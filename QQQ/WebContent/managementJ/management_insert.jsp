<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script>
	function vali(){
		
		if(form1.productId.value==""||form1.productName.value==""||form1.price.value==""){
			alert("��簪�Է���");
			return false;
		}
		var exp=/^[0-9]*$/
		if(exp.exec(form1.price.value)==null){
			alert("���ڸ��Է���");
			return false;
		}
	}
</script>


<%@include file="../header.jsp" %>
<span class=""><a class="nav-link" href="<%=getServletContext().getContextPath()%>/management/list">������</a></span>



	<h3>��ǰ���</h3>
	<div class="col-lg-8">
          <form name="form1" class="form-contact contact_form" action="/QQQ/management/insert" method="post" enctype="multipart/form-data" id="contactForm" novalidate="novalidate" onsubmit="return vali()" >
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="productId" id="id" type="text" placeholder="Enter product id">
                </div>
              </div>  
           	</div>
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="productName" id="name" type="text" placeholder="Enter product name">
                </div>
              </div>  
           	</div>  
            <div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="price" id="price" type="text" placeholder="Enter price">
                </div>
              </div>  
           	</div>
           	
           	<div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="file1" id="description" type="file" placeholder="Enter description">
                </div>
              </div>  
           	</div>
           	<div class="row">
              <div class="col-6">
                <div class="form-group">
                    <input class="form-control" name="description" id="description" type="text" placeholder="Enter description">
                </div>
              </div>  
           	</div>
           	
            <div class="form-group mt-3">
              <button type="submit" class="button button-contactForm" >���</button>
            </div>
            
         </form>
	</div>
	
</body>
</html>