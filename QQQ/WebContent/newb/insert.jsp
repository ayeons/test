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
          <form class="form-contact contact_form" name="insertBoard" action="/QQQ/newb/insert.co" method="post">
            <div class="row">
             <div class="col-sm-12">
                <div class="form-group">
                  	${param.idx }�Ǵ��
                </div>
              </div>
              <input class="form-control" name="idx" id="idx" type="text" value="${param.idx}" style="display:none">
            <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="title" id="title" type="text" placeholder="������ �Է��ϼ���.">
                </div>
              </div>
              <div class="col-12">
                <div class="form-group">
                    <textarea class="form-control w-100" name="content" id="content" cols="30" rows="9" placeholder="������ �Է��ϼ���."></textarea>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="author" id="writer" type="text"  placeholder="�̸��� �Է��ϼ���.">
                </div>
              </div>
              
            </div>
            <div class="form-group mt-3">
              <button type="submit" class="button button-contactForm">�� �ۼ�</button>
            </div>
          </form>
	 </div>
	 

<a href="${pageContext.request.contextPath}/newb/list.co">���</a>
</body>
</html>