package com.tianshouzhi.bean.bean_post_processor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianshouzhi on 2018/7/26.
 */
public class InstantiationAwareBeanPostProcessorTest {
    @Test
    public void testInstantiationAwareBeanPostProcessor(){
        String configLocation = "bean_post_proccessor/instantiation_aware_bean_post_proccessor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
    }
    @Test
    public void testPostProcessBeforeInstantiation(){
        String configLocation = "bean_post_proccessor/instantiation_aware_bean_post_proccessor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println("name:"+helloService.getName());
        System.out.println("env:"+helloService.getEnvironment());
        System.out.println("context:"+helloService.getApplicationContext());
    }
}
