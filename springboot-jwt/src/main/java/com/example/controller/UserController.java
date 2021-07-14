package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.bean.User;
import com.example.service.JwtService;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhou1
 */
@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    /**
     * 模拟登录，生成jwt token
     */
    @PostMapping("/user/login")
    public String login(@RequestBody User user) {
        // 验证账号密码
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        if (null == loginUser) {
            throw new RuntimeException("用户不存在或账号密码错误");
        }
        // 生成 token
        return jwtService.createUserToken(loginUser);
    }

    /**
     * 解析 token,取出用户信息
     */
    @GetMapping("/user/info")
    public User getUserInfo(String token) {
        Assert.notNull(token, "param token is not null");
        // 验证 token
        DecodedJWT decodedJwt = jwtService.verify(token);
        // 解析 token
        if (null == decodedJwt) {
            throw new RuntimeException("token 校验失败");
        }
        log.info("decodedJwt = {}",JSON.toJSONString(decodedJwt));
        // 取出用户信息
        Claim claim = decodedJwt.getClaim("user");
        if (claim.isNull()) {
            throw new RuntimeException("用户信息解析失败");
        }
        return JSON.parseObject(claim.asString(), User.class);
    }
}
