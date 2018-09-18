package com.tianshouzhi.core;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.*;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by tianshouzhi on 2018/8/4.
 */
public class ResourceTest {
	@Test
	public void testURL() throws Exception {
		UrlResource resource = new UrlResource("http://ip.taobao.com/service/getIpInfo.php?ip=61.173.27.189");
		if (resource.isReadable()) {
			InputStream in = resource.getInputStream();
			System.out.println(IOUtils.toString(in, Charset.defaultCharset()));
		}
	}

	@Test
	public void testClassPathResources() throws IOException {
		ClassPathResource resource = new ClassPathResource("test.txt");
		if (resource.isReadable()) {
			InputStream in = resource.getInputStream();
			System.out.println(IOUtils.toString(in, Charset.defaultCharset()));
		}
	}

	@Test
	public void testFileSystemResource() throws Exception {
		String filePath = "/Users/tianshouzhi/workspace/spring-source-study/spring-core/src/main/resources/test.txt";
		FileSystemResource resource = new FileSystemResource(filePath);
		if (resource.isWritable()) {
			// 每次都会获取到一个新的输出流
			OutputStream os = resource.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			bw.write("now i am a file resource");
			bw.flush();
		}
	}

	@Test
	public void testInputStreamResource() throws Exception {
		String filePath = "/Users/tianshouzhi/workspace/spring-source-study/spring-core/src/main/resources/test.txt";
		InputStream is = new FileInputStream(filePath);
		InputStreamResource resource = new InputStreamResource(is);
		//对于InputStreamResource而言，其getInputStream()方法只能调用一次，继续调用将抛出异常。
		InputStream target = resource.getInputStream();   //返回的就是构件时的那个InputStream
		//is将在printContent方法里面进行关闭
		System.out.println(IOUtils.toString(target, Charset.defaultCharset()));
	}

	@Test
	public void testByteArrayResource() throws IOException {
		   ByteArrayResource resource = new ByteArrayResource("Hello".getBytes());
		   //ByteArrayInputStream()
		  System.out.println(IOUtils.toString(resource.getInputStream(), Charset.defaultCharset()));
	}
}
