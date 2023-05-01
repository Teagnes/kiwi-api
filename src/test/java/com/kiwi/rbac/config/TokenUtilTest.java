package com.kiwi.rbac.config;

import com.kiwi.rbac.model.req.LoginReq;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenUtilTest {

    @Test
    public void createToken() {




    }

    @Test
    public void verifyToken() {
        LoginReq loginReq = new LoginReq();
        loginReq.setUsername("123");
        loginReq.setPassword("123");
        String sign = TokenUtil.sign(loginReq.getUsername(), loginReq.getPassword(), 1000L);
        Boolean verify = TokenUtil.verify(sign);
        assertEquals("token check",true,verify);

    }
}