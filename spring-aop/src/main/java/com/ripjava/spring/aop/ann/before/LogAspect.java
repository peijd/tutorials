package com.ripjava.spring.aop.ann.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.ripjava.spring.aop.ann.services.EmployeeManager..*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        System.out.println("LogAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.ripjava.spring.aop.ann.services.EmployeeManager.getEmployeeById(..))")
    public void logBeforeGetEmployee(JoinPoint joinPoint) {
        System.out.println("LogAspect.logBeforeGetEmployeeById() : " + joinPoint.getSignature().getName());
    }
}