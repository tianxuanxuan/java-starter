package com.xgit.starter.controller;

import cn.hutool.log.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tianxuanxuan
 * On 2020-09-25 09:56
 */
@RestController
public class SpringSessionController {
    Log log = Log.get(SpringSessionController.class);

    @GetMapping(value = "/springall/putsession")
    public String putSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info(String.valueOf(session.getClass()));
        log.info(session.getId());
        String name = "tianxx";
        session.setAttribute("user", name);
        return "hi," + name;
    }

}
