<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<script>
$(function(){
	$("div").each(function(a,b){
			var df=$(b);
		alert(df.css("color","red"));
			alert(b);
	});
})
</script>
<div>
textdwds
</div>
<div>

</div>
</body>
</html>