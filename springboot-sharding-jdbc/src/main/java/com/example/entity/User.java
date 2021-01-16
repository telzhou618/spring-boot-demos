package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author jameszhou
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
@TableName("tb_user")
public class User {

    private Integer id;
    private String username;
    private String password;
}
