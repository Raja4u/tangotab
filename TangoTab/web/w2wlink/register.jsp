<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

	String emailId="";
	if(request.getParameter("emailId")!=null && !request.getParameter("emailId").equals("Email Address"))
	emailId=request.getParameter("emailId");
	
	String refferCode="";
	if(request.getParameter("refferCode")!=null)
	refferCode=request.getParameter("refferCode");

%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>TangoTab</title>
	
	<link href="http://www.tangotab.com//css/tangotab.css" rel="stylesheet" type="text/css" /> 

	<style>
		body{ margin:0px; padding:0px; background:#000000; font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif; color:#ffffff;}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		#wrap{ margin:0px auto; padding:0px; width:967px; clear:both;}

		
		.normalwhite 	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:12px; }
		.normalblack	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:12px; }
		
		.fineprint		{ font-family:Arial, Helvetica, sans-serif; color:#666666; font-size:11px; font-style:italic }
		
		.normalgreen 	{ font-family:Arial, Helvetica, sans-serif; color:#7d9b17; font-size:12px; }
		.normalorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:12px; }
		
		.mediumorange	{ font-family:Arial, Helvetica, sans-serif; color:#e09e09; font-size:14px; font-weight:bold; }
		.mediumwhite	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:14px; font-weight:bold; }
		
		.largewhite		{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:18px;  }
		
	</style>
	
	
	
	
	<%@ include file="../jsp/consumer_imports.jsp"%>
	
	
	
	<script type="text/javascript">

		 function Onsubmit1()
		 {		 
			document.getElementById("cpwd").innerHTML = "";
				document.getElementById("pwd").innerHTML = "";
			if(document.userForm.password.value=="" || document.userForm.password.value.length==0)
			{
			   document.getElementById("pwd").innerHTML = "Password Required";
			 return false;
			}else if(document.userForm.password.value.length<8)
			{
			   document.getElementById("pwd").innerHTML = "Password  length can't be less than 8. ";
			 return false;
			}else if(document.userForm.cpassword.value=="" || document.userForm.cpassword.value.length==0)
			{
			   document.getElementById("cpwd").innerHTML = "Confirm Password Required";
			 return false;
			}else if(document.userForm.cpassword.value.length<8)
			{
			   document.getElementById("cpwd").innerHTML = "Confirm Password  length can't be less than 8";
			 return false;
			}else if(document.userForm.password.value!=document.userForm.cpassword.value)
			{
				document.getElementById("cpwd").innerHTML = "Password and  ConfirmPassword both are not same";
			 return false;
			}else if(document.userForm.agree.checked==false)
			{
				document.getElementById("msgid").innerHTML = "Please accept the Privacy Policy and User Agreement";
			 return false;
			}
			else 
			{ 
				return true;
			}
		}
			
		function oncan()
		{
			// when they click the cancel button, take them back to previous page
			history.go( -1 );
		}
		
		function hidetext(id)
		{
			document.getElementById(id).innerHTML = "";
		}
						
		function get_check_value()
		{
			var c_value = "";
			for (var i=0; i < document.userForm.agree.length; i++)
			{   
			   	if (document.userForm.agree[0].checked)
				{
			 		c_value =  document.userForm.agree[i].value ;
				}
			}
			return c_value;
		}
	
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
			pw=new StrPassword(id.value, special_chars);
		
			var verdict = pw.getStrength();
		   //alert(id.value.length);
			element = document.getElementById("strength");
			if(id.value.length>0)
			element.innerHTML = verdict;
		}
	
	</script>	
	
	
	
	
	
	
	
	
	
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
				
					<a href="http://www.tangotab.com/jsp/search.do" class="normalwhite" style="text-decoration:none;">
						Search Deals
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/jsp/how_it_works.jsp" class="normalwhite" style="text-decoration:none;">
						How It Works
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/refer/referfriends.jsp" class="normalwhite" style="text-decoration:none;">
						Refer a Friend
					</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					
					<a href="http://www.tangotab.com/ourcharities.jsp" class="normalwhite" style="text-decoration:none;">
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
			
			<img src="images/whenyoueat.jpg" border="0" align="bottom"><br>
			<br>
			<br>
			<a href="http://w2wlink.com/" target="_blank">
				<img src="images/w2wlogo.jpg" border="0">
			</a>
			<br>
			<br>
			
			<font class="mediumorange" style="font-size:26px;">&amp;</font>
			
			<br>
			<br>
			<img src="http://www.tangotab.com/images/logo.png" border="0" align="bottom"><br>
			<br>
			<br>
			<img src="images/workingtogether.jpg" border="0" align="bottom"><br>
			<br>
			<br>
			<br>
			
		</td>
		
		<!------------------------------ RIGHT COLUMN ------------------------------>
		<td width="667" valign="top" align="left">
		
			
			
							<table width="667" border="0" cellspacing="5" cellpadding="5">

								<!-- form Start-->
								<html:form  action="../jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
									
									<!-- ********** Page to return to after submit is complete *********** -->
									<input type="hidden" name="pageSource" id="pageSource" value="http://www.tangotab.com/w2wlink/submitsignup.jsp">
									<!-- ********** Page to return to after submit is complete *********** -->
										
										
										
										
												
							<tr>
								<td height="12" colspan="2" align="center" valign="middle" class="red_text">
										<logic:messagesPresent message="true">
										<html:messages id="message" message="true">
										<logic:present name="message">
											<tr>
												<td align="center" valign="middle" colspan="2">
													<FONT color="red"><bean:write name="message" filter="false" /> </FONT>
												</td>
											</tr>
										</logic:present>
										</html:messages>
										</logic:messagesPresent>
								</td>
							</tr>
							<tr>
								<td height="30" colspan="2" align="center" valign="middle" class="red_max">
									Guest Registration
								</td>
							</tr>
							<tr>
								<td  width="150" align="right" valign="middle" class="normalblack">
									First Name<span class="red_text">*</span>:
								</td>
								<td  align="left" valign="middle">
	
									<html:text property="firstname" styleClass="restaurant_input" styleId="firstName"  onkeyup="hidetext('fname')"></html:text>  
										<span  class="red_text" id="fname"><html:errors property="firstname" /></span> 
									<html:hidden property="refferCode"  value="<%=refferCode %>"/>
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Last Name</span><span	class="red_text">*</span>: 
								</td>
								<td align="left" valign="middle">
									<html:text property="lastname" styleClass="restaurant_input" styleId="lastName"  onkeyup="hidetext('lname')"></html:text>
										<span  class="red_text" id="lname"><html:errors property="lastname" /></span>
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
												<html:text property="emailId"	value="<%=emailId%>"styleClass="restaurant_input" styleId="emailId"   onblur="checkEmail(4)"></html:text> 
											 </td>
											<td width="285" align="left" valign="top" class="red_text" >
												<span  class="red_text" id="emailId"><html:errors property="emailId"  /></span>
						 						<div id="checkEmailId"></div>
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
									<html:password property="password" styleClass="restaurant_input"  onkeypress="return isSpace(event);" onkeyup="checkPassword(this);hidetext('pwd')"  value="" >  </html:password>
									</div>
									<span class="blue_text">&nbsp; Password should contain minimum eight alphanumeric characters</span>
									<div id="strength" style="float:left;color:green;font-weight:bold;"></div> 
									<span  class="red_text" id="pwd"><html:errors property="password" /></span>
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Confirm Password</span><span
										class="red_text"  >*</span>: 
								</td>
								<td align="left" valign="middle">
									<html:password property="cpassword" styleClass="restaurant_input" styleId="cpassword" onkeyup="hidetext('cpwd')"  onkeypress="return isSpace(event);"value=""></html:password>
									<span class="red_text" id="cpwd"><html:errors property="cpassword" /></span>
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="normalblack">
									Zip/Post Code<span class="red_text">*</span>:
								</td>
								<td align="left" valign="middle"> 
									<html:text property="zipCode" styleClass="restaurant_input" styleId="zipCodeID"   onkeyup="hidetext('zcode')"></html:text>
									<span  class="red_text" id="zcode">	 <html:errors property="zipCode" /></span>
								</td>
							</tr>
													
							<tr>
								<td align="right" valign="middle" class="normalblack">
									Preferred City<span class="red_text">*</span>:
								</td>
								<td align="left" valign="middle">
									<html:select property="preferCity"  styleClass="restaurant_select" styleId="preferCity"  value="${userInfo.consumerPreferCity.cityName}">
									<html:option value="0">Select City</html:option>
									<bean:define id="relationships2" name="dropDownList" property="cities" type="java.util.ArrayList"/>
									<html:options collection="relationships2" property="cityId" labelProperty="cityName"/>
									</html:select>	 <html:errors property="preferCity" />
								</td>
							</tr>
							<tr>						
								<td align="right" valign="middle" class="normalblack">
									<span class="normalblack">Mobile Number</span>:
								</td>
								<td align="left" valign="middle">
									<html:text property="mobilePhone" styleClass="restaurant_input"  onkeypress="return isNumberKey(event)"  maxlength="10" onkeyup="hidetext('cpwd')"></html:text>
									<span class="blue_text">(e.g., 2125551212)&nbsp;&nbsp;[If you would like to be notified of deals via SMS*] </span>
									<span  class="red_text" id="mphone"><html:errors property="mobilePhone" /></span>
								</td>
							</tr> 
							<tr>
								<td  colspan="3" id="msgid" class="normalblack" align="center">
									&nbsp;
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
										<div id="submitId"> 
											<html:submit styleClass="but_img" styleId="submitID"  property="submit" onclick="return Onsubmit1()" >Register</html:submit>
										</div>
									</td>
									<td style="padding-right:5px">
										<div id="select_hot">
											<a href="register.jsp">Reset</a> 
										</div>
									</td>
									<td>
										<div id="select_hot">
											<html:button styleClass="but_img" styleId="submitID"  property="submit" onclick="oncan()">Cancel</html:button>
										</div>
									</td>
								</tr>
								</table>
							</td>
						</tr>
						</html:form>
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
			Copyright © 2000-2011 TangoTab.com All rights reserved.
		</div> 
	</div> 
	
</div>
</body>

</html>
