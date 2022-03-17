package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhougaojun
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.example.service.impl.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        log.info("Before通知 -> 业务方法执行前调用...");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around通知 -> 业务方法执行前调用...");
        Object object = joinPoint.proceed();
        log.info("Around通知 -> 业务方法执行后调用...");
        return object;
    }

    @After("pointcut()")
    public void after() {
        log.info("After通知 -> 业务方法执行后调用...");
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        ex.printStackTrace();
        log.info("AfterThrowing通知 -> 业务方法执行异常调用...");
    }
}
