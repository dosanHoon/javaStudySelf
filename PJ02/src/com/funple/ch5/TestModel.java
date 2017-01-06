package com.funple.ch5;

import java.util.ArrayList;
import java.util.List;

import com.funple.ch4.MyTableBean;

public class TestModel {
	public List getTestList(){
		List list = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			MyTableBean bean = new MyTableBean();
			bean.setTid(i);
			bean.setTname("tname i = " + i);
			list.add(bean);
			
		}
		return list;
	}
	

}
