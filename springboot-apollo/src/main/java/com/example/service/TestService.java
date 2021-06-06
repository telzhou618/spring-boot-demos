package com.example.service;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zgj
 * @since 2021/6/3
 */
@Service
public class TestService {

    @ApolloJsonValue("${urls:}")
    private List<String> urls;

    public void test() {
        System.out.println(urls);
    }
}
