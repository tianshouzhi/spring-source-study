package com.tianshouzhi.aop.pointcut;

import org.junit.Test;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;

import java.lang.reflect.Method;

/**
 * Created by tianshouzhi on 2018/8/4.
 */
public class MethodMatcherTest {
	@Test
	public void testAnnotationMethodMatcher() {
		AnnotationMethodMatcher methodMatcher = new AnnotationMethodMatcher(Time.class);
		Method[] methods = ApiService.class.getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			boolean matches = methodMatcher.matches(method, ApiService.class);
			System.out.println(methodName + " : " + matches);
		}
	}

//    @Test
//    public void testJdkRegexpMethodPointcut() {
//        JdkRegexpMethodPointcut
//        Method[] methods = ApiService.class.getDeclaredMethods();
//        for (Method method : methods) {
//            String methodName = method.getName();
//            boolean matches = methodMatcher.matches(method, ApiService.class);
//            System.out.println(methodName + " : " + matches);
//        }
//    }
}
