package com.tianshouzhi.bean.bean_post_processor;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianshouzhi on 2018/7/23.
 */

public class SleepServiceImpl implements SleepService {

	public void sleep(int milliseconds) throws InterruptedException {
		System.out.println("execute sleep method,sleep " + milliseconds + " milliseconds");
		TimeUnit.MILLISECONDS.sleep(milliseconds);
	}
}
