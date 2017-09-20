<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" media="all"
	href="css/stylelogin.css">
<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="all" />
<!-- font-awesome icons -->
<link
	href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700"
	rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700"
	rel="stylesheet">
<!-- //web-fonts -->

<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery.leanModal.min.js"></script>
<script src="js/numscroller-1.0.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script src="js/jarallax.js"></script>
<script src="js/Login.js"></script>
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/register.js"></script>
<script src="js/numscroller-1.0.js"></script>
<script src="js/commonJs.js"></script>
</head>
<body>
	<!-- banner -->
	<div class="banner">
		<div class="banner-agileinfo">
			<!-- header -->
			<div class="header">
				<div class="container">
					<div class="logo">
						<h1>
							<a href="index">Fes Booking</a>
						</h1>
					</div>
					<div class="social-w3licon">
						<div align="center">
							<c:if test="${sessionScope.user != null}">
								<a class="flatbtn" id="logout" href="user/logOut">Log out</a>
								<!-- ${pageContext.request.contextPath} -->
								<a href="register" class="flatbtn" id="myaccount">My account</a>
							</c:if>
							<c:if test="${sessionScope.user == null}">
								<a href="#loginmodal" class="flatbtn" id="modaltrigger">Log
									in</a>
								<!-- ${pageContext.request.contextPath} -->
								<a href="register" class="flatbtn" id="modaltrigger">Register</a>
							</c:if>							
						</div>
						<div id="loginmodal" style="display: none;" tabindex="1">
							<h1>User Login</h1>
							<label for="username">Username:</label> <input type="text"
								name="username" id="username" class="txtfield" tabindex="1"
								onBlur="usernameVerify()" />
							<div id="usernameResult"></div>
							<label for="password">Password:</label> <input type="password"
								name="password" id="password" class="txtfield" tabindex="2"
								onBlur="psdVerify()" />
							<div id="verifyPassword"></div>
							<div id="psdResult"></div>
							<label><input name="userType" id="userType1" type="radio"
								checked value="1">Individual</label> <label><input
								name="userType" id="userType2" type="radio" value="2">Organization</label>
							<br>
							<div align="center">
								<!-- call indexLogin.js to finish the transmission of login data -->
								<input type="button" id="loginbtn" class="flatbtn-blu hidemodal"
									value="Log In" tabindex="3" onClick="loginTopRequest()" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //header -->
		</div>
	</div>
	<!-- //banner  -->