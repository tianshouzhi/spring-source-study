package com.tianshouzhi.bean.bean_post_processor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianshouzhi on 2018/7/26.
 */
public class SmartInstantiationAwareBeanPostProcessorTest {
    @Test
    public void testSmartInstantiationAwareBeanPostProcessor(){
        String configLocation = "bean_post_proccessor/smart_instantiation_aware_bean_post_processor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
    }
}
