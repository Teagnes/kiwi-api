package com.kiwi.doc.model.req;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteReq {
    @JsonProperty("note_name")
    private String noteName;

}
