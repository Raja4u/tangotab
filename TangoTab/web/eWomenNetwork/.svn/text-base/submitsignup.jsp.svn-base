<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<%@ page import="sun.net.smtp.SmtpClient" %>
<%@ page import="java.io.*" %>

<%
String emailTo = "tangotab1@gmail.com";
 String emailFrom = emailTo; 
  
 
 String hresult = "";
 
 try
  {
     SmtpClient emailclient = new SmtpClient( "www.tangotab.com" );
     emailclient.from( emailTo );
     emailclient.to( emailTo );
	 
     PrintStream msg = emailclient.startMessage();
     
	
	 msg.println( "Subject: TangoTab.com eWomenNETWORK User Registration" + "\r\n" );
     msg.println( "First Name: "  + request.getParameter( "FirstName" ) + " Last Name: " + request.getParameter( "LastName" ) + "\r\n" );
	 msg.println( "Email: " + request.getParameter( "Email" ) + "\r\n" );
	 msg.println( "Zip: " + request.getParameter( "Zip" ) + "\r\n" );
	 msg.println( "Prefered City: " + request.getParameter( "PrefCity" ) + "\r\n" );
	 msg.println( "Phone Number: " + request.getParameter( "Phone" ) + "\r\n" );
	 msg.println( "\r\n" );
	 emailclient.closeServer();
  }
  catch (IOException err)
  {   
     hresult = "Could not send email\r\n" + err.toString();
  }
%>
 


<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title> TangoTab </title>
	
	<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 

	<style>
		body{ margin:0px; padding:0px; background:#000000; font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif; color:#ffffff;}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		#wrap{ margin:0px auto; padding:0px; width:967px; clear:both;}
		.normalwhite 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; }
		.normalgreen 	{ font-family:Arial, Helvetica, sans-serif; color:#7d9b17; font-size:12px; }
		.normalorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:12px; }
		.normalblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:12px; }
		.mediumblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:16px; }
		.mediumorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:14px; font-weight:bold; }
		.largeorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:16px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		.header 		{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  		{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#7d9b17;} 
		.dealtitle  	{font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  		{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#7d9b17;} 
		.dealtext		{font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#000000;} 
	</style>
	
	
	<script language="javascript">
		var hresult = "<%= hresult %>";
	</script>
	
	
	
</head>



<body topmargin="0" bottommargin="0">
<div id="wrap"> 

	<!------------------------------ START HEADER ------------------------------>

	<table cellpadding="10" cellspacing="0" border="0" width="967" align="center" bgcolor="#000000" height="70" style="height:70px; padding:10px;">
	<tr>
		<td bgcolor="#000000" align="left" valign="middle" width="200">
			<a href="http://www.tangotab.com" style="text-decoration:none;">
				<img src="http://www.tangotab.com/images/logo.png" border="0" align="left">
			</a>
		</td>
		<td bgcolor="#000000" align="left" valign="middle" width="300">
			<img src="images/tagline.jpg" border="0">
		</td>
		<td bgcolor="#000000" align="left" valign="middle" width="467">
			
			<table cellpadding="0" cellpadding="0" border="0" width="467" bgcolor="#000000" height="70" style="height:70px;">
			<tr>
				<td bgcolor="#000000" align="right" valign="top" class="mediumwhite">
					
					<a href="http://www.tangotab.com/jsp/consumer_registration.jsp" class="mediumwhite" style="text-decoration:none;">Sign Up</a>
					
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/login.jsp" class="mediumorange" style="text-decoration:none;">Sign In</a>
					
				</td>
			</tr>
			<tr>
				<td bgcolor="#000000" align="right" valign="bottom" class="normalwhite">
				
					<a href="http://www.tangotab.com/jsp/search.do" class="normalwhite" style="text-decoration:none;">
						Search Deals
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/how_it_works.jsp" class="normalwhite" style="text-decoration:none;">
						How It Works
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/refer/referfriends.jsp" class="normalwhite" style="text-decoration:none;">
						Refer a Friend
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/ourcharities.jsp" class="normalwhite" style="text-decoration:none;">
						Our Charities
					</a>
					
				</td>
			</tr>
			</table>

		</td>
	</tr>
	</table>

	<!------------------------------ END HEADER ------------------------------>








	<!------------------------------ START BODY ------------------------------>





	<table cellpadding="10" cellspacing="0" border="0" width="967" align="center" bgcolor="#ffffff" height="70" style="height:70px;">
	<tr>
	
		<!------------------------------ LEFT COLUMN ------------------------------>
		<td width="300" valign="top" align="center">
			
			<img src="images/whenyoueat.jpg" border="0" align="bottom"><br>
			<br>
			<br>
			<a href="http://www.ewomennetworkfoundation.org" target="_blank">
				<img src="images/ewn_logo.gif" border="0">
			</a>
			<br>
			<br>
			
			<font class="mediumorange" style="font-size:26px;">&amp;</font>
			
			<br>
			<br>
			<img src="http://www.tangotab.com/images/logo.png" border="0" align="bottom"><br>
			<br>
			<br>
			<img src="images/workingtogether.jpg" border="0" align="bottom"><br>
			<br>
			<br>
			<br>
			
		</td>
		
		<!------------------------------ RIGHT COLUMN ------------------------------>
		<td width="667" valign="top" align="center" background="images/backdrop2.png">
		
			
			
			
			<table cellpadding="5" cellspacing="0" border="0" width="500" align="center">
			<tr>
				<td align="center" valign="top" class="mediumblack">
					<br>
					<br>
					<br>
					<br>
					<br>
					
					<% if( hresult != "" ) {%>
						<div class="largeorange">
						Could not send registration email. Please click the back button and try again. <br>  
						<%=hresult%>
						</div>
					 <% } else { %>
						<div class="title">
						Thank you for registering with<br>
						<img src="http://www.tangotab.com/images/logo.png" border="0" height="40">  
						</div>
					<% } %>
					
					<br>
					<br>
					
					<div class="title2">
					You’re helping to feed the world’s hungry.<br>
					</div>
					
					Just by claiming a TangoTab deal at a favorite restaurant 
					once per month, you will feed 24 hungry people per year! <br>
					<br>
					<br>
					<div class="title2">
					Please help us spread the word! 
					</div>
					Connect your friends, family and colleagues with TangoTab!
					And, increase the funds raised to feed the hungry, one reservation at a time. 
					<br>
					<br>
					<br>

					<a href="referfriends.jsp">
						<img src="images/refer.png" border="0" align="absmiddle">
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://www.tangotab.com/jsp/mobileapps.jsp">
						<img src="images/getapp.png" border="0" align="absmiddle">
					</a>
					
				</td>
			</tr>
			</table>
			
			
			
			
			
			
		
		</td>
	</tr>
	</table>
		

	<!------------------------------ START FOOTER ------------------------------>
	
	<div style="background-color:#FFF;" id="footer-inner"> 
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
			Copyright © 2000-2012 TangoTab.com All rights reserved.
		</div> 
	</div> 
	
</div>
</body>

</html>
