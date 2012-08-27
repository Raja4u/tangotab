<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<table width="300" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="10" align="left" valign="top">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="480" align="center" valign="top" background="../images/fb_signup_bg.png">
                          <html:form  action="jsp/userReg.do?type=consumer" method="post" onsubmit="return Onsubmit1();">
							<input type="hidden" name="emailIdexists"	 id="emailIdexists" />		
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
                            <html:hidden property="refferCode"   styleId="refferCode"/>
													
                           <!--   <html:text property="firstname" 
															 value="First Name"	styleClass="text_box" styleId="firstName"  onclick="removetext(this,'First Name');"  ></html:text>-->
															 <input type="text" name="firstname" id="firstname" placeholder="First Name" class="text_box"  />  </td>
                          </tr> 
                          	<tr>
									<td> 	<!--<html:text property="lastname" value="Last Name"	
																styleClass="text_box" styleId="lastName"  onkeyup="removetext(this,'Last Name');clickedForm(this.id);" onclick="removetext(this,'Last Name');clickedForm(this.id);"    ></html:text>
													--><input type="text" name="lastname" id="lastname" placeholder="Last Name" class="text_box" />
														</td>
													</tr>
													<tr>
														<td><!--<html:text property="emailId" value="Email"  onblur="checkEmail(4,this.value)" 	 styleClass="text_box" styleId="emailId"   onchange="removetext(this,'Email');"  onkeyup="removetext(this,'Email');clickedForm(this.id);"  onclick="removetext(this,'Email');clickedForm(this.id);"  ></html:text> 
												                     -->
<input type="text" name="emailId" id="emailId" placeholder="Email" class="text_box" /></td></tr>
													<tr><td > 
														<!--<html:password property="password"   styleId="password"
																styleClass="text_box"  value="Password"   onkeyup="removetext(this,'Password');clickedForm(this.id);" onclick="removetext(this,'Password');clickedForm(this.id);"      >  </html:password>
														--><input id="password-clear" type="text" value="Password" autocomplete="off"  class="text_box"  />
	    												<input id="password-password" type="password" name="password" value="" autocomplete="off" placeholder="Password" class="text_box" maxlength='16' />																	
																															
														</td> 	</tr>
											 
													<tr><td > 
															<!--	<html:text property="zipCode"  
																styleClass="text_box" maxlength="6" styleId="zipCodeID" value="Zip Code" onkeyup="removetext(this,'Zip Code');clickedForm(this.id);" onclick="removetext(this,'Zip Code');clickedForm(this.id);"   ></html:text>
												 --> <input type="text" name="zipCode" id="zipCode" placeholder="Zip Code" class="text_box" />
												 </td></tr>
                           
                          <tr>
                            <td height="40" align="center" valign="middle"><table width="85%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="11%"><input type="checkbox" name="agree" id="agree"  checked="checked"/></td>
                                <td width="89%" class="normalwht">I agree to the <a href="../jsp/terms.jsp" class="normalwht2" target="_blank">Terms &amp; Conditions</a></td>
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