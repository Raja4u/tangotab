<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 


<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%@ page import="javax.mail.event.*" %>

				
<%
	String hresult = "";
	
	String host = "smtpout.secureserver.net";
	String user = "noreply@tangotab.com";
	String pass = "nrpassword99";

	String from = "noreply@tangotab.com";
	
	/*
		mail.host=smtpout.secureserver.net
		mail.port=465
		mail.from=noreply@tangotab.com
		mail.auth.password=nrpassword99
		mail.auth.username=noreply@tangotab.com
	*/
	

	Properties props = new Properties();
	//props.put("mail.smtp.host","www.tangotab.com");
	props.put( "mail.host", host );
	props.put( "mail.transport.protocol", "smtp" );
	Session s = Session.getDefaultInstance( props, null );
	Transport transport = null;
	
	String fromName = request.getParameter( "Name" );
	String fromEmail = request.getParameter( "Email" );
	
	for( int i = 0; i < 10; ++i )
	{
		try
		{
			String toName = request.getParameter( "Name" + (i+1) );
			String toEmail = request.getParameter( "Email" + (i+1) );
			
			
			if( toName != null && toEmail != null )
			{
				if( toName.trim().equals( "" ) || toEmail.trim().equals( "" ) )
				{
					continue;
				}
				
				Message message = new MimeMessage( s );

				String msg = "";
			
				msg += "Hello " + toName + ",\r\n";
				msg += "\r\n";
				msg += fromName + " thought that you might be interested in hearing about a new concept called TangoTab!\r\n";
				msg += "\r\n";
				msg += "TangoTab allows you to receive and search for specials, happy hours, events, and even deals at your favorite restaurants, and ";
				msg += "you don't pay anything to TangoTab to take advantage of the offers. The best part is that by reserving offers through TangoTab, ";
				msg += "you are joining Shaun Proulx Media in the fight against hunger. Each time an offer is reserved, TangoTab and Shaun Proulx Media ";
				msg += "donate to local food banks and national organizations who feed Canada's hungry.\r\n";
				msg += "\r\n";
				msg += "Visit http://www.tangotab.com/shaunproulxmedia to sign up and start receiving these exclusive offers today!\r\n";
				msg += "\r\n";
				msg += "Thank you,\r\n";
				msg += "TangoTab & Shaun Proulx Media\r\n";
				msg += "Feeding the hungry one reservation at a time\r\n";
				msg += "\r\n";
								
				message.setFrom( new InternetAddress( "noreply@tangotab.com" ) );
				message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( toEmail, false ) );
				message.addRecipients( Message.RecipientType.BCC, InternetAddress.parse( "tangotab1@gmail.com", false ) );
				message.setSubject( "TangoTab Referal From " + fromName );
				message.setText( msg );  
				message.setSentDate( new Date() );
				
				//Transport.send( msg );
				
				transport = s.getTransport( "smtp" );
				transport.connect( host, user, pass );
				transport.sendMessage( message, message.getAllRecipients());
				transport.close(); 
			}
		}
		catch( Exception err )
		{   
			if( transport != null )
			{
				transport.close();
			}
			hresult += err.toString() + "<br>";
		}	
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
					
					<a href="signup.jsp" class="mediumwhite" style="text-decoration:none;">Sign Up</a>
					
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
			
			<img src="images/left.png" border="0" align="bottom" width="300">
			
		</td>
		
		<!------------------------------ RIGHT COLUMN ------------------------------>
		<td width="667" valign="top" align="center" >
		
			
			
			
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
					You’re helping Shaun Proulx Media help feed the hungry. 
					The average person has a social network of 669 people. 
					Just by claiming a TangoTab deal at a favorite restaurant 
					once per month, the average person’s social network 
					will feed 16,056 hungry people per year!

					<br>
					<br>
					<br>

			
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
