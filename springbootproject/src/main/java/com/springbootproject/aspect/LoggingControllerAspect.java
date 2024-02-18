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
@Order(1)
public class LoggingControllerAspect {


    private static MethodSignature methodSignature;

    @Before("com.springbootproject.aspect.AopExpression.methodWithoutSetterAndGetterInController()")
    public void controllerAspect(JoinPoint joinPoint) {
        methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("=====================================>>>>>> Logging Controller Aspect:START " + methodSignature.toShortString());
        for (Object obj:joinPoint.getArgs()) {
            System.out.println("Method Arguments Received " +obj);
        }
    }

    @AfterThrowing(pointcut = "com.springbootproject.aspect.AopExpression.anyMethodInController()",
            throwing = "controllerException")
    public void afterThrowingController(Throwable controllerException) {
        System.out.println("=====================================>>>>>> Logging Controller Aspect in Method Exception occurred Method " + methodSignature.toShortString()
                +" and Exception is " + controllerException);
    }

    @After("com.springbootproject.aspect.AopExpression.anyMethodInController()")
    public void controllerEndingAspect() {
        System.out.println("=====================================>>>>>> Logging Controller Aspect:END " + methodSignature.toShortString());
    }
}
