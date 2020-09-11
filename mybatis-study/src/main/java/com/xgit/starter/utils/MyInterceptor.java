package com.xgit.starter.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tianxuanxuan
 * On 2020-09-11 14:37
 *
 * 自定义拦截器，需要实现 HandlerInterceptor
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String servletPath = request.getServletPath();
        String url = request.getRequestURL().toString();
        /*
         * 业务
         */
        log.info("请求url：{},请求path：{}", url, servletPath);
        return true;
    }
}
