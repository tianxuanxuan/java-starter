package com.xgit.starter.controller;

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
        return "登录成功";
    }

    @GetMapping("/r/r1")
    public String r1(){
        return "访问资源r1";
    }

    @GetMapping("/r/r2")
    public String r2(){
        return "访问资源r2";
    }
}
