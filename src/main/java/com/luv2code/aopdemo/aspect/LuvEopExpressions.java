package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvEopExpressions {
    //    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
//    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
