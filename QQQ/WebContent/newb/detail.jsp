<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%@include file="/header.jsp" %>
	<div class="col-lg-8">
          <form class="form-contact contact_form" name="insertBoard" action="${pageContext.request.contextPath}/newb/insert.jsp?idx=${param.idx}" method="post">
              <input type="submit" class="button" value="답글쓰기">
            <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                  <input class="form-control" name="idx" style="background-color:lightpink" readonly value="${dto.getIdx()}" id="title" type="text" placeholder="제목을 입력하세요.">
                </div>
              </div>
              <div class="col-sm-6">
              
                <div class="form-group">
                  <input  class="form-control" name="title" id="writer" value="${dto.getTitle()}" type="text" <c:if test="${sessionScope.manage==null}">style="background-color:lightGreen"  readonly</c:if>>
                </div>
              </div>
              <div class="col-12">
                <div class="form-group">
                    <textarea class="form-control w-100"  name="content"  id="content" cols="30" rows="9" <c:if test="${sessionScope.manage==null}">style="background-color:lightGreen" readonly</c:if>>${dto.getContent()}</textarea>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="author" style="background-color:lightPink" id="writer" value="${dto.getAuthor()}" type="text"  readonly>
                </div>
              </div>
              
            </div>
          
          </form>
	 </div>
	 
<div>
	
</div>
<c:if test="${sessionScope.manage!=null}">

<a class="button" href="${pageContext.request.contextPath}/newb/delete.co?idx=${param.idx}">삭제</a>
</c:if>
<a class="button" href="${pageContext.request.contextPath}/newb/list.co?idx=${param.idx}">목록</a>
</body>
</html>