<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
    <%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="consumer_imports.jsp" %>
<link href="../css/bookdealpopover.css" rel="stylesheet" type="text/css" />    
<style>
#OVER{width:100%; height:100%; left:0px;/*IE*/ top:0px; text-align:center; z-index:5; position:fixed; filter:alpha(opacity=20); opacity:0.2; background-color:#fff;}
#overlay {width:40%; height:50%; z-index:6; display:inline; left:38%;/*IE*/ top:30%; font-color:#cdcdcd; font-size:0.8em;
filter:alpha(opacity=100); opacity:1;text-align:center; position:fixed; background-color:#777;}
#popup {
-webkit-border-radius: 40px;
-moz-border-radius: 40px;
border-radius: 40px; width:280px; height:auto; padding:10px;
border:solid 1px #000;  left:35%; top:40%;valign:middle;

position:fixed;
left:35%;
top:40%;
margin: 10px;
background:#FFF;
z-index:40;
text-align: center;
}
#popup p{color: #000;}
</style>
<script>
	!window.jQuery && document.write('<script src="../js/jquery-1.4.3.min.js"><\/script>');
</script>
<script type="text/javascript">
	/* Popup when suggest */
	$(document).ready(function() {
		if('${data}'=='mailsent')
		{
			document.getElementById('popup').style.display='block';
			document.getElementById('backgroundPopupdeal').style.display='block';
		}
	});
	/* closing popup */
	function close(){
		document.getElementById('popup').style.display='none';
		document.getElementById('backgroundPopupdeal').style.display='none';
	}
</script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
<script src="../js/Country_state.js" type="text/javascript"></script>
<script src="../js/util.js" type="text/javascript"></script>

<title> TangoTab </title>
<style >
	.mediumblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:14px; }
	.normalblack {color: #000000}
</style>
</head>

<body><div id="wrapper">
	<div id="main">
		<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Learn More" />
		</jsp:include> 
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
  <div class="main_deal">
  
  <div class="top_header">
  <img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
							
  <html:form action="/jsp/suggest" method="post">
 <table width="900" border="0" cellspacing="0" cellpadding="0"  >
          <tr>
            <td align="left" valign="top">&nbsp;</td>
            </tr>
          <tr>
            <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0 " align="center">
              <tr>
                <td height="120" align="center" valign="middle"><img src="../images/suggestion_box.jpg" alt="Suggestion Box" width="356" height="74" border="0" /></td>
              </tr>
              <tr>
                <td height="35" width="100%"  align="center" valign="top" class="mediumblack"> 
                Don't see your city? Your favorite lunch spot? A really good offer?</td>
              </tr>
              <tr>
                <td align="center" width="100%"  valign="top"  class="mediumblack">Tell us what we're missing! Please impart your infinite wisdom<br />
and we promise to listen and try to make TangoTab better.</td>
              </tr>
                  <tr>
                    <td align="center" valign="top" colspan='2'>
                    <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="2">
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		
																	</td>
																</tr>
															</logic:present>
														</html:messages>
													</logic:messagesPresent></td>
            </tr>
            </table></td>
          </tr>
          <tr>
            <td height="30" align="left" valign="top">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" valign="top"><table width="70%" border="0" cellspacing="2" cellpadding="4">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="10%" align="right" valign="middle"  ><span class="normalblack">Name :</span></td>
                    <td width="41%" align="left" valign="top"><html:text  property="cname"  styleClass="text_box" maxlength="60" />
                     </td>
                    <td width="10%" align="right" valign="middle"><span class="normalblack">Email :</span></td>
                    <td width="42%" align="left"><html:text  property="emailId"  styleClass="text_box"  maxlength="60" /></td>
                  </tr>
                    <tr>
                    <td width="7%" align="left" valign="middle" class="normalblack">&nbsp;</td>
                    <td width="41%" align="left" valign="top"> 
                     <html:errors  property="cname"/></td>
                    <td width="10%" align="right" valign="middle">&nbsp;</td>
                    <td width="42%" align="left"> <html:errors  property="emailId"/></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><img src="../images/mytwocents.jpg" alt="My Cents" width="177" height="35" border="0" /></td>
              </tr>

              <tr>
                <td><table width="100%" border="0" cellspacing="4" cellpadding="4">
                  <tr>
                    <td width="27%" height="30" align="right" valign="middle"><span class="normalblack">My City :</span></td>
                    <td width="73%" height="30" align="left" valign="middle"><html:text  property="city"  styleClass="text_box"   /></td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="middle"><span class="normalblack">My Restaurant :</span></td>
                    <td height="30" align="left" valign="middle"><html:text  property="businessName"  styleClass="text_box"  maxlength="60" />
                   </td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="middle"><span class="normalblack">My mobile platform :</span></td>
                    <td height="30" align="left" valign="middle"><html:text  property="mobile"  styleClass="text_box"  maxlength="10" /></td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="middle"><span class="normalblack">Other :</span></td>
                    <td height="30" align="left" valign="middle"><html:textarea  property="other"  styleClass="text_box"  cols="35" rows="5" /></td>
                  </tr>
                  <tr>
                    <td height="30" align="left" valign="middle">&nbsp;</td>
                    <td height="30" align="left" valign="bottom">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="left" valign="middle">&nbsp;</td>
                    <td height="30" align="left" valign="middle">
                     <input type="submit"  value="" class="submit_img"  />
                      </td>
                  </tr>
                </table></td>
              </tr>
               
            </table></td>
            </tr>
        </table>
    </html:form>
 </div>


</div>

            </div>
            
            
            <div class="top_bottom">
            <img src="../images/corner_bottom_left.jpg" align="left" />
            <img src="../images/corner_bottom_right.jpg" align="right" />
            </div>
<!-- Pop-up suggest box -->            
<div id="popup" style="display:none;">
	<span style="position: absolute;    right: -30px;    top: -11px;padding-right:5px;vertical-align:top;">
		<a  id="popupContactClose" href="javascript:close();"><img src="../images/close_popup.png" border="0" /></a>
	</span>
	<div style=" margin: 10px">
		<div style="font-size: 19px; color: #f57e20; font-weight: bold; font-family:arial;">Thank you for contacting TangoTab.</div><br/>
		<p style="font-size: 17px;">Your feedback is appreciated. We&nbsp;will&nbsp;respond&nbsp;shortly.</p>
	</div>
</div>
<div id="backgroundPopupdeal"  style="display:none;"></div> 
<!--footer start here-->

				<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>

</body>
</html>
