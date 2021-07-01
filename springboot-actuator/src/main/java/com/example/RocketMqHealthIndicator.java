package com.example;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/** 自定义健康检查，模拟RocketMq监控检查
 *  启动服务访问：http://localhost:8080/actuator/health
 * @author jameszhou
 */
@Component
public class RocketMqHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if(errorCode == 200){
            return Health.up().build();
        }else {
            return Health.down().withDetail("errorCode",errorCode).build();
        }
    }

    private int check(){
        // 返回 500 模拟检查检查失败
        return 500;
    }
}
