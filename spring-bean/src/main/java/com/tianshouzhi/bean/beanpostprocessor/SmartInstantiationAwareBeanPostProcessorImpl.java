package com.tianshouzhi.bean.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

public class SmartInstantiationAwareBeanPostProcessorImpl implements SmartInstantiationAwareBeanPostProcessor {
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("SmartInstantiationAwareBeanPostProcessorImpl.predictBeanType");
        return beanClass;
    }

    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("SmartInstantiationAwareBeanPostProcessorImpl.determineCandidateConstructors");
        return new Constructor[0];
    }

    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("SmartInstantiationAwareBeanPostProcessorImpl.getEarlyBeanReference");
        return null;
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        return false;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        return null;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization");
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization");
        return null;
    }
}
