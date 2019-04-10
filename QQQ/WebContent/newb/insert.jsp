<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form class="form" action="${pageContext.request.contextPath}/newb/insert.co" method="post">
	<input type="hidden" name="idx" value="${param.idx}">
	<input type="text" name="author">
	<input type="text" name="content">
	<input type="submit" >
</form>
<a href="${pageContext.request.contextPath}/newb/list.co">목록</a>
</body>
</html>