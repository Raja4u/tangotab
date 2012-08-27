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
<%@ include file="imports.jsp" %>
<link href="css/tangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/scrollend.js"></script>

<link href="css/scrollcolor.css" rel="stylesheet" type="text/css" />




<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>

</head>

<body>
<div id="wrapper">
	<div id="main">

<!--Header Start-->
<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="" />
		</jsp:include>
<!--Header End here-->
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
        <td height="15" align="center" valign="top"><table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="55" align="left" valign="top"><img src="../images/publishdeal.png" width="260" height="47" /></td>
            </tr>
           
         
            <tr>
              <td height="28" align="left" valign="middle" class="text_h9"><span class="gre_medium">TangoTab helps you take control of attracting patrons to your restaurant!</span></td>
            </tr>
            <tr>
              <td align="left" valign="top" class="text_h9"><p align="justify">The most expensive seat in a restaurant is the empty seat  TangoTab has developed an innovative on-line marketing solution that, for the first time, empowers restaurants to create 'up-to-the-minute' offers that allow them to promote and incent patrons to fill tables when necessary, without any risk.</p>
                <p><br />
                </p>
                <p align="justify">Coupons, emails, flyers, and online ads are expensive and customers can still redeem a coupon during busy nights or weekends That type of promotion  does not allow flexibility and control, yet restaurants continue to spend hundreds of dollars monthly this way. There are newer, more expensive, promotional options for restaurants; these require a restaurant to discount 75% or more without a proven ROI model and still without control.</p>
                <br/>
                <p align="justify">TangoTab puts the power back in the restaurant's hands allowing them to control the offers and the time they are made available with as close to zero risk as possible. Restaurants can promote as many deals as they wish.  A minimal transaction fee is paid for each customer that is delivered through TangoTab, tying marketing budgets directly to results.</p><br/><p>Powered by social media engines, TangoTab promotes restaurants offers to millions of customers  nationally or can focus specific offers to a limited geographic area for local customers.  Patrons do not prepay for a deal.  There is no risk!  </p><br/><p>Tango Tab strikes the right win-win balance for both restaurants and consumers.</p></td>
            </tr>
  			<tr>
              <td height="28" align="left" valign="middle" class="text_h9"><p class="red_max">How to Sign up</p></td>
            </tr>
            <tr>
              <td height="28" align="left" valign="middle" class="text_h9"><p class="gre_medium">You will be Tangoing in just 7 steps.</p></td>
            </tr>
            <tr>
              <td align="left" valign="top" class="text_h9"><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
                <ul>
                  <li class="list">Go to the Sign Up Now link at the bottom of the page and follow the instructions to become a validated client.</li>
                  <li class="list">To set up your business, enter you business name and all other pertinent information required in your profile page and submit it.   </li>
                  <li class="list">We will provide you with an approval email within 24 hours along with a quick user-friendly guide.</li>
                  <li class="list">You will now be able to make a payment for which you will receive credits. </li>
                  <li class="list">Start entering and publishing deals straight from your own computer</li>
                  <li class="list">Your credits will only be used when a consumer requests a deal</li>
                  <li class="list">Enhance or publish new deals at any time.</li>
                </ul>   </td>
  </tr>
</table>                     </td>
            </tr>
            <tr>
              <td align="left" valign="top" class="text_h9">If you want a sales representative to help you publish your deals, complete the following and submit it to us. There is no charge for this service to you:</td>
            </tr>
            <tr>
              <td align="center" valign="top" class="text_h9">
                    <html:form action="/jsp/publishDeal" method="post">  
              <table width="650" border="0" cellpadding="0" cellspacing="5">
                
                <tr>
                  <td height="28" colspan="2" align="center" valign="middle" class="gre_medium">Please help me publish my deals</td>
                </tr>
                <tr>
                  <td width="22%" height="30" align="right" valign="bottom" class="bla_low">Business Name:</td>
                  <td width="38%" align="left" valign="bottom"><html:text   property="businessname"    value="" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Street Address</span>:</td>
                  <td align="left" valign="middle"><html:textarea  property="address" styleClass="restaurant_textarea"    /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Zip/Post Code:</td>
                  <td align="left" valign="middle"><html:text   property="zipCode" styleClass="restaurant_input"  value="" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Telephone Number:</td>
                  <td align="left" valign="middle"><html:text property="phone" styleClass="restaurant_input"   value="" /></td>
                </tr>

                <tr>
                  <td align="right" valign="middle" class="bla_low">Contact Name:</td>
                  <td align="left" valign="middle"><html:text property="contactname"  styleClass="restaurant_input"   value="" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Title:</td>
                  <td align="left" valign="middle"><html:text  property="title"  styleClass="restaurant_input"    /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Email:</td>
                  <td align="left" valign="middle"><html:text property="emailId" styleClass="restaurant_input"  value="" /></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Comments:</td>
                  <td align="left" valign="middle"><html:textarea property="comments" styleClass="restaurant_input"   value=""/></td>
                </tr>


                <tr>
                  <td height="40" colspan="2" align="center" valign="middle">
                  <table width="110" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
<td>                        <html:submit styleClass="but_img" styleId="submitID1"  property="operation" value="Submit" >Submit</html:submit></td>
                        
                      </tr>
              
                  </table>
                  </td>
                </tr>        <tr><c:if test="${not empty data}">
                          <td height="28" colspan="2" align="center" valign="middle" class="gre_medium"><p><strong>Thank you for your inquiry.  A TangoTab representative will contact  you w thin 24 hours</strong></p></td>

                    </c:if>
                </tr>
                <tr>
                  <td height="40" colspan="2" align="center" valign="middle"><table width="221" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="68" align="center" valign="middle"><a href="client_registration.jsp"><img src="../images/signupbut.jpg" width="217" height="61" border="0" /></a></td>
                    </tr>
                  </table></td>
                </tr>
              </table>
    </html:form></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top">&nbsp;</td>
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
