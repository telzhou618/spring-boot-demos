package com.example.config;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * 定制表的范围分片策略
 *
 * @author jameszhou
 */
public class MyRangeTableAlgorithm implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        // select * from tb_order where id between ？and ?
        // 范围下限值
        Long lowerEndpoint = shardingValue.getValueRange().lowerEndpoint();
        // 范围上限值
        Long upperEndpoint = shardingValue.getValueRange().upperEndpoint();
        // 逻辑表
        String logicTableName = shardingValue.getLogicTableName();
        return Arrays.asList(logicTableName + "01", logicTableName + "02");
    }
}
