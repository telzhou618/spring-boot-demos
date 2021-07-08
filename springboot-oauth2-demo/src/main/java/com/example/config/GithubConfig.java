package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhougaojun
 * @since 2021/7/8
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "oauth.github")
public class GithubConfig {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
