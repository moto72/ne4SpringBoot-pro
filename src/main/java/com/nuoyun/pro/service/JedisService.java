package com.nuoyun.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuoyun.pro.config.SystemConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * @Title:  JedisService.java
 * @Package com.nuoyun.pro.service
 * @Description:redis set get service , 在set方法中，如果成功返回字符串"OK"，如果不成功则返回null。
 * @author: zhangwei
 * @date:   2019-07-05
 * @version V1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
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
	
	public String set(String key, String value, Long expireSecond) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value, "NX", "EX", expireSecond);
		jedis.close();
		return result;
	}

}
