package com.dlice.hello.controller;

import com.dlice.hello.biz.member.HelloUserBiz;
import com.dlice.hello.domain.member.HelloUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2020/9/3 21:45
 * @Author: dlice
 */
@RestController
@RequestMapping("/ucenter")
public class UCenterController {

    @Autowired
    private HelloUserBiz helloUserBiz;

    @GetMapping("get")
    public HelloUser getUserInfoByName(@RequestParam @NonNull String username) {
        return helloUserBiz.getByUserName(username);
    }

    @GetMapping("list")
    public List<HelloUser> listAllUser() {

        return helloUserBiz.listUser();
    }

}
