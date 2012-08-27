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
								<td height="17" colspan="3" align="center" valign="top">
								
								  <table width="968" border="0" cellspacing="0" cellpadding="0">
							<html:form action="/jsp/paymentGatewayCredit">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top"><table width="935" border="0" cellpadding="0" cellspacing="5">
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
																		<br>
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
                    <td align="right" valign="middle" class="bla_low">Card Number: <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"><html:text property="cardNumber" styleClass="restaurant_input"  maxlength='16' onkeypress="return isNumberKey(event);"  />
                     <span class="text_h10"> (enter number without spaces or dashes)</span> <html:errors property="cardNumber" /></td>
                  </tr>
 
                   <tr>
                    <td align="right" valign="middle" class="bla_low">Verification Code: <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle" class="bla_low" ><html:text property="verificationCode" styleClass="restaurant_input"  maxlength="6"  onkeypress="return isNumberKey(event);"   value="xxx"  readonly="true" />
                     <span class="text_h10"> (enter number without spaces or dashes)</span>
                      </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Expiry Date</span>:  <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle" class="bla_low"> 
                    										<html:text property="expiryMonth" styleClass="restaurant_small"   onkeypress="return isNumberKey(event);"  maxlength="2" readonly="true" />
  					</td>
                  </tr>
					<tr>
                    <td width="20%" height="28" align="left" valign="bottom" class="text_h3">Billing Information</td>
                    <td colspan="3" align="left" valign="middle" class="red_text">All Information is required.Please state all information as it appears on your credit card statement.</td>
                  </tr>
                  <tr>
                    <td colspan="4" align="left" valign="middle" class="td_bg"></td>
                    </tr>
           <!--      <tr>
                    <td align="right" valign="middle" class="bla_low">Customer ID:</td>
                    <td colspan="3" align="left" valign="middle" class="bla_low">Deo-John001</td>
                  </tr> -->  
                  <tr>
                    <td align="right" valign="middle" class="bla_low">First Name: <span class="red_text">*</span></td>
                    <td width="20%" align="left" valign="middle"><html:text property="firstName" styleClass="restaurant_input"    readonly="true" />
                    <html:errors property="firstName" /></td>
                    <td width="10%" align="right" valign="middle" class="bla_low">Last Name: <span class="red_text">*</span></td>
                    <td width="33%" align="left" valign="middle"><html:text property="lastName" styleClass="restaurant_input"   readonly="true"  />
                    <html:errors property="lastName" /></td>
                  </tr>
                 
 					<tr>
                    <td align="right" valign="middle" class="bla_low">Address1: <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle"><html:text property="address1" styleClass="restaurant_input"    readonly="true" />
                    <html:errors property="address1" /></td>
                  </tr>
 
				 <tr>
                    <td align="right" valign="middle" class="bla_low">City: <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle"><html:text  property="city" styleClass="restaurant_input"   readonly="true"  />
                    <html:errors property="city" /></td>
                  </tr>
					 <tr>
                    <td align="right" valign="middle" class="bla_low">State/Province: <span class="red_text">*</span></td>
                    <td align="left" valign="middle">
                    <html:text property="state"    styleClass="restaurant_select" styleId="states"     readonly="true"  />
                    <html:errors property="state" />
                    </td>
                    <td align="right" valign="middle" class="bla_low">Zip/Postal Code: <span class="red_text">*</span></td>
                    <td align="left" valign="middle"><html:text property="zip" styleClass="restaurant_input"    readonly="true"  />
                    <html:errors property="zip" /></td>
				    </tr>
 
                   <tr>
                    <td align="right" valign="middle" class="bla_low">Country: <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle"> 
                    	<html:text property="country"    styleClass="restaurant_select" styleId="countries"    readonly="true"  /> 
                    <html:errors property="country" /></td>
                  </tr>
            
 <tr>
                    <td align="right" valign="middle" class="bla_low">Phone: <span class="red_text">*</span></td>
                    <td colspan="3" align="left" valign="middle">
                    <html:text property="phone" styleClass="restaurant_input" onkeypress="return isNumberKey(event);"    readonly="true"  />
                    <html:errors property="phone" /></td>
                  </tr>
<tr>
                    <td align="right" valign="middle" class="bla_low">Fax:</td>
                    <td colspan="3" align="left" valign="middle"><html:text property="fax" styleClass="restaurant_input"    readonly="true"  onkeypress="return isNumberKey(event);"  />
                     </td>
                  </tr>
                  <tr>
                    <td height="40" colspan="4" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><div id="select_hot"><html:submit styleClass="but_img"></html:submit></div></td>
                           <td><div id="select_hot"><a href="configPagedisplay.do?operation=calulate">Cancel</a></div></td>
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