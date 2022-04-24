package com.example;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhougaojun
 * @since 2022/4/24
 */
@Getter
@Setter
public class Post {

    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
