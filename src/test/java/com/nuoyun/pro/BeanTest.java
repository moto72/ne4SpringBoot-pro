package com.nuoyun.pro;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nuoyun.pro.config.RedisConfig;

public class BeanTest extends BaseTest {
	@Autowired
	private RedisConfig redisConfig;
	@Test
	public void test() {
		System.err.println(redisConfig.getPassword());
		System.err.println(redisConfig.getJedisPoolConfig().toString());
		System.err.println(redisConfig.getJedisPool());
		System.err.println(redisConfig.getJedisPoolConfig().toString());
	}
}
