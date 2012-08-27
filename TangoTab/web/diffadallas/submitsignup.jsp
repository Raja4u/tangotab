<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<%@ page import="sun.net.smtp.SmtpClient" %>
<%@ page import="java.io.*" %>
<%@page import="com.tangotab.web.form.UserForm"%>
<%@page import="com.tangotab.business.UserBO"%>
<%@page import="com.tangotab.businessImpl.UserBOImpl"%>
<%@page import="com.tangotab.dao.pojo.ConsumerPreferCity"%>
<%@page import="com.tangotab.dao.pojo.User"%>
<%@page import="com.tangotab.dao.pojo.City"%>
<%@page import="com.tangotab.util.TangoTabMailer"%>

<%
String emailTo = "rathnakar.p@techgene.com";

  emailTo = "tangotab1@gmail.com";
 
 String hresult = "";
 
 try
  {
  User  user  =new User();
  UserBO userBO=new UserBOImpl();
  user.setFirstname(request.getParameter( "FirstName" ) );
    user.setLastname(request.getParameter( "LastName" ) );
    user.setEmailId(request.getParameter( "Email" ));
    user.setZipCode(request.getParameter( "Zip" ));
    user.setMobilePhone(request.getParameter( "Phone" ));
    
       user.setPassword(request.getParameter( "Password" ));
       int s[]={};
       user.setPreferencesList(s);
    if (!userBO.checkUserAvailability(user.getEmailId(), 4)) {
    
       user.setRefferCode(Integer.parseInt(request.getParameter( "refferCode" )));
 		ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
				consumerPreferCity.setUser(user);
				City city = new City();
				if(request.getParameter( "PrefCity" )!=null)
				city.setCityId(Integer.parseInt(request.getParameter( "PrefCity" )));
				else 
					city.setCityId(9);
				consumerPreferCity.setCity(city);
				user.setConsumerPreferCity(consumerPreferCity);
				String validcode = "";
			 	userBO.saveConsumer(user);
				}

     String mailText="";
	 

      
      mailText=   ( "First Name: "  + request.getParameter( "FirstName" ) + "        Last Name: " + request.getParameter( "LastName" ) + "\r\n" );
	 mailText= mailText+ ( "Email: " + request.getParameter( "Email" ) + "<br />" );
	  mailText= mailText+ ( "Zip: " + request.getParameter( "Zip" ) + "<br />" );
	  mailText= mailText+ ( "Prefered City: " + request.getParameter( "hPrefCity" ) + "<br />" );
	  mailText= mailText+ ( "Phone Number: " + request.getParameter( "Phone" ) + "<br />" );
	 
	   TangoTabMailer.sendEmail(emailTo,
					null, 
					"TangoTab.com DIFFA User Registration", mailText); 
	
  }
  catch (Exception err)
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
		.largered		{ font-family:Arial, Helvetica, sans-serif; color:#990000; font-size:16px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		.header 		{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  		{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#990000;} 
		.dealtitle  	{font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  		{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#990000;} 
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
					
					<a href="http://www.tangotab.com/jsp/chairty.jsp" class="normalwhite" style="text-decoration:none;">
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
			
			<img src="images/together.jpg" border="0" align="bottom"><br>
			
			
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
						<div class="largered">
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
					
					You’re helping to provide treatment and care for those living with HIV/AIDS in North Texas. 
					<br>
					<br>
					<br>
					<div class="title2">
					DIFFA/Dallas needs your support! 
					</div>
					Connect your friends, family and colleagues with TangoTab!
					And, increase the funds raised to help those in need.

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
