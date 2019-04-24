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

<img src="/QQQ/resource/img/home/55.JPG" style="width: 500px; height: 400px; margin-bottom: 5%; margin-left: 40%; margin-top: 5%;">


<div class="section-intro mb-75px" style="margin-left: 40%;">
        <h4 class="intro-title">주문 처리 완료</h4>
        <h2>주문해주셔서 감사합니다!</h2>
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