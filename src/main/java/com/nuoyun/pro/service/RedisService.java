package com.nuoyun.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.nuoyun.pro.config.SystemConfig;

@Service
public class RedisService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	public void set(String key, String value) {
		stringRedisTemplate.opsForValue().set(SystemConfig.REDIS_PREFIX.concat(key), value);
	}

	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(SystemConfig.REDIS_PREFIX.concat(key));
	}
}
