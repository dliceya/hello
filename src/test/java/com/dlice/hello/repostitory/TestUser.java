package com.dlice.hello.repostitory;

import com.dlice.hello.model.role.entity.Role;
import com.dlice.hello.repository.RoleRepository;
import com.dlice.hello.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Date: 2020/9/3 22:20
 * @Author: dlice
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUser {

    @Resource
    UserRepository userRepository;

    @Resource
    RoleRepository roleRepository;

    @Test
    public void testAddUser(){
    }

    @Test
    public void testGet(){

        for (Role role : roleRepository.findAll()) {
            System.out.println(role);
        }
    }
}
