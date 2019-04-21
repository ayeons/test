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
		<form action="/QQQ/newb/list.co?pageNum=1" method="post">
              <div class="input-group" style="margin-bottom: 50px;">
              	
                <input type="text" class="form-control col-lg-6"  name="condition" placeholder="Search" onfocus="this.placeholder = ''" onblur="this.placeholder = 'search '">
                
                <div class="input-group-append">
                  <button class="btn click-btn" type="submit" style="margin-right: 50px;">
                    <i class="ti-arrow-right"></i>                    
                  </button>
                  	
               		 제목	<input type="radio" value="title" name="opt" checked="checked">
                  	글쓴이<input type="radio" value="author" name="opt">
                  	
                </div>
              </div>
              <div style="position: absolute; left: -5000px;">
								<input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
							</div>

							<div class="info"></div>
            </form>
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>내용</th>
				<th>조회수</th>
				
				
			</tr>
			
		</thead>	
		<tbody>
		<c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" step="1">
			<tr>
				<td><a href="${pageContext.request.contextPath}/newb/listAt.co?idx=${dto.getIdx()}">${dto.getIdx()}</a></td>
				<td><a href="${pageContext.request.contextPath}/newb/listAt.co?idx=${dto.getIdx()}">
				<c:forEach begin="1" end="${dto.getLev()-1}">
				&nbsp;<span style="color:#FF0088">re:</span>
				</c:forEach>
				
					${dto.getTitle()}</a>
				</td>
				<td>${dto.getAuthor()}</td>
				<td>${dto.getContent()}</td>
				<td>${dto.getViews() }</td>
				
				
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
	<div><a class="button" href="${pageContext.request.contextPath}/newb/insert.jsp" style="margin-top: 20px;">글쓰기</a></div>
</body>
</html>