package com.nuoyun.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.nuoyun.pro.config.RedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisService {
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private RedisConfig redisConfig;


	@Bean
	public JedisPool jedisPool() {
		return redisConfig.getJedisPool();
	}
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String value = jedis.get(key);
		jedis.close();
		return value;
	}
	
	public String info() {
		Jedis jedis = jedisPool.getResource();
		return jedis.info();
	}
}
