<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sửa tài khoản</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
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
   <h1 style="text-align: center;"> Sửa thông tin Danh Mục</h1>
    </div>
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-body">
            <form method="POST" action="/QuanLyBanLapTop/admin/editTaiKhoan">
            <div class="form-group">
              <label for="">Tên Tai Khoan</label>
              <input name="ten_tai_khoan" class="form-control" placeholder="Tên Danh Muc" value="${taikhoan.ten_dang_nhap}">
            </div>  
             <div class="form-group">
              <label for="">Quyền Truy Cập</label>
              <input name="quyentruycap" class="form-control" placeholder="Tên Danh Muc" value="${taikhoan.quyen_truy_cap}">
            </div>  
            <input type="hidden" name="ma_tai_khoan" value="${taikhoan.ma_tai_khoan}">
             <div class="form-group">
              <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i>Sua</button>
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
</html>