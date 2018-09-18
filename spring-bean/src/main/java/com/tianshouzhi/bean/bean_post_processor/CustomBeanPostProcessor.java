package com.tianshouzhi.bean.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by tianshouzhi on 2018/7/25.
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
	//bean相关初始化方法被回调之前执行
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//仅HelloService进行后处理
		if (bean instanceof HelloService) {
			HelloService helloService = (HelloService) bean;
			//获取通过<property>属性配置的name值
			String name = helloService.getName();
			//通过@Autowired注解注入的Environment，并通过其获得os.name
			String env = null;
			if (helloService.getEnvironment() != null) {
				env = helloService.getEnvironment().getClass().getSimpleName();
			}
			String contextClass = null;
			if (helloService.getApplicationContext() != null) {
				contextClass = helloService.getApplicationContext().getClass().getSimpleName();
			}
			//打印，以验证在postProcessBeforeInitialization方法执行之前，bean的属性值已经被设置过了
			System.out.println("bean properties: name="+ name + ",env=" + env+",context="+ contextClass);
			//打印当前方法执行信息
			System.out.println("CustomBeanPostProcessor.postProcessBeforeInitialization");
		}
		return bean;
	}
	//bean相关初始化方法被回调之后执行
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof HelloService) {
			System.out.println("CustomBeanPostProcessor.postProcessAfterInitialization");
		}
		return bean;
	}
}
