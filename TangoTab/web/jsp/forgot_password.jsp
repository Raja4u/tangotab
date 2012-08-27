<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
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
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal">
  	 
  	 	 
  	 <div class="login_page_main">	
  	 <!-- start here  -->
		
				
					<html:form action="/jsp/forgotAction">
						<table width="968" border="0" align="center" cellpadding="0"
							cellspacing="0" class="form_txt">
							<tr>
								<td align="center" valign="top">
									<table width="968"  align="center" cellpadding="0"
										cellspacing="0" >
										<tr>
											<td height="200" align="center" valign="top">
												<table width="952" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>

														<td width="952" align="center" valign="middle">
															<table width="900" border="0" align="center"
																cellpadding="0" cellspacing="6">
																<tr>
																	<td height="45" align="left" valign="middle"
																		class="red_max">
																		Forgotten your password?
																	</td>
																</tr>
																<tr>
																	<td align="left" valign="top" class="gre_low">
																		Follow the simple steps on the next screen and/or in the email that is sent to you.
																	</td>
																</tr>
<!--																<tr>-->
<!--																	<td align="left" valign="top">-->
<!---->
<!--																		<ul class="list">-->
<!--																			<li class="list">-->
<!--																				Fill in your email address below.-->
<!--																			</li>-->
<!--																			<li class="list">-->
<!--																				We will email you a temporary code.-->
<!--																			</li>-->
<!--																			<li class="list">-->
<!--																				Use the code to change your password on our secure-->
<!--																				website.-->
<!--																			</li>-->
<!--																		</ul>-->
<!--																	</td>-->
<!--																</tr>-->
																<tr>
																	<td height="24" align="left" valign="middle"
																		class="text_h3">
																		Enter your email address
																	</td>
																</tr>
																<tr>
																	<td align="left" valign="top">
																		<html:hidden property="type" value="forgot_password" />
																		<html:text property="emailId" value="" styleClass="substxt" />
																		<logic:messagesPresent message="true">
																			<html:messages id="message" message="true">
																				<logic:present name="message">
																					<FONT color="red"> <bean:write
																							name="message" filter="false" /> </FONT>
																					<br>
																				</logic:present>
																			</html:messages>
																		</logic:messagesPresent>
																	</td>
																</tr>
																<tr>
																	<td align="left" valign="top">
																		Type in the email address you used when you registered
																		with TangoTab. Then we will email a password to this
																		address.
																	</td>
																</tr>
																<tr>
																	<td height="30" align="left" valign="middle">
																		<table width="75" border="0" align="left"
																			cellpadding="0" cellspacing="0">
																			<tr>
																				<td>
																					<div id="select_hot">
																						<html:submit property="operation" value="Submit" styleClass="but_img" styleId="submitID"  ></html:submit>
																					</div>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="10" align="center" valign="top"
									background="images/bluboxshadow.jpg"></td>
							</tr>
						</table>
					</html:form>
					
				</div>
			<!-- end here  -->
						
   
   
   </div>


</div>

            </div>
           
            <div class="top_bottom">
            <img src="../images/corner_bottom_left.jpg" align="left" />
            <img src="../images/corner_bottom_right.jpg" align="right" /></div>

	
              <%@ include file="footer.jsp"%>
             

</div>
    </div>
        </div>
	 </div>
</div> 
	</body>
</html>

