package com.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.context.CanalContext;
import top.javatool.canal.client.handler.EntryHandler;

import java.util.Map;

/**
 * @author telzhou
 * @date 2024/6/23
 */
@Slf4j
@CanalTable(value = "all")
@Component
public class DefaultEntryHandler implements EntryHandler<Map<String, String>> {

    @Override
    public void insert(Map<String, String> map) {
        String table = CanalContext.getModel().getTable();
        log.info("table:{}", table);
        log.info("增加 {}", map);
    }

    @Override
    public void update(Map<String, String> before, Map<String, String> after) {
        String table = CanalContext.getModel().getTable();
        log.info("table:{}", table);
        log.info("修改 before {}", before);
        log.info("修改 after {}", after);
    }

    @Override
    public void delete(Map<String, String> map) {
        String table = CanalContext.getModel().getTable();
        log.info("table:{}", table);
        log.info("删除 {}", map);
    }
}