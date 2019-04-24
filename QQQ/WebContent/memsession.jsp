<%@page pageEncoding="EUC-KR" %>
<div style="color:red">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.memDTO!=null}">

<script>
	$(document).ready(function(){
		$("#log").css("display","none");
	})
</script>
<a href="/QQQ/user/update?userId=${sessionScope.memDTO.getUserID()}" class="" >${sessionScope.memDTO.getUserName()}</a>´Ô È¯¿µÇØ¿ä
<a href="/QQQ/user/logout" >·Î±×¾Æ¿ô</a>
</c:if>
</div>