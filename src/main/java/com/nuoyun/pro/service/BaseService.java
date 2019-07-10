package com.nuoyun.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tmsps.ne4spring.base.IBaseService;

@Service
public class BaseService {
	@Autowired
	@Qualifier("baseMySQLService")
	protected IBaseService baseService;

	protected JdbcTemplate getJdbcTemplate() {
		return baseService.getJdbcTemplate();
	}
	
}
