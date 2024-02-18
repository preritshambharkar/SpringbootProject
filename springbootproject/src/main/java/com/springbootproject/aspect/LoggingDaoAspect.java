package com.springbootproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingDaoAspect {

    private static MethodSignature methodSignature;

    @Before("com.springbootproject.aspect.AopExpression.anyMethodInDao()")
    public void daoAspect(JoinPoint joinPoint) {
        methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("=====================================>>>>>> Logging DataAccessObject Aspect:START " + methodSignature.toShortString());
        Object args[] = joinPoint.getArgs();
        for (Object obj:args) {
            System.out.println("Method arguments received "+obj);
        }
    }

    @AfterThrowing(pointcut = "com.springbootproject.aspect.AopExpression.anyMethodInDao()",
        throwing = "exceptionDao")
    public void afterThrowingDao(Throwable exceptionDao){
        System.out.println("=====================================>>>>>> Logging DataAccessObject Aspect Exception occurred Method " + methodSignature.toShortString()
            +" Exception is " + exceptionDao);
    }

    @After("com.springbootproject.aspect.AopExpression.anyMethodInDao()")
    public void daoEndingAspect() {
        System.out.println("=====================================>>>>>> Logging DataAccessObject Aspect:END " + methodSignature.toShortString());
    }

}
