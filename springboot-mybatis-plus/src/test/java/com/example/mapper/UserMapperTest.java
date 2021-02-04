package com.example.mapper;

import com.example.SpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest extends SpringTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void list(){
        System.out.println(userMapper.selectList(null));
    }
}