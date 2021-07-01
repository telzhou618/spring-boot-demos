package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.order.Order;

/**
 * @author zhou1
 * @since 2021/6/30
 */
public interface OrderService extends IService<Order> {

     void submitOrder(Integer id);
}
