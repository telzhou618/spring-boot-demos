package com.example;

import org.apache.curator.framework.CuratorFramework;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jameszhou
 */
public class CuratorFrameworkTest extends SpringTests {

    @Autowired
    private CuratorFramework curatorFramework;

    @Test
    public void test(){
        System.out.println(curatorFramework.getState());
    }
}
