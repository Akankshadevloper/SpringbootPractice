package com.akankshaluvtocode.aopdemo.aspect;


import com.akankshaluvtocode.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
