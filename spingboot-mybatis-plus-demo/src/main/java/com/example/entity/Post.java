package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author telzhou
 * @date 2024/7/11
 */

@Data
@TableName("tb_post")
public class Post {

    private Integer id;
    private String title;
}
