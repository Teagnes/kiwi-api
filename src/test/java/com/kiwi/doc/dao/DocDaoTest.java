package com.kiwi.doc.dao;

import com.kiwi.doc.model.DocEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocDaoTest {
    @Autowired
    DocDao docDao;

    @Test
    public void findAllByUserId() {
    }

    @Test
    public void findDocEntitiesByDocUuid() {
    }

    @Test
    public void findDocEntitiesByNote() {
        List<DocEntity> docEntitiesByNote = docDao.findDocEntitiesByNote(1);
        int size = docEntitiesByNote.size();
        System.out.println(size);

    }
}