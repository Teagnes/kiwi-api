package com.kiwi.rbac.service;


import com.kiwi.common.ResultBean;
import com.kiwi.rbac.config.TokenUtil;
import com.kiwi.rbac.exception.RbacException;
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

    public ResultBean<UserInfoRes> verifyToken(String token){
        Boolean verify = TokenUtil.verify(token);
        if(verify){
            return new ResultBean<>(new UserInfoRes());
        }else{
            throw new RbacException("401","token error");
        }
    }


}
