package com.kiwi.rbac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user", schema = "kiwi", catalog = "")
@Getter
@Setter
public class UserEntity {
    public UserEntity() {
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主键使用数据库自增长策略
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "usercname")
    private String usercname;
    @Basic
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

    @JsonIgnore
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;


    @ManyToMany( targetEntity = RoleEntity.class, cascade = CascadeType.MERGE , fetch =  FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) // 通过中间表user_role来映射
    @OrderBy("id ASC")
    private Set<RoleEntity> roles;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(usercname, that.usercname) && Objects.equals(password, that.password) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, usercname, password, createTime, updateTime);
    }
}
