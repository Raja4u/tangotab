<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="com.tangotab.geo.GeoLocationUtility"%>  
<%@page import="com.tangotab.TO.UserTO"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@page import="com.tangotab.business.UserBO"%>
<%@page import="com.tangotab.businessImpl.UserBOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tangotab.TO.DealTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<fmt:setBundle basename="socialintg"></fmt:setBundle>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="TangoTab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>

<title> TangoTab </title> 

<link href="http://184.173.113.66/css/restyle.css" rel="stylesheet" type="text/css" />

<script src="http://184.173.113.66/js/jquery-1.js" type="text/javascript"></script>
<script src="http://184.173.113.66/js/jquery_003.js" type="text/javascript"></script>
<script src="http://184.173.113.66/js/jquery_002.js" type="text/javascript" charset="utf-8"></script>
<script src="http://184.173.113.66/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="http://184.173.113.66/js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script src="http://184.173.113.66/js/geolocator.js" type="text/javascript" charset="utf-8"></script>
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
 
    window.location="/mobile${after}";
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
      top:20px;
      width:335px;
      height:102px;
      z-index:5;
}

    </style>

<!-- 

<script src="http://184.173.113.66/js/coda-slider.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="http://184.173.113.66/js/scroll.js"></script>
<script type="text/javascript" src="http://184.173.113.66/js/scrollend.js"></script>
 -->
<!-- <link href="http://184.173.113.66/css/scrollcolor.css" rel="stylesheet" type="text/css" /> -->

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
						      document.loginForm.action="<fmt:message key='website.home'></fmt:message>jsp/login.do";
						   document.loginForm.submit();  
			 //     document.loginForm.password.value=details[0];
			 //alert(details[0]);
			     }else
				 {
						      document.loginForm.password.value=y;
						      document.loginForm.action="<fmt:message key='website.home'></fmt:message>jsp/login.do";
						  
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
					 document.forms[0].action = "<fmt:message key='website.home'></fmt:message>jsp/loginReg.do?type=consumer";
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

function setCookie(c_name,value,exdays)
	{
	var exdate=new Date();
	exdays = null;
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString())+"; path=/" ;
	document.cookie=c_name + "=" + c_value;
	//getCookie('landing');
	}
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



</script>
  
</head> 
 
<body onload="getLoginCookie();setCookie('landing','1060',0);" >


<div class="cantainer_inner" id="CookieDiv" style="display:none;">
   <div class="main_cantainer">
    <div class="cantainer_content">
     <div class="inner_cantainer">

  <div class="main_deal" style="background-color: #000;">
 
<div class="top_header" >
<img src="<fmt:message key='website.home'></fmt:message>images/corner_left.jpg" align="left" /><img src="<fmt:message key='website.home'></fmt:message>images/corner_right.jpg" align="right" /></div> 

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
	 <!--header start-->
	 

        	<%@ include file="../jsp/index_header.jsp"%>
		
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
                                <td height="85" colspan="3" align="left" valign="top" scope="row"></td>
                              </tr>
                             
							 
							   <tr> 
                                <td  width="45%" align="left" valign="top" scope="row" colspan="2">
								
				<h1 style="line-height: 44px; font-family: calibri;"><span style="font-size:61px;"><a href="<fmt:message key='website.home'></fmt:message>jsp/searchForward.do"  style="color:#000000;text-decoration:none;">&nbsp;Free&nbsp;Restaurant&nbsp;Deals.</a></span>
							<br/>
							<span style="font-size:61px;"><a  href='<fmt:message key="website.home"></fmt:message>jsp/charity.jsp' style="text-decoration:none;color:#FF7F00" >&nbsp;Great Cause.</a></span>
							</h1>	
							</td>
							</tr>
                            <tr>
                                <td height="73" colspan="3" align="left" valign="top" scope="row"></td>
                              </tr>
                             
                             
                             
                               <tr>
                                <td colspan="3" align="left" valign="top" ><h2 style="font-size: 29px;color:#000000;font-family: calibri;">&nbsp;TangoTab donates a meal to people in need every<br/> &nbsp;time you use the service.
<span class="text_homebold_orange" style="font-size: 29px;"><i>&nbsp;When you eat, they eat</i></span>.</h2>  </td>
                              </tr>
                              
                              
                            </table>
                           </td>
                            
                          </tr>
						   <tr><td height="28"> </td></tr>
						  
						  <tr><td height="34"> </td></tr>
						   <tr>
                                                        <td colspan="3" scope="row" align="left" valign="top" class="text_homebold"  style="font-size: 22px;">
                                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="38%" valign="bottom">&nbsp;This year <span class="text_homebold_orange" style="font-size: 22px;">TangoTab</span>
has fed</td>
    <td width="24%"> 

                 <script src="<fmt:message key='website.home'></fmt:message>js/jquery.flipCounter.1.2.js" type="text/javascript"></script>	
                     <span id="counter"><input type="hidden" name="counter-value" id="counter-value" value="" /></span>
               <script type="text/javascript">
                      /* <![CDATA[ */
                         jQuery(document).ready(function($) {
                         var count = '${charityCount}';
                         if(count == null || count == 0)
                         document.getElementById('counter-value').value= '82456';	
                         else
                         document.getElementById('counter-value').value=count;
                         $("#counter").flipCounter(); 
                        });
                   /* ]]> */
  
             </script> </td>
    <td width="38%" valign="bottom"> people in need.</td>
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
                                    <td align="center" valign="top" class="padding1" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td align="center" valign="top" scope="row">&nbsp;</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="top" class="signup_txt" scope="row">Start Here </td>
                                      </tr>
                                      <tr>
                                        <td height="10" align="center" valign="top"  scope="row"></td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="top" scope="row">
                                           <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
							<input type="hidden" name="emailIdexists"	 id="emailIdexists" />			
										
									<table width="65%" border="0" cellspacing="0" cellpadding="0">
                                          <tr>
                                            <td height="40" align="center"  >
                                          
											<html:hidden property="refferedUrl"    styleId="refferedUrl" /> 
											
										 	<!--<html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="removetext(this,'First Name');clickedForm(this.id);"  ></html:text>
					--><input type="text" name="firstname" id="firstname" placeholder="First Name" class="text_box"  />   </td>
                                          </tr>
                                         
                                          	<tr>
                                          	<td height="40" align="center" >
									 	<!--<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="removetext(this,'Last Name');clickedForm(this.id);" onclick="removetext(this,'Last Name');clickedForm(this.id);"    ></html:text>
													--><input type="text" name="lastname" id="lastname" placeholder="Last Name" class="text_box" />	</td>
													</tr>
													<tr>
														<td height="40" align="center" ><!--<html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"  onkeyup="removetext(this,'Email');clickedForm(this.id);"  onclick="removetext(this,'Email');clickedForm(this.id);"  ></html:text> 
												                     -->
<input type="text" name="emailId" id="emailId" placeholder="Email" class="text_box" /></td></tr>
													<tr><td height="40" align="center" >
														<!--<html:password property="password"   styleId="password"
																styleClass="text_box"  value="Password"   onkeyup="removetext(this,'Password');clickedForm(this.id);" onclick="removetext(this,'Password');clickedForm(this.id);"      >  </html:password>
														--><input id="password-clear" type="text" value="Password" autocomplete="off"  class="text_box"  />
	    												<input id="password-password" type="password" name="password" value="" autocomplete="off" placeholder="Password" class="text_box" maxlength='16' />																	
														</td> 	</tr>
											 
													<tr><td height="40" align="center" >
														<!--	<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="removetext(this,'Zip Code');clickedForm(this.id);" onclick="removetext(this,'Zip Code');clickedForm(this.id);"   ></html:text>
												 --> <input type="text" name="zipCode" id="zipCode" placeholder="Zip Code" class="text_box" /> </td></tr>
                                         
                                        <tr>
                            <td height="25" align="center" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="11%"><input type="checkbox" name="agree" id="agree"  /></td>
                                <td width="89%" class="normalwht">I agree to the <a href="<fmt:message key='website.home'></fmt:message>jsp/terms.jsp" class="normalwht">Terms &amp; Conditions</a></td>
                              </tr>
                            </table></td>
                          </tr>
                                          <tr>
                                            <td height="5" align="center" valign="top" scope="row"></td>
                                          </tr>
                                          <tr>
                                            <td align="center" valign="top" scope="row">
                                            <a href="#" onclick="Onsubmit1();"><img src="<fmt:message key='website.home'></fmt:message>images/signup_btn.png"   border="0" /></a>
                                            </td>
                                          </tr>
                                            <tr>
                                            <td scope="row">&nbsp;</td>
                                          </tr>
                                           <tr>
                                            <td align="center" valign="top" scope="row"><span class="normalwht">Already registered?
                                            <a href="<fmt:message key='website.home'></fmt:message>jsp/login.jsp" class="text_signin_txt"> Sign In </a></span></td>
                                          </tr>
                                          <tr>
                                            <td scope="row">&nbsp;</td>
                                          </tr>
                                          <tr>
                                            <td scope="row" align="center"><img src="<fmt:message key='website.home'></fmt:message>images/line_img.png" alt="img"  /></td>
                                          </tr>
                                          <tr>
                                            <td scope="row">&nbsp;</td>
                                          </tr>
                                          <tr>
										  
                                            <td scope="row" align="center">
                                            <div id="button"  style="float:left;">
											<div style="float;padding-left:20px;">
												<a href="#"> <img src="<fmt:message key='website.home'></fmt:message>images/f_connect_btn.png" border="0" /> </a>
											</div></div>
                                          
                                            </td>
                                          </tr>
                                        </table>
                                        </html:form></td>
                                      </tr>
                                      <tr>
                                        <td scope="row">&nbsp;</td>
                                      </tr>
                                    </table></td>
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
        	<%@ include file="../jsp/slidefooter.jsp"%>
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
