<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
				<!-- Modal Contact Form
				============================================= -->
				<a href="#" data-toggle="modal" data-target="#contactFormModal" class="button button-rounded button-mini nomargin" style="margin-top: 20px !important; margin-right: 5px !important;">Edit</a>

				<div class="modal fade" id="contactFormModal" tabindex="-1" role="dialog" aria-labelledby="contactFormModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="contactFormModalLabel">Edit Logic Board</h4>
							</div>
							<div class="modal-body">

								<div class="contact-widget">
									<div class="contact-form-result"></div>
									<form class="nobottommargin" id="template-contactform" name="template-contactform" action="LogicBoardEditProcess?id=${requestScope.logicBoard.id}" method="post">

										<div class="form-process"></div>

										<div class="col_full">
											<label for="template-contactform-name">Name <small>*</small></label>
											<input type="text" id="template-contactform-name" name="name" value="${requestScope.logicBoard.name}" class="required sm-form-control" />
										</div>

										<div class="clear"></div>

										<div class="col_half">
											<label for="template-contactform-user">User <small>*</small></label>
											<select id="template-contactform-user" name="userId" class="required sm-form-control" style="height: 40px;">
												<option value="">-- Select One --</option>
												<c:forEach items="${userList}" var="user">
													<c:choose>
														<c:when test="${user.id == requestScope.logicBoard.user.id}">
															<option value="${user.id}" selected>${user.name}</option>
														</c:when>
														<c:otherwise>
															<option value="${user.id}">${user.name}</option>
														</c:otherwise>
													</c:choose>
										  		</c:forEach>
											</select>
										</div>
										
										<div class="col_half col_last">
											<label for="template-contactform-ip">IP Address <small>*</small></label>
											<input type="text" id="template-contactform-ip" name="address" value="${requestScope.logicBoard.address}" class="required sm-form-control" />
										</div>

										<div class="clear"></div>

										<div class="col_full hidden">
											<input type="text" id="template-contactform-botcheck" name="template-contactform-botcheck" value="" class="sm-form-control" />
										</div>

										<div class="col_full">
											<button class="button button-3d nomargin" type="submit" id="template-contactform-submit" name="template-contactform-submit" value="submit">Save</button>
										</div>

									</form>

								</div>


							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal" onClick="window.location.reload()">Close</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				<!-- Modal Contact Form End -->
				<a href="LogicBoardDeleteProcess?id=${requestScope.logicBoard.id}" class="button button-rounded button-mini nomargin" style="margin-top: 20px !important;">Delete</a>
				<ol class="breadcrumb">
					<li><a href="LogicBoard">Logic Board List</a></li>
					<li class="active">Logic Board ${requestScope.logicBoard.id} Detail</li>
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

							<div class="heading-block noborder">
								<h3>${requestScope.logicBoard.name}</h3>
								<span>${requestScope.logicBoard.address}</span>
							</div>

							<div class="clear"></div>

							<div class="row clearfix">

								<div class="col-md-12">

									<div class="tabs tabs-alt clearfix" id="tabs-profile">

										<ul class="tab-nav clearfix">
											<li><a href="#tab-feeds"><i class="icon-line-paper-stack"></i> General</a></li>
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
														  <td>Name</td>
														  <td>${requestScope.logicBoard.name}</td>
														</tr>
														<tr>
														  <td>IP Address</td>
														  <td>${requestScope.logicBoard.address}</td>
														</tr>
														<tr>
														  <td>User</td>
														  <td><a href="UserDetail?id=${requestScope.logicBoard.user.id}" style="text-decoration: underline !important;">${requestScope.logicBoard.user.name}</a></td>
														</tr>
														<tr>
														  <td>Connection Status</td>
														  <c:forEach items="${connectionStatusList}" var="connectionStatus">
															  <c:choose>
																  <c:when test="${fn:containsIgnoreCase(connectionStatus, requestScope.logicBoard.connectionStatus)}">
																	  <c:choose>
																		  <c:when test="${connectionStatus == 'Online'}">
																			  <td><span class="label label-success">${connectionStatus}</span></td>
																		  </c:when>
																		  <c:otherwise>
																			  <td><span class="label label-default">${connectionStatus}</span></td>
																		  </c:otherwise>
																	  </c:choose>
																  </c:when>
															  </c:choose>
												  		  </c:forEach>
														</tr>
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