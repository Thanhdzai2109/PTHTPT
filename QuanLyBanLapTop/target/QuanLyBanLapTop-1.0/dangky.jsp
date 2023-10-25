<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="css/dangky.css">
	<link rel="stylesheet" href="css/custom.css">
	<link rel="stylesheet" media="screen" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
</head>
<body>
	<% 
	String ten_tai_khoan_err="";
	if(request.getAttribute("error")!=null){
		ten_tai_khoan_err=(String) request.getAttribute("error");
		}
	%>
	<%@ include file="headerLogin.jsp" %>
<main class="main">
	<div class="container dky-taikhoan">
		<div class="row">
			<form class="form-login" action="CheckDangKy" method="POST" id="Register">
			<h1 style="text-align: center;font: bold;">Đăng ký tài khoản</h1>
			<div class="dky">
				<div class="form-dky">
					<p style="color:red"><%=ten_tai_khoan_err%></p>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<label>Họ & tên</label>
					</div>
					<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
						<input type="text" name="hoten" id="hoten" value="" placeholder="Họ & tên">
					</div>					
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<label>Email</label>
					</div>
					<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
						<input type="text" name="email" id="email" value="" placeholder="Email">
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<label>Mật khẩu</label>
					</div>
					<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
						<input type="password" name="matkhau" id="matkhau" value="" placeholder="Mật khẩu">
					</div>
					
					
					
				</div>
				<button type="submit">Đăng ký</button>
			</div>
			</form>
		</div>
	</div>
	
</main>
<%@ include file="footer.jsp" %>
<button id="myBtn" title="Go to top"><i class="fa fa-angle-double-up"></i></button>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>	
<script src="js/multislider.min.js"></script>
</body>
	<script type="text/javascript">
		var hoten_regex=/^([A-Z _]){4,8}/;
		var email_regex=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		var matkhau_regex=/(?=^.{8,}$)/;	
		$('#Register').on('submit', function(e){
			var hoten= document.getElementById("hoten").value;
			var email= document.getElementById("email").value;
			var matkhau= document.getElementById("matkhau").value;
			if (hoten=="") {
				e.preventDefault();
				alert("Bạn chưa nhập họ tên");
				return false;
			}
			if (!hoten_regex.test(hoten)) {
				e.preventDefault();
				alert("Họ tên cần in hoa");
				return false;
			}
			if (email=="") {
				e.preventDefault();
				alert("Bạn chưa nhập email");
				return false;
			}
			if (!email_regex.test(email)) {
				e.preventDefault();
				alert("Email không đúng định dạng");
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
<script>
	$('#exampleSlider').multislider({
	interval: 4000,
	slideAll: true,
	duration: 2000
	});
</script>
<script>
	pos  = $('#menutop').position();
	$(window).scroll(function(){
		var posscroll=$(document).scrollTop();
		if (parseInt(posscroll)>parseInt(pos.top)) {
			$("#menutop").addClass('fixed');
		}else{
			$("#menutop").removeClass('fixed');
		}
	})
</script>
</html>
