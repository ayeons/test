<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� Ȩ������</title>

</head>
<body>


<%@include file="header.jsp" %>

<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/management/list" style="width: 132px; margin-left: 20%; text-shadow: black; ">������ �α���</a></span>
  <!--================Hero Banner Section start =================-->
  <section class="hero-banner">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h1 class="hero-title">���� �߿��� ���� <br>�����Դϴ�.</h1>
        <div class="d-sm-flex flex-wrap">
          <a class="button button-hero button-shadow" href="#">�ڼ��� ����</a>
          <a class="hero-banner__video" href="http://www.youtube.com/watch?v=0O2aH4XLbto">������ ����</a>          
        </div>
        <ul class="hero-info d-none d-lg-block">
          <li>
            <img src="resource/img/banner/fas-service-icon.png" alt="">
            <h4>���� ���</h4>
          </li>
          <li>
            <img src="resource/img/banner/fresh-food-icon.png" alt="">
            <h4>�ż��� ����</h4>
          </li>
          <li>
            <img src="resource/img/banner/support-icon.png" alt="">
            <h4>24�ð� ����</h4>
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
            <h4 class="intro-title">���Ŀ� ���Ͽ�</h4>
            <h2>���� �������� ���մϴ�.</h2>
          </div>
          <p>ȭ���ϰ� ������ ������ �ʿ����. �ٸ� �ż��� ���� ���� �丮�϶�.</p>
          <a class="button button-shadow mt-2 mt-lg-4" href="#">�ڼ��� ����</a>
        </div>
      </div>
    </div>
  </section>
  <!--================About Section End =================-->


  <!--================Featured Section Start =================-->
  <section class="section-margin mb-lg-100">
    <div class="container">
      <div class="section-intro mb-75px">
        <h4 class="intro-title">��õ ����</h4>
        <h2>�ż��� ���� �Ǹ��� ����</h2>
      </div>


      <div class="owl-carousel owl-theme featured-carousel">
        <div class="featured-item">
          <img class="card-img rounded-0" src="resource/img/home/featured1.png" alt="">
          <div class="item-body">
            <a href="#">
              <h3>��Ż���� ����</h3>
            </a>
            <p>������ �Ѱܺ�����</p>
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
            <p>������ �Ѱܺ�����</p>
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
            <p>������ �Ѱܺ�����</p>
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
            <p>������ �Ѱܺ�����</p>
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
            <h3>��Ż���� ���� ����!</h3>
            <h2>50% OFF</h2>
            <a class="button" href="#">�ڼ��� ����</a>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================Offer Section End =================--> 

</body>
</html>