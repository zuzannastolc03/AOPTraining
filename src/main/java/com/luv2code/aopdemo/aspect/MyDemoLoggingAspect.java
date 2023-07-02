package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
//    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("=====>>> Performing API analytics");
    }
}
