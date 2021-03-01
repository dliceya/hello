package com.dlice.hello.aop;

import cn.hutool.core.date.StopWatch;
import com.alibaba.fastjson.JSON;
import com.dlice.hello.aop.annotation.AutoLogger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * desc 记录方法返回值和执行时间
 *
 * @Auth dlice
 * @Date 2020/11/17
 **/
@Slf4j
@Aspect
@Component
public class AutoLoggerAOP {

    @Around(value = "@annotation(logger)")
    public Object recordLog(ProceedingJoinPoint point, AutoLogger logger) throws Throwable {
        StopWatch clock = new StopWatch();
        StringBuilder sb = new StringBuilder("Method: " + point.toShortString());

        if (!AutoLogger.LoggerType.Response.equals(logger.value())){

            Map<String, Object> argsMap = new HashMap<>();
            Object[] args = point.getArgs();
            MethodSignature signature = (MethodSignature) point.getSignature();
            Class<?>[] parameterTypes = signature.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {
                argsMap.put(parameterTypes[i].getSimpleName(), args[i]);
            }

            sb.append(", Args: ").append(JSON.toJSONString(argsMap));
        }

        clock.start();
        Object result = point.proceed();
        clock.stop();

        if (!AutoLogger.LoggerType.Request.equals(logger.value())){
            sb.append(", Result: ").append(JSON.toJSON(result));
        }

        long time = clock.getTotalTimeMillis();

        String timeMessage =  "ExecuteTime：" + time + "ms" + ", Desc: " + logger.description() + ", ";
        sb.insert(0, timeMessage);

        if (time > 500) {
            log.error(sb.toString());
        } else if(time > 100){
            log.warn(sb.toString());
        } else
            log.info(sb.toString());
        return result;
    }


}
