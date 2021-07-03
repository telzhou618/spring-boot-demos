package com.example.service.impl;

import com.example.bean.AvatarEntity;
import com.example.bean.Entity;
import com.example.bean.User;
import com.example.bean.UserDescEntity;
import com.example.enums.EntityTypeEnum;
import com.example.proessor.AbstractEntityProcessor;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author jameszhou
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    List<AbstractEntityProcessor> abstractEntityProcessors;

    @Override
    public User randomUserInfo() {

        // 准备任务
        List<CompletableFuture<Entity>> completableFutures = abstractEntityProcessors.stream()
                .map(processor -> CompletableFuture.supplyAsync(processor::requestEntity)
                        .exceptionally(ex -> {
                            ex.printStackTrace();
                            System.out.println(ex.getMessage());
                            return null;
                        })
                ).collect(Collectors.toList());

        // 执行任务
        CompletableFuture<Void> allOfCompletableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
        List<Entity> result = allOfCompletableFuture.thenApply(v -> completableFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList())).join();


        User user = new User();
        user.setId(1).setUsername("tom");
        result.stream().filter(Objects::nonNull).forEach(entity -> {
            if (EntityTypeEnum.AVATAR_TYPE.eq(entity.getEntityType())) {
                user.setAvatar(((AvatarEntity) entity).getImgurl());
            }
            if (EntityTypeEnum.USER_DESC_TYPE.eq(entity.getEntityType())) {
                user.setUserDesc(((UserDescEntity) entity).getText());
            }
        });
        return user;
    }
}