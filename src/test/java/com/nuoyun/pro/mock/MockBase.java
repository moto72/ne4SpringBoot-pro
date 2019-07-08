package com.nuoyun.pro.mock;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @Title:  MockBase.java
 * @Package com.nuoyun.pro.mock
 * @Description: Mock Test
 * @author: zhangwei
 * @date:   2019-07-08
 * @version V1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockBase {
	@Autowired
	protected MockMvc mockMvc;
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
