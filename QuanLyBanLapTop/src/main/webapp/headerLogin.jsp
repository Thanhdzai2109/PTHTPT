<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/QuanLyBanLapTop/css/style.css">
<link rel="stylesheet" href="/QuanLyBanLapTop/css/custom.css">
<link rel="stylesheet" media="screen"
	href="/QuanLyBanLapTop/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
<script src="/QuanLyBanLapTop/js/jquery.min.js"></script>
</head>
<body>
	<form method="GET" action="TimKiem">
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
					<li><input
						style="margin-top: 10px; margin-left: 5px; border-radius: 5px 5px 5px 5px;"
						type="submit" value="Search"></li>
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
</body>
</html>