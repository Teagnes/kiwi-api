package com.kiwi.doc.controller;


import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.DocDao;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.req.DocReq;
import com.kiwi.doc.service.DocService;
import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/doc")
public class DocController {

    @Autowired
    DocService docService;


    @ResponseBody
    @PostMapping("/createDoc")

    public ResultBean<DocEntity> createDoc(@RequestBody DocReq docReq){
        return docService.createDoc(docReq);
    }

}
