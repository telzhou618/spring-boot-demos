package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhougaojun
 */
@ToString
@Getter
@Setter
@TableName("tb_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
