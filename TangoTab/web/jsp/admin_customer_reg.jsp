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
		<%@ include file="admin_imports.jsp"%>
	
	<script>
	function Onsubmit1()
	{
	 if(document.admincustForm.agree.checked==false)
				{
					document.getElementById("msgid").innerHTML = "Please accept the Privacy Policy and User Agreement";
				 return false;
				}
	}
	</script>
	</head>
	<body > 
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
  
                   <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	
  	                   <div class="content_deal_inner">	
   <!--	start login -->
						<table width="760" border="0" cellspacing="0" cellpadding="0">
							<%@ include file="admin_banner.jsp"%>
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<html:form  action="jsp/customerReg" method="post"  onsubmit="return Onsubmit1();">
										<table width="968" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td background="../images/1.png"></td>
											<td width="952" height="8" background="../images/5.png"></td>
											<td background="../images/2.png"></td>
										</tr>
										
										<tr>
											<td width="8" background="../images/7.png"></td>
											<td height="100" align="center" valign="top">
												<table width="740" border="0" align="center" cellpadding="0"
													cellspacing="5">
													<tr>
														<td height="12" colspan="2" align="center" valign="middle"
															class="red_text">
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
														</td>
													</tr>
													<tr>
														<td height="30" colspan="2" align="center" valign="middle"
															class="red_max">
															Guest Registration
														</td>
													</tr>
													<tr>
														<td width="22%" align="right" valign="middle"
															class="bla_low">
															First Name<span class="red_text">*</span>:
														</td>
														<td width="38%" align="left" valign="middle">
															<!-- <input type="text" class="restaurant_input"  /> -->
															<html:text property="firstname" 
																styleClass="restaurant_input" styleId="firstName"  onkeyup="hidetext('fname')"></html:text>  
																<span  class="red_text" id="fname"><html:errors property="firstname" /></span> 
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low">
															Last Name<span class="red_text">*</span>: 
														</td>
														<td align="left" valign="middle">
															<html:text property="lastname" 
																styleClass="restaurant_input" styleId="lastName"  onkeyup="hidetext('lname')"></html:text>
																<span  class="red_text" id="lname"><html:errors property="lastname" /></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low">
															Email<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
												                  <tr>
												                    <td width="163" align="left" valign="top">
												                    	<html:text property="emailId"	styleClass="restaurant_input" styleId="emailId"   onblur="checkEmail(4)"></html:text> 
												                     </td>
												                    <td width="285" align="left" valign="top" class="red_text" >
												                    	<span  class="red_text" id="emailId"><html:errors property="emailId" /></span>
												
												                    
												                    <div id="checkEmailId"></div></td>
												                  </tr>
												                </table>
														</td>
														
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low">
															Zip/Post Code<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle"> 
															<html:text property="zipCode"  
																styleClass="restaurant_input" styleId="zipCodeID"   onkeyup="hidetext('zcode')"></html:text>
													<span  class="red_text" id="zcode">	 <html:errors property="zipCode" /></span></td>
													</tr>
													<tr>
			                <td align="right" valign="middle"><span class="bla_low">State/Prov</span><span class="red_text">*</span>:</td>
			                <td align="left" valign="middle">
			                <html:select property="stateId"  styleClass="restaurant_select" styleId="states"   >
			                <html:option value="0">Select State</html:option>
			                <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach>  </html:select>
			                 		<span  class="red_text" id="stateId"><html:errors property="stateId"/></span>
			                </td>
			              </tr>
													<!--<tr>
														<td height="1" colspan="2" align="right" valign="middle"
															bgcolor="#999999"></td>
													</tr>
													-->
													 <tr>
			                                                <td align="right" valign="middle" class="bla_low">Preferred City<span class="red_text">*</span>:</td>
			                                                <td align="left" valign="middle" class="restaurant_select">
			                                                  <html:select property="preferCity"  styleClass="restaurant_select" styleId="preferCity" >
			                                                      <html:option value="0">Select City</html:option>
			                                                       <bean:define id="relationships2" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    			                                      <html:options collection="relationships2" property="cityId" labelProperty="cityName"/>
			                                                   </html:select>
			                                                   <html:errors property="preferCity" />	</td>
			                                          </tr>
													  <tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Mobile Number: </span>
														</td>
														<td align="left" valign="middle">
															<html:text property="mobilePhone" 
																styleClass="restaurant_input"  onkeypress="return isNumberKey(event)"  ></html:text>
														<span class="blue_text">e.g., 2125551212 (If you would like to be notified of deals via SMS*)</span>
														<span  class="red_text" id="mphone"><html:errors property="mobilePhone" /></span></td>
													</tr>
													
													<tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Promotion Code</span>:
														</td>
														<td align="left" valign="middle">
															<html:text property="question1" 
																styleClass="restaurant_input"    ></html:text>
														 
														<span  class="red_text" id="question1"><html:errors property="question1" /></span></td>
													</tr> 
														<tr>
														<td  colspan=3 id="msgid" class="red_text" align="center">&nbsp;
														</td>
													</tr>
												<tr>
														<td height="27" align="right" valign="middle">
															&nbsp;
														</td>
														<td align="left" valign="middle" >
															<input type="checkbox" class="text_agree" name="agree" id="checkbox24"  value="ok"/>
															I certify that I have read and agree to the
															<span class="text_h8"> <a href="privacy_policy.jsp"
																class="text_agree"  target="_blank" >privacy policy</a> </span>and
															<br />
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="terms.jsp"  class="red_text" target="_blank">terms of use</a> of Tango
															Tab
														</td>
													</tr>
													<tr>
			                                      <td colspan="2" align="center" valign="middle" class="text_h10">
			                                       <div>[NOTE*Standard text messaging charges may apply as per your mobile service provider*]
			                                        </div></td>
		                                                </tr>
													<tr>
														<td height="35" colspan="2" align="center" valign="middle">
															<table width="330" border="0" align="center"
																cellpadding="0" cellspacing="0" >
																<tr>
																	<td>
																		<div id="submitId"> 
																			<html:submit styleClass="but_img" styleId="submitID"  property="submit"  >Register</html:submit>
																		</div>
																	</td>
																	<td>
																		<div id="select_hot">
																 <a href="admin_customer_reg.jsp">Reset</a> 
																		</div>
																	</td>
																	<td>
																		<div id="select_hot">
																			<!--<html:button styleClass="but_img" styleId="submitID"  property="submit" >Cancel</html:button>
																			--> <a href="viewCustomerMgmt.do?operation=display">Cancel</a>
																			
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
									</table></html:form>
									
									<!-- form End-->
								</td>
							</tr>
						</table>
					</div>
           <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>
</div>
</div>
	</body>
</html>