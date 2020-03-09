package com.example.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** postBody 参数接收测试
 * @author zhougaojun
 */
@Slf4j
@RestController
public class PostBodyParamController {

    @PostMapping("/param/post")
    public String post(@RequestBody UserDTO userDTO) {
        log.info("userDTO = {}", userDTO);
        return "ok";
    }

    @PostMapping("/param/post2")
    public String post2(String name, int age) {
        log.info("name = {},age = {}", name, age);
        return "ok";
    }


    @Data
    public static class UserDTO {
        private String name;
        private Integer age;
    }
}
