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

<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/management/list">������</a></span>
<h3>����������</h3>
	<div class="col-lg-8">
          <form class="form-contact contact_form" action="/QQQ/management/update_ok" method="post" enctype="multipart/form-data" id="contactForm" novalidate="novalidate">
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    ��ǰ���̵�<input style="background-color:lightpink" class="form-control" name="productId" id="name" type="text" value="${dto.getProductId()}" readonly>
                </div>
              </div>  
           	</div>
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                ��ǰ�̸�<input class="form-control" name="productName" id="name" type="text" placeholder="Enter your name" value="${dto.getProductName()}">
                </div>
              </div>  
           	</div>  
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    ����<input class="form-control" name="price" id="name" type="text" value="${dto.getPrice()}">
                </div>
              </div>  
           	</div>
          
           	<div class="row">
              <div class="col-6">
                <div class="form-group">
          	����          <input class="form-control" name="file1" id="description" type="file" placeholder="Enter description">
                </div>
              </div>  
           	</div>
           	<div class="row">
              <div class="col-6">
                <div class="form-group">
                    �󼼼���<input class="form-control" name="description" id="name" type="text" value="${dto.getDescription()}">
                </div>
              </div>  
           	</div>
           	
           	
            <div class="form-group mt-3" style="display:inline-block">
              <button type="submit" class="button button-contactForm">����</button>
            </div>
             <div class="form-group mt-3" style="display:inline-block">
              <button type="button" class="button button-contactForm"  onclick="location.href='delete?id=${dto.getProductId()}'">����</button>
            </div>
         </form>
	</div>
</body>
</html>