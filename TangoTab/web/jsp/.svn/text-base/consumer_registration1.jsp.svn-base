<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
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
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		<script type="text/javascript">

		 function Onsubmit1(){
			 
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
				}else 
				{ 
							return true;
				}
		
			
			//	document.forms[0].action = "userReg.do?type=consumer";
			//	document.forms[0].submit();
			}function oncan()
			{
			window.location='index.jsp';
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
		</script>
	</head>
	<body > 
		<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  	 
  	 
  	 
  	 <!-- start login -->
  	 
  	 
  	 
  	 
  <table width="965" border="0" cellspacing="0" cellpadding="0" class="form_txt">
							
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
										<table width="965" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td background="../images/1.png"></td>
											<td width="949" height="8" background="../images/5.png"></td>
											<td background="../images/2.png"></td>
										</tr>
										
										<tr>
											<td width="8" background="../images/7.png"></td>
											<td height="100" align="center" valign="top">
												<table width="900" border="0" align="center" cellpadding="0"
													cellspacing="5">
													<tr>
														<td height="12" colspan="2" align="center" valign="middle"
															class="red_text">
															<logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="2">
															<FONT color="red"><bean:write name="message"
																	filter="false" /> </FONT>
														</td>
													</tr>
												</logic:present>
											</html:messages>
										</logic:messagesPresent>
														</td>
													</tr>
													<tr>
														<td height="30" colspan="2" align="center" valign="middle"
															class="red_max">
															<h1>Guest Registration</h1>
														</td>
													</tr>
													<tr>
														<td>&nbsp;
															
														</td>
													</tr>
													<tr>
														<td  width="350" align="right" valign="middle"
															class="bla_low">
															First Name <span class="red_text">*</span>:
														</td>
														<td  align="left" valign="middle">
															<!-- <input type="text" class="restaurant_input"  /> -->
															<html:text property="firstname" 
																styleClass="substxt" styleId="firstName"  onkeyup="hidetext('fname')"></html:text>  
																<span  class="red_text" id="fname"><html:errors property="firstname" /></span> 
															<html:hidden property="refferCode"  value="<%=refferCode %>"/></td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Last Name </span><span
																class="red_text">*</span>: 
														</td>
														<td align="left" valign="middle">
															<html:text property="lastname" 
																styleClass="substxt" styleId="lastName"  onkeyup="hidetext('lname')"></html:text>
																<span  class="red_text" id="lname"><html:errors property="lastname" /></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low">
															Email <span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
												                  <tr>
												                    <td width="163" align="left" valign="top">
												                    	<html:text property="emailId"	value="<%=emailId%>"styleClass="substxt" styleId="emailId"   onblur="checkEmail(4)"></html:text> 
												                     </td>
												                    <td width="285" align="left" valign="top" class="red_text" >
												                    	<span  class="red_text" id="emailId"><html:errors property="emailId"  /></span>
												
												                    
												                    <div id="checkEmailId"></div></td>
												                  </tr>
												                </table>
														</td>
														
													</tr>
													<tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Password <span
																class="red_text">*</span></span>: 
														</td>
														<td align="left" valign="middle">
														<div style="float:left">
															<html:password property="password"  
																styleClass="substxt"  onkeypress="return isSpace(event);" onkeyup="checkPassword(this);hidetext('pwd')"  value="" >  </html:password>
																</div>
																<span class="blue_text">&nbsp; Password should contain minimum eight alphanumeric characters</span>
																<div id="strength" style="float:left;color:green;font-weight:bold;"></div> 
																	<span  class="red_text" id="pwd"><html:errors property="password" /></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Confirm Password</span><span
																class="red_text"  >*</span>: 
														</td>
														<td align="left" valign="middle">
															<html:password property="cpassword" 
																styleClass="substxt" styleId="cpassword" onkeyup="hidetext('cpwd')"  onkeypress="return isSpace(event);"value=""></html:password>
																<span
																class="red_text" id="cpwd"><html:errors property="cpassword" /></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="bla_low">
															Zip/Post Code <span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle"> 
															<html:text property="zipCode"  
																styleClass="substxt" styleId="zipCodeID"   onkeyup="hidetext('zcode')"></html:text>
													<span  class="red_text" id="zcode">	 <html:errors property="zipCode" /></span></td>
													</tr>
													
			                        <tr>
			                <td align="right" valign="middle" class="bla_low">Preferred City<span class="red_text">*</span>:</td>
			                <td align="left" valign="middle"><html:select property="preferCity"  styleClass="listboxeffect" style="width:150px; border-color:#000000;" styleId="preferCity"  value="${userInfo.consumerPreferCity.cityName}">
			                <html:option value="0">Select City</html:option>
			                <bean:define id="relationships2" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    			<html:options collection="relationships2" property="cityId" labelProperty="cityName"/>
			                </html:select>	 <html:errors property="preferCity" /></td>
			              </tr>
													<!--<tr>
														<td height="1" colspan="2" align="right" valign="middle"
															bgcolor="#999999"></td>
													</tr>
													--><tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Mobile Number</span>:
														</td>
														<td align="left" valign="middle">
															<html:text property="mobilePhone" 
																styleClass="substxt"  onkeypress="return isNumberKey(event)"  maxlength="10" onkeyup="hidetext('cpwd')"></html:text>
														<span class="blue_text">(e.g., 2125551212)&nbsp;&nbsp;[If you would like to be notified of deals via SMS*] </span>
														<span  class="red_text" id="mphone"><html:errors property="mobilePhone" /></span></td>
													</tr> 
														<tr>
														<td  colspan="3" id="msgid" class="red_text" align="center">&nbsp;
														</td>
													</tr>
												<tr>
														<td height="27" align="right" valign="middle">&nbsp;
															
														</td>
														<td align="left" valign="middle" >
															<input type="checkbox" class="text_agree" name="agree" id="checkbox24"  value="ok"/>
															I certify that I have read and agree to the
															<span class="text_h8"> <a href="privacy_policy.jsp"
																class="red_text"  target="_blank" >privacy policy</a></span> and
														
														
															<a href="terms.jsp"  class="red_text" target="_blank">terms of use</a> of TangoTab.
														</td>
														</tr>
														<tr>
			                                      <td colspan="2" align="right" valign="middle" class="text_h10">
			                                       <div>[NOTE*Standard text messaging charges may apply as per your mobile service provider*]
			                                        </div></td>
		                                                </tr>
													<tr>
														<td height="35" colspan="2" align="center" valign="middle">
															<table width="305" border="0" align="center" style="padding-left:71px;"
																cellpadding="0" cellspacing="0" >
																<tr>
																	<td>
																		<div id="submitId"> 
																			<html:submit styleClass="but_img" styleId="submitID"  property="submit" onclick="return Onsubmit1()" >Register</html:submit>
																		</div>
																	</td>
																	<td style="padding-right:5px">
																		<div id="select_hot">
																 <a href="consumer_registration.jsp">Reset</a> 
																		</div>
																	</td>
																	<td>
																		<div id="select_hot">
																			<html:button styleClass="but_img" styleId="submitID"  property="submit" onclick="oncan()">Cancel</html:button>
																			<!-- <a href="index.jsp">Cancel</a>
																			 -->
																		</div>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
											<td width="8" background="../images/8.png"></td>
										</tr>
										<tr>
											<td height="8" background="../images/3.png"></td>
											<td height="8" background="../images/6.png"></td>
											<td height="8" background="../images/4.png"></td>
										</tr>
									</table></html:form>
									
									<!-- form End-->
								</td>
							</tr>
						</table>

            </div>
            <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>
</div>
	</body>
</html>