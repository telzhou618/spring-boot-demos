package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author jameszhou
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
@TableName("tb_order")
public class Order {

    private Long id;

    @TableField("order_name")
    private String orderName;

    @TableField("total_money")
    private Double totalMoney;

    @TableField("created_time")
    private Date createdTime;

    @TableField("modified_time")
    private Date modifiedTime;

    @TableField("is_deleted")
    private Boolean isDeleted;

}
