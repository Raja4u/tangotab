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
<%@ include file="consumer_imports.jsp"%>

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
		 
	}
    
    function change_date_format2(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
	 
		
	}
	
	function submitForm1(locId){
 
	   var s = locId;
		document.forms[0].action = "viewReservations.do?restLocationId="+locId;
		document.forms[0].submit();
	}
	
	function submitForm(){
	   
		document.viewres.action = "viewByDate.do";
		document.viewres.submit();
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
							
							<table width="760" border="0" cellspacing="0" cellpadding="0">			  
				<%@ include file="client_banner.jsp" %>
				 <%@ include file="client_menu.jsp"%>	
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
						<!-- form Start-->
						<form name = "viewres" action=""  >
						<table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top">
                <table width="952" border="0" align="left" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Activity</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <c:if test="${(userInfo.roleId eq 5  or userInfo.roleId eq 6 )  and (not empty locationsInfo)}">
                  <tr>
                  <td align="left">
                  <table align="left" width="900" cellpadding="0" cellspacing="0">
                  <tr>
              					<td align="left" width="100" valign="middle" class="text_h2">
														<span class="bla_low">Location<span
															class="red_text"></span>:</span>
													<br /></td>
													<td  align="left" valign="middle" class="text_h9">
														<select name="restLocationId" 
															class="restaurant_select"  onchange="submitForm1(this.value)" >
															<option  value="0">All</option>
															<c:forEach var="location" items="${locationsInfo}">
																<option value="${location.restLocationId}" 
																<c:if test="${location.restLocationId == locId}" > 
																<%out.print("selected='selected';"); %></c:if> >
																 ${location.locationRestName}</option>
															</c:forEach>
														</select>
													<br /></td>
												</tr>
                  </table>
                  </td>
                  </tr>
                  </c:if>
                    <c:if test="${userInfo.roleId eq 6 }">
                    <input type="hidden" name="restLocationId"  value="${locId}" />
                    </c:if>
                  
                  
                  <tr>
                    <td align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="5">
                      <tr>
                        <td height="30" align="right" valign="middle" class="text_formsub">
                        <span class="gre_low">Start Date</span>:</td>
                        <td width="190" align="left" valign="middle">
                     <input type="text" class="restaurant_input" name="startDate" id="startDate" value="${sd }" onchange="change_date_format(this.value);" ></input> 
                     <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" /></td>
                            
                        <td width="60" align="right" valign="middle" class="gre_low">End Date:</td>
                        <td width="190" align="left" valign="middle">
                     <input type="text" class="restaurant_input"  name="endDate" id="endDate" value="${ed }" onchange="change_date_format2(this.value);" ></input> 
                     <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" /></td>
                     
                        <td align="left" valign="middle"><table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><input type="submit" class="but_img"  name="submitID" value="Search" onclick="submitForm()"/></div></td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <c:if test="${not empty size}">
                          <td align="left" valign="middle">Total ${size} results </td> 
                          </c:if>
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
                    
                       
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#cccccc">
                          <tr>
                          <td align="center" valign="top" class="table_midbox">
                          <% if ( request.getAttribute("byDate").equals("NO") ) 
                            {%>
                            <c:if test="${not empty reserved}">            
                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                           
                                                  
                                  <tr>
                                  <td height="24" align="center" valign="middle" class="text_h3">Name</td>
                                  <td align="center" valign="middle" class="text_h3">Deal</td>
                                  <td align="center" valign="middle" class="text_h3">Date/Time</td>
                                  <td align="center" valign="middle" class="text_h3">Confirmation Number</td>
                                  </tr>
                                 <c:forEach var="conres" items="${reserved}" >
                                 <tr> 
                                    <td align="left" valign="middle" class="table_light"> ${conres.user.firstname }  </td>
                                    <td align="left" valign="middle" class="table_light"> ${conres.restaurantDeal.dealTemplateName } </td>
                                    <td align="left" valign="middle" class="table_light"> ${conres.bookedTimestamp}</td>
                                    <td align="left" valign="middle" class="table_light"> ${conres.conResId } </td>
                                </tr>
                                </c:forEach>
                            </table>
                            </c:if>
                            <%} %>
                            
                            <% if ( request.getAttribute("byDate").equals("YES") ) 
                            {%>
                            <c:if test="${not empty viewByDate}">            
                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
                           
                                                  
                                  <tr>
                                  <td height="24" align="center" valign="middle" class="text_h3">Name</td>
                                  <td align="center" valign="middle" class="text_h3">Deal</td>
                                  <td align="center" valign="middle" class="text_h3">Date/Time</td>
                                  <td align="center" valign="middle" class="text_h3">Confirmation Number</td>
                                  </tr>
                                 <c:forEach var="conres1" items="${viewByDate}" >
                                 <tr> 
                                    <td align="left" valign="middle" class="table_light"> ${conres1.user.firstname }  </td>
                                    <td align="left" valign="middle" class="table_light"> ${conres1.restaurantDeal.dealTemplateName } </td>
                                    <td align="left" valign="middle" class="table_light"> ${conres1.reservedTimestamp}</td>
                                    <td align="left" valign="middle" class="table_light"> ${conres1.conResId } </td>
                                </tr>
                                </c:forEach>
                            </table>
                            </c:if>
                            <%} %>
          		                            
                            </td> </tr>
                      </table>
                      </td>
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
						</form>
							<!-- form End-->
							</td>
			      		</tr>
			    	</table>
			
				
				<!-- Right control End-->
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