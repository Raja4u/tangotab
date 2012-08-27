<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>

<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
	<%@ include file="consumer_imports.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
<link href="../css/menu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
 function getName(){
  var location = document.publishDealForm.stateId.options[document.publishDealForm.stateId.selectedIndex].text;
  document.publishDealForm.stateName.value=location;
  document.getElementById("stateName").value=location;
 
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


<!--Header Start-->	


 <div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" />
  <img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">	

    <table width="968" border="0" cellspacing="0" cellpadding="0" class="form_txt">
    
      <tr>
        <td height="15" align="center" valign="top">&nbsp;
        </td>
            </tr>
            <tr>
              <td height="250" align="left" valign="top" class="blue_border"><table width="955" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="30" align="center" valign="middle"><p class="red_madium">Please help me publish my deals.</p></td>
                  <td><span class="blue_text"></span></td>
                  </tr>
                  <tr>
                  <td height="30" align="center" valign="middle"><p class="bla_low">Existing TangoTab clients---Please <a href="login.jsp" style="color: #e46c0e;font-weight: bold;text-decoration:none;">Login</a> to create and publish your deals.</p></td>
                 
                  </tr>
                  <tr>
                  <td height="30" align="center" valign="middle"><p class="bla_low">Not an existing TangoTab client---Please provide us with some basic information and one of our Account Executives will contact you shortly to get you started with publishing amazing deals and filling your empty seats.</p></td>
                 
                  </tr>
             
                <tr>
                  <td align="center" valign="top">     <html:form action="/jsp/publishDeal" method="post">  
              <table width="650" border="0" cellpadding="0" cellspacing="5">
                <tr><c:if test="${not empty data}">
                                          <td height="28" colspan="2" align="center" valign="middle" class="gre_medium"><p><strong>Thank you for your inquiry.  A TangoTab representative will contact  you within 24 hours.</strong></p></td>

                    </c:if>
                </tr>
               
                <tr>
                  <td width="22%" height="30" align="right" valign="bottom" class="bla_low">Business Name:</td>
                  <td width="38%" align="left" valign="bottom"><html:text   property="businessname" styleClass="substxt"/>
                  <html:errors property="businessName" /> </td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Street Address1:</span></td>
                  <td align="left" valign="middle">
															<html:text property="address"  
																styleClass="substxt"  ></html:text>
														<span  class="red_text" id="address">		<html:errors property="address"/></span>
														</td>
													</tr>
													<tr>
														<td align="right" valign="top" class="bla_low">
														 
															 Street Address2:
														</td>
														<td align="left" valign="middle">
															<html:text property="address1"  
																styleClass="substxt"  ></html:text>
														<span  class="red_text" id="address1">		</span>
														</td>
													</tr>
													        <tr> 
			                    <td align="right" valign="middle" class="bla_low">City:</td>
			                    <td align="left" valign="middle">
			                    <html:text property="cityId" styleClass="substxt" styleId="cities"    ></html:text>
                             <span  class="red_text" id="cityId"><html:errors property="cityId"/></span></td>
			                  </tr>
													 
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">State/Prov<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
										<html:select property="stateId"  styleClass="listboxeffect" style="width:150px; border-color:#000000;" styleId="stateId"  onchange="getName()" >
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
			                 <html:hidden property="stateName" styleId="stateName" value=""/> 
                <tr>
                  <td align="right" valign="middle" class="bla_low">Zip/Post Code<span class="red_text">*</span>:</td>
                  <td align="left" valign="middle"><html:text   property="zipCode" styleClass="substxt"   /><html:errors property="zipCode"/></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Main Business Phone<span class="red_text">*</span>:</td>
                  <td align="left" valign="middle"><html:text property="phone" styleClass="substxt"   maxlength="10"  onkeypress='return isNumberKey(event)'/>
                  <span class="blue_text">(e.g., 2125551212)</span><html:errors property="phone"/></td>
                </tr>

                <tr>
                  <td align="right" valign="middle" class="bla_low">Contact Name:</td>
                  <td align="left" valign="middle"><html:text property="contactname"  styleClass="substxt"     /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Title:</td>
                  <td align="left" valign="middle"><html:text  property="title"  styleClass="substxt"    /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Email<span class="red_text">*</span>:</td>
                  <td align="left" valign="middle"><html:text property="emailId" styleClass="substxt"   />
                  <html:errors property="emailId" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Comments:</td>
                  <td align="left" valign="middle"><html:textarea property="comments" styleClass="substxt" style="height:50px;"/></td>
                </tr>


                <tr>
                  <td height="40" colspan="2" align="center" valign="middle">
                  <table width="110" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>	
<td>      <div id="select_hot"><html:submit styleClass="but_img" styleId="submitID1"  property="operation" value="Submit" >Submit</html:submit></div></td>
                        
                      </tr>
              
                  </table>
                  </td>
                </tr>       
                 <!--<tr><c:if test="${not empty data}">
                   <td height="28" colspan="2" align="center" valign="middle" class="gre_medium"><p><strong>An Email has been sent. <br/>
                    We will get back to you as soon as possible</strong></p></td>
                    </c:if>
                </tr>
                 
              --></table>
    </html:form></td>
                </tr>
                <tr>
                  <td align="left" valign="top">&nbsp;</td>
                  </tr>
              </table></td>
              </tr>
        </table></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top"></td>
      </tr>
    </table>

  </div>
  <!--footer start here-->
  </div>


</div>

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
