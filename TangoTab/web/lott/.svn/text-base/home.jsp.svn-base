
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

function verify()
{
	var form = document.RegistrationForm;
	var msg = "";
	
	if( form.Agree.checked == false )
	{
		alert( "You must agree to the terms and conditions." );
		return false;
	}
	
	if( form.FirstName.value == "" )
	{
		msg += "     * Your first name.\r\n";
	}
	if( form.LastName.value == "" )
	{
		msg += "     * Your first name.\r\n";
	}
	if( form.Email.value == "" )
	{
		msg += "     * Email Address.\r\n";
	}
	if( !form.Email.value == "" )
	{
		email = form.Email.value;
		
		if( email.indexOf( "@" ) < 0 || email.indexOf( "." ) < 0 )
		{
			msg += "     * Valid email address.\r\n";
		}
	}
	if( form.MobilePhone.value == "" )
	{
		msg += "     * Your mobile phone number.\r\n";
	}
	
	
	if( form.Password.value == "" || form.Password.value != form.ConfirmPassword.value || form.Password.value.length < 8 )
	{
		msg += "     * Invalid Password. Must be at least 8 characters long.\r\n";
	}
	
	if( form.RestaurantName.value == "" )
	{
		msg += "     * Restaurant name.\r\n";
	}
	if( form.RestaurantPhone.value == "" )
	{
		msg += "     * Restaurant phone number.\r\n";
	}
	if( form.SalesRep.value == "" )
	{
		msg += "     * Restaunt sales rep.\r\n";
	}
	
	
	if( form.Address1.value == "" )
	{
		msg += "     * Restaurant address line 1.\r\n";
	}
	if( form.City.value == "" )
	{
		msg += "     * Restaurant city.\r\n";
	}
	if( form.State.value == "" )
	{
		msg += "     * Restaurant state.\r\n";
	}
	if( form.Zip.value == "" )
	{
		msg += "     * Restaurant zip code.\r\n";
	}

	
	if( !msg == "" )
	{
		alert( "Please provide the following required information\r\n" + msg );
		return false;
	}
	else
	{
		//document.RegistrationForm.submit();
		return true;
	}
}

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
	 <a href="index.jsp"></a>
	 </h1></div>
		<div class="fr"><div class="top_navbox"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  
    <td width="83" align="center" valign="top">
    <!-- <a href="http://www.facebook.com" target="_blank"><img src="../images/facebook-icn.png" width="15" height="15" /></a>
    --></td>
    <td width="83" align="center" valign="top"><a href="login.jsp"><img src="http://www.tangotab.com/images/login-icon.png" border="0" width="15" height="18" /></a></td>

    <td width="83" align="center" valign="top"><a href="consumer_registration.jsp">
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
		
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				
				<tr>
					<td align="center" valign="top" class="red_max">
						20 Free TangoTab deals - Introductory Offer for Lott customers <br><br>
						
						Host Registration
					</td>
				</tr>
				
				<tr>
					<td width="653" align="center" valign="top" class="text_h9">
						<br>
	
						To take advantage of this special offer, please fill in the information below.  
						
						<table cellpadding="5" cellspacing="5" border="0">
						<tr>
							<td>
							
						
								<form action="promo-register.jsp" method="post" name="RegistrationForm" onSubmit="return verify();">
								
								<table cellpadding="5" cellspacing="5" border="0">
								
								<tr>
									<td align="right" valign="middle">
										First Name: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="FirstName" name="FirstName" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Last Name: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="LastName" name="LastName" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Mobile Phone: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="MobilePhone" name="MobilePhone" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Email: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="Emnail" name="Email" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								
								<tr>
									<td align="right" valign="middle">
										Password: 
									</td>
									<td align="left" valign="middle">
										<input type="password" id="Password" name="Password" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Confirm Password: 
									</td>
									<td align="left" valign="middle">
										<input type="password" id="ConfirmPassword" name="ConfirmPassword" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								
								<tr>
									<td colspan="3">&nbsp;
										 
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Restaurant Name: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="RestaurantName" name="RestaurantName" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Number of Locations: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="NumberOfLocations" name="NumberOfLocations" style="width:200px;">
									</td>
									<td align="left" valign="middle">&nbsp;
										 
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Restaurant Phone: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="RestaurantPhone" name="RestaurantPhone" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Sales Rep: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="SalesRep" name="SalesRep" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Business Address 1: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="Address1" name="Address1" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Business Address 2: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="Address2" name="Address2" style="width:200px;">
									</td>
									<td align="left" valign="middle">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										City: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="City" name="City" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										State: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="State" name="State" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">
										Zipcode: 
									</td>
									<td align="left" valign="middle">
										<input type="text" id="Zip" name="Zip" style="width:200px;">
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td colspan="3">&nbsp;
										 
									</td>
								</tr>
								<tr>
									<td align="right" valign="top">
										<input type="checkbox" id="Agree" name="Agree"> 
									</td>
									<td align="left" valign="middle" width="205">
										I certify that I have read and agree to the TangoTab 
										<a href="http://www.tangotab.com/jsp/privacy_policy.jsp" target="_blank" style="text-decoration:underline;">privacy policy</a> 
										and <a href="http://www.tangotab.com/jsp/terms.jsp" target="_blank" style="text-decoration:underline;">terms of use</a>.
									</td>
									<td align="left" valign="middle">
										<div style="color:#FF0000"><b>*</b></div>
									</td>
								</tr>
								<tr>
									<td align="right" valign="middle">&nbsp;
										 
									</td>
									<td align="right" valign="middle">
										<input type="submit" value=" Sign Up ">
									</td>
									<td align="left" valign="middle">&nbsp;
										 
									</td>
								</tr>
								</table>
								
								
								
								</form>
							
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;
							</td>
							<td valign="top">
								<br>
								<table bgcolor="#F89838" border="1" width="200" cellpadding="5" cellspacing="0">
								<tr><td align="center" >
									<div style="font:Arial, Helvetica, sans-serif; font-size:14px; margin:5px; padding:5px;">
									
									<b style="font-size:16px;">Introductory offer</b><br>
									<br>
									Create up to 20 free deals. No risk offer.<br>
									<br>
									TangoTab markets your deals via email, mobile apps & social media.
									You must register using this form to receive this promotional offer.
									Deals must be created by June 30, 2011.<br>
									<br>

									<font style="font:Arial, Helvetica, sans-serif; font-size:10px;">									
									Offer valid only to Lott Marketing customers. One offer per customer. Not redeemable for cash.  
									Offer available to new TangoTab customers only.
									</font>
									
									</div>
								</td></tr>
								</table>
								
							</td>
						</tr>
						</table>
						
						
						
						
						 
	
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
