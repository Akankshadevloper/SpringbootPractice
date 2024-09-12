package com.akankshaluvtocode.aopdemo.aspect;


import com.akankshaluvtocode.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.akankshaluvtocode.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
           ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        //print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method
        Object result = null;
        try{
            result= theProceedingJoinPoint.proceed();
        }
        catch (Exception exc){

            //log the exception
            System.out.println(exc.getMessage());

            //rethrow exception
            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====>>> Duration: " + duration/1000.0 + " seconds");


        return result;
    }

    @After("execution(* com.akankshaluvtocode.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.akankshaluvtocode.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJointPoint , Throwable theExc){

        //print out which method we are advising on
        String method = theJointPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);


        //log the exception
        System.out.println("\n=====>>> The exception is :: " + theExc);

    }

    //add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.akankshaluvtocode.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJointPoint , List<Account> result) {

        //print out which method we are advising on
        String method = theJointPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        //print out the results of the method call
        System.out.println("\n=====>>> result is : " + result);

        //lets post-process the data ... let modify it

        //convert the account names to uppercase

        convertAccountNameToUpperCase(result);
        System.out.println("\n=====>>> result is : " + result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        //loop through the account
        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            //update the name of the account
            tempAccount.setName(theUpperName);
        }
    }


    @Before("com.akankshaluvtocode.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        //loop through args
        for (Object tempArgs : args) {
            System.out.println(tempArgs);

            if (tempArgs instanceof Account){

                // downcast and print account specific stuff
                Account theAccount = (Account) tempArgs;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }


}
