package com.example.controller;

import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 * @since 2022/3/4
 */
@RestController
@AllArgsConstructor
public class TestController {

    private final UserService userService;

    @RequestMapping("/test")
    public String test() {
        userService.register();
        return "success";
    }
}
