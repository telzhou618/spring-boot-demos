package com.example.controller;

import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 */
@Slf4j
@RestController
@AllArgsConstructor
public class MallController {

    private final OrderService orderService;

    @GetMapping("/shop/buy/goods")
    public String buyGoods(Integer id){
        if(orderService.buyGoods(id)){
            return "success";
        }
        throw new RuntimeException("下单失败");
    }
}
