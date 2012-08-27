
<%@page import="com.tangotab.geo.GeoLocationUtility"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>

<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 


<html>
	<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="Tango Tab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>TangoTab</title>
	
	
	<link href="http://www.tangotab.com/css/tangotab.css" rel="stylesheet" type="text/css" /> 
	<!-- <link href="http://www.tangotab.com//css/restyle.css" rel="stylesheet" type="text/css" />  -->
	<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/ddsmoothmenuup.css" />
	
	<link href="http://www.tangotab.com/css/restyle.css" rel="stylesheet" type="text/css" />
	

	<style>
		body{ margin:0px; padding:0px; background:#000000; font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif; color:#ffffff;}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		#wrap{ margin:0px auto; padding:0px; width:967px; clear:both;}

		
		.normalwhite 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; }
		.normalgreen 	{ font-family:Arial, Helvetica, sans-serif; color:#7d9b17; font-size:12px; }
		.normalorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:12px; }
		
		.mediumorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:14px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:40px; padding-left:100px;  }
		
		.white_text		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:16px; line-height:22px; font-weight:bold; }
		
		.left_border 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; border-right:5px solid #f8a657; }
		
	</style>
	
<div id="fb-root">
</div>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	
	<script type="text/javascript" src="http://localhost:8080/TangoTab/js/ddsmoothmenu.js"></script>
	
<script type="text/javascript">
$.noConflict();
ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", //menu DIV id
	orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

ddsmoothmenu.init({
	mainmenuid: "smoothmenu2", //Menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
	//customtheme: ["#804000", "#482400"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>


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
function validate(form_id,email) {
 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   var address = document.forms[form_id].elements[email].value;
   if(reg.test(address) == false) {
 	return "Invalid Email Address";
   
   
   }return "";
}
  			function signup()
        	      {
                                if(document.homeform.Email.value=='Email Address' || document.homeform.Email.value=='')
                                {
                             	   document.homeform.action="signup.jsp";
	                                document.homeform.submit();
	                          
                                }
                                else if(document.homeform.Email.value!='Email Address')
                                {
                              	  var s=validate('homeform','Email');
	                                if(s=='')
	                                {
	                                       document.homeform.action="signup.jsp";
	                              		  document.homeform.submit();
	                              	  return true;
	                                }else {
	                                
	                              	  alert(s);
	                                return false;
	                                }
                                }
                        }
						
</script>
	<link rel="shortcut icon" href="http://tangotab.com/images/TangoT_Icon.ico" />
<div id="fb-root">
</div>
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
					
					<a href="http://www.tangotab.com/jsp/login.jsp" class="mediumwhite" style="text-decoration:none;">Sign In</a>
					
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/consumer_registration.jsp" class="mediumwhite" style="text-decoration:none;">Sign Up</a>
										
				</td>
			</tr>
			<tr>
				<td bgcolor="#000000" align="right" valign="bottom" class="normalwhite">
				
					 
					<a href="http://www.tangotab.com/jsp/search.do" class="normalwhite" style="text-decoration:none;">
						Search Restaurants 
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/how_it_works.jsp" class="normalwhite" style="text-decoration:none;">
						How to Tango
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a href="referfriends.jsp" class="normalwhite" style="text-decoration:none;">
						Share
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/charity.jsp" class="normalwhite" style="text-decoration:none;">
						Our Movement
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a href="http://www.tangotabloid.com" class="normalwhite" style="text-decoration:none;">
					   Blog
					</a>
					
				</td>
			</tr>
			</table>

		</td>
	</tr>
	</table>

	<!------------------------------ END HEADER ------------------------------>








	<!------------------------------ START BODY ------------------------------>
	          <form name="homeform" method="post" action="signup.jsp" onsubmit="return signup();">
	<table width="967" border="0" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td height="794" valign="top" background="images/jaris_wynn.jpg">
        <table width="98%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="10" align="left" valign="top"></td>
          </tr>
          <tr>
            <td height="250" align="left" valign="top" class="white_text">Each time you dine with TangoTab, we provide a meal <br>
            to a hungry person through local and national food banks</td>
          </tr>

            <tr>
           
            <td align="left" valign="middle"><table width="68%" border="0">

              <tr>
                <td align="right" valign="middle"><table width="60%" border="0">
                  <tr>
                 
                    <td width="49%" rowspan="3" align="left" valign="top">
                    <table width="100%" border="0" cellpadding="2" cellspacing="10">
                      <tr>
                        <td><input name="cityName" type="text"  class="restaurant_input" id="cityName" size="18"  maxlength="50"></td>
                      </tr>
                      <tr>
                        <td height="10"></td>
                      </tr>
                      <tr>
                        <td><input name="Email" type="text"  value="Email Address"  class="restaurant_input" id="Email" size="18"  maxlength="50"></td>
                      </tr>
                    </table></td>
                    
                    <td width="51%" align="left" valign="top"><a  href="javascript:signup();"  ><img src="images/signup_bt.png" width="193" height="44" border="0"></a></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="72" align="left" valign="top"><a href="http://www.tangotab.com/jsp/mobileapps.jsp"><img src="images/gettheapp.png" width="185" height="67" border="0"></a></td>
                  </tr>
                  
                </table></td>
              </tr>
              <tr><td>&nbsp;</td></tr>
              <tr>
                <td height="67" > 
                    <div style="float:left; padding-left: 275px;">&nbsp;
                    </div> 
              <div style="float:left; padding-left: 15px;">
		      
         
			<div id="facebook_like">
				<fb:like href='<fmt:message key="facebook.frontpage.url"></fmt:message>' show_faces="false" layout="button_count" width="0" colorscheme="light"></fb:like>
	</div>
</div>
<div style="float:left; padding: 15;">
	 
       <div id="tweet_like">
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div>
</div>
<div style="float:left; padding: 15;">
 
<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>
<script type="IN/Share"></script>
     
       
     
		 </div></td>
              </tr>
              
            </table></td>
          </tr>
          <tr>
          <td height="50">&nbsp;</td>
          </tr>
 
             <tr>
				<td width="100%" height="226" align="right" valign="top" colspan="2">
              <img src="../images/whatthis_img1.png" width="562" height="226" border="0" usemap="#Map" /></td></tr>
        </table></td>
      </tr>
      
    </table>
  <!------------------------------ START FOOTER ------------------------------>
	</form>
	<table>
	<tr> <td></td>
	</tr>
	</table>
	

	<%@ include file="jayfooter.jsp" %> 
	     
<% 
String ipAddress=request.getRemoteAddr();
String city=GeoLocationUtility.getCityUsingTempAPI(ipAddress);
	 
%>
<script>document.getElementById("cityName").value='<%=city%>';</script>
</div>
<map name="Map" id="Map">
  <area shape="rect" coords="431,34,513,80" href="signup.jsp" />
<area shape="rect" coords="6,129,183,167" href="http://www.tangotab.com/jsp/charity.jsp" />
</map>
</body>

</html>
