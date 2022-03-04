package com.example.service;

import com.example.evenet.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author zhougaojun
 * @since 2022/3/4
 */
@Service
public class CouponService {

    @EventListener
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("发优惠券给:" + event.getUsername());
    }
}
