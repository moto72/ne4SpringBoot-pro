package com.nuoyun.pro;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nuoyun.pro.service.JedisService;
import com.nuoyun.pro.service.RedisService;

public class RedisTest extends BaseTest {
	@Autowired
	private RedisService redisService;
	@Autowired
	private JedisService jedisService;
	
	@Test
	public void test() {
		jedisService.set("zhangwei-test", "zhangwei");
		int i = 0;
		while (i!=-1) {
			System.err.println(redisService.get("zhangwei-test"));
			System.err.println(jedisService.get("zhangwei-test"));
		}
	}
}
