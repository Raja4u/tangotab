<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.tangotab.util.TangotabConstants"%>
<%@page import="com.tangotab.util.TangoTabUtility"%>
<style>
#password-clear {
	    display: none;
	    color:#aaa;
}	
input.placeholder{
color:#aaa;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
 <script type="text/javascript">
 
function setErrUrlCookie()
{
	var loc=window.location;
 	<%request.setAttribute("source",TangoTabUtility.getTangoTabResourceBundle().getString(TangotabConstants.TANGO_TAB_WEB_SITE_HOME)); %>
	loc=loc.toString().replace('${source}',"").replace('/','-');
	loc+="; path=/" ;
	document.cookie="ErrorUrl= " + loc;
	

} 

$(document).ready(function(){
 var  placeHolderSupport;
  placeHolderSupport = ("placeholder" in document.createElement('input'));
      
if( !placeHolderSupport )
{   
   $('[placeholder]').focus(function() {
	  var input = $(this);
	  if (input.val() == input.attr('placeholder')) {
	   	input.val('');
		input.removeClass('placeholder');
  }
 }).blur(function() {
  var input = $(this);
  if (input.val() == '' || input.val() == input.attr('placeholder')) {
    input.addClass('placeholder');
    input.val(input.attr('placeholder'));
  }
 }).blur().parents('form').submit(function() {
  $(this).find('[placeholder]').each(function() {
    var input = $(this);
    if (input.val() == input.attr('placeholder')) {
      input.val('');
    }
  })
});

$('#password-clear').show();
	$('#password-password').hide();
	 
	$('#password-clear').focus(function() {
	    $('#password-clear').hide();
	    $('#password-password').show();
	    $('#password-password').focus();
	});
	$('#password-password').blur(function() {
	    if($('#password-password').val() == '') {
	        $('#password-clear').show();
	        $('#password-password').hide();
	    }
	});
	
}
})

</script>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td align="center" valign="top" scope="row">&nbsp;</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="top" class="signup_txt" scope="row">Start Here </td>
                                      </tr>
                                      <tr>
                                        <td height="10" align="center" valign="top"  scope="row"></td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="top" scope="row">
                                           <html:form  action="jsp/userReg.do?type=consumer&refferedUrl=window.location" method="post" onsubmit="return Onsubmit1();">
							       <input type="hidden" name="emailIdexists"	 id="emailIdexists" />			
									<html:hidden property="refferCode"   styleId="refferCode"/>	
									
									<html:hidden property="refferedUrl"   styleId="refferedUrl"/>
									<table width="65%" border="0" cellspacing="0" cellpadding="0">
                                          <tr>
                                            <td height="40" align="center"  >
                                           
										 	<!--<html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="removetext(this,'First Name');clickedForm(this.id);"  ></html:text>
					--><input type="text" name="firstname" id="firstname" placeholder="First Name" class="text_box"  />   </td>
                                          </tr>
                                         
                                          	<tr>
                                          	<td height="40" align="center" >
									 	<!--<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="removetext(this,'Last Name');clickedForm(this.id);" onclick="removetext(this,'Last Name');clickedForm(this.id);"    ></html:text>
													--><input type="text" name="lastname" id="lastname" placeholder="Last Name" class="text_box" />	</td>
													</tr>
													<tr>
														<td height="40" align="center" ><!--<html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"  onkeyup="removetext(this,'Email');clickedForm(this.id);"  onclick="removetext(this,'Email');clickedForm(this.id);"  ></html:text> 
												                     -->
<input type="text" name="emailId" id="emailId" placeholder="Email" class="text_box" /></td></tr>
													<tr><td height="40" align="center" >
														<!--<html:password property="password"   styleId="password"
																styleClass="text_box"  value="Password"   onkeyup="removetext(this,'Password');clickedForm(this.id);" onclick="removetext(this,'Password');clickedForm(this.id);"      >  </html:password>
														--><input id="password-clear" type="text" value="Password" autocomplete="off"  class="text_box"  />
	    												<input id="password-password" type="password" name="password" value="" autocomplete="off" placeholder="Password" class="text_box" maxlength='16' />																	
														</td> 	</tr>
											 
													<tr><td height="40" align="center" >
														<!--	<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="removetext(this,'Zip Code');clickedForm(this.id);" onclick="removetext(this,'Zip Code');clickedForm(this.id);"   ></html:text>
												 --> <input type="text" name="zipCode" id="zipCode" placeholder="Zip Code" class="text_box" /> </td></tr>
                                         
                                        <tr>
                            <td height="25" align="center" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="11%"><input type="checkbox" name="agree" id="agree"  checked="checked"/></td>
                                <td width="89%" class="normalwht">I agree to the <a href="<fmt:message key='website.home'></fmt:message>jsp/terms.jsp" class="normalwht">Terms &amp; Conditions</a></td>
                              </tr>
                            </table></td>
                          </tr>
                                          <tr>
                                            <td height="5" align="center" valign="top" scope="row"></td>
                                          </tr>
                                          <tr>
                                            <td align="center" valign="top" scope="row">
                                            <a href="#" onclick="Onsubmit1();"><img src="<fmt:message key='website.home'></fmt:message>images/signup_btn.png"   border="0" /></a>
                                            </td>
                                          </tr>
                                            <tr>
                                            <td scope="row">&nbsp;</td>
                                          </tr>
                                           <tr>
                                            <td align="center" valign="top" scope="row"><span class="normalwht">Already registered?
                                            <a href="<fmt:message key='website.home'></fmt:message>jsp/login.jsp" class="text_signin_txt"> Sign In </a></span></td>
                                          </tr>
                                          <tr>
                                            <td scope="row">&nbsp;</td>
                                          </tr>
                                          <tr>
                                            <td scope="row" align="center"><img src="<fmt:message key='website.home'></fmt:message>images/line_img.png" alt="img"  /></td>
                                          </tr>
                                          <tr>
                                            <td scope="row">&nbsp;</td>
                                          </tr>
                                          <tr>
										  
                                            <td scope="row" align="center">
                                            <div id="button"  style="float:left;">
											<div style="float;padding-left:20px;">
												<a href="#"> <img src="<fmt:message key='website.home'></fmt:message>images/f_connect_btn.png" border="0" /> </a>
											</div></div>
                                          
                                            </td>
                                          </tr>
                                        </table>
                                        </html:form></td>
                                      </tr>
                                      <tr>
                                        <td scope="row">&nbsp;</td>
                                      </tr>
                                    </table>
									