package com.higgsup.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created on 19-Sep-17.
 * OwnerBy anhvu
 */
@Aspect
@Component
public class ServiceMonitor {

    @AfterReturning("execution(* com.higgsup.app.service.*.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }

    @Before("execution(* com.higgsup.app.service.*.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("Completed: " + joinPoint);
    }

}