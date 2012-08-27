<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
	</head>
	<body>
		<div id="wrapper">
	<div id="main">
			<jsp:include page="header.jsp">
				<jsp:param name="currentPage" value="MyAccount" />
			</jsp:include>
			<div class="cantainer_inner">
			<div class="main_cantainer">
				<div class="cantainer_content">

					<div class="inner_cantainer">
						<div class="main_deal">

							<div class="top_header">
								<img src="../images/corner_left.jpg" align="left" />
								<img src="../images/corner_right.jpg" align="right" />
							</div>

							<div class="content_deal_inner">
							
						<table width="968" border="0" cellspacing="0" cellpadding="0">
							
							 <c:if test="${(userInfo.roleId eq 5 ) or (userInfo.roleId eq 6 )}">
								      <%@ include file="client_banner.jsp"%>
		      	  						<%@ include file="client_menu.jsp"%>
		      	  						</c:if>	
		      	  			   <c:if test="${userInfo.roleId eq 4 }">	
		      	  			     <%@ include file="consumer_banner.jsp"%>
		      	  			   </c:if>
							  <c:if test="${userInfo.roleId eq 1 }">	
		      	  			     <%@ include file="admin_banner.jsp"%>
		      	  			   </c:if>
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<table width="965" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td background="../images/1.png"></td>
											<td width="957" height="8" background="../images/5.png"></td>
											<td background="../images/2.png"></td>
										</tr>
										<tr>
											<td width="8" background="../images/7.png"></td>
											<td height="222" align="center" valign="top">
												<br />
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
							 
													<c:if test="${noofrecords ne 0}">
													<tr><td align=right> <a href="sentExpireDealsMail.do?send" class="bla_low"><b>Email Report</b></a></td></tr>
													<tr><td style="color:#CC0033">${emaildata }</td></tr>
													
													
															<c:if test="${not empty sendmail}">
													<tr>
														<td height="75" align="center" valign="top">
															<strong class="red_max">Mail sent successfully.</strong>
														</td>
													</tr>
													</c:if>
												 
													</c:if>
													
										 	<c:if test="${noofrecords eq 0}">
										 		<tr>
														<td height="75" align="center" valign="top">
															<strong class="red_max">TangoTab Offers Not Expiring in this Week.</strong>
														</td>
													</tr>
										 	</c:if>
													<tr>
														<td align="center" valign="top">
															<table width="100" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td align="center" valign="top">
																		<div id="select_hot">
																			&nbsp;
																		</div>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
											<td width="8" background="../images/8.png"></td>
										</tr>
										<tr>
											<td height="8" background="../images/3.png"></td>
											<td height="8" background="../images/6.png"></td>
											<td height="8" background="../images/4.png"></td>
										</tr>
									</table>
									<!-- form End-->
								</td>
							</tr>
						</table>
					
					</div>
							<div class="top_bottom">
								<img src="../images/corner_bottom_left.jpg" align="left" />
								<img src="../images/corner_bottom_right.jpg" align="right" />
							</div>

							<%@ include file="footer.jsp"%>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div style="clear: both;"></div>
	</div>
</div>

	</body>
</html>