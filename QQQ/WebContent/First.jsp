<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
fd
<%
Object o=null;
out.println(o instanceof List<?>);
out.println("<br>");
	out.println(application.getServerInfo());
	out.println("<br>");
	out.println(getServletName());
	out.println(application.getServletContextName());
%>


<script>
	
</script>
</body>
</html>