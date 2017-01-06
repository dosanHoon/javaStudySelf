package com.funple.ch5;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		TestModel tm = new TestModel();
		List testlist = tm.getTestList();
		
		String msg = "view Servlet";
		
		request.setAttribute("msg", msg);
		request.setAttribute("tlist", testlist);
		RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);
	}
}
