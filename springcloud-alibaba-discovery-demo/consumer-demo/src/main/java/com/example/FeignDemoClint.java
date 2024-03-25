package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * * @author telzhou618
 **/
@FeignClient(name = "provider-demo")
public interface FeignDemoClint {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable(name = "string") String string);
}
