package com.baizhi.cmfz.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/7/9.
 */
@Aspect
public class MyAdvice {
    private void execution(Object p0) {
    }

    @Pointcut("execution(* com.baizhi.cmfz.service.imple.modify*(..)) || execution(* com.baizhi.cmfz.service.imple.remove*(..)) || execution(* com.baizhi.cmfz.service.imple.add*(..)) ")
    public void cut(){

    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp){

        MethodSignature methodSignature=(MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        return null;
    }

}
