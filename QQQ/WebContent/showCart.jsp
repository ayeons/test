<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
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

 	<section class="hero-banner hero-banner-sm">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h1 class="hero-title">장바구니</h1>
        
        <p>From  set together our divided own saw divided the form god <br class="d-none d-xl-block"> seas moveth you will fifth under replenish end</p>
        <ul class="hero-info d-none d-lg-block">
          <li>
            <img src="/QQQ/img/banner/fas-service-icon.png" alt="">
            <h4>Fast Service</h4>
          </li>
          <li>
            <img src="/QQQ/img/banner/fresh-food-icon.png" alt="">
            <h4>Fresh Food</h4>
          </li>
          <li>
            <img src="/QQQ/img/banner/support-icon.png" alt="">
            <h4>24/7 Support</h4>
          </li>
        </ul>
        <br>
        <div class="section-intro mb-75px">
	        <h4 class="intro-title">!!</h4>
	        <h3>Delicious food</h3>
	    </div>
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme w-100 hero-carousel">
          <div class="hero-carousel-item">
            <img class="img-fluid" src="/QQQ/img/home/about-img1.png" alt="">
          </div>
        </div>
      </div>
      <ul class="social-icons d-none d-lg-block">
        <li><a href="#"><i class="ti-facebook"></i></a></li>
        <li><a href="#"><i class="ti-twitter"></i></a></li>
        <li><a href="#"><i class="ti-instagram"></i></a></li>
      </ul>
      
    </div>
  </section>
	<c:choose>
	<c:when test="${list==null}">
		<h1>장바구니에상품이없습니다</h1> 
	</c:when>
	<c:otherwise>
	<section class="section-margin">
	
			
	

    	<div class="container">
     
	      <c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" step="1" varStatus="stat">
	      <div class="row">
	        <div class="col-lg-6">
	          <div class="media align-items-center food-card">
	            <img class="mr-3 mr-sm-4" src="${dto.getImageName()}" alt="">
	            <div class="media-body">
	              <div class="d-flex justify-content-between food-card-title">
	                <h4><a href="detail?id=${dto.getProductId()}">${dto.getProductName()}</a></h4>
	                <h3 class="price-tag">${dto.getPrice()}</h3>
	                
	              </div>
	             	
	              <p>Whales and darkness moving form cattle</p>
	              
	           	 </div>
	         	 </div>
	       	 </div>
	       	 <div class="col-lg-6">
	          <div class="media align-items-center food-card">
	            <img class="mr-3 mr-sm-4" src="img/home/food1.png" alt="">
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
<%@include file="footer.jsp" %>
</body>
</html>