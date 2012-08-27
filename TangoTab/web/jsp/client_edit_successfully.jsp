<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
						<td height="17" colspan="3" align="center" valign="top">
			     
			        <table width="965" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td width="8" background="../images/1.png"></td>
			            <td width="949" height="8" background="../images/5.png"></td>
			            <td width="8" background="../images/2.png"></td>
			          </tr>
			          <tr>
			            <td width="8" background="../images/7.png"></td>
			            
			            <td height="100" align="center" valign="top">
			                <table width="100%" border="0" cellspacing="0" cellpadding="0">
			                  <tr>
			                    <td height="75" align="center" valign="top"><span class="red_max"><strong>Successfully Updated<br></strong></span></td>
			                  </tr>
			                  <tr>
			                    <td align="center" valign="top">&nbsp;</td>
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
			          <!-- form Start-->          <!-- form End-->        </td>
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