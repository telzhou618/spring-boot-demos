package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.SpringTests;
import com.example.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends SpringTests {


    @Autowired
    private UserService userService;

    @Test
    public void testSelectALl() {
        System.out.println(JSON.toJSONString(userService.list()));
    }

}