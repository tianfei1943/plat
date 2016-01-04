<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 测试</title>
</head>
<body>

<%
	List<String> list = new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");
	list.add("f");
	request.setAttribute("a", list);

%>

<c:forEach items="${a}" var="item" begin="2" end="4">
	<c:out value="${item}"></c:out><br>
</c:forEach>
=======================<br>


<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("a", "tian");
	map.put("b", "fei");
	request.setAttribute("b",map);
%>

<c:forEach items="${b}" var="item">
${item.key}----${item.value }<br>
</c:forEach>


</body>
</html>