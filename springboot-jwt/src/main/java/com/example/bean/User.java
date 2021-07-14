package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhou1
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer userId;
    private String username;
    private String password;
}
