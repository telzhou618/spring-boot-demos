package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.SpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsServiceTest extends SpringTests {


    @Autowired
    private GoodsService goodsService;

    @Test
    public void testList() {
        System.out.println(JSON.toJSONString(goodsService.list()));
    }
}