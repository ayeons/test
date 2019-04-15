<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>




<html>
<head>
 
<meta charset="EUC-KR">
<title>Insert title here</title>

<%@include file="header.jsp" %>

</head>

<body>
<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/management/list">관리자</a></span>
<section class="hero-banner hero-banner-sm">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h1 class="hero-title">Food Menu</h1>
        <p>From  set together our divided own saw divided the form god <br class="d-none d-xl-block"> seas moveth you will fifth under replenish end</p>
        <ul class="hero-info d-none d-lg-block">
          <li>
            <img src="/QQQ/resource/img/banner/fas-service-icon.png" alt="">
            <h4>Fast Service</h4>
          </li>
          <li>
            <img src="/QQQ/resource/img/banner/fresh-food-icon.png" alt="">
            <h4>Fresh Food</h4>
          </li>
          <li>
            <img src="/QQQ/resource/img/banner/support-icon.png" alt="">
            <h4>24/7 Support</h4>
          </li>
        </ul>
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme w-100 hero-carousel">
          <div class="hero-carousel-item">
            <img class="img-fluid" src="/QQQ/resource/img/banner/hero-banner-sm.png" alt="">
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
<section class="section-margin">

    <div class="container">
      <div class="section-intro mb-75px">
        <h4 class="intro-title">Food Menu</h4>
        <h2>Delicious food</h2>
      </div>


      <c:forEach var="list" items="${dtoList}" begin="0" end="${dtoList.size() }" step="1" varStatus="stat">
      <div class="row">
      
        <div class="col-lg-6">
          <div class="media align-items-center food-card">
            <img class="mr-3 mr-sm-4" src="${list.getImageName()}" alt="">
            <div class="media-body">
              <div class="d-flex justify-content-between food-card-title">
                <h4><a href="detail?id=${list.getProductId()}">${list.getProductName()}</a></h4>
                <h3 class="price-tag">${list.getPrice()}</h3>
              </div>
              <p>Whales and darkness moving form cattle</p>
            </div>
          </div>
        </div>
	  </div>
	  </c:forEach> 
	</div>
</section>
	
</body>
</html>