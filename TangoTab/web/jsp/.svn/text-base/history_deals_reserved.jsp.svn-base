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
      
<script language="javascript" type="text/javascript">
function setflag(idd){
/* set the flag value to id if that particular record is changed or not */
var name = idd+","+idd;

if(document.getElementById(name).value == "0")
   document.getElementById(name).value = idd;
else
   document.getElementById(name).value = "0";
   
}

	function change_date_format(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("from_date_h").value = date_out_put;
	}
    
    function change_date_format2(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("to_date_h").value = date_out_put;
		
	}

</script>

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
		
				
			<table width="760" border="0" cellspacing="0" cellpadding="0" class="form_txt">			  
				<%@ include file="consumer_banner.jsp" %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			        
	<html:form action="/jsp/historyofDeals" method="post">					<!-- form Start-->
					<table width="950" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td background="../images/1.png"></td>
            <td width="949" height="8" background="../images/5.png"></td>
            <td background="../images/2.png"></td>
          </tr>
          <tr>
            <td width="8" background="../images/7.png"></td>
            <td height="100" align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="30" align="center" valign="top" class="red_max"></td>
              </tr>
              <tr>
                <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
              </tr>
              <tr>
                <td align="center" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="40" align="right" valign="middle" class="text_formsub">
<p>Start Date:</p></td>
                    <td width="190" align="left" valign="middle">
                     <html:text styleClass="restaurant_input" property="startDate" styleId="startDate" onchange="change_date_format(this.value);" > </html:text>
                     <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" /></td>
                        
                    <td width="80" align="right" valign="middle" class="gre_low"><p>End Date:</p></td>
                    <td width="195" align="left" valign="middle">
                     <html:text styleClass="restaurant_input" property="endDate" styleId="endDate" onchange="change_date_format2(this.value);" > </html:text>
                     <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" /></td>
                     
                    <td align="left" valign="middle"><table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><div id="select_hot">
                          <html:submit styleClass="but_img" property="operation" value="Search" styleId="submitID">Search</html:submit></div></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td align="center" valign="top"><table width="98%" border="0" cellspacing="0" cellpadding="0">
                  <tr> 
                  <c:if test="${not empty size}">
                          <td align="left" valign="middle"><h1>Total ${size} results </h1></td> 
                  </c:if>
                    <td width="57%" height="30" align="right" valign="middle"><span class="blue_medium">&nbsp;<!--  prev 1 2 3 4 5 6 7 8 9 next--></span></td>
                  </tr>
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
               
               
                <table width="98%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#cccccc">
                 <c:if test="${not empty reserved}">
                  <tr>
                    <td valign="top"><h3>Name of Restaurant</h3></td>
                    <td  valign="top" class="text_h3"><h3>Offer</h3></td>
                    <td  valign="top" class="text_h3"><h3>Date/Time</h3></td>
                    <td valign="top" class="text_h3"><h3>Confirmation No</h3></td>
                    <td valign="top" class="text_h3"><h3>Status</h3></td>
                  </tr>
                  <c:forEach var="conres" items="${reserved}" >
                  <tr>
                    <td align="left" valign="middle" class="table_dark">${conres.businessName}</td>
                    <td align="left" valign="middle" class="table_dark">${conres.restaurantDeal.dealTemplateName}</td>
                    <td align="left" valign="middle" class="table_dark">${conres.reservedTimestamp}</td>
                    <td align="left" valign="middle" class="table_dark"><a href="historyofDeals.do?operation=getReservationDetails&rid=${conres.conResId}&did=${conres.restaurantDeal.dealTemplateId}" style="text-decoration:none">${conres.conResId}</a></td>
                       <input type="hidden" name="flag" id="${conres.conResId },${conres.conResId }" value="0"/>
                       <input type="hidden" name="conresId" value="${conres.conResId }" />
                    <c:if test="${ not conres.expired}">
                    <td align="left" valign="middle" class="table_dark">
                    <select  name="status" id="${conres.conResId }" onchange="setflag(this.id)"  >
                    <c:if test="${conres.isConsumerShownUp != -1}" ><option  value="claim" <c:if test="${conres.isConsumerShownUp != -1}" > <%out.print("selected='selected';"); %></c:if> >Claimed </option></c:if>
                    <option  value="cancel" <c:if test="${conres.isConsumerShownUp == -1}" > <%out.print("selected='selected';"); %></c:if> >Cancelled </option>
                     </select> </td> 
                     </c:if>
                     <c:if test="${  conres.expired}">
                     <td align="left" valign="middle" class="table_dark">
                    <select  name="status" id="${conres.conResId }" onchange="setflag(this.id)" >
                    <c:if test="${conres.isConsumerShownUp != -1}" ><option  value="expired"  selected='selected' >Claimed </option></c:if>
                    <c:if test="${conres.isConsumerShownUp == -1}" ><option  value="cancelled" selected='selected' >Cancelled </option></c:if>
                     </select> </td> 
                     </c:if>   
                  </tr>
                  </c:forEach>
                   </c:if>
                   <tr>
                    <td valign="top" colspan="5" align="center"><html:submit styleClass="but_img"  property="operation" value="Update" >Update</html:submit></td></tr>
                </table>
               
                              
                
                  <br/></td>
              </tr>
              <tr>
                <td align="center" valign="top"><table width="98%" border="0" cellspacing="4" cellpadding="0">
                  <tr>
                    <td align="right" valign="middle">&nbsp;</td>
                    <td width="57%" height="30" align="right" valign="middle"><span class="blue_medium">&nbsp;</span></td>
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

<div style="clear:both;"></div>
</div>		       
</div> 
	
	
	<script language="JavaScript1.2">
Calendar.setup({
        inputField     :    "startDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp1",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });
   
   Calendar.setup({
        inputField     :    "endDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp2",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });


</script>
	
</body>
</html>