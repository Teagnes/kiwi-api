package com.kiwi.rbac.controller;

import com.kiwi.common.ResultBean;
import com.kiwi.rbac.model.req.LoginReq;
import com.kiwi.rbac.model.res.UserInfoRes;
import com.kiwi.rbac.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 */


@RestController
@RequestMapping("/v1")
@Log
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultBean<UserInfoRes> login(@RequestBody LoginReq loginReq){
        ResultBean<UserInfoRes> userInfo = userService.login(loginReq.getUsername(), loginReq.getPassword());
        return userInfo;
    }


    @GetMapping("/token/{token}")
    public ResultBean<UserInfoRes> token(@PathVariable String token){
        ResultBean<UserInfoRes> userInfo = userService.verifyToken(token);
        return userInfo;
    }

}
