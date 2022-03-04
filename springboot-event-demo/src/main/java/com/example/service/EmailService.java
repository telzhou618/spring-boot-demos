package com.example.service;

import com.example.evenet.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author zhougaojun
 * @since 2022/3/4
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {


    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("发邮件给:" + event.getUsername());
    }
}
