<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Thêm tài khoản</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<% 
  String ten_tai_khoan_err="";
  if(request.getAttribute("error")!=null){
    ten_tai_khoan_err=(String) request.getAttribute("error");
  }
%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="../admin/home">SHOP COMPUTER</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    </div>
  </div>
</nav>
  
<div class="container">
  <div class="panel panel-default">
    <div class="panel-body">
    <h1 style="text-align: center;">Thêm Tài Khoản</h1>
    </div>
    <section class="content">
      <!-- Default box -->
      <c:if test="${not empty error}">
      <h2>${error}</h2>>
      </c:if>
      <div class="box">
        <div class="box-body">
         
          <form method="POST" class="form-login"  action="/QuanLyBanLapTop/admin/addTaiKhoan" id="Register">
            <div class="form-group">
             <p style="color:red"><%=ten_tai_khoan_err%></p>
              <label for="">Tên Tài Khoản</label>
              <input name="ten_tai_khoan" class="form-control" placeholder="Tên "  id="email">
            </div>
             <div class="form-group">
              <label for="">Mật Khẩu</label>
              <input name="mat_khau" class="form-control" id="matkhau" placeholder="MK">
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Lưu lại</button>
            </div>
          </form>
        </div>
        <!-- /.box-body -->
      </div>
      <!-- /.box -->
    </section>
  </div>
</div>

</body>
<script type="text/javascript">
		var email_regex=/^([a-z]+)([0-9]+)\@([a-z]{3,10})\.([a-z]{2,4})$/;
		var matkhau_regex=/(?=^.{8,}$)/;	
		$('#Register').on('submit', function(e){
			var email= document.getElementById("email").value;
			var matkhau= document.getElementById("matkhau").value;
			if (email=="") {
				e.preventDefault();
				alert("bạn chưa nhập tên tài");
				return false;
			}
			if (!email_regex.test(email)) {
				e.preventDefault();
				alert("tên tài khoản không đúng định dạng");
				return false;
			}
			if (matkhau=="") {
				e.preventDefault();
				alert("bạn chưa nhập mật khẩu");
				return false;
			}
			if (!matkhau_regex.test(matkhau)) {
				e.preventDefault();
				alert("mật khẩu tối thiểu tám ký tự");
				return false; 
			}
		})
	</script>
</html>
