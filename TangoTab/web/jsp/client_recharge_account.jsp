<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="com.tangotab.web.form.ConfigForm"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="java.text.DecimalFormat" %>
<%@page import="java.text.NumberFormat" %>
<!-- SimpleDateFormat is used to generate an invoice number based off of the date -->
<!-- the following imports are used to generate the fingerprint -->
<%@ page import="java.security.*" %>
<%@ page import="javax.crypto.*" %>
<%@ page import="javax.crypto.spec.SecretKeySpec" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<sslext:pageScheme secure="true"/>
	<%
	ConfigForm configForm=new ConfigForm();
	if(session.getAttribute("configdisplay")!=null)
	configForm=(ConfigForm)session.getAttribute("configdisplay");
	
	NumberFormat usFormat = new DecimalFormat("#0.00"); 
			                                 String minChargeAmt = usFormat.format(configForm.getMinChargeAmt());
			                                 String credit = usFormat.format(configForm.getDefaultDealCreditValue());
			                                  String discount = usFormat.format(configForm.getDefaultDiscountAmountOnAccount());
			                                  String setupFee = usFormat.format(configForm.getDefaultSetupFee());
	 
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

<script src="../script/droplinemenu.js" type="text/javascript"></script>
<script type="text/javascript">
function displayall(){

  document.getElementById("unit1").value = (document.getElementById("qty").value)/(document.getElementById("credit").value);
 // var t = document.getElementById("qty").value*1  +  document.getElementById("fee").value*1;
  var t = document.getElementById("qty").value*1 ;
  document.getElementById("fee1").value=0*1+" USD";
  document.getElementById("subtot1").value	= 1*t+" USD";
   if(  document.getElementById("discount").value > 0 ){
   document.getElementById("discount1").value = document.getElementById("discount").value+"%";
   var tot = 1*t-(document.getElementById("discount").value *t)/100;
   document.getElementById("totdue").value=1*tot+" USD";
   document.getElementById("final").value=tot;
   document.getElementById("totaldue").value=tot;
  }else{
   document.getElementById("totdue").value=1*t+" USD";
   document.getElementById("final").value=t;
   document.getElementById("totaldue").value=t;
  }
  
   return true;
}

function getCheckedValue(radioObj) {
	if(!radioObj)
		return "";
	var radioLength = radioObj.length;
	if(radioLength == undefined)
		if(radioObj.checked)
			return radioObj.value;
		else
			return "";
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].checked) {
			return radioObj[i].value;
		}
	}
	return "";
}
  function getQty()
   {
        if(document.getElementById('qty').value=='' && document.getElementById('qty').value!='Enter $ Amount')
	{
     	  document.getElementById('qtymsg').innerHTML="Please enter amount"; 
   }
     if(document.getElementById('qty').value=='Enter $ Amount')
	{
	document.getElementById('qty').value='';
	}
   return true;
   }
	function submitToAction(){
 
	if( parseInt(document.getElementById('unit').value) > document.getElementById('qty').value ) {
	  document.getElementById('qtymsg').innerHTML="The minimum amount to charge is $"+document.getElementById('unit').value; 
	}else if( ((document.getElementById("qty").value)%(document.getElementById("credit").value)) != 0 ){
	    var bal = (document.getElementById("qty").value)%(document.getElementById("credit").value);
	    var amou = document.getElementById("credit").value*1 - bal*1;
	    amou = document.getElementById('qty').value*1 + amou*1;
	    document.getElementById('qtymsg').innerHTML="Please Recharge with $"+amou+".00 to receive full reservation credits"; 
	}
	else if(getCheckedValue(document.frm.isAutoDebit)=='')
	{
		document.getElementById('mlymsg').innerHTML="SelectMonthly auto debit";
	}else 	if(!(document.frm.privacy.checked))
	{
		document.getElementById('privacymsg').innerHTML="Select Privacy User Agreement";
	}
 
	else
	{	document.getElementById("amountId").value=document.getElementById("totdue").value;
	
		var amount= document.getElementById("amountId").value;
		var descriptionId=  document.getElementById("descriptionId").value;
		//var loginId = dwr.util.getValue("loginId");
	//		alert('');
	//	var sequence = dwr.util.getValue("sequenceId");
	//	var timeStamp = dwr.util.getValue("timeStampId");
		//alert('');
			document.frm.action = "paymentGatewayStart.do";
			document.frm.submit();
		 
	  		}
		
	}
</script>

</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
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
				      <% // include file=client_menujsp %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
						<!-- form Start-->
						<form action="" method="post" name="frm">
				<table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top">
                <table width="952" border="0" align="center" cellpadding="0" cellspacing="8">
                 <c:if test="${records eq 'no'}">
                
               			  <tr>
														<td height="30" colspan="3" align="center" valign="middle"
															 >
															<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="5">
													<tr>
													<td  width="150px">Step 1<br/>
														Basic Account info 
													
													</td>
														<td  width="50px" ><b><img src="../images/rightarrowb.png" width="100px" height="30px"/></b>
													
													</td>
														<td   width="100px">Step 2<br/>Business Info 
													
													</td>
													 
														<td  width="50px" ><b><img src="../images/rightarrowo.png" width="100px" height="30px"/></b>
													
													</td>
														<td   align="left"  > <b>Step 3<br/>
														Charge your account 
													</b>
													</td>
													</tr>
													</table>
														</td>
													</tr>
													</c:if>
                  <tr>
                    <td height="30" colspan="2" align="center" valign="middle" class="red_max">&nbsp;</td>
                    <td height="30" align="left" valign="middle" class="red_max">Charge Account </td>
                  </tr>
                  <tr>
                    <td width="22%" colspan="2" align="right" valign="middle" class="bla_low">Product:</td>
                    <td width="38%" align="left" valign="middle" class="bla_low">TangoTab Credits</td>
                  </tr>
                  <tr>
                    <td colspan="2" align="right" valign="middle" class="bla_low">Amount: $ </td>
                    <td align="left" valign="middle" class="text_h9">
                      <input type="text" class="restaurant_input" id="qty" name="qty" value="Enter $ Amount" 
                    onkeyup="javascript:displayall();" maxlength="7"  onkeypress="return isNumberKey(event);" onfocus ="getQty()" />
                     &nbsp;(Minimum Charge Amount $<%=minChargeAmt%>)
                    <span class="red_text" id="qtymsg"></span>
                      
                      <!-- hidden -->
                      
                      <input type="hidden" id="unit" name="minChargeAmt" class="restaurant_input" value="<%=configForm.getMinChargeAmt()%>">
                    
                      <input type="hidden" id="credit" name="defaultDealCreditValue"  value="<%=configForm.getDefaultDealCreditValue() %>" class="restaurant_input"> 
                      <input type="hidden" id="discount" name="defaultDiscountAmountOnAccount"  value="<%=configForm.getDefaultDiscountAmountOnAccount() %>" class="restaurant_input">
                      
                      <input type="hidden" id="final" name="final" value="1" class="restaurant_input">                      
                      
                      <input type="hidden" id="totaldue" name="totaldue" value="1" class="restaurant_input">        
                    </td>
                  </tr>
                  <c:if test="${records eq 'no'}">
                    <input type="hidden" id="fee" name="defaultSetupFee" value="<%=configForm.getDefaultSetupFee() %>" class="restaurant_input">
                   <input type="hidden" value='<%=configForm.getDefaultDiscountAmountOnAccount()%>'  name="dis"/>
                  </c:if>
                  
                  <tr>
                    <td colspan="2" align="right" valign="middle" class="bla_low">Number of Reservations:</td>
                    <td align="left" valign="middle" class="text_h9">
                    <input type="text" class="restaurant_input" id="unit1" name="unit1" readonly="readonly" value="0.00"/>
                    &nbsp;(Credits purchased)
                      <span class="red_text"></span>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" align="right" valign="middle" class="bla_low">Set-up Fee: $</td>
                    <td align="left" valign="middle" class="text_h9">
                    <input type="text" class="restaurant_input" id="fee1" name="fee1" readonly="readonly" value="<%=setupFee %>"/>
                      <span class="red_text"></span>
                    </td>
                  </tr>
               
         <!-- added for future purpose its extendable -->
                  <%if(configForm.getPromotionCode() == Short.parseShort("1")){ %>
                  <tr>
                      <td colspan="2" align="right" valign="middle" class="bla_low">Promotion Code:</td>
                      <td align="left" valign="middle" class="text_h9">
                        <input type="text" class="restaurant_input" name="pcode"/></td>
                  </tr>
                  <%}%>
                 <tr>
                    <td colspan="2" align="right" valign="middle" class="bla_low">Sub Total: $</td>
                    <td align="left" valign="middle" class="text_h9">
                      <input type="text" class="restaurant_input" id="subtot1" name="subtot1" readonly="readonly" value="0.00 USD"/>
                      <span class="red_text"></span>
                    </td>
                  </tr>
                 
            
                 
             
                  
                     <c:if test="${records eq 'yes'}">
                                         <input type="hidden" id="fee" name="defaultSetupFee" value="0" class="restaurant_input">
                      </c:if>
                      <!-- 
                      <tr>
                    <td align="right" valign="middle" class="bla_low">No.of Credits:</td>
                    <td align="left" valign="middle" class="text_h9">
                    <input type="text" class="restaurant_input" id="unit1" name="total1" readonly="readonly" value="0.00 "/>
                        <span class="red_text"></span>
                    </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Set up Fee: $</td>
                    <td align="left" valign="middle" class="text_h9">
                    <input type="text" class="restaurant_input" id="fee1" name="fee1" readonly="readonly" value="<%=setupFee %> "/>
                        <span class="red_text"></span>
                        </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Sub Total: $</td>
                    <td align="left" valign="middle" class="text_h9">
                    <input type="text" class="restaurant_input" id="subtot1" name="subtot1" readonly="readonly" value="0.00 USD"/>
                        <span class="red_text"></span>
                    </td>
                  </tr> -->
                  <%if(configForm.getDefaultDiscountAmountOnAccount()==0) {
                  %>
                   <%  
                   } else 
                   {%>
                  <tr>
                    <td colspan="2" align="right" valign="middle" class="bla_low">Discount: $</td>
                    <td align="left" valign="middle" class="text_h9">
                      <input type="text" class="restaurant_input" id="discount1" name="discount1" readonly="readonly" value="<%=discount%>"/>
                      <span class="red_text"></span>
                    </td>
                  </tr>
                   <%} %> 
              
                  
                  
                  <tr>
                    <td rowspan="2" align="right" valign="middle" class="bla_low"><img src="../images/authorizenet_logo.gif" width="125" height="31" /></td>
                    <td align="right" valign="middle" class="bla_low">Total Due: $</td>
                    <td align="left" valign="middle" class="text_h9">
                      <input type="text" class="restaurant_input" id="totdue" name="totdue" readonly="readonly" value="0.00 USD"/>
                      &nbsp;(Amount charged to the credit card)
                      
                      
                      
                      <INPUT type='hidden' name='x_amount' value="" id="amountId"/>
                      <INPUT type='hidden' name='x_description' value="${description}" id="descriptionId"/>
                      <INPUT type='hidden' name='x_invoice_num' value="${invoice}" />
                      <INPUT type='hidden' name='x_fp_sequence' value="${sequence}" id="sequenceId"/>
                      <INPUT type='hidden' name='x_fp_timestamp' value="${timestamp}" id="timeStampId"/>
                      <INPUT type='hidden' name='x_fp_hash'  id="fingerPrintID"/>
                      <INPUT type='hidden' name='x_test_request' value="${request}"/>
                      <INPUT type='hidden' name='x_show_form' value='PAYMENT_FORM' />
                      <INPUT type='hidden' name='x_relay_response' value='true' />
                      <INPUT type='hidden' name='x_relay_url' value='http://50.17.229.179:8080/TangoTab/jsp/saveRechargeInfo.do' />
                      <input type="hidden" name="purchasedBy" value="${userInfo.emailId}"/>
                      <input type="hidden" name="restId" value="${userInfo.restaurantId}"/>
                      <INPUT type='hidden' name='x_delim_data' value='false' />
                      <span class="red_text"></span>
                    </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Auto Refill:</td>
                    <td align="left" valign="middle" class="text_h9">
                    <input type="radio" name="isAutoDebit" id="radio" value="1" />
                      Yes
                      <input type="radio" name="isAutoDebit" id="radio2" value="0" />
                      No   <span class="red_text" id="mlymsg"    ></span></td>
                  </tr>
                  <c:if test="${ not empty profiles}">
                            <tr>
                    <td align="right" valign="middle" class="bla_low"><span id="siteseal"><script type="text/javascript" src="https://seal.godaddy.com/getSeal?sealID=xK76KRK1ZM5KxMWoeksoI9wx7yFlGmyyv24JASS6rWZjrh94dgQSQ8BpH0i"></script><br/><a style="font-family: arial; font-size: 9px" href="http://www.godaddy.com/business/email-marketing.aspx" target="_blank"></a></span></td>
                    <td align="right" valign="middle" class="bla_low">Select the Credit Card:</td>
                    <td align="left" valign="middle" class="text_h9">
                      <select name="paymentProfileId">
                        <option value="0">New Card</option> 
                        
                        <c:forEach items="${profiles}" var="d">
                          <option value="${d.paymentProfileId}">${d.cardNumber}</option>  
                          </c:forEach>
                        </select>			 
                    </td>
                  </tr>
                  </c:if>
                  <c:if test="${  empty profiles}">
                  <input  name="paymentProfileId" type="hidden" value="0">
                  </c:if>
                  <tr>
                    <td colspan="2" align="right" valign="middle" class="bla_low">&nbsp;</td>
                    <td align="left" valign="middle" class="text_h10">Your account will be charged $<%=minChargeAmt%> when you have $25.00 remaining in your account. This enables you to keep publishing your deals without interruption to your account status. Check the &quot;Yes&quot; box to automate recharge.</td>
                  </tr>
                  <tr>
                    <td colspan="2" align="right" valign="top" class="bla_low">Privacy User Agreement:</td>
                    <td align="left" valign="middle"><input type="checkbox" name="privacy" id="privacy" />
                      <span class="text_h9">  
                        I certify that I have read and agree to the </span>
                      <span class="text_h8"> <a href="../documents/NewMerchantAgreement.pdf" target="_blank"  class="text_agree"  >merchant agreement</a></span> 
                      <span class="text_h9"> , </span> 
                      <span class="text_h8"> <a href="privacy_policy.jsp"
						class="text_agree"  target="_blank" >privacy policy</a> </span> <span class="text_h9">  and</span>
                      <br />
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <a href="terms.jsp"  class="red_text" target="_blank">terms of use</a> <span class="text_h9">   of TangoTab.</span>
                      <br/>
                      <span class="red_text" id="privacymsg"    ></span></td>
                  </tr>
                  <!--<tr>
                    
                    <td colspan="2" align="left" valign="middle" >
                    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                         <td align="right" valign="middle" class="bla_low">Check out:</td>
                         <td><div id="select_hot">
                         <input type="button" id="pay" class="login_but_big_gre" onClick="submitToAction();getQty();" value="Enter Payment Information"/></div></td>
                         <td align="right" valign="middle">
                                <img src="../images/authorizenet_logo.gif" /></td>
                         <td align="right" valign="middle"><span id="siteseal"><script type="text/javascript" src="https://seal.godaddy.com/getSeal?sealID=xK76KRK1ZM5KxMWoeksoI9wx7yFlGmyyv24JASS6rWZjrh94dgQSQ8BpH0i"></script><br/><a style="font-family: arial; font-size: 9px" href="http://www.godaddy.com/business/email-marketing.aspx" target="_blank">email marketing</a></span>
                         </td>
                     
                      </tr>
                    </table></td>
                    
                  </tr>
              
                  <tr>
                    <td align="center" valign="middle" class="bla_low" colspan=2><img src="../images/authorizenet_logo.gif" width="125" height="31" />
                   
                   </td></tr>
                      <tr>
                    <td align="center" valign="middle" class="bla_low" colspan=2>
                    <span id="siteseal"><script type="text/javascript" src="https://seal.godaddy.com/getSeal?sealID=xK76KRK1ZM5KxMWoeksoI9wx7yFlGmyyv24JASS6rWZjrh94dgQSQ8BpH0i"></script><br/><a style="font-family: arial; font-size: 9px" href="http://www.godaddy.com/business/email-marketing.aspx" target="_blank"></a></span>
                   
                   </td></tr>
                <tr>
                    <td align="right" valign="middle" class="bla_low"> 
                   
                       Check out:</td>
                        <td align="left"><div id="select_hot"><input type="button" id="pay" class="login_but_big_gre" onClick="submitToAction();getQty();" value="Enter Payment Information"/></div></td>
                        
                    </tr>  -->
            <tr>
                    <td colspan="3" align="right" valign="middle" class="bla_low">
                    <table width="80%" align="center" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td align="right">Check out:</td>
                        <td style="padding-left:20px;" valign="middle"><div id="select_hot_max"><input type="button" id="pay" class="login_but_big_gre" onClick="submitToAction();getQty();" value="Enter Payment Information"/></div></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table></td>
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
	</div>
</div>
</td></tr></table>
</body>
</html>