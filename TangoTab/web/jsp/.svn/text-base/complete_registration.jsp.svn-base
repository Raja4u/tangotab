<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%
					String code = "";
					String vtype="";
						if (request.getParameter("code") != null) {
							code = request.getParameter("code");
						}	
						if (request.getParameter("vtype") != null) {
							vtype = request.getParameter("vtype");
						}
						

						String emailId = "";
						if (request.getParameter("emailId") != null) {
							emailId = request.getParameter("emailId");
						}

						String msg = "";
						if (request.getAttribute("msg") != null) {
							msg = (String) request.getAttribute("msg");
						}

						if (request.getAttribute("code") != null) {
							code = (String) request.getAttribute("code");
						}
						if (request.getAttribute("emailId") != null) {
							emailId = (String) request.getAttribute("emailId");
						}
						if (request.getAttribute("vtype") != null) {
							vtype = (String) request.getAttribute("vtype");
						}
						String bannerName="User";
						if(vtype.equals("cl"))
						bannerName="Host";
						else if(vtype.equals("co"))
						bannerName="Guest";
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Welcome to Tango Tab</title>
		<%@ include file="consumer_imports.jsp"%>
	</head>
	<body>
	<div id="wrapper">
	<div id="main">

		
<table width="968" border="0" cellspacing="0" align="center" cellpadding="0">
			<tr>
				<td height="30" align="center" valign="top">
				<%@ include	file="header.jsp"%> </td>
			</tr>
			<tr>
				<td align="center" valign="top">
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
							
							<table width="760" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="3" align="center" valign="top">
										<!--Client Start-->
										<table width="965" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<img src="../images/c_lt.png" width="7" height="7" />
												</td>
												<td width="949" height="7" background="../images/c_tm.png"></td>
												<td width="7" height="7" background="../images/c_rt.png"></td>
											</tr>
											<tr>
												<td bgcolor="#7d9b17">
													&nbsp;
												</td>
												<td height="75" align="center" valign="middle"
													bgcolor="#7d9b17" class="white_max1">
													<%=bannerName%>
												</td>
												<td bgcolor="#7d9b17">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td width="7" height="7" background="../images/c_lb.png"></td>
												<td height="7" background="../images/c_bm.png"></td>
												<td width="7" height="7" background="../images/c_br.png"></td>
											</tr>
											<tr>
												<td colspan="3" height="5"></td>
											</tr>
										</table>
										<!--Client End-->
									</td>
								</tr>
								<tr>
									<td height="6" colspan="3" align="left" valign="top"></td>
								</tr>
								<tr>
									<td height="17" colspan="3" align="center" valign="top">
										<!-- form Start-->
										<form action="login.jsp" method="post">
											<table width="965" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td background="../images/1.png"></td>
													<td width="729" height="8" background="../images/5.png"></td>
													<td background="../images/2.png"></td>
												</tr>

												
												<tr>
													<td width="8" background="../images/7.png"></td>
													<td width="952" align="center" valign="top" height="222">
														&nbsp;
														
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
				                   
				                      
				                                <tr>
													<td colspan="3" align="center" valign="middle"
														class="red_max">
														Your registration process is completed. You can log into the TangoTab website.
														<br />
													</td>
												</tr>
												<tr>
													<td colspan="3" width="38%" align="center" valign="middle">
													&nbsp;
													</td>
												</tr>
												<tr>
													<td colspan="3" width="38%" align="center" valign="middle">
														<html:submit styleClass="but_img">Log In Here</html:submit>
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
										</form>
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
	
						
				</td>
			</tr>

			
		</table> 
		</div>
</div>

		
	</body>
</html>
