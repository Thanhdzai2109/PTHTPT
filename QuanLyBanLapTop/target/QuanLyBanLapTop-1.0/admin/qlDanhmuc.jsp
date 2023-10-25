<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Danh sách danh mục</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    body {
      font-family: "Lato", sans-serif;
    }
    table{
    width:100%;
    }
    .sidenav {
      height: 100%;
      width: 0;
      position: fixed;
      z-index: 1;
      top: 0;
      left: 0;
      background-color: #111;
      overflow-x: hidden;
      transition: 0.5s;
      padding-top: 60px;
    }

    .sidenav a {
      padding: 8px 8px 8px 32px;
      text-decoration: none;
      font-size: 25px;
      color: #818181;
      display: block;
      transition: 0.3s;
    }

    .sidenav a:hover {
      color: #f1f1f1;
    }

    .sidenav .closebtn {
      position: absolute;
      top: 0;
      right: 25px;
      font-size: 36px;
      margin-left: 50px;
    }

    #main {
      transition: margin-left .5s;
      padding: 16px;
    }

    @media screen and (max-height: 450px) {
      .sidenav {padding-top: 15px;}
      .sidenav a {font-size: 18px;}
    }
    .hic h1{
      text-align: center;
      color: white;
      background: black;
      padding: 10px;
      font-style: weight;
    }
    a{
      color: white;
      border-radius: 5px 5px 5px 5px;
    }
    tr{
       border: 3px solid black;
    }
  </style>
</head>
<body style="background:#D8D8D8; ">
    <div class="hic">
          <h1>SHOP COMPUTER ADMIN</h1>
    </div>
     <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="../admin/home">Quản lý sản phẩm</a>
        <a href="../admin/qldm">Quản lý danh mục</a>
        <a href="../admin/taikhoan">Quản lý tài khoản</a>
        <a href="../admin/hoadon">Xem lịch sử mua hàng</a>
    </div>
      <div id="main">
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menu</span>
     </div>
     <div class="row" >
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                 <table border="1" style="margin-bottom:0px; ">
      <div class="panel-body">
     <h1 style="font-style: bold;text-align: center;"><label style="background: gray;border-radius: 10px 10px 10px 10px;padding: 5px;color: white ">Quản Lý Danh Mục</label></h1>
      </div>
    <!-- Search form -->
<div class="md-form mt-0">
  <form action="/QuanLyBanLapTop/admin/qldm" method="GET" >
    <div class="row">
      <div class="col-sm-6">
           <input class="form-control"  name ="nameFind" type="text" placeholder="Search" aria-label="Search" style="width: 100%;">
      </div>
      <div class="col-sm-6">
            <button class="btn btn-warning" style="border-radius: 10px 10px 10px 10px; margin-bottom:10px;font-style: bold; width: 100px;" type="">Tìm</button>
            <button class="btn btn-warning" style="border-radius: 10px 10px 10px 10px; margin-bottom:10px;font-style: bold; width: 100px;" type=""><a style="  text-decoration: none;" href="../admin/addDanhMuc">Thêm DM</a></button>
      </div>    
    </div>
   
   
    </form>
</div>
    <thead>
      <tr>
        <th style="text-align: center;font-style: bold; padding: 5px;">Mã danh mục</th>
        <th style="text-align: center;font-style: bold;padding: 5px;">Tên danh mục</th>
        <th colspan="3" style="text-align: center;">Tùy chọn</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${dm}">
      <tr>
          <td style="text-align: center;">${item.ma_danh_muc}</td>
          <td style="text-align: center;">${item.ten_danh_muc}</td>
          <td><a href="../admin/editDanhMuc?maDanhMuc=${item.ma_danh_muc}" style="background: green;text-decoration: none;margin: 10px;">Sửa</a></td>
          <td> <a href="../admin/deleteDanhMuc?maDanhMuc=${item.ma_danh_muc}" style="background:red;text-decoration: none;margin: 10px;">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
            </div>
            <div class="col-sm-2"></div>
     </div>
</body>
<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
</html>
