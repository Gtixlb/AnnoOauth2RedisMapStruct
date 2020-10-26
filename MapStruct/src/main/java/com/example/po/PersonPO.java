package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version: 1.00.00
 * @description: 人
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-10-20 14:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonPO {
    private String name;

    private Integer age;

    private String addr;

    private String city;

}
