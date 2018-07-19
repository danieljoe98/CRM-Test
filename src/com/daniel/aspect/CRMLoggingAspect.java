package com.daniel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger myLogger =
            Logger.getLogger(getClass().getName());

    //setup pointcut declaration
    @Pointcut("execution(* com.daniel.controller.*.*(..))")
    private void forControllerPackage(){

    }

    //do the same for service and dao
    @Pointcut("execution(* com.daniel.service.*.*(..))")
    private void forServicePackage(){

    }

    @Pointcut("execution(* com.daniel.dao.*.*(..))")
    private void forDAOPackage(){

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){

    }

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //dispaly method we are calling
        String theMethod =
                joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: "+ theMethod);
        //display the args to the method

        //get the args
        Object[] args = joinPoint.getArgs();

        //loop thru and display the args
        for (Object tempArg : args){
            myLogger.info("====>> argument: "+ tempArg);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        //display method we are returning from
        String theMethod =
                joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning: calling method: "+ theMethod);

        //display data returned
        myLogger.info("=====>> result: "+ result);

    }


}
