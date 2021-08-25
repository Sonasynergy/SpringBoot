package com.synergyfolks.company.aspect;


import com.synergyfolks.company.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.synergyfolks.company.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try{
        result=theProceedingJoinPoint.proceed();}
        catch (Exception e){
            myLogger.warning(e.getMessage());
//            result="There is no problem now";
            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;

    }

    @After("execution(* com.synergyfolks.company.dao.AccountDAO.findAccount(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint){

        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterFinal on method: " + method);
    }

    @AfterThrowing(
            pointcut="execution(* com.synergyfolks.company.dao.AccountDAO.findAccount(..))",
            throwing="theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {

        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        myLogger.info("\n=====>>> The exception is: " + theExc);

    }

    @AfterReturning(
            pointcut = "execution(* com.synergyfolks.company.dao.AccountDAO.findAccount(..))",
            returning = "results"
    )
    public void afterReturningFindAccountAdvice(JoinPoint thejoinPoint, List<Account> results){

        String method = thejoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);

        myLogger.info("\n=====>>> result is: " + results);

        convertAccountNamesToUpperCase(results);

        myLogger.info("\n=====>>> result is: " + results);

    }

    private void convertAccountNamesToUpperCase(List<Account> results) {
        for (Account tempAccount : results){
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.synergyfolks.company.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        myLogger.info("Method: " + methodSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            myLogger.info((String) tempArg);

            if (tempArg instanceof Account) {

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                myLogger.info("account name: " + theAccount.getName());
                myLogger.info("account level: " + theAccount.getLevel());

            }
        }
    }
}
