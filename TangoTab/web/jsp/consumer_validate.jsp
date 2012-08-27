<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
					String code = "";
					String vtype="";
						if (request.getParameter("code") != null) {
							code = request.getParameter("code");
						}	
						String roleId="0";
						if (request.getParameter("roleId") != null) {
							roleId = request.getParameter("roleId");
						}	
						if (request.getParameter("vtype") != null) {
							vtype = request.getParameter("vtype");
						}
						

						String emailId = "";
						if (request.getParameter("emailId") != null) {
							emailId = request.getParameter("emailId");
						}

						String msg = "";
						if (request.getAttribute("msg") != null) {
							msg = (String) request.getAttribute("msg");
						}

						if (request.getAttribute("code") != null) {
							code = (String) request.getAttribute("code");
						}
						if (request.getAttribute("emailId") != null) {
							emailId = (String) request.getAttribute("emailId");
						}
						if (request.getAttribute("vtype") != null) {
							vtype = (String) request.getAttribute("vtype");
						}
						String bannerName="User";
						if(vtype.equals("cl"))
						{
						bannerName="Host";
						roleId="5";
						}
						else if(vtype.equals("co"))
						{
						bannerName="Guest";
						roleId="4";
						}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		<script type="text/javascript">
			function submitAction(){
				document.forms[0].action = "userReg.do?type=consumer";
				document.forms[0].submit();
			}
		</script>
<link rel="stylesheet" type="text/css" href="tangotab.css"/>
	</head>
	<body onLoad="getCountryDetails()"> 
	
	<!--Header Start-->

<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" />
  <img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">	
		
		
		<!--Header End here-->
		
		
		
			<div class="content">
				
						<table width="760" border="0" cellspacing="0" cellpadding="0"  >
							<tr>
	<td colspan="3" align="center" valign="top">
	&nbsp;
	</td>
</tr>   
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<html:form action="jsp/verify.do?type=consumer" method="post">
									<table width="965" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td background="../images/1.png"></td>
            <td width="949" height="8" background="../images/5.png"></td>
            <td background="../images/2.png"></td>
          </tr>
            <tr>
            <td width="8" background="../images/7.png"></td>
            <td height="100" align="center" valign="top"><table width="740" border="0" align="center" cellpadding="0" cellspacing="5">
              <tr>
                <td height="30" colspan="3" align="center" valign="middle" class="red_max">Please enter your password to validate your registration.
														</td>
              </tr>
												 
												
												<tr>
													<td colspan="3" width="38%" align="center" valign="middle">
														<html:hidden property="code" styleClass="restaurant_input"
															value="<%=code%>"></html:hidden>
														<html:hidden property="emailId"
															styleClass="restaurant_input" value="<%=emailId%>"></html:hidden>
										 <html:hidden property="vtype" styleClass="restaurant_input" value="<%=vtype%>" /> 
														<html:password property="password"
															styleClass="restaurant_input" value=""></html:password>
															<html:hidden property="roleId"
															styleClass="restaurant_input" value="<%=roleId%>"></html:hidden>
															</td>
												</tr>
												<tr>
												<td align="center" valign="middle" colspan="3">
																			<FONT color="red"> <%=msg%> </FONT>
																		</td>
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
														<!-- <input type="hidden" class="restaurant_input"
															value="" name="code" />
														<input type="hidden" class="restaurant_input"
															value="" name="emailId" />
														<input type="password" class="restaurant_input" value=""
															name="userPassword" /> -->
												
											 
												 <tr>
                <td height="35" colspan="3" align="center" valign="middle"><table width="105" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="center" valign="middle"><div id="select_hot"><html:submit styleClass="but_img">Validate</html:submit></div>                      </td></tr>
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
									
									<!-- form End-->
								</td>
							</tr>
						</table>
				</div>
  <div style="clear:both;"></div>
</div><!--content  end here--><!--footer start here-->
  </div>


</div>

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





</body>
</html>