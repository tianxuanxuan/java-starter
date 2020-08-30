package com.xgit.starter;

/**
 * Created by tianxuanxuan
 * On 2020-08-30 17:00
 */
public class ChildAnnotationTest extends AnnotationTest {
    public static void main(String[] args) {
        // 获取类上的注解MyAnTargetType
        MyAnTargetType t = ChildAnnotationTest.class.getAnnotation(MyAnTargetType.class);
        System.out.println("类上的注解值 === "+t.value());
    }
}
