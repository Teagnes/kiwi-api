package com.kiwi.rbac.controller;


import com.kiwi.common.ResultBean;
import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.req.UserReq;
import com.kiwi.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/rbac")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/createUser")

    public ResultBean<UserEntity> createUser(@RequestBody UserReq userReq){
        return userService.createUser(userReq);
    }


}
