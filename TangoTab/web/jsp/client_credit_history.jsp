<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>
<script type="text/javascript">
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
	function check()
	{
	var sd = document.getElementById("startDate").value;
	var ed = document.getElementById("endDate").value;
	if(sd.trim().length < 1 && ed.trim().length < 1)
	  {
	   alert("please select dates");
	   return false;
	   }
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
        <html:form action="/jsp/searchCreditsAction" method="post">
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
                    <td height="30" align="center" valign="middle" class="red_max">Host Credit History</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="text_formsub">&nbsp;</td>
                          <td height="30" align="right" valign="middle" class="text_formsub">
                        <span class="gre_low">Start Date</span>:</td>
                        <td width="190" align="left" valign="middle">
                     <input type="text" class="restaurant_input" name="startDate" id="startDate" value="${sd }" onchange="change_date_format(this.value);" ></input> 
                     <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" /></td>
                            
                        <td width="60" align="right" valign="middle" class="gre_low">End Date:</td>
                        <td width="190" align="left" valign="middle">
                     <input type="text" class="restaurant_input"  name="endDate" id="endDate" value="${ed }" onchange="change_date_format2(this.value);" ></input> 
                     <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" /></td>
                     <td><div id="select_hot"><html:submit  value="Search" styleId="search" styleClass="login_red" >Search</html:submit></div></td>
                     </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="100" height="26" align="right" valign="middle" class="text_h8">&nbsp;</td>
                        <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="2">
																		<font color="red"> <bean:write name="message"
																				filter="false" /> </font>
																	</td>
																</tr>
															</logic:present>
														</html:messages>
						</logic:messagesPresent>
                        <td width="350" align="right" valign="middle" class="blue_medium">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr> 
                     <input type="hidden" name="restId" value="${restId}" />                
                    <td align="center" valign="top"><br/>
                    <c:if test="${not empty trans}">
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="left" valign="middle" class="text_h3">S no:</td>
                            <td align="left" valign="middle" class="text_h3">DateOfTransaction</td>
                            <td align="left" valign="middle" class="text_h3">Credited</td>
                            <td align="left" valign="middle" class="text_h3">Debited</td>
                            <td align="left" valign="middle" class="text_h3">Description</td>
                            <td align="left" valign="middle" class="text_h3">DoneBy</td>
                            <td align="left" valign="middle" class="text_h3">CurrentCredits</td>
                            
                          </tr>
                           <c:forEach var="credit" items="${trans}" varStatus="status">
                          <tr>
                           
                            <td align="left" valign="middle" class="table_light">
                            ${status.index+1}</td>
                            <td align="left" valign="middle" class="table_light">
                            ${credit.transDate}</td>
                            <c:if test="${credit.typeOfTrans eq 'Cr'}" >
                            <td align="left" valign="middle" class="table_light">
                            ${credit.noOfCredits }</td>
                            <td align="left" valign="middle" class="table_light">
                            -----</td>
                            </c:if>
                            <c:if test="${credit.typeOfTrans eq 'Dr'}" >
                            <td align="left" valign="middle" class="table_light">
                            -----</td>
                            <td align="left" valign="middle" class="table_light">
                            ${credit.noOfCredits }</td>
                            </c:if>
                            <td align="left" valign="middle" class="table_light">
                            ${credit.description}</td>
                            <td align="left" valign="middle" class="table_light">
                            ${credit.user.firstname}</td>
                            <td align="left" valign="middle" class="table_light">
                            ${credit.currentCredits}</td>
                            
                           
                            </tr> </c:forEach>
                        </table></c:if>
                        </td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="right" valign="middle"><table width="110" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                            </tr>
                          </table></td>
                          <td align="right" valign="middle" class="blue_medium">&nbsp;</td>
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
