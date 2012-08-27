<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 


<%@ page import="sun.net.smtp.SmtpClient" %>
<%@ page import="java.io.*" %>
<%@page import="com.tangotab.util.TangoTabMailer"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>

<fmt:setBundle basename="tangotab"></fmt:setBundle>
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
     String personalHeader="Pierre Thomas Referal Friend";
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
						
					 
						 mail = personalMail.replace(HOLDER_NAME, toName ).
					 replace(HOLDER_EMAIL, request.getParameter("Name"));
					 
					 TangoTabMailer.sendEmail(toEmail, null,personalHeader, mail);
						 
					}
				}
			}	 
	  if(request.getParameter( "Name" ).length()>0 && request.getParameter("Email").length()>0)	
      {
       TangoTabMailer.sendEmail(emailTo,
					null, 
					"Pierre Thomas Friend Referal", mailText); 
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
	<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="Tango Tab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>
	<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 
<link href="../css/restyle.css" rel="stylesheet" type="text/css" /> 
<!--<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/ddsmoothmenu.css" />
	--><style>
	 	body{ margin:0px; padding:0px; background:#000000; font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif; color:#ffffff;}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		#wrap{ margin:0px auto; padding:0px; width:967px; clear:both;}
		.normalwhite 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; }
		.normalgreen 	{ font-family:Arial, Helvetica, sans-serif; color:#7d9b17; font-size:12px; }
		.normalorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:12px; }
		.normalblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:12px; }
		.mediumblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:16px; }
		.mediumblack2 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:20px; font-weight:bold; }
		.mediumorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:14px; font-weight:bold; }
		.mediumred		{ font-family:Arial, Helvetica, sans-serif; color:#990000; font-size:14px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		.header 		{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  		{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#990000;} 
		.dealtitle  	{font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  		{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#990000;} 
		.dealtext		{font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#000000;} 
		
		.right_bottom_border 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; border-bottom:5px solid #f8a657; border-right:5px solid #f8a657; }
	.white_text {font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:16px; line-height:22px; font-weight:bold; }
    </style>
	
	
	
	<script language="javascript">
		var hresult = "<%= hresult %>";
	</script>
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
	<link rel="shortcut icon" href="http://tangotab.com/images/TangoT_Icon.ico" />
</head>



<body topmargin="0" bottommargin="0">
<div id="wrapper"> 
<div id="main">
	<!------------------------------ START HEADER ---------------------------- -->

	<jsp:include page="../jsp/landheader.jsp"/> 

	<!------------------------------ END HEADER ---------------------------- -->

	<!------------------------------ START BODY ------------------------------>

<div class="content_deal_inner_land" >


	<table width="967" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="64" align="center" valign="top" background="images/top_bg.jpg"><table width="98%" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="5"></td>
            </tr>
            <tr>
              <td class="white_text"  align="left">Each time you dine with TangoTab, we provide a meal <br>
                to a hungry person through local and national food banks</td>
            </tr>
        </table></td>
      </tr>
    </table>
  <table cellpadding="10" cellspacing="0" border="0" width="967" align="center" bgcolor="#ffffff" height="70" style="height:70px;">
	<tr>
	
		<!------------------------------ LEFT COLUMN ------------------------------>
		<td width="300" valign="top" align="center">
			
			  <table width="300" border="0" cellspacing="0" cellpadding="0">
			    <tr>
			      <td align="center" valign="top" class="right_bottom_border">
			      <img src="images/thanku_img.jpg" width="295" height="265"></td>
		        </tr>
                  <tr>
			      <td align="center" valign="top" >
			      <img src="images/submitfriendsshort.gif" width="295" height="150"></td>
			       
		        </tr>
		        <tr>
		        <td height="40">
			       
			       </td>
		        </tr>
			    <!--  <tr>
			      <td height="50" align="center">
			      <img src="images/supporting.jpg" width="200"   border="0" align="bottom" height="40">
			     <a href="www.associaadvantage.com"><img src="images/associa_cares.jpg" width="240" height="80" border="0" align="bottom"></a>
         	      </td>
		        </tr>
			    <tr>
			      <td height="250" align="center" valign="top">
                   <img src="images/assisting_families.jpg" width="270" height="120" border="0" align="bottom">
                   </td>
		        </tr> -->
                  <!--<img src="images/suppoting_minnies2.jpg" width="194" height="229">-->
        </table></td>
		
		<!------------------------------ RIGHT COLUMN ------------------------------>
		<td width="667" valign="top" align="center" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td height="180" align="center" valign="middle"><img src="images/thanku_referfriend.jpg" width="573" height="98"></td>
	      </tr>
		  <tr>
		    <td height="150" align="center" valign="top" class="mediumblack2">
		    By using TangoTab to eat at your favorite restaurants,<br> you're providing meals to people in need.</td>
	      </tr>
		  <tr>
		    <td align="center" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
		      <tr>
              <td><a href="http://www.tangotab.com/jsp/mobileapps.jsp"><img src="images/getapp.png" border="0" align="absmiddle"></a></td>
		        <td><a href="http://www.tangotab.com/jsp/search.do"><img src="images/search_deals.png" border="0" align="absmiddle"></a></td>
		        </tr>
		      </table></td>
	      </tr>
		  <tr>
		    <td>&nbsp;</td>
	      </tr>
		  <tr>
		    <td height="50" align="center" valign="middle">
		    
		     <div class="twiietr_bg">
        
       <div class="facebook_l">
			<div id="facebook_like">
				<fb:like href='<fmt:message key="facebook.frontpage.url"></fmt:message>' show_faces="false" layout="button_count" width="0" colorscheme="light"></fb:like>
	</div>

		</div>
       <div id="tweet_like">
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div>
<div>
<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>
<script type="IN/Share"></script>
</div>
       
       
       </div>
		    <!--   <table width="400" border="0" cellspacing="0" cellpadding="0">
		        <tr>
		          <td width="116" align="center" valign="middle"><img src="images/facebook_share.jpg" width="116" height="40"></td>
		          <td align="center" valign="middle"><img src="images/facebook_like.jpg" width="46" height="40"></td>
		          <td align="center" valign="middle"><img src="images/conatct_icon.png" width="53" height="39"></td>
		          <td align="center" valign="middle"><img src="images/twitter_icon.png" width="41" height="40"></td>
		          <td align="center" valign="middle"><img src="images/facebook_icon.png" width="41" height="40"></td>
	            </tr>
	          </table>--></td>
	      </tr>
		  <tr>
		    <td height="80" align="center" valign="middle">&nbsp;</td>
	      </tr>
	    </table></td>
	</tr>
	</table>
		

	<!------------------------------ START FOOTER ------------------------------>
	
	<!--  <div style="background-color:#FFFFF;" id="footer-inner"> 
		<div class="footer_in"> 
 
			<a href="http://www.tangotab.com/jsp/search.do" >Search Restaurants</a> I 
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
	</div>  -->
	<%@ include file="../jsp/footer.jsp" %> 
</div>
</div>
</div>
</body>

</html>
