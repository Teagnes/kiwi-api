package com.kiwi.doc.controller;


import com.kiwi.common.ResultBean;
import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.HighLightDocEntity;
import com.kiwi.doc.model.req.DocReq;
import com.kiwi.doc.model.req.NewDocReq;
import com.kiwi.doc.model.req.PageReq;
import com.kiwi.doc.model.req.SearchReq;
import com.kiwi.doc.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/doc")
public class DocController {

    @Autowired
    DocService docService;

    @ResponseBody
    @GetMapping("/{docId}")
    public ResultBean<DocEntity> getDoc(@PathVariable String docId) throws IOException {
        return  docService.getDocByDocId(docId);

    }


    @ResponseBody
    @PostMapping("/createDoc")

    public ResultBean<DocEntity> createDoc(@RequestBody NewDocReq newDocReq) throws IOException {
        return docService.createDoc(newDocReq);
    }


    @PostMapping("/findAllDoc")
    public ResultBean<Page<DocEntity>>  findAllDoc(@RequestBody PageReq pageReq){
        return  docService.findDocByUserId(-1,pageReq.getPage(), pageReq.getSize());
    }



    @PostMapping("/updateDoc")
    public ResultBean<DocEntity>  updateDoc(@RequestBody DocReq docReq) throws IOException {
        return  docService.updateDoc(docReq);
    }

    @GetMapping("/findAllDocsByNote/{noteId}")
    public  ResultBean<List<DocEntity>> findAllDocsByNote(@PathVariable Integer noteId){
        return  docService.findDocsByNote(noteId);

    }

    @DeleteMapping("/{docUUid}")
    public ResultBean<DocEntity> deleteDoc(@PathVariable String docUUid){
        return  docService.delDoc(docUUid);
    }

    @PostMapping("/search")
    public ResultBean<List<HighLightDocEntity>> searchDoc(@RequestBody SearchReq searchReq) throws IOException {
        return  docService.searchDoc(searchReq);
    }

}
