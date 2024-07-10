package com.example.mapper;

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
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        List<Post> posts = postMapper.selectList(null);
        posts.forEach(System.out::println);
    }
}