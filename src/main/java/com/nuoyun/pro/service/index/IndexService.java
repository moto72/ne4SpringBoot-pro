package com.nuoyun.pro.service.index;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.nuoyun.pro.service.BaseService;
import com.nuoyun.pro.service.JedisService;
import com.nuoyun.pro.service.RedisService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IndexService extends BaseService {
	@Autowired
	private JedisService jedisService;
	
	public String getUsers() {
		
		if(jedisService.get("ny_user")==null) {
			log.debug("查询用户列表，缓存中没有，查询数据库，并存入缓存");
			List<Map<String, Object>> users = baseService.findList("select * from ny_user");
			jedisService.set("ny_user", JSON.toJSONString(users));
		}
		
		return jedisService.get("ny_user");
	}
}
