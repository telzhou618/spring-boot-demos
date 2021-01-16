package com.example.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 定制库的精确分片策略
 *
 * @author jameszhou
 */
public class MyPreciseDBAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {

        // select * from tb_order where id = ? or id in();

        // 分片键的值 11111
        Long value = shardingValue.getValue();
        // 分片列名称 id
        String columnName = shardingValue.getColumnName();
        // 逻辑表名称 tb_order
        String logicTableName = shardingValue.getLogicTableName();

        return "ds0" + value % 2 + 1;
    }
}
