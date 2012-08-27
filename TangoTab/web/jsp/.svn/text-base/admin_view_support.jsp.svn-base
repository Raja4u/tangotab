<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<%@ include file="admin_imports.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tangotab.dao.pojo.Restaurant" %>
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
        <td height="6" colspan="3" align="left" valign="top"></td>
      </tr>
      <tr>
        <td height="17" colspan="3" align="center" valign="top">
        <!-- form Start-->
        <html:form action="/jsp/viewSupportMgmt" >
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
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Consumer Care Management</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="gre_low">Search by EmailId: </td>
                          <td width="200" align="left" valign="middle">
                          <input type="text" class="restaurant_input" name="searchname" ></input></td>
                          <td align="left" valign="middle">
                          <table width="220" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot">
                              <html:submit property="operation" value="search" styleId="search" styleClass="but_img">Search</html:submit></div></td>
                             
                            </tr>
                          </table></td>
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
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		<br>
																	</td>
																</tr>
															</logic:present>
														</html:messages>
						</logic:messagesPresent>
                          <td width="350" align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><br/>
                    <c:if test="${not empty supportdetails }">
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="22" align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;Email ID</td>
                            <td height="22" align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;Issue Opened Date</td>
                            <td height="22" align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;Role ID</td>
                            <td align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;Subject</td>
                            <td align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;Status</td>
                          </tr>
                          <c:forEach var="support" items="${supportdetails}">
                          <tr>
                            <input type="hidden" value="${support.supportId }" name="supportId" id="supportId"/>
                            <td align="left" valign="middle" class="table_dark"><a href="viewSupportMgmt.do?operation=view&id=${support.supportId }" class="text_h9">${support.emailId }</a></td>
                            <td align="left" valign="middle" class="table_dark">${support.supportDate}</td>
                            <td align="left" valign="middle" class="table_dark">${support.rolename}</td>
                            <td align="left" valign="middle" class="table_dark">${support.subject}</td>
                            <td align="left" valign="middle" class="table_dark">
                            <select name="status" class="restaurant_selectmedium" id="select2">
                            <option value="1" <c:if test="${support.status == 1}" > <%out.print("selected='selected';"); %></c:if>  >Close</option>
                            <option value="0" <c:if test="${support.status == 0}" > <%out.print("selected='selected';"); %></c:if>  >Open</option>
                            </select></td>
                          </tr>
                          </c:forEach>
                      </table>
                      </c:if></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="right" valign="middle"><table width="110" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot">
                              <html:submit property="operation" value="update" styleId="update" styleClass="but_img">Update</html:submit></div></td>
                            </tr>
                          </table></td>
                          <td align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
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




</body>
</html>
