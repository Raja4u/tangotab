<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		<script type="text/javascript">
	function submitAction() {
		if (document.getElementById("rand").value == 0) {

			if (document.getElementById("ans").value != document
					.getElementById("a1").value) {
				document.getElementById("counter").value = document
						.getElementById("counter").value + 1;
				if (document.getElementById("type").value == "next") {
				    document.getElementById("type").value = "failed";
					return true;
				}

				if (document.getElementById("counter").value == "011") {
					//document.getElementById("alerts").style.display = "block";
					//document.getElementById("alerts").innerHTML = "Incorrect answer. Please try again with another question";
					document.getElementById("type").value = "next";
					return true;
				} else {
					document.getElementById("alerts").style.display = "block";
					//document.getElementById("alerts").innerHTML = "Incorrect answer. Please try again";
					return false;
				}

			}
			if (document.getElementById("ans").value == document
					.getElementById("a1").value) {
				document.getElementById("type").value = "matched";
				return true;
				
			}
		}

		if (document.getElementById("rand").value == 1) {
			if (document.getElementById("ans").value != document
					.getElementById("a2").value) {
				document.getElementById("counter").value = document
						.getElementById("counter").value + 1;

				if (document.getElementById("type").value == "next") {
				    document.getElementById("type").value = "failed";
					return true;
				}

				if (document.getElementById("counter").value == "011") {
					//document.getElementById("alerts").style.display = "block";
					//document.getElementById("alerts").innerHTML = "Incorrect answer. Please try again with another question";
					document.getElementById("type").value = "next";
					return true;
				} else {
					document.getElementById("alerts").style.display = "block";
					//document.getElementById("alerts").innerHTML = "Incorrect answer. Please try again";
					return false;
				}
			}
			if (document.getElementById("ans").value == document
					.getElementById("a2").value) {
			document.getElementById("type").value = "matched";
			return true;
			}
		}

	}
</script>
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
							
						<table width="760" border="0" cellspacing="0" cellpadding="0">
						<tr>
				        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
				            <table width="968" border="0" cellspacing="0" cellpadding="0">
				              <tr>
				                <td background="../images/1.png"></td>
				                <td width="729" height="8" background="../images/5.png"></td>
				                <td background="../images/2.png"></td>
				              </tr>
				              <tr>
				                <td width="8" background="../images/7.png"></td>
				                <td width="952" height="222" align="center" valign="top">
									<!-- form Start-->
									<html:form action="/jsp/forgotanswer" method="post"
										onsubmit="return submitAction();">
										  <table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
																<td  align="center" valign="top">
																	<strong class="red_max">We've heard that you
																		may have forgotten your password. You will be asked to
																		answer the security question that you selected when
																		you first created your account.</strong>
																</td>
															</tr>
														
														<logic:messagesPresent message="true">
															<html:messages id="message" message="true">
																<logic:present name="message">
																	<tr>
																		<td align="center" valign="middle" colspan="4">
																			<FONT color="red" class="red_text"> <bean:write
																					name="message" filter="false" /> </FONT>
																			<br>
																		</td>
																	</tr>
																</logic:present>
															</html:messages>
														</logic:messagesPresent>
														<tr>
													<td   align="center" valign="top">
													&nbsp;
														<P id="alerts" class ="red_text" style="display: none">Incorrect answer. Please try again</P> </td></tr>
 
														
														<tr>

															<td  colspan="4" align="left" valign="middle"
																class="text_h3s">
																&nbsp;
																Security Question - &nbsp;
																<c:if test="${rand eq 0}">
                                                                      ${user.question1}
                                                                </c:if>
																<c:if test="${rand eq 1}">
                                                                      ${user.question2}
                                                                </c:if>
																&nbsp;
															</td>
														</tr>
														<tr>

															<td  colspan="4" align="left" valign="middle" height="5" >
																
															</td>
														</tr>
														<input type="hidden" id="type" name="type" value="${type}" />
														<input type="hidden" id="counter" name="counter" value="0" />
														<input type="hidden" id="email" name="email"
															value="${emailId}" />
														<input type="hidden" id="rand" name="rand" value="${rand}" />

														<input type="hidden" id="q1" value="${user.question1}" />
														<input type="hidden" id="a1" value="${user.answer1}" />
														<input type="hidden" id="q2" value="${user.question2}" />
														<input type="hidden" id="a2" value="${user.answer2}" />

														<input type="hidden" id="type" name="type" value="${type}" />
														<tr>
															<td height="26" colspan="4" align="left" valign="middle"
																bgcolor="#a2dae4" class="text_h3s">
																<input type="text" id="ans" name="ans" />
															</td>
														</tr>
														<c:if test="${empty messages}">
															<tr>
																<td align="center" valign="top">
																	<table width="100" border="0" align="center"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td>&nbsp;</td></tr>
																		<tr>
																			<td>
																				<div id="select_hot">
																					<html:submit styleClass="but_img">Submit</html:submit>
																				</div>
																			</td>
																			<td>
																				<div id="select_hot">
																					<a href="forgot_password.jsp" class="but_img">Cancel</a>
																				</div>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</c:if>
													
													</table>
														</html:form>
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