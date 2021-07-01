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
@TableName("tb_Order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("goods_name")
    private String goodsName;

    @TableField("buy_count")
    private Integer buyCount;

    @TableField("total_money")
    private Integer totalMoney;

    @TableField("remark")
    private String remark;
}
