package com.tianshouzhi.aop;

/**
 * Created by tianshouzhi on 2018/7/30.
 */
public class HelloServiceWrapper implements HelloService{

    private HelloService delegate;

    public HelloServiceWrapper(HelloService delegate) {
        this.delegate = delegate;
    }

    public void hello() {
        long start = System.currentTimeMillis();
        delegate.hello();
        long end = System.currentTimeMillis();
        System.out.println("execution time " + (end - start)+" ms!");
    }
}
