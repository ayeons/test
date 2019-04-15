<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.sun.jmx.snmp.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<img alt="이미지" src="/QQQ/member/a?name=aa" width="300">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<script src="http://code.jquery.com/jquery-2.1.4.js"></script>



<form action="/QQQ/NewFile1.jsp" method="post" enctype="multipart/form-data">
	<input type="text" name="id">
	<input type="submit">
	<input type="file" name="file">
	<input type="email">
	<input type="submit">
</form>

</body>
</html>