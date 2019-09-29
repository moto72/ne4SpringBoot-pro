package com.nuoyun.pro.action.index;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuoyun.pro.action.BaseAction;
import com.nuoyun.pro.service.index.IndexService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
@Api(value = "首页测试类")
public class IndexAction extends BaseAction {
	@Autowired
	private IndexService indexService;
	
	@RequestMapping()
	public String defaultView(String username) {
		
		if(StringUtils.isEmpty(username)) {
			username = "";
		}
		
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
	@ApiOperation(value = "用户退出", notes = "用户通过token以及uid退出登陆状态")
	public String logout() {
		return "GoodBye";
	}

}
