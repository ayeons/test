<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<title>장바구니</title>
</head>
<body>

<%@include file="header.jsp" %>

 	<section class="hero-banner hero-banner-sm">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h1 class="hero-title">장바구니</h1>
        
        
        <br>
        <div class="section-intro mb-75px">
	        <h3>주문처리페이지</h3>
	    </div>
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme w-100 hero-carousel">
          <div class="hero-carousel-item">
            <img class="img-fluid" src="/QQQ/resource/img/home/33.jpg" alt="" style="width: 650px; height: 500px;">
          </div>
        </div>
      </div>
      
      
    </div>
  </section>
	<c:choose>
	<c:when test="${list==null}">
		
	</c:when>
	<c:otherwise>
	<section class="section-margin">
	
			
	

    	<div class="container">
     
	      <c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" step="1" varStatus="stat">
	      <div class="row">
	        <div class="col-lg-6">
	          <div class="media align-items-center food-card">
	            <img width="200" class="mr-3 mr-sm-4" src="/QQQ/resource/img/${dto.getImageName()}" alt="noimg">
	            <div class="media-body">
	              <div class="d-flex justify-content-between food-card-title">
	                <h4><a href="detail?id=${dto.getProductId()}">${dto.getProductName()}</a></h4>
	                <h3 class="price-tag">${dto.getPrice()}</h3>
	                
	              </div>
	             	
	              
	              
	           	 </div>
	         	 </div>
	       	 </div>
	       	 <div class="col-lg-6">
	          <div class="media align-items-center food-card">
	            <img class="mr-3 mr-sm-4" src="resource/img/home/food1.png" alt="">
	            <div class="media-body">
	              <div class="d-flex justify-content-between food-card-title">
	                <h4>x${dto.getQuantity() }</h4>
	                <h3 class="price-tag">${dto.getPrice()*dto.getQuantity()}</h3>
	                
	              </div>
	             	
	              <p>${dto.getQuantity() }개</p>
	              
	           	 </div>
	         	 </div>
	       	 </div>
		 	 </div>
		 		
		 	 </c:forEach> 
			</div>
		
		
	</section>
	</c:otherwise>

</c:choose>
<div class="container">
<h2>
	<a href="order">주문</a>
</h2>
</div>

</body>
</html>