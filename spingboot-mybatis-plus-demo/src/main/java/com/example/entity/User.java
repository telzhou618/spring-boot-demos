package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author telzhou
 * @date 2024/7/10
 */

@Data
@TableName("tb_user")
public class User {

    private Integer id;
    private String username;
    private Integer age;
    private Date birthday;
    private String email;
}
