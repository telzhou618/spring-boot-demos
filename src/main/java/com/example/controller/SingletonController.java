package com.example.controller;

import com.example.common.UserSingletonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 */
@RestController
public class SingletonController {


    @GetMapping("/user/singleton")
    public String getUserSingleton() {
        return UserSingletonService.getInstance().toString();
    }

    @GetMapping("/user/singleton2")
    public String getUserSingleton2() {
        return UserSingletonService.getInstance2().toString();
    }
}
