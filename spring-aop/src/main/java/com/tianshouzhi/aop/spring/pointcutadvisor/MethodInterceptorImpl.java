package com.tianshouzhi.aop.spring.pointcutadvisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodInterceptorImpl implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(" 环绕增强 :方法前增强");
        // 如果不写这一句话，目标方法就不会执行
        Object result = invocation.proceed();// 目标方法执行
        System.out.println(" 环绕增强 :方法后增强");
        return result;
    }
}
