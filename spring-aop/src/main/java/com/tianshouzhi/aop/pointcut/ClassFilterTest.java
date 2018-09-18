package com.tianshouzhi.aop.pointcut;

import org.junit.Test;
import org.springframework.aop.support.RootClassFilter;
import org.springframework.aop.support.annotation.AnnotationClassFilter;

/**
 * Created by tianshouzhi on 2018/8/4.
 */
public class ClassFilterTest {
    @Test
    public void testAnnotationClassFilter(){
        //类上有指定的注解返回true
        AnnotationClassFilter classFilter=new AnnotationClassFilter(Time.class);
        System.out.println(classFilter.matches(ApiService.class));
    }

    @Test
    public void testRootClassFilter(){
        //是指定类的子类返回true
        RootClassFilter classFilter=new RootClassFilter(Object.class);
        System.out.println(classFilter.matches(ApiService.class));
    }

}
