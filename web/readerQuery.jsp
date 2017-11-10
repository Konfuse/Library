<%--
  Created by IntelliJ IDEA.
  User: 89789
  Date: 2017/10/24
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reader Querying</title>
    <link href="css3/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="css3/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css3/chocolat.css" type="text/css" media="screen"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Progress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script src="js/modernizr.custom.97074.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
    <!---->
    <script type="text/javascript" src="js2/move-top.js"></script>
    <script type="text/javascript" src="js2/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
            });
        });
    </script>
    <!---->
<style type="text/css">
       #list {
            color: #FFF;
            font-size:15px;
        }
</style>
</head>
<!--banner-->
<body>

<%
    String user_name = (String) request.getSession().getAttribute("ad_name");
%>
<div id="home" class="banner">
    <div class="header">
        <div class="container">
            <div class="logo">
                <a href="index.html"><img src="images/title.png"
                                          alt="xidian-logo" /></a> <h1><a href="#">XD Library Management System</a></h1>
            </div>
        </div>
    </div>
    <div class="top-menu">
        <div id="top" style="float:right;margin-right: 20px">
            <%
                if (user_name == null) {
            %>
            <a href="login.jsp">Sign in</a>
            <%
            } else {
            %>
            <a href="login.jsp">Sign out</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="query.jsp" title="<%=user_name%>" onclick="show()">Back to Query</a>
            <%
                }
            %>
        </div>
    </div>
        <div class="container" id="list">
        <table align="center" border="1" width="100%" style="border-collapse: separate; border-spacing: 20px;">
            <tr>
                <td>Reader</td>
                <td>PassWord</td>
            </tr>
            <%
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                String readerName = (String) request.getAttribute("readerName");
                String passWord = (String) request.getAttribute("passWord");
            %>
            <tr>
                <td><%=readerName%></td>
                <td><%=passWord%></td>
            </tr>
            </table>
        </div>
</div>
<!---->
<script src="js2/responsiveslides.min.js"></script>
<script>
    // You can also use "$(window).load(function() {"
    $(function () {
        $("#slider2").responsiveSlides({
            auto: true,
            pager: true,
            speed: 300,
            namespace: "callbacks",
        });
    });
</script>
<!---->
<div class="footer">
    <div class="container">
        <div class="copywrite">
            <p>Copyright &copy; 2015.Company name All rights reserved</p>
        </div>
        <div class="social">
            <a href="#"><i class="facebook"></i></a>
            <a href="#"><i class="twitter"></i></a>
            <a href="#"><i class="dribble"></i></a>
            <a href="#"><i class="google"></i></a>
            <a href="#"><i class="youtube"></i></a>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!---->
<script type="text/javascript">
    $(document).ready(function() {
        /*
        var defaults = {
        containerID: 'toTop', // fading element id
        containerHoverID: 'toTopHover', // fading element hover id
        scrollSpeed: 1200,
        easingType: 'linear'
        };
        */
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!---->
</body>
</html>
