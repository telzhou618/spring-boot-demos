package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("tb_goods")
public class Goods {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("goods_name")
    private String goodsName;

    @TableField("goods_count")
    private Integer goodsCount;
}
