package com.example.conf;

import com.example.filter.InterfaceLogIdFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @version: 1.00.00
 * @description: 日志过滤器
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020/5/15 15:35
 */

@Configuration
public class FilterConf {
    @Bean(name = "reqRespFilter")
    public FilterRegistrationBean reqRespFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new InterfaceLogIdFilter());
//        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }
}
