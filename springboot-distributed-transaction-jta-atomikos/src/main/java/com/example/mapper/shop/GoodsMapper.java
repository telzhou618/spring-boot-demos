package com.example.mapper.shop;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.shop.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhou1
 * @since 2021/6/30
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select * from tb_goods")
    List<Goods> selectGoodsList();
}
