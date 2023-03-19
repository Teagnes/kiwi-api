package com.kiwi.doc.service;


import com.kiwi.common.ResultBean;
import com.kiwi.doc.dao.NoteDao;
import com.kiwi.doc.model.NoteEntity;
import com.kiwi.doc.model.req.NoteReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class NoteService {

    @Autowired
    NoteDao noteDao;

    public ResultBean<List<NoteEntity>>  findAllByUser(Integer userId){
        return new ResultBean<>(noteDao.findAllByCreateUserIdOrderByCreateTimeDesc(userId));
    }

    public ResultBean<NoteEntity> createNote(NoteReq noteReq){
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setNoteUuid(UUID.randomUUID().toString());
        noteEntity.setCreateUserId(1);
        noteEntity.setNoteName(noteReq.getNoteName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        noteEntity.setCreateTime(timestamp);
        noteEntity.setUpdateTime(timestamp);
        return  new ResultBean<>(noteDao.save(noteEntity));

    }





}
