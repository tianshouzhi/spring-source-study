package com.tianshouzhi.aop.spring.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJAnnotationImpl {
    //前置增强
    @Before("execution(* com.tianshouzhi.aop.spring.CrudServiceImpl.add(..))")
    public void before1 (){
        System. out.println (" 前置增强 1....");
    }

    @Before("execution(* com.tianshouzhi.aop.spring.CrudServiceImpl.*(..))")
    public void before2 (){
        System. out.println (" 前置增强 2....");
    }
}
