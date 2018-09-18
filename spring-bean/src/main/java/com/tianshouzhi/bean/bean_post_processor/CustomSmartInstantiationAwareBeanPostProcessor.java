package com.tianshouzhi.bean.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

public class CustomSmartInstantiationAwareBeanPostProcessor extends CustomInstantiationAwareBeanPostProcessor implements
        SmartInstantiationAwareBeanPostProcessor {

    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass.isAssignableFrom(HelloService.class)){
            System.out.println("CustomSmartInstantiationAwareBeanPostProcessor.predictBeanType");
        }

        return null;
    }

    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass.isAssignableFrom(HelloService.class)){
            System.out.println("CustomSmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors");
        }
        return null;
    }

    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAssignableFrom(HelloService.class)){
            System.out.println("CustomSmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference");
        }
        return null;
    }
}
