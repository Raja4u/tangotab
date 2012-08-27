<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
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



 
function validateEmail(form_id,email) {
 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   var address = document.forms[form_id].elements[email].value;
   if(reg.test(address) == false) {
 	return "Invalid Email Address";
   
   
   }return "";
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



<body id="body" topmargin="0" bottommargin="0" onload="setCookie('landing','1036',0);"  onclick="clickedBodyUtil();">
 
	
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
    
    
    <table width="1000" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="left" valign="top">&nbsp;</td>
            </tr>
          <tr>
            <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="left" valign="top" scope="col"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="69%" align="left" valign="top" scope="row"><table width="71%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="left" valign="middle" scope="row">
						<a href="../jsp/search.do" ><img src="../images/cartboard.png" width="480" height="300" border="0" /></a></td>
                      </tr>
                      <tr>
                        <td scope="row">&nbsp;</td>
                      </tr>
                      <tr>
                        <td align="left" valign="top" scope="row">
                        <table width="70%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="46%" align="left" valign="top" scope="col">
                            <table width="81%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td align="left" valign="middle" scope="col"><img src="images/victor_butler_txt_img.png" width="484" height="156" /></td>
                                </tr>
                            </table></td>
                            <td align="left" valign="top" scope="col">
                            <a href="../jsp/charity.jsp" ><img src="../images/widget.png" width="220" height="167" border="0" /></a></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                    <td width="31%" align="right" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="300" height="480" align="center" valign="top" style="background:url('../images/fb_signup_bg.png') no-repeat center top;" scope="row">
                        
                         <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
							<input type="hidden" name="emailIdexists"	 id="emailIdexists" />		
							<input type="hidden" name="formClicked"	 id="formClicked" value="false" />	
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
                            <html:hidden property="refferCode"  value="1036" styleId="refferCode"/>
													
                            <html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="clickedFormUtil(this,'First Name');"  ></html:text>  </td>
                          </tr> 
                          	<tr>
									<td> 	<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="clickedFormUtil(this,'Last Name');" onclick="clickedFormUtil(this,'Last Name');"    ></html:text>
														</td>
													</tr>
													<tr>
														<td><html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"   onclick="clickedFormUtil(this,'Email');"  onkeyup="clickedFormUtil(this,'Email');"></html:text> 
												                     </td></tr>
													<tr><td > 
														<html:password property="password"  styleId="password"
																styleClass="text_box"  value="Password"   onkeyup="clickedFormUtil(this,'Password');" onclick="clickedFormUtil(this,'Password');"      >  </html:password>
																															
														</td> 	</tr>
											 
													<tr><td > 
															<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="clickedFormUtil(this,'Zip Code');" onclick="clickedFormUtil(this,'Zip Code');"   ></html:text>
												 </td></tr>
                           
                          <tr>
                            <td height="40" align="center" valign="middle">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="11%"><input type="checkbox" name="agree" id="agree"  checked="checked"/></td>
                                <td width="89%" class="normalwht">I agree to the <a href="#" class="normalwht2">Terms &amp; Conditions</a></td>
                              </tr>
                            </table></td>
                          </tr>
                            <tr>
                              <td align="center" valign="middle"><a href="#" onclick="Onsubmit1();"><img src="../images/signup_fb.png" width="145" height="50" border="0" /></a></td>
                            </tr>
                        </table>
                        </html:form></td>
                      </tr>
                    </table>
                            
                            
                            </td>
                  </tr>
                </table></td>
                </tr>
              <tr>
                <td height="3" scope="col"></td>
              </tr>
              <tr>
                <td align="left" valign="top" scope="col">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="center" valign="top">&nbsp;</td>
          </tr>
        </table>
        
    <!--  <table width="1000" border="0" cellpadding="0" cellspacing="0">
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
                              <td align="right" valign="top"><a href="#"><img src="../images/widget_new.png" alt="Hungry" width="180" height="127" border="0" /></a></td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></td>
                    <td width="400" height="445" align="center" valign="top" >
                    
                    <table width="300" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="10" align="left" valign="top">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="480" align="center" valign="top" background="../images/fb_signup_bg.png">
                         <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
							<input type="hidden" name="emailIdexists"	 id="emailIdexists" />		
							<input type="hidden" name="formClicked"	 id="formClicked" value="false" />	
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
                            <html:hidden property="refferCode"  value="1021" styleId="refferCode"/>
													
                            <html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="clickedForm(this,'First Name');"  ></html:text>  </td>
                          </tr> 
                          	<tr>
									<td> 	<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="clickedForm(this,'Last Name');" onclick="clickedForm(this,'Last Name');"    ></html:text>
														</td>
													</tr>
													<tr>
														<td><html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"   onclick="clickedForm(this,'Email');"  onkeyup="clickedForm(this,'Email');"></html:text> 
												                     </td></tr>
													<tr><td > 
														<html:password property="password"  styleId="password"
																styleClass="text_box"  value="Password"   onkeyup="clickedForm(this,'Password');" onclick="clickedForm(this,'Password');"      >  </html:password>
																															
														</td> 	</tr>
											 
													<tr><td > 
															<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="clickedForm(this,'Zip Code');" onclick="clickedForm(this,'Zip Code');"   ></html:text>
												 </td></tr>
                           
                          <tr>
                            <td height="40" align="center" valign="middle"><br></td>
                          </tr>
                            <tr>
                              <td align="center" valign="middle"><a href="#" onclick="Onsubmit1();"><img src="../images/signup_fb.png" width="145" height="50" border="0" /></a></td>
                            </tr>
                        </table>
                        </html:form></td>
                      </tr>
                    </table>
                    
                    
                    </td>
                  </tr>
                  
                </table></td>
              </tr>
            </table></td>
          </tr>
         
        </table> -->
        
        
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
