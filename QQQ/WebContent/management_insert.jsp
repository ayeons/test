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
<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/management/list">관리자</a></span>



	<h3>상품등록</h3>
	<div class="col-lg-8">
          <form class="form-contact contact_form" action="/QQQ/management/insert" method="post" id="contactForm" novalidate="novalidate">
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="productId" id="name" type="text" placeholder="Enter product id">
                </div>
              </div>  
           	</div>
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="productName" id="name" type="text" placeholder="Enter product name">
                </div>
              </div>  
           	</div>  
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="price" id="name" type="text" placeholder="Enter price">
                </div>
              </div>  
           	</div>
           	<div class="row">
              <div class="col-6">
                <div class="form-group">
                   <input class="form-control" name="imageName" id="name" type="text" placeholder="Enter imageName">
                </div>
              </div>  
           	</div>
           	<div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="description" id="name" type="text" placeholder="Enter description">
                </div>
              </div>  
           	</div>
           	
            <div class="form-group mt-3">
              <button type="submit" class="button button-contactForm">Send Message</button>
            </div>
         </form>
	</div>
	
</body>
</html>