package com.example.pojo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-04-29 9:46
 */
@Data
public class User extends Person{
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11")
    private String account;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-11")
    private String password;

    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
