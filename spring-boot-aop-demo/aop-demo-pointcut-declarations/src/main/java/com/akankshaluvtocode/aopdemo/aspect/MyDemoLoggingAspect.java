package com.akankshaluvtocode.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Pointcut("execution(* com.akankshaluvtocode.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>>> Executing @Before advice on method");
    }


}
