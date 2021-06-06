package com.example.mapper;

import com.example.SpringTests;
import com.example.entity.T1;
import com.example.entity.T2;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class T1MapperTest extends SpringTests {

    @Autowired
    private T1Mapper t1Mapper;

    @Autowired
    private T2Mapper t2Mapper;

    @Test
    public void genDataT1() {
        for (int i = 100000; i < 1000000; i++) {
            T1 t1 = new T1().setA(i).setB(i);
            t1Mapper.insert(t1);
        }
    }

    @Test
    public void batchInsertDataT1() {
        ArrayList<T1> t1s = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
           t1s.add( new T1().setA(i).setB(i));
        }
        int i = t1Mapper.insertBatch(t1s);
        System.out.println(i);
    }

    @Test
    public void genDataT2() {
        for (int i = 0; i < 10000; i++) {
            T2 t2 = new T2().setA(i).setB(i);
            t2Mapper.insert(t2);
        }
    }
}