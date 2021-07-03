package com.example.cnofig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jameszhou
 */
@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    @ConditionalOnMissingBean(Executor.class)
    public Executor executor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(5);
        threadPoolTaskExecutor.setThreadNamePrefix("thread-pool-");
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setKeepAliveSeconds(30);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolTaskExecutor;
    }
}
