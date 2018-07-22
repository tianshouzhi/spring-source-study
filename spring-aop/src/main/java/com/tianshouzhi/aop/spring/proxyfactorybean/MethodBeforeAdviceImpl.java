package com.tianshouzhi.aop.spring.proxyfactorybean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {
    //method，目标方法
    //args ，方法参数
    //target ，目标对象
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System. out.println (" 前置增强 ");
    }
}
