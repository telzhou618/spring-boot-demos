package com.example.controller;

import lombok.AllArgsConstructor;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhougaojun
 * @since 2021/6/29
 */
@RestController
@AllArgsConstructor
public class DistributedLockZookeeperController {

    private CuratorFramework curatorFramework;

    /**
     * zookeeper 分布式锁
     */
    @RequestMapping("/zookeeper/get-lock")
    public String doReduceStack() throws Exception {
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/zookeeper/lockId");

        // zookeeper 加锁的两种方式

        // lock.acquire()
        // 尝试加锁，如果加锁失败，会一致的等到加锁成功。

        // lock.acquire(3, TimeUnit.SECONDS)
        // 尝试加锁，如果加锁失败会在3秒内不断获取所，如果3秒内获取锁失败，则抛异常

        if (lock.acquire(3, TimeUnit.SECONDS)) {
            try {
                // 执行业务
                System.out.println("获得锁成功，执行业务逻辑！");
                TimeUnit.SECONDS.sleep(2);
                return "success";
            } finally {
                if (lock.isOwnedByCurrentThread()) {
                    lock.release();
                }
            }
        } else {
            throw new RuntimeException("操作过于频繁");
        }
    }

}
