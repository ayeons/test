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
<script>
	function re(t){
		
	var idx=$(t).next().html();
		
		
		$.ajax({
			url : "/QQQ/free/ajax",
			type : "post",
			dataType : "xml",
			data :{
				reff : idx
			},
			success : function(data){
				
				
				var tag=$("<td></td>");
				var b=$(data).find("reff").text();
				
				
				
				$(tag).html(b);
				
				$(t).parent().next().append(tag);
				
			}
		})		 
		
	}
	
</script>
<table class="table table-striped table-hover">
		<tr>
			<th>d</th>
			<th>aaa</th>
			<th>aaa</th>
			<th>aaa</th>
			<th>aaa</th>
			<th>aaa</th>
		</tr>
		<c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" >
		<tr>
		<c:if test="${!dto.isReply()}">
			<td onclick="re(this)">df</td>
			</c:if>
			<td>${dto.getIdx()}</td>
			
			<td>${dto.getReff()}</td>
			
			<td>${dto.getSeq()}</td>
			
			<td>${dto.getAuthor()}</td>
			
			<td>${dto.getContent()}</td>
			
		</tr>
		<tr></tr>
		</c:forEach>
	</table>
		<input type=button onclick="d(this)" value="fd">
</body>
</html>