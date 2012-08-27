<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
	<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp" %>

<script type="text/javascript">
 
	function getNoof(btype)
	{
	 
		if(btype==1)
		{
		 document.getElementById("noofloc").innerHTML = "<input type='hidden' name='noOfLocations' value='1' /><input type='text' name='noOfLocations' disabled='true' value='1' />";
		}else 
		{
			 document.getElementById("noofloc").innerHTML = "<input type='text' name='noOfLocations' value='2'   onkeypress='return isNumberKey(event)'/>";
		}
	}
	
	 function Onsubmit1(){
			 
		       if(document.adminclientForm.noOfLocations.value=="" || document.adminclientForm.noOfLocations.value < 1)
				{
				   document.getElementById("noOfLocations").innerHTML = "Number of Locations Required ";
				 return false;
				} else 
				{ 
				document.adminclientForm.action = "adminclientEdit.do";
				document.adminclientForm.submit();
							return true; 
				}
		
	 
			}
	function oncan()
			{
			window.location='index.jsp';
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
  
                   <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	
  	                   <div class="content_deal_inner">	
   <!--	start login -->
   
		    <table width="968" border="0" cellspacing="0" cellpadding="0">
		      <%@ include file="admin_banner.jsp" %>
		    
		      <tr>
		        <td height="6" colspan="3" align="left" valign="top"></td>
		      </tr>
		      <tr>
		        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
		        <html:form action="/jsp/adminclientEdit" method="post">
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
		                    <td height="30" colspan="4" align="center" valign="middle" class="red_max">Edit Host Profile</td>
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
		                    <td width="22%" align="right" valign="middle" class="bla_low" colspan="2">Business Name<span class="red_text">*</span>:</td>
		                    <td width="38%" align="left" valign="middle" colspan="2"><html:text   property="businessName"  styleClass="restaurant_input" ></html:text>
		                        <span  class="red_text" id="businessName"><html:errors   property="businessName" />	 </span>
		                        
		                        
		                        <html:hidden property="password"  styleClass="restaurant_input" ></html:hidden>
		                        <html:hidden property="restaurantId"  styleClass="restaurant_input" ></html:hidden>
		                        <input type="hidden" name="restactive"  value="${client.isActivated}"/>
		                        <!--<input type="hidden" name="restId" value="${client.restaurantId }"/>
		                            
		                        --></td>
		                                  
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Business Type<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:select property="restTypeId" 
																styleClass="restaurant_select"  onchange="getNoof(this.value)">
																<html:option value="0">Select your option</html:option>
																<bean:define id="relationships3" name="dropDownList"
																	property="businessTypes" type="java.util.ArrayList" />
																<html:options collection="relationships3"
																	property="restTypeId" labelProperty="restTypeName" />
															</html:select>
														   <span  class="red_text" id="restTypeId"><html:errors property="restTypeId"/></span>
														   </td>
		                                                </tr>
		                                           <!--<tr><td align="right" valign="middle" class="bla_low">
															Billing Method<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle"><html:hidden property="billingMethodId" value="1" />
														
															<html:select property="billingMethodId" 
																styleClass="restaurant_select" >
																<html:option value="0">select method</html:option>
																<bean:define id="relationships4" name="dropDownList"
																	property="billingMethods" type="java.util.ArrayList" />
																<html:options collection="relationships4"
																	property="billingMethodId"
																	labelProperty="billingMethodName"/>
															</html:select><span  class="red_text" id="dd"><html:errors property="billingMethodId"/></span>
														</td>
													 </tr>
													 <tr>
														<td align="right" valign="middle" class="bla_low">
															Billing Type<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle">
														
															<html:select property="billingTypeId" 
																styleClass="restaurant_select"  >
																<html:option value="0">Select Type</html:option>
																<bean:define id="relationships5" name="dropDownList"
																	property="billingTypes" type="java.util.ArrayList" />
																<html:options collection="relationships5"
																	property="billingTypeId"
																	labelProperty="billingTypeName" />
															</html:select><span  class="red_text" id="ddd"><html:errors property="billingTypeId"/></span>
														</td>
													 </tr>
		                  -->
		                  <html:hidden property="billingMethodId" />
		                  <html:hidden property="billingTypeId"/>
		                 		                
		                  <tr>
		                    <td align="right" valign="middle" class="text_formsub" colspan="2"><span class="bla_low">Number of Locations</span><span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" id="noofloc" colspan="2">
		                    <html:text property="noOfLocations"   styleClass="restaurant_input" 
		                    onkeyup="hidetext('noOfLocations')"   onkeypress="return isNumberKey(event)"></html:text>
		                    <span  class="red_text" id="noOfLocations"><html:errors property="noOfLocations"/></span>
		                    </td>
		                  </tr>
		                   <tr>
		                    <td align="right" valign="middle" class="text_formsub" colspan="2"><span class="bla_low">IsAutoDebit</span><span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" id="noofloc" colspan="2">
		                    <c:if test="${!adminclientForm.profileExists}" >
		                       <c:if test="${adminclientForm.isAutoDebit == 0}" >
		                       <html:text readonly="true" property="isAutoDebit"  value="NO" />
		                       </c:if>
		                       <c:if test="${adminclientForm.isAutoDebit == 1}" >
		                       <html:text readonly="true"  property="isAutoDebit"  value="YES" />
		                       </c:if>
		                    </c:if>
		                    <c:if test="${adminclientForm.profileExists}" >
		                       <html:select property="isAutoDebit" value="${adminclientForm.isAutoDebit}">
		                       <html:option value="1">YES</html:option>
		                       <html:option value="0">NO</html:option>
		                       </html:select>
		                    </c:if>
		                    
		                     <span  class="red_text" id="isAutoDebit"></span>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top" class="bla_low" colspan="2">Business Street Address1<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="address"   onkeyup="hidetext('email')" styleClass="restaurant_input" ></html:text>
		                       <span class="red_text" id="address">	<html:errors  property="address"/></span></td>
		                  </tr>
		                  
		                  <tr>
														<td align="right" valign="top" class="bla_low" colspan="2">
														 
															 Street Address2:
														</td>
														<td align="left" valign="middle" colspan="2">
															<html:text property="address1"  
																styleClass="restaurant_input"  ></html:text>
														<span  class="red_text" id="address1"></span>
														</td>
													</tr>
													
		                  
		                  <tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">City<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
			                    <html:text property="cityId" styleClass="restaurant_select" styleId="cities" ></html:text>
                             <span  class="red_text" id="cityId"><html:errors property="cityId"/></span></td>
			                  </tr>
													 
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low" colspan="2">State/Prov<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
										<html:select property="stateId"  onkeyup="hidetext('stateId')"   styleClass="restaurant_select" styleId="states"   >
			                			<html:option value="0">Select State</html:option>
			                 <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach>  </html:select><span  class="red_text" id="stateId"><html:errors property="stateId"/></span>
									</td>
			                  </tr>
			                     <tr>
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Zip/Post Code<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2"><html:text property="zipCode"  onkeyup="hidetext('zipCode')"  styleClass="restaurant_input" ></html:text>
								<span  class="red_text" id="zipCode">	<html:errors property="zipCode"/></span></td>
			                  </tr>
			                    <tr>
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Country<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
													<html:select property="countryId"    styleClass="restaurant_select" styleId="countries"  >
			                			<html:option value="0">Select Country</html:option>
			                <bean:define id="relationships3" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships3" property="countryId" labelProperty="countryName"/>
			                </html:select><span  class="red_text" id="countryId"><html:errors property="countryId"/></span>
			                	 
									</td>
			                  </tr>
		                  
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Administrator's First Name<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="firstname"   onkeyup="hidetext('firstname')" styleClass="restaurant_input"></html:text>
		                    <span class="red_text" id="firstname">  <html:errors  property="firstname"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Administrator's Last Name<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="lastname"   onkeyup="hidetext('lastname')" styleClass="restaurant_input"></html:text>
		                    <span class="red_text" id="lastname">  <html:errors  property="lastname"/></span></td>
		                  </tr>
		                  <tr>
		                  	<td align="right" valign="middle" class="bla_low" colspan="2">Administrator's Business Title:</td>
		                    <td align="left" valign="middle" colspan="2">
		                    <html:text property="businessTitle" styleClass="restaurant_input" ></html:text>
						 	</td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low" colspan="2">Administrator's Phone:</td>
		                    <td align="left" valign="middle" colspan="2"><html:text property="mobilePhone" onkeyup="hidetext('mobilePhone')" onkeypress="return isNumberKey(event)"  styleClass="restaurant_input"></html:text>
						    <span class="blue_text">(e.g., 2125551212)</span>
						    <span  class="red_text" id="mobilePhone"><html:errors property="mobilePhone"/></span>
							     	 
		                     	                
						</td>
		                  </tr>
		                  <tr>
														<td align="right" valign="middle" class="bla_low" colspan="2">
															Administrator's Email<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle" colspan="2">
															<table width="100%" border="0" cellspacing="0" cellpadding="0">
												                  <tr>
												                    <td width="163" align="left" valign="top">
												                    	<html:text property="emailId"	styleClass="restaurant_input" styleId="emailId" ></html:text> 
												                     </td>
												                    <td width="285" align="left" valign="top" class="red_text" id="checkEmailId">  	
												                    <span  class="red_text" id="emailId"><html:errors property="emailId" /></span></td>
												                  </tr>
												                </table> 
														</td>
													</tr>
														<html:hidden property="userId" ></html:hidden>
													<html:hidden property="emailIdDummy" ></html:hidden>
													         <tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Change password</td>
			                    <td align="left" valign="middle" colspan="2"><a href="passwordForwardAction.do?userId=${adminclientForm.userId}"  ><u class="text_agree">Change password</u></a>
			                        &nbsp;
                                </td>
			                  </tr>
		                  <tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Sales Rep Name<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
			                        <html:text property="srepName" styleClass="restaurant_select" styleId="repname"   ></html:text>
			                        <span  class="red_text" id="srepName"><html:errors property="srepName"/></span>
                                </td>
			                  </tr>
			                  <tr> 
			                    <td align="right" valign="middle" class="bla_low" colspan="2">Sales Rep Email<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle" colspan="2">
			                        <html:text property="srepEmail" styleClass="restaurant_select" styleId="repemail" ></html:text>
			                        <span  class="red_text" id="srepEmail"><html:errors property="srepEmail"/></span>
                                </td>
			                  </tr>
			                  <tr>
			                  	 <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameOne" styleId="nameOne" styleClass="restaurant_input" />
			                      <span  class="red_text" id="nameOne">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdOne"   styleClass="restaurant_input" ></html:text>
			                      <span  class="red_text" id="emailIdOne">  <html:errors property="emailIdOne"/> </span></td>
			                  </tr>
			                  <tr>
			                   	 <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameTwo" styleId="nameTwo" styleClass="restaurant_input" />
			                      <span  class="red_text" id="nameTwo">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdTwo"   styleClass="restaurant_input" ></html:text>
			                      <span  class="red_text" id="emailIdTwo">  <html:errors property="emailIdTwo"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameThree" styleId="nameThree" styleClass="restaurant_input" />
			                      <span  class="red_text" id="nameThree">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdThree"   styleClass="restaurant_input" ></html:text>
			                      <span  class="red_text" id="emailIdThree">  <html:errors property="emailIdThree"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFour" styleId="nameFour" styleClass="restaurant_input" />
			                      <span  class="red_text" id="nameFour">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFour"   styleClass="restaurant_input" ></html:text>
			                      <span  class="red_text" id="emailIdFour">  <html:errors property="emailIdFour"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Host Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFive" styleId="nameFive" styleClass="restaurant_input" />
			                      <span  class="red_text" id="nameFive">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFive"   styleClass="restaurant_input" ></html:text>
			                      <span  class="red_text" id="emailIdFive"> <html:errors property="emailIdFive"/>  </span></td>
			                  </tr>
		                  <tr>
		                    <td height="45" colspan="4" align="center" valign="middle" ><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
		                        <tr>
		                          <td><div id="select_hot"><html:submit styleClass="but_img" property="submit"
																				styleId="submitID" onclick="Onsubmit1();">Update</html:submit></div></td>
		                          <td colspan="2"><div id="select_hot"><a href="viewClientMgmt.do?operation=display">Cancel</a></div></td>
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
		            </table></html:form>
		          <!-- form End-->        </td>
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