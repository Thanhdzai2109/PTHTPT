<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sach</title>
</head>

<body>
	<%@include file="header.jsp"%>

	<div class="san-pham">
		<div class="container">
			<div class="row">
				<div class="san-pham-content">
					<div class="col-md-12 sp1">
						<h4 id="name-pc"></h4>
					</div>
				</div>
				<div class="sanpham"></div>


			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		load_data()
		function load_data() {
			var url_length = window.location.href.length;

			console.log(url_length)
			if (url_length <= 62) {
				home();
			} else {
				name();
			}
		}
		function name() {
			var url = window.location.href.split("/");

			document.getElementById("name-pc").innerHTML = "Sản phẩm phù hợp";

			$.ajax({
				url : 'http://localhost:8080/QuanLyBanLapTop/api/products/'
						+ url[5],
				type : 'GET',
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
			return '<div class="col-md-3">' + '<div class="item1">'
					+ '<img src="/QuanLyBanLapTop/'+resultdanhmuc.hinh_anh+'">'
					+ '<div class="item1-conten">' + '<h4>'
					+ resultdanhmuc.ten_san_pham + '</h4>' + '<h5>'
					+ resultdanhmuc.don_gia + 'đ</h5>'
					+ '<a href="/QuanLyBanLapTop/chitiet.jsp?ma_san_pham='
					+ resultdanhmuc.ma_san_pham + '">Xem Chi Tiết</a>'
					+ '</div>' + '</div>' + '</div>';

		}
		function home() {
			document.getElementById("name-pc").innerHTML = "Sản phẩm phù hợp";
			$.ajax({
				
				url : "http://localhost:8080/QuanLyBanLapTop/api/products",
				type : "GET",
				success : function(resultdanhmuc) {
					var texts = '';
					for (let i = 0; i < resultdanhmuc.length; i++) {
						texts += getElement_Product(resultdanhmuc[i]);
					}
					console.log(texts);

					$(".sanpham").append(texts);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>

</body>

</html>