package com.dlice.hello.aop.annotation;

import java.lang.annotation.*;

/**
 * desc 自定义日志记录
 *
 * @Auth dlice
 * @Date 2020/9/24
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface AutoLogger {

    LoggerType value() default LoggerType.All;
    String description() default "";

    enum LoggerType{
        /**
         * 记录请求参数
         */
        Request,
        /**
         * 记录返回值
         */
        Response,
        /**
         * 记录所有信息
         */
        All
    }
}
