<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page import="sun.net.smtp.SmtpClient" %>
<%@ page import="java.io.*" %>

<%
 String emailTo 	= "ttfundraisers@gmail.com";
 String emailFrom 	= emailTo; 
 String source		= "Childcare Fundraiser";
 
 String hresult = "";
 
 try
  {
     SmtpClient emailclient = new SmtpClient( "www.tangotab.com" );
     emailclient.from( emailTo );
     emailclient.to( emailTo );
	 
     PrintStream msg = emailclient.startMessage();
     
	
	 msg.println( "Subject: " + source + " Registration" + "\r\n" );
     msg.println( "First Name: "  + request.getParameter( "FirstName" ) + " Last Name: " + request.getParameter( "LastName" ) + "\r\n" );
	 msg.println( "Email: " + request.getParameter( "Email" ) + "\r\n" );
	 msg.println( "Zip: " + request.getParameter( "Zip" ) + "\r\n" );
	 msg.println( "Organization: " + request.getParameter( "Organization" ) + "\r\n" );
	 msg.println( "Phone Number: " + request.getParameter( "Phone" ) + "\r\n" );
	 msg.println( "\r\n" );
	 emailclient.closeServer();
  }
  catch (IOException err)
  {   
     hresult = "Could not send email\r\n" + err.toString();
  }
%>
 
 
 

<head>



<script language="javascript">
	var hresult = "<%= hresult %>";
</script>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>


<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" />
<link href="http://www.tangotab.com//css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="http://www.tangotab.com//css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<link href="http://www.tangotab.com/css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"  href="http://www.tangotab.com/css/jqueryslidemenu.css" />
<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/calendar-blue2.css"/>
<link href="http://www.tangotab.com/css/menu.css" rel="stylesheet" type="text/css" />
</head>


	<style>
		.header 	{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  	{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#7d9b17;} 
		.dealtitle  {font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  	{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#7d9b17;} 
		.dealtext	{font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#000000;} 
	</style>



<body>
	<div id="wrap">
		 

 












<div class="header">
	<div class="social_top">
		<div class="facebook_l">
			<div id="facebook_like">
				<fb:like href='http://www.tangotab.com/jsp/index.jsp' show_faces="false" layout="button_count" width="450" colorscheme="light"></fb:like>
	</div>

			<!--<div class="facebook_com">0</div>
			<div class="like_text">0 people like this. Be the first of your friends .</div>-->
			
		</div>
		<div class="like_text"></div>
		<div class="social_l">
<div id="tweet_like">
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='http://www.tangotab.com/jsp/index.jsp' data-text="I'm getting hot deals at cool restaurants with TangoTab and now you can too!" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div>
		<div id="email_like"><a href="#" title="Email"></a></div>
		</div>

	</div>
	<div class="logo"><h1>
	 <a href="http://www.tangotab.com/jsp/index.jsp"></a>
	 </h1></div>
		<div class="fr"><div class="top_navbox"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  
    <td width="83" align="center" valign="top">
    <!-- <a href="http://www.facebook.com" target="_blank"><img src="../images/facebook-icn.png" width="15" height="15" /></a>
    --></td>
    <td width="83" align="center" valign="top"><a href="http://www.tangotab.com/jsp/login.jsp"><img src="http://www.tangotab.com/images/login-icon.png" border="0" width="15" height="18" /></a></td>

    <td width="83" align="center" valign="top"><a href="http://www.tangotab.com/jsp/consumer_registration.jsp">
    <img src="http://www.tangotab.com/images/createicon.png" border="0"  width="18" height="18" /></a></td>
    
    
  </tr>
  <tr>
    
    <td height="22" align="center" valign="middle">
    <!-- <a href="http://www.facebook.com"  target="_blank">Login</a>--></td>
    <td align="center" valign="middle"><a href="http://www.tangotab.com/jsp/login.jsp">Login</a></td>
    <td align="center" valign="middle"><a href="http://www.tangotab.com/jsp/consumer_registration.jsp">Sign up</a></td>

    
      
  </tr>
</table>
</div>
<div class="download_tg"><a href="http://www.tangotab.com/jsp/mobileapps.jsp"><img src="http://www.tangotab.com/images/download-app.jpg" width="212" height="50" border="0"/></a>
</div></div>

 

 
	<div id="navigation">
		<div class="nav_l"></div>
		<div class="nav_m">
			
			<div id="menu">
				<ul>

					<li style="margin-left:0px;">
					
					
				 
					<a href="http://www.tangotab.com/jsp/index.jsp" id="home" title="Home"><span>Home</span></a>
					
					</li>
					<li>
					
						
						
						
					</li>
					<div class="nav_divider"></div><li><a href="http://www.tangotab.com/jsp/how_it_works.jsp" id="Learn More" title="Learn More"><span>Learn More</span></a></li>
					
					
						
							 <div class="nav_divider"></div>	
						<!-- <div class="nav_divider"></div>	-->

						 <li>					
						<a href="http://www.tangotab.com/jsp/searchForward.do" id="searchdeals" title="Search Deals"><span>Search Deals</span>
							</a>
							</li>
						
				 </ul>
			</div>	
		</div>
		<div class="nav_r"></div>

	</div>
</div>



	
			
			

<div class="content">
  <div>
    
	<table width="968" border="0" cellspacing="0" cellpadding="0">
 	<tr>
 	  <td width="968" height="25" align="center" valign="top" background="http://www.tangotab.com/images/abtgre.jpg"></td>
 	  </tr>
 	<tr>
 	  <td height="15" align="center" valign="top">
 	    
 	    
 	    
 	    <table cellpadding="5" cellspacing="0" border="0" width="900" align="center">
 	      <tr>
 	        <td width="200">&nbsp;
 	          
 	          </td>
 	        <td width="500" align="center" valign="top" class="strong">
 	          <br>
 	          
 	          
 	          <% if( hresult != "" ) {%>
 	          Could not send registration email. Please click the back button and try again. <br>
 	          <%=hresult%>
 	          <% } else { %>
 	          <div class="title2">
 	            Thank you for joining the <%=source%> TangoTab program!  
 	            </div>
 	          <br>
 	          <p align="center" style="font-size:16px; line-height:1.75"><strong>You will be receiving an email from us shortly.</strong> <br>
 	            You can start accruing funds for <%=source%> charities today by clicking the link below and signing up friends and family to receive awesome deals: <br>
 	            <strong><a style="color:#06C;" href="http://www.tangotab.com/refer/referfriends.jsp">http://www.tangotab.com/refer/referfriends.jsp</a></strong>
 	            <br>
 	            
 	            <% } %>
 	            
 	            
 	            </td>
 	        <td width="200">&nbsp;
 	          
 	          </td>
 	        </tr>
 	      </table>
 	    
 	    
 	    
 	    
 	    
 	    
 	    
 	    
 	    
 	    </td>
 	  </tr>
	</table>
  
  </div>
  <div style="clear:both;"></div>
</div>


<!--content  end here--><div style="clear:both;"></div>
<div id="footer-inner">
		<div class="footer_in">

			<a href="http://www.tangotab.com/jsp/aboutus.jsp">About Us</a>  I  
			<a href="http://www.tangotab.com/jsp/affiliates.jsp">Affiliates</a>  I  
			<a href="http://www.tangotab.com/jsp/press.jsp">Press</a> I  
			<a href="http://www.tangotab.com/jsp/jobs.jsp" >Jobs</a>  I  
			<a href="http://www.tangotab.com/jsp/contact_us.jsp">Contact Us</a>  I  
			<a href="http://www.tangotab.com/jsp/support_us.jsp">Support</a>  I  
			<a href="http://www.tangotab.com/jsp/privacy_policy.jsp">Privacy</a>  I  
			<a href="http://www.tangotab.com/jsp/terms.jsp">Terms</a>  
			<br/>
			<br/> 
			Copyright © 2000-2011 TangoTab.com All rights reserved.
		</div>

</div>


<div style="clear:both;"></div>
</div>
</body>
</html>
