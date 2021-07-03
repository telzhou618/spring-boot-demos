package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 */
@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 获取用户信息
     */
    @GetMapping("/user/random-user-info")
    public User randomUserInfo() {
        return userService.randomUserInfo();
    }
}
