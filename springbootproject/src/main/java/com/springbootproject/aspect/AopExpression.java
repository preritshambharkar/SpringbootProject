package com.springbootproject.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpression {

    @Pointcut("execution(* com.springbootproject.controller.*.*(..))")
    public void anyMethodInController() {}

    @Pointcut("execution(* com.springbootproject.*.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.springbootproject.*.*.get*(..))")
    public void getter() {}

    @Pointcut("anyMethodInController() && !(setter() || getter())")
    public void methodWithoutSetterAndGetterInController() {}

    @Pointcut("execution(* com.springbootproject.service.*.*(..))")
    public void anyMethodInService() {}

    @Pointcut("execution(* com.springbootproject.dao.*.*(..))")
    public void anyMethodInDao() {}
}
