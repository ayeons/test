<%@page pageEncoding="EUC-KR" %>
<div style="color:red">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.memDTO!=null}">

<script>
	$(document).ready(function(){
		$("#log").css("display","none");
	})
</script>
<a href="/QQQ/user/update?userId=${sessionScope.memDTO.getUserID()}" class="" >${sessionScope.memDTO.getUserName()}</a>�� ȯ���ؿ�
<a href="/QQQ/user/logout" >�α׾ƿ�</a>
</c:if>
</div>