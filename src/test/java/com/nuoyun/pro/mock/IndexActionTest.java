package com.nuoyun.pro.mock;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.alibaba.fastjson.JSON;

public class IndexActionTest extends MockBase {
	@Test
	public void test() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/").param("username", "zhangsan").contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = result.getResponse().getStatus(); // 得到返回代码
		String content = result.getResponse().getContentAsString(); // 得到返回结果
		
		System.err.println(status);
		System.err.println(result.getHandler());
		System.err.println(result.getInterceptors());
		System.err.println(content);

	}
}
