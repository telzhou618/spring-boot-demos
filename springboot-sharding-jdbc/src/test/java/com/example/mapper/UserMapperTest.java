package com.example.mapper;


import com.example.SpringTests;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class UserMapperTest extends SpringTests {


    @Resource
    private UserMapper userMapper;

    @Test
    public void selectList(){
        System.out.println(userMapper.selectList(null));
    }
}