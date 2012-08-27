<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="admin_imports.jsp"%>

		<script type="text/javascript">
		function submitSearch(){
	    var locname = document.getElementById("searchname").value;
		document.frm.action = "dealApprove.do?byloc=true";
		document.frm.submit();
}

function submit(id) {
 var locname = document.getElementById("searchname").value;
 if(locname == null || locname.length <1)
   document.frm.action = "dealApprove.do?page="+id;
  else
    document.frm.action = "dealApprove.do?byloc=true&page="+id;

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

												<%@ include file="admin_banner.jsp"%>
											</c:if>
											<c:if test="${userInfo.roleId eq 5}">

												<%@ include file="client_banner.jsp"%>
												<%@ include file="client_menu.jsp"%>
											</c:if>
											<tr>
												<td height="17" colspan="3" align="center" valign="top">
													<form  action="dealApprove.do?byloc=true" name="frm" method="post">
														<!-- form Start-->
														<table width="968" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td background="../images/1.png"></td>
																<td width="729" height="8" background="../images/5.png"></td>
																<td background="../images/2.png"></td>
															</tr>
															<tr>
																<td width="8" background="../images/7.png"></td>
																<td width="952" height="100" align="center" valign="top">
																	<table width="100%" border="0" align="center"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td height="30" align="center" valign="middle"
																				class="red_max">
																				Approved Deals
																			</td>
																		</tr>
																		<tr>
																			<td height="1" align="center" valign="top"
																				bgcolor="#B7D286"></td>
																		</tr>
																		<c:if test="${userInfo.roleId eq 1}">
                     <tr>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="gre_low">Search by Restaurant: </td>
                          <td width="200" align="left" valign="middle">
                          <input type="text" class="restaurant_input" id="searchname" name="searchname" value="${searchname}" /></td>
                          <input type="hidden" name="hsearch" id="hsearch" value="${searchname}"/>
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
																				<table width="98%" border="0" align="center"
																					cellpadding="0" cellspacing="0">
																					<tr>
																						<input type="hidden" name="num" value="${num}" />
																						<td width="350" colspan="2" align="right"
																							valign="middle" class="blue_medium">
																							<c:if
																								test="${userInfo.roleId eq 1 and not empty dealsInfo}">
																								<%@ include file="pagination.jsp"%></c:if>
																						</td>
																					</tr>
																					<!--   <tr>
                        <td width="480" height="26" align="right" valign="middle">&nbsp;</td>
                        <td width="365" align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
                      </tr> -->
																				</table>

																				<table width="98%" border="0" align="center"
																					cellpadding="0" cellspacing="1" bgcolor="#cccccc">
																					<tr>
																						<td align="center" valign="middle" class="text_h3">
																							Name of the Restaurant
																						</td>
																						<td align="center" valign="middle" class="text_h3"">
																							Location
																						</td>
																						<td align="center" valign="middle" class="text_h3">
																							City
																						</td>
																						<td align="center" valign="middle" class="text_h3">
																							Deal Name
																						</td>
																						<td align="center" valign="middle" class="text_h3">
																							Description
																						</td>
																						<td align="center" valign="middle" class="text_h3">
																							Restrictions
																						</td>
																						<td align="center" valign="middle" class="text_h3">
																							&nbsp;&nbsp;&nbsp;&nbsp;
																						</td>
																						<td align="center" valign="middle" class="text_h3">
																							Edit
																						</td>
																					</tr>
																					<c:forEach var="deal" items="${dealsInfo}">
																						<tr>
																							<td align="left" valign="middle"
																								class="table_light">
																								${deal.locationRestName}
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								${deal.locationName}
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								${deal.city}
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								${deal.dealTemplateName}
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								${deal.dealTemplateDescription}
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								${deal.dealTemplateRestrictions}
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								<a
																									href="dealApprove.do?dealId=${deal.dealTemplateId}&&type=approve"
																									class="login_butgre">InActive</a>
																							</td>
																							<td align="left" valign="middle"
																								class="table_light">
																								<a
																									href="admineditDeal.do?dealId=${deal.dealTemplateId}"
																									class="login_butgre">&nbsp;&nbsp;Edit&nbsp;&nbsp;</a>
																							</td>


																						</tr>
																					</c:forEach>

																				</table>
																			</td>
																		</tr>
																		<tr>
																			<td width="480" height="26" align="right"
																				valign="middle" class="blue_medium">
																				<c:if
																					test="${userInfo.roleId eq 1 and not empty dealsInfo}">
																					<%@ include file="pagination.jsp"%></c:if>
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