<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>

<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/jqueryslidemenu.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
<script type="text/javascript">
	
	function submitForm(){
//	alert(document.getElementById("restLocationId").options[document.getElementById("restLocationId").selectedIndex].value);
	
		var locationId = document.getElementById("restLocationId").value;
		document.frm.action = "viewDeals.do?locationId="+locationId;
		document.frm.submit();
	}
	
</script>
<%@ include file="consumer_imports.jsp"%>
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

<form action="" method="post" name="frm">
  
    <table width="968" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="3" align="center" valign="top">
          <%@ include file="client_banner.jsp"%>
		  <%@ include file="client_menu.jsp"%>
       </td>
      </tr>
      <tr>
        <td height="6" colspan="3" align="left" valign="top"></td>
      </tr>
       
      <tr>
        <td height="17" colspan="3" align="center" valign="top">
        
        <!-- form Start-->
            <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
             
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top">
                <table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                   <c:if test="${not empty dealsInfo}">
                  <tr>
                  
                    <td height="35" align="center" valign="middle" class="red_max">View Offers</td>
                  </tr>
                  </c:if>
                   <logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="3" class="red_max">
															<bean:write name="message"
																	filter="false" /> 
														</td>
													</tr>
												</logic:present>
											</html:messages>
										</logic:messagesPresent>
                   <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <c:if test="${(userInfo.roleId eq 5 or userInfo.roleId eq 6) and locationsInfoSize gt 1 }"> 
                  <tr>
                  <td align="left">
                  <table align="left" width="900" cellpadding="0" cellspacing="0">
                  <tr>
              					<td align="left" width="100" valign="middle" class="text_h2">
														<span class="bla_low">Location<span
															class="red_text"></span>:</span>
													<br /></td>
													<td  align="left" valign="middle" class="text_h9">
														<html:select property="restLocationId" 
															styleClass="restaurant_select" styleId="restLocationId" onchange="submitForm()" value="${location}">
															<html:option  value="">All</html:option>
															<c:forEach var="location" items="${locationsInfo}">
																<html:option value="${location.restLocationId}">${location.locationRestName}</html:option>
															</c:forEach>
														</html:select>
													<br /></td>
												</tr>
                  </table>
                  </td>
                  </tr>
                  </c:if>
                  <tr>
                    <td align="center" valign="top"><br/>
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td align="center" valign="top">
                             <c:if test="${not empty dealsInfo}">
                 						 <c:forEach var="deal" items="${dealsInfo}" >
                            <table width="950" border="0" align="center" cellpadding="0" cellspacing="5">
                              <tr>
                                <td width="130" align="right" valign="top"><span class="green">Deal Name:</span></td>
                                <td width="250" align="left" valign="top"><span class="red">${deal.dealTemplateName}</span></td>
                                <td width="130" align="right" valign="top"><span class="green">Description:</span></td>
                                <td width="250" align="left" valign="top"><span class="red">${deal.dealTemplateDescription}</span></td>
                                <td width="185" rowspan="5" align="center" valign="middle"><span class="text_h9"><img src="${deal.restDealImagePath}" width="190" height="100" /></span></td>
                              </tr>
                              <tr>
                                <td align="right" valign="top"><span class="green">Days:</span></td>
                                <td align="left" valign="top"><span class="red"> <c:if test="${fn:indexOf(deal.availableWeekDays, \"1\") >= 0}">
										SUN
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"2\") >= 0}">
										MON
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"3\") >= 0}">
										TUE
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"4\") >= 0}">
										WED
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"5\") >= 0}">
										THU
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"6\") >= 0}">
										FRI
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"7\") >= 0}">
										SAT
									</c:if>	<br/></span></td>
                                <td align="right" valign="top"><span class="green">Restrictions:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.dealTemplateRestrictions}</span></td>
                              </tr>
                              <tr>
                                <td align="right" valign="top"><span class="green">QTY:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.availableDealsQty}</span></td>
                                <td align="right" valign="top"><span class="green">Recurring:</span></td>
                                <td align="left" valign="top"><span class="red"> 
                                <c:if test="${deal.isRecurring== 0}">
                                No
                                </c:if> <c:if test="${deal.isRecurring== 1}">
                                Yes
                                </c:if></span></td>
                              </tr>
                              <tr>
                                <td align="right" valign="top"><span class="green">Start Time:</span></td>
                                <td align="left" valign="top"><span class="red"> ${deal.availableStartTime}</span></td>
                                <td align="right" valign="top"><span class="green">Start Date:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.startDate}</span></td>
                              </tr>
                              <tr>
                                <td align="right" valign="top"><span class="green">End Time:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.availableEndTime}</span></td>
                                <td align="right" valign="top"><span class="green">End Date:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.dealEndDate}</span></td>
                              </tr>
                              <tr>
                              <c:if test="${deal.restDealPublishStatus == 0}">
                              		<c:if test="${userInfo.billingMethodId == 1}">
                              			<c:if test="${userInfo.currentCredits > 0}">
		                                	<td align="right" valign="top"><table align="left" cellpadding="0" cellspacing="0"><tr><td align="left" class="login_butgre">
		                                 	<a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=publish " class="login_butgre">Publish</a></td></tr></table></td>
	                                 	</c:if>
	                                 	<c:if test="${userInfo.currentCredits < 1}">
		                                	<td align="right" valign="top">
		                                		<table align="center" cellpadding="0" cellspacing="0" >
		                                			<tr>
		                                				<td align="center" class="login_butred" width=150px>
		                                 					<a  href="#" class="login_butred">Publish</a>
		                                 				 <br/>	<font class="red_text">
		                                 					You've no credits left
		                                 				</font>
		                                 					
		                                 				</td>
		                                 			
		                                 			</tr>
		                                 		 
		                                 		</table>
		                                 	</td>
	                                 	</c:if>
	                                </c:if>
	                                <c:if test="${userInfo.billingMethodId != 1}">
	                                	<td align="right" valign="top"><table align="left" cellpadding="0" cellspacing="0"><tr><td align="left" class="login_butgre">
	                                 	<a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=publish " class="login_butgre">Publish</a></td></tr></table></td>
	                                </c:if>
                              </c:if>
                                 <c:if test="${deal.restDealPublishStatus == 1}">
                                  	 <td align="right" valign="top"><table align="left" cellpadding="0" cellspacing="0"><tr><td align="left" class="login_butgre">
                                  	 <a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=unpublish " class="login_butgre">Unpublish</a></td></tr></table></td>
                                  </c:if>
                                <td align="right" valign="top"><table align="left" cellpadding="0" cellspacing="0"><tr><td align="left" class="login_butgre">
                                <a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=update" >Edit</a></td></tr></table></td>
                                <td align="left" valign="top">&nbsp;</td>
                                <td align="center" valign="middle">&nbsp;</td>
                              </tr>
                               <tr>
                                <td colspan="5" align="right" valign="top" height="2"></td>
                                </tr>
                            </table>
                            </c:forEach>        
                  </c:if></td>
                          </tr>
                          
                          <tr>
                            <td align="center" valign="top">&nbsp;</td>
                          </tr>
                        </table>
                      <br/></td>
                  </tr>
                  <tr>
                  

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
          <!-- form End--> 
          </td>
      </tr>
    </table>  
    
</form>

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
