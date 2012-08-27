<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<html>
	<head>
	<fmt:setBundle basename="tangotab"></fmt:setBundle>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		
<link rel="shortcut icon" href="<fmt:message key="website.home"></fmt:message>images/TangoT_Icon.ico" />
		
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

quickHideAddressBar();
hideAddressBar(bPad);

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
		function validateEmail(form_id,email) {
 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   var address = document.forms[form_id].elements[email].value;
   if(reg.test(address) == false) {
 	return "Invalid Email Address";
   
   
   }return "";
} 
		

		 function Onsubmit1(){
	
			
				//	document.getElementById("pwd").innerHTML = "";
				var form = document.userForm;
					
			var msg = "";
			var s=validateEmail('userForm','emailId');
		
	 		if( form.firstname.value == "" ||  form.firstname.value == "First Name" )
			{
				msg += "     * Your  Name.\r\n";
			}
				
			if( form.emailId.value == "" || form.emailId.value == "Email" )
			{
				msg += "     * Your Email Address.\r\n";
			}else if(s!="")
			{
				msg += "       "+s+"\r\n";
			 
			
			}
			if( form.zipCode.value == "" || form.zipCode.value == "Zip Code"  )
			{
				msg += "     * Your Zipcode.\r\n";
			}
	
			if( form.password.value == "" || form.password.value == "Password" )
			{
				msg += "     * Your Password.\r\n";
			}
			
 
			
			if( form.password.value.length <6  )
			{
				msg += "     * Your Password length can't be less than 6.\r\n";
			}
		 
		 
			if( form.emailId.value != ""  && form.emailIdexists.value == 1 )
			{
				msg += "     * Your Email Address is already exists.\r\n";
			}
			 
			if(form.agree.checked==false)
			{
					msg += "     * Please accept the Privacy Policy and User Agreement";
					}
		 
			if( !msg == "" )
			{
				alert( "Please provide the following required information\r\n" + msg );
				return false;
			}
			else
			{
			 
				//document.RegistrationForm.submit();
			 
			 
					 document.forms[0].action = "../../jsp/loginReg.do?type=consumer";
			 	document.forms[0].submit();
							 
				}
		
			
		
			}
			
			function checkEmail(roleId,emailId){

		var emailId = dwr.util.getValue("emailId");
		 	 
		if(emailId!=null && emailId.trim()!=""){
			deal.checkUserAvailability( emailId,roleId,function(data) {
	 
			    	if(data==true){
			    	//	document.getElementById("checkEmailId").innerHTML="";
			    		document.userForm.emailIdexists.value=1;
			    	//	document.getElementById("checkEmailId").innerHTML="Email already exists";
			    	}else{
			    	document.userForm.emailIdexists.value=0;
			    	//	document.getElementById("checkEmailId").innerHTML="";
			    	}
			 });	
		} 
}
 //window.resizeTo(400,600);
		</script>
		
	
<script type="text/javascript">
 
function StrPassword(arg_password, arg_spc_chars)
{
    var password = arg_password;
    var spc_chars = arg_spc_chars;
    this.lcase_count = 0;
    this.ucase_count = 0;
    this.num_count = 0;
    this.schar_count = 0;
    this.length = 0;
    this.strength = 0;
    this.runs_score = 0;
    this.verdict = '';

      var verdict_conv = {'medium':10, 'strong':30, 'toostrong':90};
 
    var flc = 1.0;  // lowercase factor
    var fuc = 1.0;  // uppercase factor
    var fnm = 1.3;  // number factor
    var fsc = 1.5;  // special char factor

    this.getStrength = function()
    {
        if ((this.run_score = this.detectRuns()) <= 1)
        {
            return "    Weak   ";
        }

        var regex_sc = new RegExp('['+spc_chars+']', 'g');

        this.lcase_count = password.match(/[a-z]/g);
        this.lcase_count = (this.lcase_count) ? this.lcase_count.length : 0;
        this.ucase_count = password.match(/[A-Z]/g);
        this.ucase_count = (this.ucase_count) ? this.ucase_count.length : 0;
        this.num_count   = password.match(/[0-9]/g);
        this.num_count   = (this.num_count) ? this.num_count.length : 0;
        this.schar_count = password.match(regex_sc);
        this.schar_count = (this.schar_count) ? this.schar_count.length : 0;
        this.length = password.length;

        var avg = this.length / 4;
   this.strength = ((this.lcase_count * flc + 1) * 
                         (this.ucase_count * fuc + 1) *
                         (this.num_count * fnm + 1) * 
                         (this.schar_count * fsc + 1)) / (avg + 1);

        if (this.strength > verdict_conv.toostrong)
            this.verdict = '&nbsp;&nbsp;&nbsp;     Too Strong &nbsp;&nbsp;&nbsp;      ';
        else if (this.strength > verdict_conv.strong)
            this.verdict = '&nbsp;&nbsp;&nbsp;       Strong &nbsp;&nbsp;&nbsp;';
        else if (this.strength > verdict_conv.medium)
            this.verdict = '&nbsp;&nbsp;&nbsp;    Medium &nbsp;&nbsp;&nbsp;';
        else
            this.verdict = "&nbsp;&nbsp;&nbsp; Weak &nbsp;&nbsp;&nbsp; ";

        return this.verdict;
    }
  this.detectRuns = function()
    {
        var parts = password.split('');
        var ords = new Array();
        for (i in parts)
        {
            ords[i] = parts[i].charCodeAt(0);
        }

        var accum = 0;
        var lasti = ords.length-1

        for (var i=0; i < lasti; ++i)
        {
            accum += Math.abs(ords[i] - ords[i+1]);
        }

        return accum/lasti;
    }


    this.toString = function()
    {
        return 'lcase: '+this.lcase_count+
               ' -- ucase: '+this.ucase_count+
               ' -- nums: '+this.num_count+
               ' -- schar: '+this.schar_count+
               ' -- strength: '+this.strength+
               ' -- verdict: '+this.verdict;
    }
}

function checkPassword(id)
{
    var special_chars = "~!@#$%&*";

    var pw = "";
    pw=new StrPassword(id.value, 
                           special_chars);

    var verdict = pw.getStrength();
   //alert(id.value.length);
    element = document.getElementById("strength");
    if(id.value.length>0)
    element.innerHTML = verdict;
			}
			
	function delete_cookie ( cookie_name )
		{
		  var cookie_date = new Date ( );  // current date & time
		  cookie_date.setTime ( cookie_date.getTime() - 1 );
		  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
		}		
			
			
			
		</script>
		<script type="text/javascript">
function display(){
var ua = navigator.userAgent;

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
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='Android';
   }else 
   {
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }
   //alert(document.getElementById('device').value);

}

</script>
<span id="metatag"></span>
	</head>
	
	<body onLoad="display()">

<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td align="center" valign="top" scope="row"><div class="cantainer">
 <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
	  <table width="320" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" valign="top" scope="row">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr><td><table><tr>
          <td width="50%" align="left" valign="top" scope="row"><img src="images/logo.png" alt="Tangotab" width="160" height="71" class="padding1" /></td>
          <td width="50%" align="left" valign="bottom">
          <table width="100%" border="0">
             <tr>
                <td align="left" valign="top" scope="row" class="text1">FREE DINING SERVICE </td>
              </tr>
              <tr>
                <td align="left" valign="top" class="text1" scope="row">FREE OFFERS </td>
              </tr>
              <tr>
                <td align="left" valign="top" class="text2" scope="row">GREAT CAUSE</td>

              </tr>
          </table>
          </td>
          </tr></table></td></tr>
              <tr>
                <input type="hidden" name="device" id="device" value="other" />
                
              </tr>
              

              
              <tr>
                <td height="10" align="center" valign="top" scope="row"></td>
              </tr>
              <tr>
                <td height="45" align="center" valign="top" class="" scope="row">
                <html:text property="firstname" 	styleClass="text_box" styleId="firstName" value="First Name" onclick="this.value=((this.value=='First Name')?'':this.value);" onfocus="this.select()" onblur="this.value=!this.value?'First Name':this.value;"  ></html:text> 
               </td>
              </tr>
             <!--  <tr>
                <td height="45" align="center" valign="top" class="" scope="row">
                 <html:text property="lastname" value="Last Name"	styleClass="text_box" styleId="lastName"  onfocus="this.select()" onblur="this.value=!this.value?'Last Name':this.value;" onclick="this.value=((this.value=='Last Name')?'':this.value);"     ></html:text>
                </td>

              </tr> -->
              <tr>
                <td height="45" align="center" valign="top" class="" scope="row">
               <html:text property="emailId" onfocus="this.select()" styleClass="text_box" onblur="this.value=!this.value?'Email':this.value;checkEmail(4,this.value)" value="Email"  styleId="emailId"   onclick="this.value=((this.value=='Email')?'':this.value);"   ></html:text> 
			      <input type="hidden" name="emailIdexists"	 id="emailIdexists" />    
                </td>
              </tr>
              <tr>
                <td height="45" align="center" valign="top" class="" scope="row">
               <html:password property="password"   styleId="password"	styleClass="text_box"  value="Password"   onfocus="this.select()" onblur="this.value=!this.value?'Password':this.value;" onclick="this.value=((this.value=='Password')?'':this.value);"   >  </html:password>
												
                 </td>
              </tr>
              <tr>
                <td height="45" align="center" valign="top" class="" scope="row">
                <html:text property="zipCode"  styleClass="text_box" maxlength="6" styleId="zipCodeID"  onfocus="this.select()" onblur="this.value=!this.value?'Zip Code':this.value;" value="Zip Code" onclick="this.value=((this.value=='Zip Code')?'':this.value);"    ></html:text>
												
                </td>

              </tr>
              <tr>
                <td height="10" align="center" valign="top" class="" scope="row"></td>
              </tr>
              <tr>
                <td align="center" valign="top" class="" scope="row"><table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="11%" align="center" valign="middle" scope="row">
                      <input type="checkbox" name="agree" id="agree"  checked="checked"/></td>
                      <td width="89%" align="left" valign="top" class="text3" scope="row">By checking and pressing Sign Up, I certify I have read and agree to the 
					  <span class="text4">
					  <a href='<fmt:message key="website.home"></fmt:message>jsp/privacy_policy.jsp' target="_blank">privacy policy</a></span> and <span class="text4">
					  <a href='<fmt:message key="website.home"></fmt:message>jsp/terms.jsp' target="_blank">terms of use</a></span> of TangoTab </td>

                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="10" align="center" valign="top" class="" scope="row"></td>
              </tr>
              <tr>
                <td align="center" valign="top" class="" scope="row"><a href="#" onclick="Onsubmit1();"><img src="images/signup_btn.png" alt="Sign Up" border="0"></a></td>
              </tr>

              <tr>
                <td height="30" align="center" valign="top" class="" scope="row"></td>
              </tr>
              <tr>
                <td height="8" align="center" valign="top" class="line_img" scope="row"></td>
              </tr>
            <!--  <tr>
                <td align="center" valign="top" class="" scope="row"><table width="300" border="0" cellspacing="0" cellpadding="0">
                    <tr>

                      <td align="left" valign="top" scope="row"><span class="text3"><% DateFormat df=new SimpleDateFormat("EEEE, MMMM dd, yyyy");  %>
                      <%= df.format(new Date()) %>
 </span></td>
                    </tr>-->
                </table></td>
              </tr>
              <tr>
                <td align="center" valign="top" scope="row">&nbsp;</td>
              </tr>
          </table>
          </html:form>
	</div>
    </td>

        </tr>
      </table>
      
  
</body>
	
</html>