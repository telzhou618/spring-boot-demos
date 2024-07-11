package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author telzhou
 * @date 2024/7/11
 */

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 禁止删除所有记录
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        // 添加非法SQL拦截器
        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        return interceptor;
    }
}
