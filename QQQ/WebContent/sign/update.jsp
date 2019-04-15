<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="/QQQ/resource/css/custom.css">
</head>
<body>
<%@include file="/header.jsp" %>
<div class="container">
		<form method="post" action="/QQQ/user/updateOK">
			<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 정보 수정</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;"><h5>아이디</h5></td>
						<td><input class="form-control" type="text" id="userID" name="userId" maxLength="20"  value="${dto.getUserID()}" readonly></td>
						
					</tr>
					
					<tr>
						<td style="width: 110px;"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userName" name="userName" maxLength="20" value="${dto.getUserName}"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>나이</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userAge" name="userAge" maxLength="20"  value="${dto.getUserAge}"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>성별</h5></td>
						<td colspan="2">
							<div class="form-group" style="text-align: center; margin: 0 auto;">
								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-primary active">
										
										<input type="radio" name="userGender" autocomplete="off"  value="남자" <c:if test='${dto.getUserGender().equals("남")}'>checked="checked"</c:if>>남자
										
										 
									</label>
									<label class="btn btn-primary">
										<input type="radio" name="userGender" autocomplete="off" value="여자" <c:if test='${dto.getUserGender().equals("여")}'>checked="checked"</c:if>>여자 
									</label>
								</div>
							
							</div>  
						</td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="email" id="userEmail" name="userEmail" maxLength="20"  value="${dto.getUserEmail}"></td>
					</tr>
					<tr>
						
						<td style="text-align: Left" colspan="3"><h5 style="color: red;" id="passwordCheckMessage"></h5><input class="btn btn-primary pull-right" type="submit" value="회원가입"></td>
					</tr>
				</tbody>
			</table>
		
		</form>
	</div>
</body>
</html>