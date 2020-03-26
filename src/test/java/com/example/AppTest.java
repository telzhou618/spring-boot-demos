package com.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * @author zhougaojun
 */
@Slf4j
public class AppTest {

    @Test
    public void test(){
        log.info("test");
        System.out.printf(ArrayUtils.toString(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 26, 27, 28, 29, 30}));
    }
}
