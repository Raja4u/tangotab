<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>

<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />




<link rel="stylesheet" type="text/css" href="../css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>

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
      <tr>
        <td colspan="3" align="center" valign="top">
               <%@ include file="client_banner.jsp"%>
			   <%@ include file="client_menu.jsp"%>
       </td>
      </tr>
      <tr>
							<td align="left" valign="top" width="8">
								<img src="../images/rednavleft.png" width="8" height="32" />
							</td>
							<td height="32" align="left" valign="top" width="952"
								background="../images/r_bot-mid.png">
								

							</td>
							<td width="8" align="left" valign="top">
								<img src="../images/rednavright.png" width="8" height="32" />
							</td>
						</tr></table><br/>
        

            <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
<td width="952" height="100" align="center" valign="top">



<table width="940" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="35" align="center" valign="middle" class="red_max">View Deal</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
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
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                       
                          <tr>
                            <td align="center" valign="top" class="table_midbox">
                                         <c:if test="${not empty dealsInfo}">
                 						 <c:forEach var="deal" items="${dealsInfo}" >
                            <table width="945" border="0" align="center" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
                                <tr>
                                  <td align="right" width="85" valign="top"><span class="green">Deal Name:<br/>
                                    Days:<br/>
                                    QTY:<br/>
                                    Start Time:<br/>
                                    End Time:</span><span class="text_h8red"><br/>
                                  </span></td>
                                  <td width="300" align="left" valign="top" class="red">${deal.dealTemplateName} <br/>
                                    <c:if test="${fn:indexOf(deal.availableWeekDays, \"1\") >= 0}">
										<input disabled="disabled" type="checkbox" value="1" checked="checked">SUN</input>
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"2\") >= 0}">
										<input disabled="disabled" type="checkbox"  value="2" checked="checked">MON</input>
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"3\") >= 0}">
										<input disabled="disabled" type="checkbox" value="3" checked="checked">TUE</input>
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"4\") >= 0}">
										<input disabled="disabled" type="checkbox" value="4" checked="checked">WED</input>
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"5\") >= 0}">
										<input disabled="disabled" type="checkbox" value="5" checked="checked">THU</input>
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"6\") >= 0}">
										<input disabled="disabled" type="checkbox" value="6" checked="checked">FRI</input>
									</c:if>
									<c:if test="${fn:indexOf(deal.availableWeekDays, \"7\") >= 0}">
										<input disabled="disabled" type="checkbox"  value="7" checked="checked">SAT</input>
									</c:if>	<br/>
                                    ${deal.availableDealsQty}<br/>
                                    ${deal.availableStartTime}<br/>
                                  ${deal.availableEndTime}</td>
                                  <td align="right" width="150" valign="top"><span class="green">Description:<br/>
                                    Restrictions:<br/>
                                    Recurring:<br/>
                                    Start Date:<br/>
                                    End Date:</span><span class="text_h8red"><br/>
                                    </span></td>
                                  <td align="left" width="350" valign="top" class="red">${deal.dealTemplateDescription}<br/>
                                    ${deal.dealTemplateRestrictions}<br/>
                                    ${deal.isRecurring}<br/>
                                    ${deal.startDate}<br/>
                                    ${deal.dealEndDate}</td>
                                  <td rowspan="2" align="center" valign="middle"><img src="../images/img1.jpg" width="174" height="117" border="0" /></td>
                                </tr>
                                <tr>
                                  
                                  <c:if test="${deal.restDealPublishStatus == 0}">
                                  <td align="right" width="85" valign="top" class="login_butgre"><a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=publish " >Publish</a></td>
                                  </c:if>
                                  <c:if test="${deal.restDealPublishStatus == 1}">
                                  	<td width="150" align="left" valign="top" class="login_butgre"><a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=unpublish " >Un Publish</a></td>
                                  </c:if>
                                  
                                  <td align="center" valign="top" ><table align="left" cellpading="0" cellspacing="0"><tr><td align="center" class="login_butgre"><a href="editDeal.do?dealId=${deal.dealTemplateId}&&type=update" >Edit</a></td></tr></table></td>
                                  <td align="center" valign="top"  class="text_h8b"></td>
                                  <td align="center" valign="top" class="text_h9"></td>
                                </tr>
                            </table>
          		</c:forEach>        
                  </c:if>
                            
                            </td>
                          </tr>
                                </table>
                           </td>
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
