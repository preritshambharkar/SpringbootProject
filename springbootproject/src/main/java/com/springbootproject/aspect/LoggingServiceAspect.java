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
@Order(2)
public class LoggingServiceAspect {

    private static MethodSignature methodSignature;

    @Before("com.springbootproject.aspect.AopExpression.anyMethodInService()")
    public void serviceAspect(JoinPoint joinPoint) {
        methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("=====================================>>>>>> Logging service Aspect:START " + methodSignature.toShortString());
        for (Object obj: joinPoint.getArgs()) {
            System.out.println("Method Arguments Received " + obj);
        }

    }

    @AfterThrowing(pointcut = "com.springbootproject.aspect.AopExpression.anyMethodInService()",
            throwing = "serviceException")
    public void afterThrowingService(Throwable serviceException) {
        System.out.println("=====================================>>>>>> Logging service Aspect Exception occurred Method "+ methodSignature.toShortString()
                +" Exception is " + serviceException);
    }

    @After("com.springbootproject.aspect.AopExpression.anyMethodInService()")
    public void serviceEndingAspect() {
        System.out.println("=====================================>>>>>> Logging service Aspect:END " + methodSignature.toShortString());
    }

}
