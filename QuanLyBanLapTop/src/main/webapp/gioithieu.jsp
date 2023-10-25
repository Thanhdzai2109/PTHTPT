<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Liên hệ </title>
        <link rel="stylesheet" href="css/lienhe.css">
        <link rel="stylesheet" href="css/custom.css">
        <link rel="stylesheet" media="screen" href="css/bootstrap.min.css">
    </head>
    <body>
        <%@ include file="headerLogin.jsp" %>
        <h1 class="h1-lh">Giới thiệu về cửa hàng</h1>
        <div class="container">
         <div id="map"> <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3516.1857989706114!2d105.78503872759333!3d20.981843909854955!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135accdd8a1ad71%3A0xa2f9b16036648187!2zSOG7jWMgdmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IGNow61uaCB2aeG7hW4gdGjDtG5n!5e0!3m2!1svi!2s!4v1652356195942!5m2!1svi!2s" width="100%" height="300px" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe></div>
        <div class="row">


            <div class="col-md-4">
                <h2 class="light-title"><strong>Thông tin liên hệ</strong></h2>

                <div class="contact-info">
                    <div>
                        <i class="icon-mobile"></i>
                        <p><a href="tel:">Số điện thoại: 098989898</a></p>
                    </div>
                    <div>
                        <i class="icon-mail-alt"></i>
                        <p><a href="mailto:#">Gmail: thanhdzai2109@gmail.com</a></p>
                    </div>
                </div><!-- End .contact-info -->
            </div><!-- End .col-md-4 -->
        </div><!-- End .row -->
    </div><!-- End .container -->

        <%@ include file="footer.jsp" %>
    </body>
</html>