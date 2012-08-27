<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>TangoTab</title>
	
	<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" type="text/css" href="http://www.tangotab.com/css/ddsmoothmenuup.css" />
<script type="text/javascript" src="http://tangotab.com/js/util.js"></script>
<link rel="shortcut icon" href="http://tangotab.com/images/TangoT_Icon.ico" />
	<style>
		body{ margin:0px; padding:0px; background:#000000; font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif; color:#ffffff;}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		#wrap{ margin:0px auto; padding:0px; width:967px; clear:both;}
		.normalwhite 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; }
		.normalgreen 	{ font-family:Arial, Helvetica, sans-serif; color:#7d9b17; font-size:12px; }
		.normalorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:12px; }
		.normalblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:12px; }
		.mediumorange	{ font-family:Arial, Helvetica, sans-serif; color:#e46c0e; font-size:18px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		.mediumblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:14px; }
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		.header 		{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  		{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#7d9b17;} 
		.dealtitle  	{font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  		{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#7d9b17;} 
		.dealtext		{font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#000000;} 
	.title1 {font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#990000;}
    #select_hot{ float:left; padding:5px 5px 0 0;}

#select_hot a{ background:url(../images/submit_button.png) no-repeat; display: block;
    height: 27px;
    padding: 5px 0 0;
    text-align: center;
    text-decoration: none; font-size:12px; font-family:Arial, Helvetica, sans-serif;
    width: 112px; color:#FFFFFF; font-weight:bold; margin:0px 0 0 0; }

#select_hot input{background:url(../images/submit_button.png) no-repeat; display: block;
    height: 27px;
    padding:0;
    text-align: center;
    text-decoration: none;
    width: 112px; color:#FFFFFF;  font-size:12px; font-family:Arial, Helvetica, sans-serif; font-weight:bold; border:none;}
	
	
	.but_img{
	width:106px;
	height:27px;
	border:none;
	cursor:pointer;
	color:#000;
	text-align:center;
	background: url(../images/logbutton.png);
	background-repeat: no-repeat;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	vertical-align: middle;
}
.but_img a{
	width:106px;
	height:27px;
	border:none;
	cursor:pointer;
	color:#232222;
	text-align:center;
	background: url(../images/logbutton.png);
	background-repeat: no-repeat;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	vertical-align: middle;
}
    .white_text {font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:16px; line-height:22px; font-weight:bold; }
    </style>
	
	
	
	<script language="javascript"> 
	 function city()
	 {
	 
	  document.RegistrationForm.hPrefCity.value=document.RegistrationForm.PrefCity.getElementsByTagName('option')[document.RegistrationForm.PrefCity.selectedIndex].firstChild.nodeValue;
	 
	 }
	 
	function checkEmail(roleId){
		 
		var emailId = dwr.util.getValue("Email");
	
		if(emailId!=null && emailId.trim()!=""){
			deal.checkUserAvailability( emailId,roleId,function(data) {
	 
			    	if(data==true){
			    		document.getElementById("checkEmailId").innerHTML="";
			    		document.RegistrationForm.emailIdexists.value=1;
			    		document.getElementById("checkEmailId").innerHTML="Email already exists";
			    	}else{
			    	document.RegistrationForm.emailIdexists.value=0;
			    		document.getElementById("checkEmailId").innerHTML="";
			    	}
			 });	
		}else{
				document.getElementById("checkEmailId").innerHTML="Email Id is required";
		}
}
function validate(form_id,email) {
 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   var address = document.forms[form_id].elements[email].value;
   if(reg.test(address) == false) {
 	return "Invalid Email Address";
   
   
   }return "";
}
		function validateForm()
		{
		
			var form = document.RegistrationForm;
			var msg = "";
			var s=validate('RegistrationForm','Email');
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
			}else if(s!="")
			{
				msg += "       "+s+"\r\n";
			 
			
			}
			if( form.Zip.value == "" )
			{
				msg += "     * Your Zipcode.\r\n";
			}
			if( form.PrefCity.value == "" )
			{
				msg += "     * Your Prefered City.\r\n";
			}
			if( form.Password.value == "" )
			{
				msg += "     * Your Password.\r\n";
			}
			
			if( form.CPassword.value == "" )
			{
				msg += "     * Your Confirm Password.\r\n";
			}
			
			if( form.Password.value.length <8  )
			{
				msg += "     * Your Password length can't be less than 8.\r\n";
			}
			
			if( form.CPassword.value == "" )
			{
				msg += "     * Your Confirm Password length can't be less than 8.\r\n";
			}
			
				if( form.Password.value != form.CPassword.value )
			{
				msg += "     * Password and ConfirmPassword both are not same.\r\n";
			}
	 
			if( form.Email.value != ""  && form.emailIdexists.value == 1 )
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
				return true;
			}
		}
		function onCancel()
		{
		document.RegistrationForm.action="home.jsp";
		document.RegistrationForm.submit();
		
		}
	 
	</script> 
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>
</head>



<body topmargin="0" bottommargin="0">
<% String emailhome = "" ;%>
<% emailhome = request.getParameter("Email"); %>
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
					
					<a href="http://www.tangotab.com/jsp/chairty.jsp" class="normalwhite" style="text-decoration:none;">
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





	<table width="967" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="64" align="center" valign="top" background="images/top_bg.jpg"><table width="98%" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="5"></td>
            </tr>
            <tr>
              <td class="white_text" align="left">Each time you dine with TangoTab, we provide a meal <br>
                to a hungry person through local and national food banks</td>
            </tr>
        </table></td>
      </tr>
    </table>
  <table cellpadding="10" cellspacing="0" border="0" width="967" align="center" bgcolor="#ffffff" height="70" style="height:70px;">
	<tr>
	
		<!------------------------------ LEFT COLUMN ------------------------------>
		<td width="300" valign="top" align="center">
			
			<img src="images/didyouknow1.jpg" border="0" align="bottom"><br><br>
          <!--  <a href="#"><img src="images/suppoting_minnies.jpg" width="194" height="149" border="0" align="bottom"></a>--><br><br><br><br>
			
			
		</td>
		
		<!------------------------------ RIGHT COLUMN ------------------------------>
		<td width="667" valign="top">
		
			
			
			
			<table cellpadding="5" cellspacing="0" border="0" width="667" align="center">
			<tr>
				<td width="667" align="center" valign="top" class="title2">
					<br><br>
					
					

				</td>
			</tr>
					<tr>
					  <td colspan="3" align="center"  id="checkEmailId2" class="red_text" height="20px;" style="font-size: 12px;"  ><span class="title1"><img src="images/signup.jpg" border="0" height="96"></span></td>
			  </tr>
					<tr>
				<td colspan="3" align="center"  id="checkEmailId" class="red_text" height="20px;" style="font-size: 12px;"  >&nbsp;
				
						   
				      </td></tr>
			<tr>
				<td colspan="3" align="center" valign="top" >
				  <div class="mediumorange">
					Guest Registration
					</div>
			
					 <form action="submitsignup.jsp" method="post" name="RegistrationForm" onSubmit="return validateForm();" >
				    <br>
					<table cellspacing="10" border="0">
					 
					 
					 
								<!-- form Start-->
								<!-- <html:form  action="jsp/userRegs.do?type=consumer" method="post" onsubmit="return Onsubmit1();"> -->
									
									<!-- ********** Page to return to after submit is complete *********** -->
									<input type="hidden" name="pageSource" id="pageSource" value="http://www.tangotab.com/mai/submitsignup.jsp">
									<!-- ********** Page to return to after submit is complete *********** -->
										
										
										
										
  
							<tr>
								<td  width="150" align="right" valign="middle" class="normalblack">
									First Name<span class="red_text">*</span>:
								</td>
								<td  align="left" valign="middle">
	
									<input type="text" name="FirstName" id="FirstName" class="restaurant_input" maxlength="50" > 
										 
									<input type="hidden" name="refferCode"  value="1023"/>
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Last Name</span><span	class="red_text">*</span>: 
								</td>
								<td align="left" valign="middle">
								<input type="text" name="LastName" id="LastName"  class="restaurant_input"  maxlength="50"> 
									<!-- <html:text property="lastname" styleClass="restaurant_input" styleId="lastName"  onkeyup="hidetext('lname')"></html:text>
										<span  class="red_text" id="lname"><html:errors property="lastname" /></span> -->
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									Email<span class="red_text">*</span>:
								</td>
								<td align="left" valign="middle">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
										  <tr>
											<td width="163" align="left" valign="top">
												<input type="text" name="Email" value="<%=emailhome %>"  onblur="checkEmail(4)" id="Email"  class="restaurant_input" />
											 </td>
											<td width="285" align="left" valign="top" class="red_text" >
												
						 						<input type="hidden" name="emailIdexists"	>
											</td>
										  </tr>
										</table>
								</td>
								
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Password<span class="red_text">*</span></span>: 
								</td>
								<td align="left" valign="middle">
									<div style="float:left">
									<input type="password" name="Password" id="Password" class="restaurant_input">
									</div>
									<span class="blue_text">&nbsp; Password should contain minimum eight alphanumeric characters</span>
								
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Confirm Password</span><span
										class="red_text"  >*</span>: 
								</td>
								<td align="left" valign="middle">
									<input type="password" name="CPassword" id="CPassword" class="restaurant_input" >
									
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									Zip/Post Code<span class="red_text">*</span>:
								</td>
								<td align="left" valign="middle"> 
									<input type="text" name="Zip"  maxlength="6" id="Zip" class="restaurant_input" >
									
								</td>
							</tr>
													
							<tr>
								<td align="right" valign="middle" class="normalblack">
									Preferred City<span class="red_text">*</span>:
								</td>
								<td align="left" valign="middle" class="restaurant_input">
									<select name="PrefCity" id="PrefCity"  onchange="city()" class="restaurant_input">
	<option value="">-------- Select ---------  </option>							
   	<c:forEach var="dList2" items="${dropDownList.cities}"  varStatus="status">
  	<option value="${dList2.cityId}">${dList2.cityName}</option>
 	 
    
     
 
    </c:forEach>
	</select>	
	<input type="hidden" name="hPrefCity"	>	
								</td>
							</tr>
							<tr>						
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Mobile Number</span>:
								</td>
								<td align="left" valign="middle">
									<input type="text" name="Phone" id="Phone" maxlength="10" onKeyPress="return isNumberKey(event)"  class="restaurant_input" />
									<span class="blue_text">(e.g., 2125551212)&nbsp;&nbsp;[If you would like to be notified of deals via SMS*] </span>
									
								</td>
							</tr> 
							<tr>
								<td  colspan="3" id="msgid" class="normalblack" align="center">&nbsp;
									
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center" valign="middle" class="normalblack" >
									<input type="checkbox" class="normalblack" name="agree" id="checkbox24"  value="ok"/>
									I certify that I have read and agree to the
									<span class="normalblack"> 
										<a href="privacy_policy.jsp" class="red_text"  target="_blank" >privacy policy</a> 
									</span>and
									<br/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="terms.jsp"  class="red_text" target="_blank">terms of use</a> of TangoTab.
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center" valign="middle" class="fineprint">
									<div>[NOTE*Standard text messaging charges may apply as per your mobile service provider*]
									</div>
								</td>
							</tr>
							<tr>
								<td height="35" colspan="2" align="center" valign="middle">
									<table width="330" border="0" align="center" cellpadding="0" cellspacing="0" >
									<tr>
										<td>
										<div > 
										<input type="submit" value="Submit" class="but_img">
										<input type="reset" value="Reset" class="but_img">
										 <input type="button" value="Cancel" onClick="onCancel()" class="but_img">
											<!-- <html:submit styleClass="but_img" styleId="submitID"  property="submit" onclick="return Onsubmit1()" >Register</html:submit> -->
										</div>
									</td>
									<!-- <td style="padding-right:5px">
										<div id="select_hot">
											<a href="register.jsp">Reset</a> 
										</div>
									</td>
									<td>
										<div id="select_hot">
											<html:button styleClass="but_img" styleId="submitID"  property="submit" onclick="oncan()">Cancel</html:button>
										</div>
									</td> -->
								</tr>
								</table>
							</td>
						</tr>
						
					 
					 
				<!--	  <tr> 
							<td align="right" class="mediumblack">First Name:
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
								<input type="text" name="Email"  onblur="checkEmail(4)" id="Email" maxlength="50" style="width:150px;" tabindex="5"> 
							<input type="hidden" name="emailIdexists"	>
						  	</td> 
							<td align="right" class="strong">Postal Code:</td> 
							<td align="left"><input type="text" name="LastName2" id="LastName2" maxlength="50" style="width:150px;" tabindex="4"></td> 
						</tr> 
						<tr> 
							<td align="right" class="strong"> 
								Preferred City:
							</td> 
							<td align="left"> 
	<select name="PrefCity" id="PrefCity"  onchange="city()">
	<option value="">-------Select--- </option>							
   	<c:forEach var="dList2" items="${dropDownList.cities}"  varStatus="status">
  	<option value="${dList2.cityId}">${dList2.cityName}</option>
 	 
    
     
 
    </c:forEach>
	</select>			
	<input type="hidden" name="hPrefCity"	>		 		</td> 
							<td align="right" class="strong"> 
								Phone Number:
							</td> 
							<td align="left"> 
								<input type="text" name="Phone" id="Phone" maxlength="10" onkeypress="return isNumberKey(event)"  style="width:150px;" tabindex="8"> 
							</td> 
						</tr>
						
						
						<tr> 
							<td align="right" class="strong"> 
								Password:
							</td> 
							<td align="left"> 
								<input type="password" name="Password" id="Password" maxlength="50" style="width:150px;" tabindex="8"> 
							
	 	 		</td> 
							<td align="right" class="strong"> 
								Confirm Password:
							</td> 
							<td align="left"> 
								<input type="password" name="CPassword" id="CPassword" maxlength="50" style="width:150px;" tabindex="8"> 
							</td> 
						</tr> 
						
						 
		  				<tr> 
							<td align="center" colspan="4"> <br>
								<input type="submit" value="Submit">
							</td> 
						</tr> 
						-->
					</table> 
					
					
					 
					</form> 
					
				</td>
			</tr>
			</table>
			
			
			
			
			
			
			
		
		</td>
	</tr>
	</table>
		

	<!------------------------------ START FOOTER ------------------------------>
	
	<!--  <div style="background-color:#FFFFF;" id="footer-inner"> 
		<div class="footer_in"> 
 <a href="http://www.tangotab.com/jsp/search.do" >Search Restaurants</a> I 
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
	</div> -->
	<%@ include file="landfooter.jsp" %> 
</div>
</body>

</html>
