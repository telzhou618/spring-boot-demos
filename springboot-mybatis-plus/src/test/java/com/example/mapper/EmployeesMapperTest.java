package com.example.mapper;

import com.example.SpringTests;
import com.example.entity.Employees;
import com.example.entity.T2;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Random;

/**
 * @author zhougaojun
 */
public class EmployeesMapperTest extends SpringTests {

    @Autowired
    private EmployeesMapper employeesMapper;

    @Test
    public void genData() {
        for (int i = 0; i < 10000; i++) {
            Employees employees = new Employees().setName("zhangsan" + i)
                    .setAge(Lists.newArrayList(18, 19, 24).get(new Random().nextInt(2)))
                    .setPosition(Lists.newArrayList("dev", "manager", "admin").get(new Random().nextInt(2)))
                    .setHireTime(new Date());
            employeesMapper.insert(employees);
        }
    }
}
