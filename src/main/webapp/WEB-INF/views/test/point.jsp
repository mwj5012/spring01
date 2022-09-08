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
	 
	 <form action="/test/point_result.do" method="post">
	 
	 	이름 : <input type="text" name="name"><br>
	 	국어 : <input type="text" name="kor"><br>
	 	영어 : <input type="text" name="eng"><br>
	 	수학 : <input type="text" name="mat"><br>
	 	
	 	<button type="submit">확인</button>
	 </form>
</body>
</html>