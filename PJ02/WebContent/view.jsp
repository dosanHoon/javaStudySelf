<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
view.jsp<br/>
<%=request.getAttribute("msg") %>
<%
	String msg = (String)request.getAttribute("msg");
	out.print("msg = "+ msg );
%>
jstl:<c:out value="${msg}"/><br/>
<c:out value="asdasd">asd1111</c:out><br/>
el : ${msg}
<hr>
toUpper 와 subString : ${fn:toUpperCase(fn:substring(msg, 0, 12))}<br/>
toUpper 와 subString : <c:out value="${fn:toUpperCase(fn:substring(msg, 0, 12))}"></c:out><br/>

<br/>
tlist : 
<c:forEach var="bean" items="${tlist}" varStatus="beanVar">
	count : <c:out value="${beanVar.count}"></c:out>
   tid <c:out value="${bean.tid}"/>,
   tname <c:out value="${bean.tname}"/> : 
   <c:if test="${bean.tid lt 3}">
	   <b>3번</b>
	</c:if>
	<br/>
	${bean.tid eq 2 ? '<b>2번</b>' : '2가아님'}
	<c:choose>
		<c:when test="${bean.tid lt 1}">
			0일꼬야,
		</c:when>
		<c:when test="${bean.tid ge 4}">
			4일꼬야,
		</c:when>
		<c:otherwise>
			1~3의 값
		</c:otherwise>
	</c:choose>
	<br/>
</c:forEach>
<c:set var = "setVar">set을 통해서 만 변수 </c:set>
<c:out value="${setVar}"></c:out>
</body>
</html>