package com.itersan.ersanadmin.controller;

import com.itersan.ersanadmin.service.LoginService;
import com.itersan.ersanpojo.admin.User;
import com.itersan.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        log.info("登录的用户名是{}", user.getUserName());
        return loginService.login(user);
    }

    @GetMapping("/user/logout")
    @PreAuthorize("@er.hasAuthority('system:test:list111')")
    public ResponseResult logout() {
        log.info("退出登录");
        return loginService.loginout();
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('system:test:list111')")//权限
    public String hello(){
        return "hello";
    }




}
