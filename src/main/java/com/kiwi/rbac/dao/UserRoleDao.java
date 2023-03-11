package com.kiwi.rbac.dao;

import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao  extends JpaRepository<UserRoleEntity, Integer> {



}
