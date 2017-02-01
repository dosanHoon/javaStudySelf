package com.funple.ch7;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
//	public static SqlSessionFactory ssf;
//	static {
//		String resource = "mybatis-config.xml";
//		InputStream is = null;
//		try {
//			is = Resources.getResourceAsStream(resource);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ssf = new SqlSessionFactoryBuilder().build(is);
//	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		
	}
}
