
<%@page import="com.funple.ch4.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp
	<br />
	<%
		
		JdbcTest jt = new JdbcTest();
	
		/*List<MyTableBean> myList = jt.getMyTableList(conn);
		out.println("myList.size() = " + myList.size());
		for (int i = 0; i < myList.size(); i++) {
			MyTableBean myBean = myList.get(i);
			out.print("myBean" + myBean.getTid());
			out.println(", tname =" + myBean.getTname());
		}*/
		
	%>
	jstl:<c:out value="$msg"></c:out>
</body>
</html>