package com.example.conf;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.annotation.IsMobile;
import com.example.annotation.IsTimestamp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @version: 1.00.00
 * @description:  校验器
 *                ConstraintValidator接口使用了泛型，需要指定两个参数，
 *               第一个自定义注解类，第二个为需要校验的数据类型（可以是对象、基本类型、String等）。
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020/9/10 10:40
 */

@Slf4j
public class IsTimestampValidator implements ConstraintValidator<IsTimestamp, String> {

    /**
     * 毫秒转秒
     */
    private final int secondBase = 1000;

    /**
     * 5分钟有效期
     */
    private final int timestampExpireTime = 300;

    /**
     * 默认值_false，用于接收注解上自定义的 required
     */
    private boolean required = false;

    /**
     * 异常信息
     */
    private String message = null;

    /**
     * @description: 初始化方法：通过该方法我们可以拿到我们的注解信息
     * @author: chd
     * @param: [constraintAnnotation]
     * @return: void
     * @throws:
     */
    @Override
    public void initialize(IsTimestamp constraintAnnotation) {
        //默认值_true，用于接收注解上自定义的 required
        required = constraintAnnotation.required();
        //错误信息（timestamp invalid!）
        message = constraintAnnotation.message();
    }

    /**
     * @description: 逻辑处理
     * @author: chd
     * @param: [value, context]
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //1. 是否使用注解
        if (required) {
            if (StringUtils.isEmpty(value)) {
                return setMessage("timestamp can't null!", context);
            }
            if (!StringUtils.isNumeric(value)) {
                return false;
            }
            long timestamp = Long.valueOf(value);
            long currentTimestamp = System.currentTimeMillis();
            long expireTime = (timestamp - currentTimestamp) / secondBase;
            if (Math.abs(expireTime) > timestampExpireTime){
                log.info("----------------   req timestamp:{}", DateUtil.date(timestamp));
                log.info("----------------   local timestamp:{}", DateUtil.date(currentTimestamp));
                log.info("----------------   expireTime:{}", expireTime);
                return false;
            }
        }
        return true;
    }

    /**
     * @description: 重写异常提示信息
     * @author: chd
     * @param: [msg, context]
     * @return: boolean
     * @throws:
     */
    public boolean setMessage(String msg, ConstraintValidatorContext context) {
        //禁用默认的message的值
        context.disableDefaultConstraintViolation();
        //重新添加错误提示语句
        context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
        return false;
    }

    public static void main(String[] args) {
        log.info(JSONObject.toJSONString(StringUtils.isNumeric("dddd")));
    }
}
