<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@page import="com.luvlove.dao.impl.HoaDonDAOImpl"%>
<%@page import="com.luvlove.dao.HoaDonDAO"%>
<%@page import="com.luvlove.model.DetailHoaDon"%>
<%@page import="com.luvlove.model.TaiKhoan"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<title>Lịch sử mua hàng</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="headerLogin.jsp"%>
	<%
	List<DetailHoaDon> list = new ArrayList<DetailHoaDon>();
	HoaDonDAO hd = new HoaDonDAOImpl();
	String username = session.getAttribute("username").toString();
	%>
	<div class="container">
	
	<h3 style="text-align: center;"> Lịch sử mua hàng  </h3>
	 
	<table class="table table-bordered table-striped mb-0"
		id="datatable-editable">
		<tr>

			<th style="text-align: center;">Tên sản phẩm</th>
			<th style="text-align: center;">Đơn giá sản phẩm</th>
			<th style="text-align: center;">Số lượng</th>
			<th style="text-align: center;">Ngày mua hàng</th>
			<th style="text-align: center;">Địa chỉ giao hàng</th>
			<th style="text-align: center;">Số điện thoại</th>
		</tr>
		
		
		<%
		for (DetailHoaDon detail : hd.getListHD()) {
		%>
		<%
		if (username.equals( detail.getMataikhoan()) ) {
		%>
		<tr>
			<td style="text-align: center;"><%=detail.getTensp()%></td>
			<td style="text-align: center;"><%=detail.getDongia()%></td>
			<td style="text-align: center;"><%=detail.getSoluong()%></td>
			<td style="text-align: center;"><%=detail.getNgaymuahang()%></td>
			<td style="text-align: center;"><%=detail.getDiachigiaohang()%></td>
			<td style="text-align: center;"><%=detail.getSdt()%></td>
		</tr>
		<%
		}
		%>
		<%
		}
		%>

	</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>