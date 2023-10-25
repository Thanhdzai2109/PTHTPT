<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Thêm danh mục</title>
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
    <h1 style="text-align: center;">Thêm Danh Mục</h1>
    </div>
    <section class="content">
      <!-- Default box -->
      <c:if test="${not empty error}">
      <h2>${error}</h2>>
      </c:if>
      <div class="box">
        <div class="box-body">
         
          <form method="POST" action="/QuanLyBanLapTop/admin/addDanhMuc">
            <div class="form-group">
              <label for="">Tên Danh Mục</label>
              <input name="ten_danh_muc" class="form-control" placeholder="Tên Danh Mục">
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
</html>
