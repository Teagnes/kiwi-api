package com.kiwi.doc.controller;


import com.kiwi.common.ResultBean;
import com.kiwi.doc.model.NoteEntity;
import com.kiwi.doc.model.req.NoteReq;
import com.kiwi.doc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @ResponseBody
    @GetMapping("/allByUser")
    public ResultBean<List<NoteEntity>>   listAllNoteByUser(){
        return  noteService.findAllByUser(1);
    }

    @ResponseBody
    @PostMapping("/createNote")
    public ResultBean<NoteEntity> createNote(@RequestBody NoteReq noteReq){
        return noteService.createNote(noteReq);
    }

}
