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
<h2 style="margin-left: 35%; margin-top: 5%;" >�α���</h2>
	<div class="col-lg-8" style="margin-left: 35%;">
          <form class="form-contact contact_form" action="/QQQ/user/check" method="post" id="contactForm" novalidate="novalidate">
            <div class="row">
              <div class="col-6">
                <div class="form-group" >
                    ���̵�<input style="" class="form-control" name="userId" id="name" type="text" placeholder="���̵� �Է����ּ���" >
                </div>
              </div>  
           	</div>
            <div class="row">
              <div class="col-6">
                <div class="form-group">
              ���<input class="form-control" name="userPassword" id="name" type="password" placeholder="��й�ȣ�� �Է����ּ���" >
              
                </div>
              </div>  
           	</div>  
          <button type="submit" class="button button-contactForm" style="margin-left: 40%;">Ȯ��</button>
         </form>
          
	</div>
</body>

</html>