package com.example.demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

/**
 * @author zhougaojun
 */
public class BloomFilterTest {
    // 100_0000 是容量，0.0001是错误率
    private static BloomFilter bloomFilter = BloomFilter.create(Funnels.integerFunnel(),100_0000,0.0001);

    @Test
    public void test(){
        // 加入数据
        bloomFilter.put(1);
        bloomFilter.put(2);
        bloomFilter.put(3);

        // 验证是否存在
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
        System.out.println(bloomFilter.mightContain(3));
        System.out.println(bloomFilter.mightContain(4));
    }
}
