package com.example.model;


import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * 测试实体类
 *
 * @author Administrator
 */
@Data
public class User implements Serializable {
    private Integer id;
    @Column(name = "name")
    private String name;
    private Integer age;
}