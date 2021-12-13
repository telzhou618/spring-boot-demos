package com.example.service.impl;

import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author zhougaojun
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Override
    public void test() {
        log.info("执行业务方法test...");
        ((UserService) AopContext.currentProxy()).test1();
    }

    @Override
    public void test1() {
        log.info("执行业务方法test1...");
    }
}
