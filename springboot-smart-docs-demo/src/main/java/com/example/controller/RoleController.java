package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

/**
 * 角色管理
 *
 * @author zhougaojun
 * @since 2021/11/11
 */
@RestController
public class RoleController {

    /**
     * 角色列表
     */
    @GetMapping("/role/list")
    public Result<List<User>> userList() {
        return Result.success(Collections.emptyList());
    }
}
