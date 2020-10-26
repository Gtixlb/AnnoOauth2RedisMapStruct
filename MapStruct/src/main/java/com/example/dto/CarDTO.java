package com.example.dto;

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
public class CarDTO {

    private String cardName;

    private String cardColor;

    private String gender;

}
