package com.kiwi.rbac.service;

import com.kiwi.common.ResultBean;
import com.kiwi.common.ResultEnum;
import com.kiwi.common.ResultUtil;
import com.kiwi.rbac.config.TokenUtil;
import com.kiwi.rbac.exception.RbacException;
import com.kiwi.rbac.model.RoleEntity;
import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.req.UserReq;
import com.kiwi.rbac.model.res.UserInfoRes;
import com.kiwi.rbac.repository.RoleRepository;
import com.kiwi.rbac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${jwt.expireTimeMillis}")
    private Long expireTimeMillis;



    public UserEntity getUserByToken(String xToken){
        String userName = TokenUtil.getUserName(xToken);
        UserEntity user = userRepository.findByUsername(userName);
        return user;
    }

    public ResultBean<UserEntity> getUserInfo(String userName){
        UserEntity user = userRepository.findByUsername(userName);
        if(user == null){
            return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
        }else{
            return ResultUtil.success(user);
        }
    }

    public ResultBean<UserInfoRes> login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username.toLowerCase());
        if (user == null) {
            return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
        } else if (!user.getPassword().equals(password)) {
            return ResultUtil.fail(ResultEnum.PASSWORD_ERROR);
        } else {
            String sign = TokenUtil.sign(username, password ,expireTimeMillis);
            UserInfoRes userInfoRes = new UserInfoRes(user, sign);
            return ResultUtil.success(userInfoRes);
        }
    }

    public ResultBean<UserEntity> register(UserReq userReq) {
        UserEntity user = userRepository.findByUsername(userReq.getUserName());
        if (user != null) {
            return ResultUtil.fail(ResultEnum.USER_EXIST);
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userReq.getUserName());
            userEntity.setPassword(userReq.getUserCname());
            userEntity.setUsercname(userReq.getUserCname());
            Set<RoleEntity> roleSet = userReq.getRoles().stream().map(
                    roleId -> {
                        RoleEntity role = roleRepository.findById(roleId).get();
                        return role;
                    }
            ).collect(Collectors.toSet());
            userEntity.setRoles(roleSet);
            userRepository.save(userEntity); // 用户角色信息
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


    public ResultBean<UserEntity> updateUser(UserReq userReq){
        UserEntity user = userRepository.findByUsername(userReq.getUserName());
        if(user == null){
            return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
        }else{
            user.setUsercname(userReq.getUserCname());
            user.setPassword(userReq.getPwd());
            user.setUsername(userReq.getUserName());
            userRepository.save(user);
            return ResultUtil.success(user);
        }
    }


    public ResultBean deleteUser(String userName){
        UserEntity user = userRepository.findByUsername(userName);
        if(user == null){
            return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
        }else{
            userRepository.delete(user);
            return ResultUtil.success(user);
        }



    }

}