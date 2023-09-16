package com.kiwi.rbac.controller;


import com.kiwi.common.ResultBean;
import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.req.UserReq;
import com.kiwi.rbac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户管理", tags = "用户接口")
@RestController
@RequestMapping("/v1/rbac/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ResponseBody
    @PostMapping("/createUser")
    @RequiresPermissions("p_user")
    public ResultBean<UserEntity> createUser(@RequestBody UserReq userReq){
        return userService.register(userReq);
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ResultBean<UserEntity> getTokenInfo(@RequestHeader String xToken){
        return userService.getUserInfo(xToken);
    }


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ResponseBody
    @GetMapping("/getUserInfo/{userName}")
    @RequiresPermissions("p_user")
    public ResultBean<UserEntity> getUserInfo(@PathVariable String userName){
        return userService.getUserInfo(userName);
    }


    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ResponseBody
    @PutMapping("/updateUser")
    @RequiresPermissions("p_user")
    public ResultBean<UserEntity> updateUser(@RequestBody UserReq userReq){
        return userService.updateUser(userReq);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ResponseBody
    @DeleteMapping("/deleteUser/{userName}")
    @RequiresPermissions("p_user")
    public ResultBean<UserEntity> deleteUser(@PathVariable String userName){
        return userService.deleteUser(userName);
    }

}
