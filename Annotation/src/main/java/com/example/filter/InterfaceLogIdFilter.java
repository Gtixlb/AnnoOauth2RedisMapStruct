package com.example.filter;


import com.example.util.CommonUtil;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;

import static com.example.constant.Constant.REQUEST_ID;

/**
 * @version: 1.00.00
 * @description: 日志ID
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-05-15 15:19
 */

public class InterfaceLogIdFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(REQUEST_ID, CommonUtil.generateUnique());
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.remove(REQUEST_ID);
    }

    @Override
    public void destroy() {

    }
}
