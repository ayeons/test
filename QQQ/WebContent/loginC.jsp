<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String s=request.getParameter("uri");
	String str=s.substring(request.getRequestURL().length()-request.getRequestURI().length());
	session.setAttribute("uri",str );
	
%>
<input type="button" onclick='location.href="loginCC.jsp"'>
</body>
</html>