package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhougaojun
 * @since 2022/3/13
 */
@Data
@Accessors(chain = true)
public class User {

    /**
     * ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 年龄
     */
    private Integer age;
}
