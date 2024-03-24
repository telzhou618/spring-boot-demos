package com.example;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * * @author telzhou618
 **/
@Configuration
public class FeignLogConfiguration {

    @Bean
    feign.Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
