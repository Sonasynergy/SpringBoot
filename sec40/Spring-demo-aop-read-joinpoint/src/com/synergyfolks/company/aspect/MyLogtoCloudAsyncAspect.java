package com.synergyfolks.company.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogtoCloudAsyncAspect {


    @Before("com.synergyfolks.company.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logtoCloudAsynch(){
        System.out.println("=====>>> Performing logtoCloudAsynch");
    }
}
