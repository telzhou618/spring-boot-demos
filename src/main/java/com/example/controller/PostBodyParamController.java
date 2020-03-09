package com.example.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 */
@RestController
public class PostBodyParamController {

    @PostMapping("/param/post")
    public String test(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return "ok";
    }

    @PostMapping("/param/post2")
    public String test2(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "ok";
    }


    @Data
    public static class UserDTO {
        private String name;
        private Integer age;
    }
}
