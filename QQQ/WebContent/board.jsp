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
        <h1 class="hero-title">게시판</h1>
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
	<table class="table table-striped table-hover">
		<tr>
			<th>aaa</th>
			<th>aaa</th>
			<th>aaa</th>
			<th>aaa</th>
			<th>aaa</th>
		</tr>
		<c:forEach var="dto" items="${list}" begin="0" end="${list.size()}" step="1">
		<tr>
			<td>${dto.getId()}</td>
			<td>${dto.getAuthor()}</td>
			<td>${dto.getTitle()}</td>
			<td>${dto.getContent()}</td>
			
		</tr>
		
		</c:forEach>
	</table>
	<input class="button pull-right" type="button" value="글쓰기" onclick="location.href='write'">
	<div class="container">
	<ul class="pagination" style="font-size:30px">
		<li style="padding:5px"><a href="#">1</a></li>
		<li style="padding:5px"><a href="#">2</a></li>
		<li style="padding:5px"><a href="#">3</a></li>
		<li style="padding:5px"><a href="#">4</a></li>
	</ul>
	</div>
	
<%@include file="footer.jsp" %>
</body>
</html>