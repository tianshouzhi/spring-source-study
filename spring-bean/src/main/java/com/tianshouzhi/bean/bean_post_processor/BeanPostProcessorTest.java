package com.tianshouzhi.bean.bean_post_processor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianshouzhi on 2018/7/25.
 */
public class BeanPostProcessorTest {
    @Test
    public void testBeanPostProcessor(){
        String configLocation = "bean_post_proccessor/bean_post_proccessor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
    }
}
