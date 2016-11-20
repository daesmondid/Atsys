<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />

<!-- Stylesheets
	============================================= -->
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic|Play+Fair:700"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="style.css" type="text/css" />
<link rel="stylesheet" href="css/dark.css" type="text/css" />
<link rel="stylesheet" href="css/font-icons.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />

<!-- Range Slider CSS -->
<link rel="stylesheet" href="css/components/ion.rangeslider.css"
	type="text/css" />

<!-- Bootstrap Switch CSS -->
<link rel="stylesheet" href="css/components/bs-switches.css"
	type="text/css" />

<link rel="stylesheet" href="css/responsive.css" type="text/css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->

<link rel="stylesheet" href="css/colors.css" type="text/css" />

<!-- Document Title
	============================================= -->
<title>Range Sliders | Canvas</title>

<style>
.white-section {
	background-color: #FFF;
	padding: 25px 20px;
	-webkit-box-shadow: 0px 1px 1px 0px #dfdfdf;
	box-shadow: 0px 1px 1px 0px #dfdfdf;
	border-radius: 3px;
}

.white-section label {
	margin-bottom: 30px;
}

.dark .white-section {
	background-color: #333;
	-webkit-box-shadow: 0px 1px 1px 0px #444;
	box-shadow: 0px 1px 1px 0px #444;
}
</style>

</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<header id="header" class="transparent-header full-header"
			data-sticky-class="not-dark">

		<div id="header-wrap">

			<div class="container clearfix">

				<div id="primary-menu-trigger">
					<i class="icon-reorder"></i>
				</div>

				<!-- Logo
					============================================= -->
				<div id="logo">
					<a href="index.html" class="standard-logo"
						data-dark-logo="images/logo.svg"><img src="images/logo.svg"
						alt="Canvas Logo"></a> <a href="index.html" class="retina-logo"
						data-dark-logo="images/logo.svg"><img src="images/logo.svg"
						alt="Canvas Logo"></a>
				</div>
				<!-- #logo end -->

				<!-- Primary Navigation
					============================================= -->
				<nav id="primary-menu">

				<ul>
					<li><a href="index.html"><div>Setting</div></a></li>
					<li><a href="Logout"><div>Logout</div></a></li>
				</ul>

				</nav>
				<!-- #primary-menu end -->

			</div>

		</div>

		</header>
		<!-- #header end -->

		<!-- Page Title
		============================================= -->
		<!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">

		<div class="content-wrap nopadding">

			<div class="section nomargin">

				<div class="container clearfix">

					<div class="row common-height clearfix">

						<c:forEach items="${list}" var="audioSystem" varStatus="loop">
							<div class="col-md-4 col-sm-6 bottommargin-sm"
								data-animate="fadeInRight"
								data-delay="${500 + (200 * loop.index)}">
								<div class="white-section">
									<label><c:out value="${audioSystem.name}"></c:out></label> <br />
									<span class="label label-success"
										style="position: absolute; right: 35px; top: 25px;">Online</span>
									<input class="range_${loop.index}" />
									<center style="margin-top: 10px;">
										<h4 style="margin-bottom: 10px;">
											<span style="color: #999;">Power</span>
											<c:choose>
												<c:when test="${audioSystem.powerStatus == 0}">
												    OFF
												  </c:when>
												<c:when test="${audioSystem.powerStatus == 1}">
												    ON
												  </c:when>
											</c:choose>
										</h4>
										<div class="switch notopmargin">
											<input id="switch-toggle-${loop.index}"
												class="switch-toggle switch-flat switch-toggle-flat"
												type="checkbox"
												<c:choose>
												  <c:when test="${audioSystem.powerStatus == 1}">
												    checked
												  </c:when>
												</c:choose>>
											<label for="switch-toggle-${loop.index}"></label>
										</div>
									</center>
									<div class="line nomargin" style="margin: 10px 0px !important;"></div>
									<a href=""><i class="icon-settings2"
										style="font-size: 17px; line-height: 17px; margin-right: 10px;"></i></a>
									<a href=""><i class="icon-refresh"
										style="font-size: 17px; line-height: 17px; margin-right: 10px;"></i></a>
									<a href=""><i class="icon-chat-3"
										style="font-size: 17px; line-height: 17px; margin-right: 10px;"></i></a>
								</div>
							</div>
						</c:forEach>

					</div>


				</div>

			</div>
		</section>
		<!-- #content end -->

		<!-- Footer
		============================================= -->
		<!-- #footer end -->

	</div>
	<!-- #wrapper end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- External JavaScripts
	============================================= -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>

	<!-- Bootstrap Switch Plugin -->
	<script type="text/javascript" src="js/components/bs-switches.js"></script>

	<!-- Range Slider Plugin -->
	<script type="text/javascript" src="js/components/rangeslider.min.js"></script>
	<script type="text/javascript" src="js/components/moment.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script type="text/javascript" src="js/functions.js"></script>

	<script type="text/javascript">

		$(document).ready(function () {
			
			<c:forEach items="${list}" var="audioSystem" varStatus="loop">
				$(".range_${loop.index}").ionRangeSlider({
					min: 0,
					max: 100,
					from: <c:out value="${audioSystem.volumeLevel}"></c:out>
				});
			</c:forEach>

		});

	</script>

	<script>

		jQuery(".bt-switch").bootstrapSwitch();

	</script>

</body>
</html>