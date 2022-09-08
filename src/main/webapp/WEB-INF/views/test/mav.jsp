<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	
	<form action="mav_result.do" method="post">
		상품명 : <input type="text" name="name">
		가격 : <input type="text" name="price">
		<button type="submit">저장</button>
	</form>

</body>
</html>