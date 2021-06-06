package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jameszhou
 */
@SpringBootTest
class SpringTests {

    @Autowired
    private UserService userService;
    @Test
    void listALl() {
        System.out.println(userService.listALl());
    }

}
