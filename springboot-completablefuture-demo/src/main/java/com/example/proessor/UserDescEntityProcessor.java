package com.example.proessor;

import com.alibaba.fastjson.JSON;
import com.example.bean.Entity;
import com.example.bean.UserDescEntity;
import com.example.enums.EntityTypeEnum;
import org.springframework.stereotype.Service;

/**
 * @author jameszhou
 */
@Service
public class UserDescEntityProcessor extends AbstractEntityProcessor {


    @Override
    public Entity requestEntity() {
        try {
            String json = restTemplate.getForObject("http://api.btstu.cn/yan/api.php?charset=utf-8&encode=json", String.class);
            UserDescEntity userDescEntity = JSON.parseObject(json, UserDescEntity.class);
            if (userDescEntity != null) {
                userDescEntity.setEntityType(EntityTypeEnum.USER_DESC_TYPE.getType());
            }
            return userDescEntity;
        } catch (Exception e) {
            throw new RuntimeException("用户简介获取失败", e);
        }

    }
}
