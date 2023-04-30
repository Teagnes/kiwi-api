package com.kiwi.rbac.repository;

import com.kiwi.rbac.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();

    UserEntity findByUsername(String userName);

    UserEntity findByUsernameAndPassword(String userName, String password);

}