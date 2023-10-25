<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/QuanLyBanLapTop/css/style.css">
</head>
<body>
	<%@ include file="header.jsp"%>
		<div class="san-pham">
		<div class="container">
			<div class="row">
				<div class="san-pham-content">
					<div class="col-md-12 sp1">
						<h4 id="demo"></h4>
					</div>
				</div>
				<div class="sanpham">
					
				</div>
				
				
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
	
		name();
		
		function name() {
			console.log("Test");
			var url = window.location.href.split("=");
			var res = url[1].replace("+", " ");
			var data = {};
			data["ten_san_pham"]= $("#search").val();
			document.getElementById("demo").innerHTML="TỪ KHÓA:"+res;
			
			$.ajax({
				url : 'http://localhost:8080/QuanLyBanLapTop/api/products/'+res,
				type : 'GET',
				/* data : JSON.stringify(data),
				dataType : "application/json", */
				success : function(resultdanhmuc) {
					var texts = '';
					for (let i = 0; i < resultdanhmuc.length; i++) {
						texts += getElement_Product(resultdanhmuc[i]);
					}

					$(".sanpham").append(texts);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}

		function getElement_Product(resultdanhmuc) {
			return '<div class="col-md-3">'
					+ '<div class="item1">'
					+ '<img src="/QuanLyBanLapTop'+resultdanhmuc.hinh_anh+'">'
					+ '<div class="item1-conten">' + '<h4>'+resultdanhmuc.ten_san_pham+'</h4>'
					+ '<h5>'+resultdanhmuc.don_gia+'đ</h5>' 
					+'<a href="/QuanLyBanLapTop/chitiet.jsp?ma_san_pham='+resultdanhmuc.ma_san_pham+'">Xem Chi Tiết</>'
					+ '</div>'
					+ '</div>' + '</div>';

		}
		
	</script>
</body>
</html>