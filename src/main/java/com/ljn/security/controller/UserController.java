package com.ljn.security.controller;


import com.ljn.security.common.R;
import com.ljn.security.entity.User;
import com.ljn.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ljn
 * @since 2022-05-05
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public R login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping("/user/logout")
    public R logout() {
        return userService.logout();
    }
}

