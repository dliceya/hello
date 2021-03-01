package com.dlice.hello.service.impl;

import com.dlice.hello.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/2/25 19:29
 **/
@Service(version = "${yanpu.service.version}", group = "${yanpu.service.group}", timeout = 5999)
public class UserServiceImpl implements UserService {
    @Override
    public String getStringTest(Integer param) {
        if (param.equals(1)) {
            return "hello";
        }
        else {
            return "world";
        }
    }
}
