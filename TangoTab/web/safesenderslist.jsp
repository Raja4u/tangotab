<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TangoTab</title>

<link href="css/tangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/scrollend.js"></script>
<link href="css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>

</head>

<body>
<div id="wrap">
<!--Header Start-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>

<script src="js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<link rel="shortcut icon"  href="../images/TangoT_Icon.ico" /> 
<div id="fb-root">
</div>
<script type="text/javascript">
                      window.fbAsyncInit = function(){
                                    FB.init({
                                        appId: '<fmt:message key="facebook.appid"></fmt:message>',
                                        status: true,
                                        cookie: true,
                                        xfbml: true
                                    });
									
                                };
                                (function(){
                                    var e = document.createElement('script');
                                    e.async = true;
                                    e.src = document.location.protocol +
                                    '//connect.facebook.net/en_US/all.js';
									document.getElementById('fb-root').appendChild(e);
                                }());
						
</script>
<div class="header">
	<div class="social_top">
		<div class="facebook_l">
			<div id="facebook_like">
				<fb:like href='<fmt:message key="facebook.frontpage.url"></fmt:message>' show_faces="false" layout="button_count" width="450" colorscheme="light"></fb:like>
	</div>
			<!--<div class="facebook_com">0</div>
			<div class="like_text">0 people like this. Be the first of your friends .</div>-->
			
		</div>
		<div class="like_text"><c:if test="${not empty userInfo}">
				welcome ${userInfo.firstname} 
			</c:if></div>
		<div class="social_l">
<div id="tweet_like">
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div>
		<div id="email_like"><a href="#" title="Email"></a></div>
		</div>
	</div>
	<div class="logo"><h1>
	 <a href="index.jsp"></a>
	 </h1></div>
		<div class="fr"><div class="top_navbox"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  <c:if test="${ empty userInfo and  empty profileUsers}">
    <td width="83" align="center" valign="top">
    <!-- <a href="http://www.facebook.com" target="_blank"><img src="../images/facebook-icn.png" width="15" height="15" /></a>
    --></td>
    <td width="83" align="center" valign="top"><a href="login.jsp"><img src="images/login-icon.png" border="0" width="15" height="18" /></a></td>
    <td width="83" align="center" valign="top"><a href="jsp/consumer_registration.jsp">
    <img src="images/createicon.png" border="0"  width="18" height="18" /></a></td>
    </c:if>
    <c:if test="${not empty userInfo and not empty profileUsers}">
        <td width="83" align="center" valign="top">&nbsp;
        </td>    <td width="83" align="center" valign="top">&nbsp;
        </td>    <td width="83" align="center" valign="top">&nbsp;
        </td>
    </c:if>
  </tr>
  <tr>
    <c:if test="${ empty userInfo and  empty profileUsers}">
    <td height="22" align="center" valign="middle">
    <!-- <a href="http://www.facebook.com"  target="_blank">Login</a>--></td>
    <td align="center" valign="middle"><a href="jsp/login.jsp">Login</a></td>
    <td align="center" valign="middle"><a href="jsp/consumer_registration.jsp">Sign up</a></td>
    </c:if>
      <c:if test="${not empty userInfo and not  empty profileUsers}">
       <td height="22" align="center" valign="middle">
    <!-- <a href="http://www.facebook.com"  target="_blank">Login</a>--></td>
     <td height="22" align="center" valign="middle">
    <!-- <a href="http://www.facebook.com"  target="_blank">Login</a>--></td>
     <td height="22" align="center" valign="middle">
    <!-- <a href="http://www.facebook.com"  target="_blank">Login</a>--></td>
      </c:if>
  </tr>
</table>
</div>
<div class="download_tg"><a href="jsp/mobileapps.jsp"><img src="images/download-app.jpg" width="212" height="50" border="0"/></a>
</div></div>

 

 
	<div id="navigation">
		<div class="nav_l"></div>
		<div class="nav_m">
			<%
			//if (request.getParameter("currentPage") == "Home")
				
				String currentPage = request.getParameter("currentPage");
			%>
			<div id="menu">
				<ul>
					<li style="margin-left:0px;">
					<c:if test="${not empty userInfo or not empty profileUsers}">
				 
					<a href="jsp/index.jsp" id="home" title="Home"><span>Home</span></a>
					</c:if>
					<c:if test="${ empty userInfo and  empty profileUsers}">
				 
					<a href="jsp/index.jsp" id="home" title="Home"><span>Home</span></a>
					</c:if>
					</li>
					<li>
					<c:if test="${userInfo.roleId == 4}">
						 <div class="nav_divider"></div>	
					<a href="jsp/profileEdit.do" id="myaccount" title="My Account"><span>My Account</span></a>
					</c:if>
						<c:if test="${userInfo.roleId == 5 and  userInfo.billingMethodId ne 0 and  userInfo.billingTypeId ne 0 }">
						
						
							 <div class="nav_divider"></div>	
							 <sslext:link  forward="jsp/unsecureViewDeals" indexId="myaccount" title="My Account">
							 <span>My Account</span></sslext:link>
							 
					 
					</c:if>
						<c:if test="${userInfo.roleId == 5 and  userInfo.billingMethodId eq 0 and  userInfo.billingTypeId eq 0 }">
						
						
							 <div class="nav_divider"></div>	
							 <li>					
						<a href="jsp/client_registration_process.jsp" id="searchdeals" title="Search Deals"><span>My Account</span>
							</a>
							</li>
					 
					</c:if>
						<c:if test="${userInfo.roleId == 6}">
							 <div class="nav_divider"></div>	
					<a href="jsp/viewDeals.do" id="myaccount" title="My Account"><span>My Account</span></a>
					</c:if>
					</li>
					<div class="nav_divider"></div><li><a href="jsp/how_it_works.jsp" id="Learn More" title="Learn More"><span>Learn More</span></a></li>
					
					<c:if test="${userInfo.roleId == 4}">
						
					  	 <div class="nav_divider"></div>	
						 <li>					
						<a href="jsp/searchForward.do" id="searchdeals" title="Search Deals"><span>Search Deals</span>
							</a>
							</li> 
						</c:if>
						<c:if  test="${empty userInfo}">
							 <div class="nav_divider"></div>	
						<!-- <div class="nav_divider"></div>	-->
						 <li>					
						<a href="jsp/searchForward.do" id="searchdeals" title="Search Deals"><span>Search Deals</span>
							</a>
							</li>
						</c:if>
			 

			 	 
						<c:if test="${not empty userInfo or not empty profileUsers}">
						<div class="nav_divider"></div><li>
					 	<sslext:link  forward="jsp/unsecurelogout" indexId="login" title="Log Out">
							 <span>Log Out</span></sslext:link>
						</li></c:if>
				 </ul>
			</div>
			<script type="text/javascript">
				var currentPage = "<%=currentPage%>";
				/*console.warn("Current Page is :"+ currentPage);*/
				if(currentPage == "Home")
					document.getElementById("home").className = 'current';
				else if(currentPage == "MyAccount")
					document.getElementById("myaccount").className = 'current';
				else if(currentPage == "Learn More")
					document.getElementById("Learn More").className = 'current';
				else if(currentPage == "SearchDeals")
					document.getElementById("searchdeals").className = 'current';
				else if(currentPage == "Login")
					document.getElementById("login").className = 'current';				
			</script>			
		</div>
		<div class="nav_r"></div>
	</div>
</div>



	
			
			<!--Added the Email Dialog Here - Social Integration-->
        <div id="dialog" title="Share Through Email" style="display: none; position: relative; z-index: 500;">
            <form action="SendMail" method="post">
                <div class="styled">
                    <table>
                        <tr>
                            <td>
                                <b>To:</b>
                            </td>
                            <td>
                                <input type="text" id="to" name="to" size="50"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>From:</b>
                            </td>
                            <td>
                                <input type="text" id="from" name="from" size="50"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Subject:</b>
                            </td>
                            <td>
                                A friend thought you might be interested in these great
                                deals at Tangotab.
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Message:</b>
                            </td>
                            <td>
                                <p id="message" name="message" style='border:1px solid'>
                                	I came across this great site that I wanted to share with you. Tangotab offers great deals for all of the restaurants that we like to eat at. They offer many great deals on a daily basis, not just one deal a day. The best part is that we don't have to pay anything to Tangotab to take advantage of these deals. Click <a href="<fmt:message key="email.registration.url"></fmt:message>">here</a> to signup to receive great deals.
							    </p>
                            </td>
                        </tr>
                        <tr align="center">
                            <td>
                                <input type="submit" value="Cancel" id="cancel">
                            </td>
                            <td>
                                <input type="submit" value="Send" id="send">
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

<!--Header End here-->
<div class="content">
  <div>
    <table width="968" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" height="25" align="center" valign="top" background="images/abtgre.jpg"></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td colspan="2" align="center" valign="top" class="red_max">Safe Senders List</td>
            </tr>
            <tr>
              <td colspan="2" align="center" valign="top" class="red_max"><br/></td>
            </tr>
            <tr>
              <td align="left" valign="top" class="text_h9"> <!--  form starts -->
              <html:form action="jsp/contact" method="post">
              <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
                <tr>
                  <td height="28" colspan="2" align="justify"  valign="middle" class="bla_low">
                  <p> 
Help ensure that your TangoTab emails are always delivered to your inbox. Log in to your email now and follow the steps below to add TangoTab to your address book, contacts or "Safe Senders" list.<br/><br/> 
<strong>Gmail</strong><br/><br/>
<i>New Subscribers:</i><br/><br/>
Please add our "from" address (for example: noreply@tangotab.com) to your Gmail contacts list.<br/>Remember that you may receive messages from several TangoTab addresses, including noreply@tangotab.com.<br/>To add us to your contact list:<br/><br/>
1. Click "Contacts" along the left side of any Gmail page.<br/><br/>
2. Click "Add Contact".<br/><br/>
3. Copy and paste our "From" address, "noreply@tangotab.com", into the primary email address dialog box.<br/><br/>
4. Click "Save".<br/><br/>
<i>Existing Subscribers:</i><br/><br/>
How to check if our email and/or email and/or newsletter is in the "Spam" folder:<br/><br/>
1. Click "Spam" along the left side of any Gmail page.<br/><br/>
2. If you see any TangoTab email listed among the messages in this folder, check the box next to our email.<br/><br/>
3. Click the "Not Spam" button along the top.<br/><br/>
<strong>Windows Live Hotmail</strong><br/><br/>
<i>New Subscribers:</i> <br/><br/>
Please add our "from" address (for example: noreply@tangotab.com>) to your Safe Senders list.<br/>Remember that you may receive messages from several TangoTab addresses, including noreply@tangotab.com.<br/>To add us to your Safe Senders list:<br/><br/>
1. Open your mailbox and click "Options" (upper right hand corner).<br/><br/>
2. Click the "Junk Email Protection" link (top of page).<br/><br/> 
3. Select the "Safe List" link (second from bottom). <br/><br/>
4. Copy and paste "noreply@tangotab.com" into the dialog box titled "Type an address or domain".<br/><br/> 
5. Click the "Add" button next to the dialog box.<br/><br/>
<i>Existing Subscribers:</i><br/><br/>
If our email and/or newsletter is in your "Junk Email Folder", open the email and click the "Not Junk" button. Next, check to see if our email address is in your "Blocked Senders" list. If you see "noreply@tangotab.com" on this list, select it and click the "Remove" button. Finally, if you have not done so, add our "from" address (for example: noreply@tangotab.com) to your Safe Senders list as described above.<br/><br/>
<strong>AOL</strong> <br/><br/>
<i>New Subscribers:</i><br/><br/> 
Please add our "from" address (for example: noreply@tangotab.com) to your Safe Senders list.<br/>Remember that you may receive messages from several TangoTab addresses, including noreply@tangotab.com.<br/>To add us to your Safe Senders list:<br/><br/>
1. Click "Mail Menu" and select "Address Book".<br/><br/> 
2. Wait for the "Address Book" window to pop up and then click the "Add" button.<br/><br/> 
3. Wait for the "Address Card for New Contact" window to load.<br/><br/> 
4. Paste "noreply@tangotab.com", into the "Other Email" field.<br/><br/> 
5. Make our "from" address the "Primary Email" address by checking the associated check box.<br/><br/> 
6. Click the "Save" button.<br/><br/> 
<i>Existing Subscribers:</i><br/><br/> 
If our email and/or newsletter is in your AOL Spam Folder, please open the email and then click the "This Is Not Spam" button. Next, please add "noreply@tangotab.com", to your address book as described above.<br/><br/> 
<strong>Yahoo!</strong><br/><br/> 
<i>New Subscribers:</i> <br/><br/> 
You will need to set up a filter to redirect our emails and/or newsletters into your inbox:<br/><br/> 
1. Open your mailbox and click on "Mail Options" (upper right hand corner).<br/><br/> 
2. Select Filters.<br/><br/> 
3. Click the "Add" link on the filters page.<br/><br/> 
4. Update the "From Header" rule with the following two pieces of information: "contains" and "@TangoTab.com".<br/><br/> 
5. Click the "Choose Folder" pull-down menu and select "Inbox". Pick the "Add Filter" button. <br/><br/> 
<i>Existing Subscribers:</i><br/><br/> 
If our emails and/or newsletters are ending up in your Yahoo! "Bulk Folder", please open the issue and click the "Not Spam" button. Next, check to see if the address the email or newsletter was sent from is in your "Blocked Addresses" list. If you see "noreply@tangotab.com" on this list, select it and click the "Remove Block" button. Finally, please set up a filter as outlined above.<br/><br/> 
<strong>Microsoft Outlook 2003 - 2007</strong><br/><br/> 
Please add our "from" address (for example: noreply@tangotab.com) to your Safe Senders list.<br/>Remember that you may receive messages from several TangoTab addresses, including noreply@tangotab.com.<br/>To add us to your Safe Senders list:<br/><br/> 
1. On the "Tools" menu, click "Options".<br/><br/> 
2. On the "Preferences" tab, click "Junk Email".<br/><br/> 
3. On the "Safe Senders" tab, click "Add".<br/><br/> 
4. In the "Add Address" field, enter "&grt;noreply@tangotab.com".<br/><br/> 
5. Click "OK".<br/><br/> 
</p></td>
                </tr>
               
                <tr>
<!--                  <td height="40" align="right" valign="middle">&nbsp;</td>-->
                  <td height="20" align="center" valign="middle">
                 <table width="220" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      
                    </tr>
                  </table></td>
                </tr>
               </table>
              </html:form>
              
              </td>
            </tr>
           
        </table></td>
      </tr>
    
      <tr>
        <td height="15" align="center" valign="top"></td>
      </tr>
    </table>
  </div>
  <div style="clear:both;"></div>
</div><!--content  end here-->
<div style="clear:both;"></div>
<!--footer start here-->
<div id="footer-inner">
		<div class="footer_in">
			<a href="jsp/aboutus.jsp">About Us</a>  I  
			<a href="jsp/affiliates.jsp">Affiliates</a>  I  
			<a href="jsp/press.jsp">Press</a> I  
			<a href="jsp/jobs.jsp" >Jobs</a>  I  
			<a href="jsp/contact_us.jsp">Contact Us</a>  I  
			<a href="jsp/support_us.jsp">Support</a>  I  
			<a href="jsp/privacy_policy.jsp">Privacy</a>  I  
			<a href="jsp/terms.jsp">Terms</a>  
			<!-- I  
			<a href="./advertise.jsp">Advertise With Us</a> --> <br /><br /> Copyright © 2000-2011 TangoTab.com All rights reserved.
		</div>
</div>

<!--footer end here-->
<div style="clear:both;"></div>
</div>
</body>
</html>
