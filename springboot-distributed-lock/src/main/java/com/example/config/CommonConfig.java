package com.example.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhougaojun
 * @since 2021/6/29
 */
@Configuration
public class CommonConfig {

    @Bean
    @ConditionalOnMissingBean({CuratorFramework.class})
    public CuratorFramework curatorFramework() {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryNTimes(5, 1000));
        curatorFramework.start();
        return curatorFramework;
    }
}
