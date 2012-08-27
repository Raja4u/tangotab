<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		<script language="javascript">
	function showLocationsDiv(control) {
	var rid=(control.value).split(';');
	
	 
		// alert(rid);
		
	}
	function setUser()
	{
	if(document.getElementById("personId").value=="0;0")
	{
	document.getElementById("locations_div").innerHTML="Please select profile";
	
	return false
	}
	else 
	 return true;
	}
</script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	</head>
	<body>
		<div id="wrapper">
		 <div id="main">
			<jsp:include page="header.jsp">
				<jsp:param name="currentPage" value="MyAccount" />
			</jsp:include>
			
			<div class="cantainer_inner" style="margin-top:20px;">
<div class="main_cantainer">
<div class="cantainer_content">

<div class="inner_cantainer" style="background:#ffffff;border-left:8px; border-right:8px;border-color: #61b9ca">


			<div class="content" >
				<div class="insight-content" >
				  <div class= "mid_consumer">
				    <table width="100%" border="0" cellspacing="0" cellpadding="0"  style="background-color: ffffff;">
                      <tr>
                        <td align="center" valign="top" scope="row"  bgcolor="#ffffff">
                        <table width="1000" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
                                <html:form  action="/jsp/switchProfile" onsubmit="return setUser();">
                                  <table 	border= "6" cellpadding="0" cellspacing="0" bordercolor="#61b9ca">
                                    <tr>
                                      <td  valign="top"><table width="1000" border="0" align="center"
																	cellpadding="0" cellspacing="6" height="200">
                                          <tr>
                                            <td align="center" height="30" valign="middle"
																			class="gre_low"> We found multiple roles / profiles for the email in the TangoTab website. </td>
                                          </tr>
                                          <tr>
                                            <td align="center" valign="top" class="text_h9">
                                            <table width="600" border="0" align="center"
																				cellpadding="0" cellspacing="6">
                                                <tr>
                                                  <td align="right" valign="middle" class="text_h9b"> Please select profile: </td>
                                                  <td align="left" valign="middle"><c:if test="${not empty profileUsers}">
                                                      <select name="roleId" class="restaurant_select" id="personId"
																								onchange="showLocationsDiv(this)">
                                                        <option value="0;0"> Select </option>
                                                        <c:forEach var="profileUser"
																									items="${profileUsers}">
                                                          <c:if test="${profileUser.roleId == 1}">
                                                            <option value="1;${profileUser.userId}"> Administrator </option>
                                                          </c:if>
                                                          <c:if test="${profileUser.roleId == 2}">
                                                            <option value="2;${profileUser.userId}"> Sales Manager </option>
                                                          </c:if>
                                                          <c:if test="${profileUser.roleId == 3}">
                                                            <option value="3;${profileUser.userId}"> Sales Representative </option>
                                                          </c:if>
                                                          <c:if test="${profileUser.roleId == 4}">
                                                            <option value="4;${profileUser.userId}"> Diner </option>
                                                          </c:if>
                                                          <c:if test="${profileUser.roleId == 5}">
                                                            <option value="5;${profileUser.userId}"> Restaurant </option>
                                                          </c:if>
                                                          <c:if test="${profileUser.roleId == 6}">
                                                            <option value="6;${profileUser.userId}"> Deal Manager </option>
                                                          </c:if>
                                                        </c:forEach>
                                                      </select>
                                                    </c:if>
                                                  </td>
                                                </tr>
                                                <tr>
                                                  <td colspan="2"><div id="locations_div" style="display:inline;" class="red_text">
                                                      <!-- <table>
																								<tr>
																									<td align="right" valign="middle"
																										class="text_h9b">
																										Select restaurant location:
																									</td>
																									<td align="left" valign="middle">
																										<select name="select"
																											class="restaurant_select" id="locationId">
																											
																										</select>
																									</td>

																								</tr>
																							</table> -->
                                                    </div>
                                                  </td>
                                                </tr>
                                                <tr>
                                                  <html:hidden property="dealId" value="${dealId}"></html:hidden>
													<html:hidden property="date" value="${date}"></html:hidden>
													<html:hidden property="bypass" value="${bypass}"></html:hidden>
																				
                                                  <td height="30" align="left" valign="top">&nbsp;</td>
                                                  <td align="left" valign="middle"><table width="75" border="0" align="left"
																							cellpadding="0" cellspacing="0">
                                                      <tr>
                                                        <td align="center" valign="middle"><div id="select_hot">
                                                            <input type="submit" name="Go" class="but_img"   value="Go">
                                                        </div></td>
                                                      </tr>
                                                  </table></td>
                                                </tr>
                                            </table></td>
                                          </tr>
                                      </table></td>
                                    </tr>
                                  </table>
                                </html:form>
                                <!-- form End-->
                            </td>
                          </tr>
                        </table></td>
                      </tr>
                    </table>
				  </div>
					<div class="mid_right">
						<!-- Right control Start-->
						<div align="right">
						</div>
						<!-- Right control End-->
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
			
			<!--content  end here-->
			
			 </div> </div>
			 <div style="clear: both;"></div>
			<%@ include file="footer.jsp"%>
			<div style="clear: both;"></div></div>
			
			 </div>
			 
			</div>
		</div>
	</body>
</html>