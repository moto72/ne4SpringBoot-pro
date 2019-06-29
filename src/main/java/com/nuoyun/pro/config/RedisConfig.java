package com.nuoyun.pro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@ConfigurationProperties(prefix = "spring.redis.jedis.pool")
@Component
@Data
@Slf4j
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String password;

	private int maxActive;
	private int maxIdle;
	private int minIdle;
	
	public JedisPoolConfig getJedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxTotal(maxActive);
		jedisPoolConfig.setMinIdle(minIdle);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(false);
        return jedisPoolConfig;
	}

	@Bean
    public JedisPool getJedisPool(){
		JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 2000, password);
        log.info("JedisPool 注入完成:{}",jedisPoolConfig.toString());
        return jedisPool;
    }

}
