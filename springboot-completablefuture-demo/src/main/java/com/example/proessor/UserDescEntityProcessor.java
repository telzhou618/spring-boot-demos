package com.example.proessor;

import com.alibaba.fastjson.JSON;
import com.example.bean.Entity;
import com.example.bean.UserDescEntity;
import org.springframework.stereotype.Service;

/**
 * @author jameszhou
 */
@Service
public class UserDescEntityProcessor extends AbstractEntityProcessor {


    @Override
    public Entity requestEntity() {
        String json = restTemplate.getForObject("http://api.btstu.cn/yan/api.php?charset=utf-8&encode=json", String.class);
        return JSON.parseObject(json,UserDescEntity.class);
    }
}
