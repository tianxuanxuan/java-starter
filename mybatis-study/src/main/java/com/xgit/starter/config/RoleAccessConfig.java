package com.xgit.starter.config;

import com.xgit.starter.exception.BizException;
import com.xgit.starter.utils.Function;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianxuanxuan
 * On 2020-09-24 09:53
 */
@Configuration
@Aspect
@Slf4j
public class RoleAccessConfig {
    @Around("@within(org.springframework.web.bind.annotation.RestController) " +
            "&& @annotation(function)")
    public Object functionAccessCheck(final ProceedingJoinPoint pjp, Function function) throws Throwable {
        //功能增强
        if (function != null){
            String functionName = function.value();
            log.info("方法名：" + functionName);
            if (!canAccess(functionName)){
                MethodSignature ms = (MethodSignature) pjp.getSignature();
                throw new BizException("没有权限访问方法:" + ms.getMethod());
            }
        }
        //继续处理原有逻辑
        return pjp.proceed();
    }

    private boolean canAccess(String functionName){
        if (functionName.length() == 0){
            return true;
        }else {
            //权限管理，取出当前用户所对应地角色，从数据库中查询该角色是否有访问functionName的权限
            return false;
        }
    }
}
