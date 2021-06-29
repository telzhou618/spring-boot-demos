package com.example.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou1
 * @since 2021/6/29
 */
@Configuration
public class CommonConfig {

    @Value("${spring.zookeeper.address}")
    private String zookeeperAddress;

    @Bean
    @ConditionalOnMissingBean({CuratorFramework.class})
    public CuratorFramework curatorFramework() {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(zookeeperAddress, new RetryNTimes(5, 1000));
        curatorFramework.start();
        return curatorFramework;
    }
}
