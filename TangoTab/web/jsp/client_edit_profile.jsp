<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
	<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
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
		      <%@ include file="client_banner.jsp" %>
		      <%@ include file="client_menu.jsp" %>
		      <tr>
		        <td height="6" colspan="3" align="left" valign="top"></td>
		      </tr>
		      <tr>
		        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
		        <html:form action="/jsp/clientUpdate">
		            <table width="968" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td background="../images/1.png"></td>
		                <td width="952" height="8" background="../images/5.png"></td>
		                <td background="../images/2.png"></td>
		              </tr>
		              <tr>
		                <td width="8" background="../images/7.png"></td>
		                <td height="100" align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="5">
		                  <tr>
		                    <td height="30" colspan="4" align="center" valign="middle" class="red_max">&nbsp;Edit Host Profile</td>
		                  </tr>
		                  <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="2">
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		<br>
																	</td>
																</tr>
															</logic:present>
														</html:messages>
													</logic:messagesPresent>
		                  <tr>
		                    <td width="22%" colspan="2" align="right" valign="middle" class="bla_low">Business Name :</td>
		                    <td width="38%" colspan="2" align="left" valign="middle"><html:text readonly="true"  property="businessName" name="userInfo" styleClass="restaurant_input"></html:text>
		                        <span class="red_text" id="businessName"><html:errors   property="businessName" /></span>
		                        
		                        <html:hidden property="emailId" name="userInfo" styleClass="restaurant_input"></html:hidden>
		                        <html:hidden property="password"  value="12345678"    name="userInfo" styleClass="restaurant_input"></html:hidden>
		                         <html:hidden property="businessName"  styleClass="restaurant_input"></html:hidden>
		                          <html:hidden property="cpassword" name="userInfo" value="12345678" styleClass="restaurant_input"></html:hidden>
		                           <html:hidden property="billingTypeId"   name="userInfo" styleClass="restaurant_input"/>
		     					   <html:hidden property="billingMethodId"   name="userInfo" styleClass="restaurant_input"/>
		     					  
		     					      <html:hidden property="isAutoDebit"   value="${userInfo.restaurent.isAutoDebit}" styleClass="restaurant_input"/>
		     					     
		                        </td>
		                                  
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Business Type<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:select property="restTypeId" disabled="true"
																styleClass="restaurant_select" name="userInfo">
																<html:option value="0">Select your option</html:option>
																<bean:define id="relationships3" name="dropDownList"
																	property="businessTypes" type="java.util.ArrayList" />
																<html:options collection="relationships3"
																	property="restTypeId" labelProperty="restTypeName" />
															</html:select>
														   <span class="red_text" id="businessName">
															<html:errors  property="restTypeId"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="text_formsub" colspan="2"><span class="bla_low">Number of Locations</span><span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="noOfLocations"  readonly="true" styleClass="restaurant_input" name="userInfo"></html:text>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top" class="bla_low" colspan="2">Business Street Address1<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="address"   onkeyup="hidetext('address')" styleClass="restaurant_input" name="userInfo"></html:text>
		                       <span class="red_text" id="address">	<html:errors  property="address"/></span></td>
		                  </tr>
		                     <tr>
		                    <td align="right" valign="top" class="bla_low" colspan="2">  Street Address2:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="address1"   onkeyup="hidetext('address1')" styleClass="restaurant_input" name="userInfo"></html:text>
		                       <span class="red_text" id="address1">	</span></td>
		                  </tr>

  							<tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">City<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
			                    <html:text property="cityId" styleClass="restaurant_select" styleId="cities"   name="userInfo"   ></html:text>
                              <span  class="red_text" id="cityId"><html:errors property="cityId"/></span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low" colspan="2">State/Prov<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
										<html:select property="stateId"  onkeyup="hidetext('stateId')"   styleClass="restaurant_select" styleId="states"   name="userInfo" >
			                			<html:option value="0">Select State</html:option>
			                	<c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach> 
			                </html:select>
			                <span  class="red_text" id="stateId"><html:errors property="stateId"/></span>
									</td>
			                  </tr>
			                
			                   <tr>
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Zip/Post Code<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2"><html:text property="zipCode"  onkeyup="hidetext('zipCode')"  styleClass="restaurant_input"  name="userInfo"></html:text>
								<span  class="red_text" id="zipCode">	<html:errors property="zipCode"/></span></td>
			                  </tr>
			                     <tr>
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Country<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
													<html:select property="countryId"    styleClass="restaurant_select" styleId="countries"   name="userInfo" >
			                			<html:option value="0">Select Country</html:option>
			                <bean:define id="relationships3" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships3" property="countryId" labelProperty="countryName"/>
			                </html:select><span  class="red_text" id="countryId"><html:errors property="countryId"/></span>
			                	 
									</td>
			                  </tr>
			                  
			               
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Administrator's first name<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="firstname"   onkeyup="hidetext('firstname')" name="userInfo" styleClass="restaurant_input"></html:text>
		                     <span class="red_text" id="firstname">  <html:errors  property="firstname"/></span></td>
		                  </tr>
		                            
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Administrator's last name<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="lastname"   onkeyup="hidetext('firstname')" name="userInfo" styleClass="restaurant_input"></html:text>
		                     <span class="red_text" id="lastname">  <html:errors  property="lastname"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Administrator's Phone:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="mobilePhone"    onkeyup="hidetext('mobilePhone')" onkeypress="return isNumberKey(event)"  styleClass="restaurant_input" name="userInfo"></html:text>
						 <span class="blue_text">(e.g., 2125551212)</span>
						 <span class="red_text" id="firstname"> 	<html:errors  property="mobilePhone"/></span>
							     	  <html:hidden property="restTypeId" name="userInfo"  />
		                     	                     <html:hidden property="noOfLocations"   name="userInfo"/>
						</td>
		                  </tr>
		                  <tr>
		                  	<td align="right" valign="middle" class="bla_low" colspan="2">Administrator's Business Title:</td>
		                    <td align="left" valign="middle" colspan="2">
		                    <html:text property="businessTitle" styleClass="restaurant_input" name="userInfo"></html:text>
						 	</td>
		                  </tr>
		                  <tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Sales Rep Name<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
			                        <html:text property="srepName" styleClass="restaurant_input" styleId="repname"  name="userInfo"  ></html:text>
			                        <span  class="red_text" id="srepName"><html:errors property="srepName"/></span>
                                </td>
			                  </tr>
			                  <tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Sales Rep Email<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
			                        <html:text property="srepEmail" styleClass="restaurant_input" styleId="repemail"  name="userInfo"  ></html:text>
			                        <span  class="red_text" id="srepEmail"><html:errors property="srepEmail"/></span>
                                </td>
			                  </tr>
			                  						
						 		<tr>
														<td align="right" valign="middle" class="bla_low" colspan="2">
															Security Question 1<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle" colspan="2">
											 
															<html:text property="question1"  
																styleClass="restaurant_input"   name="userInfo"    />
															 
																  <html:errors property="question1" /> 
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low" colspan="2">
															Answer1<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle" colspan="2">
															<html:text property="answer1" 
																styleClass="restaurant_input"    name="userInfo"   /> 
														 	<html:errors property="answer1"/> 
														</td>
													</tr>
													
																			
						 		<tr>
														<td align="right" valign="middle" class="bla_low" colspan="2">
															Security Question 2<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle" colspan="2">
											 
															<html:text property="question2"  
																styleClass="restaurant_input"    name="userInfo"   />
															 
																  <html:errors property="question2" /> 
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low" colspan="2">
															Answer2<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle" colspan="2">
															<html:text property="answer2" 
																styleClass="restaurant_input"   name="userInfo"   /> 
														 	<html:errors property="answer2"/> 
														</td>
													</tr>
													<tr>
			                  	 <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameOne" styleId="nameOne" styleClass="restaurant_input" value="${userInfo.nameArray[0]}"/>
			                      <span  class="red_text" id="nameOne">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdOne"   styleClass="restaurant_input" value="${userInfo.emailIdArray[0]}"></html:text>
			                      <span  class="red_text" id="emailIdOne">  <html:errors property="emailIdOne"/> </span></td>
			                  </tr>
			                  <tr>
			                   	 <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameTwo" styleId="nameTwo" styleClass="restaurant_input" value="${userInfo.nameArray[1]}"/>
			                      <span  class="red_text" id="nameTwo">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdTwo"   styleClass="restaurant_input" value="${userInfo.emailIdArray[1]}"></html:text>
			                      <span  class="red_text" id="emailIdTwo">  <html:errors property="emailIdTwo"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameThree" styleId="nameThree" styleClass="restaurant_input" value="${userInfo.nameArray[2]}"/>
			                      <span  class="red_text" id="nameThree">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdThree"   styleClass="restaurant_input" value="${userInfo.emailIdArray[2]}"></html:text>
			                      <span  class="red_text" id="emailIdThree">  <html:errors property="emailIdThree"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFour" styleId="nameFour" styleClass="restaurant_input" value="${userInfo.nameArray[3]}"/>
			                      <span  class="red_text" id="nameFour">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFour"   styleClass="restaurant_input" value="${userInfo.emailIdArray[3]}"></html:text>
			                      <span  class="red_text" id="emailIdFour">  <html:errors property="emailIdFour"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFive" styleId="nameFive" styleClass="restaurant_input" value="${userInfo.nameArray[4]}"/>
			                      <span  class="red_text" id="nameFive">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFive"   styleClass="restaurant_input" value="${userInfo.emailIdArray[4]}"></html:text>
			                      <span  class="red_text" id="emailIdFive"> <html:errors property="emailIdFive"/>  </span></td>
			                  </tr>
								 	
													 
		                  <tr>
		                    <td height="45" colspan="4" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
		                        <tr>
		                          <td><div id="select_hot"><html:submit styleClass="but_img" property="submit"
																				styleId="submitID">Update</html:submit></div></td>
		                          <td colspan="2"><div id="select_hot"><a href="manageLocations.do">Cancel</a></div></td>
		                        </tr>
		                    </table></td>
		                  </tr>
		                </table></td>
		                <td width="8" background="../images/8.png"></td>
		              </tr>
		              <tr>
		                <td height="8" background="../images/3.png"></td>
		                <td height="8" background="../images/6.png"></td>
		                <td height="8" background="../images/4.png"></td>
		              </tr>
		            </table>
		          <!-- form End-->  </html:form>      </td>
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