package com.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jameszhou
 */
@Component
@EnableAspectJAutoProxy
@SpringBootApplication
public class Application implements InitializingBean {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    private ResourceLoader resourceLoader;

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Autowired
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        InputStream inputStream = resourceLoader.getResource("classpath:prop.properties").getInputStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        System.out.println(properties);
        System.out.println(properties.getProperty("a"));
    }
}
