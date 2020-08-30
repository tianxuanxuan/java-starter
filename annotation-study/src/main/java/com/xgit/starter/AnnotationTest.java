package com.xgit.starter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by tianxuanxuan
 * On 2020-08-30 15:38
 *
 * 测试java注解类
 */
@MyAnTargetType("我是父类的注解")
public class AnnotationTest {
    @MyAnTargetField(value = "我是字段上的注解")
    private String field = "我是字段";

    @MyAnTargetMethod("测试方法")
    public void test(@MyAnTargetParameter("args11111")
                         @MyAnTargetParameter2("一个参数可以有多个注解，所以读取参数的时候要二维数组")
                                 Integer arg1,
                     @MyAnTargetParameter("args2222") String arg2){
        System.out.println("参数值 === " + arg1 + "," + arg2);
    }

    public static void main(String[] args) {
        //获取类上的注解
        MyAnTargetType t = AnnotationTest.class.getAnnotation(MyAnTargetType.class);
        System.out.println("类上注解的值 === " + t.value());

        MyAnTargetMethod tm = null;

        try {
            //根据反射获取AnnotationTest类上的test方法
            Method method = AnnotationTest.class.getDeclaredMethod("test", Integer.class, String.class);
            tm = method.getAnnotation(MyAnTargetMethod.class);
            System.out.println("方法上的注解值 ===" + tm.value());
            //获取方法上的所有参数注解，循环所有注解找到MyAnTargetParameter注解
            Annotation[][] annotations = method.getParameterAnnotations();
            for (Annotation[] tt : annotations){
                for (Annotation t1 : tt){
                    if (t1 instanceof MyAnTargetParameter){
                        System.out.println("参数上的注解值1 === " + ((MyAnTargetParameter) t1).value());
                    }
                    if (t1 instanceof MyAnTargetParameter2){
                        System.out.println("参数上的注解值2 === " + ((MyAnTargetParameter2) t1).value());
                    }
                }
            }
            //这里method.invoke方法就是调用某个对象的该方法，第一个参数是对象，第二个第三个是该方法的参数
            method.invoke(new AnnotationTest(), 1, "改变默认参数");

            //获取AnnotationTest类上字段field的注解MyAnTargetField
            MyAnTargetField fieldAn = AnnotationTest.class.getDeclaredField("field")
                    .getAnnotation(MyAnTargetField.class);
            System.out.println("字段上的注解值 === " + fieldAn.value());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
