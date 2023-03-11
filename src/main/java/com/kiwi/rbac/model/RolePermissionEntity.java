package com.kiwi.rbac.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "role_permission", schema = "kiwi", catalog = "")
@Getter
@Setter
public class RolePermissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "role_id")
    private Integer roleId;
    @Basic
    @Column(name = "permission_id")
    private Integer permissionId;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermissionEntity that = (RolePermissionEntity) o;
        return id == that.id && Objects.equals(roleId, that.roleId) && Objects.equals(permissionId, that.permissionId) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, permissionId, createTime, updateTime);
    }
}
