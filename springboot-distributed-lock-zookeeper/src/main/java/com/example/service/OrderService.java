package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Order;

/**
 * @author gaojun.zhou
 */
public interface OrderService extends IService<Order> {

    boolean buyGoods(Integer id);

}
