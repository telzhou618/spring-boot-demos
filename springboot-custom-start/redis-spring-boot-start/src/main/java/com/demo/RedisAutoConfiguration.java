package com.demo;

import com.demo.config.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;

/**
 * @author zhougaojun
 */
@Slf4j
@Configuration
@ConditionalOnClass(Jedis.class)
/**
 * 使得配置RedisProperties生效
 */
@EnableConfigurationProperties(RedisProperties.class)
/**
 * 存在 redis.enable 配置，且值为true时生效
 * havingValue 存在且值和havingValue的值相等时生效
 * matchIfMissing 不存在时的默认值
 */
@ConditionalOnProperty(name = "redis.enable", havingValue = "true", matchIfMissing = false) //  RedisAutoConfiguration 生效条件
public class RedisAutoConfiguration {

    @PostConstruct
    public void init(){
        System.out.println("RedisAutoConfiguration.init...");
    }

    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties) {
        if (log.isDebugEnabled()) {
            log.debug("redisProperties = {}", redisProperties);
        }
        Jedis jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
        if (!StringUtils.isEmpty(redisProperties.getPassword())) {
            jedis.auth(redisProperties.getPassword());
        }
        jedis.select(redisProperties.getIndex());
        return jedis;
    }
}
