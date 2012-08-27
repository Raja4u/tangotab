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
	 

     
	
 
    mailText= "First Name: "  + request.getParameter( "FirstName" ) + "     Last Name: " + request.getParameter( "LastName" ) + "<br/>" ;
	  mailText= mailText+ ("Email: " + request.getParameter( "Email" ) + "<br/>") ;
	  mailText= mailText+ ("Zip: " + request.getParameter( "Zip" ) + "<br/>" );
	  mailText= mailText+ ( "Prefered City: " + request.getParameter( "hPrefCity" ) + "<br/>" );
	  mailText= mailText+( "Phone Number: " + request.getParameter( "Phone" ) + "<br/>") ;
	  mailText= mailText+( "\r\n" );
	 	  TangoTabMailer.sendEmail(emailTo,
					null, 
					"TangoTab.com Shaun Proulx Media User Registration", mailText); 
	/*
	     SmtpClient emailclient = new SmtpClient( "smtpout.secureserver.net" );
    emailclient.from( emailTo );
     emailclient.to( emailTo );
       PrintStream msg = emailclient.startMessage();
	    msg.println( "First Name: "  + request.getParameter( "FirstName" ) + " Last Name: " + request.getParameter( "LastName" ) + "\r\n" );
	 msg.println( "Email: " + request.getParameter( "Email" ) + "\r\n" );
	 msg.println( "Zip: " + request.getParameter( "Zip" ) + "\r\n" );
	 msg.println( "Prefered City: " + request.getParameter( "hPrefCity" ) + "\r\n" );
	 msg.println( "Phone Number: " + request.getParameter( "Phone" ) + "\r\n" );
	 msg.println( "\r\n" );
	 
	  emailclient.closeServer();*/

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
		.largepurple	{ font-family:Arial, Helvetica, sans-serif; color:#6600DD; font-size:16px; font-weight:bold; }
		
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		.header 		{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  		{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#6600DD;} 
		.dealtitle  	{font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  		{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#6600DD;} 
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
				<img src="images/tt-spmlogo.png" border="0" align="left">
			</a>
		</td>
		<td bgcolor="#000000" align="left" valign="middle" width="300">&nbsp;
			
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
				
					<a href="http://www.tangotab.com/jsp/search.do" class="normalwhite" style="text-decoration:none;" target="_blank">
						Search Deals
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/how_it_works.jsp" class="normalwhite" style="text-decoration:none;" target="_blank">
						How It Works
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="referfriends.jsp" class="normalwhite" style="text-decoration:none;">
						Refer a Friend
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/chairty.jsp" class="normalwhite" style="text-decoration:none;" target="_blank">
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
			
			<br>
			<img src="images/whenyoueat.jpg" border="0" align="bottom">
			<br>
			<a href="http://shaunproulxmedia.com/" target="_blank">
				<img src="images/spmlogo.jpg" border="0">
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
						<div class="largepurple">
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
					
					
					You’re helping Shaun Proulx Media feed Canada’s hungry. 
					Just by claiming a TangoTab deal at a favorite 
					restaurant once per month, you will feed 
					24 hungry people per year! <br>
					<br>
					<br>
					<div class="title2">
					Shaun Proulx Media needs your support!  
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
		

	
</div>
</body>

</html>
