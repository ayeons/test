<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.1.4.js"></script>


</head>
<body>
NewFile2

<script>
$(function(){
	$("#button").click(function(){
		$(".fd").fadeIn(1000);
	});
		
})
</script>
<button id="button">fd</button>
<div class="fd" style="display:none">fddf</div>

</body>
</html>