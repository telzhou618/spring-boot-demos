package com.example.proessor;

import com.alibaba.fastjson.JSON;
import com.example.bean.AvatarEntity;
import com.example.bean.Entity;
import com.example.enums.EntityTypeEnum;
import org.springframework.stereotype.Service;

/**
 * @author jameszhou
 */
@Service
public class AvatarEntityProcessor extends AbstractEntityProcessor {


    @Override
    public Entity requestEntity() {
        try {
            String json = restTemplate.getForObject("http://api.btstu.cn/sjtx/api.php?lx=c1&format=json", String.class);
            AvatarEntity avatarEntity = JSON.parseObject(json, AvatarEntity.class);
            if (avatarEntity != null) {
                avatarEntity.setEntityType(EntityTypeEnum.AVATAR_TYPE.getType());
            }
            return avatarEntity;
        } catch (Exception e) {
            throw new RuntimeException("头像数据获取出错", e);
        }

    }
}
