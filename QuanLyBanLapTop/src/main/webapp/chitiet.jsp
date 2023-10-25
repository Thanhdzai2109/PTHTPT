
<%@page import="com.luvlove.model.SanPham"%>
<%@page import="com.luvlove.dao.impl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Chi tiết sản phẩm</title>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
  <%
  ProductDAOImpl spDAO=new ProductDAOImpl();
  SanPham sp=spDAO.getChiTietSP(Integer.parseInt(request.getParameter("ma_san_pham")));
  %>
   
	<%@ include file="headerLogin.jsp" %>
		<main>
			<div class="container-fluid">
			  <div class="container">
			  	   <h1> Chi Tiết Sản Phẩm</h1>
			  	   <div class="row">	
						<div class="col-sm-6">
								<img src="/QuanLyBanLapTop<%=sp.getHinh_anh()%>" alt style="width:100%;">
						</div>
						<div class="col-sm-2">
							 </div>
						<div class="col-sm-4">
							<div class="panel panel-success">
								<div class="panel-danger">
								     <h4 style="text-align: center;"><%=sp.getTen_san_pham()%></h4>
									 <h3 class="btn-warning"><%=sp.getDon_gia()%> đ</h3>
								</div>
							</div>
							<div class="panel panel-success">
								<h4 style="text-align: center;">Miêu Tả Sản Phẩm</h4>
								<div class="panel-danger" >
									 <p style="padding-left: 20px"><%=sp.getMo_ta()%></p>
								</div>
							</div>
							<div class="panel panel-success">
								<h4 style="text-align: center;">Khuyến mãi và bảo hành </h4>
								<div class="panel-danger" >
									 <p style="padding-left: 20px">Hiện Tại Chưa Có Khuyến Mại</p>
									
								</div>
							</div>
							<div class="panel panel-success">
								<div class="panel-danger" >
								<div  class="row">
									<div style="margin: 0px;padding: 0px;" class="col-sm-6">
										<button style="width: 100%" class="btn btn-success"><a href="trangchu.jsp" title="" style="color: black; text-decoration: none;text-align: center;color: white;" >Tiếp Tục Mua</a></button>
									</div>
									<div style="margin: 0px;padding: 0px;" class="col-sm-6">
		<button style="width: 100%" class="btn btn-warning"><a href="GioHangServlet?command=insert&ma_san_pham=<%=sp.getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>" title="" style="color: black; text-decoration: none;text-align: center;color: white;" >Thêm Vào Giỏ Hàng</a></button>
									</div>
								</div>
								</div>
							</div>
						</div>
			  	   </div>
			  </div>
			</div>
		</main>	
	<%@ include file="footer.jsp" %>
</body>
</html>