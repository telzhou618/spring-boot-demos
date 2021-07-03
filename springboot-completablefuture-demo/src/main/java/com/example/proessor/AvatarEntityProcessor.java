package com.example.proessor;

import com.alibaba.fastjson.JSON;
import com.example.bean.AvatarEntity;
import com.example.bean.Entity;
import org.springframework.stereotype.Service;

/**
 * @author jameszhou
 */
@Service
public class AvatarEntityProcessor extends AbstractEntityProcessor {


    @Override
    public Entity requestEntity() {
        String json = restTemplate.getForObject("http://api.btstu.cn/sjtx/api.php?lx=c1&format=json", String.class);
        return JSON.parseObject(json, AvatarEntity.class);
    }
}
