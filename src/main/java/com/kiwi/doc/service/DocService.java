package com.kiwi.doc.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.DocDao;
import com.kiwi.doc.dao.NoteDao;
import com.kiwi.doc.dao.NoteDocDao;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.HighLightDocEntity;
import com.kiwi.doc.model.NoteDocEntity;
import com.kiwi.doc.model.NoteEntity;
import com.kiwi.doc.model.req.DocReq;
import com.kiwi.doc.model.req.NewDocReq;
import com.kiwi.doc.model.req.SearchReq;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocService {

    @Autowired
    DocDao docDao;

    @Autowired
    NoteDao noteDao;

    @Autowired
    NoteDocDao noteDocDao;

    @Autowired
    ObjectMapper om ;

    @Autowired
    RestHighLevelClient esClient;

    @Value("${es.docIndex}")
    private String docIndex;

    @Value("${es.docIndex}-his")
    private String docIndexHis;



    public ResultBean<DocEntity> getDocByDocId(String docId) throws IOException {
        DocEntity docEntity = getDocByID(docIndex, docId);
        return new ResultBean<>(docEntity);
    }

    public ResultBean<DocEntity> createDoc(NewDocReq newDocReq) throws IOException {
        NoteEntity noteEntity = createNewNoteIfNoteE(newDocReq.getNoteName());
        DocEntity newDoc = createNewDoc(newDocReq.getDocName());
        send2es(docIndex,om.writeValueAsString(newDoc),newDoc.getDocUuid());
        saveNoteDoc(noteEntity,newDoc);
        return new ResultBean<>(newDoc);
    }

    public DocEntity createNewDoc(String docName){
        DocEntity docEntity = new DocEntity();
        String uuid = UUID.randomUUID().toString();
        docEntity.setDocName(docName);
        docEntity.setDocUuid(uuid);
        docEntity.setUserId(-1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        docEntity.setCreateTime(timestamp);
        docEntity.setUpdateTime(timestamp);
        docEntity.setDocContent("");
        DocEntity save = docDao.saveAndFlush(docEntity);
        return save;

    }

    public NoteEntity createNewNoteIfNoteE(String noteName){
        NoteEntity noteEntity = noteDao.findByCreateUserIdAndNoteName(1, noteName);
        if (noteEntity == null) {
            NoteEntity noteEntity1 = new NoteEntity();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            noteEntity1.setCreateTime(timestamp);
            noteEntity1.setUpdateTime(timestamp);
            noteEntity1.setNoteName(noteName);
            noteEntity1.setCreateUserId(1);
            String noteUuid = UUID.randomUUID().toString();
            noteEntity1.setNoteUuid(noteUuid);
            noteEntity = noteDao.save(noteEntity1);
        }
        return  noteEntity;
    }

    public void saveNoteDoc(NoteEntity noteEntity,DocEntity docEntity){
        int noteid = noteEntity.getId();
        int docId = docEntity.getId();
        NoteDocEntity noteDocEntity = new NoteDocEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        noteDocEntity.setCreateTime(timestamp);
        noteDocEntity.setUpdateTime(timestamp);
        noteDocEntity.setNoteId(noteid);
        noteDocEntity.setDocId(docId);
        NoteDocEntity save = noteDocDao.save(noteDocEntity);
    }



    public ResultBean<Page<DocEntity>> findDocByUserId(Integer userId, Integer page , Integer size){
        Pageable pageable = PageRequest.of(page-1,size, Sort.by("updateTime").descending());
        Page<DocEntity> DataPage = docDao.findAllByUserId(userId, pageable);
        return  new ResultBean<>(DataPage);

    }

    public ResultBean<DocEntity> updateDoc(DocReq docReq) throws IOException {
        String versionUUID = UUID.randomUUID().toString();
        DocEntity docEntity = docDao.findDocEntitiesByDocUuid(docReq.getDocUuid());
        docEntity.setDocName(docReq.getDocName());
        docEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        docEntity.setDocUuid(docReq.getDocUuid());
        docEntity.setVersionUuid(versionUUID);
        docEntity.setDocContent(docReq.getContent());
        docDao.saveAndFlush(docEntity);
        String s = om.writeValueAsString(docEntity);
        send2es(docIndex,s,docEntity.getDocUuid());
        send2es(docIndexHis,s,versionUUID);
        return  new ResultBean<>(docEntity);
    }


    public void  send2es(String index,String docJsonString,String uuid) throws IOException {
        IndexRequest source = new IndexRequest(index).id(uuid).source(docJsonString, XContentType.JSON);
        IndexResponse index1 = esClient.index(source, RequestOptions.DEFAULT);
        RestStatus status = index1.status();
    }

    public DocEntity getDocByID(String index,String uuid) throws IOException {
        GetRequest getRequest = new GetRequest(index, uuid);
        GetResponse response = esClient.get(getRequest, RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        DocEntity entity = om.readValue(sourceAsString, DocEntity.class);
        return  entity;

    }

    public ResultBean<List<DocEntity>> findDocsByNote(Integer noteId){
        return new ResultBean<>(docDao.findDocEntitiesByNote(noteId));

    }

    @Transactional
    public ResultBean<DocEntity> delDoc(String  docUuid){
        DocEntity docEntity = docDao.findDocEntitiesByDocUuid(docUuid);
        int docId = docEntity.getId();
        noteDocDao.deleteByDocId(docId);
//        DocEntity one = docDao.getOne(docId);
        docDao.removeByDocUuid(docUuid);
        return  new ResultBean<>();
    }

    public ResultBean<List<HighLightDocEntity>> searchDoc(SearchReq searchReq) throws IOException {
        SearchRequest searchRequest = new SearchRequest(docIndex);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder
                .must(new MatchQueryBuilder("user_id",-1))
                .must(new MatchQueryBuilder("doc_content",searchReq.getInputStr()));
        String s = boolQueryBuilder.toString();
        System.out.println(s);
        searchSourceBuilder.query(boolQueryBuilder);
        // high
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highlightTitle =
                new HighlightBuilder.Field("doc_content");
//        highlightTitle.highlighterType("");
        highlightBuilder.field(highlightTitle);
//        highlightBuilder.preTags("<span style=\"color:red\">");
        highlightBuilder.preTags("<span style=\"font-weight:bold;color:red\">");
        highlightBuilder.postTags("</span>");

        searchSourceBuilder.highlighter(highlightBuilder);
        SearchRequest source = searchRequest.source(searchSourceBuilder);
        SearchResponse response = esClient.search(source, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        List<HighLightDocEntity> docList = new LinkedList<>();
        for (SearchHit hit : hits) {
            String sourcestr = hit.getSourceAsString();
            HighLightDocEntity adoc = om.readValue(sourcestr, HighLightDocEntity.class);
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField docContent = highlightFields.get("doc_content");
            Text[] fragments = docContent.getFragments();
            List<String> collect = Arrays.stream(fragments).map(t -> t.toString()).collect(Collectors.toList());
            adoc.setHighLight(collect);
            docList.add(adoc);
        }
        return new ResultBean<>(docList);
    }


}
