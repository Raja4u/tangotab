<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>
<script type="text/javascript">
	function submitAction() {
		document.forms[0].action = "restReg.do?type=restaurant";
		document.forms[0].submit();
	}
	function getNoof(btype)
	{
	 
		if(btype==1)
		{
		 document.getElementById("noofloc").innerHTML = "<input type='hidden' name='noOfLocations' value='1' /><input type='text' name='noOfLocations' disabled='true' value='1' />";
		}else 
		{
			 document.getElementById("noofloc").innerHTML = "<input type='text' name='noOfLocations' value='2'   onkeypress='return isNumberKey(event)'/>";
		}
	}
	
	 function Onsubmit1(){
			 
				document.getElementById("cpwd").innerHTML = "";
					document.getElementById("pwd").innerHTML = "";
			  	if(document.clientForm.password.value=="" || document.clientForm.password.value.length==0)
				{
				   document.getElementById("pwd").innerHTML = "Password Required";
				 return false;
				}else if(document.clientForm.password.value.length<6)
				{
				   document.getElementById("pwd").innerHTML = "Password  length can't be less than 6. ";
				 return false;
				}else if(document.clientForm.cpassword.value=="" || document.clientForm.cpassword.value.length==0)
				{
				   document.getElementById("cpwd").innerHTML = "Confirm Password Required";
				 return false;
				}else if(document.clientForm.cpassword.value.length<6)
				{
				   document.getElementById("cpwd").innerHTML = "Confirm Password  length can't be less than 6";
				 return false;
				}else if(document.clientForm.password.value!=document.clientForm.cpassword.value)
				{
				  	document.getElementById("cpwd").innerHTML = "Password and  Confirm Password must be the same";
				 return false;
				}else 
				{ 
							return true;
				}
		
			
			//	document.forms[0].action = "userReg.do?type=consumer";
			//	document.forms[0].submit();
			}
	function oncan()
			{
			window.location='index.jsp';
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

    var pw = new StrPassword(id.value, 
                           special_chars);

    var verdict = pw.getStrength();
   
    element = document.getElementById("strength");
        if(id.value.length>0)
    element.innerHTML = verdict;
}
function terms()
{
window.location='terms.jsp';
}

function delete_cookie ( cookie_name )
{
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
}



</script>
</head>
<body onload="delete_cookie('showhidt');">

<div id="wrapper">
	<div id="main"><jsp:include page="header.jsp">
	<jsp:param name="currentPage" value="Login" />
</jsp:include>
<div class="cantainer_inner">
<div class="main_cantainer">
<div class="cantainer_content">

<div class="inner_cantainer">
<div class="main_deal">

<div class="top_header"><img src="../images/corner_left.jpg"
	align="left" /> <img src="../images/corner_right.jpg" align="right" /></div>

<div class="content_deal_inner">

<table width="965" border="0" cellspacing="0" cellpadding="0" class="form_txt">


	<tr>
		<td height="15" align="center" valign="top">
		<html:form	action="jsp/restReg.do?type=restaurant"
			onsubmit="return Onsubmit1();"></td>
	</tr>
	<tr>
<td style="background:url(../images/1.png) no-repeat;"></td>
<td width="949" height="8" style="background:url(../images/5.png) repeat-x;"></td>
<td style="background:url(../images/2.png) no-repeat;"></td>
</tr>
<tr>
<td width="8" style="background:url(../images/7.png) left top repeat-y;"></td>
<td valign="top" height="100" align="center">
			
		<table width="900" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="middle">
				<table width="900" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">

							<tr>

								<td height="100" align="center" valign="top">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="5">
									<tr>
										<td height="30" colspan="3" align="center" valign="middle">
										<table width="80%" border="0" align="center" cellpadding="0"
											cellspacing="5">
											<tr>
												<td><b>Step 1<br />
												Basic Account info</b></td>
												<td><b><img
													src="../images/rightarrowb.png" width="100px" height="30px" /></b>												</td>
												<td><b>Step 2<br />
												Business Info</b></td>

												<td><img src="../images/rightarrowb.png"
													width="100px" height="30px" /></td>
												<td align="left"><b>Step 3<br />
												Charge your account</b></td>
											</tr>
										</table>										</td>
									</tr>
									<tr>
										<td height="30" colspan="3" align="center" valign="middle"
											class="red_max"><h2> Host Registration - Account
									  Information</h2></td>
									</tr>
									<logic:messagesPresent message="true">
										<html:messages id="message" message="true">
											<logic:present name="message">
												<tr>
													<td align="center" valign="middle" colspan="3"><FONT
														color="red"> <bean:write name="message"
														filter="false" /> </FONT> <br>													</td>
												</tr>
											</logic:present>
										</html:messages>
									</logic:messagesPresent>
									
									
									<tr>
									<td>
									   <table align="center" width="100%">
									   <!-- here -->	
									
									
									<tr>
										<td width="44%" align="right" valign="middle" class="bla_low">
										Business Name<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:text
											property="businessName" styleClass="substxt"
											onkeyup="hidetext('businessName')"></html:text> <span
											class="red_text" id="businessName"> <html:errors
											property="businessName" /> </span></td>
									</tr>
									<tr>
										<td height="24" align="right" valign="middle" class="bla_low">
										Administrator's last name<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:text
											property="lastname" styleClass="substxt"
											onkeyup="hidetext('lastname')"></html:text> <span
											class="red_text" id="lastname"> <html:errors
											property="lastname" /></span></td>
									</tr>
									<tr>
										<td align="right" valign="middle" class="bla_low">
										Administrator's first name<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:text
											property="firstname" styleClass="substxt"
											onkeyup="hidetext('firstname')"></html:text> <span
											class="red_text" id="firstname"> <html:errors
											property="firstname" /></span></td>
									</tr>

									<tr>
										<td align="right" valign="middle" class="bla_low">
										Administrator's Email<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
											  <td width="345" align="left" valign="top"><html:text
													property="emailId" styleClass="substxt"
													styleId="emailId" onkeyup="hidetext('checkEmailId')"
													onblur="checkEmail(5)"></html:text></td>
												<td width="334" align="left" valign="top" class="red_text"
													id="checkEmailId"><span class="red_text" id="emailId">
											  <html:errors
													property="emailId" /></span></td>
											</tr>
										</table>										</td>
									</tr>
									<tr>
										<td align="right" valign="middle" class="bla_low">
										Password<span class="red_text">*</span>:</td>
										<td width="12%" align="left" valign="middle">

										<div style="float: left"><html:password
											property="password" styleClass="substxt" value=""
											onkeypress="return isSpace(event)"
											onkeyup="checkPassword(this);hidetext('pwd');">
										</html:password></div>
										
										<div id="strength"
											style="float: left; color: green; font-weight: bold;"></div>
									  <span class="red_text" id="pwd"> <html:errors
											property="password" /></span></td>
										
									    <td width="44%" align="left"><span class="blue_text" style="font-size:11px; color:grey;">Password should contain
										minimum eight alphanumeric characters</span></td>
									</tr>
									
										<tr><td align="right" valign="middle" class="bla_low">
										Confirm Password<span class="red_text">*</span>:</td>
										<td align="left" valign="middle"><html:password
											property="cpassword" styleClass="substxt"
											onkeyup="hidetext('cpwd')" onkeypress="return isSpace(event)"
											value="">
										</html:password> <span class="red_text" id="cpwd"> <html:errors
											property="cpassword" /></span></td>
									    <td align="left" style="font-size:11px; color:grey;">Please enter 2 security questions to help you retrieve your
										account information in the event of a forgotten password.</td>
									</tr>
									
									<tr>
										<td align="right" valign="middle" class="bla_low">
										Security Question 1<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:textarea
											property="question1" styleClass="substxt" style="height:50px;" /> <html:errors
											property="question1" /></td>
									</tr>
									<tr>
										<td align="right" valign="middle" class="bla_low">
										Answer1<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:text
											property="answer1" styleClass="substxt"
											onkeyup="hidetext('cpwd')" /> <html:errors
											property="answer1" /></td>
									</tr>


									<tr>
										<td align="right" valign="middle" class="bla_low">
										Security Question 2<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:textarea
											property="question2" styleClass="substxt" style="height:50px;" /> <html:errors
											property="question2" /></td>
									</tr>
									<tr>
										<td align="right" valign="middle" class="bla_low">
										Answer2<span class="red_text">*</span>:</td>
										<td colspan="2" align="left" valign="middle"><html:text
											property="answer2" styleClass="substxt"
											onkeyup="hidetext('cpwd')" /> <html:errors
											property="answer2" /></td>
									</tr>
</table>
</td>
</tr>
									<tr>
										<td height="45" colspan="5" align="center" valign="middle">
										<table width="240" border="0" align="center" cellpadding="0"
											cellspacing="5" style="padding:0 0 0 58px;">
											<tr>
												<td style="padding-top:5px;">
												<div id="select_hot"><a href="index.jsp">Cancel</a></div>												</td>
												<!--<td>
																		<div id="select_hot">
																			<a href="client_registration.jsp">Reset</a>
																	
																		</div>
																	</td>
																	-->
												<td>
												<div id="select_hot"><html:submit styleClass="but_img"
													property="submit" styleId="submitID" onclick="Onsubmit1();">Next</html:submit>
												</div>												</td>
											</tr>
										</table>										</td>
									</tr>
								</table>
								</td>

							</tr>

						</table>

						<p class="red_madium">&nbsp;</p>
						<p align="justify">&nbsp;</p>
						</td>
					</tr>

				</table>
				</td>
			</tr>
		</table>
		</td><td style="background:url(../images/8.png) left top repeat-y;" width="8">&nbsp;</td></tr>
<tr>
<td height="8" style="background:url(../images/3.png) no-repeat;" width="8">&nbsp;</td>
<td height="8" style="background:url(../images/6.png) repeat-x;" width="949">&nbsp;</td>
<td height="8" style="background:url(../images/4.png) no-repeat;" width="8">&nbsp;</td>
</tr>
</table>
		
		</td>
	</tr>

</table>
</html:form> <!-- form End-->
</td>
</tr>
</table>


<div style="clear: both;"></div>
</div>

<!--content  end here-->
<div style="clear: both;"></div>
<!--footer start here--></div>


</div>

</div>
<div class="top_bottom"><img
	src="../images/corner_bottom_left.jpg" align="left" /><img
	src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%></div>
</div>
</div>
</div>

</div>

<div style="clear: both;"></div>
</div>

</body>
</html>