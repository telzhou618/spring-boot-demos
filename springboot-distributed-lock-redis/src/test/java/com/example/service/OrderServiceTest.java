package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.SpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceTest extends SpringTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void testList() {
        System.out.println(JSON.toJSONString(orderService.list()));
    }

    @Test
    public void buyGoods(){
        System.out.println(orderService.buyGoods(1));
    }
}