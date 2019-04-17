<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="section-intro mb-75px">
        <h4 class="intro-title">주문 처리 완료</h4>
        <h2>Fresh taste and great price</h2>
</div>

<script>
	window.onload=function(){
		
		setTimeout("gourl()",1000);	
	}
	function gourl(){
		location="/QQQ/product/list";
	}
</script>
</body>
</html>