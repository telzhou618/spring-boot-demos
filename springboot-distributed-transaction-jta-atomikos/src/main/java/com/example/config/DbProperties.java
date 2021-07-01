package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou1
 * @since 2021/6/30
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DbProperties {

    private DbProp shop;
    private DbProp order;

    @Getter
    @Setter
    public static class DbProp {
        private String username;
        private String password;
        private String url;
    }
}
