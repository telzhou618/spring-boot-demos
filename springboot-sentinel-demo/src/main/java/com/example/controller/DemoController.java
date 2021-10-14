package com.example.controller;

import com.example.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 * @since 2021/10/14
 */
@RestController
@AllArgsConstructor
public class DemoController {

    private final TestService service;

    @GetMapping("/foo")
    public String apiFoo(@RequestParam(required = false) Long t) throws Exception {
        if (t == null) {
            t = System.currentTimeMillis();
        }
        service.test();
        return service.hello(t);
    }

    @GetMapping("/baz/{name}")
    public String apiBaz(@PathVariable("name") String name) {
        return service.helloAnother(name);
    }
}
