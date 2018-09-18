package com.tianshouzhi.aop.proxy_factory;

import com.tianshouzhi.aop.HelloService;
import com.tianshouzhi.aop.HelloServiceImpl;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * Created by tianshouzhi on 2018/7/27.
 */
public class ProxyFactoryTest {
	@Test
	public void testProxyFactory() {
		// 1、创建需要被代理的类，称之为目标类
		HelloService target = new HelloServiceImpl();

		// 2、创建ProxyFactory
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target); // 设置被代理的类
		// factory.setInterfaces(ClassUtils.getAllInterfaces(target));//设置针对接口进行代理，其将会使用JDK动态代理
		factory.addAdvice(new CustomMethodBeforeAdvice());// 添加advice增强
		// 3 创建代理类，执行方法
		HelloService proxy = (HelloService) factory.getProxy();
		proxy.hello();
		System.out.println(proxy.getClass());
	}

	@Test
	public void testProxyTargetClass() {
		// 1、创建需要被代理的类，称之为目标类
		HelloService target = new HelloServiceImpl();

		// 2、创建ProxyFactory
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.setInterfaces(ClassUtils.getAllInterfaces(target));
		factory.addAdvice(new CustomMethodBeforeAdvice());

		factory.setProxyTargetClass(true);

		// 3 创建代理类，执行方法
		HelloService proxy = (HelloService) factory.getProxy();
		proxy.hello();
		System.out.println(proxy.getClass());
	}

	@Test
	public void testPreFiltered() {
		ProxyFactory factory = new ProxyFactory();

		HelloServiceImpl target = new HelloServiceImpl();
		factory.setTarget(target);
		// 等价于 factory.setTargetSource(new SingletonTargetSource(target));
		factory.setInterfaces(HelloService.class);
		factory.setPreFiltered(true);
		factory.addAdvice(new CustomMethodBeforeAdvice());

		HelloService proxy = (HelloService) factory.getProxy();
		proxy.hello();
		printProxyInfo(proxy);
	}

	@Test
	public void testOptimize() {
		ProxyFactory factory = new ProxyFactory();

		factory.setTarget(new HelloServiceImpl());
		factory.setInterfaces(HelloService.class);
		factory.setOptimize(true);

		factory.addAdvice(new CustomMethodBeforeAdvice());

		HelloService proxy = (HelloService) factory.getProxy();
		proxy.hello();
		printProxyInfo(proxy);
	}

	@Test
	public void testExposeProxy() {
		ProxyFactory factory = new ProxyFactory();

		factory.setTarget(new HelloServiceImpl());
		factory.setInterfaces(HelloService.class);
		factory.addAdvice(new CustomMethodBeforeAdvice());

		factory.setExposeProxy(true);// 默认为false

		HelloService proxy = (HelloService) factory.getProxy();
		System.out.println("========调用hello方法========");
		proxy.hello();
		System.out.println("========调用helloExposeProxy方法========");
//		proxy.helloExposeProxy();
	}

	@Test
	public void testOpaque() {
		ProxyFactory factory = new ProxyFactory();

		factory.setTarget(new HelloServiceImpl());
		factory.setInterfaces(HelloService.class);
		factory.addAdvice(new CustomMethodBeforeAdvice());

		factory.setOpaque(false);
		factory.setFrozen(true);

		HelloService proxy = (HelloService) factory.getProxy();
		System.out.println("=========第一次调用hello方法==========");
		proxy.hello();// 第一次调用hello方法

		if (proxy instanceof Advised) {
			Advised advised = (Advised) proxy;
			advised.addAdvice(new MethodBeforeAdvice() {
				public void before(Method method, Object[] args, Object target) throws Throwable {
					System.out.println("...代理实例创建后，动态增强...");
				}
			});
		}
		System.out.println("=========第二次调用hello方法==========");
		proxy.hello();
	}

	@Test
	public void testFrozen() {
		ProxyFactory factory = new ProxyFactory();

		factory.setTarget(new HelloServiceImpl());
		factory.setInterfaces(HelloService.class);
		factory.addAdvice(new CustomMethodBeforeAdvice());

		factory.setFrozen(true);//冻结配置

		HelloService proxy = (HelloService) factory.getProxy();
		if(proxy instanceof Advised){
			((Advised) proxy).addAdvice(new MethodBeforeAdvice() {
				public void before(Method method, Object[] args, Object target) throws Throwable {
					System.out.println("...配置冻结后，对代理实例动态增强...");
				}
			});
		}
		proxy.hello();
	}

	@Test
	public void testCglibProxy() {
		ProxyFactory factory = new ProxyFactory();
		factory.setTargetClass(HelloServiceImpl.class);
		factory.addAdvice(new CustomMethodBeforeAdvice());
		HelloService proxy = (HelloService) factory.getProxy();
		proxy.hello();
	}

	public void printProxyInfo(Object proxy) {
		System.out.println("-----------------proxy info---------------------");
		System.out.println("isJdkDynamicProxy=" + AopUtils.isJdkDynamicProxy(proxy));
		System.out.println("isCglibProxy=" + AopUtils.isCglibProxy(proxy));
		System.out.println("proxy class:" + proxy.getClass());
	}
}
