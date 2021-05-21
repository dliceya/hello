package com.dlice.hello.aop;

import com.alibaba.fastjson.JSON;
import com.dlice.hello.aop.annotation.SqlInjectionBlocker;
import com.dlice.hello.utils.PinyinUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @author mubai
 **/
@Slf4j
@Aspect
@Component
public class SqlInjectionBlockerAOP {
    @Around(value = "@annotation(blocker)")
    public Object recordLog(ProceedingJoinPoint point, SqlInjectionBlocker blocker) throws Throwable {
        String[] checkField = blocker.value();

        Object[] args = point.getArgs();

        if (checkField.length > 0) {

        } else {
            boolean b = Arrays.stream(args).allMatch(str -> JSON.toJSONString(str).contains(";"));
        }

        for (Object arg : args) {
            log.info(JSON.toJSONString(arg));
        }

        return point.proceed();
    }

    public static void main(String[] args) {
        String w = PinyinUtil.convertFirstPinyinChar("给我一个");

        System.out.println(w + "121");
    }
}
