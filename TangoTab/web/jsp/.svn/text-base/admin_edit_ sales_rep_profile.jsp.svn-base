<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ page language="java" import="java.util.*;"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>
<script language="javaScript" type="text/javascript" src="../js/calendar.js"></script>
<link href="../css/calendar.css" rel="stylesheet" type="text/css" />
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">		
	       function add(){
				 leftSideCities = document.getElementById("totalCities");
				 rightSideCitiws= document.getElementById("cities");
				 len = leftSideCities.length;
				 for (i = 0; i < len; i++) {
				 	option = leftSideCities.options[i];
					if(option.selected) {
						rightSideCitiws.appendChild(option);
						i--;
						continue;
					} 
				}
       		}
       		function removeCity(){
       			leftSideCities = document.getElementById("totalCities");
				 rightSideCitiws= document.getElementById("cities");
				 len = rightSideCitiws.length;
				 for (i = 0; i < len; i++) {
				 	option = rightSideCitiws.options[i];
					if(option.selected) {
						leftSideCities.appendChild(option);
						i--;
						continue;
					} 
				}
       		}
       		
       		function selectAllCities(){
       			rightSideCitiws= document.getElementById("cities");
				 len = rightSideCitiws.length;
				 rightSideCitiws.multiple=true;
				 for (i = 0; i < len; i++) {
				 	rightSideCitiws.options[i].selected=true;
				 }
				 document.forms[0].action = "salesUpdate.do?type=represent";
				 document.forms[0].submit();
       		}
       		
       		function getManagerCities(){
				manager = dwr.util.getValue("managerId");
				dwr.util.removeAllOptions("cityId");
				dwr.util.addOptions("cityId",["Select City"]);
				deal.getCitiesOfManger(manager,function(data) {
    				dwr.util.addOptions("cityId", data, "cityId", "cityName");
  				}); 
       		}
       		
       		function getCityZipCodes(){
       			cityId =dwr.util.getValue("cityId");
       			dwr.util.removeAllOptions("totalCities");
       			Countries.getZipcodeByCity(cityId,function(data) {
    				dwr.util.addOptions("totalCities", data, "zipCodeId", "zipCodeId");
  				}); 
       		}
       		function cancelToDisplay(){
   			document.forms[0].action = "salesRepDisplay.do";
			document.forms[0].submit();
       	}
</script>

</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		 </jsp:include> 
		<html:hidden property="userId" name="repInfo"/>
		<html:hidden property="salesInfoId" name="repInfo"/>
		<html:hidden property="salasMgrUserId" name="repInfo"/>
		 
	   <div class="content">
			<div class="insight-content"><div class="mid_consumer"><table width="760" border="0" cellspacing="0" cellpadding="0">	
			     <tr>		  
				<%@ include file="admin_banner.jsp" %>
			         <td height="17" colspan="3" align="center" valign="top">
						<!-- form Start-->
						<html:form action="/jsp/salesRepReg">
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top"><table width="938" border="0" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="40" colspan="2" align="center" valign="middle" class="red_max">Sales Rep Update</td>
                    </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">First Name:</td>
                    <td width="38%" align="left" valign="middle"><span class="red_text">
                      <html:text  property="firstname" styleClass="restaurant_input"  name="repInfo"/>
                  	</span></td>
                  </tr>
                  <tr>
                    <td width="22%" align="right" valign="middle" class="bla_low">Last Name:</td>
                    <td width="38%" align="left" valign="middle"><span class="red_text">
                      <html:text  property="lastname"  styleClass="restaurant_input"  name="repInfo"/>
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top" class="bla_low">Home Address:</td>
                    <td align="left" valign="middle"><html:textarea   property="address"  styleClass="restaurant_textarea" name="repInfo"></html:textarea></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Home Phone:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text  property="homePhone"  styleClass="restaurant_input"  name="repInfo"/>
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Mobile Number:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text  property="mobilePhone"  styleClass="restaurant_input"  name="repInfo"/>
                      <html:hidden property="salesManId" value="${repInfo.salesManId}"/>
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low"> Email ID:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text  property="emailId"  styleClass="restaurant_input" name="repInfo"/>
                    </span></td>
                  </tr>
                  <tr>
				  <td align="right" valign="middle" class="bla_low">SalesManager Assigned:</td>
					<td align="left" valign="middle">
					<html:select  property="assignedManager" styleClass="restaurant_select" styleId="managerId" onchange="getManagerCities()" value="${repInfo.assignedManager}">
                      <html:option value="">Select Manager</html:option>
                      <c:if test="${not empty manageList}">
                      	<c:forEach var="manager" items="${manageList}">
                      		<html:option value="${manager.userId}">${manager.firstname}&nbsp;${manager.lastname}</html:option>
                      	</c:forEach>
                      </c:if>
                    </html:select>
                   </td>
				   </tr>
				  <tr>
				  <td align="right" valign="middle" class="bla_low">Select City:</td>
					<td align="left" valign="middle">
						<html:select  property="cityId" styleClass="restaurant_select" styleId="cityId" onchange="getCityZipCodes()">
							<html:option value="${repInfo.cityId}">${repInfo.cityName}</html:option>
	                    </html:select>
                    </td>
				   </tr>	
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Hire Date:</td>
                   <td align="left" valign="middle">
					<html:text property="hireDate"
					tabindex="1" styleClass="textBox" name="repInfo" value="${repInfo.hireDate}"/>
					<a href="#" onclick="setYears(1947, 2080);
                      showCalender(this,'hireDate');">
                       <img src="../images/calender.gif"></a>
                   </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Termination Date:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text   property="terminationDate" styleClass="restaurant_input"  name="repInfo" value="${repInfo.terminationDate}"/>
                      <a href="#" onclick="setYears(1947, 2080);
                            showCalender(this,'terminationDate');">
                     <img src="../images/calender.gif"></a></span>
                     </td>
                  </tr>
                                <tr>
                  		<td colspan="2">
                  			<table width="940" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="400" align="center" valign="top" bgcolor="#CCCCCC"><table width="100%" border="0" cellspacing="1" cellpadding="0">
                          <tr>
                            <td height="30" align="center" valign="middle" bgcolor="#efefef"><span class="text_h3">Zip/Post Codes</span></td>
                          </tr>
                          <tr>
                            <td align="center" valign="top" bgcolor="#EFEFEF"><table width="98%" cellpadding="0" cellspacing="5">
                                <tr>
                                  <td height="155" colspan="6" align="center" valign="top">
                                  <html:select property="totalCities" size="10" multiple="true" styleClass="list_menu" styleId="totalCities">
                                  </html:select>
							</td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>
                        <td width="140" align="center" valign="middle" bgcolor="#F9F9F9"><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td height="45" align="center" valign="middle"><html:button property="" value="Add" onclick="add()"/></td>
                          </tr>
                          <tr>
                            <td height="45" align="center" valign="middle"><html:button property="" value="Remove" onclick="removeCity()"/></td>
                          </tr>
                        </table></td>
                        <td width="400" align="center" valign="top" bgcolor="#CCCCCC"><table width="100%" border="0" cellspacing="1" cellpadding="0">
                          <tr>
                            <td height="30" align="center" valign="middle" bgcolor="#efefef"><span class="text_h3"> Allocated Zip/Post Codes</span></td>
                          </tr>
                          <tr>
                            <td align="center" valign="top" bgcolor="#EFEFEF"><table width="98%" cellpadding="0" cellspacing="5">
                                <tr>
                                  <td height="155" colspan="6" align="center" valign="top" class="list_menu">
                                 		 <html:select property="cities" size="10" multiple="true" styleClass="list_menu" styleId="cities">
                                   			<c:if test="${not empty repInfo.zipCodes}">
	                                   			<c:forEach var="zip" items="${repInfo.zipCodes}" varStatus="count">
	                                   				<html:option value="${zip}">${zip}</html:option>
	                                   			</c:forEach>
                                   			</c:if>
                                  		</html:select>
								  </td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table>
                  		</td>
                  </tr>
                  <tr>
                    <td height="40" colspan="2" align="center" valign="middle" class="text_h9"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><div id="select_hot"><html:button property="" onclick="selectAllCities()">Submit</html:button></div></td>
                          <td><div id="select_hot"><html:reset>Reset</html:reset></div></td>
                          <td><div id="select_hot"><html:button property="" onclick="cancelToDisplay()">Cancel</html:button></div></td>
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
            </table></html:form>
			     <!-- form End-->
							</td>
							</tr>
			      		</table>
				</div>
				</div>
			<div style="clear:both;"></div>
		</div><!--content  end here-->
		<div style="clear:both;"></div>
		<%@ include file="footer.jsp"%>
		<div style="clear:both;"></div>
	</div> 
</body>
</html>
