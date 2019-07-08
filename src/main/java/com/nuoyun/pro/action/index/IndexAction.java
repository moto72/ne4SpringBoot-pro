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
	
	@RequestMapping()
	public String defaultView(String username) {
		return "welcome to index ".concat(username);
	}
	
	@GetMapping("index")
	public String index() {
		return indexService.getUsers();
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
