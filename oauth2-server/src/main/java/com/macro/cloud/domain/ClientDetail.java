package com.macro.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @version: 1.00.00
 * @description: client信息凭证
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-09-29 11:11
 */
@Data
@AllArgsConstructor
public class ClientDetail implements Serializable {

    /**
     * clientId
     */
    private String clientId;

    /**
     * clientSecret
     */
    private String clientSecret;

    /**
     * 重定向url
     */
    private String redirectUrl;

    /**
     * 权限范围
     */
    private String scope;

}
