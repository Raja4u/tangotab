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
		<%@ include file="consumer_imports.jsp"%>
		
		<script type="text/javascript">

		 function Onsubmit1(){
			 
				document.getElementById("cpwd").innerHTML = "";
					document.getElementById("pwd").innerHTML = "";
				if(document.userForm.newPassword.value=="" || document.userForm.newPassword.value.length==0)
				{
				   document.getElementById("pwd").innerHTML = "Password Required";
				 return false;
				}else if(document.userForm.newPassword.value.length<6)
				{
				   document.getElementById("pwd").innerHTML = "Password  length can't be less than 6. ";
				 return false;
				}else if(document.userForm.confirmPassword.value=="" || document.userForm.confirmPassword.value.length==0)
				{
				   document.getElementById("cpwd").innerHTML = "Confirm Password Required";
				 return false;
				}else if(document.userForm.confirmPassword.value.length<6)
				{
				   document.getElementById("cpwd").innerHTML = "Confirm Password  length can't be less than 6";
				 return false;
				}else if(document.userForm.newPassword.value!=document.userForm.confirmPassword.value)
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
		</script>
		
	</head>
	<body>
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
  	 
  	 
  	 <!-- start here  -->
  	 
		<table width="950" border="0" cellspacing="0" cellpadding="0" >
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
									<html:form action="/jsp/passwordAction">
										<table width="950" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td background="../images/1.png"></td>
												<td width="957" height="8" background="../images/5.png"></td>
												<td background="../images/2.png"></td>
											</tr>
											<tr>
												<td width="8" background="../images/7.png"></td>
												<td height="100" align="center" valign="top">
													<table width="740" border="0" align="center"
														cellpadding="0" cellspacing="5" class="form_txt">
														<tr>
															<td height="30" colspan="2" align="center"
																valign="middle" class="red_max">
															<h1>Reset Password</h1>
																<html:hidden property="type" value="reset_password" />
																<html:hidden property="emailId"
																	value="${userInfo.emailId}" />
															</td>
														</tr>
														<tr>
															<td width="22%" align="right" valign="middle"
																class="bla_low">
																<c:if test="${userInfo.isPwdChange eq 1}">
																Temporary password<span class="red_text">*</span>:
																</c:if>
																<c:if test="${userInfo.isPwdChange ne 1}">
																  Password <span class="red_text">*</span>:
																</c:if>
																
															</td>
															<td width="38%" align="left" valign="middle">
																<html:password property="password"
																	styleClass="substxt"  value=""></html:password>
																<html:errors property="password" />
															</td>
														</tr>
														<tr>
															<td align="right" valign="middle" class="bla_low">
																New Password <span class="red_text">*</span>:
															</td>
															<td align="left" valign="middle">
														 
																<html:password property="newPassword" styleId="newPassword" onkeypress="return isSpace(event);" onkeyup="checkPassword(this);hidetext('pwd')"
																	styleClass="substxt" value=""></html:password>
															 
																<span  class="red_text" id="pwd"><html:errors property="newPassword" /></span>
														
																  <span id="strength" style="color:green;font-weight:bold;"></span> 
															</td>
														</tr>
														<tr>
															<td align="right" valign="middle" class="bla_low">
																Retype New Password <span class="red_text">*</span>:
															</td>
															<td align="left" valign="middle">
																<html:password property="confirmPassword" styleId="confirmPassword" onkeyup="hidetext('cpwd')"  onkeypress="return isSpace(event);"
																	styleClass="substxt"  value=""> </html:password>
																<span class="red_text" id="cpwd"><html:errors property="confirmPassword" /></span>
															</td>
														</tr>
														<tr>
															<td height="55" colspan="2" align="center"
																valign="middle">
																<table width="180" border="0" align="center"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td>
																			<div id="select_hot">
																				<html:submit  styleClass="but_img" >Submit</html:submit>
																			</div>
																		</td>
																		<td>
																			<div id="select_hot">
																				<c:if test="${userInfo.roleId == 1}">
																					<a href="./index.jsp">Cancel</a>
																				</c:if>
																				<c:if test="${userInfo.roleId == 2}">
																					<a href="./index.jsp">Cancel</a>
																				</c:if>
																				<c:if test="${userInfo.roleId == 3}">
																					<a href="./index.jsp">Cancel</a>
																				</c:if>
																				<c:if test="${userInfo.roleId == 4}">
																					<a href="./search.do">Cancel</a>
																				</c:if>
																				<c:if test="${userInfo.roleId == 5}">
																					<a href="./profileEdit.do">Cancel</a>
																				</c:if>
																				<c:if test="${userInfo.roleId == 6}">
																					<a href="./profileEdit.do">Cancel</a>
																				</c:if>
																			</div>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td colspan="2" align="center">
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
						
						<!-- end here  -->
						
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