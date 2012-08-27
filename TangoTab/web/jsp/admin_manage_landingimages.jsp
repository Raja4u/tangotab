<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tangotab.dao.pojo.BillingType"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp"%>
<script type="text/javascript">

	function submitForm(){
		var source=document.forms[0].source.value;
		var url=document.forms[0].url.value;
		if(source.trim()=='')
		{
			document.getElementById('error').innerHTML="Source is Empty";
			return false;
		}
		else if(url.trim()=='')
		{
			document.getElementById('error').innerHTML="URL is Empty";
			return false;
		}
		return true;
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
				<%@ include file="admin_banner.jsp" %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			        <html:form action="/jsp/addLandingImage" method="post" onsubmit="return submitForm()" >
						<!-- form Start-->
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top">
                <table width="935" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">    Landing Images  </td>
                  </tr>
                   
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                       <tr>
                    <td height="10" align="center" valign="top" >&nbsp;&nbsp;</td>
                  </tr>
                  <tr align="center" class="gre_low" align="right" valign="middle">
                  
                    <td>
                    <table>
                  	<tr>
                  	  <td>Source: <html:text property="source" ></html:text>&nbsp;&nbsp;&nbsp;</td>
                  	  <td>URL: <html:text property="url"></html:text>&nbsp;&nbsp;&nbsp;</td>
                  	  <td><div id="select_hot">
						<input id="search" class="login_butgre" type="submit" value="Add New">
						</div></td>
                  	</tr>
                  </table></td>
                  </tr>
                  <tr><td  align="center"><span class="red_text" style="font-size:12px" id="error" ></span></td>  </tr>
                  <logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="2">
															<FONT color="red"><bean:write name="message"
																	filter="false" /></FONT>
														</td>
													</tr>
												</logic:present>
											</html:messages>
										</logic:messagesPresent>
                  <tr>
                    <td align="center" valign="top"><br/>
                        <table width="60%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
                   <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Source</td>
                             
                            <td align="center" valign="middle" class="text_h3">Image URL</td>
                          </tr>	
                          <c:forEach var="landing" items="${landings}">
                          <tr>
                            <td align="left" valign="middle" class="table_dark">${landing.source}</td>
                            <td align="left" valign="middle" class="table_dark">${landing.url}</td>
                          </tr>
                          </c:forEach>
                 
                        </table>
                      <br/></td>
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