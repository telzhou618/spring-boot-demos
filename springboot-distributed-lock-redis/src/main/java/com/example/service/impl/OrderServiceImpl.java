package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Goods;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.GoodsService;
import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jameszhou
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final GoodsService goodsService;
    private final RedissonClient redissonClient;


    @Override
    public boolean buyGoods(Integer id) {
        // redisson 分布式锁
        // @see https://github.com/redisson/redisson/wiki/8.-%E5%88%86%E5%B8%83%E5%BC%8F%E9%94%81%E5%92%8C%E5%90%8C%E6%AD%A5%E5%99%A8
        RLock lock = redissonClient.getLock("lock-goods-" + id);
        try {
            if (lock.tryLock(5L, TimeUnit.SECONDS)) {
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
                throw new RuntimeException("操作过于频繁，请稍后重试!");
            }

        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("业务异常", e);
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    private void submitOrder(Goods goods) {
        Order order = new Order()
                .setGoodsName(goods.getGoodsName())
                .setBuyCount(1)
                .setUsername(RandomStringUtils.randomAlphabetic(10))
                .setTotalMoney(1000);
        this.save(order);
    }

    private void reduceStack(Goods goods) {
        Goods update = new Goods()
                .setId(goods.getId())
                .setGoodsCount(goods.getGoodsCount() - 1);
        goodsService.updateById(update);
    }


}