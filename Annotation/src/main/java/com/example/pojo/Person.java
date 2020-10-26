package com.example.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @version: 1.00.00
 * @description: 人
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-07-03 11:14
 */
@Data
public class Person {

    @NotNull(message = "姓名不能为空")
    @Size(min = 1, max = 11, message = "姓名长度必须是1-11")
    private String name;

}
