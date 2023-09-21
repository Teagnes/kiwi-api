package com.kiwi.rbac.controller;

import com.kiwi.common.ResultBean;
import com.kiwi.rbac.model.PermissionEntity;
import com.kiwi.rbac.model.req.PermissionReq;
import com.kiwi.rbac.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "权限管理")
@RestController
@RequestMapping("/v1/rbac/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @ApiOperation(value = "获取权限列表", notes = "获取权限列表")
    @GetMapping("/getPermissionList")
    @ResponseBody
    @RequiresPermissions("p_permission")
    public ResultBean<PermissionEntity> getPermissionList(){
        return permissionService.getPermissionList();
    }

    @ApiOperation(value = "创建权限", notes = "创建权限")
    @PostMapping("/createPermission")
    @ResponseBody
    @RequiresPermissions("p_permission")
    public ResultBean<PermissionEntity> createPermission(@RequestBody PermissionReq permissionReq){
        return permissionService.createPermission(permissionReq);
    }

    @ApiOperation(value = "删除权限", notes = "删除权限")
    @DeleteMapping("/deletePermission/{id}")
    @ResponseBody
    @RequiresPermissions("p_permission")
    public ResultBean<PermissionEntity> deletePermission(@PathVariable Integer id){
        return permissionService.deletePermission(id);
    }

    @ApiOperation(value = "更新权限", notes = "更新权限")
    @PutMapping("/updatePermission")
    @ResponseBody
    @RequiresPermissions("p_permission")
    public ResultBean<PermissionEntity> updatePermission(@RequestBody PermissionReq permissionReq){
        return permissionService.updatePermission(permissionReq);
    }

}
