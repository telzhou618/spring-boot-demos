package com.example.service;

import com.example.SpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhou1
 * @since 2021/6/30
 */
public class OrderServiceTest extends SpringTests {

    @Autowired
    private OrderService orderService;


    @Test
    public void submitOrder() {
        orderService.submitOrder(1);
    }
}