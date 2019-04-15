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
</head>
<body>
<%
	
MultipartRequest req=new MultipartRequest(request,"c:/ttt",80000,"EUC-KR",new DefaultFileRenamePolicy());
Enumeration<?> e=req.getFileNames();
String s=null;
out.println(e.hasMoreElements());
while(e.hasMoreElements()){
	String sss=(String)e.nextElement();
s=req.getOriginalFileName(sss);
out.println(s);

String ss=req.getFilesystemName(sss);
out.println(ss);
	
}

%>
fdfd
</body>
</html>