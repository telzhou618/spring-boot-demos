package com.example.controller;

import lombok.AllArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhou1
 * @since 2021/6/29
 */
@RestController
@AllArgsConstructor
public class DistributedLockRedissonController {

    private final RedissonClient redissonClient;
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * redisson 分布式锁
     */
    @RequestMapping("/redisson/doReduceStack")
    public String doReduceStack() {
        // 检查库存
        int store = Integer.parseInt(stringRedisTemplate.opsForValue().get("store"));
        if (store <= 0) {
            throw new RuntimeException("库存不足");
        }
        RLock lock = redissonClient.getLock("lock");
        try {
            lock.lock();
            // 双重检查
            store = Integer.parseInt(stringRedisTemplate.opsForValue().get("store"));
            if (store <= 0) {
                throw new RuntimeException("库存不足");
            }
            // 减库存
            stringRedisTemplate.opsForValue().set("store", String.valueOf(store - 1));
            // 生成订单
            System.out.println("下单成功");
            return "下单成功";
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
