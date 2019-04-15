<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${messageContent}
<%session.removeAttribute("messageContent"); %>
<script>
function df(){
	location="/QQQ/"
}
	window.onload=setTimeout("df()",1000);

</script>
</body>
</html>