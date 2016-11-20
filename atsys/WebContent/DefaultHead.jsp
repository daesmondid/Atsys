<%@page import="models.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="enumerations.TicketStatus"%>
<header id="header" class="full-header">

	<div id="header-wrap">

		<div class="container clearfix">

			<div id="primary-menu-trigger">
				<i class="icon-reorder"></i>
			</div>

			<!-- Logo
			============================================= -->
			<div id="logo" style="border-right: none !important;">
				<a href="" class="standard-logo" data-dark-logo="images/logo.svg"><img
					src="images/logo.svg" alt="Atmos Logo"></a> <a href=""
					class="retina-logo" data-dark-logo="images/logo.svg"><img
					src="images/logo.svg" alt="Atmos Logo"></a>
			</div>
			<!-- #logo end -->

			<!-- Primary Navigation
			============================================= -->
			<nav id="primary-menu">

				<ul>
					<!--li><a href="index.html"><div>Setting</div></a></li-->
					<li><a href="Logout"><div>Logout</div></a></li>
				</ul>

				<!-- Top Cart
				============================================= -->
				<div id="top-cart">
					<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
					<a href="#" id="top-cart-trigger"> <i class="icon-comment"></i>
						<span> <% int counter = 0; %> <c:forEach
								items="${ticketList}" var="ticket">
								<%
								Ticket ticket = (Ticket)pageContext.getAttribute("ticket");
								if (ticket.getTicketStatus() == TicketStatus.ADMIN) {
									counter++;
								}
					    	%>
							</c:forEach> <% out.print(counter); %>
					</span>
					</a>
					<div class="top-cart-content">
						<div class="top-cart-title">
							<h4>Awaiting Admin Reply</h4>
						</div>
						<div class="top-cart-items">
							<c:forEach items="${ticketList}" var="ticket">
								<c:choose>
									<c:when
										test="${fn:containsIgnoreCase(ticket.ticketStatus, 'ADMIN')}">
										<div class="top-cart-item clearfix">
											<div class="top-cart-item-desc">
												<a
													href="TicketDetail?id=<c:out value="${ticket.id}"></c:out>"><c:out
														value="${ticket.name}"></c:out></a> <span
													class="top-cart-item-price"><c:out
														value="${ticket.user.name}"></c:out></span> <span
													class="top-cart-item-quantity"><c:out
														value="${ticket.id}"></c:out></span>
											</div>
										</div>
									</c:when>
								</c:choose>
							</c:forEach>
						</div>
						<div class="top-cart-action clearfix">
							<button onclick="document.location='Ticket'"
								class="button button-3d button-small nomargin fright">View
								Tickets</button>
						</div>
					</div>
				</div>
				<!-- #top-cart end -->

			</nav>
			<!-- #primary-menu end -->

		</div>

	</div>

</header>