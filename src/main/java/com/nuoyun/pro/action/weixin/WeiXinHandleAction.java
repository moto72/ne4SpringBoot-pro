package com.nuoyun.pro.action.weixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nuoyun.pro.config.WeiXinConfig;
import com.tmsps.ne4weixin.action.Ne4WeiXinSpringAction;
import com.tmsps.ne4weixin.config.WxConfig;

@RequestMapping("/weixin/handle")
public class WeiXinHandleAction extends Ne4WeiXinSpringAction {
	@Autowired
	private WeiXinConfig weixinConfig;

	@Override
	public WxConfig getWxConfig(String IdCode) {
		if (null == IdCode) {
			return weixinConfig.getWxConfig();
		}
		return null;
	}

}
