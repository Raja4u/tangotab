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
			        <!-- form Start-->
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
			                    <td align="center" valign="middle" class="red_max">Deal Summary</td>
			                  </tr>
			                  <tr>
			                    <td align="center" valign="top" class="red_max"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			                      <tr>
			                        <td width="480" align="right" valign="middle">&nbsp;</td>
			                        <td align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
			                      </tr>
			                    </table></td>
			                  </tr>
			                  <tr>
			                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
			                  </tr>
			                  <tr>
			                    <td align="center" valign="top"><br/>
			                        <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
			                          <tr>
			                            <td align="center" valign="top" class="text_h3">Deal Name</td>
			                            <td align="center" valign="top" class="text_h3">Deal Description</td>
			                            <td align="center" valign="top" class="text_h3">Days</td>
			                            <td align="center" valign="top" class="text_h3"> From Date</td>
			                            <td align="center" valign="top" class="text_h3">To Date</td>
			                            <td align="center" valign="top" class="text_h3">Time</td>
			                            <td align="center" valign="top" class="text_h3">QTY Left</td>
			                            <td align="center" valign="top" class="text_h3">Status</td>
			                            <td align="center" valign="top" class="text_h3">Edit</td>
			                          </tr>
			                          <tr>
			                            <td align="left" valign="middle" class="table_light">Lunch Special</td>
			                            <td align="left" valign="middle" class="table_light">1/2 off</td>
			                            <td align="left" valign="middle" class="table_light">Mon, Tue, Wed, Thu, Fri</td>
			                            <td align="left" valign="middle" class="table_light">06/02/2011</td>
			                            <td align="left" valign="middle" class="table_light">08/02/2011</td>
			                            <td align="left" valign="middle" class="table_light">1:30 - 4:00</td>
			                            <td align="left" valign="middle" class="table_light">5</td>
			                            <td align="left" valign="middle" class="table_light"><button class="login_butgre">Publish</button></td>
			                            <td align="left" valign="middle" class="table_light"><button class="login_butgre">Edit</button></td>
			                          </tr>
			                          <tr>
			                            <td align="left" valign="middle" class="table_dark">Dinner Special</td>
			                            <td align="left" valign="middle" class="table_dark">1/2  off</td>
			                            <td align="left" valign="middle" class="table_dark">Mon, Tue, Wed, Thu, Fri</td>
			                            <td align="left" valign="middle" class="table_dark">06/02/2011</td>
			                            <td align="left" valign="middle" class="table_dark">08/02/2011</td>
			                            <td align="left" valign="middle" class="table_dark">4:00 - 7:00</td>
			                            <td align="left" valign="middle" class="table_dark">10</td>
			                            <td align="left" valign="middle" class="table_dark"><button class="login_butgre">Unpublish</button></td>
			                            <td align="left" valign="middle" class="table_dark"><button class="login_butgre">Edit</button></td>
			                          </tr>
			                          <tr>
			                            <td align="left" valign="middle" class="table_light">3.New Horizon</td>
			                            <td align="left" valign="middle" class="table_light">1/2  off</td>
			                            <td align="left" valign="middle" class="table_light">Mon, Tue, Wed, Thu, Fri</td>
			                            <td align="left" valign="middle" class="table_light">06/02/2011</td>
			                            <td align="left" valign="middle" class="table_light">10/02/2011</td>
			                            <td align="left" valign="middle" class="table_light">6:00 - 8:00</td>
			                            <td align="left" valign="middle" class="table_light">12</td>
			                            <td align="left" valign="middle" class="table_light"><button class="login_butgre">Publish</button></td>
			                            <td align="left" valign="middle" class="table_light"><button class="login_butgre">Edit</button></td>
			                          </tr>
			                          <tr>
			                            <td align="left" valign="middle" class="table_dark">4.New Horizon</td>
			                            <td align="left" valign="middle" class="table_dark">1/2  off</td>
			                            <td align="left" valign="middle" class="table_dark">Mon, Tue, Wed, Thu, Fri</td>
			                            <td align="left" valign="middle" class="table_dark">06/02/2011</td>
			                            <td align="left" valign="middle" class="table_dark">15/02/2011</td>
			                            <td align="left" valign="middle" class="table_dark">7:30 - 9:00</td>
			                            <td align="left" valign="middle" class="table_dark">15</td>
			                            <td align="left" valign="middle" class="table_dark"><button class="login_butgre">Publish</button></td>
			                            <td align="left" valign="middle" class="table_dark"><button class="login_butgre">Edit</button></td>
			                          </tr>
			                          <tr>
			                            <td align="left" valign="middle" class="table_light">5.New Horizon</td>
			                            <td align="left" valign="middle" class="table_light">1/2  off</td>
			                            <td align="left" valign="middle" class="table_light">Mon, Tue, Wed, Thu, Fri</td>
			                            <td align="left" valign="middle" class="table_light">06/02/2011</td>
			                            <td align="left" valign="middle" class="table_light">17/02/2011</td>
			                            <td align="left" valign="middle" class="table_light">8:00 - 9:00</td>
			                            <td align="left" valign="middle" class="table_light">20</td>
			                            <td align="left" valign="middle" class="table_light"><button class="login_butgre">Unpublish</button></td>
			                            <td align="left" valign="middle" class="table_light"><button class="login_butgre">Edit</button></td>
			                          </tr>
			                          <tr>
			                            <td align="left" valign="middle" class="table_dark">6.New Horizon</td>
			                            <td align="left" valign="middle" class="table_dark">1/2  off</td>
			                            <td align="left" valign="middle" class="table_dark">Mon, Tue, Wed, Thu, Fri</td>
			                            <td align="left" valign="middle" class="table_dark">06/02/2011</td>
			                            <td align="left" valign="middle" class="table_dark">20/02/2011</td>
			                            <td align="left" valign="middle" class="table_dark">9:00 - 10:00</td>
			                            <td align="left" valign="middle" class="table_dark">25</td>
			                            <td align="left" valign="middle" class="table_dark"><button class="login_butgre">Publish</button></td>
			                            <td align="left" valign="middle" class="table_dark"><button class="login_butgre">Edit</button></td>
			                          </tr>
			                      </table></td>
			                  </tr>
			                  <tr>
			                    <td align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <tr>
			                          <td width="297" height="40" align="right" valign="middle">&nbsp;</td>
			                          <td width="353" align="right" valign="middle"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
			                            <tr>
			                              <td width="100" align="center"><div id="select_hot"><a href="index.jsp">Cancel</a></div></td>
			                            </tr>
			                          </table></td>
			                          <td width="295" align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
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