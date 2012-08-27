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

function submit(id){
var search = document.getElementById("hsearch").value;
if(search.length > 0)
 document.adminclientForm.action = "viewClientMgmt.do?operation=search&page="+id;
else
 document.adminclientForm.action = "viewClientMgmt.do?operation=display&page="+id;
document.adminclientForm.submit();
}

function onUpdate(){
document.getElementById('operation').value ="Update";
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
  
                   <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	
  	                   <div class="content_deal_inner">	
   <!--	start login -->
    <table width="968" border="0" cellspacing="0" cellpadding="0">
      <%@ include file="admin_banner.jsp" %>     
       <tr>
        <td height="17" colspan="3" align="center" valign="top">
        <html:form action="/jsp/viewClientMgmt" method="post">
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
                    <td height="30" align="center" valign="middle" class="red_max">Host Management</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="text_formsub">&nbsp;</td>
                          <td width="300" align="right" valign="middle" class="gre_low">Search by business name:</td>
                          <td width="200" align="left" valign="middle"><input type="text" name="searchname" class="restaurant_input" value="${searchname}" /></td>
                          <td align="left" valign="middle">
                          <table width="220" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot">
                              <input type="hidden" id="operation" name="operation" value="search"  />
                              <html:submit property="operation" value="search" styleId="search" styleClass="login_butgre">Search</html:submit></div></td>
                              <td><div id="select_hot"><a href="admin_client_registration.jsp">New</a></div></td>
                            </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
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
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		<br>
																	</td>
																</tr>
															</logic:present>
														</html:messages>
						</logic:messagesPresent></td>
						<input type="hidden" id="hsearch" name="hsearch" value="${searchname}"/>
					    <input type="hidden" name="num" value="${num}"/>
                        <td width="350"  colspan="2" align="right" valign="middle" class="blue_medium">
                        <c:if test="${not empty clientdetails}">
                        <%@ include file="pagination.jsp" %></c:if>
                       </td>
                      </tr>
                    </table></td>
                  </tr>
                 
                  <tr>                 
                    <td align="center" valign="top"><br/>
                    <c:if test="${not empty clientdetails}">
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="left" valign="middle" class="text_h3">
                              <a href="javascript:submit(0);"  class="bla_low"><b>Business Name</b></a>
                            <input type="hidden" name="name" value="${sort.name }"/>
                                <input type="hidden" name="date" value="${sort.date }"/></td>
                            <td align="left" valign="middle" class="text_h3">User Name</td>
                            <td align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;
                            <a href="javascript:submit(-1);" class="bla_low"><b>Registered Date</b></a></td>
                            <td align="left" valign="middle" class="text_h3">Status</td>
                          </tr>
                           <c:forEach var="client" items="${clientdetails}" >
                          <tr>
                            <input type="hidden" name="restId" value="${client.restaurantId }" />
                            <input type="hidden" name="flag" id="${client.restaurantId},${client.restaurantId }" value="0"/>
                            <td align="left" valign="middle" class="table_light">
                            <a href="viewClientMgmt.do?operation=edit&id=${client.restaurantId }" class="bla_low"><u>${client.businessName }</u></a></td>
                            <td align="left" valign="middle" class="table_light">${client.user.firstname }</td>
                            <td align="left" valign="middle" class="table_dark">${client.user.zipCode}</td>
                            <td align="left" valign="middle" class="table_light">
                           <select name="isActive" class="restaurant_selectmedium" id="${client.restaurantId }" onchange="setflag(this.id)">
                           <option value="1" <c:if test="${client.isActivated == 1}" > <%out.print("selected='selected';"); %></c:if>  >Active</option>
                           <option value="0" <c:if test="${client.isActivated == 0}" > <%out.print("selected='selected';"); %></c:if>  >Suspended</option>
                           
                           </select>
                            </td></tr> </c:forEach>
                        </table></c:if>
                        </td>
                  </tr>
                  <tr>
                   <input type="hidden" name="page" value="${currentPage}"/>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="right" valign="middle">
                          <table width="110" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><html:submit property="operation" value="Update" styleId="Update" styleClass="login_butgre" onclick="onUpdate();">Update</html:submit></div></td>
                            </tr>
                          </table></td>
                        <td width="350" align="right" valign="middle" class="blue_medium">
                        <c:if test="${not empty clientdetails}">
                        <%@ include file="pagination.jsp" %></c:if>
                       </td>
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
           <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>
</div>
</div>



</body>
</html>
