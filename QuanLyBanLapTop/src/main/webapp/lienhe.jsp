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
        <h1 class="h1-lh">Liên hệ với chúng tôi</h1>
        <form class="mail-app" action="MailApp" method="post">
            <label class="lbl">To:</label>
            <input class="input-lh" type="text" name="to"  placeholder="VD: admin@gmail.com"/>
            
            <label class="lbl">Product:</label>
            <input class="input-lh" type="text" name="subject" placeholder="VD: Asius vio5" />
            
            <label class="lbl">Message:</label>
            <input class="input-lh" type="text" name="message" placeholder="VD: sản phầm đã hết" />
            
            <label class="lbl">Your email ID:</label>
            <input class="input-lh" type="text" name="user" placeholder="VD: user@gmail.com" >
            
            <label class="lbl">Password:</label>
            <input class="input-lh" type="password" name="pass"  placeholder="VD: ****** (> 8 ký tự)" />
            
            <label class="lbl"></label>
            <input class="btn-lh" type="submit" value="Send" />
        </form>
        <%@ include file="footer.jsp" %>
    </body>
</html>