package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Goods;
import com.example.mapper.GoodsMapper;
import com.example.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @author jameszhou
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}