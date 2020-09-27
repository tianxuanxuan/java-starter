package com.xgit.starter.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxuanxuan
 * On 2020-09-26 19:01
 */
@RestController
public class LoginController {
    @RequestMapping("/login-success")
    public String loginSuccess(){
        return "用户" + getUserName()+  "登录成功";
    }

    @GetMapping("/r/r1")
    public String r1(){
        return getUserName() + "访问资源r1";
    }

    @GetMapping("/r/r2")
    public String r2(){
        return getUserName() + "访问资源r2";
    }

    //session会话管理，获取用户信息
    public String getUserName(){
        //获取当前认证用户的身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principle = authentication.getPrincipal();
        if (principle == null){
            return "匿名";
        }

        if (principle instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principle;
            return userDetails.getUsername();
        }else {
            return principle.toString();
        }
    }
}
