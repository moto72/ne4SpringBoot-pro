package com.nuoyun.pro;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nuoyun.pro.service.JedisService;

public class RedisTest extends BaseTest {
	@Autowired
	private JedisService jedisService;
	
	
	public void test1() {
		System.err.println(jedisService.get("zhangwei-test"));
	}
	
	@Test
	public void test() {
		String result = jedisService.set("testex", "zhangwei",10l);
		System.err.println(String.valueOf(result).contentEquals("OK"));
		System.err.println(jedisService.set("testex", "zhangwei"));
		
		
	}
}
