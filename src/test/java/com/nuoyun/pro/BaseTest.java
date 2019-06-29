package com.nuoyun.pro;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
	private long start;
	
	@Before
	public void before() {
		System.err.println("-----===== 测试开始 =====-----");
		start = System.nanoTime();
	}
	
	@After
	public void after() {
		System.err.println("-----===== 测试结束，共耗时："+(System.nanoTime()-start)/(1000*1000)+"ms =====-----");
	}
}
