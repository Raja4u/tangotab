<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title> TangoTab </title> 
 
 
 
<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 
<link href="http://www.tangotab.com//css/scrollcolor.css" rel="stylesheet" type="text/css" /> 
<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/jqueryslidemenu.css" /> 
<link href="http://www.tangotab.com/css/scrollcolor.css" rel="stylesheet" type="text/css" /> 
<link rel="stylesheet" type="text/css"  href="http://www.tangotab.com/css/jqueryslidemenu.css" /> 
<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/calendar-blue2.css"/> 
<link href="http://www.tangotab.com/css/menu.css" rel="stylesheet" type="text/css" /> 

	<style> 
		.header 	{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  	{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#7d9b17;} 
		.dealtitle  {font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  	{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#7d9b17;} 
		.dealtext	{font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#000000;} 
	</style> 
 
 
 
	<script language="javascript"> 
	 
		function validateForm()
		{
			var form = document.RegistrationForm;
			var msg = "";
			
			if( form.FirstName.value == "" )
			{
				msg += "     * Your First Name.\r\n";
			}
			if( form.LastName.value == "" )
			{
				msg += "     * Your Last Name.\r\n";
			}
			if( form.Email.value == "" )
			{
				msg += "     * Your Email Address.\r\n";
			}
			if( form.Zip.value == "" )
			{
				msg += "     * Your Zipcode.\r\n";
			}
			if( form.PrefCity.value == "" )
			{
				msg += "     * Your Prefered City.\r\n";
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
 
 
</head> 
 
 
	
 
 
<body> 
	<div id="wrap"> 
		<link rel="shortcut icon"  href="http://www.tangotab.com/images/TangoT_Icon.ico" /> 
		<div id="fb-root"></div> 
 
 
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
    
	<table style="background-color:#FFF;" width="968" border="0" cellspacing="0" cellpadding="0"> 
 	<tr> 
        <td width="8" height="25" align="center" valign="top" background="http://www.tangotab.com/images/abtgre.jpg"></td> 
 
	</tr>
     <td height="25" align="left" valign="top"><p style="font-size:14px; text-align:left;">TangoTab makes it easy for your organization to raise funds without anyone dipping into their wallets.  Simply, connect your friends, family and colleagues with TangoTab, a free service that provides them with hot deals at their favorite restaurant. <br />
 	    <br />
      </p>
</td>
 	  </tr>
 	<tr>
 	  <td height="25" align="left" valign="top"><p style="color:#e09e09; font-size:16px; line-height:1.75; text-align:left;"><strong>How it works</strong></p></td>
 	  </tr>
 	<tr>
        <td width="968" height="25" align="left" valign="top"><p style="font-size:14px; line-height:1.5; text-align:left;"><img src="images/tick.png" width="16" height="16" align="baseline"> We will email you a unique link when you sign up for the fundraising program<br>
  <img src="images/tick.png" width="16" height="16" align="baseline"> Ask each parent or caregiver to register for TangoTab using your unique fundraising link <br>
    <img src="images/tick.png" width="16" height="16" align="baseline"> Your recruits become ambassadors to your cause and continue to recruit their friends and family
    <br>
   <img src="images/tick.png" width="16" height="16" align="baseline"> TangoTab will provide your organization with funds based on the number of registered members and their dining reservations though TangoTab. 
        <br />
        <br />
        </p>
 
</td>
 
 	<tr> 
        <td height="15" align="center" valign="top"><table width="600" border="0">
          <tr>
            <td align="center"><p class="gre_max">Sign up!<br /><br /></td>
            
          </tr>
        </table> 
		
		
		
			

		</tr> 
			<tr> 
				<td colspan="3" align="center" valign="top" class="strong"> 
					It's easy! Please provide your name and email address:
					
				      <form action="ewomensignup.jsp" method="post" name="RegistrationForm" onSubmit="return validateForm();" >
				    <br>
					<table cellspacing="10" border="0"> 
					  <tr> 
							<td align="right" class="strong">First Name:
					</td> 
							<td align="left"> 
								<input type="text" name="FirstName" id="FirstName" maxlength="50" tabindex="3" style="width:150px;"> 
							</td> 
							<td align="right" class="strong"> 
								Last Name:
							</td> 
							<td align="left"> 
								<input type="text" name="LastName" id="LastName" maxlength="50" style="width:150px;" tabindex="4"> 
							</td> 
						</tr> 
						<tr> 
							<td align="right" class="strong"> 
								Email:
							</td> 
							<td align="left"> 
								<input type="text" name="Email" id="Email" maxlength="50" style="width:150px;" tabindex="5"> 
							</td> 
							<td align="right" class="strong">Zip:</td> 
							<td align="left"> 
								<input type="text" name="Zip" id="Zip" maxlength="50" style="width:150px;" tabindex="6"> 
							</td> 
						</tr> 
						<tr> 
							<td align="right" class="strong"> 
								Preferred City:
							</td> 
							<td align="left"> 
								<input type="text" name="PrefCity" id="PrefCity" maxlength="50" style="width:150px;" tabindex="7"> 
							</td> 
							<td align="right" class="strong"> 
								Phone Number:
							</td> 
							<td align="left"> 
								<input type="text" name="Phone" id="Phone" maxlength="50" style="width:150px;" tabindex="8"> 
							</td> 
						</tr> 
		  				<tr> 
							<td align="center" colspan="4"> <br>
								<input type="submit" value="Submit">
							</td> 
						</tr> 
						
					</table> 
					
					
					 
					</form> 
					
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
			Copyright © 2000-2011 TangoTab.com All rights reserved.
		</div> 
 
</div> 
 
 
<div style="clear:both;"></div> 
</div> 
</body> 
</html> 
