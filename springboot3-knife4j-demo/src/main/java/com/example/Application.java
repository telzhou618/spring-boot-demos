package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author jameszhou
 */
@SpringBootApplication
public class Application {

    /**
     * 应用程序的主入口函数。
     *
     * @param args 命令行传入的参数数组。
     *
     * 本方法通过SpringApplication.run方法启动Spring应用，将当前类Application作为应用的入口类，
     * 并将命令行参数args传递给Spring应用。
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
