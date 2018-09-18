package com.tianshouzhi.bean.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tianshouzhi on 2018/7/23.
 */
public class TimerBeanPostProcessor implements BeanPostProcessor,Ordered{
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

		return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
		      new InvocationHandler() {
			      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			          //方法执行前，记录并打印当前时间
				      long start = System.currentTimeMillis();
					  System.out.println("before execute,current time:"+start);
					  //执行目标类方法，并得到结果
				      Object result = method.invoke(bean, args);
                      //方法执行后，统计并打印执行耗时
				      long end = System.currentTimeMillis();
					  System.out.println("after execute,current time:"+end+",elapse time:"+(end-start)+" ms!");

				      //返回结果
				      return result;
			      }
		      });
	}

	public int getOrder() {
		return 0;
	}
}
