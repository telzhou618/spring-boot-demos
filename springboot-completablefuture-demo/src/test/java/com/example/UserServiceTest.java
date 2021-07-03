package com.example;

import com.alibaba.fastjson.JSON;
import com.example.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jameszhou
 */
public class UserServiceTest extends SpringTests {

    @Autowired
    private UserService userService;

    @Test
    public void randomUserInfo(){
        System.out.println(JSON.toJSONString(userService.randomUserInfo()));
    }
}
