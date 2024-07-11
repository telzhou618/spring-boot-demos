package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.BaseTest;
import com.example.entity.Post;
import com.example.entity.User;
import com.example.mapper.post.PostMapper;
import com.example.mapper.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author telzhou
 * @date 2024/7/10
 */
public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void test() {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, 1);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {
        // 无条件，报错，禁止全表扫描
        List<Post> posts = postMapper.selectList(null);
        posts.forEach(System.out::println);
    }

    @Test
    public void test3() {
        // 禁止无条件删除，
        userMapper.delete(null);
        postMapper.delete(null);
    }
}