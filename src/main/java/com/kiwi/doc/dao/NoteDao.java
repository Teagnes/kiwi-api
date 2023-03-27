package com.kiwi.doc.dao;

import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao   extends JpaRepository<NoteEntity,Integer> {

    List<NoteEntity> findAllByCreateUserIdOrderByCreateTimeDesc(Integer userid);

    NoteEntity findByCreateUserIdAndNoteName(Integer createUserId,String noteName);
}
