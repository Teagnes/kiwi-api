package com.kiwi.doc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer userId;
    @Basic
    @Column(name = "doc_name")
    private String docName;
    @Basic
    @Column(name = "doc_uuid")
    private String docUuid;
    @Basic
    @Column(name = "create_time" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")

    private Timestamp createTime;
    @Basic
    @Column(name = "update_time" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    private Timestamp updateTime;


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
