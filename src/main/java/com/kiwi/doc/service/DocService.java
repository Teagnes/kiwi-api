package com.kiwi.doc.service;


import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.DocDao;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.req.DocReq;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
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

}
