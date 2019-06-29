package com.nuoyun.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title:  AppProStarter.java
 * @Package com.nuoyun.pro
 * @Description: 工程启动类
 * @author: zhangwei
 * @date:   2019-06-28
 * @version V1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
@SpringBootApplication(scanBasePackages = {"com.nuoyun.pro","com.tmsps.ne4spring.base"})
@Slf4j
public class AppProStarter {
	public static void main(String[] args) {
		SpringApplication.run(AppProStarter.class, args);
		log.info("========== Nuoyun Pro 服务启动完成 ==========");
	}
}
