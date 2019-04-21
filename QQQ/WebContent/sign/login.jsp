<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


</head>
<%@include file="../header.jsp" %>
<body>
${loginMessage}
<h2 style="margin-left: 35%; margin-top: 5%;" >로그인</h2>
	<div class="col-lg-8" style="margin-left: 35%;">
          <form class="form-contact contact_form" action="/QQQ/user/check" method="post" id="contactForm" novalidate="novalidate">
            <div class="row">
              <div class="col-6">
                <div class="form-group" >
                    아이디<input style="" class="form-control" name="userId" id="name" type="text" placeholder="아이디를 입력해주세요" >
                </div>
              </div>  
           	</div>
            <div class="row">
              <div class="col-6">
                <div class="form-group">
              비번<input class="form-control" name="userPassword" id="name" type="password" placeholder="비밀번호를 입력해주세요" >
              
                </div>
              </div>  
           	</div>  
          <button type="submit" class="button button-contactForm" style="margin-left: 40%;">확인</button>
         </form>
          
	</div>
</body>

</html>