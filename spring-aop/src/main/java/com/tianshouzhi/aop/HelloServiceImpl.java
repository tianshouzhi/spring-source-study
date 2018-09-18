package com.tianshouzhi.aop;

import org.springframework.aop.framework.AopContext;

public class HelloServiceImpl implements HelloService{
    public void hello() {
        System.out.println("HelloServiceImpl.hello");
    }

    public void helloExposeProxy() {
        System.out.println("HelloServiceImpl.helloExposeProxy");
        HelloService proxy = (HelloService) AopContext.currentProxy();
        proxy.hello();
    }
}
