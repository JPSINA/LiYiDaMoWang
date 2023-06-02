package com.jp.katesystem.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.jp.katesystem.domain.User;
import com.jp.katesystem.service.UserService;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user/")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public SaResult loginController(@RequestBody Map<String, Object> data){
        User user = userService.loginService((String) data.get("name"), (String) data.get("password"));
        if(user!=null){
            StpUtil.login(user.getUid());
            return SaResult.data(user);
        }else{
            return SaResult.error("账号或密码错误！");
        }
    }

    @PostMapping("register")
    public SaResult registController(@RequestBody Map<String, Object>  newUser){
        User registerUser = new User();
        registerUser.setName((String) newUser.get("name"));
        registerUser.setPassword((String) newUser.get("password"));
        registerUser.setRole("normal");
        User user = userService.registService(registerUser);
        if(user!=null){
            return SaResult.data(user);
        }else{
            return SaResult.error("用户名已存在！");
        }
    }
}
