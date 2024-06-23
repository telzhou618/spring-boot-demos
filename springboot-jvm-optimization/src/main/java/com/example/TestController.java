package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * * @author telzhou618
 **/
@RequestMapping("/test")
@RestController
public class TestController {
    private static List<Object> objects = new ArrayList<>();

    @RequestMapping("oom")
    public String testOom(){
        new Thread(()->{
            while (true){
                byte[] bytes = new byte[1024*1024*10];
                objects.add(bytes);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return "ok";
    }
}
