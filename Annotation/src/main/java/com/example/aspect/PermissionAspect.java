package com.example.aspect;
import com.alibaba.fastjson.JSONObject;
import com.example.annotation.Permission;
import com.example.dto.PersonDTO;
import com.example.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @version: 1.00.00
 * @description: 权限校验切面
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-05-14 19:26
 */
/*@Aspect
@Component*/
@Slf4j
public class PermissionAspect {

    private static Logger logger = LoggerFactory.getLogger(PermissionAspect.class);

    private static Map<String,String> permissionMap = new LinkedHashMap<>();

    static{
        permissionMap.put("admin","read,write");
        permissionMap.put("user","read");
    }

    @Around("@annotation(com.example.annotation.Permission)")
    public Result<String> checkPermission(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取执行方法的类名
        Class<?> clazz = joinPoint.getTarget().getClass();
        //获取执行方法的方法名
        String methodName = joinPoint.getSignature().getName();
        Class[] argClass = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();
        //反射获取参数值
        Object[] args = joinPoint.getArgs();
        PersonDTO person = (PersonDTO) args[0];
        if(!permissionMap.containsKey(person.getUserName())){
            return Result.err("暂无该用户！");
        }
        log.info("-----------  clazz:{},methodName:{},argClass:{}",JSONObject.toJSONString(clazz),methodName, JSONObject.toJSONString(argClass));
        log.info("----------- person:{}",JSONObject.toJSONString(person));
        try {
            Method method = clazz.getMethod(methodName, argClass);
            String mapVal = permissionMap.get(person.getUserName());
            //是否含有permission注解
            if(method.isAnnotationPresent(Permission.class)){
                //获取注解对象
                Permission permission = method.getAnnotation(Permission.class);
                log.info("----------------  method:{},permission:{}",JSONObject.toJSONString(method),JSONObject.toJSONString(permission));
                String annoVal = permission.value();
                if (!mapVal.contains(annoVal)){
                    return Result.err("暂无该接口权限！");
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return (Result) joinPoint.proceed();

    }
}
