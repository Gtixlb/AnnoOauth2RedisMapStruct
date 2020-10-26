package com.example.dto;

import com.example.annotation.IsMobile;
import com.example.annotation.IsTimestamp;
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
public class PersonDTO {

    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 12, message = "用户名长度必须是2-12")
    private String userName;

//    @NotNull(message = "密码不能为空")
//    @Size(min = 6, max = 11, message = "密码长度必须是6-11")
//    private String password;
//
//    @NotNull(message = "邮箱不能为空")
//    @Email(message = "邮箱格式不正确")
//    private String email;

    @IsMobile(required = false)
    @NotNull
    private String love;

    @IsTimestamp
    private String timestamp;

}
