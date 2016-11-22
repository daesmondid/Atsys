<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic|Play+Fair:700" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link rel="stylesheet" href="css/dark.css" type="text/css" />
	<link rel="stylesheet" href="css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="css/animate.css" type="text/css" />
	<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />
	
	<!-- Bootstrap Switch CSS -->
	<link rel="stylesheet" href="css/components/bs-switches.css" type="text/css" />

	<link rel="stylesheet" href="css/responsive.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
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

		.white-section label { margin-bottom: 30px; }

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
		<%@include file="DefaultClientHead.jsp" %>
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
						
							<c:forEach items="${climateList}" var="climate" varStatus="loop">
								<c:choose>
									<c:when test="${climate.logicBoard.user.id == requestScope.sessionUser.id}">
										<div class="col-md-4 col-sm-6 bottommargin-sm" data-animate="fadeInRight" data-delay="${500 + (200 * loop.index)}">
											<div class="white-section">
												<label><c:out value="${climate.name}"></c:out></label>
												<br />
												<c:choose>
												  <c:when test="${climate.logicBoard.connectionStatus == 'UNKNOWN'}">
												    <span class="label label-default" style="position:absolute; right: 35px; top: 25px;">Unknown</span>
												  </c:when>
												  <c:when test="${climate.logicBoard.connectionStatus == 'OFFLINE'}">
												    <span class="label label-default" style="position:absolute; right: 35px; top: 25px;">Offline</span>
												  </c:when>
												  <c:when test="${climate.logicBoard.connectionStatus == 'ONLINE'}">
												    <span class="label label-success" style="position:absolute; right: 35px; top: 25px;">Online</span>
												  </c:when>
												</c:choose>
												<div class="rounded-skill" data-color="#020b48" data-size="100" data-percent="${(climate.temperature / 30.0) * 100}" data-width="4" data-speed="3000" data-delay="2000" style="margin-right: 20px;">
													<div class="counter counter-inherit"><span id="temp-value-${loop.index}" data-from="1" data-to="<c:out value="${climate.temperature}"></c:out>" data-refresh-interval="50" data-speed="2500"></span>&deg;C</div>
												</div>
												<a id="switch-btn-inc-${loop.index}" href="#" class="button button-xlarge button-dark button-rounded tright">+</a>
												<a id="switch-btn-dec-${loop.index}" href="#" class="button button-xlarge button-dark button-rounded tright">-</a>
												<center>
													<h4 style="margin-bottom: 10px;"><span style="color: #999;">Power</span> <span id="switch-label-${loop.index}">
													<c:choose>
														  <c:when test="${climate.powerStatus == 'UNKNOWN'}">
														    UNKNOWN
														  </c:when>
														  <c:when test="${climate.powerStatus == 'OFF'}">
														    OFF
														  </c:when>
														  <c:when test="${climate.powerStatus == 'ON'}">
														    ON
														  </c:when>
														</c:choose>
													</span></h4>
													<div class="switch notopmargin" >
														<input id="switch-toggle-${loop.index}" class="switch-toggle switch-flat switch-toggle-flat" type="checkbox"  
														<c:choose>
														  <c:when test="${climate.powerStatus == 'ON'}">
														    checked
														  </c:when>
														</c:choose>
														>
														<label for="switch-toggle-${loop.index}"></label>
													</div>
												</center>
												<div class="line nomargin" style="margin: 10px 0px !important;"></div>
												<a href=""><i class="icon-settings2" style="font-size: 17px; line-height: 17px; margin-right: 10px;"></i></a>
												<a href=""><i class="icon-refresh" style="font-size: 17px; line-height: 17px; margin-right: 10px;"></i></a>
												<a href=""><i class="icon-chat-3" style="font-size: 17px; line-height: 17px; margin-right: 10px;"></i></a>
											</div>
										</div>
									</c:when>
								</c:choose>
							</c:forEach>

						</div>

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

	<!-- Bootstrap Switch Plugin -->
	<script type="text/javascript" src="js/components/bs-switches.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script type="text/javascript" src="js/functions.js"></script>
	
	<script type="text/javascript">

		$(document).ready(function () {
			
			<c:forEach items="${climateList}" var="climate" varStatus="loop">
				$("#switch-toggle-${loop.index}").change(function(){
					if (this.checked) {
						$.post("ClientClimateEditPowerProcess",
							    {
							        id: "${climate.id}",
							        power: 3
							    },
							    function(data, status){
							        //alert("Data: " + data + "\nStatus: " + status);
							    }); 
						$("#switch-label-${loop.index}").html("ON");
				    } else {
				    	$.post("ClientClimateEditPowerProcess",
							    {
							        id: "${climate.id}",
							        power: 2
							    },
							    function(data, status){
							        //alert("Data: " + data + "\nStatus: " + status);
							    });
				    	$("#switch-label-${loop.index}").html("OFF");
				    }
			    });
				
				$("#switch-btn-inc-${loop.index}").click(function(){
					$.post("ClientClimateEditTemperatureProcess",
						    {
						        id: "${climate.id}",
						        temperature: 1
						    },
						    function(data, status){
						        //alert("Data: " + data + "\nStatus: " + status);
						    }); 
					$("#temp-value-${loop.index}").html(parseInt($("#temp-value-${loop.index}").html(), 10)+1);
			    });
				
				$("#switch-btn-dec-${loop.index}").click(function(){
					$.post("ClientClimateEditTemperatureProcess",
						    {
						        id: "${climate.id}",
						        temperature: -1
						    },
						    function(data, status){
						        //alert("Data: " + data + "\nStatus: " + status);
						    }); 
					$("#temp-value-${loop.index}").html(parseInt($("#temp-value-${loop.index}").html(), 10)-1);
			    });
			</c:forEach>

		});

	</script>
	
	<script>

		jQuery(".bt-switch").bootstrapSwitch();

	</script>

</body>
</html>