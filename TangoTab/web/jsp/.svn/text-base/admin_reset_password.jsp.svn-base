<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="admin_imports.jsp"%>
		
		<script type="text/javascript">

		 function Onsubmit1(){
			 
				document.getElementById("cpwd").innerHTML = "";
					document.getElementById("pwd").innerHTML = "";
				if(document.ResetPasswordForm.newPassword.value=="" || document.ResetPasswordForm.newPassword.value.length==0)
				{
				   document.getElementById("pwd").innerHTML = "Password Required";
				 return false;
				}else if(document.ResetPasswordForm.newPassword.value.length<6)
				{
				   document.getElementById("pwd").innerHTML = "Password  length can't be less than 6. ";
				 return false;
				}else if(document.ResetPasswordForm.confirmPassword.value=="" || document.ResetPasswordForm.confirmPassword.value.length==0)
				{
				   document.getElementById("cpwd").innerHTML = "Confirm Password Required";
				 return false;
				}else if(document.ResetPasswordForm.confirmPassword.value.length<6)
				{
				   document.getElementById("cpwd").innerHTML = "Confirm Password  length can't be less than 6.";
				 return false;
				}else if(document.ResetPasswordForm.newPassword.value!=document.ResetPasswordForm.confirmPassword.value)
				{
				  	document.getElementById("cpwd").innerHTML = "Password and  ConfirmPassword both are not same";
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
			
			
function getRandomNum(lbound, ubound) {
return (Math.floor(Math.random() * (ubound - lbound)) + lbound);
}
function getRandomChar( ) {
var numberChars = "0123456789";
var lowerChars = "abcdefghijklmnopqrstuvwxyz";
var upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
var charSet = "";
 
charSet += numberChars;
 
charSet += lowerChars;
 
charSet += upperChars;
 
 
return charSet.charAt(getRandomNum(0, charSet.length));
}
function getPassword(length ) {
var rc = "";
if (length > 0)
rc = rc ;
for (var idx = 1; idx < length; ++idx) {
rc = rc + getRandomChar( );
}	 
document.ResetPasswordForm.newPassword.value=rc;

document.ResetPasswordForm.confirmPassword.value=rc;
 
}
		</script>
		
	</head>
	<body>
		<div id="wrapper">
	         <div id="main">
			<jsp:include page="header.jsp">
				<jsp:param name="currentPage" value="MyAccount" />
			</jsp:include>
			<div class="cantainer_inner">
			<div class="main_cantainer">
				<div class="cantainer_content">

					<div class="inner_cantainer">
						<div class="main_deal">

							<div class="top_header">
								<img src="../images/corner_left.jpg" align="left" />
								<img src="../images/corner_right.jpg" align="right" />
							</div>

							<div class="content_deal_inner">
						<table width="968" border="0" cellspacing="0" cellpadding="0">
						   <c:if test="${(userInfo.roleId eq 5 ) or (userInfo.roleId eq 6 )}">
								      <%@ include file="client_banner.jsp"%>
		      	  						<%@ include file="client_menu.jsp"%>
		      	  						</c:if>	
		      	  			   <c:if test="${userInfo.roleId eq 4 }">	
		      	  			     <%@ include file="consumer_banner.jsp"%>
		      	  			   </c:if>	
		      	  			   		   <c:if test="${userInfo.roleId eq 1 }">	
		      	  			         <%@ include file="admin_banner.jsp" %>
		      	  			         </c:if>
							<tr>
								<td height="27" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<html:form action="/jsp/adminpasswordAction">
										<table width="968" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="8" background="../images/1.png"></td>
												<td width="952" height="8" background="../images/5.png"></td>
												<td width="8" background="../images/2.png"></td>
											</tr>
											<tr>
												<td width="8" background="../images/7.png"></td>
												<td height="100" width="952" align="center" valign="top">
													<table width="950" border="0" align="center"
														cellpadding="0" cellspacing="5">
														<tr>
															<td height="30" colspan="3" align="center"
																valign="middle" class="red_max">
																Reset Password
																<html:hidden property="type" value="reset_password" />
																<html:hidden property="emailId"  />
															</td>
														</tr>
														 
																<html:hidden property="password"
																	styleClass="restaurant_input" />
												 
														<tr>
															<td width="40%" align="right" valign="middle" class="bla_low">
																New Password<span class="red_text">*</span>:
															</td>
															<td width="20%" align="left" valign="middle">
														 
																<html:password property="newPassword" styleId="newPassword" onkeypress="return isSpace(event);" onkeyup="checkPassword(this);hidetext('pwd')"
																	styleClass="restaurant_input" value=""></html:password>
															</td>
															<td  width="40%" align="left" valign="middle"> 
																<span  class="red_text" id="pwd"><html:errors property="newPassword" /></span>
													
																  <span id="strength" style="color:green;font-weight:bold;"></span> 
															</td>
														</tr>
														<tr>
															<td width="40%" align="right" valign="middle" class="bla_low">
																Retype New Password<span class="red_text">*</span>:
															</td>
															<td width="20%" align="left" valign="middle">
																<html:password property="confirmPassword" styleId="confirmPassword" onkeyup="hidetext('cpwd')"  onkeypress="return isSpace(event);"
																	styleClass="restaurant_input"  value=""> </html:password>
															</td><td  width="40%" align="left" valign="middle"> 
																<span class="red_text" id="cpwd"><html:errors property="confirmPassword" /></span>
															</td>
														</tr>
														
													<tr>
															<td colspan="3" align="center" valign="middle" class="gre_low">
																<div id="select_hot_max">
																<div style="float:left">
																				Please enter the password of your choice or click here <html:button styleClass="login_but_big_gre" value="Genarate Password" onclick="getPassword(9);" property="Genarate Password"  />
																			</divv></div> </td>
														</tr>
														
														<tr>
															<td height="55" colspan="3" align="center"
																valign="middle">
																<table width="330" border="0" align="center"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td>
																			<div id="select_hot">
																				<html:submit  styleClass="but_img" onclick="return Onsubmit1();">Submit</html:submit>
																			</div>
																		</td>
																		<td>
																			<div id="select_hot">
																				<c:if test="${userInfo.roleId == 1}">
																					<a href="viewNames.do?operation=display">Cancel</a>
																				</c:if>
																				
																			</div>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td colspan="3" align="center">
																<logic:messagesPresent message="true">
																	<html:messages id="message" message="true">
																		<logic:present name="message">
																			<tr>
																				<td align="center" valign="middle" colspan="2">
																					<FONT color="red"> <bean:write
																							name="message" filter="false" /> </FONT>
																					<br>
																				</td>
																			</tr>
																		</logic:present>
																	</html:messages>
																</logic:messagesPresent>
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
										</table>
									</html:form>
									<!-- form End-->
								</td>
							</tr>
						</table>
					</div>
							<div class="top_bottom">
								<img src="../images/corner_bottom_left.jpg" align="left" />
								<img src="../images/corner_bottom_right.jpg" align="right" />
							</div>

							<%@ include file="footer.jsp"%>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div style="clear: both;"></div>
	</div>
</div>
	</body>
</html>