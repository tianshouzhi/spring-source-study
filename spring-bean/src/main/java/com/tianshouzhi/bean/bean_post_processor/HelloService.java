package com.tianshouzhi.bean.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * Created by tianshouzhi on 2018/7/25.
 */
public class HelloService implements InitializingBean, ApplicationContextAware {
	private String name;

	@Autowired
	private Environment environment;

	private ApplicationContext context;

	public void init() {
		System.out.println("HelloService.init");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("HelloService.postConstruct");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("HelloService.afterPropertiesSet");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return context;
	}
}
