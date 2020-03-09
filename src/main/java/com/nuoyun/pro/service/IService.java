package com.nuoyun.pro.service;

import java.util.List;

import com.tmsps.ne4spring.page.Page;

/**
 * @Title: IService.java
 * @Package com.nuoyun.pro.service
 * @Description: 通用接口
 * @author: zhangwei
 * @date: 2019-07-10
 * @version v1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
public interface IService {
	// 新增
	public boolean save();

	// 删除
	public boolean delete();

	// 修改
	public boolean update();

	// 查询单条信息
	public Object findObject();

	// 查询列表
	public List<?> findList();

	// 分页查询
	public Page findPage();
}
