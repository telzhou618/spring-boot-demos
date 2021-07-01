package com.example.entity.order;

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
@TableName("tb_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("userId")
    private Integer userId;
    @TableField("goodsId")
    private Integer goodsId;
    @TableField("totalMoney")
    private Integer totalMoney;
}
