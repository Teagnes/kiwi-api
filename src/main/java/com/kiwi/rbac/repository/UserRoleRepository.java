package com.kiwi.rbac.dao;

import com.kiwi.rbac.model.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao  extends JpaRepository<UserRoleEntity, Integer> {



}
