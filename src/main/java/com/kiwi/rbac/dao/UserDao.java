package com.kiwi.rbac.dao;

import com.kiwi.rbac.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();

    UserEntity findByUsername(String userName);

}
