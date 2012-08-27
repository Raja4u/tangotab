<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

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
     
	 String program = request.getParameter( "Program" );
	 
	if( program != null && program.equals( "ewn" ) )
	{
		msg.println( "Subject: eWomenNETWORK Friend Referal" 		 + "\r\n" );
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
<title>TangoTab</title>


<script type="text/javascript" src="http://www.tangotab.com/js/scroll.js"></script>
<script type="text/javascript" src="http://www.tangotab.com/js/scrollend.js"></script>
<script type="text/javascript" src="http://www.tangotab.com//js/util.js"></script>

<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" />
<link href="http://www.tangotab.com//css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="http://www.tangotab.com//css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="http://www.tangotab.com//js/jqueryslidemenu.js"></script> 
<script type="text/javascript" src="http://www.tangotab.com//js/jquery.min.js"></script>
<script type="text/javascript" src="http://www.tangotab.com//js/consumerValidations.js"></script>
<script type="text/javascript" src="http://www.tangotab.com//js/jqueryslidemenu.js"></script>
<script src="http://www.tangotab.com//js/Country_state.js" type="text/javascript"></script>

<script type='text/javascript' src='http://www.tangotab.com/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='http://www.tangotab.com/dwr/engine.js'></script>
<script type='text/javascript' src='http://www.tangotab.com/dwr/util.js'></script>
<script type='text/javascript' src='http://www.tangotab.com/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='http://www.tangotab.com/dwr/interface/deal.js'></script>
<script type='text/javascript' src='http://www.tangotab.com/dwr/interface/DealDescr.js'></script>
<script type="text/javascript" src="http://www.tangotab.com/js/calendar.js"></script>
<script type="text/javascript" src="http://www.tangotab.com/js/calendar-en.js"></script>
<script type="text/javascript" src="http://www.tangotab.com/js/calendar-setup.js"></script>

<link href="http://www.tangotab.com/css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"  href="http://www.tangotab.com/css/jqueryslidemenu.css" />
<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/calendar-blue2.css"/>
<link href="http://www.tangotab.com/css/menu.css" rel="stylesheet" type="text/css" />
<script src="http://www.tangotab.com/js/jquery-1.js" type="text/javascript"></script> 
<script src="http://www.tangotab.com/js/sendmail.js" type="text/javascript" charset="utf-8"></script>
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
		 

 

<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
<script src="http://www.tangotab.com/js/jquery-1.js" type="text/javascript"></script>

<script src="http://www.tangotab.com/js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<link rel="shortcut icon"  href="http://www.tangotab.com/images/TangoT_Icon.ico" /> 
<div id="fb-root">
</div>
<script type="text/javascript">
                      window.fbAsyncInit = function(){
                                    FB.init({
                                        appId: '216686028341782',
                                        status: true,
                                        cookie: true,
                                        xfbml: true
                                    });
									
                                };
                                (function(){
                                    var e = document.createElement('script');
                                    e.async = true;
                                    e.src = document.location.protocol +
                                    '//connect.facebook.net/en_US/all.js';
									document.getElementById('fb-root').appendChild(e);
                                }());
						
</script>











<script language="javascript">


<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-17306170-3']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>







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
        <td width="8" height="25" align="center" valign="top" background="http://www.tangotab.com/images/abtgre.jpg"></td>

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
					Thank you for referring friends to TangoTab!  
					</div>
					<br>
					Check out the cool deals we have running every day here.  Tell your friends why it’s a great idea to sign up
					(aside from the fact that it will put money in your pocket).  When 25 of them sign up, you’ll receive a check from us!<br>
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
