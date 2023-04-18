package com.kiwi.doc.dao;

import com.kiwi.doc.model.DocEntity;
import com.kiwi.doc.model.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao   extends JpaRepository<NoteEntity,Integer> {

    List<NoteEntity> findAllByCreateUserIdOrderByCreateTimeDesc(Integer userid);

    NoteEntity findByCreateUserIdAndNoteName(Integer createUserId,String noteName);

    @Query(value = "SELECT n.id ,n.create_user_id ,n.note_name ,n.note_uuid ,n.note_uuid ,n.create_time ,n.update_time   from note n  \n" +
            "left  join note_doc nd   on n.id =nd.note_id  where nd.doc_id =?2  and n.create_user_id =?1" ,nativeQuery = true)
    NoteEntity findNoteEntityByCreateUserIdAndDocId(Integer createUserId,Integer docID);
}
