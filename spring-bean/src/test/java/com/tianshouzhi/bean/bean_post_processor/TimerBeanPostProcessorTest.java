package com.tianshouzhi.bean.bean_post_processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianshouzhi on 2018/7/23.
 */
public class TimerBeanPostProcessorTest {
	public static void main(String[] args) throws InterruptedException {

		ApplicationContext context = new ClassPathXmlApplicationContext(
		      "bean_post_proccessor/bean_post_proccessor_proxy.xml");

		SleepService sleepService = context.getBean(SleepService.class);

		sleepService.sleep(2000);

    }
}
