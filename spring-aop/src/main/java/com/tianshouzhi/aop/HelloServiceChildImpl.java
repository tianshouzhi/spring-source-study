package com.tianshouzhi.aop;

/**
 * Created by tianshouzhi on 2018/7/30.
 */
public class HelloServiceChildImpl extends HelloServiceImpl {
	public void hello() {
		long start = System.currentTimeMillis();
		super.hello();
		long end = System.currentTimeMillis();
		System.out.println("execution time " + (end - start)+" ms!");
	}
}
