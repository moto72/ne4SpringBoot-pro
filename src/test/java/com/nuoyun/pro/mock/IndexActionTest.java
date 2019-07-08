package com.nuoyun.pro.mock;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class IndexActionTest extends MockBase {
	@Test
	public void test() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/").param("username", "zhangsan")).andReturn();

		int status = result.getResponse().getStatus(); // 得到返回代码
		String content = result.getResponse().getContentAsString(); // 得到返回结果

		System.err.println(status);
		System.err.println(content);

	}
}
