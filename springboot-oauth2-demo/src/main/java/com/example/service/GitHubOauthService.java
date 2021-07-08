package com.example.service;

import com.example.config.GithubConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

/**
 * @author zhougaojun
 * @since 2021/7/8
 */
@Slf4j
@Service
@AllArgsConstructor
public class GitHubOauthService {

    private final RestTemplate restTemplate;
    private final GithubConfig githubConfig;


    public String getAccessToken(String code) {
        String url = "https://github.com/login/oauth/access_token?"
                + "client_id=" + githubConfig.getClientId()
                + "&client_secret=" + githubConfig.getClientSecret()
                + "&code=" + code;
        String str = restTemplate.getForObject(url, String.class);
        // access_token=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&scope=&token_type=bearer
        log.info("access_token_response = {}", str);
        return StringUtils.substringBetween(str, "access_token=", "&");
    }

    public String getUserInfos(String accessToken) {
        String url = "https://api.github.com/user";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "token " + accessToken);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> result = restTemplate.exchange(URI.create(url), HttpMethod.GET, entity, String.class);
        log.info("getUserInfos.result = {}", result.getBody());
        return result.getBody();
    }
}
