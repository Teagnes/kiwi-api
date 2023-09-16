package com.kiwi.rbac.service;

import com.kiwi.common.ResultBean;
import com.kiwi.rbac.repository.UserRepository;
import com.kiwi.rbac.repository.UserRoleRepository;
import com.kiwi.rbac.model.UserEntity;
import com.kiwi.rbac.model.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepository userDao;

    @Autowired
    UserRoleRepository userRoleDao;


    public ResultBean<UserEntity> createUser(UserReq userReq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsercname(userReq.getUserCname());
        userEntity.setUsername(userReq.getUserName());
        userEntity.setPassword(userReq.getPwd());
        UserEntity userEntitiesByUserName = userDao.findByUsername(userReq.getUserName());
        if (userEntitiesByUserName != null) {

        } else {

            userDao.save(userEntity);
//            userReq
//            userRoleDao.saveAll()
        }

        return new ResultBean<>(userEntitiesByUserName);


    }

}