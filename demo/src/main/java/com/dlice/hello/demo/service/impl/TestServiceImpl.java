package com.dlice.hello.demo.service.impl;

import com.dlice.hello.demo.service.TestService;
import com.dlice.hello.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/2/26 14:59
 **/
@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private UserService userService;

    @Override
    public String test(Integer param) {
        return userService.getStringTest(param);
    }
}
