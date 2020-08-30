package com.xgit.starter;

import java.lang.annotation.*;

/**
 * Created by tianxuanxuan
 * On 2020-08-30 15:23
 *
 * 定义一个可以注解在class，interface，enum上的注解
 *
 */
@Target({ElementType.TYPE}) //TYPE表示注解可以作用在类、接口和enum上
@Retention(RetentionPolicy.RUNTIME)
@Inherited //父类的注解可以被子类继承
public @interface MyAnTargetType {
    /**
     * 定义注解的一个元素，并给定默认值
     * @return
     */
    String value() default "我是定义在类接口枚举类型上的注解元素value的默认值";
}
