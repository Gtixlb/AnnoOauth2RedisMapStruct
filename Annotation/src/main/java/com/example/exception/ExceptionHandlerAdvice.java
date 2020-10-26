package com.example.exception;

import com.example.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-04-29 9:50
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class ExceptionHandlerAdvice {
    /**
     * 实体类成员参数校验错误
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleArgsNotValidException(MethodArgumentNotValidException e) {
        /*ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Result.err(objectError.getDefaultMessage());*/

        String message = e.getBindingResult().getFieldError().getDefaultMessage();
//        String message = Stream.of(e.getBindingResult().getFieldErrors()).map(a->a.toString()).collect(Collectors.joining());
        log.info("-------------handleArgsNotValidException  :{}",message);
        if(StringUtils.isNotEmpty(message)){
            return Result.paramValid(message);
        }else {
            log.info("---------------  handleArgsNotValidException:{}",e);
            return Result.paramValid(e.getBindingResult().getFieldError().toString());
        }

    }

    /**
     * 方法参数@RequestParam校验错误
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Object> constraintViolationException(ConstraintViolationException e) {
        log.info("---------------constraintViolationException-:{}",e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).findFirst().get());
        final String message = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining());
        if(StringUtils.isNotEmpty(message)){
            return Result.paramValid(message);
        }else {
            log.info("------------   constraintViolationException:{}",e);
            return Result.paramValid(e.getConstraintViolations().toString());
        }

    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public Result<Object> handleValidationException(ValidationException e) {
        return Result.paramValid(e.getMessage());
    }

}