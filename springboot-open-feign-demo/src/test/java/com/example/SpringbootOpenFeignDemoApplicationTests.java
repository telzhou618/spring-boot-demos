package com.example;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootOpenFeignDemoApplicationTests {

    @Resource
    private JSONPlaceHolderClient jsonPlaceHolderClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        System.out.println(JSON.toJSONString(jsonPlaceHolderClient.getPosts(), true));
    }

    @Test
    public void test2() {
        System.out.println(JSON.toJSONString(jsonPlaceHolderClient.getPostById(1L), true));
    }

}
