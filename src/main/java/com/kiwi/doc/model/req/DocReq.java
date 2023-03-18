package com.kiwi.doc.model.req;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocReq {


    private String docName;

    private String docUuid;

    private String content;


}
