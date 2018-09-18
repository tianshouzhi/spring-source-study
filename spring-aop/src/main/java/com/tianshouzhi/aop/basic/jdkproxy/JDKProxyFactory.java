package com.tianshouzhi.aop.basic.jdkproxy;

import com.tianshouzhi.aop.HelloServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {
	public static <T> T getProxy(final T target) {
		try {
			return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
					new InvocationHandler() {
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("...方法执行前增强...");
					Object result = method.invoke(target, args);
					System.out.println("...方法执行后增强...");
					return result;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("create proxy for  " + target.getClass().getName() + " failed", e);
		}
	}

	/*
	 * 将根据类信息 动态生成的二进制字节码保存到硬盘中， 默认的是clazz目录下 params :clazz 需要生成动态代理类的类 proxyName : 为动态生成的代理类的名称
	 */
	public static void generateProxyClassFile(Class<?> clazz) {
		// 根据类信息和提供的代理类名称，生成字节码
        String proxyName=clazz.getSimpleName()+"Proxy";
		byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
		String paths = clazz.getResource(".").getPath();
		System.out.println(paths);
		FileOutputStream out = null;

		try {
			// 保留到硬盘中
			out = new FileOutputStream(paths + proxyName + ".class");
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException ignore) {
			}
		}
	}

    public static void main(String[] args) {
        JDKProxyFactory.generateProxyClassFile(HelloServiceImpl.class);
    }
}
