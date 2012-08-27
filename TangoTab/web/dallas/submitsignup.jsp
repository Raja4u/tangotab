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
<%@page import="org.apache.commons.lang.StringUtils"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>

<fmt:setBundle basename="tangotab"></fmt:setBundle>
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
					"TangoTab.com and ChrisChamberlain User Registration", mailText); 
		
			
  }
  catch (Exception err)
  {   
     hresult = "Could not send email\r\n" + err.toString();
  }
%>
 


<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="Tango Tab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>
	<title> TangoTab </title>
	
	<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<!--  <link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/ddsmoothmenuup.css" /> 
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
		
		.top_border 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; border-top:5px solid #f8a657; }
		.left_right_border 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; border-left:5px solid #f8a657; border-right:5px solid #f8a657; }
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
<div id="wrap"> 
	<jsp:include page="../jsp/landheader.jsp"/> 
	<!------------------------------ START HEADER ------------------------------>

	
	<!------------------------------ END HEADER ------------------------------>








	<!------------------------------ START BODY ------------------------------>





	<table width="967" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="64" align="center" valign="top" background="images/top_bg.jpg"><table width="98%" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="5"></td>
            </tr>
            <tr>
              <td class="white_text"  align="left"> Each time you dine with TangoTab, we provide a meal <br>
                to a hungry person through local and national food banks</td>
            </tr>
        </table></td>
      </tr>
    </table>
  <table cellpadding="10" cellspacing="0" border="0" width="967" align="center" bgcolor="#ffffff" height="70" style="height:70px;">
	<tr>
	  <td align="center" valign="top" background="images/submitsignup.jpg" height="558"><table width="500" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td height="420">&nbsp;</td>
	      </tr>
	    <tr>
	      <td align="center" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	          <td><a href="referfriends.jsp"><img src="images/refer.png" border="0" align="absmiddle"></a></td>
	          <td><a href="http://www.tangotab.com/jsp/mobileapps.jsp"><img src="images/getapp.png" border="0" align="absmiddle"></a></td>
	          </tr>
	        </table></td>
	      </tr>
	    <tr>
	      <td>&nbsp;</td>
	      </tr>
	    <tr>
	      <td align="center" valign="middle">
	           
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
	       <!--  <table width="400" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="116" align="center" valign="middle"><img src="images/facebook_share.jpg" width="116" height="40"></td>
	            <td align="center" valign="middle"><img src="images/facebook_like.jpg" width="46" height="40"></td>
	            <td align="center" valign="middle"><img src="images/conatct_icon.png" width="53" height="39"></td>
	            <td align="center" valign="middle"><img src="images/twitter_icon.png" width="41" height="40"></td>
	            <td align="center" valign="middle"><img src="images/facebook_icon.png" width="41" height="40"></td>
	            </tr>
            </table>--></td>
	      </tr>
      </table></td>
	  </tr>
	<tr>
	
		<!------------------------------ LEFT COLUMN ------------------------------>
		<td align="center" valign="top" class="top_border">
        <table width="967" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="300" align="center" valign="middle"><!--  <a href="#"><img src="images/minnie's_big_img.jpg" width="215" height="201" border="0"></a>--></td>
		    <td width="357" align="center" valign="top" class="left_right_border"><img src="images/thanku_img.jpg" width="357" height="265"></td>
		    <td align="center" valign="middle"><img src="images/hungry_people.jpg" width="294" height="170"></td>
	      </tr>
		  </table>		  <br>
			
			
		</td>
		 
		<!------------------------------ RIGHT COLUMN ------------------------------>	  </tr>
	</table>
		

	<!------------------------------ START FOOTER ------------------------------>

	<%@ include file="../jsp/footer.jsp" %> 
</div>
</body>

</html>
