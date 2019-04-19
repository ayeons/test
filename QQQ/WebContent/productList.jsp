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

<section class="hero-banner hero-banner-sm">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h1 class="hero-title">음식 메뉴</h1>
        <p>- 저희가 준비한 음식 메뉴입니다.</p>
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme w-100 hero-carousel">
          <div class="hero-carousel-item">
            <img class="img-fluid" src="/QQQ/resource/img/blog/jumo.jpg" alt="" style="width: 650px; height: 500px;">
          </div>
        </div>
      </div>
    </div>
  </section>
<section class="section-margin">

    <div class="container">
     

      <div class="row">
      <c:forEach var="list" items="${dtoList}" begin="0" end="${dtoList.size() }" step="1" varStatus="stat">
      
        <div class="col-lg-6">
          <div class="media align-items-center food-card">
            <img class="mr-3 mr-sm-4" width="50" src="/QQQ/resource/img/${list.getImageName()}" alt="noimage">
            <div class="media-body">
              <div class="d-flex justify-content-between food-card-title">
                <h4><a href="detail?id=${list.getProductId()}">${list.getProductName()}</a></h4>
                <h3 class="price-tag">${list.getPrice()}</h3>
              </div>
              <p>메뉴</p>
            </div>
          </div>
        </div>
	  </c:forEach> 
	  </div>
	</div>
</section>
	
</body>
</html>