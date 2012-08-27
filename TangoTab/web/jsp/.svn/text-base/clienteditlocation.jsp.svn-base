<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>

<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
<%@ include file="consumer_imports.jsp"%>
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
      <tr>
        <td colspan="3" align="center" valign="top">
               <%@ include file="client_banner.jsp"%>
			   <%@ include file="client_menu.jsp"%>
       </td>
      </tr>
      
      <tr>
        <td height="6" colspan="3" align="left" valign="top"></td>
      </tr>
      <tr>
        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
            <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Locations</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="100" height="26" align="right" valign="middle" class="text_h8">&nbsp;</td>
                          <td width="380" align="left" valign="middle">&nbsp;</td>
                          <td align="right" valign="middle" class="blue_medium"></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><br/>
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <c:if test="${not empty locationsInfo}">
                          <tr>
                            <td width="29%" height="24" align="left" valign="middle" class="text_form">&nbsp;&nbsp;<span class="text_h3">Locations</span></td>
                            <td width="71%" align="left" valign="middle" class="text_form">&nbsp;&nbsp;<span class="text_h3">Address</span></td>
                          </tr>
                          </c:if>
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
                          <c:if test="${not empty locationsInfo}">
                          
                          		<c:forEach var="location" items="${locationsInfo}" varStatus="count">
                          			<tr>
	                          			<c:if test="${count.index % 2 ne 0}">
	                          				<td align="left" valign="middle" class="table_light"><span class="text_h8"><a href="editLocation.do?locationId=${location.restLocationId}" class="text_h8">${location.locationRestName}:</a></span></td>
                       					    <td align="left" valign="middle" class="table_light">${location.address}</td>
	                          			</c:if>
	                          			<c:if test="${count.index % 2 eq 0}">
	                          				 <td align="left" valign="middle" class="table_dark"><span class="text_h8"><a href="editLocation.do?locationId=${location.restLocationId}" class="text_h8">${location.locationRestName}:</a></span></td>
                            				<td align="left" valign="middle" class="table_dark">${location.address}</td>
	                          			</c:if>
                          			</tr>
                          		</c:forEach>
                          
                          </c:if>
                      </table></td>
                  </tr>
                  
                    <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                       <tr>
                             <td width="490" align="center">&nbsp;     </td></tr>
                        <tr> <td  width="490"  align="center">
         <c:if test="${userInfo.noOfLocations gt userInfo.noOfEnteredLocatios}">
            <div id="select_hot">  <a href="createLocation.do">Add Locations</a></div>
         </c:if>
                <c:if test="${userInfo.noOfLocations  eq userInfo.noOfEnteredLocatios}">
     <div class="red_text" style="align:right"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; To add a location, please contact Your Account Executive or Account Manager.</div>
         </c:if>
        
     </td><td width="490" align="center">&nbsp; </td>         
              </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="left" valign="middle">&nbsp;</td>
                          <td align="right" valign="middle" class="blue_medium"></td>
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
