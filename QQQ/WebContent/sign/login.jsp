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
<h3>�α���</h3>
	<div class="col-lg-8">
          <form class="form-contact contact_form" action="/QQQ/user/check" method="post" id="contactForm" novalidate="novalidate">
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    ���̵�<input style="background-color:lightpink" class="form-control" name="userId" id="name" type="text" placeholder="enter id"  >
                </div>
              </div>  
           	</div>
            <div class="row">
              <div class="col-6">
                <div class="form-group">
              ���<input class="form-control" name="userPassword" id="name" type="text" placeholder="Enter your password" >
                </div>
              </div>  
           	</div>  
          <button type="submit" class="button button-contactForm">Ȯ��</button>
         </form>
	</div>
</body>

</html>