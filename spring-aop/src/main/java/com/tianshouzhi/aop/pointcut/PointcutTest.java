package com.tianshouzhi.aop.pointcut;

import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * Created by tianshouzhi on 2018/8/4.
 */
public class PointcutTest {
    @Test
    public void testJdkRegexpMethodPointcut(){
        JdkRegexpMethodPointcut pointcut=new JdkRegexpMethodPointcut();
        pointcut.setPattern("com.tianshouzhi.aop.*");
        boolean canApply = AopUtils.canApply(pointcut, ApiService.class);
        System.out.println(canApply);
    }

    @Test
    public void testAnnotationMatchingPointcut(){
        //目标类，必须类上有@Time注解，且至少有一个方法上添加了@Time注解才，返回true
        AnnotationMatchingPointcut classMethodPointcut=new AnnotationMatchingPointcut(Time.class, Time.class);
        boolean canApply = AopUtils.canApply(classMethodPointcut, ApiService.class);
        System.out.println(canApply);

        //目标类，类上有@Time注解，即返回true
        AnnotationMatchingPointcut classPointcut=new AnnotationMatchingPointcut(Time.class);
        canApply = AopUtils.canApply(classMethodPointcut, ApiService.class);
        System.out.println(canApply);

        //目标类，目标类任意一个方法上添加了@Time注解才返回true
        AnnotationMatchingPointcut methodPointcut=new AnnotationMatchingPointcut(null,Time.class);
        canApply = AopUtils.canApply(classMethodPointcut, ApiService.class);
        System.out.println(canApply);
    }

    @Test
    public void testComposablePointcut(){
        //类上，或者至少有一个方法上存在@Time注解，则返回true
        AnnotationMatchingPointcut classPointcut = AnnotationMatchingPointcut.forClassAnnotation(Time.class);
        AnnotationMatchingPointcut methodPointcut = AnnotationMatchingPointcut.forMethodAnnotation(Time.class);
        ComposablePointcut composablePointcut=new ComposablePointcut(classPointcut);
        composablePointcut.union(methodPointcut);
        boolean canApply = AopUtils.canApply(composablePointcut, ApiService.class);
        System.out.println(canApply);
    }
}
