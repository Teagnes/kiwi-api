package com.kiwi.rbac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role", schema = "kiwi", catalog = "")
@Getter
@Setter
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public RoleEntity() {
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

    @JsonIgnore
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;


    @ManyToMany(targetEntity = PermissionEntity.class, cascade = CascadeType.MERGE , fetch =  FetchType.EAGER)
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")) // 通过中间表user_role来映射
    @OrderBy("id ASC")
    private Set<PermissionEntity> permissions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createTime, updateTime);
    }
}
