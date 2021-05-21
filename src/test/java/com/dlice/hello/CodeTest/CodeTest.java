package com.dlice.hello.CodeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CodeTest {

    @Test
    public void testDataTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
