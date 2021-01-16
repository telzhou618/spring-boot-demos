package com.example.mapper;

import com.example.SpringTests;
import com.example.entity.Order;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class OrderMapperTest extends SpringTests {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testAdd() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order()
                    .setOrderName("order_name" + i)
                    .setTotalMoney(1000D);
            orderMapper.insert(order);
        }
    }

    @Test
    public void selectAll() {
        orderMapper.selectList(null)
                .stream()
                .forEach(System.out::println);
    }
}