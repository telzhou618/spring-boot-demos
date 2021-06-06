package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.example.entity.T1;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author zhougaojun
 */
public interface T1Mapper extends BaseMapper<T1> {

    int insertBatch(List<T1> entityList);
}
