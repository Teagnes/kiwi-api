package com.kiwi.rbac.dao;

import com.kiwi.rbac.model.RoleEntity;
import com.kiwi.rbac.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void findAll() {
    }

    @Test
    public void findUserById() {
        Optional<UserEntity> byId = userDao.findById(1);
        UserEntity userEntity = byId.get();
        userEntity.setPassword("5777777");
//        userDao.flush();
        userDao.saveAndFlush(userEntity);
//        List<RoleEntity> roles = userEntity.getRoles();
//        RoleEntity remove = roles.remove(1);
//        userEntity(roles);
//        userDao.save(userEntity);
        System.out.println(userEntity);
//        userDao.

    }
}