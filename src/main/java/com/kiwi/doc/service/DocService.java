package com.kiwi.doc.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.DocDao;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.req.DocReq;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.print.Doc;
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

    @Value("${es.host}")
    private String esHost;

    @Value("${es.port}")
    private String esPort;

    @Value("${es.docIndex}")
    private String docIndex;




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

    public ResultBean<DocEntity> updateDoc(DocReq docReq) throws JsonProcessingException {
        String esDocId = UUID.randomUUID().toString();
        DocEntity docEntity = docDao.findDocEntitiesByDocUuid(docReq.getDocUuid());
        docEntity.setDocName(docReq.getDocName());
        docEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        docEntity.setDocUuid(docReq.getDocUuid());
        docEntity.setVersionUuid(esDocId);
        docDao.saveAndFlush(docEntity);
        String s = om.writeValueAsString(docEntity);
        send2es(s);
        return  new ResultBean<>(docEntity);
    }


    public void  send2es(String docJsonString){
        String url = String.format("http://%s:%s/%s",esHost,esPort,docIndex);
        HttpRequest httpRequest = HttpRequest.put(url).acceptJson();
        httpRequest.header("content-type","application/json; charset=UTF-8");
        httpRequest.send(docJsonString);
        int code = httpRequest.code();
        String body = httpRequest.body();
        System.out.println(body);


    }


}
