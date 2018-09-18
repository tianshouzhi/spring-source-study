package com.tianshouzhi.bean.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * Created by tianshouzhi on 2018/7/26.
 */
public class CustomInstantiationAwareBeanPostProcessor extends CustomBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass.isAssignableFrom(HelloService.class)){
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");

//            try {
//                return beanClass.newInstance();
//            } catch (Exception e) {
//                throw new BeanCreationException(e.getMessage(),e);
//            }
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof HelloService){
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if(bean instanceof HelloService) {
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessPropertyValues");

            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues(pvs);
            mutablePropertyValues.add("name","wangxiaoxiao");
            return mutablePropertyValues;
        }
        return pvs;
    }
}

