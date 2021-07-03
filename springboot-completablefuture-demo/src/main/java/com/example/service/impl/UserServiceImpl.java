package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.bean.Entity;
import com.example.bean.User;
import com.example.proessor.AbstractEntityProcessor;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author jameszhou
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    List<AbstractEntityProcessor> abstractEntityProcessors;

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(5);


    @Override
    public User randomUserInfo() {

        // 准备任务
        List<CompletableFuture<Entity>> completableFutures = abstractEntityProcessors.stream()
                .map(processor -> CompletableFuture
                        .supplyAsync(processor::requestEntity,EXECUTOR)
                        .exceptionally(ex -> {
                            ex.printStackTrace();
                            return null;
                        })
                ).collect(Collectors.toList());

        // 执行任务
        CompletableFuture<Void> allOfCompletableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
        List<Entity> result = allOfCompletableFuture
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()))
                .join();
        log.info(JSON.toJSONString(result));
        return null;
    }
}
