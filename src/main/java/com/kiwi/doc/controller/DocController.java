package com.kiwi.doc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kiwi.common.ResultBean;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.req.DocReq;
import com.kiwi.doc.model.req.PageReq;
import com.kiwi.doc.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @ResponseBody
    @PostMapping("/findAllDoc")
    public ResultBean<Page<DocEntity>>  findAllDoc(@RequestBody PageReq pageReq){
        return  docService.findDocByUserId(-1,pageReq.getPage(), pageReq.getSize());
    }


    @ResponseBody
    @PostMapping("/updateDoc")
    public ResultBean<DocEntity>  updateDoc(@RequestBody DocReq docReq) throws JsonProcessingException {
        return  docService.updateDoc(docReq);
    }

}
