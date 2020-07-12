<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관리자 페이지</title>
</head>

<body>

<%@include file="/header.jsp" %>
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


	<header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container box_1620">
         

          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav justify-content-end">
              <li class="nav-item submenu dropdown">
                <a href="#" class="button button-hero button-shadow" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false" style="margin-bottom: 30px;">관리자메뉴</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="/QQQ/management/list">list</a></li>
                  <li class="nav-item"><a class="nav-link" href="/QQQ/management/management_insert.jsp">insert</a></li>
                  <li class="nav-item"><a class="nav-link" href="#update">modify and delete</a></li>
                  <li class="nav-item"><a class="nav-link" href="/QQQ/management/out">관리자out</a></li>
                  
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
        <h1 class="hero-title">관리자 페이지</h1>
        <p>여기서 내용을 수정하십시오. <br class="d-none d-xl-block"> 상품 등록 및 수정</p>
       
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme w-100 hero-carousel">
          <div class="hero-carousel-item">
            <img class="img-fluid" src="/QQQ/resource/img/banner/99.jpg" alt="" style="width: 600px; height: 500px;">
          </div>
        </div>
      </div>
  
      
       <a id="update"></a>   
    </div>
    
  </section>
 
<section class="section-margin">

    <div class="container">
      <div class="section-intro mb-75px">
        
      </div>


      <div class="row">
      <c:forEach var="list" items="${dtoList}" begin="0" end="${dtoList.size() }" step="1" varStatus="stat">

        <div class="col-lg-6">
          <div class="media align-items-center food-card">
            <img class="mr-3 mr-sm-4" width="50" src="/QQQ/resource/img/${list.getImageName()}" alt="noimg">
            <div class="media-body">
              <div class="d-flex justify-content-between food-card-title">
                <h4><a href="update?id=${list.getProductId()}">${list.getProductName()}</a></h4>
                <h3 class="price-tag">${list.getPrice()}</h3>
              </div>
              
            </div>
          </div>
        </div>
	  </c:forEach> 
	  </div>
	</div>
</section>

<br><br><br><br><br><br><br><br>
</body>
</html>