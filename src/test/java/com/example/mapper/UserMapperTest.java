package com.example.mapper;

import com.alibaba.fastjson.JSON;
import com.example.SpringTests;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author zhougaojun
 */
public class UserMapperTest extends SpringTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void list() {
        System.out.printf(JSON.toJSONString(userMapper.selectAll()));
    }

}
