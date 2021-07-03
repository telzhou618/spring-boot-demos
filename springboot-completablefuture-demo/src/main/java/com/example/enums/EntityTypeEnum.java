package com.example.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author gaojun.zhou
 */

@Getter
@AllArgsConstructor
public enum EntityTypeEnum {

    USER_DESC_TYPE(1, "简介数据"),

    AVATAR_TYPE(2, "头像数据");

    private final int type;
    private final String name;


    public boolean eq(Integer entityType) {
        return Objects.equals(entityType, this.getType());
    }
}
