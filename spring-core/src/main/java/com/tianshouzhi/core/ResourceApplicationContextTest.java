package com.tianshouzhi.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by tianshouzhi on 2018/8/4.
 */
public class ResourceApplicationContextTest {
    public static void main(String[] args) throws IOException {
        String location="test.txt";
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource(location);
        System.out.println(resource.getInputStream());
    }
}
