package com.kiwi.rbac.repository;

import com.kiwi.rbac.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAll() {
    }

    @Test
    public void findByUsername() {
        userRepository.findByUsername("u_normal").getRoles().forEach( role -> {
            System.out.println(role.getName());
            role.getPermissions().forEach( permission -> {
                System.out.println(role.getName()+" | "+permission.getName());
            });
        });
    }
}