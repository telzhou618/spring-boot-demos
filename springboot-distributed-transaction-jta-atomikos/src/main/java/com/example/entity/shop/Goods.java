package com.example.entity.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author zhou1
 * @since 2021/6/30
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("tb_goods")
public class Goods {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("goodsName")
    private String goodsName;
    private Integer price;
    private Integer store;
}
