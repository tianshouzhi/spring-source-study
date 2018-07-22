package com.tianshouzhi.aop.spring.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectJXmlImpl {
    // 前置增强
    public void before() {
        System.out.println(" 前置增强 ....");
    }

    // 后置增强 (返回值 )
    public void afterReturning(Object returnVal) {
        System.out.println(" 后置增强 : 返回值" + returnVal);
    }

    // 环绕增强

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(" 环绕前增强 ...");
        Object result = proceedingJoinPoint.proceed();
        System.out.println(" 环绕后增强 ...");
        return result;
    }

    // 抛出增强 (注意程序中没有出现异常的时候，这段代码不会执行 )
    public void afterThrowing(Throwable e) {
        System.out.println(" 发生了异常，原因是 :" + e.getMessage());
    }

    // 最终通知，无论是否发生异常都执行 ( 是每一个方法结束后都会执行 )
    public void after() {
        System.out.println(" 最终通知 ...");
    }
}
