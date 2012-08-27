<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
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
	 
				   				
			    if(document.getElementById("noOfLocations").value=="" || document.getElementById("noOfLocations").value<1)
				{
				   document.getElementById("noOfLocationss").innerHTML = "Number of Locations Required ";
				    return false;
				}else if(document.getElementById("checkbox24").checked==false)
				{
					document.getElementById("msgid").innerHTML = "Please accept the Privacy Policy and User Agreement";
				    return false;
				}else 
				{
					return true;
				}
		
			
			 
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
      <tr>
        <td width="8" height="25" align="center" valign="top" background="../images/abtgre.jpg"></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top">
        			<html:form action="/jsp/clientProcess"  onsubmit="return Onsubmit1();">
        
        <table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td align="left" valign="top"><table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
           
              </table></td>
            </tr>
            <tr>
              <td height="250" align="left" valign="top" class="blue_border">
              <table width="955" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td align="center" valign="middle">
						<table width="968" border="0" cellspacing="0" cellpadding="0">
						 
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									<table width="968" border="0" cellspacing="0" cellpadding="0">
									 <tr>
														<td height="30" colspan="2" align="center" valign="middle"
															 >
															<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="5">
													<tr>
													<td  width="120px">Step 1<br/>
														Basic Account info 
													
													</td>
														<td  width="50px" ><b><img src="../images/rightarrowo.png" width="100px" height="30px"/></b>
													
													</td>
														<td   width="90px"><b>Step 2<br/>Business Info</b>
													
													</td>
													 
														<td  width="50px" ><b><img src="../images/rightarrowb.png" width="100px" height="30px"/></b>
													
													</td>
														<td   align="left" > Step 3<br/>
														Charge your account 
													
													</td>
													</tr>
													</table>
														</td>
													</tr>
										<tr>
										 
											<td height="100" align="center" valign="top">
												<table width="952" border="0" align="center" cellpadding="0"
													cellspacing="5">
													<tr>
														<td height="30" colspan="2" align="center" valign="middle"
															class="red_max">&nbsp; 
													Host Registration - Business Information

														</td>
													</tr>
													<logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="2">
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		<br>
																	</td>
																</tr>
															</logic:present>
														</html:messages>
													</logic:messagesPresent>
													<tr>
														<td width="350" align="right" valign="middle"
															class="bla_low">
															Business Name<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle">
															<html:text property="businessName"  
																styleClass="restaurant_input" onkeyup="hidetext('businessName')"  name="userInfo"></html:text>
													<span  class="red_text" id="businessName">	<html:errors   property="businessName" /> </span></td>
													</tr>
													
													   <html:hidden property="emailId" name="userInfo" styleClass="restaurant_input"></html:hidden>
		                        <html:hidden property="password"  value="12345678"  name="userInfo" styleClass="restaurant_input"></html:hidden>
		                        <html:hidden property="businessName"  styleClass="restaurant_input"></html:hidden>
		                        <html:hidden property="cpassword" name="userInfo" value="12345678" styleClass="restaurant_input"></html:hidden>
								<html:hidden property="firstname"    name="userInfo" ></html:hidden>
								<html:hidden property="emailId"  name="userInfo"></html:hidden> 
								<html:hidden property="lastname"    name="userInfo" />	
								<html:hidden property="question1"    name="userInfo" />
								<html:hidden property="answer1"  name="userInfo"/>
								<html:hidden property="question2"    name="userInfo" />
								<html:hidden property="answer2"  name="userInfo"/>
													<tr>
														<td align="right" valign="middle" class="bla_low">
															Business Type<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle">
															<html:select property="restTypeId"  
																styleClass="restaurant_select"   onchange="getNoof(this.value)">
																<html:option value="0">Select your option</html:option>
																<bean:define id="relationships3" name="dropDownList"
																	property="businessTypes" type="java.util.ArrayList" />
																<html:options collection="relationships3"
																	property="restTypeId" labelProperty="restTypeName" />
															</html:select><span  class="red_text" id="restTypeId"><html:errors property="restTypeId"/></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="middle" class="text_formsub">
															<span class="bla_low">Number of Locations</span> <span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle" id="noofloc">
															<html:text property="noOfLocations" styleId="noOfLocations"  
																styleClass="restaurant_input" onkeyup="hidetext('noOfLocations')"   onkeypress="return isNumberKey(event)"></html:text>
																<span  class="red_text" id="noOfLocationss"><html:errors property="noOfLocations"/></span>
														</td>
													</tr>
													 <html:hidden property="billingMethodId" value="1" />
													 
													<tr>
														<td align="right" valign="top" class="bla_low">
															Business Street Address1<span class="red_text">*</span>:
														</td>
														<td align="left" valign="middle">
															<html:text property="address"  
																styleClass="restaurant_input"  ></html:text>
														<span  class="red_text" id="address">		<html:errors property="address"/></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="top" class="bla_low">
														 
															 Street Address2:
														</td>
														<td align="left" valign="middle">
															<html:text property="address1"  
																styleClass="restaurant_input"  ></html:text>
														<span  class="red_text" id="address1">		</span>
														</td>
													</tr>
													        <tr> 
			                    <td align="right" valign="middle" class="bla_low">City <span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
			                    <html:text property="cityId" styleClass="restaurant_select" styleId="cities"    ></html:text>
                             <span  class="red_text" id="cityId"><html:errors property="cityId"/></span></td>
			                  </tr>
													 
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">State/Prov<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
										<html:select property="stateId"  styleClass="restaurant_select" styleId="states"   >
			                			<html:option value="0">Select State</html:option> 
			                			<c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach> 
			                </html:select><span  class="red_text" id="stateId"><html:errors property="stateId"/></span>
									</td>
			                  </tr>
			                     <tr>
			                    <td align="right" valign="middle" class="bla_low">Zip/Post Code<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="zipCode"  onkeyup="hidetext('zipCode')"  styleClass="restaurant_input"></html:text>
								<span  class="red_text" id="zipCode">	<html:errors property="zipCode"/></span></td>
			                  </tr>
			                    <tr>
			                    <td align="right" valign="middle" class="bla_low">Country<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
													<html:select property="countryId"    styleClass="restaurant_select" styleId="countries"  >
			                			<html:option value="0">Select Country</html:option>
			                <bean:define id="relationships3" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships3" property="countryId" labelProperty="countryName"/>
			                </html:select><span  class="red_text" id="countryId"><html:errors property="countryId"/></span>
			                	 
									</td>
			                  </tr> 				 
													<tr>
														<td align="right" valign="middle" class="bla_low">
														Administrator's	Phone:
														</td>
														<td align="left" valign="middle">
															<html:text property="mobilePhone" 
																styleClass="restaurant_input" onkeyup="hidetext('mobilePhone')"   onkeypress="return isNumberKey(event)"></html:text>
																<span class="blue_text">(e.g., 2125551212)</span>
																<span  class="red_text" id="mobilePhone"><html:errors property="mobilePhone"/></span>
														</td>
													</tr>
												 
							<tr> 
			                    <td align="right" valign="middle" class="bla_low">Sales Rep Name<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
			                        <html:text property="srepName" styleClass="restaurant_select" styleId="repname"></html:text>
			                        <span  class="red_text" id="srepName"><html:errors property="srepName"/></span>
                                </td>
			                  </tr>
			                  <tr> 
			                    <td align="right" valign="middle" class="bla_low">Sales Rep Email<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
			                        <html:text property="srepEmail" styleClass="restaurant_select" styleId="repemail"    ></html:text>
			                        <span  class="red_text" id="srepEmail"><html:errors property="srepEmail" /></span>
                                </td>
			                  </tr>
			                  <tr>
														<td  colspan="3" id="msgid" class="red_text" align="center">&nbsp;
														</td>
													</tr>	<tr>
														<td height="27" align="right" valign="middle">
															&nbsp;
														</td>
														<td align="left" valign="middle">
															<input type="checkbox" name="agree" id="checkbox24"  value="ok"/>
															I certify that I have read and agree to the
															<span class="text_h8"> <a href="privacy_policy.jsp"
																class="text_agree" target="_blank">privacy policy</a> </span>and
															<br />
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="terms.jsp"  class="text_agree" target="_blank">terms of use</a> of Tango
															Tab
														</td>
													</tr>
													<tr>
														<td  colspan="3" id="msgid" class="red_text" align="center">&nbsp;<div id="msgid"></div>
														</td>
													</tr>	 
													<tr>
														<td height="45" colspan="2" align="center" valign="middle">
															<table width="330" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																   <td>
																		<div id="select_hot">
																			<a href="index.jsp">Cancel</a>
																		</div>
																	</td>
																	<td>
																		<div id="select_hot">
																			<a href="client_registration_process.jsp">Reset</a>
																	
																		</div>
																	</td>
																	<td>
																		<div id="select_hot">
																			<html:submit styleClass="but_img" property="submit" 
																				styleId="submitID" >Next</html:submit>
																		</div>
																	</td>
																	
																	
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
											 
										</tr>
								 
									</table>
									
								
									
				  
				  
                  <p class="red_madium">&nbsp;</p>                    <p align="justify">&nbsp;</p></td>
                  </tr>
                
              </table></td>
              </tr>
        </table></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top"></td>
      </tr>
    </table></html:form>
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