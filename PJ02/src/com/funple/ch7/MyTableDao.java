package com.funple.ch7;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.funple.ch4.MyTableBean;

public class MyTableDao {
	SqlSessionFactory factory = MySqlSessionFactory.getSqlSessionFactory();
	
	public int getMyTableCount(){
		int count = 0;		
		SqlSession sqlSession = factory.openSession();
		count = sqlSession.selectOne("com.funple.ch7.selectCountMytable");
		sqlSession.close();
		return count;
	}
	public List<MyTableBean> getListMyTable( MyTableBean paramBean){
		SqlSession sqlSession = factory.openSession();
		List<MyTableBean> list = sqlSession.selectList("com.funple.ch7.SelectListMytable",paramBean);
		sqlSession.close();
		return list;
	}

	
}