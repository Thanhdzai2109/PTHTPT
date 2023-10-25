<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lịch sử giao dịch</title>
          <style >
          table, th, tr,td {
            border:1px solid black;
            border-collapse: collapse;
           }
           
          </style>
    </head>
    <table >
    <tr>
        <th>mã tài khoản</th>
        <th>tên sản phẩm</th>
        <th>ngày mua hàng</th>
        <th>tên sản phẩm</th>
        <th>địa chỉ giao hàng</th>
        <th>số điện thoại</th>
    </tr>
    <c:forEach items="${listhoadon}" var="sp" varStatus="status">
        <tr>
            <td>${sp.mataikhoan}</td>
            <td>${sp.tensp}</td>
            <td>${sp.ngaymuahang}</td>
             <td>${sp.dongia}</td>
             <td>${sp.diachigiaohang}</td>
             <td>${sp.sdt}</td>
        </tr>
    </c:forEach>
</table>
           
</html>
