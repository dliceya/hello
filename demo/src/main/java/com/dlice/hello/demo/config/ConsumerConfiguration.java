package com.dlice.hello.demo.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/2/26 16:15
 **/
@Configuration
@EnableDubbo(scanBasePackages = "com.dlice.consume")
@PropertySource("classpath:/application.properties")
@ComponentScan(value = {"com.dlice.consume"})
public class ConsumerConfiguration {
}
