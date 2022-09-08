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

	<h3>구구단</h3>
	<form action="table_result.do" method="post">
		단 : <input type="text" name="num">
		
		<button type="submit">전송</button>
	</form>

</body>
</html>