package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhougaojun
 * @since 2021/7/8
 */
@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
