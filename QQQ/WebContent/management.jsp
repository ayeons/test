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
<script>

$(document).ready(function(){
	setTimeout(disappear,1000);
	
})
function disappear(){
	
	$("#result").fadeOut(3000,"linear");
}

</script>

<c:if test="${param.result!=null}">
<h3 id="result">영향받은row수 :${param.result}</h3>
</c:if>

<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/product/list">일반</a></span>
	<header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container box_1620">
         

          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav justify-content-end">
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">관리자메뉴</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="/QQQ/management/list">list</a></li>
                  <li class="nav-item"><a class="nav-link" href="/QQQ/management_insert.jsp">insert</a></li>
                  <li class="nav-item"><a class="nav-link" href="#update">modify and delete</a></li>
                  
                </ul>
	  		 </li>
              
              	
            </ul>
          </div> 
        </div>
      </nav>
    </div>
  </header>
   
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
       <a id="update"></a>   
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
                <h4><a href="update?id=${list.getProductId()}">${list.getProductName()}</a></h4>
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

<%@include file="footer.jsp" %>
</body>
</html>