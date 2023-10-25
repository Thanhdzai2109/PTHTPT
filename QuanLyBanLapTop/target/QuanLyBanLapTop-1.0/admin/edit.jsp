<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sửa sản phẩm</title>
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
      <a class="navbar-brand" href="#">SHOP COMPUTER</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    </div>
  </div>
</nav>
  
<div class="container">
  <div class="panel panel-default">
    <div class="panel-body">
   <h1 style="text-align: center;"> Sửa thông tin Sản  Phẩm</h1>
    </div>
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-body">
          <form method="POST" action="/QuanLyBanLapTop/admin/edits" enctype="multipart/form-data">
            <div class="form-group">
              <label for="">Tên product</label>
              <input name="name" class="form-control" placeholder="Tên product" value="${sanPham.ten_san_pham}">
            </div>
            <div class="form-group">
              <label for="">Giá</label>
              <input name="price" class="form-control" placeholder="Giá" value="${sanPham.don_gia}">
            </div>
            <div class="form-group">
              <label for="">So luong</label>
              <input type="number" name="total" class="form-control" placeholder="So luong product" value="${sanPham.so_luong}">
            </div>
            <div class="form-group">
                  <label for="">Danh mục sản phẩm</label>
                  <select name="category_id" class="form-control" >
                    <option value="">Chọn danh mục</option>
                    <c:forEach items="${list}" var="item">
                    	<option value="${item.ma_danh_muc}" <c:if test="${item.ma_danh_muc == sanPham.danh_muc}">selected</c:if>>${item.ten_danh_muc}</option>
                    </c:forEach>
                  </select>
                </div>
           <div class="form-group">
              <label for="">Ảnh product</label>
              <input type="file" name="file" />
              <img src="/QuanLyBanLapTop${sanPham.hinh_anh}" alt="" width="400"> 
            </div>
            <div class="form-group">
              <label for="">nôi dung</label>
             <textarea name="descriptsion" id="content" class="form-control" rows="3" >${sanPham.mo_ta}</textarea>
            </div>
            
            <input type="hidden" name="maSanPham" value="${sanPham.ma_san_pham}">
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
