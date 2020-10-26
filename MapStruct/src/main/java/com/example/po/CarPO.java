package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version: 1.00.00
 * @description: 车
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-10-19 10:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarPO {

    private String name;

    private String color;

    private Integer sex;

}
