package com.funple.ch5;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funple.ch4.JdbcTest;
import com.funple.ch6.ConnectionPool;

public class ViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		TestModel tm = new TestModel();
		List testlist = tm.getTestList();
		
		String msg = "view Servlet";
		
		request.setAttribute("msg", msg);
		request.setAttribute("tlist", testlist);
		
		ConnectionPool pool = new ConnectionPool();
		
		try {
			Connection poolConn =  pool.getDBCPConnection();
			System.out.println("poolConn : " + poolConn.getCatalog());
			JdbcTest jt = new JdbcTest();
			jt.viewTable(poolConn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);
	}
}
