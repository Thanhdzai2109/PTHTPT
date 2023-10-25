<%@page import="java.util.Map"%>
<%@page import="com.luvlove.model.ChiTietHoaDon"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.luvlove.model.HoaDon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		
		HoaDon cart = (Giohang) session.getAttribute("cart");
		
		session.setAttribute("cart", cart);
		
		TreeMap<SanPham, Integer> list = cart.getList();
	%>
	<%@ include file="headerLogin.jsp"%>
	<div class="bang">
		<div class="container">
			<div class="row">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center">Ảnh</th>
								<th class="text-center">Sản phẩm</th>
								<th class="text-center">Đơn giá</th>
								<th class="text-center">Số lượng</th>
								<th class="text-center">Tổng</th>
								<th class="text-center">Thành tiền</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
							%>
							<tr>
								<td class="text-center"><img
									src="/QuanLyBanLapTop<%=ds.getKey().getHinh_anh()%>" alt=""
									width="100px" height="100px"></td>
								<td class="text-center"><%=ds.getKey().getTen_san_pham()%></td>
								<td class="text-center"><%=ds.getKey().getDon_gia()%></td>
								<td class="text-center"><a
									href="GioHangServlet?command=sub&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>">-</a>
									<input type="text" value="<%=ds.getValue()%>"
									autocomplete="off" value="1" size="2" disabled=""> <a
									href="GioHangServlet?command=plus&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>">+</a>
								</td>
								<td class="text-center" id="pr_1"><%=ds.getValue() * ds.getKey().getDon_gia()%></td>
								<td class="text-center" id="tt_1"><%=ds.getValue() * ds.getKey().getDon_gia()%></td>
							</tr>
							<div type="hidden"
								value="<%=pay += ds.getValue() * ds.getKey().getDon_gia()%>"></div>
							<%
								}
							%>
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5" class="text-left">Tổng tiền</td>
								<td class="text-center" id="tongtien"><%=pay%></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<div id="tieptuc">
					<a href="trangchu.jsp" title=""><h4>Tiếp tục mua hàng</h4></a>
				</div>
				<div id="thanhtoan">
					<a href="thanhtoan.jsp" title=""><h4>Tiến hành thanh toán</h4></a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	 <%}
 	 %>
</body>
</html>