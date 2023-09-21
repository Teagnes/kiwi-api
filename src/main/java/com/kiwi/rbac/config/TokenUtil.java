package com.kiwi.rbac.config;

import com.kiwi.rbac.model.req.LoginReq;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;

/**
 *  jwt token 工具类
 */

public class TokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);


    //密钥盐
    private static final String TOKEN_SECRET="xxxx12345";

    /**
     * 创建一个token
     * @param loginReq
     * @return
     */
    public static String sign(String username ,String  password,Long expireTimeMillis){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+expireTimeMillis);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    //存放数据
                    .withClaim("username",username)
                    .withClaim("password",password)
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException|JWTCreationException je) {

        }
        return token;
    }
    /**
     * 对token进行验证
     * @param token
     * @return
     */
    public static Boolean verify(String token){
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            logger.info("认证通过：");
            logger.info("username: " + TokenUtil.getUserName(token));
            logger.info("过期时间：    " + decodedJWT.getExpiresAt());
        return true;
    }

    /**
     * 获取用户名
     */
    public static String getUserName(String token){
        try{
            DecodedJWT jwt=JWT.decode(token);
            return  jwt.getClaim("username").asString().toLowerCase();
        }catch (JWTDecodeException e)
        {
            return null;
        }
    }



}
