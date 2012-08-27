<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.tangotab.geo.GeoLocationUtility"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<fmt:setBundle basename="tangotab"></fmt:setBundle>


<fmt:setBundle basename="tangotab"></fmt:setBundle>

<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="TangoTab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>



	<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="Tango Tab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>TangoTab</title>
	
	
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
	
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>
<script type='text/javascript' src='../js/util.js'></script>
 
<div id="fb-root">
</div>
</head>



<body topmargin="0" bottommargin="0" onload="setCookie('landing','1022',0);">
 
	
<div id="wrapper"> 
<div id="main">
	<!------------------------------ START HEADER ---------------------------- -->

	<jsp:include page="../jsp/landheader.jsp"/> 

	<!------------------------------ END HEADER ---------------------------- -->

	<!------------------------------ START BODY ------------------------------>

<div class="cantainerland" style="background:url('../images/orginal_bg.jpg') no-repeat center top;">
   <div class="main_cantainer">
       <div class="main_positon">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top">
    
     <table width="1000" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="left" valign="top">&nbsp;</td>
            </tr>
          <tr>
            <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="40%" align="center" valign="top"><img src="images/jse_cartboard.png" width="379" height="501" /></td>
                    <td align="center" valign="top" height="445" >
                     <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
							<input type="hidden" name="emailIdexists"	 id="emailIdexists" />	
                    <table width="300" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="10" align="left" valign="top">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="480" align="center" valign="top" background="../images/fb_signup_bg.png"><table width="85%" border="0" cellspacing="4" cellpadding="4">
                            <tr>
                              <td height="118">&nbsp;</td>
                            </tr>
                            <tr>
                              <td height="50" align="center" valign="middle">
                              <a href="#" onclick="centerPopup();loadPopup();" ><img src="../images/signup_img.png" width="168" height="53" border="0" /></a></td>
                            </tr>
                            <tr>
                              <td height="40">&nbsp;</td>
                            </tr>
                            <tr>
                            <td>
                             <html:hidden property="refferCode"  value="1022" styleId="refferCode"/>
                            <html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="removetext(this,'First Name');"  ></html:text>  </td>
                          </tr> 
                          	<tr>
									<td> 	<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="removetext(this,'Last Name');" onclick="removetext(this,'Last Name');"    ></html:text>
														</td>
													</tr>
													<tr>
														<td><html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"   onclick="removetext(this,'Email');"  ></html:text> 
												                     </td></tr>
													<tr><td > 
														<html:password property="password"  
																styleClass="text_box"  value="Password"   onkeyup="removetext(this,'Password');" onclick="removetext(this,'Password');"      >  </html:password>
																															
														</td> 	</tr>
											 
													<tr><td > 
															<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="removetext(this,'Zip Code');" onclick="removetext(this,'Zip Code');"   ></html:text>
												 </td></tr>
                            <tr>
                              <td height="30" align="center" valign="middle">
                              <table width="85%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="11%"><input type="checkbox" name="agree" id="agree"  checked="checked"/></td>
                                    <td width="89%" class="normalwht">I agree to the <a href="#" class="normalwht2">Terms &amp; Conditions</a></td>
                                  </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td align="center" valign="middle"><a href="#" onclick="Onsubmit1();"><img src="images/signup_fb.png" width="145" height="50" border="0" /></a></td>
                            </tr>
                        </table></td>
                      </tr>
                    </table>
                    </html:form>
                    </td>
                    <td align="center" valign="bottom" ><img src="images/sje-logo.png" width="200" height="200" border="0" /></td>
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
