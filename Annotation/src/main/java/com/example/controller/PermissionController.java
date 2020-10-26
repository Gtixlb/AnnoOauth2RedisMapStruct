package com.example.controller;

import com.example.annotation.Permission;
import com.example.constant.Constant;
import com.example.dto.PersonDTO;
import com.example.util.CommonUtil;
import com.example.util.Result;
import org.slf4j.MDC;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @version: 1.00.00
 * @description: 权限控制类
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-05-14 19:24
 */
@RestController
@Validated
public class PermissionController {

    @RequestMapping("/read")
    @Permission("read")
    public Result<String> readPermission(@RequestBody @Valid PersonDTO person){
        return Result.data("——————————————读—————————————");
    }

    @RequestMapping("/write")
    @Permission("write")
    public Result<String> writePermission(@RequestBody @Valid PersonDTO person){
        return Result.data("——————————————写——————————————");
    }

}
