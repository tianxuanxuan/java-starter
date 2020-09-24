package com.xgit.starter.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by tianxuanxuan
 * On 2020-09-24 08:59
 */
@Configuration
@Aspect
@Slf4j
public class AOPConfig {
    //凡是带有该类型注解的方法被调用时都被执行@Around注解的方法
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simpleAop(final ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        log.info("args:" + Arrays.asList(args));
        //调用原有的方法
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("return:" + o);
        return o;
    }
}
