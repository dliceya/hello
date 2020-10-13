package com.dlice.hello.controller;

import com.dlice.hello.api.app.UCenterControllerApi;
import com.dlice.hello.model.user.entity.HelloUser;
import com.dlice.hello.repository.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/9/3 21:45
 * @Author: dlice
 */
@RestController
@RequestMapping("/ucenter")
public class UCenterController implements UCenterControllerApi {

    private final UserRepository userRepository;
    public UCenterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @GetMapping("get")
    public HelloUser getUserInfoByName(@RequestParam @NonNull String username) {
        return userRepository.getByUsername("dlice");
    }

}
