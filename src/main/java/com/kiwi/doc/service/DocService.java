package com.kiwi.doc.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.DocDao;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.req.DocReq;
import io.swagger.models.auth.In;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocService {

    @Autowired
    DocDao docDao;

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

    public ResultBean<DocEntity> createDoc(DocReq docReq){
        DocEntity docEntity = new DocEntity();
        String uuid = UUID.randomUUID().toString();
        docEntity.setDocName(docReq.getDocName());
        docEntity.setDocUuid(uuid);
        docEntity.setUserId(-1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        docEntity.setCreateTime(timestamp);
        docEntity.setUpdateTime(timestamp);
        DocEntity save = docDao.saveAndFlush(docEntity);
        return new ResultBean<>(save);

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


}
