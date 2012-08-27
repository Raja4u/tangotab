<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.tangotab.dao.pojo.CuisineType"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
    <%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  page import="com.tangotab.TO.UserTO,java.util.*,com.tangotab.TO.DropDownTO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp" %>
<script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
		<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
		<script src="../js/Country_state.js" type="text/javascript"></script>
			<script src="../js/util.js" type="text/javascript"></script>
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
		  <%@ include file="admin_banner.jsp" %>
		  <tr>
		  	<td height="17" colspan="3" align="center" valign="top">
		  	<form >
				<!-- form Start-->
				<table width="760" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td background="../images/1.png"></td>
			            <td width="729" height="8" background="../images/5.png"></td>
			            <td background="../images/2.png"></td>
			          </tr>
			          <tr>
			            <td width="8" background="../images/7.png"></td>
			            <td height="100" align="center" valign="top">
			            <table width="740" border="0" align="center" cellpadding="0" cellspacing="5">
			              <tr>
			                <td height="12" colspan="2" align="center" valign="middle" class="red_max">Complete Details of Issue</td>
			              </tr>
			              <tr>
			                <td height="10" colspan="2" align="center" valign="top" class="td_bg"></td>
			              </tr>
			              
			 			<tr>
			                <td align="right" valign="middle"><span class="bla_low">Email<span class="red_text">*</span></span>:</td>
			                <td align="left" valign="middle"><span class="bla_low">${support.emailId} </span>
			                    <span  class="red_text" id="email">  </span>
			                <html:hidden property="supportId" value="${support.supportId }"></html:hidden>
			                </td>
			               
			              </tr>
			              
			              <tr>
			                <td align="right" valign="middle"><span class="bla_low">Opened Date<span class="red_text">*</span></span>:</td>
			                <td align="left" valign="middle"><span class="bla_low">${support.supportDate}</span> 
			                    
			                </td>
			               
			              </tr>
							
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Role:</td>
			                <td align="left" valign="middle"><span class="bla_low">${support.rolename}</span>
			              <span  class="red_text" id="amphone">   </span></td>
			              </tr>
			              
			                  <tr>
			                <td align="right" valign="middle" class="bla_low">Subject:</td>
			                <td align="left" valign="middle"><span class="bla_low">${support.subject}</span>
			                <span  class="red_text" id="ahphone">     </span></td>
			              </tr>
			              
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Description:</td>
			                <td align="left" valign="middle"><span class="bla_low">${support.description}</span>
			                   <span  class="red_text" id="amsg">  </span></td>
			              </tr>
			              
			              <tr>
			              <td align="right" valign="middle" class="bla_low">Status:</td>
			                <c:if test="${support.status == 0 }">
			                <td align="left" valign="middle" class="bla_low"> Open  </td></c:if>
                            <c:if test="${support.status == 1 }">
                            <td align="left" valign="middle" class="bla_low"> Close </td></c:if>
			              </tr>
			              
			              
			            
			              <tr>
			                <td height="45" colspan="2" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
			                  <tr>
			                    <td> <div id="select_hot"><a href="admin_view_support.jsp">Back</a></div></td>
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