<%@page pageEncoding="EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-2.1.4.js"></script>

<link rel="stylesheet" href="/QQQ/resource/vendors/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/QQQ/resource/vendors/themify-icons/themify-icons.css">
<link rel="stylesheet" href="/QQQ/resource/vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet" href="/QQQ/resource/vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="/QQQ/resource/vendors/Magnific-Popup/magnific-popup.css">

<link rel="stylesheet" href="/QQQ/resource/css/style.css">
 <script src="/QQQ/resource/vendors/jquery/jquery-3.2.1.min.js"></script>
  <script src="/QQQ/resource/vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="/QQQ/resource/vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="/QQQ/resource/vendors/nice-select/jquery.nice-select.min.js"></script>
  <script src="/QQQ/resource/vendors/Magnific-Popup/jquery.magnific-popup.min.js"></script>
  <script src="/QQQ/resource/js/jquery.ajaxchimp.min.js"></script>
  <script src="/QQQ/resource/js/mail-script.js"></script>
  <script src="/QQQ/resource/js/main.js"></script>
<script>
	function df(){
	
		var s=location.href;
		location.href="/QQQ/test/loginC.jsp?uri="+s;
	}
</script>

<header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container box_1620">
          <a class="navbar-brand logo_h" href="/QQQ/index.jsp"><img src="/QQQ/resource/img/logo.png" alt=""></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>

          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav justify-content-end">
              <li class="nav-item"><a class="nav-link" href="javascript:df()"></a>
              <li class="nav-item"><a class="nav-link" href="/QQQ/index.jsp">Home</a></li> 
              <li class="nav-item"><a class="nav-link" href="#"></a></li> 
              <li class="nav-item"><a class="nav-link" href="/QQQ/product/list">Menu</a>
              <li class="nav-item"><a class="nav-link" href="/QQQ/newb/list.co?pageNum=1">게시판</a>

              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Blog</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="#">Blog Single</a></li>
                  <li class="nav-item"><a class="nav-link" href="#">Blog Details</a></li>
                </ul>
							</li>
              <li class="nav-item"><a class="nav-link" href="contact.html"></a></li>
              <li class="nav-item active"> <a class="nav-link" href="/QQQ/product/showCart">장바구니</a></li>
              
              <li class="nav-item active"> <a class="nav-link" href="/QQQ/user/login" id="log">로그인</a></li>
              
          
             
              <li class="nav-item active"> <a class="nav-link" href="/QQQ/user/sign">회원가입</a></li>
              <%@include file="memsession.jsp" %>	
            </ul>
          </div> 
        </div>
      </nav>
    </div>
  </header>
   