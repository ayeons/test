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

        <h1 class="hero-title" style="width: 200px; margin-left: 45%; margin-top: 5%;">�ֹ�</h1>
        <section class="bg-lightGray section-padding">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-6 col-xl-5 mb-4 mb-md-0">
          <div class="section-intro">
            <h4 class="intro-title">�ֹ� ó�� ������</h4>
            <h2 class="mb-3">ȸ������ ������ �Է����ּ���.</h2>
          </div>
        
        </div>
        <div class="col-md-6 offset-xl-2 col-xl-5">
          <div class="search-wrapper">
            <h3>�ֹ� �Է¶�</h3>

            <form class="search-form" action="/QQQ/orderProcess.jsp">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" style="color:#FF00FF" class="form-control" placeholder="ȸ���̸�" value="${sessionScope.memDTO.getUserName()}">
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-user"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input style="color:#FF00FF" type="text" class="form-control" placeholder="�̸��� �ּ�" value="${sessionScope.memDTO.getUserEmail()}">
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-email"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="��ȭ��ȣ">
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-headphone-alt"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group form-group-position">
                <button class="button border-0" type="submit">�ֹ��ϱ�</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  


</body>
</html>