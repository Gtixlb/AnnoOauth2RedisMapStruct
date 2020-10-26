package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version: 1.00.00
 * @description: 地址
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-10-20 14:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddrInfoPO {

    private String city;

    private String name;

    private Double lat;

    private Double lng;


}
