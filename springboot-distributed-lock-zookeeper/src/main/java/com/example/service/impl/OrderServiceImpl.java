package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Goods;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.GoodsService;
import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jameszhou
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final GoodsService goodsService;
    private final CuratorFramework curatorFramework;


    /**
     * 购买商品
     */
    @Override
    public boolean buyGoods(Integer id) {
        // zookeeper 分布式锁
        // @see https://curator.apache.org/getting-started.html
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/lock/goods-" + id);
        try {
            if (lock.acquire(5L, TimeUnit.SECONDS)) {
                // 验证库存
                Goods goods = goodsService.getById(id);
                if (goods == null) {
                    throw new RuntimeException("商品不存在");
                }
                if (goods.getGoodsCount() <= 0) {
                    throw new RuntimeException("库存不足");
                }
                // 下单
                submitOrder(goods);
                // 减库存
                reduceStack(goods);
                return true;
            } else {
                throw new RuntimeException("获取锁失败，下单用户过多，请稍后重试！");
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("业务异常", e);
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 提交订单
     */
    private void submitOrder(Goods goods) {
        Order order = new Order()
                .setGoodsName(goods.getGoodsName())
                .setBuyCount(1)
                .setUsername(RandomStringUtils.randomAlphabetic(10))
                .setTotalMoney(1000);
        this.save(order);
    }

    /**
     * 减库存
     */
    private void reduceStack(Goods goods) {
        Goods update = new Goods()
                .setId(goods.getId())
                .setGoodsCount(goods.getGoodsCount() - 1);
        goodsService.updateById(update);
    }


}