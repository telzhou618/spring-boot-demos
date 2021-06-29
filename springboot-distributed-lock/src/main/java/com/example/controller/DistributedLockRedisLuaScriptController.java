package com.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author zhou1
 * @since 2021/6/29
 */
@RestController
@AllArgsConstructor
public class DistributedLockRedisLuaScriptController {

    private StringRedisTemplate stringRedisTemplate;

    /**
     * 模拟下单减库存，使用redis单线程的特性保证不超卖
     * 在 lua 脚本中校验库存，再减库存，保证原子性,前提是要把库存先存在 redis 中。
     * 库存扣减成功，再下单。
     */
    @RequestMapping("/test/doReduceStack")
    public String doReduceStack() {
        int store = Integer.parseInt(stringRedisTemplate.opsForValue().get("store"));
        if (store <= 0) {
            throw new RuntimeException("库存为0，请补仓");
        }
        // 减库存脚本，线程安全
        RedisScript<Boolean> script = new DefaultRedisScript(
                "local original_count_str = redis.call('GET', KEYS[1]) " +
                        "local original_count = tonumber(original_count_str) " +
                        "local need_count = tonumber(ARGV[1]) " +
                        "if original_count >=  need_count " +
                        "then " +
                        "  redis.call('SET',  KEYS[1], original_count-need_count ) " +
                        "  return true " +
                        "else " +
                        "  return false " +
                        "end", Boolean.class);
        Boolean result = stringRedisTemplate.execute(script, Collections.singletonList("store"), "1");
        if (result) {
            // 库存扣减成功，模拟生成丁当
            System.out.println("下单成功");
            return "下单成功";
        } else {
            throw new RuntimeException("商品已抢光，下次早点来哦。");
        }
    }

}
