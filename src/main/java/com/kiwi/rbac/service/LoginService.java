package com.kiwi.rbac.service;


import com.kiwi.common.ResultBean;
import com.kiwi.rbac.config.TokenUtil;
import com.kiwi.rbac.model.res.UserInfoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LoginService {

    @Autowired
    UserService userService;

    public ResultBean<UserInfoRes> login(String username, String password){
        String sign = TokenUtil.sign(username, password);
        UserInfoRes userInfoRes = new UserInfoRes();
        userInfoRes.setToken(sign);
        return new ResultBean<>(userInfoRes);
    }


}
