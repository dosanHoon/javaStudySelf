package com.funple.ch7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funple.ch4.MyTableBean;

public class MybatisServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("hello Servlet");

		try {
			
			MyTableDao myTableDao = new MyTableDao();
			out.println("<hr>Hello : "+ myTableDao.getMyTableCount());
			
			MyTableBean paramBean = new MyTableBean();
			paramBean.setTname("번");
			paramBean.setTid(12);
			List<MyTableBean> list = myTableDao.getListMyTable(paramBean);
			for (int i = 0;i < list.size();i++) {
				MyTableBean bean = list.get(i);
				out.println("<br>tid  = " + bean.getTid() + ", tname" + bean.getTname());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
