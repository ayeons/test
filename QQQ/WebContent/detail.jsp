<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@include file="header.jsp" %>
<!-- <script src="/QQQ/resource/addCart.js"></script> -->
</head>

<body>

<script>
function d(){
	$(".val").css("display","block");
	$(".val").fadeOut(2000);
	
	$.ajax({
		
		url : "/QQQ/product/addShoppingBasket",
		type : "post",
		
		data : {
						
			
			id : $("#hidden").val(),
		} ,
			
		success : function(data){
			$(".val").text(data);
		}
	});
	}
	
	
</script>

<div class="val"></div>
<input id="hidden" type="hidden" value="${dto.getProductId()}">
	<div class="col-lg-12">
          <div class="media align-items-center food-card">
            <img  class="mr-3 mr-sm-4" src="/QQQ/resource/img/${dto.getImageName()}" alt="">
            <div class="media-body">
              <div class="d-flex justify-content-between food-card-title">
                <h4><a href="#">${dto.getProductName()}</a></h4>
                <h3 class="price-tag">${dto.getPrice()}</h3>
                
              </div>
              <p>${dto.getDescription()}</p>
              <p>Whales and darkness moving form cattle</p>
            </div>
          </div>
        </div>
	<br>
	
	<a class="button button-contactForm"  href="javascript:d()">장바구니추가</a>
	<a class="button button-contactForm" href="order">주문</a>
	
	
</body>
</html>