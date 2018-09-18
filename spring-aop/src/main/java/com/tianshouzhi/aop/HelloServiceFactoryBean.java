package com.tianshouzhi.aop;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tianshouzhi on 2018/7/31.
 */
public class HelloServiceFactoryBean implements FactoryBean<HelloService>{
    public HelloService getObject() throws Exception {
        return (HelloService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{HelloService.class}, new
                InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                return null;
            }
        });
    }

    public Class<HelloService> getObjectType() {
        return HelloService.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
