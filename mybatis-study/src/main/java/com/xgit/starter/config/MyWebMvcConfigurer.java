package com.xgit.starter.config;

import com.xgit.starter.utils.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by tianxuanxuan
 * On 2020-09-11 14:32
 */

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Bean
    public MyInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义的拦截器，凡url以"/role"开头都拦截
        registry.addInterceptor(getMyInterceptor())
                .addPathPatterns("/role/**")
                .excludePathPatterns("/error/**");
    }

    //跨域访问配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/role/**") //允许跨域的路径
                .allowedOrigins("*") //允许跨域请求的域名
                .allowedMethods("POST", "GET"); //允许跨域请求的方法
    }
}
