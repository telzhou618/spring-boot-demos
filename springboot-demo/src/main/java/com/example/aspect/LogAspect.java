package com.example.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhougaojun
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    public LogAspect() {
        System.out.println(111);
    }

    @Pointcut("execution(public * com.example.service.impl.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        log.info("参数 ==> {}", JSON.toJSONString(method.getParameters()));
        Object object = joinPoint.proceed();
        log.info("返回 <== {}", JSON.toJSONString(object));
        return object;
    }

    @Before("pointcut()")
    public void beginTransaction() {
        System.out.println("before beginTransaction");
    }

    @After("pointcut()")
    public void commit() {
        System.out.println("after commit");
    }

}
