package com.atguigu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Slf4j
public class ExceptionAspect {
    @AfterThrowing(value = "execution(* com.atguigu..*.*(..))", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        log.error("service {} exception.", joinPoint.getSignature().getName(), exception);
    }
    @Before("execution(* com.atguigu..*.*(..))")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("{} start ========================>", name);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            String value = null;
            if (arg != null) {
                value = arg.toString();
                if (value.length() > 500) {
                    value = value.substring(0, 500);
                }
            }
            log.info("{}() arg value: {}", name, value);
        }
        log.info("{} end <========================", name);
    }
}
