package com.nuoyun.pro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.tmsps.ne4weixin.config.WxConfig;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title:  WeiXinConfig.java
 * @Package com.nuoyun.pro.system.config
 * @Description: 用于单微信用户版本，如果需要多用户需要独立每个商户的信息
 * @author: zhangwei
 * @date:   2020-03-09
 * @version  v1.0
 * @Copyright: 2020 nuoyun All rights reserved.
 */
@Configuration
@Getter
@Setter
public class WeiXinConfig{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@Value("${weixin.AppID}")
	private String AppID;
	@Value("${weixin.AppSecret}")
	private String AppSecret;
	@Value("${weixin.Token}")
	private String Token;
	@Value("${weixin.EncodingAESKey}")
	private String EncodingAESKey;
	@Value("${weixin.isSafe}")
	private boolean isSafe;
	
	@Bean
	public WxConfig getWxConfig() {
		WxConfig wxConfig = new WxConfig(AppID, EncodingAESKey, AppID, isSafe, Token);
		return wxConfig;
		
	}
	
}
