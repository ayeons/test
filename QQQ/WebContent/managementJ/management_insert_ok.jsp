<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%@include file="../header.jsp" %>
<script>
	$(document).ready(function(){
		setTimeout(function(){
			location.href="/QQQ/managementJ/management_insert.jsp";
		},2000);
	})
</script>
	<c:choose>
	<c:when test="${result>0}">
		등록성공
	</c:when>
	
	<c:otherwise>아이디중복</c:otherwise>
	</c:choose>
	
</body>
</html>