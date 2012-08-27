<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
	<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
<script type="text/javascript">
function askemail(){

document.getElementById("optional").style.display="block";

}
function submitAction(){
if(document.getElementById("toemail").value != null){
  return true;
 }
else{
  document.getElementById("alert").innerHTML = "please enter mailId";
 
  return false;
  }
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
							
				<table width="760" border="0" cellspacing="0" cellpadding="0">
				 <%@ include file="consumer_head.jsp" %>	 	  		
					<tr>
						<td height="17" colspan="3" align="center" valign="top">
							<!-- form Start-->
							<html:form action="/jsp/resendValidation" method="post" onsubmit="return submitAction();">
							<table width="965" border="0" cellspacing="0" cellpadding="0">
					          <tr>
					            <td background="../images/1.png"></td>
					            <td width="949" height="8" background="../images/5.png"></td>
					            <td background="../images/2.png"></td>
					          </tr>
					          <tr>
					            <td width="8" background="../images/7.png"></td>
					            <td height="300" width="949" align="center" valign="top"><p class="red_max"><strong><br/>
					            </strong></p>
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					               <c:if test="${not empty code}">
					                <tr>
					                  <td height="75" align="center" valign="top"><span class="red_max"><strong>Thank you for registering  with TangoTab. Please check your email and complete the validation process.</strong></span></td>
					                </tr>
					               </c:if>
					               <c:if test="${not empty resent}">
					                <tr>
					                   <td height="75" align="center" valign="top"><span class="red_max"><strong>Thank you for providing the alternate email address. <br>Please check your email and complete the validation process.</strong></span></td>
					                </tr>
					               </c:if>
					                <tr>
					                  <td height="75" align="center" valign="top"><span class="bla_low"> In case the email does not appear in your inbox, please check your junk folder. To continue to receive uninterrupted emails from TangoTab, please add TangoTab.com to your Safe Sender List. <a href="../safesenderslist.jsp" target="_blank"  class="text_agree"  >Click here</a> for instructions on adding to safe sender list.</span></td>
					                </tr>
					                <input type="hidden" id="firstname" name="firstname" value="${firstname}"/>
					                <input type="hidden" id="emailId" name="emailId" value="${emailId}"/>
					                <input type="hidden" id="password" name="password" value="${password}"/>
					                <input type="hidden" id="code" name="code" value="${code}"/>
                                  <c:if test="${not empty code}">
					                <tr>
					                  <td align="center" valign="top">
					                  <table width="35%" cellspacing="5" border="0" align="center" cellpadding="0" cellspacing="0">
					                      <tr>
					                        <td width="50%" align="left" valign="top"><div id="select_hot"><a href="index.jsp" style="align:center">Close</a></div></td>
					                         
												<td width="50%" align="center" valign="middle" >
													<div id="select_hot_max">
															<a href="javascript:askemail();" style="text-decoration:none;">Resend Validation Email</a>
													</div>
												</td>
											
											 
											 
					                      </tr>
					                      
					                  </table></td>
					                </tr> 
                                   </c:if>
					               <c:if test="${not empty resent}">
									  <tr>
					                  <td align="center" valign="top">
					                  <table width="13%" cellspacing="5" border="0" align="center" cellpadding="0" cellspacing="0">
					                  <tr>
					                        <td width="50%" align="left" valign="top"><div id="select_hot"><a href="index.jsp" style="align:center">Close</a></div></td>
					                   </tr>
					                   </table>
					                   </td>
					                   </tr>
								    </c:if>
					                <!--<tr>
					                  <td align="center" valign="top">
					                  <table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
					                      <tr>
					                        <td align="center" valign="top"><div id="select_hot"><a href="index.jsp">Close</a></div></td>
					                         <c:if test="${not empty code}">
												<td align="center" valign="top" class="but_img">
													<div  >
															<a href="javascript:askemail();" class="but_img">Resend Validation Email</a>
													</div>
												</td>
											 </c:if>
					                      </tr>
					                      
					                  </table></td>
					                </tr>
					               
					                -->
					                <logic:messagesPresent message="true">
																			<html:messages id="message" message="true">
																				<logic:present name="message">
																					<FONT color="red"> <bean:write
																							name="message" filter="false" /> </FONT>
																					<br>
																				</logic:present>
																			</html:messages>
																		</logic:messagesPresent>
					               <tr >
					               <td valign="top"  width="100%" align="center" id="optional" style="display:none;">
					               
					                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					                  <tr>
					                  <td width="65%" align="right" valign="top" class="bla_low">
					                  If you did not receive the validation email, enter another email address: </td>
					                  <td width="35%" align="left" valign="top" class="bla_low">
					                    <input type="text" id="toemail" name="toemail"></input>
					                    <span id="alert"></span> </td>
					                    </tr>
					                    <tr>
					                  <td height="35" align="center" valign="top" class="bla_low" colspan="2">
					                    <html:submit  value="Send Validation to new email address"></html:submit> </td>
					                    </tr>
					                    </table>
					               </td>
					                </tr>
					               
					              </table></td>
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