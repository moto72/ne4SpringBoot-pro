package com.nuoyun.pro.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nuoyun.pro.BaseTest;
import com.tmsps.ne4spring.utils.generator.BeanGenerator;
import com.tmsps.ne4spring.utils.generator.GeUtils;
import com.tmsps.ne4spring.utils.generator.TableMeta;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: ModelCreator.java
 * @Package com.nuoyun.pro.model
 * @Description: 对应数据库中的表信息映射到VO
 * @author: zhangwei
 * @date: 2019-07-11
 * @version v1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
@Slf4j
public class ModelCreator extends BaseTest {
	@Autowired
	private DataSource dataSource;

	@Test
	public void Ge() throws SQLException {
		new DBInfo(dataSource.getConnection()).getInfo();
		GeUtils ge = new GeUtils(dataSource.getConnection());
		// bean文件输出的文件夹路径
		String outPath = ge.getPath() + "/src/main/java/com/nuoyun/pro/model";
		log.info("Model 输出路径 ：{}", outPath);
		List<TableMeta> tableMetas = ge.getTableMetas();
		for (TableMeta tableMeta2 : tableMetas) {
			// bean的package 路径
			new BeanGenerator("com.nuoyun.pro.model").getBeanContent(tableMeta2);
		}
		for (TableMeta tableMeta2 : tableMetas) {
			try {
				ge.wirtToFile(tableMeta2, outPath);
			} catch (IOException e) {
				log.error(e.toString());
			}
		}
	}
}
