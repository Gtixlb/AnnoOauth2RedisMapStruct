package com.example.util;


import com.example.constant.Constant;
import lombok.Data;
import org.slf4j.MDC;

import static com.example.constant.Constant.REQUEST_ID;

/**
 * @version: 1.00.00
 * @description: 请求返回消息体
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-04-29 9:44
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private int code = -1;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 系统唯一标识吗
     */
    private String requestId;

    private Result(int code, String message, T data,String requestId) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.requestId = requestId;
    }

    public static <T> Result<T> data(T data) {
        return new Result<>(ResultMessage.SUCCESS.code(), ResultMessage.SUCCESS.message(), data,MDC.get(REQUEST_ID));
    }

    public static <T> Result<T> err() {
        return new Result<>(ResultMessage.SERVER_ERROR.code(), ResultMessage.SERVER_ERROR.message(), null,MDC.get(REQUEST_ID));
    }

    public static <T> Result<T> err(String message) {
        return new Result<>(ResultMessage.SERVER_ERROR.code(), message, null,MDC.get(REQUEST_ID));
    }

    public static <T> Result<T> paramValid(String message) {
        return new Result<>(Constant.paramsError, message, null,MDC.get(REQUEST_ID));
    }

}