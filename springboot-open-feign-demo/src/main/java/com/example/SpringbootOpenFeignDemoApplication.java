package com.example;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class SpringbootOpenFeignDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootOpenFeignDemoApplication.class, args);
        JSONPlaceHolderClient jsonPlaceHolderClient = context.getBean(JSONPlaceHolderClient.class);

        System.out.println(JSON.toJSONString(jsonPlaceHolderClient.getPosts(), true));

        System.out.println(JSON.toJSONString(jsonPlaceHolderClient.getPostById(1L),true));
    }

}
