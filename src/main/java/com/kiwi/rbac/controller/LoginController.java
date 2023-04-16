package com.kiwi.rbac.controller;

import com.kiwi.common.ResultBean;
import com.kiwi.rbac.model.req.LoginReq;
import com.kiwi.rbac.model.req.UserReq;
import com.kiwi.rbac.model.res.UserInfoRes;
import com.kiwi.rbac.service.LoginService;
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
    LoginService loginService;

    @PostMapping("/login")
    public ResultBean<UserInfoRes> login(@RequestBody LoginReq loginReq){
        ResultBean<UserInfoRes> userInfo = loginService.login(loginReq.getUsername(), loginReq.getPassword());
        return userInfo;
    }






}
