package com.kiwi.doc.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DocContent {

    private String content;

    private String docUuid;

    private String versionUuid;

    private Date createDate;

    private Date updateDate;

//    private Date
}
