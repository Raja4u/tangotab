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
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
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
</head>

<body>
<!--Header Start-->
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
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" />
  <img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">	

    <table width="968" border="0" cellspacing="0" cellpadding="0" class="form_txt">
  
      <tr>
        <td height="15" align="center" valign="top">
        &nbsp;
              
              </td>
            </tr>
            <tr>
              <td height="250" align="center" valign="top" class="blue_border"><br/>
              <table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td colspan="2" align="left" valign="top" class="red_max"> <h1 class="red_max" >Contact Us</h1></td>
                </tr>
                <tr>
                  <td width="653" align="left" valign="top" class="text_h9"></td>
                  <td width="425" rowspan="2" align="center" valign="top">&nbsp;</td>
                </tr>
                  <tr>
                  <td height="28" colspan="2" align="left" valign="middle" class="gre_medium"><p style="padding:14px 0 0 159px; line-height:21px;"><strong>Please submit your  comments or requests below and<br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;click the submit button to send the message.</strong></p></td>
                </tr>
                <tr>
                        <td width="100" height="26" align="left" valign="middle" class="text_h8">&nbsp;</td>
                        <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="left" valign="middle" colspan="" class="gre_medium">
																		<font color="green"> <bean:write name="message"
																				filter="false" /> </font>
																		
																	</td>
																</tr>
															</logic:present>
														</html:messages>
						</logic:messagesPresent>
                      </tr>
                <tr>
                  <td align="left" valign="top" class="text_h9">   
				  
				  <html:form action="/jsp/contactUs" method="post">
              
<table width="900" border="0" align="left" cellpadding="0" cellspacing="5">
              
                 <tr>
                    <td align="center" valign="top">                  </td>
            </tr>
               
                <tr>
                  <td width="250" height="30" align="right" valign="middle" class="bla_low">Name<span class="red_text">*</span>:</td>
                  <td width="350" align="left" valign="middle">
                  <html:text property="firstName" styleClass="substxt" styleId="firstName"  ></html:text>
                  <span  class="red_text" id="fname"><html:errors property="firstName" /></span> </td>
                  <td width="350" rowspan="7" align="center" valign="top"><img src="../images/contactimg.jpg" width="302" height="192" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Email<span class="red_text">*</span>:</td>
                  <td align="left" valign="middle">
                  <html:text property="emailId" styleClass="substxt" styleId="emailId"  ></html:text> 
                  <span  class="red_text" id="fname"><html:errors property="emailId" /></span> </td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Phone:</td>
                  <td align="left" valign="middle">
                  <html:text property="phone" styleClass="substxt" styleId="phone"  onkeypress="return isNumberKey(event)" maxlength="10"  ></html:text> 
                  <span class="blue_text">Eg: 2125551212</span>
                  <html:errors property="phone" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Restaurant Name:</td>
                  <td align="left" valign="middle">
                  <html:text property="restaurantName" styleClass="substxt" styleId="restaurantName" ></html:text> </td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Restaurant City:</td>
                  <td align="left" valign="middle">
                  <html:text property="restaurantCity" styleClass="substxt" styleId="restaurantCity" value=""  ></html:text> </td>
                </tr>
                <tr>
                  <td align="right" valign="top" class="bla_low">Comments/Requests:</td>
                  <td align="left" valign="middle">
                  <html:textarea property="comments" styleClass="stxtarea" styleId="comments" value="" ></html:textarea> </td>
                </tr>
                <tr>
                  <td align="right" valign="top" class="bla_low">Type Of Inquiry<span class="red_text">*</span>:</td>
                  <td align="left" valign="middle">
                  <html:select property="typeOfEnquiry" styleClass="listboxeffect" style="width:150px; border-color:#000000;" styleId="typeOfEnquiry">
                    <html:option  value="Sales Inquiry">Sales Inquiry</html:option>
                    <html:option  value="Customer Service">Customer Service</html:option>
                    <html:option  value="Billing Inquiry">Billing Inquiry</html:option>
                    <html:option  value="Technical Issues">Technical Issues</html:option>
                    <html:option  value="Web Master">Web Master</html:option>
                  </html:select>
                  <html:errors property="typeOfEnquiry" /> </td>
                </tr>
                <tr>
                  <td height="40" align="right" valign="middle">&nbsp;</td>
                  <td height="40" align="left" valign="middle">
                  <table width="250" border="0" align="left" cellpadding="0" cellspacing="5">
                    <tr>
                      <td><div id="select_hot">
                      <html:submit styleClass="but_img" styleId="submitID1"  property="operation" value="Send" >Submit</html:submit></div></td>
                      <td style="padding-top:5px"><div id="select_hot">
                      <a href="contact_us.jsp"> Clear</a></div></td>
                    </tr>
                  </table></td>
                  <td align="left" valign="middle">&nbsp;</td>
                </tr>
              </table>

              </html:form></td>
                </tr>
                <tr>
                  <td align="left" valign="top" class="text_h9">&nbsp;</td>
                  <td align="center" valign="top">&nbsp;</td>
                </tr>
              </table></td>
            </tr>
        </table>
</div>  <!--footer start here-->
  </div>


</div>

            </div>
            <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
    <div style="clear:both;"></div>
	</div>
	 </div>


</body>
</html>
