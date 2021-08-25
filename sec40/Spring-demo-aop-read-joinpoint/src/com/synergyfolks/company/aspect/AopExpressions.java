package com.synergyfolks.company.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    @Pointcut("execution(* com.synergyfolks.company.dao.*.*(..))")
    public void forDaoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.synergyfolks.company.dao.*.get*(..))")
    public void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.synergyfolks.company.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
