<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css2/style.css">
<style type="text/css">
.clear {
	clear: both;
}

#top_left {
	width: 100px;
	float: left;
}

#top_right {
	width: 220px;
	float: right;
	margin-top: 40px;
}

#top_right a {
	color: #000;
}

#top_right a:hover {
	color: #909;
}

#bottom_up {
	margin-top: 100px;
}

#bottom_down {
	margin-top: 250px;
}
</style>

<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.urn.value=="") {
			alert("Please enter the username!");
			document.forms.loginForm.account.focus();
			return false;
		}
		if (document.forms.loginForm.pwd.value=="") {
			alert("Please enter the password!");
			document.forms.loginForm.password.focus();
			return false;
		}
		
	}
    function librarian(form) {
        document.getElementById("isL").value = "true";
        return check(form);
    }
</script>
</head>
<body>
	<%
	request.getSession().invalidate();
	%>
	<h1>
		<font color="black">Library Management System</font>
	</h1>
	<div id="page">
		<div id="top">
			<div id="top_left">
				<img alt="" src="images/title.png">
			</div>
			<div id="top_right">
			</div>
		</div>
		<div class="clear"></div>

		<div id="bottom">
			<div id="bottom_up">
<div class="index-main">
    <div class="index-main-body">
        <div class="index-header">
            <h2 class="subtitle">XD  Library  Management  System</h2>
        </div>

        <div class="desk-front sign-flow clearfix sign-flow-simple">

            <div class="view view-signup selected" data-za-module="SignUpForm">
                <form class="zu-side-login-box" action="SignUpServlet" method="post" name="loginUpForm" id="sign-form-1" autocomplete="off">
                    <input type="password" hidden>
                    <input type="hidden" name="_xsrf" value="b84af75b5f7abfe28b10e84830ecbef6"/>
                    <div class="group-inputs">

                        <div class="name input-wrapper">
                            <input required type="text" name="urn" aria-label="Username" placeholder="Username">
                        </div>

                        <div class="input-wrapper">
                            <input required type="password" name="psw" aria-label="Password" placeholder="Password" autocomplete="off">
                        </div>

                        <div class="input-wrapper">
                            <input required type="password" name="c_psw" aria-label="Confirmation" placeholder="Confirmation" autocomplete="off">
                        </div>

                    </div>
                    <div class="button-wrapper command">
                        <button class="sign-button submit" type="submit" onclick="return check(this)">Register</button>
                    </div>
                </form>

            </div>
        </div>
    </div>

</div>
			</div>

			<div id="bottom_down"
				style="text-align: center; font: normal 14px/24px 'MicroSoft YaHei';">
				<p>Suitable browser：360、FireFox、Chrome、Safari、Opera、sougo and so
					on. IE8 and previous versions are not supported</p>
			</div>

		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/common.js"></script>
	<!--背景图片自动更换-->
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<!--表单验证-->
	<script src="js/jquery.validate.min.js?var1.14.0"></script>
	<script> 

  var errori ='<%=request.getParameter("error")%>';
		if (errori == 'yes') {
			alert("Login Failed!");
			window.location.href = 'login.jsp';
		}
	</script>
</body>
</html>