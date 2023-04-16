package com.kiwi.rbac.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "role_relation", schema = "kiwi", catalog = "")
public class RoleRelationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "parent_role_id")
    private Integer parentRoleId;
    @Basic
    @Column(name = "child_role_id")
    private Integer childRoleId;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParentRoleId() {
        return parentRoleId;
    }

    public void setParentRoleId(Integer parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    public Integer getChildRoleId() {
        return childRoleId;
    }

    public void setChildRoleId(Integer childRoleId) {
        this.childRoleId = childRoleId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRelationEntity that = (RoleRelationEntity) o;
        return id == that.id && Objects.equals(parentRoleId, that.parentRoleId) && Objects.equals(childRoleId, that.childRoleId) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentRoleId, childRoleId, createTime, updateTime);
    }
}
