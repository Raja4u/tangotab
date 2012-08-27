<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>

<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />




<link rel="stylesheet" type="text/css" href="../css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
<link href="../css/menu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
	var emailId='${loginForm.emailId}';
	//alert(emailId);
	function getCookie()
{

var i,x,y,ARRcookies=document.cookie.split(";");
 
 //alert(ARRcookies.length);
	for (i=0;i<ARRcookies.length;i++)
	  {
	//alert(ARRcookies);
	  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
	  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
	  x=x.replace(/^\s+|\s+$/g,"");
	 //alert(x);
 
			   if(x!='JSESSIONID' && emailId=="")
			   {
			//    alert(emailId);
			  document.loginForm.emailId.value=x;
			    document.loginForm.password.value=y;
			    break;
			  }//else 
			//   alert("else :");
	  }
 
}
function getCookieByName()
{

var cname=document.loginForm.emailId.value;
 document.loginForm.password.value='';
var i,x,y,ARRcookies=document.cookie.split(";");

for (i=0;i<ARRcookies.length;i++)
  {

  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  //alert(x);
  if(cname==x)
  {
  document.loginForm.password.value=y;
  }
 
  }
}



function delete_cookie ( cookie_name )
{
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
}
	</script>




</head>

<body onload="delete_cookie('showhidt');getCookie()">

<div id="wrapper">
<div id="main"><jsp:include page="header.jsp">
	<jsp:param name="currentPage" value="Login" />
</jsp:include> <!--Header End here-->


<div class="cantainer_inner">
<div class="main_cantainer">
<div class="cantainer_content">

<div class="inner_cantainer">
<div class="main_deal">

<div class="top_header"><img src="../images/corner_left.jpg"
	align="left" /> <img src="../images/corner_right.jpg" align="right" /></div>


<div class="content_deal">
<div class="login_page_main">

		<table width="955" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="2" align="center" valign="top">
				<table width="555" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="55" align="right" valign="middle"><img
							src="../images/logicon.png" width="28" height="31" /></td>
						<td width="420" align="left" valign="middle" class="red_max">
						<h1>I already have an account.</h1></td>
					</tr>
				</table>
				
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><logic:messagesPresent
					message="true">
					<html:messages id="message" message="true">
						<logic:present name="message">
							<tr>
								<td align="center" valign="middle" colspan="2"><FONT
									color="red"> <bean:write name="message" filter="false" />
								</FONT> <br>
								</td>
							</tr>
						</logic:present>
					</html:messages>
				</logic:messagesPresent></td>
			</tr>
			<tr>
				<td align="center" valign="top"><html:form
					action="/jsp/innerlogin">
					<table width="325" border="0" cellpadding="0" cellspacing="5" class="form_txt">
						<tr>
						</tr>

						<tr>
							<td align="right" width="20%" valign="middle"><p>Email:</p>
							</td>
							<td align="left" valign="middle"><html:hidden
								property="dealId" value="${dealID}" name="loginForm" /> <html:text
								property="emailId" styleClass="substxt"
								styleId="textfield"
								onkeyup="hidetext('emailId');getCookieByName();"
								onchange="getCookieByName();" /> <span id="emailId"> <html:errors
								property="emailId" /></span> <br>
							</td>
						</tr>
						<tr>
							<td align="right" valign="middle" width="20%"><p>Password: </p>
							</td>
							<td align="left" valign="middle"><html:password
								property="password" styleClass="substxt"
								styleId="textfield2" value="" onkeyup="hidetext('password');" />
							<span id="password"> <html:errors property="password" /></span><br>
							</td>
						</tr>
						<tr>
							<td align="left" valign="top">&nbsp; <br>
							</td>
							<td align="left" valign="top" class="gre_low"><a
								href="./forgot_password.jsp"
								style="color: #7d9b17; text-decoration: none;"><strong>Forgot
							Password</strong></a> <br>
							</td>
						</tr>
						<tr>
							<td align="right" valign="top">&nbsp; <br>
							</td>
							<td align="left" valign="top" class="text_h9"><html:checkbox
								property="rememberme"></html:checkbox>Remember me 
							</td>
						</tr>
						<tr>
							<td height="30" align="left" valign="top">&nbsp; <br>
							</td>
							<td align="left" valign="middle">
							<table width="75" border="0" align="left" cellpadding="0"
								cellspacing="0">
								<tr>
									<td>
									<div id="select_hot"><html:submit styleClass="but_img"
										styleId="submitID">Log In</html:submit></div>
									<br>
									</td>
								</tr>
							</table>
							
							</td>
						</tr>

					</table></td>
			</tr>
			              
             
		</table>
		</html:form>

<div style="clear: both;"></div>
</div>
</div>
<!--content  end here-->
<div style="clear: both;"></div>
<!--footer start here--></div>


</div>

</div>
<div class="top_bottom"><img
	src="../images/corner_bottom_left.jpg" align="left" /><img
	src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%></div>
</div>
</div>
</div>

</div>

<div style="clear: both;"></div>
</div>


</body>
</html>
