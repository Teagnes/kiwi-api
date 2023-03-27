package com.kiwi.doc.dao;

import com.kiwi.doc.model.NoteDocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteDocDao extends JpaRepository<NoteDocEntity,Integer> {

    void deleteByDocId(Integer docid );
}
