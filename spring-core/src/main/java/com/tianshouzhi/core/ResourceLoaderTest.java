package com.tianshouzhi.core;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

/**
 * Created by tianshouzhi on 2018/8/4.
 */
public class ResourceLoaderTest {
    @Test
    public void testClasspathPrefix(){
        String location = ResourceUtils.CLASSPATH_URL_PREFIX + "test.txt";//classpath:test.txt
        ResourceLoader resourceLoader=new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        System.out.println(resource.getClass().getSimpleName()+":"+resource.getDescription());
    }

    @Test
    public void testHttpPrefix() throws IOException {
        String location = "http://ip.taobao.com/service/getIpInfo.php?ip=61.173.27.189";//classpath:test.txt
        ResourceLoader resourceLoader=new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        System.out.println(resource.getClass().getSimpleName()+":"+resource.getDescription());
    }

    @Test
    public void testNoPrefix(){
        String location = "test.txt";
        ResourceLoader resourceLoader=new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        System.out.println(resource.getClass().getSimpleName()+":"+resource.getDescription());
    }

    @Test
    public void testCustomProtocolResolver() throws IOException {
        DefaultResourceLoader resourceLoader=new DefaultResourceLoader();

        String location = "/Users/tianshouzhi/workspace/spring-source-study/spring-core/src/main/resources/test.txt";
        Resource resource = resourceLoader.getResource(location);
        System.out.println(resource.getInputStream());
        System.out.println(resource.getClass().getSimpleName()+":"+resource.getDescription());
    }
}
