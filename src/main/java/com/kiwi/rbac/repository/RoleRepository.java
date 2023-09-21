package com.kiwi.rbac.repository;

import com.kiwi.rbac.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);




}
