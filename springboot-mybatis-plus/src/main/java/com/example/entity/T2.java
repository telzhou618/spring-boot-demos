package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author zhougaojun
 */
@ToString
@Getter
@Setter
@Accessors(chain = true)
@TableName("t2")
public class T2 {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer a;
    private Integer b;

}
