package com.dlice.hello.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mubai
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
class TestServiceTest {

    @Autowired
    private TestService service;

    @Test
    void test1() {
        String test = service.test(4);
        System.out.println(test);
    }
}