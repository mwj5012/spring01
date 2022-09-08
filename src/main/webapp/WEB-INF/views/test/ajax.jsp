<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	
	<div id="result"></div>
	
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url: "/test/background.do",
				success: function(pdto) {
					$("#result").html("상품평 : " + pdto.name + ", 가격 : " + pdto.price);
				}
			});
		});
	</script>
</body>
</html>