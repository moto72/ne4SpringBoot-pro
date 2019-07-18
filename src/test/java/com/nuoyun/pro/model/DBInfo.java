package com.nuoyun.pro.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: DBInfo.java
 * @Package com.nuoyun.pro.model
 * @Description: 数据库的连接信息
 * @author: zhangwei
 * @date: 2019-07-18
 * @version v1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
@Slf4j
public class DBInfo {
	private Connection conn;

	public DBInfo(Connection conn) {
		this.conn = conn;
	}

	public void getInfo() {
		DatabaseMetaData dbMeta = null;
		ResultSet rest = null;
		try {
			dbMeta = conn.getMetaData();
			System.err.println("数据库已知的用户: " + dbMeta.getUserName());
			System.err.println("数据库的系统函数的逗号分隔列表: " + dbMeta.getSystemFunctions());
			System.err.println("数据库的时间和日期函数的逗号分隔列表: " + dbMeta.getTimeDateFunctions());
			System.err.println("数据库的字符串函数的逗号分隔列表: " + dbMeta.getStringFunctions());
			System.err.println("数据库供应商用于 'schema' 的首选术语: " + dbMeta.getSchemaTerm());
			System.err.println("数据库URL: " + dbMeta.getURL());
			System.err.println("是否允许只读:" + dbMeta.isReadOnly());
			System.err.println("数据库的产品名称:" + dbMeta.getDatabaseProductName());
			System.err.println("数据库的版本:" + dbMeta.getDatabaseProductVersion());
			System.err.println("驱动程序的名称:" + dbMeta.getDriverName());
			System.err.println("驱动程序的版本:" + dbMeta.getDriverVersion());
			System.err.println();
			System.err.println("数据库中使用的表类型");
			rest = dbMeta.getTableTypes();
			while (rest.next()) {
				System.err.println(rest.getString(1));
			}
		} catch (SQLException e) {
			log.error(e.toString());
		} finally {
			if (null != rest) {
				try {
					rest.close();
				} catch (SQLException e) {
					log.error(e.toString());
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.toString());
				}
			}
		}

	}
}
