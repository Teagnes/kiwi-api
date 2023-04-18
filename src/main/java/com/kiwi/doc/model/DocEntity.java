package com.kiwi.doc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "doc", schema = "kiwi", catalog = "")
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class DocEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private Integer userId;
    @Basic
    @Column(name = "doc_name")
    @JsonProperty("doc_name")
    private String docName;
    @Basic
    @Column(name = "doc_uuid")
    @JsonProperty("doc_uuid")
    private String docUuid;

    @Basic
    @Column(name = "version_uuid")
    @JsonProperty("version_uuid")
    private String versionUuid;
    @Basic
    @Column(name = "create_time" )
    @JsonProperty("create_title")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    private Timestamp createTime;
    @Basic
    @Column(name = "update_time" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    @JsonProperty("update_time")
    private Timestamp updateTime;

    @Transient // 非数据库字段，在映射时忽略
    @JsonProperty("doc_content")
    private  String  docContent;

    @Transient // 非数据库字段，在映射时忽略
    @JsonProperty("note_name")
    private String noteName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocEntity docEntity = (DocEntity) o;
        return id == docEntity.id && Objects.equals(userId, docEntity.userId) && Objects.equals(docName, docEntity.docName) && Objects.equals(docUuid, docEntity.docUuid) && Objects.equals(createTime, docEntity.createTime) && Objects.equals(updateTime, docEntity.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, docName, docUuid, createTime, updateTime);
    }
}
