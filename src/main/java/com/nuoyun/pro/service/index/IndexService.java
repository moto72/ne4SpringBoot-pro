package com.nuoyun.pro.service.index;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.nuoyun.pro.service.BaseService;

@Service
public class IndexService extends BaseService {
	public String getUsers() {
		List<Map<String, Object>> users = baseService.findList("select * from ny_user");
		return JSON.toJSONString(users);
	}
}
