package com.nuoyun.pro;

import org.junit.Test;

public class PasswordTest{
	@Test
	public void test() {
		try {
			System.err.println(com.alibaba.druid.filter.config.ConfigTools.encrypt("root"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
