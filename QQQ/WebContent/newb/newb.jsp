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
		var num=$("#pageNum").html();
		$("#"+num).css("color","red");
		
	})
</script>
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<td>d</td>
				<td>d</td>
				<td>d</td>
				<td>d</td>
			</tr>
			
		</thead>	
		<tbody>
		<c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" step="1">
			<tr>
				<td><a href="${pageContext.request.contextPath}/newb/detail.jsp?idx=${dto.getIdx()}">${dto.getIdx()}</a></td>
				<td>
				<c:forEach begin="1" end="${dto.getLev()-1}">
				&nbsp;<span style="color:#FF0088">re:</span>
				</c:forEach>
				
					${dto.getContent()}
				</td>
				<td>${dto.getAuthor()}</td>
				<td>${dto.getContent()}</td>
				<td>${dto.getSeq() }</td>
				<td>${dto.getLev() }</td>
				<td>${dto.getRefg() }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<span style="display:none" id="pageNum" >${param.pageNum}</span>
	<ul class="pagination">
	<c:choose>
		<c:when test="${param.pageNum-1<0 }">
			<c:set var="page" value="1"/>
		</c:when>
		<c:otherwise>
			<c:set var="page" value="${param.pageNum-1}"/>
		</c:otherwise>
	</c:choose>
	
	<li><a href="list.co?pageNum=${page}" class="page-link">이전</a></li>
	<c:forEach begin="${pageStart}" end="${pageStart+pageQ-1}" varStatus="i">
	
		<li><a href="list.co?pageNum=${i.index}" id="${i.index}" class="page-link">${i.index}</a></li>
	</c:forEach>
		<li><a href="list.co?pageNum=${param.pageNum+1}" class="page-link">다음</a></li>
	</ul>
	<div><a href="${pageContext.request.contextPath}/newb/insert.jsp">글쓰기</a></div>
</body>
</html>