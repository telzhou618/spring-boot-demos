package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author zhougaojun
 * @since 2021/10/14
 */
@RestController
@AllArgsConstructor
public class TestController {

    @GetMapping("/user")
    @SentinelResource(value = "user", blockHandler = "blockHandlerTest")
    public String user() {
        return "tom";
    }

    @GetMapping("/exception")
    @SentinelResource(value = "exception", fallback = "fallbackTest")
    public String exception() {
        Random random = new Random();
        int a = random.nextInt();
        if (a > 10_0000) {
            throw new RuntimeException("错误的参数," + a);
        }
        return String.valueOf(a);
    }

    public String blockHandlerTest(BlockException e) {
        e.printStackTrace();
        return "error,default-username";
    }

    public String fallbackTest(Throwable e) {
        e.printStackTrace();
        return "error,0";
    }
}
