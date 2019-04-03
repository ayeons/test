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
out.println(request.getRequestURL());
out.println(request.getRequestURI());

out.println(s.substring(request.getRequestURL().length()-request.getRequestURI().length()));
%>

</body>
</html>