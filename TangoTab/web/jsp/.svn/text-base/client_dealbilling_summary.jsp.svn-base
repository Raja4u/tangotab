<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.tangotab.util.DateConverterUtility" %>
<%@ page import ="com.tangotab.TO.BillingCcTO" %>
<%@ page import ="com.tangotab.TO.DealSummaryTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>

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

<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		</jsp:include>
<!--Header End here-->
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
							<td colspan="3" align="center" valign="top">
								<!--Client Start-->
							  
    <!--Client End-->   
			<html:form action="/jsp/billingSearch" method="post">
			 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="949" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top">
                <table width="945" border="0" align="center" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Account Summary</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                 
                  <tr>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                      
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
                    
                       
                        <table width="98%" border="0" align="left" cellpadding="0" cellspacing="1"  >
                        <% DealSummaryTO dt = new DealSummaryTO();
                         dt =(DealSummaryTO)request.getAttribute("bill");
                         int credits = 0;
                         credits = (int)dt.getCurrentcredits(); %>
                         
                  <tr>
                    <td align="left" valign="top"><br/>
                    
                        <table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" >
                          <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Published Deals</td>
                             <td align="left" valign="middle" class="table_dark">${bill.publishdeal}</td>
                    
                          </tr>
                          
                  <tr>
                      <td align="center" valign="middle" class="text_h3">Unpublished Deals</td>
                    <td align="left" valign="middle" class="table_dark">${bill.unpublishdeal}</td>
                  
                  </tr>
                  <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Current Credits</td>
                             <td align="left" valign="middle" class="table_dark"><%=credits %></td>
                    
                          </tr>
                         
                </table>
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
     </td></tr></table> 
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

