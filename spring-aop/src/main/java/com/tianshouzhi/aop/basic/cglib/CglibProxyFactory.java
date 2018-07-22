package com.tianshouzhi.aop.basic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory{
    public static <T> T getProxy(Class<T> clazz) {
        //创建代理的核心对象
        Enhancer enhancer = new Enhancer();
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("...方法执行前增强...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("...方法执行后增强...");
                return result;
            }
        });
        //返回代理子类的对象
        return (T) enhancer.create();
    }
}
