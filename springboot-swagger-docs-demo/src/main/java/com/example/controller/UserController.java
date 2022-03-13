package com.example.controller;

import com.example.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhougaojun
 * @since 2022/3/13
 */
@Slf4j
@RestController
@Api(value = "用户信息管理")
public class UserController {

    @ApiOperation(value = "获取用户信息", notes = "通过用户ID获取用户信息")
    @GetMapping("/user/detail")
    public User detail(@ApiParam(value = "用户ID", required = true) @RequestParam Integer id) {
        return new User().setId(1).setUsername("zhangsan").setAge(10);
    }

    @ApiOperation(value = "保存用户信息", notes = "通过用户姓名获取用户信息")
    @PostMapping("/user/save")
    public Boolean detail(@ApiParam @RequestBody User user) {
        log.info("user:{}", user);
        return true;
    }
}
