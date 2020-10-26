package com.example.annotation;
import com.example.conf.IsMobileValidator;
import com.example.conf.IsTimestampValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @version: 1.00.00
 * @description: 时间戳校验
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020/9/10 8:36
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsTimestampValidator.class })
public @interface IsTimestamp {
    //是否开启
    boolean required() default true;

    //如果校验不通过默认提示信息
    String message() default "timestamp invalid!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
