package com.macro.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by macro on 2019/9/30.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    @Qualifier("redisTokenStore")
    private RedisTokenStore tokenStore;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/redis/{clientId}")
    public Object get(@PathVariable String clientId){
        Collection<OAuth2AccessToken> tokenCollection = tokenStore.findTokensByClientId(clientId);
        return tokenCollection;
    }

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @GetMapping("/test11")
    public void test01(){
        Long count = redisTemplate.opsForValue().increment("test");
        log.info("-----------------  count:{}",count);
    }

    @GetMapping("/test12")
    public void test02(){
        Long count = redisTemplate.opsForValue().increment("test2",1);
        log.info("-----------------  count:{}",count);
    }







}
