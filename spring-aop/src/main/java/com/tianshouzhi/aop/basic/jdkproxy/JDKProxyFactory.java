package com.tianshouzhi.aop.basic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    public static <T> T getProxy(Class<T> clazz) {
        try {
            ClassLoader classLoader = clazz.getClassLoader();
            Class<?>[] interfaces = clazz.getInterfaces();
            TimeInvocationHandler invocationHandler = new TimeInvocationHandler(clazz.newInstance());

            return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        } catch (Exception e) {
            throw new RuntimeException("create proxy for  "+clazz.getName()+" failed",e);
        }
    }

    private static class TimeInvocationHandler implements InvocationHandler {
        private Object target;

        public TimeInvocationHandler(Object target) {
            this.target = target;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("...方法执行前增强...");
            Object result = method.invoke(target, args);
            System.out.println("...方法执行后增强...");
            return result;
        }
    }
}
