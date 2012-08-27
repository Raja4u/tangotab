<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
	<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
	<%@ page import="com.tangotab.web.form.ConfigForm" %>
	<%@ page import="java.text.DecimalFormat"  %>
	<%@page import ="java.text.NumberFormat" %>
	 <% ConfigForm configvalues =(ConfigForm) request.getAttribute("config");
										     NumberFormat usFormat = new DecimalFormat("#0.00");  
			                                 String minChargeAmt = usFormat.format(configvalues.getMinChargeAmt());
			                                 String credit = usFormat.format(configvalues.getDefaultDealCreditValue());
			                                  String discount = usFormat.format(configvalues.getDefaultDiscountAmountOnAccount());
			                                  String setupFee = usFormat.format(configvalues.getDefaultSetupFee());
			                                 
										  %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp" %>
     
    
	  <script type="text/javascript" src="../js/scroll.js"></script>
	  <script type="text/javascript" src="../js/scrollend.js"></script>
      <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
	  <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
      <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
      <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
      <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css" />

<script language="javascript" type="text/javascript">
	function change_date_format(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("from_date_h").value = date_out_put;
	}
    
    function change_date_format2(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("to_date_h").value = date_out_put;
		
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
		      <%@ include file="admin_banner.jsp" %>
		   
		      <tr>
		        <td height="6" colspan="3" align="left" valign="top"></td>
		      </tr>
		      <tr>
		        <td height="17" colspan="3" align="center" valign="top">
		        <!-- form Start-->
		        <html:form action="/jsp/configPage">
		        
		            <table width="968" border="0" cellspacing="0" cellpadding="0" class="form_txt">
		              <tr>
		                <td background="../images/1.png"></td>
		                <td width="952" height="8" background="../images/5.png"></td>
		                <td background="../images/2.png"></td>
		              </tr>
		              <tr>
		                <td width="8" background="../images/7.png"></td>
		                <td height="100" align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="5">
		                  <tr>
		                    <td height="30" colspan="2" align="center" valign="middle" class="red_max">Config Page</td>
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
		                    <td width="30%" align="right" valign="middle" class="bla_low">Minimum Charge Amount($)<span class="red_text">*</span>:</td>
		                    <td width="38%" align="left" valign="middle"><html:text property="minChargeAmt" styleClass="restaurant_input" value="<%=minChargeAmt %>"></html:text>
		                    <span class="red_text"><html:errors property="minChargeAmt"/></span></td>
		                      
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low">One Credit($)<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle" ><html:text property="defaultDealCreditValue" styleClass="restaurant_input"  value="<%=credit %>"></html:text> 
		                     <span class="red_text"><html:errors property="defaultDealCreditValue"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top" class="bla_low">Discount($)&nbsp;:</td>
		                    <td align="left" valign="middle"><html:text property="defaultDiscountAmountOnAccount" styleClass="restaurant_input" value="<%=discount %>"></html:text>
		                     <span class="red_text"><html:errors property="defaultDiscountAmountOnAccount"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low">Setup Fee($)<span class="red_text">*</span>:</td>
		                    <td align="left" valign="middle"><html:text property="defaultSetupFee"  styleClass="restaurant_input" value="<%=setupFee %>"></html:text>
		                     <span class="red_text"><html:errors property="defaultSetupFee"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low">Discount Date From<span class="red_text"></span>:</td>
		                    <td align="left" valign="middle">
                           <table>
                           <tr>
                           <td align="left" valign="middle">
		                    <html:text property="discountFromDate" styleId="startDate" readonly="true"  styleClass="restaurant_input" onchange="change_date_format(this.value);" ></html:text>
		                    <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" />
		                     <span class="red_text"><html:errors property="discountFromDate"/></span></td>
		                       
							 <td width="65" align="right" valign="middle" class="bla_low">To<span class="red_text"></span>:</td>
		                    <td align="left" valign="middle">
		                    <html:text property="discountTODate" styleId="endDate" readonly="true" styleClass="restaurant_input" onchange="change_date_format(this.value);"></html:text>
		                    <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" />
		                     <span class="red_text"><html:errors property="discountTODate"/></span></td>
                           
                           </tr>
                           </table>
		                  
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low">Credits for approving the customized deal<span class="red_text"></span>:</td>
		                    <td align="left" valign="middle"><html:text property="customizedDealCredit" styleClass="restaurant_input"></html:text>
		                     <span class="red_text"><html:errors property="customizedDealCredit"/></span></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="middle" class="bla_low">Credits deducted when the User selects a deal<span class="red_text"></span>:</td>
		                    <td align="left" valign="middle"><html:text property="creditUserDeal" styleClass="restaurant_input"></html:text>
		                     <span class="red_text"><html:errors property="creditUserDeal"/></span></td>
		                  </tr>
		                  <tr>
		                     <td align="right" valign="middle" class="bla_low">Promotion code<span class="red_text"></span>:</td>
		                     <td align="left" valign="middle">
		                     <html:radio property="promotionCode" value="1">Yes</html:radio>
		                     <html:radio property="promotionCode" value="0">No</html:radio>
		                     <!--<input type="radio" name="promo" value="Yes">Yes</input>
		                     <input type="radio" name="promo" value="No" CHECKED>No</input>
		                     --></td>
		                  </tr>
		                  <tr>
		                    <td height="45" colspan="2" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
		                        <tr>
		                          <td><div id="submitId"><html:submit styleClass="but_img" property="operation"> Update</html:submit></div></td>
		                         
		                          <td><div id="select_hot"><a href="#">Cancel</a></div></td>
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
		            </html:form>
		          <!-- form End-->        </td>
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
	<script language="JavaScript1.2">
Calendar.setup({
        inputField     :    "startDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp1",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });
   
   Calendar.setup({
        inputField     :    "endDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp2",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });
</script>
</body>
</html>