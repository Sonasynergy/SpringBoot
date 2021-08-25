package com.synergyfolks.company.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalysticsAspect {

    @Before("com.synergyfolks.company.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalystics(){
        System.out.println("=====>>> Performing API Analystics");
    }
}
