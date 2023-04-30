package com.kiwi.rbac.service;

import com.kiwi.common.ResultBean;
import com.kiwi.common.ResultEnum;
import com.kiwi.common.ResultUtil;
import com.kiwi.rbac.model.PermissionEntity;
import com.kiwi.rbac.model.req.PermissionReq;
import com.kiwi.rbac.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public ResultBean createPermission(PermissionReq permissionReq){
        PermissionEntity permission = permissionRepository.findByName(permissionReq.getPermissionName());
        if(permission != null){
            return ResultUtil.fail(ResultEnum.PERMISSION_EXIST);
        }
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setName(permissionReq.getPermissionName());
        permissionEntity.setDescription(permissionReq.getPermissionDesc());
        PermissionEntity save = permissionRepository.save(permissionEntity);
        return ResultUtil.success(save);
    }

    public ResultBean deletePermission(Integer id){
        PermissionEntity permission = permissionRepository.findById(id).orElse(null);
        if(permission == null){
            return ResultUtil.fail(ResultEnum.PERMISSION_NOT_EXIST);
        }
        permissionRepository.delete(permission);
        return ResultUtil.success(permission);
    }

    public ResultBean updatePermission(PermissionReq permissionReq){
        PermissionEntity permission = permissionRepository.findById(permissionReq.getPermissionId()).orElse(null);
        if(permission == null){
            return ResultUtil.fail(ResultEnum.PERMISSION_NOT_EXIST);
        }
        permission.setName(permissionReq.getPermissionName());
        permission.setDescription(permissionReq.getPermissionDesc());
        PermissionEntity save = permissionRepository.save(permission);
        return ResultUtil.success(save);
    }

    public ResultBean getPermissionList(){
        return ResultUtil.success(permissionRepository.findAll());
    }



}
