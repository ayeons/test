<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인 홈페이지</title>

</head>
<body>


<%@include file="header.jsp" %>

<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/management/list" style="width: 132px; margin-left: 20%; text-shadow: black; ">관리자 로그인</a></span>
  <!--================Hero Banner Section start =================-->
  <section class="hero-banner">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h1 class="hero-title">가장 중요한 것은 <br>음식입니다.</h1>
        <div class="d-sm-flex flex-wrap">
          <a class="button button-hero button-shadow" href="#">자세히 보기</a>
          <a class="hero-banner__video" href="http://www.youtube.com/watch?v=0O2aH4XLbto">동영상 보기</a>          
        </div>
        <ul class="hero-info d-none d-lg-block">
          <li>
            <img src="resource/img/banner/fas-service-icon.png" alt="">
            <h4>빠른 배송</h4>
          </li>
          <li>
            <img src="resource/img/banner/fresh-food-icon.png" alt="">
            <h4>신선한 음식</h4>
          </li>
          <li>
            <img src="resource/img/banner/support-icon.png" alt="">
            <h4>24시간 영업</h4>
          </li>
        </ul>
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme hero-carousel">
          <div class="hero-carousel-item">
            <img class="img-fluid" src="resource/img/banner/11.jpg" alt="">
          </div>
          <div class="hero-carousel-item">
            <img class="img-fluid" src="resource/img/banner/22.jpg" alt="">
          </div>
          <div class="hero-carousel-item">
            <img class="img-fluid" src="resource/img/banner/hero-banner1.png" alt="" style="height: 541px;">
          </div>
          <div class="hero-carousel-item">
            <img class="img-fluid" src="resource/img/banner/hero-banner2.png" alt="" style="height: 541px;">
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================Hero Banner Section end =================-->

  
  <!--================About Section start =================-->
  <section class="about section-margin pb-xl-70">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-xl-6 mb-5 mb-md-0 pb-5 pb-md-0">
          <div class="img-styleBox">
            <div class="styleBox-border">
              <img class="styleBox-img1 img-fluid" src="resource/img/home/about-img1.png" alt="">
            </div>
            <img class="styleBox-img2 img-fluid" src="resource/img/home/about-img2.png" alt="">
          </div>
        </div>
        <div class="col-md-6 pl-md-5 pl-xl-0 offset-xl-1 col-xl-5">
          <div class="section-intro mb-lg-4">
            <h4 class="intro-title">음식에 대하여</h4>
            <h2>좋은 음식으로 말합니다.</h2>
          </div>
          <p>화려하고 복잡한 음식은 필요없다. 다만 신선한 좋은 재료로 요리하라.</p>
          <a class="button button-shadow mt-2 mt-lg-4" href="#">자세히 보기</a>
        </div>
      </div>
    </div>
  </section>
  <!--================About Section End =================-->


  <!--================Featured Section Start =================-->
  <section class="section-margin mb-lg-100">
    <div class="container">
      <div class="section-intro mb-75px">
        <h4 class="intro-title">추천 음식</h4>
        <h2>신선한 맛과 훌륭한 가격</h2>
      </div>


      <div class="owl-carousel owl-theme featured-carousel">
        <div class="featured-item">
          <img class="card-img rounded-0" src="resource/img/home/featured1.png" alt="">
          <div class="item-body">
            <a href="#">
              <h3>이탈리안 피자</h3>
            </a>
            <p>옆으로 넘겨보세요</p>
            <div class="d-flex justify-content-between">
              <ul class="rating-star">
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
              </ul>
              <h3 class="price-tag">$35</h3>
            </div>
          </div>
        </div>
        <div class="featured-item">
          <img class="card-img rounded-0" src="resource/img/home/featured2.png" alt="">
          <div class="item-body">
            <a href="#">
              <h3>Patatas Bravas</h3>
            </a>
            <p>옆으로 넘겨보세요</p>
            <div class="d-flex justify-content-between">
              <ul class="rating-star">
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
              </ul>
              <h3 class="price-tag">$30</h3>
            </div>
          </div>
        </div>
        <div class="featured-item">
          <img class="card-img rounded-0" src="resource/img/home/featured3.png" alt="">
          <div class="item-body">
            <a href="#">
              <h3>Pulled Sandwich</h3>
            </a>
            <p>옆으로 넘겨보세요</p>
            <div class="d-flex justify-content-between">
              <ul class="rating-star">
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
              </ul>
              <h3 class="price-tag">$20</h3>
            </div>
          </div>
        </div>
        <div class="featured-item">
          <img class="card-img rounded-0" src="resource/img/home/featured1.png" alt="">
          <div class="item-body">
            <a href="#">
              <h3>Mountain Mike Pizza</h3>
            </a>
            <p>옆으로 넘겨보세요</p>
            <div class="d-flex justify-content-between">
              <ul class="rating-star">
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
                <li><i class="ti-star"></i></li>
              </ul>
              <h3 class="price-tag">$35</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================Featured Section End =================-->

  <!--================Offer Section Start =================-->
  <section class="bg-lightGray section-padding">
    <div class="container">
      <div class="row no-gutters">
        <div class="col-sm">
          <img class="card-img rounded-0" src="resource/img/home/offer-img.png" alt="">
        </div>
        <div class="col-sm">
          <div class="offer-card offer-card-position">
            <h3>이탈리안 피자 세일!</h3>
            <h2>50% OFF</h2>
            <a class="button" href="#">자세히 보기</a>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================Offer Section End =================--> 

</body>
</html>