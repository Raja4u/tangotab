<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<% session.removeAttribute("AL"); %>
<%@page import="com.tangotab.geo.GeoLocationUtility"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab" ></fmt:setBundle>

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
	<title> TangoTab </title>
	
	
	<link href="http://www.tangotab.com/css/tangotab.css" rel="stylesheet" type="text/css" /> 
	<!-- <link href="http://www.tangotab.com//css/restyle.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/ddsmoothmenuup.css" /> -->
	
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



    </style>
	
<div id="fb-root">
</div>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	
	<!--  <script type="text/javascript" src="http://localhost:8080/TangoTab/js/ddsmoothmenu.js"></script>-->
	
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

  		 var emailId='';
	//alert(emailId);
	function getLoginCookie()
{

var i,x,y,ARRcookies=document.cookie.split(";");
 
 //alert(ARRcookies.length);
	for (i=0;i<ARRcookies.length;i++)
	  {
	//alert(ARRcookies);
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
						      document.loginForm.action="login.do";
						   document.loginForm.submit();  
			 //     document.loginForm.password.value=details[0];
			 //alert(details[0]);
			     }else
				 {
						      document.loginForm.password.value=y;
						      document.loginForm.action="login.do";
						   document.loginForm.submit();   
				  }
			    break;
			    }
			  }
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
			
 
			
			if( form.password.value.length <8  )
			{
				msg += "     * Your Password length can't be less than 8.\r\n";
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
			 
			 
					 document.forms[0].action = "../jsp/loginReg.do?type=consumer";
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
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
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

<fmt:setBundle basename="tangotab"></fmt:setBundle>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>
<script type='text/javascript' src='../js/util.js'></script>

	<link rel="shortcut icon" href="http://tangotab.com/images/TangoT_Icon.ico" />
<div id="fb-root">
</div>
</head>



<body topmargin="0" bottommargin="0" onload="setCookie('landing','1021',0);" onclick="clickedBody(this.id);" >
 
	
<div id="wrapper"> 
<div id="main">
 <jsp:include page="../jsp/landheader.jsp"/> 
	<!------------------------------ START HEADER ---------------------------- 


	<!------------------------------ END HEADER ------------------------------>

	<!------------------------------ START BODY ------------------------------>
<div class="cantainerland" style="background:url('../images/orginal_bg.jpg') no-repeat center top;">
   <div class="main_cantainer">
       <div class="main_positon">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top">
    
    <table width="1000" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="left" valign="top">&nbsp;</td>
            </tr>
          <tr>
            <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="480" height="501" align="left" valign="top"><table width="500" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="350" height="500" align="right" valign="top"  style="background:url('../images/jse_cartboard.png') no-repeat;"><table width="72%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td height="370" align="left" valign="top">&nbsp;</td>
                            </tr>
                            <tr>
                              <td align="right" valign="top"><a href="http://www.tangotab.com/jsp/charity.jsp"><img src="../images/widget_new.png" alt="Hungry" width="180" height="127" border="0" /></a></td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></td>
                    <td width="400" height="445" align="center" valign="top" ><table width="300" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="10" align="left" valign="top">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="480" align="center" valign="top" background="../images/fb_signup_bg.png">
                         <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
							<input type="hidden" name="emailIdexists"	 id="emailIdexists" />		
							<input type="hidden" name="formClicked"	 id="formClicked" value="false"/>	
									
							<table width="85%" border="0" cellspacing="4" cellpadding="4">
                            <tr>
                              <td height="118">&nbsp;</td>
                            </tr>
                            <tr>
                              <td height="50" align="center" valign="middle"><a href="#"  onclick="centerPopup();loadPopup();"><img src="../images/signup_img.png" width="168" height="53" border="0" /></a></td>
                            </tr>
                            <tr>
                              <td height="40">&nbsp;</td>
                            </tr>
                              <tr>
                            <td>
							<html:hidden property="refferCode"  value="1021" styleId="refferCode" />
                            <html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="removetext(this,'First Name');clickedForm(this.id);"  ></html:text>  </td>
                          </tr> 
                          	<tr>
									<td> 	<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="removetext(this,'Last Name');clickedForm(this.id);" onclick="removetext(this,'Last Name');clickedForm(this.id);"    ></html:text>
														</td>
													</tr>
													<tr>
														<td><html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"   onclick="removetext(this,'Email');clickedForm(this.id);" onkeyup="removetext(this,'Email');clickedForm(this.id);" ></html:text> 
												                     </td></tr>
													<tr><td > 
														<html:password property="password"   styleId="password"
																styleClass="text_box"  value="Password"   onkeyup="removetext(this,'Password');clickedForm(this.id);" onclick="removetext(this,'Password');clickedForm(this.id);"      >  </html:password>
																															
														</td> 	</tr>
											 
													<tr><td > 
															<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="removetext(this,'Zip Code');clickedForm(this.id);" onclick="removetext(this,'Zip Code');clickedForm(this.id);"   ></html:text>
												 </td></tr>
                           
                          <tr>
                            <td height="40" align="center" valign="middle"><table width="85%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="11%"><input type="checkbox" name="agree" id="agree"  checked="checked"/></td>
                                <td width="89%" class="normalwht">I agree to the <a href="#" class="normalwht2">Terms &amp; Conditions</a></td>
                              </tr>
                            </table></td>
                          </tr>
                            <tr>
                              <td align="center" valign="middle"><a href="#" onclick="Onsubmit1();"><img src="images/signup_fb.png" width="145" height="50" border="0" /></a></td>
                            </tr>
                        </table>
                        </html:form></td>
                      </tr>
                    </table></td>
                  </tr>
                  
                </table></td>
              </tr>
            </table></td>
          </tr>
         
        </table>
    </td>
  </tr>
</table>
    
        	<div class="footer_inner_home3">
        	<%@ include file="../jsp/slidefooter.jsp"%>
        	</div>
        </div>
            
    </div>           
 
</div>
</div>
</div>

</body>

</html>
