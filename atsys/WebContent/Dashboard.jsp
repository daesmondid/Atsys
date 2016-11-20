<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />

<!-- Stylesheets
	============================================= -->
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="style.css" type="text/css" />
<link rel="stylesheet" href="css/dark.css" type="text/css" />
<link rel="stylesheet" href="css/font-icons.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />

<link rel="stylesheet" href="css/responsive.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->

<link rel="stylesheet" href="css/colors.css" type="text/css" />

<!-- SLIDER REVOLUTION 5.x CSS SETTINGS -->
<link rel="stylesheet" type="text/css"
	href="include/rs-plugin/css/settings.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="include/rs-plugin/css/layers.css">
<link rel="stylesheet" type="text/css"
	href="include/rs-plugin/css/navigation.css">

<!-- Document Title
	============================================= -->
<title>Atsys - Dashboard</title>

<style>
.revo-slider-emphasis-text {
	font-size: 64px;
	font-weight: 700;
	letter-spacing: -1px;
	font-family: 'Raleway', sans-serif;
	padding: 15px 20px;
	border-top: 2px solid #FFF;
	border-bottom: 2px solid #FFF;
}

.revo-slider-desc-text {
	font-size: 20px;
	font-family: 'Lato', sans-serif;
	width: 650px;
	text-align: center;
	line-height: 1.5;
}

.revo-slider-caps-text {
	font-size: 16px;
	font-weight: 400;
	letter-spacing: 3px;
	font-family: 'Raleway', sans-serif;
}

.tp-video-play-button {
	display: none !important;
}

.tp-caption {
	white-space: nowrap;
}
</style>

</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<%@include file="DefaultClientHead.jsp"%>
		<!-- #header end -->

		<!-- Content
		============================================= -->
		<section id="content">

		<div class="content-wrap">

			<div class="container clearfix">

				<div class="col_one_third" data-animate="bounceIn" data-delay="300">
					<div class="feature-box fbox-center fbox-light fbox-effect">
						<div class="fbox-icon">
							<a href="ClientLighting"><i class="icon-bulb i-alt"></i></a>
						</div>
						<h3>Lighting</h3>
					</div>
				</div>

				<div class="col_one_third" data-animate="bounceIn" data-delay="600">
					<div class="feature-box fbox-center fbox-light fbox-effect">
						<div class="fbox-icon">
							<a href="ClientDoorLock"><i class="icon-line2-lock i-alt"></i></a>
						</div>
						<h3>Door Lock</h3>
					</div>
				</div>

				<div class="col_one_third col_last" data-animate="bounceIn"
					data-delay="900">
					<div class="feature-box fbox-center fbox-light fbox-effect">
						<div class="fbox-icon">
							<a href="ClientGarageDoor"><i class="icon-line-columns i-alt"></i></a>
						</div>
						<h3>Garage Door</h3>
					</div>
				</div>

				<div class="col_one_third" data-animate="bounceIn" data-delay="1200">
					<div class="feature-box fbox-center fbox-light fbox-effect">
						<div class="fbox-icon">
							<a href="ClientClimate"><i class="icon-line-sun i-alt"></i></a>
						</div>
						<h3>Climate</h3>
					</div>
				</div>

				<div class="col_one_third" data-animate="bounceIn" data-delay="1500">
					<div class="feature-box fbox-center fbox-light fbox-effect">
						<div class="fbox-icon">
							<a href="ClientAppliances"><i
								class="icon-line2-screen-desktop i-alt"></i></a>
						</div>
						<h3>Appliances</h3>
					</div>
				</div>

				<div class="col_one_third col_last" data-animate="bounceIn"
					data-delay="1800">
					<div class="feature-box fbox-center fbox-light fbox-effect">
						<div class="fbox-icon">
							<a href="ClientAudioSystem"><i class="icon-music i-alt"></i></a>
						</div>
						<h3>Audio System</h3>
					</div>
				</div>

			</div>

		</div>

		</section>
		<!-- #content end -->

	</div>
	<!-- #wrapper end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- External JavaScripts
	============================================= -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script type="text/javascript" src="js/functions.js"></script>

</body>
</html>