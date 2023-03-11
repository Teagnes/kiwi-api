package com.kiwi.doc.dao;

import com.kiwi.doc.model.DocEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocDao extends JpaRepository<DocEntity ,Integer> {


}
