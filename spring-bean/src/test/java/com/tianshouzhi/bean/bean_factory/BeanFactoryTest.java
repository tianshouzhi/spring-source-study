package com.tianshouzhi.bean.bean_factory;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tianshouzhi.bean.bean_post_processor.HelloService;

/**
 * Created by tianshouzhi on 2018/7/23.
 */

public class BeanFactoryTest {

    public void testDemo1(){

    }

    @Test
    public void testBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:bean_factory/beans-factory.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:bean_factory/beans-factory.xml");
        HelloService helloService = context.getBean(HelloService.class);
//        helloService.hello();
    }
}
