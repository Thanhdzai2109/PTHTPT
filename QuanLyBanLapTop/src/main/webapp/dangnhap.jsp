<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/dangnhap.css">
	<link rel="stylesheet" media="screen" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
	
</head>
<body>

	<%@ include file="headerLogin.jsp" %>
<main class="main">
	<div class="conten">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div class="conten-left">
						<h3>Khách hàng mới</h3>
						<p><strong>Đăng ký</strong></p>
						<p>Bằng việc tạo tài khoản bạn có thể mua sắm nhanh hơn, theo dõi trạng thái đơn hàng, và theo dõi đơn hàng mà bạn đã đặt.</p>
						<button type="submit"><a href="DangKy" title="">Tiếp tục</a></button>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div class="conten-left">
						<h3>Khách hàng cũ</h3>
						<p><strong>Tôi là khách hàng cũ</strong></p>
						<form class="form-login" action="DangNhap" method="post" id="formLogin">
							<p style="color:red">${loi}</p>
							<label>Email</label><br>
								<input type="text" name="email" id="email" value="" placeholder="Email"><br>
							<label>Mật khẩu</label><br>
							<input type="password" name="matkhau" id="matkhau" value="" placeholder="Mật khẩu"><br>
							<p>Quên mật khẩu?</p>
							<button type="submit">Đăng nhập</button>
							<!--  -->
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
	<%@ include file="footer.jsp" %>
</body>
<!-- <script>
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
</script> -->
<script>
	/* pos  = $('#menutop').position();
	$(window).scroll(function(){
		var posscroll=$(document).scrollTop();
		if (parseInt(posscroll)>parseInt(pos.top)) {
			$("#menutop").addClass('fixed');
		}else{
			$("#menutop").removeClass('fixed');
		}
	}) */
	
		var matkhau_regex=/(?=^.{8,}$)/;	
		
		$('#formLogin').on('submit', function(e){
		      
			console.log("Test");
			var dienthoai= document.getElementById("email").value;
			var matkhau= document.getElementById("matkhau").value;
			

			if (dienthoai=="") {
				e.preventDefault();
				alert("Bạn chưa nhập email");
				
				return false;
			}
			if (!dienthoai.includes("@")) {
				e.preventDefault();
				alert("Email" + dienthoai + "không đúng định dạng");
				
				return false;
			}
			if (matkhau=="") {
				e.preventDefault();
				alert("Bạn chưa nhập mật khẩu");
				
				return false;
			}
			if (!matkhau_regex.test(matkhau)) {
				e.preventDefault();
				alert("Mật khẩu tối thiểu 8 ký tự");
				
				return false; 
			}
		})
		
</script>
<script type="text/javascript">
		
	</script>
</html>