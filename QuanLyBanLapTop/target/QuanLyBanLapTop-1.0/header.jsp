<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/QuanLyBanLapTop/css/style.css">
<link rel="stylesheet" href="/QuanLyBanLapTop/css/custom.css">
<link rel="stylesheet" media="screen"
	href="/QuanLyBanLapTop/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
<script src="/QuanLyBanLapTop/js/jquery.min.js"></script>
</head>
<style>
img {
	width: 100%;
}
</style>
<body>

	<form method="GET" action=timkiem.jsp>
		<header class="header">
		<div class="container">
			<nav class="navbar navbar-default navbar-static-top"
				role="navigation">
			<div class="container">
				<ul class="nav navbar-nav">
					<li><a href="/QuanLyBanLapTop/trangchu.jsp">Trang chủ</a></li>
					<li><a href="/QuanLyBanLapTop/gioithieu.jsp">Giới thiệu </a></li>
					<li><a href="/QuanLyBanLapTop/ListProductByDanhMuc.jsp">Sản phẩm</a></li>
					<%
					if (session.getAttribute("username") != null) {
					%>
					<li><a href="/QuanLyBanLapTop/lichsu.jsp">Lịch sử</a></li>
					<% } %>

					<li><a href="/QuanLyBanLapTop/lienhe.jsp">Liên hệ</a>
					<li><input
						style="margin-top: 14px; border-radius: 5px 5px 5px 5px;"
						type="text" name="Name" placeholder="  nhập để tìm kiếm"
						id="search"></li>
					<!-- bat su kien an nut Enter hoac an nut search call API  -->
					<li><input
						style="margin-top: 10px; margin-left: 5px; border-radius: 5px 5px 5px 5px;"
						type="submit" value="Search"><a href="/QuanLyBanLapTop/timkiem.jsp"></a></li>
					<li><a href="#">Chào: <%=session.getAttribute("username")%></a></li>
					<%
					if (session.getAttribute("username") == null) {
					%>
					<li><a href="DangNhap"><span
							class="glyphicon glyphicon-user"></span> Đăng nhập</a></li>
					<%
					} else {
					%>
					<li><a href="DangXuat"><span
							class="glyphicon glyphicon-user"></span> Đăng xuất</a></li>
					<%
					}
					%>

					<li><a href="DangKy"><span
							class="glyphicon glyphicon-log-in"></span> Đăng ký</a></li>
					<li><a href="giohang.jsp"><span
							class="glyphicon glyphicon-shopping-cart"></span> Giỏ hàng</a></li>

				</ul>
			</div>
			</nav>
		</div>
		</header>
	</form>
	<main class="main">
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="dmuc-sp">
						<p>DANH MỤC SẢN PHẨM</p>
						<div class="danhmuc"></div>
					</div>
				</div>
				<div class="col-md-9">
					<section class="banner-img">
					<div id="carousel-id" class="carousel slide " data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-id" data-slide-to="0" class=""></li>
							<li data-target="#carousel-id" data-slide-to="1" class=""></li>
							<li data-target="#carousel-id" data-slide-to="2" class=""></li>
							<li data-target="#carousel-id" data-slide-to="3" class=""></li>
							<li data-target="#carousel-id" data-slide-to="4" class=""></li>
							<li data-target="#carousel-id" data-slide-to="5" class="active"></li>
						</ol>
						<div class="carousel-inner ">
							<div class="item">
								<img
									src="/QuanLyBanLapTop/images/banner/10-chiec-laptop-dep-nhat-hien-nay-du-suc-lam-con-tim-ban-tan-chay.jpg">
							</div>
							<div class="item">
								<img
									src="/QuanLyBanLapTop/images/banner/1-the-hp-spectre-is-an-opulent-laptop-1461211911577.jpg">
							</div>
							<div class="item">
								<img
									src="/QuanLyBanLapTop/images/banner/asus-zenbook-ux333-6.jpg">
							</div>
							<div class="item">
								<img src="/QuanLyBanLapTop/images/banner/image1.jpg">
							</div>
							<div class="item active">
								<img src="/QuanLyBanLapTop/images/banner/image2.png">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-id"
							data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left"></span></a> <a
							class="right carousel-control" href="#carousel-id"
							data-slide="next"><span
							class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
					</section>
				</div>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	$.ajax({
		url : "http://localhost:8080/QuanLyBanLapTop/api/danhmuc",
		type : "GET",
		success : function(resultdanhmuc) {
			var texts = '';
			var tendm = '';
			for (let i = 0; i < resultdanhmuc.length; i++) {
				texts += getElement_DanhMuc(resultdanhmuc[i]);
			}

			$(".danhmuc").append(texts);
		},
		error : function(error) {
			console.log(error);
		}
	});
	function getElement_DanhMuc(resultdanhmuc) {
		return '<h5><i class="fa fa-arrow-circle-right"></i><a href="/QuanLyBanLapTop/ListProductByDanhMuc/'+resultdanhmuc.ma_danh_muc+'/'+resultdanhmuc.ten_danh_muc+'">'
				+ resultdanhmuc.ten_danh_muc + '</a></h5>'
	}
</script>
</html>