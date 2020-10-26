package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @version: 1.00.00
 * @description: redis控制层
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-10-23 10:58
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisTemplateController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("test1")
    public void increTest(){
        Long count = redisTemplate.opsForValue().increment("testtest2test2test2test2test2test2");
        log.info("---------------------   :{}",count);
        log.info("----------------   :{}",redisTemplate.opsForValue().get("test"));

    }

    @RequestMapping("test2")
    public void increTest2(){
        Long count = redisTemplate.opsForValue().increment("test2test2test2test2",2);
        log.info("----------------------   count:{}",count);
        log.info("----------------   :{}",redisTemplate.opsForValue().get("test2"));
    }

    @RequestMapping("multiSet")
    public void multiSet(){
        Map<String, String> hash = new HashMap<>();
        hash.put("test001", "1");
        hash.put("test002", "2");
        hash.put("test003", "3");
        redisTemplate.opsForValue().multiSet(hash);
    }

    @RequestMapping("multiGet")
    public void multiGet(){
        List list = new ArrayList();
        list.add("test001");
        list.add("test002");
        list.add("test003");
        log.info(JSONObject.toJSONString(redisTemplate.opsForValue().multiGet(list)));
    }


    public static void main(String[] args) {
        noNull(null);
    }

    public static void noNull(@NonNull Object o){
//        Assert.notNull(o, "not null");
        Objects.requireNonNull(o);
        Optional.ofNullable(o).orElseThrow(() -> new NullPointerException("null"));
        log.info("___________________  :{}",JSONObject.toJSONString(o));
    }

    @RequestMapping("append")
    public void append(){
        log.info(JSONObject.toJSONString(redisTemplate.opsForValue().append("testtest001", "aaa")));
        log.info(redisTemplate.opsForValue().get("testtest001"));
    }


}
