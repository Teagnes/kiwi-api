package com.kiwi.doc.service;

import com.kiwi.common.ResultBean;
import com.kiwi.doc.model.DocEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocServiceTest {
    @Autowired
    DocService docService;

    @Test
    public void createDoc() {
    }

    @Test
    public void findDocByUserId() {
        ResultBean<Page<DocEntity>> docByUserId = docService.findDocByUserId(-1, 1, 10);
        System.out.println(docByUserId.getData().getSize());
    }
}