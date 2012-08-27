<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title> TangoTab </title>
	
	<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="http://tangotab.com/js/util.js"></script>
<link rel="shortcut icon" href="../images/TangoT_Icon.ico" />
	<style>
		body{ margin:0px; padding:0px; background:#000000; font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif; color:#ffffff;}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		#wrap{ margin:0px auto; padding:0px; width:967px; clear:both;}
		.normalwhite 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; }
		.normalgreen 	{ font-family:Arial, Helvetica, sans-serif; color:#7d9b17; font-size:12px; }
		.normalorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:12px; }
		.normalblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:12px; }
		.mediumorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:14px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		.header 		{font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#666666;}
		.title  		{font-family:Arial, Helvetica, sans-serif; font-size:28px; font-weight:bold; color:#7d9b17;} 
		.dealtitle  	{font-family:Arial, Helvetica, sans-serif; font-size:24px; font-weight:bold; color:#7d9b17;} 
		.title2	  		{font-family:Arial, Helvetica, sans-serif; font-size:20px; font-weight:bold; color:#7d9b17;} 
		.dealtext		{font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#000000;} 
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
				msg += "     * 	Password and ConfirmPassword both are not same.\r\n";
			}
	 
			if( form.Email.value != ""  && form.emailIdexists.value == 1 )
			{
				msg += "     * Your Email Address is already exists.\r\n";
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
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>
	
	
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
					
					<a href="http://www.tangotab.com/jsp/consumer_registration.jsp" class="mediumwhite" style="text-decoration:none;">Sign Up</a>
					
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/login.jsp" class="mediumorange" style="text-decoration:none;">Sign In</a>
					
				</td>
			</tr>
			<tr>
				<td bgcolor="#000000" align="right" valign="bottom" class="normalwhite">
				
					<a href="http://www.tangotab.com/jsp/search.do" class="normalwhite" style="text-decoration:none;" target="_blank">
						Search Deals
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/how_it_works.jsp" class="normalwhite" style="text-decoration:none;" target="_blank">
						How It Works
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/refer/referfriends.jsp" class="normalwhite" style="text-decoration:none;">
						Refer a Friend
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/chairty.jsp" class="normalwhite" style="text-decoration:none;">
						Our Charities
					</a>
					
				</td>
			</tr>
			</table>

		</td>
	</tr>
	</table>

	<!------------------------------ END HEADER ------------------------------>








	<!------------------------------ START BODY ------------------------------>





	<table cellpadding="10" cellspacing="0" border="0" width="967" align="center" bgcolor="#ffffff" height="70" style="height:70px;">
	<tr>
	
		<!------------------------------ LEFT COLUMN ------------------------------>
		<td width="300" valign="top" align="center">
			
			<img src="images/didyouknow.jpg" border="0" align="bottom"><br>
			
			
		</td>
		
		<!------------------------------ RIGHT COLUMN ------------------------------>
		<td width="667" valign="top">
		
			
			
			
			<table cellpadding="5" cellspacing="0" border="0" width="667" align="center">
			<tr>
				<td width="667" align="center" valign="top" class="title2">
					<br><br>
					<div class="mediumorange">
					Guest Registration
					</div>
					

				</td>
			</tr>
					<tr>
				<td colspan="3" align="center"  id="checkEmailId" class="red_text" height="20px;" style="font-size: 12px;"  >
				&nbsp;
						   
						    </td></tr>
			<tr>
				<td colspan="3" align="center" valign="top" class="normalblack">
					Please provide your name and email address:
			
					 <form action="submitsignup.jsp" method="post" name="RegistrationForm" onSubmit="return validateForm();" >
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
								<input type="text" name="Email"  onblur="checkEmail(4)" id="Email" maxlength="50" style="width:150px;" tabindex="5"> 
							<input type="hidden" name="emailIdexists"	>
							<!-- change the reffercode between 1001 to 1250 but every time give different one   -->
								<input type="hidden" name="refferCode"	 value="1003" >		</td> 
							<td align="right" class="strong">Postal Code:</td> 
							<td align="left"> 
								<input type="text" name="Zip"  maxlength="6" id="Zip" maxlength="50" style="width:150px;" tabindex="6"> 
							</td> 
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
						
					</table> 
					
					
					 
					</form> 
					
				</td>
			</tr>
			</table>
			
			
			
			
			
			
		
		</td>
	</tr>
	</table>
		

	<!------------------------------ START FOOTER ------------------------------>
	
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
			Copyright © 2000-2012 TangoTab.com All rights reserved.
		</div> 
	</div> 
	
</div>
</body>

</html>
