<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link rel="stylesheet" href="css/dark.css" type="text/css" />
	<link rel="stylesheet" href="css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="css/animate.css" type="text/css" />
	<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />
	<link rel="stylesheet" href="css/calendar.css" type="text/css" />
	
	<!-- Bootstrap Data Table Plugin -->
	<link rel="stylesheet" href="css/components/bs-datatable.css" type="text/css" />

	<link rel="stylesheet" href="css/responsive.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->
	
	<link rel="stylesheet" href="css/colors.css" type="text/css" />

	<!-- Document Title
	============================================= -->
	<title>Vertical Navigation Tree | Canvas</title>

<style>

#vertical-nav {
	position: fixed;
	top: 0;
	left: 0;
	width: 240px;
	z-index: 99;
	background: #F9F9F9;
	border-right: 1px solid #EEE;
	height: 100%;
	overflow: auto;
	padding: 140px 0 40px;
	-webkit-transition: padding .4s ease;
	-o-transition: padding .4s ease;
	transition: padding .4s ease;
}

.sticky-header + #vertical-nav { padding-top: 100px; }

#vertical-nav nav ul {
	margin-bottom: 0;
	list-style: none;
}

#vertical-nav nav li a {
	display: block;
	padding: 10px 30px;
	color: #333;
	text-transform: uppercase;
	font-size: 13px;
	font-weight: 700;
	letter-spacing: 2px;
	font-family: 'Raleway', sans-serif;
}

#vertical-nav nav li i {
	font-size: 14px;
	width: 16px;
	text-align: center;
}

#vertical-nav nav li i:not(.icon-angle-down) {
	margin-right: 8px;
	position: relative;
	top: 1px;
}

#vertical-nav nav li a i.icon-angle-down {
	width: auto;
	margin-left: 5px;
}

#vertical-nav nav li:hover > a,
#vertical-nav nav li.current > a,
#vertical-nav nav li.active > a {
	background-color: #FFF;
	color: #1ABC9C;
}

#vertical-nav nav ul ul { display: none; }

#vertical-nav nav ul ul a {
	font-size: 12px;
	letter-spacing: 1px;
	padding-left: 45px;
	font-family: 'Lato', sans-serif;
}

#vertical-nav nav ul ul a i.icon-angle-down { font-size: 12px; }

#vertical-nav nav ul ul ul a { padding-left: 60px; }
#vertical-nav nav ul ul ul ul a { padding-left: 75px; }

@media (min-width: 992px) {

	#header { z-index: 199; }

	#page-title,
	#content,
	#footer { margin-left: 240px; }

	#page-title .container,
	#content .container,
	#footer .container {
		width: auto;
		padding: 0 60px;
	}

	#vertical-nav .container {
		width: 100%;
		padding: 0;
	}

	#page-title .breadcrumb { right: 60px !important; }

}


@media (max-width: 991px) {

	#vertical-nav {
		position: relative;
		width: 100%;
		z-index: auto;
		border: none;
		border-bottom: 1px solid #EEE;
		height: auto;
		padding: 0;
	}

	#vertical-nav .container { padding: 10px 20px; }

	#vertical-nav nav li a { padding: 10px 0; }

	#vertical-nav nav li:hover > a,
	#vertical-nav nav li.current > a,
	#vertical-nav nav li.active > a { background-color: transparent; }

	#vertical-nav nav ul ul a { padding-left: 15px; }
	#vertical-nav nav ul ul ul a { padding-left: 30px; }
	#vertical-nav nav ul ul ul ul a { padding-left: 45px; }

}

</style>

</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<%@include file="DefaultHead.jsp" %>
		<!-- #header end -->

		<%@include file="DefaultSidebar.jsp" %>

		<!-- Page Title
		============================================= -->
		<section id="page-title">

			<div class="container clearfix">
				<h1>Logic Board Detail</h1>
				<a href="#" class="button button-rounded button-mini nomargin" style="margin-top: 20px !important; margin-right: 5px !important;">Edit</a>
				<a href="LogicBoardDelete?id=${requestScope.logicBoard.id}" class="button button-rounded button-mini nomargin" style="margin-top: 20px !important;">Delete</a>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Functionality</a></li>
					<li class="active">Navigation Tree</li>
				</ol>
			</div>
			
		</section><!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">

					<div class="row clearfix">

						<div>

							<img src="images/icons/avatar.jpg" class="alignleft img-circle img-thumbnail notopmargin nobottommargin" alt="Avatar" style="max-width: 84px;">

							<div class="heading-block noborder">
								<h3>${requestScope.logicBoard.name}</h3>
								<span>Your Profile Bio</span>
							</div>

							<div class="clear"></div>

							<div class="row clearfix">

								<div class="col-md-12">

									<div class="tabs tabs-alt clearfix" id="tabs-profile">

										<ul class="tab-nav clearfix">
											<li><a href="#tab-feeds"><i class="icon-desktop"></i> General</a></li>
											<li><a href="#tab-lighting"><i class="icon-phone3"></i> Lighting</a></li>
											<li><a href="#tab-doorLock"><i class="icon-phone3"></i> Door Lock</a></li>
											<li><a href="#tab-climate"><i class="icon-phone3"></i> Climate</a></li>
											<li><a href="#tab-appliances"><i class="icon-phone3"></i> Appliances</a></li>
											<li><a href="#tab-garageDoor"><i class="icon-phone3"></i> Garage Door</a></li>
											<li><a href="#tab-audioSystem"><i class="icon-phone3"></i> Audio System</a></li>
										</ul>

										<div class="tab-container">

											<div class="tab-content clearfix" id="tab-feeds">
												
												<div class="table-responsive">
													<table class="table table-bordered">
													  <colgroup>
														<col class="col-xs-1">
														<col class="col-xs-7">
													  </colgroup>
													  <tbody>
														<tr>
														  <td>ID</td>
														  <td>${requestScope.logicBoard.id}</td>
														</tr>
														<tr>
														  <td>Address</td>
														  <td>${requestScope.logicBoard.address}</td>
														</tr>
														<tr>
														  <td>User ID</td>
														  <td>${requestScope.logicBoard.user.id}</td>
														</tr>
														<tr>
														  <td>Connection Status</td>
														  <td>${requestScope.logicBoard.connectionStatus}</td>
														</tr>
													  </tbody>
													</table>
												  </div>

											</div>
											<div class="tab-content clearfix" id="tab-lighting">

												<div class="table-responsive">
							
													<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
														<thead>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Intensity</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</thead>
														<tfoot>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Intensity</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</tfoot>
														<tbody>
														<c:forEach items="${lightingList}" var="lighting">
															<tr onclick="document.location='LightingDetail?id=<c:out value="${lighting.id}"></c:out>'" style="cursor: pointer;">
																<td><c:out value="${lighting.id}"></c:out></td>
																<td><c:out value="${lighting.name}"></c:out></td>
																<td><c:out value="${lighting.intensity}"></c:out></td>
																<td><c:out value="${lighting.deviceId}"></c:out></td>
																<td><c:out value="${lighting.logicBoard.id}"></c:out></td>
																<td><c:out value="${lighting.pin}"></c:out></td>
															</tr>
														</c:forEach>
													</table>
							
												</div>

											</div>
											<div class="tab-content clearfix" id="tab-doorLock">

												<div class="table-responsive">
							
													<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
														<thead>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Lock Status</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</thead>
														<tfoot>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Lock Status</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</tfoot>
														<tbody>
														<c:forEach items="${doorLockList}" var="doorLock">
															<tr onclick="document.location='DoorLockDetail?id=<c:out value="${doorLock.id}"></c:out>'" style="cursor: pointer;">
																<td><c:out value="${doorLock.id}"></c:out></td>
																<td><c:out value="${doorLock.name}"></c:out></td>
																<td><c:out value="${doorLock.lockStatus}"></c:out></td>
																<td><c:out value="${doorLock.deviceId}"></c:out></td>
																<td><c:out value="${doorLock.logicBoard.id}"></c:out></td>
																<td><c:out value="${doorLock.pin}"></c:out></td>
															</tr>
														</c:forEach>
														</tbody>
													</table>
							
												</div>

											</div>
											<div class="tab-content clearfix" id="tab-climate">

												<div class="table-responsive">
							
													<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
														<thead>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Power Status</th>
																<th>Device ID</th>
																<th>Temperature</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</thead>
														<tfoot>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Power Status</th>
																<th>Device ID</th>
																<th>Temperature</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</tfoot>
														<tbody>
														<c:forEach items="${climateList}" var="climate">
															<tr onclick="document.location='ClimateDetail?id=<c:out value="${climate.id}"></c:out>'" style="cursor: pointer;">
																<td><c:out value="${climate.id}"></c:out></td>
																<td><c:out value="${climate.name}"></c:out></td>
																<td><c:out value="${climate.powerStatus}"></c:out></td>
																<td><c:out value="${climate.deviceId}"></c:out></td>
																<td><c:out value="${climate.temperature}"></c:out></td>
																<td><c:out value="${climate.logicBoard.id}"></c:out></td>
																<td><c:out value="${climate.pin}"></c:out></td>
															</tr>
														</c:forEach>
														</tbody>
													</table>
							
												</div>

											</div>
											<div class="tab-content clearfix" id="tab-appliances">

												<div class="table-responsive">
							
													<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
														<thead>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Power Status</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</thead>
														<tfoot>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Power Status</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</tfoot>
														<tbody>
														<c:forEach items="${appliancesList}" var="appliances">
															<tr onclick="document.location='AppliancesDetail?id=<c:out value="${appliances.id}"></c:out>'" style="cursor: pointer;">
																<td><c:out value="${appliances.id}"></c:out></td>
																<td><c:out value="${appliances.name}"></c:out></td>
																<td><c:out value="${appliances.powerStatus}"></c:out></td>
																<td><c:out value="${appliances.deviceId}"></c:out></td>
																<td><c:out value="${appliances.logicBoard.id}"></c:out></td>
																<td><c:out value="${appliances.pin}"></c:out></td>
															</tr>
														</c:forEach>
														</tbody>
													</table>
							
												</div>

											</div>
											<div class="tab-content clearfix" id="tab-garageDoor">

												<div class="table-responsive">
							
													<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
														<thead>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Door Status</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</thead>
														<tfoot>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Door Status</th>
																<th>Device ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</tfoot>
														<tbody>
														<c:forEach items="${garageDoorList}" var="garageDoor">
															<tr onclick="document.location='GarageDoorDetail?id=<c:out value="${garageDoor.id}"></c:out>'" style="cursor: pointer;">
																<td><c:out value="${garageDoor.id}"></c:out></td>
															<td><c:out value="${garageDoor.name}"></c:out></td>
															<td><c:out value="${garageDoor.doorStatus}"></c:out></td>
															<td><c:out value="${garageDoor.deviceId}"></c:out></td>
															<td><c:out value="${garageDoor.logicBoard.id}"></c:out></td>
															<td><c:out value="${garageDoor.pin}"></c:out></td>
															</tr>
														</c:forEach>
														</tbody>
													</table>
							
												</div>

											</div>
											<div class="tab-content clearfix" id="tab-audioSystem">

												<div class="table-responsive">
							
													<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
														<thead>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Power Status</th>
																<th>Device ID</th>
																<th>Volume Level</th>
																<th>Music ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</thead>
														<tfoot>
															<tr>
																<th>ID</th>
																<th>Name</th>
																<th>Power Status</th>
																<th>Device ID</th>
																<th>Volume Level</th>
																<th>Music ID</th>
																<th>Logic Board ID</th>
																<th>Pin</th>
															</tr>
														</tfoot>
														<tbody>
														<c:forEach items="${audioSystemList}" var="audioSystem">
															<tr onclick="document.location='AudioSystemDetail?id=<c:out value="${audioSystem.id}"></c:out>'" style="cursor: pointer;">
																<td><c:out value="${audioSystem.id}"></c:out></td>
																<td><c:out value="${audioSystem.name}"></c:out></td>
																<td><c:out value="${audioSystem.powerStatus}"></c:out></td>
																<td><c:out value="${audioSystem.deviceId}"></c:out></td>
																<td><c:out value="${audioSystem.volumeLevel}"></c:out></td>
																<td><c:out value="${audioSystem.musicId}"></c:out></td>
																<td><c:out value="${audioSystem.logicBoard.id}"></c:out></td>
																<td><c:out value="${audioSystem.pin}"></c:out></td>
															</tr>
														</c:forEach>
														</tbody>
													</table>
							
												</div>

											</div>

										</div>

									</div>

								</div>

							</div>

						</div>

						<div class="line visible-xs-block"></div>

					</div>

				</div>

			</div>

		</section><!-- #content end -->

		<!-- Footer
		============================================= -->
		<!-- #footer end -->

	</div><!-- #wrapper end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- External JavaScripts
	============================================= -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>
	
	<!-- Bootstrap Data Table Plugin -->
	<script type="text/javascript" src="js/components/bs-datatable.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script type="text/javascript" src="js/functions.js"></script>

	<script type="text/javascript">
		jQuery(document).ready(function($){
			$( '#vertical-nav nav ul li:has(ul)' ).addClass('sub-menu');
			$( '#vertical-nav nav ul li:has(ul) > a' ).append( ' <i class="icon-angle-down"></i>' );

			$( '#vertical-nav nav ul li:has(ul) > a' ).click( function(e){
				var element = $(this);
				$( '#vertical-nav nav ul li' ).not(element.parents()).removeClass('active');
				element.parent().children('ul').slideToggle( function(){
					$(this).find('ul').hide();
					$(this).find('li.active').removeClass('active');
				});
				$( '#vertical-nav nav ul li > ul' ).not(element.parent().children('ul')).not(element.parents('ul')).slideUp();
				element.parent('li:has(ul)').toggleClass('active');
				e.preventDefault();
			});
		});
	</script>
	
	<script>

		$(document).ready(function() {
			$('#datatable1').DataTable();
		});

	</script>
	
	<script>
		jQuery( "#tabs-profile" ).on( "tabsactivate", function( event, ui ) {
			jQuery( '.flexslider .slide' ).resize();
		});
	</script>

</body>
</html>