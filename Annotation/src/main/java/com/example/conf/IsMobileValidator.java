package com.example.conf;

import com.example.annotation.IsMobile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program:Alibaba
 * @description:
 * @author:Mr.Chen
 * @create:2020-09-09 00:12
 **/
@Slf4j
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
    //默认值_false，用于接收注解上自定义的 required
    private boolean required = false;

    private String message = null;

    //1、初始化方法：通过该方法我们可以拿到我们的注解
    @Override
    public void initialize(IsMobile constraintAnnotation) {

        //constraintAnnotation.required() 接收我们自定义的属性，是否为空
        required = constraintAnnotation.required();
        message = constraintAnnotation.message();

    }

    //2、逻辑处理
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //2.1、如果允许为空的话，直接返回结果
        if(required) {
//            return ValidatorUtil.isMobile(value);
            log.info("------------   value:{}",value);
        }else {
            //2.2、不允许为空
            //2.2.1、验证是否为空
            if(StringUtils.isEmpty(value)) {
                log.info("---------------- val isEmpty!!!!!");
                context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate("mobile can't null!").addConstraintViolation();
                context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
                return false;
            }else {
                log.info("---------------  val isNotEmpty!:{}",value);
//                return ValidatorUtil.isMobile(value);
                return true;
            }
        }
        return false;
    }
}
