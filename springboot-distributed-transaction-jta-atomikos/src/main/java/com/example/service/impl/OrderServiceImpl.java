package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.order.Order;
import com.example.entity.shop.Goods;
import com.example.mapper.order.OrderMapper;
import com.example.mapper.shop.GoodsMapper;
import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhou1
 * @since 2021/6/30
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final OrderMapper orderMapper;
    private final GoodsMapper goodsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submitOrder(Integer id) {

        // 预先在 tb_goods 表中插入一个ID商品
        Goods goods = goodsMapper.selectById(id);
        if (goods == null) {
            throw new RuntimeException("商品不存在");
        }
        orderMapper.insert(new Order().setGoodsId(goods.getId()).setUserId(1).setTotalMoney(goods.getPrice()));
        goodsMapper.updateById(new Goods().setId(goods.getId()).setStore(goods.getStore() - 1));
        // 模拟抛异常，两个不同的库都会回滚
        System.out.println(1 / 0);
    }
}
