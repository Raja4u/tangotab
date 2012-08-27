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
		  function fill(){
		   if(document.getElementById("autoFillDetails").checked == true){
		    document.creditCardInfo.firstName.value=document.getElementById("hfn").value;
		    document.creditCardInfo.lastName.value=document.getElementById("hln").value;
		    document.creditCardInfo.address1.value=document.getElementById("hadd1").value;
		    document.creditCardInfo.address2.value=document.getElementById("hadd2").value;
		    document.creditCardInfo.city.value=document.getElementById("hcity").value;
		    var stateid = document.getElementById("hstate").value;
		    var o = document.getElementById("hstates").options;
		    var statename = null;
		    for(i=0;i<o.length;i++){
		        if(o[i].value == stateid){
		                statename = o[i].text;
		                }
		        }
		    document.creditCardInfo.state.value=statename;
		   // var countryname = document.getElementById("hcountries").options[document.getElementById("hcountry").value-1].text;
		    var countryname = document.getElementById("countryname").value;
		    document.creditCardInfo.country.value=countryname;
		    document.creditCardInfo.zip.value=document.getElementById("hzip").value;
		    document.creditCardInfo.email.value=document.getElementById("hemail").value;
		    document.creditCardInfo.phone.value=document.getElementById("hphone").value;
		    document.creditCardInfo.fax.value=document.getElementById("hfax").value;
		    }
		    else if(document.getElementById("autoFillDetails").checked == false){
		    document.creditCardInfo.firstName.value="";
		    document.creditCardInfo.lastName.value="";
		    document.creditCardInfo.address1.value="";
		    document.creditCardInfo.address2.value="";
		    document.creditCardInfo.city.value="";
		    document.creditCardInfo.state.value="";
		    document.creditCardInfo.country.value="";
		    document.creditCardInfo.zip.value="";
		    document.creditCardInfo.email.value="";
		    document.creditCardInfo.phone.value="";
		    document.creditCardInfo.fax.value="";
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
							
			    <table width="968" border="0" cellspacing="0" cellpadding="0">
			      <%@ include file="client_banner.jsp" %>
			      <% // include file="client_menu.jsp" %>
			      
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
								
								  <table width="968" border="0" cellspacing="0" cellpadding="0">
							<html:form action="/jsp/paymentGatewaysample">
	 

              <tr>
                <td background="../images/1.png"></td>
                <td width="952" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top"><table width="952" border="0" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="30" colspan="4" align="center" valign="middle" class="red_max">Payment Information</td>
                    </tr>
                      <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="4">
																		<FONT color="red"  class="red_max"> <bean:write name="message"
																				filter="false" /> </FONT>
																		
																	</td>
																</tr>
															</logic:present>
														</html:messages>
													</logic:messagesPresent>
                  <tr>
                    <td height="12" colspan="4" align="center" valign="top" class="td_bg"></td>
                    </tr>
                  <tr>
                    <td width="20%" height="28" align="left" valign="bottom" class="text_h3">Order Information</td>
                    <td colspan="3" align="left" valign="middle">&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="4" align="left" valign="middle" class="td_bg"></td>
                    </tr>
                 
                  <tr>
                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Description</span>:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"> TangoTab Credits.</td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="text_h3">Total:</td>
                    <td colspan="3" align="left" valign="middle" class="text_h3">$ ${amount} USD
               
                    <input type="hidden" name="amount" value="${amount}" />
                    
                       <input type="hidden" name="totaldue" value="${amount}" />
                      <input type="hidden" name="qty" value="${qty}"  />
                          <input type="hidden" name="unit1" value="${qty}"  />
                        <input type="hidden" name="isAutoDebit" value="${isAutoDebit}" />
                         <input type="hidden" name="paymentProfileId" value="${paymentProfileId}" />
                        
                    </td>
                  </tr>
 <tr>
                    <td width="20%" height="28" align="left" valign="bottom" class="text_h3">Payment Information</td>
                    <td colspan="3" align="left" valign="middle">&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="4" align="left" valign="middle" class="td_bg"></td>
                    </tr>
<tr>
                    <td align="right" valign="middle" class="bla_low">&nbsp;</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"><img src="../images/paypal.jpg" width="238" height="29" /></td>
                  </tr>
                   <tr>
                    <td align="right" valign="middle" class="bla_low">Card Type<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low">
						  <select name="cardType">
						  <option value="Visa">Visa</option>
						     <option value="Master Card">Master Card</option>
						  <option value="American Express">American Express</option>
						   <option value="Discover">Discover</option>
						    <option value="Diners Club">Diners Club</option>
						        <option value="JCB">JCB</option>
						   
						  </select>
                      </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Card Number<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"><html:text property="cardNumber" styleClass="restaurant_input"  maxlength='16' onkeypress="return isNumberKey(event);"  />
                     <span class="text_h10"> (enter number without spaces or dashes)</span> <html:errors property="cardNumber" /></td>
                  </tr>
                   <tr>
                    <td align="right" valign="middle" class="bla_low">Name on Card<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"><html:text property="cardName" styleClass="restaurant_input"  />
                     <span class="text_h10"> </span> <html:errors property="cardName" /></td>
                  </tr>
                   <tr>
                    <td align="right" valign="middle" class="bla_low">Verification Code<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low" ><html:text property="verificationCode" styleClass="restaurant_input"  maxlength="6"  onkeypress="return isNumberKey(event);"   />
                     <span class="text_h10"> (enter number without spaces or dashes)</span>
                     <html:errors property="verificationCode" /></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Expiry Date</span><span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"> 
                    										<html:text property="expiryMonth" styleClass="restaurant_small"   onkeypress="return isNumberKey(event);"  maxlength="2" />/
                    									<html:text property="expiryYear"   styleClass="restaurant_small"     onkeypress="return isNumberKey(event);"   maxlength="4"  />
                      <span class="text_h10"> (mm/yyyy)</span><html:errors property="expiryMonth" /> <html:errors property="expiryYear" /></td>
                  </tr>
					<tr>
                    <td width="20%" height="28" align="left" valign="bottom" class="text_h3">Billing Information</td>
                    <td colspan="3" align="left" valign="middle" class="red_text">All Information is required. Please state all information as it appears on your credit card statement.</td>
                  </tr>
                  
                  <tr>
                    <td colspan="3" align="center" valign="middle" class="bla_low">
                     <html:checkbox property="autoFillDetails" styleId="autoFillDetails" onclick="fill()" ></html:checkbox>
                    &nbsp;Check this box, if Billing information  is the same as the Business information</td>
                  </tr>
                  <tr>
                    <td colspan="4" align="left" valign="middle" class="td_bg"></td>
                  </tr>
           <!--   <tr>
                    <td align="right" valign="middle" class="bla_low">Customer ID:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low">Deo-John001</td>
                  </tr> --> 
                  <input type="hidden" id="hfn" value="${userInfo.firstname}"/>
                  <input type="hidden" id="hln" value="${userInfo.lastname}"/>
                  <input type="hidden" id="hadd1" value="${userInfo.address}"/>
                  <input type="hidden" id="hadd2" value="${userInfo.address1}"/>
                  <input type="hidden" id="hcity" value="${userInfo.cityId}"/>
                  <input type="hidden" id="hstate" value="${userInfo.stateId}"/>
                  <input type="hidden" id="hcountry" value="${userInfo.countryId}"/>
                  <input type="hidden" id="hzip" value="${userInfo.zipCode}"/>
                  <input type="hidden" id="hemail" value="${userInfo.emailId}"/>
                  <input type="hidden" id="hphone" value="${userInfo.mobilePhone}"/>
                  <input type="hidden" id="hfax" value="${userInfo.fax}"/>
                  <div id="statelists" style="display:none">
                     <select id="hstates" name="hstates">
                       <!--<c:forEach var="dList2" items="${dropDownList.states}" >
                           <option id="${dList2.stateId}" value="${dList2.stateId}">${dList2.stateName}</option>
                       </c:forEach>
                       
                       --><c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<option value="${dList2.stateId}">${dList2.stateName }</option>
			                 		</c:if>
			                 		</c:forEach>
			                 		</c:forEach>
                     </select>
                     <select id="hcountries" name="hcountries">
                       <c:forEach var="dList" items="${dropDownList.countries}" >
                           <option id="${dList.countryId}" value="${dList.countryId}">${dList.countryName}</option>
                       </c:forEach>
                     </select>
                     <c:forEach var="dList" items="${dropDownList.countries}" >
                          <c:if test="${dList.countryId eq userInfo.countryId}">
                             <input type="hidden" id="countryname" value="${dList.countryName}"/>
                          </c:if>
                     </c:forEach>
                  </div>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">First Name<span class="red_text">*</span>:</td>
                    <td width="20%" align="left" valign="middle"><html:text property="firstName" styleId="firstName" styleClass="restaurant_input"  />
                    <html:errors property="firstName" /></td>
                    <td width="14%" align="right" valign="middle" class="bla_low">Last Name<span class="red_text">*</span>:</td>
                    <td width="29%" align="left" valign="middle"><html:text property="lastName" styleClass="restaurant_input"  />
                    <html:errors property="lastName" /></td>
                  </tr>
                 
 					<tr>
                    <td align="right" valign="middle" class="bla_low">Address1<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle"><html:text property="address1" styleClass="restaurant_input"  />
                    <html:errors property="address1" /></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Address2: <span class="red_text"></span></td>
                    <td colspan="3" align="left" valign="middle"><html:text property="address2" styleClass="restaurant_input"  />
                   </td>
                  </tr>
				 <tr>
                    <td align="right" valign="middle" class="bla_low">City<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle"><html:text property="city" styleClass="restaurant_input"  />
                    <html:errors property="city" /></td>
                  </tr>
					 <tr>
                    <td align="right" valign="middle" class="bla_low">State/Province<span class="red_text">*</span>:</td>
                    <td align="left" valign="middle">
                    <html:select property="state"    styleClass="restaurant_select" styleId="states"    >
			                			<html:option value="">Select State</html:option>
			               <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateName}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach>  </html:select>
                    <html:errors property="state" />
                    </td>
                    <td align="right" valign="middle" class="bla_low">Zip/Postal Code<span class="red_text">*</span>:</td>
                    <td align="left" valign="middle"><html:text property="zip" styleClass="restaurant_input"  />
                    <html:errors property="zip" /></td>
				    </tr>
 
                   <tr>
                    <td align="right" valign="middle" class="bla_low">Country<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle"> 
                    	<html:select property="country"    styleClass="restaurant_select" styleId="countries"   >
			                			<html:option value="">Select Country</html:option>
			                <bean:define id="relationships3" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships3" property="countryName" labelProperty="countryName"/>
			                </html:select> 
                    <html:errors property="country" /></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Email<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle"><html:text property="email" styleClass="restaurant_input"  />
                    <html:errors property="email" /></td>
                  </tr>
 <tr>
                    <td align="right" valign="middle" class="bla_low">Phone<span class="red_text">*</span>:</td>
                    <td colspan="3" align="left" valign="middle">
                    <html:text property="phone" styleClass="restaurant_input" onkeypress="return isNumberKey(event);"   />
                    <html:errors property="phone" /></td>
                  </tr>
<tr>
                    <td align="right" valign="middle" class="bla_low">Fax:</td>
                    <td colspan="3" align="left" valign="middle"><html:text property="fax" styleClass="restaurant_input"   onkeypress="return isNumberKey(event);"  />
                     </td>
                  </tr>
                  <tr>
                    <td height="40" colspan="4" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="110" style="padding-right:5px"><div id="select_hot"><a href="configPagedisplay.do?operation=calulate">Cancel</a></div></td>
                          <td width="110"><div id="select_hot"><html:reset styleClass="but_img"/></div></td>
                          <td width="110"><div id="select_hot"><html:submit styleClass="but_img"></html:submit></div></td>
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
              </html:form>
            </table>
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