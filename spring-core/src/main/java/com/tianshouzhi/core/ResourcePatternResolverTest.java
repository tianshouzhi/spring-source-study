package com.tianshouzhi.core;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by tianshouzhi on 2018/8/5.
 */
public class ResourcePatternResolverTest {
	@Test
	public void testClassPathPrefixAndAntPattern() throws IOException {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader);
        //classpath:*.txt
		String locationPattern = ResourceLoader.CLASSPATH_URL_PREFIX + "*.txt";
		Resource[] resources = resolver.getResources(locationPattern);
		for (Resource resource : resources) {
			System.out.println(resource.getClass().getSimpleName() + ":" + resource.getDescription());
		}
	}

	@Test
	public void testClassPathStarPrefixAndAntPattern() throws IOException {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader);
        // classpath*:*.txt
		String locationPattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "*.txt";
		Resource[] resources = resolver.getResources(locationPattern);
		for (Resource resource : resources) {
			System.out.println(resource.getClass().getSimpleName() + ":" + resource.getDescription());
		}
	}
}
