package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户管理
 *
 * @author zhougaojun
 * @since 2021/11/11
 */
@RestController
public class UserController {

    /**
     * 用户列表
     */
    @GetMapping("/user/list")
    public Result<List<User>> userList() {

        List<User> userList = new ArrayList<>();
        userList.add(new User().setUserId(1).setUsername("zhangsan").setBirthday(new Date()).setAddress("杭州").setPhoneNumber("12345678903"));
        userList.add(new User().setUserId(2).setUsername("list").setBirthday(new Date()).setAddress("北京").setPhoneNumber("15345674903"));
        return Result.success(userList);
    }

    /**
     * 用户明细
     *
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/user/id")
    public Result<User> findUserById(@NotNull(message = "用户ID不能为空") Integer userId) {
        return Result.success(new User().setUserId(2).setUsername("list").setBirthday(new Date()).setAddress("北京").setPhoneNumber("15345674903"));
    }

    /**
     * 保存用户
     *
     * @param user 用户对象
     */
    @PostMapping("/user/save")
    public Result<Integer> saveUser(@Validated @RequestBody User user) {
        return Result.success(1);
    }
}
