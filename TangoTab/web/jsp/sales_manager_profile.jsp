<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
 <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/scroll.js"></script>
		<script type="text/javascript" src="../js/scrollend.js"></script> 
        <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
	    <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
       <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
       <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
       <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css" />
       <script language="javascript" type="text/javascript">
       	
       		function add(){
				 leftSideCities = document.getElementById("totalCities");
				 rightSideCitiws= document.getElementById("cities");
				 len = leftSideCities.length;
				 for (i = 0; i < len; i++) {
				 	option = leftSideCities.options[i];
					if(option.selected) {
						rightSideCitiws.appendChild(option);
						i--;
						continue;
					} 
				}
       		}
       		
       		function removeCity(){
       			leftSideCities = document.getElementById("totalCities");
				 rightSideCitiws= document.getElementById("cities");
				 len = rightSideCitiws.length;
				 for (i = 0; i < len; i++) {
				 	option = rightSideCitiws.options[i];
					if(option.selected) {
						leftSideCities.appendChild(option);
						i--;
						continue;
					} 
				}
       		}
       		
       		function selectAllCities(){
       			rightSideCitiws= document.getElementById("cities");
				 len = rightSideCitiws.length;
				 rightSideCitiws.multiple=true;
				 for (i = 0; i < len; i++) {
				 	rightSideCitiws.options[i].selected=true;
				 }
				 document.forms[0].action = "salesManagerReg.do";
				 document.forms[0].submit();
       		}
       			function cancelToDisplay(){
       			document.forms[0].action = "salesMgrDisplay.do";
				 document.forms[0].submit();
       		}
	   </script>

</head>

  <body >
	
	<div id="wrap"><jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		 </jsp:include> 
		
		<div class="content">
			<div class="insight-content"><div class="mid_consumer">
			<table width="760" border="0" cellspacing="0" cellpadding="0">			  
				<%@ include file="admin_banner.jsp" %>
			         <td height="17" colspan="3" align="center" valign="top">
			         <html:form action="/jsp/salesManagerReg">
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top"><table width="938" border="0" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="40" colspan="2" align="center" valign="middle" class="red_max">Sales Manager Registration</td>
                    </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">First Name:</td>
                    <td width="38%" align="left" valign="middle"><span class="red_text">
                      <html:text  property="firstname" styleClass="restaurant_input"  />
                    </span></td>
                  </tr>
                  <tr>
                    <td width="22%" align="right" valign="middle" class="bla_low">Last Name:</td>
                    <td width="38%" align="left" valign="middle"><span class="red_text">
                      <html:text  property="lastname"  styleClass="restaurant_input"  />
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top" class="bla_low">Home Address:</td>
                    <td align="left" valign="middle"><html:textarea   property="address"  styleClass="restaurant_textarea"></html:textarea></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Home Phone:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text  property="homePhone"  styleClass="restaurant_input"  />
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Mobile Number:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text  property="mobilePhone"  styleClass="restaurant_input"  />
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low"> Email ID:</td>
                    <td align="left" valign="middle"><span class="red_text">
                      <html:text  property="emailId"  styleClass="restaurant_input"/>
                    </span></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Hire Date:</td>
                    <td align="left" valign="middle" class="text_h9">
					<html:text  property="hireDate" styleId="hireDate" />
			        <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />
                   </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Termination Date:</td>
                    <td align="left" valign="middle" class="text_h9">
                      <html:text property="terminationDate"  styleId="terminationDate" styleClass="restaurant_input" />
					  <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />
				  </td>
                  </tr>
                  <tr>
                  		<td colspan="2">
                  			<table width="940" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="400" align="center" valign="top" bgcolor="#CCCCCC"><table width="100%" border="0" cellspacing="1" cellpadding="0">
                          <tr>
                            <td height="30" align="center" valign="middle" bgcolor="#efefef"><span class="text_h3">Cities</span></td>
                          </tr>
                          <tr>
                            <td align="center" valign="top" bgcolor="#EFEFEF"><table width="98%" cellpadding="0" cellspacing="5">
                                <tr>
                                  <td height="155" colspan="6" align="center" valign="top">
                                  <html:select property="totalCities" size="10" multiple="true" styleClass="list_menu" styleId="totalCities">
                                		<bean:define id="relationships4" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    					<html:options collection="relationships4" property="cityId" labelProperty="cityName"/>
                                  </html:select>
							</td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>
                        <td width="140" align="center" valign="middle" bgcolor="#F9F9F9"><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td height="45" align="center" valign="middle"><html:button property="" value="Add" onclick="add()"/></td>
                          </tr>
                          <tr>
                            <td height="45" align="center" valign="middle"><html:button property="" value="Remove" onclick="removeCity()"/></td>
                          </tr>
                        </table></td>
                        <td width="400" align="center" valign="top" bgcolor="#CCCCCC"><table width="100%" border="0" cellspacing="1" cellpadding="0">
                          <tr>
                            <td height="30" align="center" valign="middle" bgcolor="#efefef"><span class="text_h3"> Allocated Cities</span></td>
                          </tr>
                          <tr>
                            <td align="center" valign="top" bgcolor="#EFEFEF"><table width="98%" cellpadding="0" cellspacing="5">
                                <tr>
                                  <td height="155" colspan="6" align="center" valign="top" class="list_menu">
                                 		 <html:select property="cities" size="10" multiple="true" styleClass="list_menu" styleId="cities">
                                   
                                  		</html:select>
								  </td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table>
                  		</td>
                  </tr>
                  <tr>
                    <td height="40" colspan="2" align="center" valign="middle" class="text_h9"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><div id="select_hot"><html:button property="" onclick="selectAllCities()">Submit</html:button></div></td>
                          <td><div id="select_hot"><html:reset>Reset</html:reset></div></td>
                          <td><div id="select_hot"><html:button property="" onclick="cancelToDisplay()">Cancel</html:button></div></td>
                        </tr>
                    </table></td>
                    </tr>
                	</table></td>
                	<td width="8" background="../images/8.png"></td>
              	</tr>
	              <tr>
	                <td height="8" background="../images/3.png"></td>
	                <td height="8" background="../images/6.png">/</td>
	                <td height="8" background="../images/4.png">t</td>
	              </tr>
            </table></html:form>
            <script language="JavaScript1.2">
Calendar.setup({
        inputField     :    "hireDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp1",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });
   
   Calendar.setup({
        inputField     :    "terminationDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp2",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });


</script>
			     <!-- form End-->
							</td>
			      		</table>
				</div>
				</div>
			<div style="clear:both;"></div>
		</div><!--content  end here-->
		<div style="clear:both;"></div>
		<%@ include file="footer.jsp"%>
		<div style="clear:both;"></div>
	</div> 
</body>
</html>