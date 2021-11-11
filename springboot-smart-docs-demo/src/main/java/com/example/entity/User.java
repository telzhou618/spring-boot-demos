package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zhougaojun
 * @since 2021/11/11
 */
@Setter
@Getter
@Accessors(chain = true)
public class User {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    @Length(max = 11, min = 11, message = "手机号码不合法")
    private String phoneNumber;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /**
     * 住址
     */
    private String address;

}
