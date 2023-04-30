package com.kiwi.rbac.service;

import com.kiwi.common.ResultBean;
import com.kiwi.common.ResultEnum;
import com.kiwi.common.ResultUtil;
import com.kiwi.rbac.config.TokenUtil;
import com.kiwi.rbac.exception.RbacException;
import com.kiwi.rbac.model.res.UserInfoRes;
import com.kiwi.rbac.repository.UserRepository;
import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public ResultBean<UserEntity> createUser(UserReq userReq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsercname(userReq.getUserCname());
        userEntity.setUsername(userReq.getUserName());
        userEntity.setPassword(userReq.getPwd());
        UserEntity userEntitiesByUserName = userRepository.findByUsername(userReq.getUserName());
        if (userEntitiesByUserName != null) {

        } else {

            userRepository.save(userEntity);
//            userReq
//            userRoleDao.saveAll()
        }
        return ResultUtil.success(userEntity);
    }

    public UserEntity getUserByToken(String xToken){
        String userName = TokenUtil.getUserName(xToken);
        UserEntity user = userRepository.findByUsername(userName);
        return user;
    }

    public ResultBean<UserEntity> getUserInfo(String xToken){
        UserEntity user = getUserByToken(xToken);
        return ResultUtil.success(user);
    }

    public ResultBean<UserInfoRes> login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username.toLowerCase());
        if (user == null) {
            return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
        } else if (!user.getPassword().equals(password)) {
            return ResultUtil.fail(ResultEnum.PASSWORD_ERROR);
        } else {
            String sign = TokenUtil.sign(username, password);
            UserInfoRes userInfoRes = new UserInfoRes(user, sign);
            return ResultUtil.success(userInfoRes);
        }
    }

    public ResultBean<UserEntity> register(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null) {
            return ResultUtil.fail(ResultEnum.USER_EXIST);
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userRepository.save(userEntity);
            return ResultUtil.success(userEntity);
        }
    }

    public ResultBean<UserInfoRes> verifyToken(String token){
        Boolean verify = TokenUtil.verify(token);
        if(verify){
            String userName = TokenUtil.getUserName(token);
            UserEntity byUsername = userRepository.findByUsername(userName);
            UserInfoRes userInfoRes = new UserInfoRes(byUsername, token);
            return new ResultUtil().success(userInfoRes);
        }else{
            throw new RbacException("401","token error");
        }


    }

}