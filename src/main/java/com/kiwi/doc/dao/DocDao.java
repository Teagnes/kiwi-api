package com.kiwi.doc.dao;

import com.kiwi.doc.model.DocEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DocDao extends JpaRepository<DocEntity ,Integer> {

    Page<DocEntity> findAllByUserId(Integer userId, Pageable pageable);

    DocEntity findDocEntitiesByDocUuid(String uuid);


}
