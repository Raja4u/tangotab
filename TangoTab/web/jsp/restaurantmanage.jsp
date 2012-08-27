<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib  uri="/WEB-INF/displaytag.tld"  prefix="display" %>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>
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
        <!-- form Start-->
         
         
            <table width="968" border="0" cellspacing="0" cellpadding="0">
            
              <tr>
                <td background="images/1.png"></td>
                <td width="729" height="8" background="images/5.png"></td>
                <td background="images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="images/7.png"></td>
                <td height="100" align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Restaurant  Management</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="text_formsub">&nbsp;</td>
                          <td width="300" align="right" valign="middle" class="gre_low">Search by userid:</td>
                          <td width="200" align="left" valign="middle"><input type="text" class="restaurant_input"  /></td>
                          <td align="left" valign="middle"><table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><a href="#">Search</a></div></td>
                            </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="100" height="26" align="right" valign="middle" class="text_h8">&nbsp;</td>
                        <td width="476" align="right" valign="middle" class="red_madium"><!-- Restaurant  status update successfully. --></td>
                        <td width="350" align="right" valign="middle" class="blue_medium">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"  class="blue_medium"><br/>
     
                          <%
						   
						     int i=0;
						     String style="";
						     %>
						   
                              <display:table requestURI='restaurantmanage.do' id="restList" name="restList" pagesize="10"  cellpadding="3" cellspacing="3" 
                               style="background-color:#cccccc;width:78%" >
									 <%
                                i++;
                                style="table_light"; 
                                if(i%2==0)
                                style="table_dark";
                                %> 
                                
							  <display:column  headerClass="text_h3"  title="Sl.No"   class="<%=style%>" style="width:5%;">
 									<%=i %>					
                                 </display:column>
                               <display:column   class="<%=style%>" headerClass="text_h3"    style="width:45%;"  title="Business Name" >
                               <a href="restaurantmanage.do?restid=<bean:write name="restList"  property="restaurantId"/>"><bean:write name="restList"  property="businessName"/></a>
                               </display:column>
                               <display:column   class="<%=style%>"  headerClass="text_h3" style="width:15%;" title="No Of Locations" >
                               <div align="right" style="padding-right: 20px;"><a href="restaurantlocations.do?restid=<bean:write name="restList"  property="restaurantId"/>"><bean:write name="restList"  property="noOfLocations"/></a>
                               </div>
                               </display:column>
                                </display:table>
                    <!-- 
                        <table width="30%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="left" valign="middle" class="text_h3">&nbsp;&nbsp;Business Name</td>
                            <td align="left" valign="middle" class="text_h3">&nbsp;&nbsp;&nbsp;Number of Locations</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_light"><a href="restaurantlocations.html" class="bla_low">Hubs</a></td>
                            <td align="left" valign="middle" class="table_light">10</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_dark"><a href="restaurantlocations.html" class="bla_low">Jubilee Redge</a></td>
                            <td align="left" valign="middle" class="table_dark">15</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_light"><a href="restaurantlocations.html" class="bla_low">Logica</a></td>
                            <td align="left" valign="middle" class="table_light">20</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_dark"><a href="restaurantlocations.html" class="bla_low">Redwod</a></td>
                            <td align="left" valign="middle" class="table_dark">25</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_light"><a href="restaurantlocations.html" class="bla_low">Rubbles</a></td>
                            <td align="left" valign="middle" class="table_light">30</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_dark"><a href="restaurantlocations.html" class="bla_low">Pasand</a></td>
                            <td align="left" valign="middle" class="table_dark">40</td>
                          </tr>
                      </table> -->
                      
                      
                      
                      </td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="right" valign="middle">&nbsp;</td>
                          <td align="right" valign="middle" class="blue_medium">&nbsp;</td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
                <td width="8" background="images/8.png"></td>
              </tr>
              <tr>
                <td height="8" background="images/3.png"></td>
                <td height="8" background="images/6.png"></td>
                <td height="8" background="images/4.png"></td>
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