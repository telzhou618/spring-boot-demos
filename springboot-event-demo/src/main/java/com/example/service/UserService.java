package com.example.service;

import com.example.evenet.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author zhougaojun
 * @since 2022/3/4
 */
@Service
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void register() {
        System.out.println("用户注册成功!");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, "tom"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
