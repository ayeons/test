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

	function d(t){
		
	var s=$(t).attr("title");
	
	
	if(s=="true"){return false;}
	$(t).attr("title","true");
	
	var refg=$(t).next().html();
	var lev=$(t).next().next().html();
		
		
		$.ajax({
			url : "/QQQ/free/ajax",
			
			type : "post",
			data : {refg:refg,lev:lev},

			dataType : "html",
			
			
				
			success : function(data){
				var item=$(data).find("item");
				
					
					
					
				$(item).each(function(){
					var	tagTr=$("<tr>");
					var lev=$(this).find("lev").text();
					
					
					$(tagTr).append("<td onclick='d(this)'>"+$(this).find("idx").text());
					$(tagTr).append("<td style='display:none'>"+$(this).find("refg").text());
					$(tagTr).append("<td style='display:none'>"+$(this).find("lev").text());
					var tag=$("<td>");
					
					for(var i=0;i<lev;i++){
						
						$(tag).append("<span style='color:blue'>&nbsp;&nbsp;&nbsp;re");
						
						
					}
					$(tag).append(": "+$(this).find("subject").text());
					$(tagTr).append(tag);
					
					$(tagTr).append("<td>"+$(this).find("content").text());
					$(tagTr).append("<td>"+$(this).find("author").text());
					
					$(t).parent().after(tagTr);
				})
			}
		})		 
		
	}
	
</script>
<span class="badge badge-primary">df</span>
<table class="table table-striped table-hover">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>글쓴이</th>
			
		</tr>
		<c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" >
		<tr>
			
			<td title="false" onclick="d(this)">${dto.getIdx()}</td>
			<td style="display:none">${dto.getRefg()}</td>
			<td style="display:none">${dto.getLev()}</td>
			<td>${dto.getSubject()}</td>
			<td>${dto.getContent()}</td>
			<td>${dto.getAuthor()}</td>
			
		</tr>
		
		</c:forEach>
	</table>
	<ul class="pagination">
	<c:forEach begin="1" end="${pageQuantity}" varStatus="re">
	
		<li class="page-item"><a class="page-link" href="<c:url value='/free/list?pageNum=${re.index}'/>">${re.index}</a></li>
		
		
	</c:forEach>
	</ul>
	
</body>
</html>