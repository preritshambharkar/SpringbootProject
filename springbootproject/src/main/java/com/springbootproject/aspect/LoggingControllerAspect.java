package com.springbootproject.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingControllerAspect {
    @Before("com.springbootproject.aspect.AopExpression.methodWithoutSetterAndGetterInController()")
    public void controllerAspect() {
        System.out.println("=========================================================>>>>>> Logging Controller Aspect");
    }
}
