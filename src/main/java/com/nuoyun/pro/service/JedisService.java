package com.nuoyun.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuoyun.pro.config.SystemConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisService {
	@Autowired
	private JedisPool jedisPool;

	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(SystemConfig.REDIS_PREFIX.concat(key), value);
		jedis.close();
		return result;
	}

	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String value = jedis.get(SystemConfig.REDIS_PREFIX.concat(key));
		jedis.close();
		return value;
	}

}
