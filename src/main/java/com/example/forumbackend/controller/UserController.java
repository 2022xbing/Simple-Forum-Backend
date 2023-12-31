package com.example.forumbackend.controller;

import com.example.forumbackend.domain.User;
import com.example.forumbackend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.forumbackend.utils.Result;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestBody User newUser) {
        User user = userService.loginService(newUser.getUsername(), newUser.getPassword());
        if (user != null) {
            return Result.success(user, "登录成功！");
        } else {
            return Result.error(201, "账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registerController(@RequestBody User newUser) {
        User user = userService.registerService(newUser);
        if (user != null) {
            return Result.success(user, "注册成功！");
        } else {
            return Result.error(201, "用户名已存在！");
        }
    }
}
