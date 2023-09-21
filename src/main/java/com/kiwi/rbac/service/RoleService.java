package com.kiwi.rbac.service;

import com.kiwi.common.ResultBean;
import com.kiwi.common.ResultEnum;
import com.kiwi.common.ResultUtil;
import com.kiwi.rbac.model.PermissionEntity;
import com.kiwi.rbac.model.RoleEntity;
import com.kiwi.rbac.model.req.RoleReq;
import com.kiwi.rbac.repository.PermissionRepository;
import com.kiwi.rbac.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PermissionRepository permissionRepository;


    public ResultBean getRoleList(){
        List<RoleEntity> all = roleRepository.findAll();
        return ResultUtil.success(all);
    }

//    createRole
    public ResultBean createRole(RoleReq roleReq){
        RoleEntity role = roleRepository.findByName(roleReq.getRoleName());
        if(role != null){
            return ResultUtil.fail(ResultEnum.ROLE_EXIST);
        }
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(roleReq.getRoleName());
        roleEntity.setDescription(roleReq.getRoleDesc());

        List<PermissionEntity> allByIdIn = permissionRepository.findAllByIdIn(roleReq.getPermissionIds());
        roleEntity.setPermissions(new HashSet<>(allByIdIn));
        RoleEntity save = roleRepository.save(roleEntity);
        return ResultUtil.success(save);
    }

//    deleteRole
    public ResultBean deleteRole(Integer id){
        RoleEntity role = roleRepository.findById(id).orElse(null);
        if(role == null){
            return ResultUtil.fail(ResultEnum.ROLE_NOT_EXIST);
        }
        roleRepository.delete(role);
        return ResultUtil.success(role);
    }

    public ResultBean updateRole(RoleReq roleReq){
        RoleEntity role = roleRepository.findById(roleReq.getRoleId()).orElse(null);
        if(role == null){
            return ResultUtil.fail(ResultEnum.ROLE_NOT_EXIST);
        }
        role.setName(roleReq.getRoleName());
        role.setDescription(roleReq.getRoleDesc());
        List<PermissionEntity> allByIdIn = permissionRepository.findAllByIdIn(roleReq.getPermissionIds());
        role.setPermissions(new HashSet<>(allByIdIn));
        RoleEntity save = roleRepository.save(role);
        return ResultUtil.success(save);
    }

}
