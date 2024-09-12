package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations

    // Pointcut for controller package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    // Pointcut for service package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    // Pointcut for DAO package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    // Combine pointcuts: controller, service, and DAO
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before (JoinPoint theJoinPoint) {
        //display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before : calling method: " + theMethod);

        //display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        //loop through the argument
        for (Object tempArg : args) {
            myLogger.info("======>> argument: " + tempArg);
        }

    }

    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()" ,
            returning = "theResult")
    public void afterReturning(JoinPoint theJointPoint, Object theResult){

        //display method we are returning from
        String theMethod = theJointPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning : calling method: " + theMethod);

        // display data returned
        myLogger.info("=====>> result : " + theResult);

    }
}

