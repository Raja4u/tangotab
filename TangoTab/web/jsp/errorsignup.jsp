<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="TangoTab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>

<title> TangoTab </title> 
 
<link href="<fmt:message key='website.home'></fmt:message>/css/restyle.css" rel="stylesheet" type="text/css" />

<script src="<fmt:message key='website.home'></fmt:message>/js/jquery-1.js" type="text/javascript"></script>
<script src="<fmt:message key='website.home'></fmt:message>/js/jquery_003.js" type="text/javascript"></script>
<script src="<fmt:message key='website.home'></fmt:message>/js/jquery_002.js" type="text/javascript" charset="utf-8"></script>
<script src="<fmt:message key='website.home'></fmt:message>/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="<fmt:message key='website.home'></fmt:message>/js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script src="<fmt:message key='website.home'></fmt:message>/js/geolocator.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		checkUserAgent();
function checkUserAgent(){
var ua = navigator.userAgent;

var checker = {
  iphone: ua.match(/(iPhone|iPod|iPad)/),
  blackberry: ua.match(/BlackBerry/),
  android: ua.match(/Android/)  
};
 if(ua.indexOf('iPhone') != -1 || ua.indexOf('iPod') != -1  
	|| ua.indexOf('BlackBerry') != -1 || ua.indexOf('Android') != -1 || ua.indexOf('RIM') != -1)
	{
     window.location='<fmt:message key="website.home"></fmt:message>mobile'+'${errorPath}';
   //window.location="http://www.tangotab.com/mobile/fb1/";
  // document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }


}

</script>

<style>
		body{
	margin:0px;
	padding:0px;
	font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif;
	color:#ffffff;
	background-repeat: no-repeat;
}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		.normalwht 	{ font-family:Arial, Helvetica, sans-serif; color:#fff; font-size:12px;  }
		.normalwht2 	{ font-family:Arial, Helvetica, sans-serif; color:#fff; font-size:12px; text-decoration:underline;  }


.text_box{
margin:0px;
padding:4px;
font-size:13px;
width:230px;
height:16px;
border:1px solid #a2abae;
}
.red_max_home {
	font-family: "Century Gothic", Arial, Helvetica, sans-serif;
	font-size: 40px;
	font-style: normal;
	color: #e46c0e;
	text-decoration: none;
	font-weight: 600;
	text-align:center;
	

}

#password-clear {
	    display: none;
	    color:#aaa;
}	
input.placeholder{
color:#aaa;
}
#Layer2 {
      position: relative ; 
      left:0px;
      top:40px;
      width:335px;
      height:102px;
      z-index:5;
}

    </style>

<!-- 

<script src="../js/coda-slider.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
 -->
<!-- <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" /> -->

<fmt:setBundle basename="tangotab"></fmt:setBundle>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
 <script type="text/javascript">
$(document).ready(function(){
 var  placeHolderSupport;
  placeHolderSupport = ("placeholder" in document.createElement('input'));
      
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

$('#password-clear').show();
	$('#password-password').hide();
	 
	$('#password-clear').focus(function() {
	    $('#password-clear').hide();
	    $('#password-password').show();
	    $('#password-password').focus();
	});
	$('#password-password').blur(function() {
	    if($('#password-password').val() == '') {
	        $('#password-clear').show();
	        $('#password-password').hide();
	    }
	});
	
}
})
</script>
	<script type="text/javascript" language="javascript">
	var emailId='';
	//alert(emailId);
function getLoginCookie()
{
var cookieFound = false;
var i,x,y,ARRcookies=document.cookie.split(";");
 
    //alert(ARRcookies[0]);
    /* If cookies found then only search for tangouser id and password */
    if(ARRcookies.length > 1){
	for (i=0;i<ARRcookies.length;i++)
	  {
	  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
	  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
	  x=x.replace(/^\s+|\s+$/g,"");
	 
              // remove double quotes
              
 
			   if(x!='JSESSIONID' && emailId=="" )
			   {
			    var email=x.split("::");
			    
			    if(y.indexOf(",")!= -1){
			      y = y.substring(1,y.length-1);
			      var details = y.split(",");
			    }
			    
			    if(email.length>1)
			    {
			//	document.loginForm.rememberme.checked=true;
			//	 alert(email[1]);
			    document.loginForm.emailId.value=email[1];
			
			//	 alert(y);
			     if(y.indexOf(",")!= -1){
				 document.loginForm.password.value=details[0];
						      document.loginForm.action="../jsp/login.do";
						   document.loginForm.submit();  
			 //     document.loginForm.password.value=details[0];
			 //alert(details[0]);
			     }else
				 {
						      document.loginForm.password.value=y;
						      document.loginForm.action="../jsp/login.do";
						  
				  }
				  cookieFound = true;
			      break;
			    }
			  }
			  
			
	  }
	  }
	  /* If no cookies found except jession id, then display home page directly */
	  else{
	 		 document.getElementById('wrapper').style.display='block';
           	 document.getElementById('CookieDiv').style.display='none'; 
	  }
	  
	  
	  if(cookieFound){
	  		document.getElementById('CookieDiv').style.display='block';
	  		document.loginForm.submit();   
          
       }
       else{
          	 document.getElementById('wrapper').style.display='block';
           	 document.getElementById('CookieDiv').style.display='none'; 
       }
}
 

 

function trim(s)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not a whitespace, append to returnString.
	
			for (i = 0; i < s.length; i++)
			{   
				// Check that current character isn't whitespace.
				var c = s.charAt(i);
				if (c != " ") returnString += c;
			}
			
    return returnString;
}

function isEmail(str){
	var at="@";
	var dot=".";
	var lat=str.indexOf(at);
	var ldot=str.indexOf(dot);
	var lstr=str.length;

	if(str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
		return false;
	}
	if(str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
		return false;
	}
	if(str.indexOf(" ")!=-1){
		return false;
	}
	if(str.indexOf(at,(lat+1))!=-1){
		return false;
	}
	if(str.indexOf(dot,(lat+2))==-1){
		return false;
	}
	if(str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
		return false;
	}
return true;
}


		 function Onsubmit1(){
	
			
				//	document.getElementById("pwd").innerHTML = "";
				var form = document.userForm;
					
			var msg = "";
			var s=validateEmail('userForm','emailId');
		
	 		if( form.firstname.value == "" ||  form.firstname.value == "First Name" )
			{
				msg += "     * Your First Name.\r\n";
			}
					
			if( form.lastname.value == "" || form.lastname.value == "Last Name" )
			{
				msg += "     * Your Last Name.\r\n";
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
			 
			 document.getElementById("refferedUrl").value=window.location;
					 document.forms[0].action = "<fmt:message key='website.home'></fmt:message>jsp/loginReg.do?type=consumer&";
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
 
function signup()
{
 if(trim(document.getElementById('cityName').value)=='')
   {
			document.getElementById('cityNameerr').innerHTML = '<font color="#FF0000"><b><b>Please Enter City</b></font>';
			document.getElementById('cityName').focus();
			return false;
   }
   document.getElementById('cityNameerr').innerHTML = '';
   
   if(trim(document.getElementById('clEmail').value)=='' || trim(document.getElementById('clEmail').value)=='Email Address')
   {
			document.getElementById('clEmaileerr').innerHTML = '<font color="#FF0000"><b><b>Please Enter email address</b></font>';
			document.getElementById('clEmail').focus();
			return false;
   }
   
   document.getElementById('clEmaileerr').innerHTML = '';
   
  if(isEmail(trim(document.getElementById('clEmail').value))==false)
		{
			document.getElementById('clEmaileerr').innerHTML = '<font color="#FF0000"><b>Please Enter valid email address</b></font>';
			document.getElementById('clEmail').focus();
			return false;
	  } 
   
   else
   {
 
 
	setCookie("emailId",document.getElementById('clEmail').value,100);
	setCookie("cityName",document.getElementById('cityName').value,100);
	document.frm.submit();
}
}
function searchdeals()
{
document.frm.action='searchForward.do';
document.frm.submit();
}

function removevalu()
{
   if(trim(document.getElementById('cityName').value)=="City Name")
   {
      document.getElementById('cityName').value=="";  
   }
   
   
   if(trim(document.getElementById('cityName').value)=="")
   {
      document.getElementById('cityName').value=="City Name";
   }
}

function removevalusec()
{
  
  
   if(document.getElementById("clEmail").value=="Email Address")
   {
   
   
      document.getElementById("clEmail").value="";
   }
   
   if(document.getElementById("clEmail").value=="")
   {
   	
      document.getElementById("clEmail").value="Email Address";
   }
}

function delete_cookie ( cookie_name )
{ 

var emailId = getCookie("emailId");
var cityName = getCookie("cityName");

	if( (emailId!=null && emailId!="") && (cityName!=null && cityName!="") )
     {
	   document.getElementById("loadingimg").style.display="inline";
	      document.getElementById("loadingimg1").style.display="none";
   
        window.location.href = 'search.do?cityName='+cityName;       
     }
        
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
  
  
  
}

/*function setCookie(c_name,value,exdays)
	{
	var exdate=new Date();
	exdays = null;
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString())+"; path=/" ;
	document.cookie=c_name + "=" + c_value;
	//getCookie('landing');
	}*/
function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
{
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  //alert(x);
  if (x==c_name)
    {
    return unescape(y);
    }
  }
}

function getCookieme(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
if(ARRcookies.length > 0){
for (i=(ARRcookies.length-1);i>=0;i++)
{
 
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
   if(x.indexOf(c_name) != -1 ){
        //alert(y);
        return unescape(y);
       
    }
  }
 }
  
} 

function sendToSearch(){
var ck, passwd, cityname, zipcode , urlstring
urlstring = 'search.do?';
ck =  getCookieme('tangotabid::');
//ck = "pwd";
if(ck != null && ck.length > 1) {
 //document.getElementById("loadingimg").style.display="inline";
     ck = ck.substring(1,ck.length-1);
  	 var details = new Array();
  	 details = ck.split(",");
	 //alert( details.length);
	 if(details.length > 0 ){
	   	  passwd = details[0];
	
	 }
	 if(details.length > 1){
	    cityname = details[1];
	    if(cityname.length > 0)
	      urlstring = urlstring+'cityName='+cityname;
	 }
	 if(details.length > 2){
	    zipcode = details[2];
	    if(cityname.length < 1 && zipcode.length > 0)
	       urlstring = urlstring+'zipCode='+zipcode;
	 }

	}
     //alert("in sending:" + passwd +":"+ cityname+":"+ zipcode );
   //  alert(urlstring);
	 window.location.href = urlstring; 
}
//getCookieme('tangotabid::');
 
function validateEmail(form_id,email) {
 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   var address = document.forms[form_id].elements[email].value;
   if(reg.test(address) == false) {
 	return "Invalid Email Address";
   
   
   }return "";
} 

function putFirstName(){
if(document.getElementById('firstName').value == null || document.getElementById('firstName').value == "")
  document.getElementById('firstName').value = 'First Name';
}
function putLastName(){
if(document.getElementById('lastName').value == null || document.getElementById('lastName').value == "")
  document.getElementById('lastName').value = 'Last Name';
}
function putEmailId(){
if(document.getElementById('emailId').value == null || document.getElementById('emailId').value == "")
  document.getElementById('emailId').value = 'Email';
}
function putPassword(){
if(document.getElementById('password').value == null || document.getElementById('password').value == "")
  document.getElementById('password').value = 'Password';
}
function putZipCode(){
if(document.getElementById('zipCodeID').value == null || document.getElementById('zipCodeID').value == "")
  document.getElementById('zipCodeID').value = 'Zip Code'; 
}

function clickedBody(id){
//alert('body'+document.getElementById('formClicked').value);

if(document.getElementById('formClicked').value == "false"){

 putFirstName();
 putLastName();
 putEmailId();
 putPassword();
 putZipCode();
 
  }
  document.getElementById('formClicked').value = "false";
}

function clickedForm(id){
//alert("form"+id);
document.getElementById('formClicked').value = "true";

if(id == 'firstName'){
 //putFirstName();
 putLastName();
 putEmailId();
 putPassword();
 putZipCode();
}

if(id == 'lastName'){
 putFirstName();
// putLastName();
 putEmailId();
 putPassword();
 putZipCode();
}


if(id == 'emailId'){
putFirstName();
 putLastName();
// putEmailId();
 putPassword();
 putZipCode();
}

if(id == 'password'){
putFirstName();
 putLastName();
 putEmailId();
 //putPassword();
 putZipCode();

}

if(id == 'zipCodeID'){
putFirstName();
 putLastName();
 putEmailId();
 putPassword();
 //putZipCode();

}


}

</script>
  
</head> 
 
<body onload="getLoginCookie();setErrUrlCookie();" >


<div class="cantainer_inner" id="CookieDiv" style="display:none;">
   <div class="main_cantainer">
    <div class="cantainer_content">
     <div class="inner_cantainer">

  <div class="main_deal" style="background-color: #000;">
 
<div class="top_header" >
<img src="<fmt:message key='website.home'></fmt:message>images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 

 <div class="content_deal">
  	 
  	 <div class="login_page_main">	

        <table width="100%">
       <tr style="height:50px;">
		  <td style="height:40px;">
		  </td>
		  </tr>
        
		<tr>
		  <td style="height:40px;"  align="center" valign="middle"	class="red_max_home " >
		 Finding Offers Near You... <br/><br/>
		  </td> 
		  </tr>
		  <tr style="height:40px;" align="center" valign="middle"	class=" red_max_home ">
		  <td style="width:40px; height:35px;"><img src="<fmt:message key='website.home'></fmt:message>images/loading-new.gif" alt="loading" border="0px;" style="width:150px; height:16px;" />
		  </td>
		  </tr>
		  <tr style="height:50px;">
		  <td style="height:40px;">
		  </td>
		  </tr>
		  
        
		</table>

	 </div>
	 </div>

<div class="top_bottom">
    <img src="<fmt:message key='website.home'></fmt:message>images/corner_bottom_left.jpg" align="left" /><img src="<fmt:message key='website.home'></fmt:message>images/corner_bottom_right.jpg" align="right" /></div>

</div>

</div>
</div>
</div>
</div>

 
<div id="wrapper" style="display:none;">
  <div id="main"> 
 <!--  header start here -->
		 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!--  <script src="../js/jquery-1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/ddsmoothmenuup.css" /> -->
<link rel="stylesheet" type="text/css"
	href="<fmt:message key='website.home'></fmt:message>css/ddsmoothmenuplain.css" />

<script src="<fmt:message key='website.home'></fmt:message>js/sendmail.js" type="text/javascript" charset="utf-8"></script>

<link rel="shortcut icon" href="<fmt:message key='website.home'></fmt:message>images/TangoT_Icon.ico" />
<div id="fb-root">
</div>
<script type="text/javascript">
                      window.fbAsyncInit = function(){
                                    FB.init({
                                        appId: '<fmt:message key="facebook.appid"></fmt:message>',
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

function delete_cookie_logindetails(cookiename){
                                
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
  {
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  //alert(x);
  //alert(y);
  if(x.indexOf(cookiename) != -1 ){
  //alert('matched'+ i);
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  var c_value=escape(y) + ("; expires="+cookie_date.toUTCString())+"; path=/" ;
  document.cookie = x + "=" + c_value; 
  }
  }
}
						
</script>
<script type="text/javascript">

function setCookie(c_name,value,exdays)
	{
	var exdate=new Date();
	exdays = null;
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString())+"; path=/" ;
	document.cookie=c_name + "=" + c_value;
	//getCookie('landing');
	if(document.getElementById("refferCode") != null){
		document.getElementById("refferCode").value = value;
		//alert(document.getElementById("refferCode").value);
	}
	}
</script>
<script src="<fmt:message key='website.home'></fmt:message>js/jquery-1.js" type="text/javascript"></script>
<script src="<fmt:message key='website.home'></fmt:message>js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<fmt:message key='website.home'></fmt:message>js/ddsmoothmenu.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript">
$.noConflict();
ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

ddsmoothmenu.init({
	mainmenuid: "smoothmenu2", //Menu DIV id
	orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
	//customtheme: ["#804000", "#482400"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
<link rel="stylesheet" href="<fmt:message key='website.home'></fmt:message>css/general.css" type="text/css"
	media="screen" />
<script src="http://code.jquery.com/jquery-1.7.1.min.js"
	type="text/javascript"></script>
<script src="<fmt:message key='website.home'></fmt:message>js/popup.js" type="text/javascript"></script>
<script type="text/javascript" src="<fmt:message key='website.home'></fmt:message>js/util.js"></script>
<div id="header">
	<div class="head_top">
		<div class="logo">
			<c:if test="${not empty userInfo}">
				<a href="<fmt:message key='website.home'></fmt:message>jsp/charity.jsp"> <img src="<fmt:message key='website.home'></fmt:message>images/tango_tablogo.png"
						border="0" /> </a>
			</c:if>
			<c:if test="${ empty userInfo}">
				<a href="<fmt:message key='website.home'></fmt:message>jsp/index.jsp"> <img src="<fmt:message key='website.home'></fmt:message>images/tango_tablogo.png"
						border="0" /> </a>
			</c:if>
		</div>
		<div class="navigtiion">

			<c:if test="${not empty userInfo}">
				<div class="signin_inner">
					<div class="hi_inner">

						welcome ${userInfo.firstname}
				   
					</div>
					<div class="my_account">
						<!-- <a href="profileEdit.do">My Account</a> -->
						<sslext:link forward="unsecurelogout" indexId="login"
							title="Sign Out"
							onclick="delete_cookie_logindetails('tangotabid');">
							<span>Sign Out</span>
						</sslext:link>
					</div>
				</div>
			</c:if>
			<%
				String emailId1 = request.getParameter("emailId");
			%>

 
			<c:if test="${ empty userInfo and  empty profileUsers}">
				<div class="signin">&nbsp;
<!--  
					<a href="login.jsp">Sign in</a><a
						href="consumer_registration.jsp?emailId=<%out.write(emailId1);%>"
						style="padding: 0 0 0 5px;">Sign up</a>
	 -->			</div>
			</c:if>


		</div>
		
		
    <div class="nav_head">   
      <ul>
<c:if test="${ empty userInfo and  empty profileUsers}">
				<li>
  <div style="float:right;padding-right: 100px;">&nbsp;
 </div>
					<a href="<fmt:message key='website.home'></fmt:message>jsp/login.jsp">Sign in</a> </li>
					<li> <b> &nbsp;| </li>
					<li>
					 <a
						href="<fmt:message key='website.home'></fmt:message>jsp/consumer_registration.jsp?emailId=<%out.write(emailId1);%>"
						style="padding: 0 0 0 5px;">Sign up</a>
				</li>
			</c:if>

					<li>

						<c:if
							test="${userInfo.roleId == 5 and  userInfo.billingMethodId ne 0 and  userInfo.billingTypeId ne 0 }">



							<sslext:link forward="unsecureViewDeals" indexId="myaccount"
								title="My Account">
								<span>My Account</span>
							</sslext:link>


						</c:if>
						<c:if
							test="${userInfo.roleId == 5 and  userInfo.billingMethodId eq 0 and  userInfo.billingTypeId eq 0 }">

							<li>
								<a href="<fmt:message key='website.home'></fmt:message>jsp/client_registration_process.jsp" id="searchdeals"
									title="Search Deals"><span>My Account</span> </a>
							</li>

						</c:if>
						<c:if test="${userInfo.roleId == 6}">

							<a href="<fmt:message key='website.home'></fmt:message>jsp/viewDeals.do" id="myaccount" title="My Account"><span>My
									Account</span> </a>
						</c:if>
					</li>


					<c:if test="${userInfo.roleId == 1}">


						<li>
							<a href="<fmt:message key='website.home'></fmt:message>jsp/viewNames.do?operation=display" id="myaccount"
								title="My Account"><span>My Account</span> </a>
						</li>
					</c:if>
					<c:if test="${userInfo.roleId == 4}">
						<li>
							<a href="<fmt:message key='website.home'></fmt:message>jsp/profileEdit.do" id="myaccount" title="My Account"><span>My
									Account</span> </a>
						</li>
					</c:if>

					 
			  	<li>
						<a href="<fmt:message key='website.home'></fmt:message>jsp/suggest_restaurant.jsp">Suggestion Box</a>
					</li>
					<li>
					   <a href="http://www.tangotabloid.com" target="_blank">Blog</a>
					
					</li>

					<li>
						<a href="<fmt:message key='website.home'></fmt:message>jsp/Friendforward.do">Share</a>
					</li>
					
					<li>
						<a href="<fmt:message key='website.home'></fmt:message>jsp/charity.jsp">Our Movement</a>
					</li>
					<!--
					<li>
						<a href="how_it_works.jsp">How to Tango</a>
					</li>-->

					<li>
						<a href="<fmt:message key='website.home'></fmt:message>jsp/searchForward.do" id="searchdeals" title="Search Deals"><span>Search
								Offers</span> </a>

					</li>

		
				</ul>
    </div>
  </div>
 <script type="text/javascript">
				var currentPage = "1";

	/*console.warn("Current Page is :"+ currentPage);*/
	if (currentPage == "Home")
		document.getElementById("home").className = 'current';
	else if (currentPage == "MyAccount")
		document.getElementById("myaccount").className = 'current';
	else if (currentPage == "Learn More")
		document.getElementById("Learn More").className = 'current';
	else if (currentPage == "SearchDeals")
		document.getElementById("searchdeals").className = 'current';
	else if (currentPage == "Login")
		document.getElementById("login").className = 'current';
</script>
</div>
<div id="headerbottom"></div>


<!--Added the Email Dialog Here - Social Integration-->


			<div id="popupContact">
				<a id="popupContactClose">x</a>


				<iframe
					src="https://www.facebook.com/plugins/registration.php?
             client_id=422265907817292&
             redirect_uri=http://www.tangotab.com/jsp/Face.do&
             fields=[
 {'name':'name'},
 {'name':'email'},
  
 {'name':'zipcode',       'description':'Zip Code', 'type':'text'}]"
					scrolling="auto" frameborder="no" style="border: none"
					allowTransparency="true" width="500" height="330">
				</iframe>

			</div>
			<div id="backgroundPopup"></div>
<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-29227383-1']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

		
		<!--Header End here-->
	
		
		
<div class="cantainer3" >
   <div class="main_cantainer">
       <div class="main_positon">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td align="center" valign="top">
    
   <table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tbody><tr>
            <td align="left" valign="top">&nbsp;</td>
            </tr>
          <tr>
            <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
               
                    <td align="right" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="70%" align="left"  valign="middle" scope="row" >
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        
                          <tr>
                            <td align="left" valign="top" scope="row">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							  <tr> 
                                <td  width="41%" align="left" valign="top" class="text_homebold_1" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/searchForward.do" >Free&nbsp;Restaurant&nbsp;Deals.&nbsp; </a></td>
                                <!-- <td  align="left" valign="top" class="text_homebold_1" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/searchForward.do" >Free Offers. </a></td>-->
                                <td  align="left" valign="top" class="text_homebold_2" scope="row"><span class="text_homebold_2"><a  href='<fmt:message key="website.home"></fmt:message>jsp/charity.jsp' >Great Cause.</a></span></td>
                              </tr>
                              
                              <tr>
                                <td colspan="3" align="left" valign="top" class="text_homebold" scope="row"><br/> People dine out <span class="text_homebold_orange">1,000,000,000</span> times a<br/> week in North America. </td>
                              </tr>
                              <tr>
                                <td height="20" colspan="3" align="left" valign="top" scope="row"></td>
                              </tr>
                              <tr>
                                <td colspan="3" align="left" valign="top" class="text_homebold" scope="row" style="font-size: 22px;">TangoTab donates a meal to people in need every<br/> time you use the service.
<span class="text_homebold_orange" style="font-size: 22px;"><i>&nbsp;When you eat, they eat</i></span>.  </td>
                              </tr>
                              <tr>
                                <td colspan="3" scope="row">&nbsp;</td>
                              </tr>
                             
                              <tr>
                                <td colspan="3" align="left" valign="top" class="text_homebold_2" scope="row">&nbsp;</td>
                              </tr>
                            </table>
                           </td>
                            
                          </tr>
                        </table></td>
                        <td width="20%" align="right" valign="top" scope="row"><table width="300" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                              <tr>
                                <td height="5" align="left" valign="top">&nbsp;</td>
                              </tr>
                              <tr>
                                <td height="450" align="center" valign="top" bgcolor="#141414"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td align="center" valign="top" class="padding1" scope="row">
									<%@include file="../jsp/embed_blackform1.jsp"%>
									</td>
                                  </tr>
                                </table>
                                  <p>&nbsp;</p></td>
                              </tr>
                            </tbody>
                        </table></td>
                      </tr>
                    </table></td>                    
              </tr>
            </tbody></table></td>
          </tr>
        </tbody></table>
    
    </td>
  </tr>
</tbody></table>
    
        	<div class="footer_inner_home3">
        	<!-- footer start here -->
        	
<link rel="stylesheet" type="text/css" href="<fmt:message key='website.home'></fmt:message>css/ddsmoothmenuplain.css" /> 
<link href="<fmt:message key='website.home'></fmt:message>css/tangotab.css" rel="stylesheet" type="text/css" />
<link href="<fmt:message key='website.home'></fmt:message>css/restyle.css" rel="stylesheet" type="text/css" />
<link href="<fmt:message key='website.home'></fmt:message>css/styles.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="http://www.tangotab.com/images/TangoT_Icon.ico" />
 
<script type="text/javascript" 
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

<script type="text/javascript" src="<fmt:message key='website.home'></fmt:message>js/ddsmoothmenu.js"></script>
	
<script type="text/javascript">
$.noConflict();
ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

ddsmoothmenu.init({
	mainmenuid: "smoothmenu2", //Menu DIV id
	orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
	//customtheme: ["#804000", "#482400"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
<style type="text/css">
.clearboth {
	float:left;
	clear:both;
	overflow:hidden;
}
.body{background:#ffffff;}
</style>
		<script type="text/javascript">
		$(document).ready(function() {
			//$("body",document.parent).css("background","#ffffff")   
		});
		
		</script>
			 
	</div></div></div>
	  <!--Footer Starts-->
	  <div class="footer-inner" style="clear:both;">
	 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tbody><tr>
    <td height="6" align="center" valign="top" bgcolor="#bbd531" scope="row"></td>
  </tr>
  
  <tr>
    <td align="center" valign="top" bgcolor="#141414" scope="row"><table width="1003" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
        <th align="center" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tbody>
         
          <tr>
            <th align="center" valign="top" scope="row">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                  
                  <tr>
                    <td align="left" valign="middle" scope="row">&nbsp;</td>
                    <td align="center" valign="top" scope="row">&nbsp;</td>
                    <td align="left" valign="top" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                  <td align="left" valign="middle" scope="row" width="38%">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                     
          
                    <tr>
                      <td align="left" valign="top" class="text8" scope="row">&nbsp;</td>
                      <td height="3" colspan="2" align="left" valign="top" class="text8" style="font-weight: normal;" scope="row">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="5%" align="left" valign="top" class="text8" scope="row">&nbsp;</td>
                      <td width="87%" height="3" align="left" valign="top" class="text8" style="font-weight: normal;" scope="row"><span class="footer_text01">Get TangoTab on your mobile Phone,</span></td>
                      <td width="8%" align="left" valign="top" class="text8" style="font-weight: normal;" scope="row">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="text8" scope="row">&nbsp;</td>
                      <td height="3" align="left" valign="top" class="footer_text01" scope="row">to find and redeem great offers in-the-moment. </td>
                      <td height="3" align="left" valign="top" class="footer_text01" scope="row">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="text8" scope="row">&nbsp;</td>
                      <td height="3" colspan="2" align="left" valign="top" class="footer_text01" scope="row">&nbsp;</td>
                    </tr>
                  </tbody></table></td>
                  <td align="center" valign="middle" scope="row" width="22%"><a href="http://itunes.apple.com/ca/app/tango-tab/id449163047?mt=8" target="_blank"></a><a href="http://itunes.apple.com/ca/app/tango-tab/id449163047?mt=8" target="_blank"><img src="<fmt:message key='website.home'></fmt:message>images/appstore_img.png" width="200" height="69" border="0"></a></td>
                  <td align="left" valign="middle" scope="row" width="40%"><table width="60%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                      
                      <tr>
                        <td width="30%" align="center" valign="top" scope="row"><a href="http://www.facebook.com/TangoTab${searchForm.cityName }" target="_blank"><img src="<fmt:message key='website.home'></fmt:message>images/facebook_img.png" width="70" height="69" border="0"></a></td>
                        <td width="30%" align="center" valign="top" scope="row"><a href="https://twitter.com/#!/TangoTab${searchForm.cityName }" target="_blank"><img src="<fmt:message key='website.home'></fmt:message>images/twitter_img.png" width="70" height="69" border="0"></a></td>
                      <td width="30%" height="35" align="center" valign="top" scope="row">
                      <a href="http://www.youtube.com/user/TheTangoTab?feature=creators_cornier-%2F%2Fs.ytimg.com%2Fyt%2Fimg%2Fcreators_corner%2FYouTube%2Fyoutube_32x32.png" target="_blank"><img src="<fmt:message key='website.home'></fmt:message>images/youtube.png" alt="img" width="72" height="72" border="0" /></a><img src="//www.youtube-nocookie.com/gen_204?feature=creators_cornier-//s.ytimg.com/yt/img/creators_corner/YouTube/youtube_32x32.png" style="display: none"/>
                      </td>
                      </tr>
                    </tbody>
                  </table></td>
                </tr>
                
                <tr>
                  <td align="left" valign="middle" scope="row">&nbsp;</td>
                  <td align="left" valign="top" scope="row">&nbsp;</td>
                </tr>
            </tbody></table></th>
          </tr>
        </tbody></table></th>
      </tr>
    </tbody></table></td>
  </tr>
  <tr>
    <td align="center" valign="top" bgcolor="#2b2a2a" scope="row"><table width="1003" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
        <td align="center" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          
          
          <tbody><tr>
            <td colspan="3" align="left" valign="top" class="text9" scope="row">&nbsp;
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
                <td width="2%" align="left" valign="top" class="footer_text02" scope="row">&nbsp;</td>
                <td width="29%" align="left" valign="top" class="footer_text02" scope="row">Company</td>
                <td width="29%" align="left" valign="top" scope="row"><span class="footer_text02">Clients</span></td>
                <td width="39%" align="left" valign="top" scope="row"><span class="footer_text02">More....</span></td>
              </tr>
              <tr>
                <td height="8" colspan="4" scope="row"></td>
                </tr>
              <tr>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="text10" scope="row"><a href="http://www.tangotab.com/" class="footer_text03">Home</a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/learnmore.jsp" class="footer_text03">Learn More </a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/suggest_restaurant.jsp" class="footer_text03">Suggestion Box </a><a href="<fmt:message key='website.home'></fmt:message>jsp/TangoTab_files/TangoTab.htm" class="footer_text03"></a></td>
              </tr>
              <tr>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/searchForward.do" class="footer_text03">Search Offers </a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/login.jsp" class="footer_text03">Sign In </a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/terms.jsp" class="footer_text03">Terms of Use </a><a href="<fmt:message key='website.home'></fmt:message>jsp/suggest_restaurant.jsp" class="footer_text03"></a></td>
              </tr>
              <tr>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/charity.jsp" class="footer_text03">Our Movement </a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/client_registration.jsp" class="footer_text03">Sign Up </a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/privacy_policy.jsp" class="footer_text03">Privacy Statement </a><a href="<fmt:message key='website.home'></fmt:message>jsp/terms.jsp" class="footer_text03"></a></td>
              </tr>
              <tr>
                <td align="left" valign="top" class="footer_text03" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="footer_text03" scope="row"><a href="http://www.tangotabloid.com/" target="_blank" class="footer_text03">Blog</a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/contact_us1.jsp" class="footer_text03">Contact Us </a></td>
                <td align="left" valign="top" class="text10" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/privacy_policy.jsp" class="footer_text03"></a></td>
              </tr>
              <tr>
                <td align="left" valign="top" class="footer_text03" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="footer_text03" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/press.jsp" class="footer_text03">Press</a></td>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
              </tr>
              <tr>
                <td align="left" valign="top" class="footer_text03" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="footer_text03" scope="row"><a href="<fmt:message key='website.home'></fmt:message>jsp/jobs.jsp" class="footer_text03">Careers</a></td>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
                <td align="left" valign="top" class="text10" scope="row">&nbsp;</td>
              </tr>
            </tbody></table></td>
            <td width="35%" align="left" valign="top" class="text9" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
                <td align="left" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tbody><tr>
                    <th scope="row">&nbsp;</th>
                  </tr>
                  <tr>
                    <td align="left" valign="top" scope="row"><em class="footer_text01"><i><b>When you eat, they eat </b></i></em></td>
                  </tr>
                  <tr>
                    <td height="8" scope="row"></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top" class="footer_text01" scope="row" style="font-size:14px;">TangoTab feeds a person in need </td>
                  </tr>
                  <tr>
                    <td align="left" valign="top" class="footer_text01" scope="row" style="font-size:14px;">every time you dine out with one </td>
                  </tr>
                  <tr>
                    <td align="left" valign="top" class="footer_text01" scope="row" style="font-size:14px;">of our offers. </td>
                  </tr>
                  <tr>
                    <td align="left" valign="top" class="padding_left" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="left" valign="top" class="copyright_text" scope="row">&copy; 2012 TangoTab.com.</td>
                  </tr>
                  <tr>
                    <td align="left" valign="top" class="copyright_text" scope="row"> All Rights Reserved. </td>
                  </tr>
                </tbody></table></td>
              </tr>
            </tbody></table></td>
          </tr>
          <tr>
            <td colspan="4" align="right" valign="top" class="text1" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
                <td align="right" valign="top" scope="row">&nbsp;</td>
              </tr>
            </tbody></table></td>
            </tr>
          <tr>
            <td colspan="4" align="left" valign="top" scope="row">&nbsp;</td>
          </tr>
        </tbody></table></td>
      </tr><!--
    </table-->
</tbody></table>
	 
	 
	 
	  <div><div><div>
	 
	 <div style="clear:both;"></div>

		

        </div>
    </div>
	</div>

	 <div><div><div>	  
	 
	 <div style="clear:both;"></div>

		
        	
        	<!--  footer end here -->
        	</div>
        </div>
            
    </div>           
 
</div>

</div>      
</div>
 
<form name="loginForm" method="post">
<input type="hidden" name="emailId"/>
<input type="hidden" name="password"/>
</form>
</body>
</html>
