<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml" xml:lang="en" lang="en">
<head> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/util.css" rel="stylesheet" type="text/css"/>
	
  
	<fmt:setBundle basename="tangotab"></fmt:setBundle>


<title>TangoTab</title>
<script src="../js/jquery-1.js" type="text/javascript"></script>
<link href="css/style2.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="http://www.tangotab.com/images/TangoT_Icon.ico"> 
<meta name="viewport" content="width=device-width;minimum-scale=0.5,maximum-scale=1.0; user-scalable=1;" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>
          
          
          
          
          
          <script>
          

/*!
Intelligent auto-scrolling to hide the mobile device address bar
Optic Swerve, opticswerve.com
Documented at http://menacingcloud.com/?c=iPhoneAddressBar
*/

var bodyTag;
var executionTime = new Date().getTime(); // JavaScript execution time

// Document ready
//----------------
documentReady(function() {
      // Don't hide address bar after a distracting amount of time
      var readyTime = new Date().getTime()
      if((readyTime - executionTime) < 3000) hideAddressBar(true);

});

// Run specified function when document is ready (HTML5)
//------------------------------------------------------
function documentReady(readyFunction) {
      document.addEventListener('DOMContentLoaded', function() {
            document.removeEventListener('DOMContentLoaded', arguments.callee, false);
            readyFunction();

      }, false);

}

// Hide address bar on devices like the iPhone
//---------------------------------------------
function hideAddressBar(bPad) {

      // Big screen. Fixed chrome likely.
      if(screen.width > 980 || screen.height > 980) return;

      // Standalone (full screen webapp) mode
      if(window.navigator.standalone === true) return;

      // Page zoom or vertical scrollbars
      if(window.innerWidth !== document.documentElement.clientWidth) {
            // Sometimes one pixel too much. Compensate.
            if((window.innerWidth - 1) !== document.documentElement.clientWidth) return;

      }

      // Pad content if necessary.
      if(bPad === true && (document.documentElement.scrollHeight <= document.documentElement.clientHeight)) {
            // Extend body height to overflow and cause scrolling
            bodyTag = document.getElementsByTagName('body')[0];

            // Viewport height at fullscreen
            bodyTag.style.height = document.documentElement.clientWidth / screen.width * screen.height + 'px';

      }

      setTimeout(function() {
            // Already scrolled?
            if(window.pageYOffset !== 0) return;

            // Perform autoscroll
            window.scrollTo(0, 1);

            // Reset body height and scroll
            if(bodyTag !== undefined) bodyTag.style.height = window.innerHeight + 'px';
            window.scrollTo(0, 0);

      }, 1000);

}

// Quick address bar hide on devices like the iPhone
//---------------------------------------------------
function quickHideAddressBar() {

      setTimeout(function() {
            if(window.pageYOffset !== 0) return;
            window.scrollTo(0, window.pageYOffset + 1);

      }, 1000);

}
</script>
          
<script type="text/javascript">
function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
{
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    document.getElementById("refferCode").value = y*1;
    //alert(document.getElementById("refferCode").value);
    return unescape(y);
    }
  }
}
</script>

		<script type="text/javascript">
		
		function Onsubmit(){
	
		document.forms[0].action = "<fmt:message key='website.home' ></fmt:message>jsp/search.do";
			 	document.forms[0].submit();
		
		}
		
function display(){
var ua = navigator.userAgent;
quickHideAddressBar();
hideAddressBar(bPad);

var checker = {

  iphone: ua.match(/(iPhone|iPod|iPad)/),
  blackberry: ua.match(/BlackBerry/),
  android: ua.match(/Android/)  
};

 if(ua.indexOf('NT') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=1024, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='web';
   }else  if(ua.indexOf('iPhone') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='iPhone';
   }else  if(ua.indexOf('iPod') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='iPod';
   }else  if(ua.indexOf('iPad') != -1){
   document.getElementById('device').value='iPad';
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=768, initial-scale=1, maximum-scale=1">';
   }else  if(ua.indexOf('Android') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1"><link href="css/stylesold.css" rel="stylesheet" type="text/css" />';
   document.getElementById('device').value='Android';
   }else 
   {
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }
   //alert(document.getElementById('device').value);

}
</script>
<script type="text/javascript">
$(document).ready(function(){
 var  placeHolderSupport;
  placeHolderSupport = ("placeholder" in document.createElement('input'));
 //alert(placeHolderSupport);
if( !placeHolderSupport )
{   
   $('[placeholder]').focus(function() {
	  var input = $(this);
	  if (input.val() == input.attr('placeholder')) {
	   	input.val('');
		input.removeClass('placeholder');
  }
 }).blur(function() {
  var input = $(this);
  if (input.val() == '' || input.val() == input.attr('placeholder')) {
    input.addClass('placeholder');
    input.val(input.attr('placeholder'));
  }
 }).blur().parents('form').submit(function() {
  $(this).find('[placeholder]').each(function() {
    var input = $(this);
    if (input.val() == input.attr('placeholder')) {
      input.val('');
    }
  })
});


	
}
})
</script>

<style type="text/css">  
        *{  
            background:url(../images/search_bg@2x.png) no-repeat;
            margin:0;  
            padding:0;  
            font:"Lucida Grande", Arial, sans-serif;  
        }  
        body {  
            padding: 10px;  
        }  
        #status{  
            width:50%;  
            padding:10px;  
            outline:none;  
            height:36px;  
        }  
         .focusField{  
             
             
            color:#000;  
        }  
        .idleField{             
            color: #666;  
            
        }  
       
}
    </style>  
    <script>
        $(document).ready(function() {  
        $('input[type="text"]').addClass("idleField");  
        $('input[type="text"]').focus(function() {  
            $(this).removeClass("idleField").addClass("focusField");  
            if (this.value == this.defaultValue){  
                this.value = '';  
            }  
            if(this.value != this.defaultValue){  
                this.select();  
            }  
        });  
        $('input[type="text"]').blur(function() {  
            $(this).removeClass("focusField").addClass("idleField");  
            if ($.trim(this.value == '')){  
                this.value = (this.defaultValue ? this.defaultValue : '');  
            }  
        });  
    });  
    </script>
      
   

</head>
<body  onLoad="display()">
<div id="fb-root">
</div>

      <script>
      
       
        window.fbAsyncInit = function() {
        
          FB.init({
            appId      : '<fmt:message key="facebook.appid"></fmt:message>', // App ID
            channelUrl :  '<fmt:message key='website.home'></fmt:message>/channel.html', // Channel File
            status     : true, // check login status
            cookie     : true, // enable cookies to allow the server to access the session
            xfbml      : true  // parse XFBML
            
          });
                  };
      
     (function(d){
         
           var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
           if (d.getElementById(id)) {return;}
           js = d.createElement('script'); js.id = id; js.async = true;
           js.src = "//connect.facebook.net/en_US/all.js";
           ref.parentNode.insertBefore(js, ref);
           
          }(document));
    
       
       
      </script>
 
    
      
      

      
<div class="cantainer" >
  <html:form  method="post" action="/jsp/search" >
    <table width="640" border="0" cellspacing="0" cellpadding="0">
      <tbody>
        <tr>
          <td align="center" valign="top" class="landing_page_bg" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                  <td height="245">&nbsp;</td>
              </tr>
              <tr>
                  <td align="center" ><a href="<fmt:message key='website.home'></fmt:message>jsp/searchForward.do"><img src="images/free_restaurant.png" border="0" /></a></td>
              </tr>
              <tr>
                  <td height="22" >&nbsp;</td>
              </tr>
              <tr>
                  <td  align="center"><a  href='<fmt:message key="website.home"></fmt:message>jsp/charity.jsp' ><img src="images/great_cause.png" border="0" /></a></td>
              </tr>
              <tr>
                  <td height="153" >&nbsp;</td>
              </tr>
              
                  <tr>
                <td height="79" align="center">
                <div id="button"  style="float:left;">
				<div style="float;padding-left:20px;">
				</div></div>																									
			    
       
     
<div style="position: absolute; top: -10000px; height: 0px; width: 0px;">
</div>



 <script src="https://ssl.google-analytics.com/ga.js" type="text/javascript"></script>
    <script type="text/javascript">
      try {
        var pageTracker = _gat._getTracker('UA-2322480-5');
        pageTracker._trackPageview();
        pageTracker._trackPageLoadTime();
      } catch(err) {}
    </script>
      	
	

  
     <img src="images/facebook_sigin@2x.png" onclick="authUser();" />
 
      </td>
                                          </tr>
                                          
                 <tr>
                <td height="31" align="center"><img src="images/or.png"  /><br /></td>
              </tr>
                        
                            
              <tr>
                <td height="86" align="center"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="18">&nbsp;</td>
                      <td><a href="<fmt:message key='website.home' ></fmt:message>mobile/signup/index.jsp"><img src="images/sign_up@2x.png" border="0"  /></a></td>
                      <td width="18">&nbsp;</td>
                      <td><a href="<fmt:message key='website.home' ></fmt:message>jsp/login.jsp"><img src="images/sign_in@2x.png"  border="0" /></a></td>
                      <td width="18">&nbsp;</td>
                    </tr>
                  </table></td>
              </tr>
                <tr>
                <td height="12"></td>
              </tr>
            </table></td>
        </tr>
        
        <tr>
          <td align="center"  class="landing_search_bg"  ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20">&nbsp;</td>
                <td width="446"><label for="textfield" ></label>
                
                 <input type="text" name="zipCode" id="zipCode" class="land_search_input" placeholder="Enter City, State or ZipCode"  /></td>
                <td width="20">&nbsp;</td>
                <td><a href="#" onclick="Onsubmit();"><img src="images/find_deals@2x.png" border="0" /></a></td>
                <td width="20">&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </tbody>
    </table>
  </html:form>
</div>
     <script> 
       
       
  // Check if the current user is logged in and has authorized the app
     // FB.getLoginStatus(checkLoginStatus);
      
      // Login in the current user via Facebook and ask for email permission
      function authUser() {
     
             FB.login(checkLoginStatus, {scope:'email,user_likes,user_birthday,user_location,user_checkins,offline_access,publish_stream'});
       
      }
                     
      
      // Check the result of the user status and display login button if necessary
      function checkLoginStatus(response) {
           
        if(response && response.status == 'connected') {
         // alert('User is authorized');
          // Now Personalize the User Experience
          var uid = response.authResponse.userID;
          var accessToken = response.authResponse.accessToken;
          var signedRequest = response.authResponse.signedRequest;
      
	      FB.api(
           {
                method: 'fql.query',
                query: 'SELECT name,email,sex,current_location FROM user WHERE uid='+uid
           },
        function(response) {
          //alert(response[0].name);
		  email= response[0].email;
		  fullname = response[0].name;
		  gen = response[0].sex;		  
		  country=response[0].current_location.country;
		  state=response[0].current_location.state;
		  city =response[0].current_location.city;
          window.location='<fmt:message key="website.home" ></fmt:message>jsp/fblogin.do?email='+email+'&fullname='+fullname+'&gen='+gen+'&city='+city+'&state='+state+'&country='+country+'&signedRequest='+signedRequest;
	
    }

  );
          
        } else {
          
          
          // Display the login button
          document.getElementById('loginButton').style.display = 'block';
        }
      }
    </script>
   
</body>
</html>
	