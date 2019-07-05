package com.nuoyun.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.nuoyun.pro.config.SystemConfig;

/**
 * @Title:  RedisService.java
 * @Package com.nuoyun.pro.service
 * @Description:请使用JedisService来进行Redis的操作。
 * @author: zhangwei
 * @date:   2019-07-05
 * @version V1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
@Service
@Deprecated
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
