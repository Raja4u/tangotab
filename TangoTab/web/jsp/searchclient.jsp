<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
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
<script language="javascript">
function gosearch(id)
{
 
document.frm.cityName.value=id;
document.frm.submit();
}
</script>
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
           
       </td>
      </tr>
 
      <tr>
        <td height="6" colspan="3" align="left" valign="top"></td>
      </tr>
      <tr>
        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
        <form name="frm" method="post" action="search.do" >
        <input type="hidden" name="cityName" />
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
                    <td height="30" align="center" valign="middle" class="red_max">Cities</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td height="30" align="left" valign="middle" class="text_h3">Book deals the easyway Find a location->Select a deal->book the deal</td>
                  </tr> 
                  <tr>
                    
                  </tr>
                  <tr>
                    <td align="center" valign="top"><br/>
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" >
                         
               <tr>    <td width="29%" height="24" align="left" valign="middle" class="gre_medium"> 
               Featured cities :- Select a city to begin
					</td></tr>
                            
                            
			   						<bean:define id="citynames" name="dropDownList" property="cities" type="java.util.ArrayList"/>
																		<logic:iterate name="citynames" id="city">
			          <tr>    <td width="29%"  align="left" valign="top" > 
																				
																				<ul class="list">
																				<li class="list">
																				<a href="#" class="list" onclick="gosearch('<bean:write name="city" property="cityName" />')"><bean:write name="city" property="cityName"  /></a>
																				</li></ul>
				</td></tr>
																		</logic:iterate>
															
                          
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
          <!-- form End--> </form>       </td>
          
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
