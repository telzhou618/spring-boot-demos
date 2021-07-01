package com.example.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.order.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhou1
 * @since 2021/6/30
 */
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from tb_order")
    List<Order> selectOrderList();
}
