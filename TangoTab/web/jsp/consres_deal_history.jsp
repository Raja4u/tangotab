<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.tangotab.util.DateConverterUtility" %>
<%@ page import ="com.tangotab.TO.ConsumerReservationTO" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>

	  <script type="text/javascript" src="../js/scroll.js"></script>
	  <script type="text/javascript" src="../js/scrollend.js"></script>
      <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
	  <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
      <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
      <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
      <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css" />
      
</head>
<body>
	
	<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  	 
  	 
  	 <!-- start here  -->
		
		
		
			<table width="760" border="0" cellspacing="0" cellpadding="0">			  
				<%@ include file="consumer_banner.jsp" %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			        
	<html:form action="/jsp/searchByDate" method="post">					<!-- form Start-->
					<table width="965" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td background="../images/1.png"></td>
            <td width="949" height="8" background="../images/5.png"></td>
            <td background="../images/2.png"></td>
          </tr>
          <tr>
            <td width="8" background="../images/7.png"></td>
            <td height="100" align="center" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_txt">
              <tr>
                <td height="30" align="center" valign="top" class="red_max"><h1>Reserved Deal History </h1></td>
              </tr>
              <tr>
                <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
              </tr>
              <tr>
                <td align="center" valign="top">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
                  
                </table></td>
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
            
              <tr>
                <td align="center" valign="top">
                <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
                  <tr>
                    <td colspan="2" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table"></td>
                    <td valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="2" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Your Confirmation Number is :</td>
                    <td valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${rid}<span class="blue_medium">&nbsp;</span></td>
                  </tr>
                  <tr>
              <td colspan="2" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Restaurant Name :</td>
              <td width="551" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.locationName}</td>
            </tr>
          
            <tr>
              <td width="197" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td width="197" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Dining Style:</td>
              <td width="551" align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.diningStyleString}</td>
            </tr>
            <tr>

              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Cuisine:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.cuisineTypeString}</td>
            </tr>
            <tr>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Price:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.price}</td>
            </tr>
            <tr>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Website:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.website}</td>
            </tr>
            <tr>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Phone Number:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.cellPhone}</td>
            </tr>
            <tr>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Address:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin"> 
           
              ${reserveddeal.address}	 
              <c:if test="${not empty reserveddeal.address1 }" >
				${reserveddeal.address1} <br/>
				</c:if>
				<c:if test="${not empty reserveddeal.city }" >
				${reserveddeal.city}				</c:if>
				<c:if test="${not empty reserveddeal.state }" >
				${reserveddeal.state} <br/>
				</c:if>
				<c:if test="${not empty reserveddeal.zipcode }" >
				${reserveddeal.zipcode} <br/>
				</c:if>				</td>
            </tr>
            <tr>
              <td height="20" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="20" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Date:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.startDate}</td>
            </tr>
            <tr>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Time:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.availableStartTime} TO ${reserveddeal.availableEndTime}</td>
            </tr>
            <tr>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td height="24" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">Days:</td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">${reserveddeal.day}              </td>
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
							<!-- form End-->
							</td>
			      		</tr>
			    	</table>
				
				
				
				
				
				
			<!-- end here  -->
						
   
   
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
	
	
	
</body>
</html>