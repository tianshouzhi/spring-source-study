package com.tianshouzhi.aop.proxy_factory;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by tianshouzhi on 2018/7/27.
 */
public class CustomMethodBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("...方法执行前增强...");
	}
}
