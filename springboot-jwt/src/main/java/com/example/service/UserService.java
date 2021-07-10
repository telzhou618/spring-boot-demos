package com.example.service;

import com.example.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author zhou1
 */
@Service
public class UserService {
    /**
     * 模拟登录
     */
    public User login(String username, String password) {
        // 验证参数
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("用户名和密码不能为空");
        }
        // 模拟查库，验证密码，验证成功返回用户信息
        if ("admin".equals(username) && "123".equals(password)) {
            User user = new User();
            user.setUserId(1);
            user.setUsername("admin");
            return user;
        }
        throw new RuntimeException("用户名或密码错误");
    }
}
