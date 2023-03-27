package com.kiwi.doc.dao;

import com.kiwi.doc.model.DocEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DocDao extends JpaRepository<DocEntity ,Integer> {

    Page<DocEntity> findAllByUserId(Integer userId, Pageable pageable);

    DocEntity findDocEntitiesByDocUuid(String uuid);

    @Query(value = "select d.id,d.user_id,d.doc_name ,d.create_time ,d.update_time ,d.doc_uuid ,d.version_uuid from  note_doc n left join  doc d on n.doc_id= d.id where n.note_id=?1 order by d.update_time desc " ,nativeQuery = true)
    List<DocEntity>  findDocEntitiesByNote( Integer noteID);

    void removeByDocUuid(String docUuid);


}
