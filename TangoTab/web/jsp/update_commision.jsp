<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		
	</head>
	<body onload="getCountryDetails()"> 
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
						<table width="760" border="0" cellspacing="0" cellpadding="0">
							<%@ include file="consumer_banner.jsp"%>
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<html:form action="/jsp/updateCommision" method="post">
										<table width="760" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td background="../images/1.png"></td>
											<td width="729" height="8" background="../images/5.png"></td>
											<td background="../images/2.png"></td>
										</tr>
										<logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="2">
															<FONT color="red"><bean:write name="message"
																	filter="false" /> </FONT>
														</td>
													</tr>
												</logic:present>
											</html:messages>
										</logic:messagesPresent>
										<tr>
											<td width="8" background="../images/7.png"></td>
											<td height="100" align="center" valign="top">
												<table width="935" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Update Commisions</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><br/>    
                   
                    
                                      <table width="60%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
                      <tr>
                        <td align="left" valign="middle" class="table_light">Commision For New Sale </td>
                        <td align="left" valign="middle" class="table_light"><span class="red_text">*</span>
                          <html:text property="percentOnNewSale" />
                       </td>
                       <td><span><html:errors property="percentOnNewSale" /></span></td>
                      </tr>
                       <tr>
                        <td align="left" valign="middle" class="table_light">Commision For Renewal</td>
                        <td align="left" valign="middle" class="table_light"><span class="red_text">*</span>
                          <html:text property="personOnRenewalSale" />
                       </td>
                         <td><span><html:errors property="personOnRenewalSale" /></span></td>
                      </tr>
                       <tr>
                        <td align="left" valign="middle" class="table_light">Commision For Manage through Sales Rep</td>
                        <td align="left" valign="middle" class="table_light"><span class="red_text">*</span>
                          <html:text property="commisionManager" />
                         </td>
                          <td><SPAN class="red_text"><html:errors property="commisionManager" /></SPAN></td>
                      </tr>
                      <tr>
                        <td align="right" valign="middle" class="table_light">&nbsp;</td>
                        <td align="left" valign="middle" class="table_light"><table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                          <tr>
                            <td><div id="select_hot"><html:submit property="operation" value="Submit"></html:submit></div></td>
                         <!--        <td><div id="select_hot"><html:reset property="operation" value="Reset"></html:reset></div></td> -->
                            <td><div id="select_hot"><html:cancel property="operation" value="Cancel"></html:cancel></div></td>
                          </tr>
                        </table>
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
									</table></html:form>
									
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

