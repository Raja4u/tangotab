<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
 <%@ taglib  uri="/WEB-INF/displaytag.tld"  prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp"%>
<script type="text/javascript">
	
	function submitForm(){
		var locationId = document.getElementById("restLocationId").value;
		document.frm.action = "dealPending.do?locationId="+locationId;
		document.frm.submit();
	}
/*	function searchVisible(){
	   alert("fd");
	   var s = document.getElementById("searchname").value;
	   //if(s!=null && s.length() > 0)
	   // document.getElementById("search").enabled="true";
	}*/
	
function submitSearch(){
	    var locname = document.getElementById("searchname").value;
		document.frm.action = "dealPending.do?byloc=true";
		document.frm.submit();
}
	
function submit(id){
 var locname = document.getElementById("searchname").value;
 if(locname == null || locname.length <1)
   document.frm.action = "dealPending.do?page="+id;
  else
    document.frm.action = "dealPending.do?byloc=true&page="+id;
document.frm.submit();
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
				<c:if test="${userInfo.roleId eq 1}">	
				 		  
				<%@ include file="admin_banner.jsp" %>
				</c:if>
				<c:if test="${(userInfo.roleId eq 5) or (userInfo.roleId eq 6) }">	
				 		  
				<%@ include file="client_banner.jsp" %>
					<%@ include file="client_menu.jsp" %>
				</c:if>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			 <form action="dealPending.do?byloc=true" name="frm" method="post">
						<!-- form Start-->
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                  <c:if test="${userInfo.roleId eq 1}">
                    <td height="30" align="center" valign="middle" class="red_max">Pending Deals</td></c:if>
                  <c:if test="${(userInfo.roleId eq 5) or (userInfo.roleId eq 6)}">
                    <td height="30" align="center" valign="middle" class="red_max">All Deals</td></c:if>   
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td></tr>
                     <c:if test="${userInfo.roleId eq 1}">
                     <tr>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="gre_low">Search by Restaurant: </td>
                          <td width="200" align="left" valign="middle">
                          <input type="text" class="restaurant_input" id="searchname" name="searchname" value="${searchname}" /></td>
                          <input type="hidden" name="hsearch" id="hsearch" value="${searchname}"/>
                          <input type="hidden" name="searchflag" id="searchflag" value="false"/>
                          <td align="left" valign="middle">
                          <table width="220" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot">
                              <input type="submit" name="search" id="search"  class="login_butgre" onclick="submitSearch();" value="Search"/></div></td>
                              
                            </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  </c:if>
                  <tr>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="100" colspan="2" height="26" align="center" valign="middle" class="text_h8">&nbsp;
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
										</logic:messagesPresent></td>
						<input type="hidden" name="num" value="${num}"/>
                        <td width="350"  colspan="2" align="right" valign="middle" class="blue_medium">
                        <c:if test="${userInfo.roleId eq 1 and not empty dealsInfo}">
                        <%@ include file="pagination.jsp" %></c:if>
                       </td>
                      </tr>
                    </table></td>
                  </tr>
                    	
                    <c:if test="${(userInfo.roleId eq 5 or userInfo.roleId eq 6)  and locationsInfoSize gt 1 }">	
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
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                  
                  
                  
                      <tr>
                        <td width="480" height="26" align="right" valign="middle">&nbsp;</td>
                  <!--       <td width="365" align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
                    -->   </tr>
                    </table>
                    <c:if test="${not empty dealsInfo}">
                              	 <c:forEach var="deal" items="${dealsInfo}">
                              	 
                        <table width="950" border="0" align="center" cellpadding="0" cellspacing="5">
                              <tr>
                               
                        
                             <td width="130" align="right" valign="top"><span class="green">Restaurant Name:</span></td>
                              <td width="250" align="left" valign="top"><span class="red">${deal.locationRestName}</span></td>
                              <td width="130" align="right" valign="top"><span class="green">location:</span></td>
                               <td width="250" align="left" valign="top"><span class="red">${deal.locationName}</span></td>
                               </tr>
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
									<td width="130" align="right" valign="top"><span class="green">Restrictions:</span></td>
                                 <td width="250" align="left" valign="top"><span class="red">${deal.dealTemplateRestrictions}</span></td>
                                </tr>
                                
                                <tr>
                                <td align="right" valign="top"><span class="green">QTY:</span></td>
                                <td align="left" valign="top">${deal.availableDealsQty}</td>
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
                                <td align="left" valign="top"> ${deal.availableStartTime}</td>
                                <td align="right" valign="top"><span class="green">Start Date:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.startDate}</span></td>
                              </tr>
                              <tr>
                                <td align="right" valign="top"><span class="green">End Time:</span></td>
                                <td align="left" valign="top">${deal.availableEndTime}</td>
                                <td align="right" valign="top"><span class="green">End Date:</span></td>
                                <td align="left" valign="top"><span class="red">${deal.dealEndDate}</span></td>
                              </tr>
                                <tr>
                                 
                                  <!--<td width="130" align="right" valign="top"><span class="green">status:</span></td>
                                  
                                  <c:if test="${deal.isActive eq 1 }">
                             <c:if test="${deal.restDealPublishStatus eq 1 }">
                                  <td align="left" valign="middle" class="table_light">Published</td></c:if>
                             <c:if test="${deal.restDealPublishStatus eq 0 }">
                                  <td align="left" valign="middle" class="table_light">UnPublished</td></c:if> 
                            </c:if>    
                            -->
                            <c:if test="${deal.isActive eq 0 }">
                            <c:if test="${userInfo.roleId eq 1}">	
						<td align="right" valign="top"><table align="left" cellpadding="0" cellspacing="0"><tr><td align="left" class="login_butgre">
                            <a href="dealPending.do?dealId=${deal.dealTemplateId}&&type=approve"  class="login_butgre">&nbsp;&nbsp;Active&nbsp;&nbsp;</a>
                                           </td>  </tr></table></td> 
                          <td align="right" valign="top"><table align="left" cellpadding="0" cellspacing="0"><tr><td align="left" class="login_butgre">
                                 <a href="admineditDeal.do?dealId=${deal.dealTemplateId}"  class="login_butgre">&nbsp;&nbsp;Edit&nbsp;&nbsp;</a>
                          </td></tr></table></td>  </c:if> </c:if>
                          
                          </tr>
                          </table>
                          </c:forEach>
                           </c:if>    
                               </td>   
                                </tr>
             <tr>       
             <td width="480" height="26" align="right" valign="middle"  class="blue_medium">
             <c:if test="${userInfo.roleId eq 1 and not empty dealsInfo}">
                        <%@ include file="pagination.jsp" %></c:if></td>
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
</body>
</html>