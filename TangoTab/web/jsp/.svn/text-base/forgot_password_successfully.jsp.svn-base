<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
	<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		<script type="text/javascript">
		function submitAction(){
		   document.forgotForm.action="forgotanswer.do?type=resend";
		   document.forgotForm.submit();
		   return true;
		}
		</script>
	</head>
	<body>
		
		
		<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  	 
  	 
  	 <!-- start here  -->
		
		
		
						<table width="968" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
								<html:form action="/jsp/forgotanswer" onsubmit="return submitAction();">
									<table width="968" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td background="../images/1.png"></td>
											<td width="949" height="8" background="../images/5.png"></td>
											<td background="../images/2.png"></td>
										</tr>
										<tr>
											<td width="8" background="../images/7.png"></td>
											<td height="222" align="center" valign="top">
												<br />
												<input type="hidden" id="email" name="email" value="${emailId}"/>
												<input type="hidden" id="chance" name="chance" value="${chance}"/>
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td align="center" valign="top">
															<h5>Password details have been sent to your email id. Please check your email.</h5>
														</td>
													</tr>
													<tr>
													     <td height="30" align="center" valign="top" class="bla_low">
													    <p> In case the email does not appear in your inbox, please check your junk folder. To continue to get uninterrupted emails from TangoTab, please add TangoTab.com to your Safe Sender List.
													      <a href="../safesenderslist.jsp" target="_blank"  class="text_agree"  >Click here</a> for instructions on adding to safe sender list.</p>
													     </td>
													</tr>
													<tr>
                                                         <td colspan="4" align="left" valign="middle" class="td_bg"><br><br></br></td>
                                                    </tr>
                                                    <c:if test="${chance eq 'yes'}">
													  <tr>
													     <td height="75" align="center" valign="top" class="bla_low">
													     If you did not receive the password reset email, click on "Resend password reset email". 
													     </td>
													  </tr>
													</c:if>
													<c:if test="${chance eq 'no'}">
													  <tr>
													     <td height="75" align="center" valign="top" class="bla_low">
													    <p> If you did not receive the password reset email, please <a href="contact_us.jsp" target="_blank"  class="text_agree"  >contact us</a> to get this password reset. </p>
													     </td>
													  </tr>
													</c:if>
													<tr>
														<td align="center" valign="top">
															<table width="100" border="0" align="center"
																cellpadding="0" cellspacing="5">
																<tr>
																	<td align="center" valign="top">
																		<div id="select_hot">
																			<a href="login.jsp">Close</a>
																		</div>
																	</td>
																	<c:if test="${chance eq 'yes'}">
																	<td align="center" valign="top">
																		<div id="select_hot_max">
																			<html:submit property="submit" styleId="resend" >Resend password reset email</html:submit>
																		</div>
																	</td>
																	</c:if>
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
									</html:form>
									<!-- form End-->
								</td>
							</tr>
						</table>
					
					
					<!-- end here  -->
						
   
   
   </div>


</div>

            </div>
            <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div> 
					
	</body>
</html>