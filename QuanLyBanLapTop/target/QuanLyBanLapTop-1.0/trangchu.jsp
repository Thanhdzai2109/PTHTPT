<%@page import="com.luvlove.model.Giohang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" href="/QuanLyBanLapTop/css/style.css">
</head>

<body>
	<%
	 Giohang cart=(Giohang)session.getAttribute("cart");
       if(cart==null){
	   cart=new Giohang();
	   session.setAttribute("cart", cart);
      }
  %>
	<%@ include file="header.jsp" %>
	<div class="san-pham">
		<div class="container">
			<div class="row">
				<div class="san-pham-content">
					<div class="col-md-12 sp1">
						<h4 id="name"></h4>
					</div>
				</div>
				<div class="sanpham">
				
				</div>
			
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
	<button id="myBtn" title="Go to top">
		<i class="fa fa-angle-double-up"></i>
	</button>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/multislider.min.js"></script>
</body>
<script>
    //Khi người dùng cuộn chuột thì gọi hàm scrollFunction
    window.onscroll = function() {scrollFunction()};
    // khai báo hàm scrollFunction
    function scrollFunction() {
        // Kiểm tra vị trí hiện tại của con trỏ so với nội dung trang
        if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
            //nếu lớn hơn 20px thì hiện button
            document.getElementById("myBtn").style.display = "block";
        } else {
             //nếu nhỏ hơn 20px thì ẩn button
            document.getElementById("myBtn").style.display = "none";
        }
    }
    //gán sự kiện click cho button
    document.getElementById('myBtn').addEventListener("click", function(){
        //Nếu button được click thì nhảy về đầu trang
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    });
</script>

	<script type="text/javascript">
	document.getElementById("name").innerHTML = "Sản phẩm phù hợp";
	
	$.ajax({

			url: "http://localhost:8080/QuanLyBanLapTop/api/products", 
			type: "GET",
			success: function(resultdanhmuc){
				var texts= '';
				for(let i=0;i<resultdanhmuc.length;i++){
					texts += getElement_Product(resultdanhmuc[i]);
				}

				$(".sanpham").append(texts);
			},
			error: function(error){
				console.log(error);
			}
		});
		  function getElement_Product(resultdanhmuc) {
			return '<div class="col-md-3">'+
			'<div class="item1">'+
			'<img src="/QuanLyBanLapTop/'+resultdanhmuc.hinh_anh+'">'+
			'<div class="item1-conten">'+
			'<h4>'+resultdanhmuc.ten_san_pham+'</h4>'+
				'<h5>'+resultdanhmuc.don_gia+'đ</h5>'+
				'<a href="chitiet.jsp?ma_san_pham='+resultdanhmuc.ma_san_pham+'">Xem Chi Tiết</a>'+
				'</div>'+
			'</div>'+
			'</div>';
	
			
		}
		</script>
		
		
</html>
