package com.synergyfolks.company.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void com.synergyfolks.company.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(void add*())")
//    @Before("execution(* add*())") // start with add in any class
//    @Before("execution(* add*(com.synergyfolks.company.Account))")  // only this class
//    @Before("execution(* add*(com.synergyfolks.company.Account, ..))") // 2 or more param from particular class
//@Before("execution(* add*(..))") //any parameter from any class
@Before("execution(* com.synergyfolks.company.dao.*.*(..))") //any class & any methodfrom particular package is valid
    public void beforeAddAccountAdvice() {

        System.out.println("=====>>> Executing @Before advice on addAccount()");

    }
}
