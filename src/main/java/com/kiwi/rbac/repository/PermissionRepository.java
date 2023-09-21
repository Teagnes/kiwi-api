package com.kiwi.rbac.repository;

import com.kiwi.rbac.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {

    PermissionEntity findByName(String name);

    List<PermissionEntity> findAllByIdIn(List<Integer> ids);

}
