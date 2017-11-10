<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

</head>	
<!--banner-->
<body>
<%
		String user_name = (String) request.getSession().getAttribute("ad_name");
		long days = (long)request.getAttribute("days");
		double money = (double)request.getSession().getAttribute("money");
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
	 <div class="banner-form" style="margin-top: 50px">
		 <div class="container">
					<%
						if (user_name != null) {
					%>
					 <form action="PaymentServlet" method="post">
			 			<br>
			 			<a>Return Failed! You have expired <%=days%> days! Please pay first!</a><br>
						<input type="text" value="" placeholder=<%=money+"$"%> name="payment"><br>
						<input type="submit" value="Send">
						</form>
					<%
						} else {
					%>
						<a href="login.jsp">Please Login !</a>
					<%
						}
					%>
		 </div>
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