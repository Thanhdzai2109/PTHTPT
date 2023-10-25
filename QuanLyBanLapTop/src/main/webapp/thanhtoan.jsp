<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/QuanLyBanLapTop/css/style.css">
<link rel="stylesheet" href="/QuanLyBanLapTop/css/custom.css">
<link rel="stylesheet" media="screen" href="/QuanLyBanLapTop/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
<script src="/QuanLyBanLapTop/js/jquery.min.js"></script>
</head>
<body>
	<% 
	String ten_tai_khoan_err="";
	if(request.getAttribute("success")!=null){
		ten_tai_khoan_err=(String) request.getAttribute("success");
	}
%>
	<%@ include file="headerLogin.jsp" %>
	<main class="main">
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form action="ThanhToanServlet" method="POST" role="form">
		<legend style="text-align: center;">Hoàn thành thông tin đơn hàng</legend>
	
		<div class="form-group">
			<label for="">Địa chỉ giao hàng</label>
			<input type="text" class="form-control" id="diachi" name="diachi" placeholder="Nhập địa chỉ">
		</div>
		<div class="form-group">
			<label for="">Số điện thoại</label>
			<input type="text" class="form-control" id="sdt" name="sdt" placeholder="Nhập số điện thoại">
		</div>
		<select id="input" name="input" class="form-control" required="required">
			<option value="ATM">ATM</option>
			<option value="Tiền Mặt">Tiền mặt</option>
		</select>
		<input type="hidden" name="username" value="<%=session.getAttribute("username")%>"></input>
		<button style="margin-top: 20px;" type="submit" class="btn btn-primary">Xác nhận</button>
		   <p style="color:red"><%=ten_tai_khoan_err%></p>
	</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</main>
	<%@ include file="footer.jsp" %>
	
</body>
</html>