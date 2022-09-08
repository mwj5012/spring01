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
	
	<h3>입력</h3>
	상품명 : <input type="text" name="name" id="name">
	가격 : <input type="text" name="price" id="price">
	
	<button id="button">전송</button>
	
	<hr>
	
	<h3>결과</h3>
	
	<div id="result"></div>
	
	<script type="text/javascript">
		$(function() {
			var btn = document.getElementById("button");
			console.log(btn);
			
			btn.addEventListener("click", function() {
				/* 서버로 데이터 보내기 */
				var name = $("#name").val();
				var price = $("#price").val();
				
				var param = { "name" : name, "price" : price };
				console.log(param);
				
				$.ajax({
					url: "ajaxReturn.do",
					type: "POST",
					data: JSON.stringify(param),
					dataType: "text",
					success: function(pdto) {
						console.log("1. ajax 데이터 전송 완료");
						
						console.log("2. " + pdto);
						
						$("#result").html("상품명 : " + pdto.name + ", 가격 : " + pdto.price);
					}
					
					
				});
				
				
				/* 데이터 출력 */
				/* $.ajax({
					url: "/test/ajaxReturn.do",
					success: function(pdto) {
						console.log("ajax 데이터 전송");
						
						console.log(pdto);
						
						$("#result").html("상품명 : " + pdto.name + ", 가격 : " + pdto.price);
					}
					
				}); */
			});
			
			
			
		});
		
		
		
	</script>
</body>
</html>