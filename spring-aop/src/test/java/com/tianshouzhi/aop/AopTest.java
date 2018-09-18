package com.tianshouzhi.aop;

import com.tianshouzhi.aop.basic.cglib.CglibProxyFactory;
import com.tianshouzhi.aop.basic.cglib.HelloCglib;
import com.tianshouzhi.aop.basic.jdkproxy.JDKProxyFactory;
import com.tianshouzhi.aop.spring.CrudService;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void testJdkProxy() {
        HelloService proxy = JDKProxyFactory.getProxy(new HelloServiceImpl());
        proxy.hello();
    }

    @Test
    public void testCglib() {
        HelloCglib proxy = CglibProxyFactory.getProxy(HelloCglib.class);
        proxy.hello();
    }

    @Test
    public void testProxyFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("proxy-factory-bean.xml");

        System.out.println("================bean crudService=========================");
        CrudService crudService = context.getBean("crudService", CrudService.class);
        crudService.add();
        crudService.del();
        crudService.update();
        crudService.search();
        System.out.println("isCglibProxy     :" + AopUtils.isCglibProxy(crudService));
        System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(crudService));
        System.out.println("isAopProxy       :" + AopUtils.isAopProxy(crudService));

        System.out.println("================bean crudServiceProxy====================");
        CrudService crudServiceProxy = context.getBean("crudServiceProxy", CrudService.class);
        crudServiceProxy.add();
        crudServiceProxy.del();
        crudServiceProxy.update();
        crudServiceProxy.search();

        System.out.println("isCglibProxy     :" + AopUtils.isCglibProxy(crudServiceProxy));
        System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(crudServiceProxy));
        System.out.println("isAopProxy       :" + AopUtils.isAopProxy(crudServiceProxy));
    }
    @Test
    public void testPointcutAdvisor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("pointcut-advisor.xml");
        CrudService crudService = context.getBean("crudServiceProxy", CrudService.class);
        crudService.add();
        crudService.del();
        crudService.update();
        crudService.search();
    }

    @Test
    public void testAutoProxy(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-name-auto-proxy-creator.xml");
//        CrudService crudService = context.getBean("crudService", CrudService.class);
        HelloService helloService = context.getBean("helloService", HelloService.class);

        helloService.hello();
//
//        crudService.add();
//        crudService.del();
//        crudService.update();
//        crudService.search();
    }

    @Test
    public void testDefaultAdvisorAutoProxyCreator(){
        ApplicationContext context = new ClassPathXmlApplicationContext("default-advisor-autoproxy-creator.xml");
        CrudService crudService = context.getBean("crudService", CrudService.class);
        HelloService helloService = context.getBean("helloService", HelloService.class);

        helloService.hello();

        crudService.add();
        crudService.del();
        crudService.update();
        crudService.search();
    }

    @Test
    public void testAspectJ(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj-annotation.xml");
        CrudService crudService = context.getBean("crudService", CrudService.class);
        crudService.add();
        crudService.del();
        crudService.update();
        crudService.search();
    }
}
