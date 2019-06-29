package com.nuoyun.pro.action.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuoyun.pro.action.BaseAction;
import com.nuoyun.pro.service.JedisService;
import com.nuoyun.pro.service.index.IndexService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
public class IndexAction extends BaseAction {
	@Autowired
	private IndexService indexService;
	@Autowired
	private JedisService jedisService;
	
	@GetMapping("index")
	public String index() {
		log.debug("");
		if(jedisService.get("userList")==null) {
			System.err.println("查询数据库");
			jedisService.set("userList", indexService.getUsers());
		}
		
		return jedisService.get("userList");
	}
	
	@GetMapping("login")
	public String login() {
		return "this is login";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "GoodBye";
	}
	
}
