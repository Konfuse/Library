<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="PhotoBook Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="PhotoBook Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.11.0.min.js"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!--start-smoth-scrolling-->
</head>
<body>
	<!--header-->
	<div style="margin-bottom: 10px; width: 100%; height: 100px;">
		<div class="logo" style="left-margin: 0px; float: left">
			<a href="index2.html"><img src="images/title.png"
				alt="xidian-logo" /></a>
		</div>
		<div style="margin-top: 29px; float: left; font-size: 40px">
			<b>Xidian University</b>
		</div>
		<div
			style="margin-top: 40px; float: right; width: 200px; font-size: 20px">
			<a href="login.jsp">Sign out</a>
		</div>
	</div>

	<!--//header-->
	<!--search-scripts-->
	<script src="js/uisearch.js"></script>
	<script src="js/classie.js"></script>
	<script>
		new UISearch(document.getElementById('sb-search'));
	</script>
	<!--//search-scripts-->
	<!--banner-->
	<div class="banner">
		<div class="container">
			<div class="banner-top">
				<div class="jumbotron">
					<h1>XD Library Management System</h1>
					<p>Happy reading online</p>
					<div class="banner-btn">
						<form action="searchServlet" method="post">
							Please enter the title or author name： <br> <br> <input
								type="text" name="input" /> <br> <br>
							<button type="submit">Search</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--banner-->

	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-main">
				<div class="col-md-8 footer-left">
					<div class="col-md-4 footer-one">
						<ul>
							<li><a href="#">About us</a></li>
							<li><a href="#">Careers</a></li>
							<li><a href="#">Help</a></li>
						</ul>
					</div>
					<div class="col-md-4 footer-one">
						<ul>
							<li><a href="#">Terms</a></li>
							<li><a href="#">Payment</a></li>
							<li><a href="#">Shipping</a></li>
						</ul>
					</div>
					<div class="col-md-4 footer-one">
						<ul>
							<li><a href="#">LIGHTBOOK</a></li>
							<li><a href="#">CLASSICBOOK</a></li>
							<li><a href="#">PREMIUMBOOK</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-4 footer-right">
					<div class="footer-two">
						<ul>
							<li><a href="#"><span class="fb"></span></a></li>
							<li><a href="#"><span class="b"></span></a></li>
							<li><a href="#"><span class="cam"></span></a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="footer-bottom">
				<p>Copyright &copy; 2015.Company name All rights reserved</p>
			</div>
		</div>
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

				$().UItoTop({
					easingType : 'easeOutQuart'
				});

			});
		</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;">
			<span id="toTopHover" style="opacity: 1;"> </span>
		</a>
	</div>

	<!--footer-->
</body>
</html>