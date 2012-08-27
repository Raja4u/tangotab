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
<%@ include file="admin_imports.jsp"%>
<script type="text/javascript">
function setflag(idd){

var name = idd+","+idd;

if(document.getElementById(name).value == "0")
   document.getElementById(name).value = idd;
else
   document.getElementById(name).value = "0";
 
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
      <%@ include file="admin_banner.jsp" %>     
       <tr>
        <td height="17" colspan="3" align="center" valign="top">
        <html:form action="/jsp/updatelocationStatus.do?operation=updateStatus&restid=${restid}" method="post">
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
                    <td height="30" align="center" valign="middle" class="red_max">Location Management</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                         <html:hidden property="businessName" value="${businessName}" /> 
                          <td align="right" valign="middle" class="text_formsub">&nbsp;</td>
                          <!--<td width="300" align="right" valign="middle" class="gre_low">Search by Location name:</td>
                          <td width="200" align="left" valign="middle"><input type="text" class="restaurant_input"  /></td>
                          --><td align="right" valign="middle">
                          <table width="420" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                           
                              <!--<td width="110"><div id="select_hot"><a href="#">Search</a></div></td>
                              
                              --><c:if test="${add eq 'yes'}">
                              <td width="300" align="right" valign="middle" class="gre_low">Add a new location here </td>
                              <td width="110"><div id="select_hot">
                              
                              <a href="newlocation.do?operation=insert&restid=${restid}&businessName=${businessName}">New</a>
                               </div></td> </c:if>
                             
                            </tr>
                          </table></td>
                          
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                         <c:if test="${not empty size}">
                        <td width="100" height="26" align="right" valign="middle" class="text_h8">&nbsp;</td>
                        <td width="476" align="right" valign="middle" class="red_madium">Total ${size} results </td>
                        </c:if>
                        <td width="350" align="right" valign="middle" class="blue_medium">&nbsp;</td>
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
                    <c:if test="${not empty restList}">
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="left" valign="middle" class="text_h3">Location Name</td>
                            <td align="left" valign="middle" class="text_h3">City</td>
                             <td align="left" valign="middle" class="text_h3">ZipCode</td>
                            <td align="left" valign="middle" class="text_h3">Status</td>
                          </tr>
                           <c:forEach var="location" items="${restList}" >
                           <tr>
                            <html:hidden  property="restLocationId" value="${location.restLocationId}" />
                            <input type="hidden" name="flag" id="${location.restLocationId},${location.restLocationId}" value="0"/>
                            <td align="left" valign="middle" class="table_light">
                            
                            <a href="admineditLocations.do?operation=editLocation&restLocationId=${location.restLocationId}&businessName=${location.restaurant.businessName}&restid=${restid}" class="bla_low"><u>${location.locationRestName}</u></a></td>
                            <td align="left" valign="middle" class="table_light">
                            <a href="#" class="bla_low">${location.city.cityName}</a></td>
                            <td align="left" valign="middle" class="table_light">
                            <a href="#" class="bla_low">${location.zipCode}</a></td>
                            <td align="left" valign="middle" class="table_light"> 
                            <html:hidden name="businessName" property="businessName" value="${location.restaurant.businessName}" />
                           <select name="isActive" class="restaurant_selectmedium" id="${location.restLocationId}" onchange="setflag(this.id)">
                           <option value="1" <c:if test="${location.isActive == 1}" > <%out.print("selected='selected';"); %></c:if>  >Active</option>
                           <option value="0" <c:if test="${location.isActive == 0}" > <%out.print("selected='selected';"); %></c:if>  >Suspended</option>
                           
                           </select>
                            </td></tr> </c:forEach>
                        </table></c:if>
                        </td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="right" valign="middle"><table width="110" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><html:submit styleClass="login_butgre">Update</html:submit></div></td>
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
            </table></html:form>
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
</body>
</html>