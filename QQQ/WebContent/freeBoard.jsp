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
					var	tagTr=$("<tr></tr>");
					var lev=$(this).find("lev").text();
					
					for(var i=0;i<lev;i++){
						
						$(tagTr).append("<td onclick='d(this)' style='color:blue'>re</td>");
						
					}
					$(tagTr).append("<td style='display:none'>"+$(this).find("refg").text()+"</td>");
					$(tagTr).append("<td style='display:none'>"+$(this).find("lev").text()+"</td>");
					$(tagTr).append("<td>"+$(this).find("content").text()+"</td>");
					$(tagTr).append("<td>"+$(this).find("author").text()+"</td>");
					
					$(t).parent().after(tagTr);
				})
			}
		})		 
		
	}
	
</script>
<span class="badge badge-primary">df</span>
<table class="table table-striped table-hover">
		<tr>
			<th>�۹�ȣ</th>
			
			<th>����</th>
			<th>�۾���</th>
			
		</tr>
		<c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" >
		<tr>
			
			<td title="false" onclick="d(this)">${dto.getIdx()}</td>
			<td style="display:none">${dto.getRefg()}</td>
			<td style="display:none">${dto.getLev()}</td>
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
	<input type=button onclick="d(this)" value="fd">
</body>
</html>