<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
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
							
			    <table width="968" border="0" cellspacing="0" cellpadding="0">
			      <%@ include file="client_banner.jsp" %>
			      <%@ include file="client_menu.jsp" %>
			      <tr>
			        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
			            <table width="968" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <td background="../images/1.png"></td>
			                <td width="952" height="8" background="../images/5.png"></td>
			                <td background="../images/2.png"></td>
			              </tr>
			              <tr>
			                <td width="8" background="../images/7.png"></td>
			                <td height="100" align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="5">
			                  <tr>
			                    <td height="30" colspan="2" align="center" valign="middle" class="red_max">Reset password</td>
			                    </tr>
			                  <tr>
			                    <td width="22%" align="right" valign="middle" class="bla_low">Password:</td>
			                    <td width="38%" align="left" valign="middle"><html:password property="password" value="password" styleClass="restaurant_input"></html:password></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">New Password:</td>
			                    <td align="left" valign="middle"><html:password property="newPassword" value="newpassword" styleClass="restaurant_input"></html:password></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Retype New Password</span>:</td>
			                    <td align="left" valign="middle"><html:password property="confirmPassword" value="newpassword" styleClass="restaurant_input"></html:password></td>
			                  </tr>
			                  <tr>
			                    <td height="55" colspan="2" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
			                  <tr>
			                    <td><div id="select_hot"><a href="reset_password_successfully.jsp">Submit</a></div></td>
			                    <td><div id="select_hot"><a href="client_reset_password.jsp">Reset</a></div></td>
			                    <td><div id="select_hot"><a href="client_edit_profile.jsp">Cancel</a></div></td>
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