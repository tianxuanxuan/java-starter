package com.xgit.starter.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tianxuanxuan
 * On 2020-09-24 09:51
 */

@Target({ElementType.METHOD}) //作用在方法
@Retention(RetentionPolicy.RUNTIME) //保留策略，不加的话注解会被编译器抹去
public @interface Function {
    /**
     * 定义注解的一个元素，并给定默认值
     * @return
     */
    String value() default "我是定义在方法上的注解元素value的默认值";
}
