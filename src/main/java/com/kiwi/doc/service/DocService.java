package com.kiwi.doc.service;


import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.DocDao;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.req.DocReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
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
        docEntity.setId(-1);
        DocEntity save = docDao.save(docEntity);
        return new ResultBean<>(save);

    }
}
