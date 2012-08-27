<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 



<%@ page import="sun.net.smtp.SmtpClient" %>
<%@ page import="java.io.*" %>
<%@page import="com.tangotab.util.TangoTabMailer"%>

<%
String emailTo = "rathnakar.p@techgene.com";

  emailTo = "tangotab1@gmail.com";
 
 String hresult = "";
 
 
 
 try
 {
     String mailText="";
	 
 String HOLDER_NAME="#HOLDER_NAME#";
 String HOLDER_EMAIL="#HOLDER_EMAIL#";
     String personalMail="";
     String personalHeader="DIFFA Referal Friend";
	 String mail = "";
      
     personalMail =  "Dear "
	+HOLDER_NAME
	+ ",<BR/><BR/>"
	+ HOLDER_EMAIL
	+ " thought that you might be interested in hearing about a new concept called  TangoTab!" +
	  " TangoTab allows you to receive and search for specials, happy hours, events, and even deals at your favorite restaurants, " +
	  " and you don't pay anything to TangoTab to take advantage of the offers. The best part is that by reserving offers through TangoTab, you are joining in the fight against hunger.  " +
	  " Each time an offer is reserved, TangoTab donates to local food banks, as well as national and global organizations who feed the world's hungry.  Click "
	+ "<a  href='http://www.tangotab.com/jsp/consumer_registration.jsp'>here</a> to signup and start receiving these exclusive offers today! "
	+ "<BR/><BR/>Thank you,<BR/><BR/>"
	+"<img src='http://tangotab.com/images/logo.png' /><BR/><BR/>" 
	+" Feeding the world's hungry... one reservation at a time";
	
	
	
		 if(request.getParameter( "Name" ).length()>0 && request.getParameter("Email").length()>0)	
		     {
			   personalHeader= request.getParameter( "Name" )+" wants to share TangoTab with you!";
		     mailText= ( "Name: "  + request.getParameter( "Name" ) 	 + "<br/>" );
			mailText= mailText+ ( "Email: " + request.getParameter( "Email" )    + "<br/>" );
			mailText= mailText+ ( "<br/>" );
			}
			String toName="";
			String toEmail="";
			int j=1;
			for (int i=1;i<11;i++)
			{
				if(request.getParameter("Name"+i)!=null && request.getParameter("Email"+i)!=null)
				{ 
				toName=request.getParameter("Name"+i);
				toEmail=request.getParameter("Email"+i);
					if(toName.length()>0 && toEmail.length()>0)
					{
						mailText= mailText+ ( j + ")  Name: " +toName + "  Email: " +  toEmail    + "<br/>" );
						j++;
							/*
						 mail = personalMail.replace(HOLDER_NAME, toName ).
					 replace(HOLDER_EMAIL, request.getParameter("Email"));
					 
					 TangoTabMailer.sendEmail(toEmail, null,personalHeader, mail);
						*/
					}
				}
			}	 
	  if(request.getParameter( "Name" ).length()>0 && request.getParameter("Email").length()>0)	
      {
       TangoTabMailer.sendEmail(emailTo,
					null, 
					"DIFFA Friend Referal", mailText); 
      }
    
    
    /*  SmtpClient emailclient = new SmtpClient( "www.tangotab.com" );
     emailclient.from( emailTo );
     emailclient.to( emailTo );
	 
     PrintStream msg = emailclient.startMessage();
     
	 String program = request.getParameter( "Program" );
	 
	if( program != null && program.equals( "ewn" ) )
	{
		msg.println( "Subject: DIFFA Friend Referal" 		 + "\r\n" );
	}
	else
	{
		msg.println( "Subject: TangoTab.com Friend Registration" 	 + "\r\n" );
	}
	
    msg.println( "Name: "  + request.getParameter( "Name" ) 	 + "\r\n" );
	msg.println( "Email: " + request.getParameter( "Email" )    + "\r\n" );
	msg.println( "\r\n" );
	 
	msg.println( "1. Name: " + request.getParameter( "Name1" ) + " Email: " + request.getParameter( "Email1" )    + "\r\n" );
	msg.println( "2. Name: " + request.getParameter( "Name2" ) + " Email: " + request.getParameter( "Email2" )    + "\r\n" );
	msg.println( "3. Name: " + request.getParameter( "Name3" ) + " Email: " + request.getParameter( "Email3" )    + "\r\n" );
	msg.println( "4. Name: " + request.getParameter( "Name4" ) + " Email: " + request.getParameter( "Email4" )    + "\r\n" );
	msg.println( "5. Name: " + request.getParameter( "Name5" ) + " Email: " + request.getParameter( "Email5" )    + "\r\n" );
	msg.println( "6. Name: " + request.getParameter( "Name6" ) + " Email: " + request.getParameter( "Email6" )    + "\r\n" );
	msg.println( "7. Name: " + request.getParameter( "Name7" ) + " Email: " + request.getParameter( "Email7" )    + "\r\n" );
	msg.println( "8. Name: " + request.getParameter( "Name8" ) + " Email: " + request.getParameter( "Email8" )    + "\r\n" );
	msg.println( "9. Name: " + request.getParameter( "Name9" ) + " Email: " + request.getParameter( "Email9" )    + "\r\n" );
	msg.println( "10. Name: " + request.getParameter( "Name10" ) + " Email: " + request.getParameter( "Email10" )    + "\r\n" );
	 
	msg.println( "\r\n" );
	
	emailclient.closeServer();
	*/
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
		.mediumred		{ font-family:Arial, Helvetica, sans-serif; color:#990000; font-size:14px; font-weight:bold; }
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
			
			<br>
			<br>
			<a href="http://www.diffadallas.org" target="_blank">
				<img src="images/diffalogo.jpg" border="0">
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
						Thank you for referring your friends to <br>
						<img src="http://www.tangotab.com/images/logo.png" border="0" height="40">  
						</div>
					<% } %>
					
					
					<br>
					<br>
					
					
					<div class="title2">
					You’re helping to make a difference!<br>
					</div>
					The average person has a social network of 669 people. 
					Just by claiming TangoTab deals at your favorite restaurants, 
					your network can significantly impact the lives of 
					North Texans living with HIV/AIDS. 

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
