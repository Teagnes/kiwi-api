package com.kiwi.rbac.controller;

import com.kiwi.common.ResultBean;
import com.kiwi.rbac.model.RoleEntity;
import com.kiwi.rbac.model.req.RoleReq;
import com.kiwi.rbac.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/v1/rbac/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @ApiOperation(value = "创建角色", notes = "创建角色")
    @PostMapping("/createRole")
    @ResponseBody
    @RequiresPermissions("role")
    public ResultBean<RoleEntity> createRole(@RequestBody RoleReq roleReq){
        return roleService.createRole(roleReq);
    }


    @ApiOperation(value = "删除角色", notes = "删除角色")
    @DeleteMapping("/deleteRole/{id}")
    @ResponseBody
    @RequiresPermissions("role")
    public ResultBean<RoleEntity> deleteRole(@PathVariable Integer id){
        return roleService.deleteRole(id);
    }

    @ApiOperation(value = "更新角色", notes = "更新角色")
    @PutMapping("/updateRole")
    @ResponseBody
    @RequiresPermissions("role")
    public ResultBean<RoleEntity> updateRole(@RequestBody RoleReq roleReq){
        return roleService.updateRole(roleReq);
    }

    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    @GetMapping("/getRoleList")
    @ResponseBody
    @RequiresPermissions("role")
    public ResultBean<RoleEntity> getRoleList(){
        return roleService.getRoleList();
    }


}
