<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp" %>
      <link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
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
<!--Header Start-->
<jsp:include page="header.jsp">
	<jsp:param name="currentPage" value="MyAccount" />
</jsp:include> 
<!--Header End here-->

<div class="cantainer_inner">
      <div class="main_cantainer">
        <div class="cantainer_content">
   
         <div class="inner_cantainer">
            <div class="main_deal">
  
                   <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	
  	                   <div class="content_deal_inner">	
  	                   
    <table width="968" border="0" cellspacing="0" cellpadding="0">
      <%@ include file="admin_banner.jsp" %>     
       <tr>
        <td height="17" colspan="3" align="center" valign="top">
        <html:form action="/jsp/searchBilling" method="post">
            <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Billing Summary</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="5">
                      <tr>
                    <td height="40" align="right" valign="middle" class="text_formsub">
                     <span class="gre_low">Start Date</span>:</td>
                    <td width="190" align="left" valign="middle">
                     <html:text styleClass="restaurant_input" property="startDate" styleId="startDate" onchange="change_date_format(this.value);" > </html:text>
                     <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" /></td>
                        
                    <td width="60" align="right" valign="middle" class="gre_low">End Date:</td>
                    <td width="190" align="left" valign="middle">
                     <html:text styleClass="restaurant_input" property="endDate" styleId="endDate" onchange="change_date_format2(this.value);" > </html:text>
                     <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" /></td>
                     
                    <td align="left" valign="middle"><table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                        <tr>
                         <input type="hidden" name="Id" id="Id" value="${restaurantId }"/>
                         <td><div id="select_hot"><html:submit property="operation" value="searchBilling" styleId="searchBilling" styleClass="login_butgre">Search</html:submit></div></td>
                        </tr>
                    </table></td>
                  </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <c:if test="${not empty size}">
                          <td align="left" valign="middle">Total ${size} results </td> 
                          </c:if>
                          <td width="100" height="26" align="right" valign="middle" class="text_h8"></td>
                          <td width="380" align="left" valign="middle">&nbsp;</td>
                          <td align="right" valign="middle" class="blue_medium">&nbsp;</td>
                        </tr>
                    </table></td>
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
                     <td align="center" valign="top"><br/>
                    
                       
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                         
                  <tr>
                    <td align="center" valign="top"><br/>
                   
                     <% if (request.getAttribute("purchasedDate").equals("NO") ) 
                         {%>
                        <c:if test="${not empty bill}">
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Date</td>
                            <td align="left" valign="middle" class="text_h3">Amount</td>
                                 <td align="center" valign="middle" class="text_h3">Number of Credits</td>
                            <td align="left" valign="middle" class="text_h3">Transaction Number</td>
                             <td align="left" valign="middle" class="text_h3">Credit card Number</td>
                          </tr>
                          <c:forEach var="billing" items="${bill}" >
                  <tr>
                    <td align="left" valign="middle" class="table_dark">${billing.purchasedDate}</td>
                    <html:hidden property="purchasedDate" value="${billing.purchasedDate}" />
                    <td align="left" valign="middle" class="table_dark"> ${billing.amount}</td>
                       <td align="left" valign="middle" class="table_dark"> ${billing.noOfUnits}</td>
                    <td align="left" valign="middle" class="table_dark"> ${billing.transNumber}</td>
                        <td align="left" valign="middle" class="table_dark"> ${billing.accNo}</td>
                  </tr>
                  </c:forEach>
                   <tr><td  align="left" valign="middle" class="text_h3">Total: ${total}</td></tr>
                </table>
                </c:if>
                <%} %>
                
                
                <% if (request.getAttribute("purchasedDate").equals("YES") ) 
                {%> 
                <c:if test="${not empty purchaseDate}">
                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                  <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Date</td>
                            <td align="center" valign="middle" class="text_h3">Amount</td>
                                 <td align="center" valign="middle" class="text_h3">Number of Credits</td>
                            <td align="center" valign="middle" class="text_h3">Transaction Number</td>
                            <td align="center" valign="middle" class="text_h3">Credit card Number</td>
                          </tr>
                  <c:forEach var="billing1" items="${purchaseDate}" >
                  <tr>
                    <td align="left" valign="middle" class="table_dark">${billing1.purchasedDate}</td>
                    <td align="left" valign="middle" class="table_dark"> ${billing1.amount}</td>
                       <td align="left" valign="middle" class="table_dark"> ${billing1.noOfUnits}</td>
                    <td align="left" valign="middle" class="table_dark"> ${billing1.transNumber}</td>
                             <td align="left" valign="middle" class="table_dark"> ${billing1.accNo}</td>
                  </tr>
                  </c:forEach>
                  <tr><td  align="left" valign="middle" class="text_h3">Total: ${total}</td>
                  </tr>
                </table>
                </c:if>
                <%} %>
                 <br/></td>
              </tr>
                 </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="left" valign="middle">&nbsp;</td>
                          <td align="right" valign="middle" class="blue_medium">&nbsp;</td>
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
          <!-- form End--> 
         </html:form>
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


