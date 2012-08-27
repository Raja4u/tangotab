
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>  

<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

function setCookie(c_name,value,exdays)
	{
	var exdate=new Date();
	exdays = null;
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString())+"; path=/" ;
	document.cookie=c_name + "=" + c_value;
	//getCookie('landing');
	if(document.getElementById("refferCode") != null){
		document.getElementById("refferCode").value = value;
		//alert(document.getElementById("refferCode").value);
	}
	}
</script>
<link rel="shortcut icon" href="../images/TangoT_Icon.ico" />
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


<div id="header">
	<div class="head_top" >
		<div class="logo">
			<c:if test="${not empty userInfo}">
				<a href="http://www.tangotab.com/jsp/searchForward.do">
				<img src="../images/tango_tablogo.png" border="0" />
				</a>
			</c:if>
			<c:if test="${ empty userInfo}">
				<a href="http://www.tangotab.com/jsp/index.jsp">
				<img src="../images/tango_tablogo.png" border="0" />
				</a>
			</c:if>
		</div>
		<div class="navigtiion">

			<c:if test="${not empty userInfo}">
				<div class="signin_inner">
					<div class="hi_inner">
				 
						welcome ${userInfo.firstname}
				   
					</div>
					<div class="my_account">
						<!-- <a href="profileEdit.do">My Account</a> -->
						<sslext:link forward="unsecurelogout" indexId="login"
							title="Log Out">
							<span>Log Out</span>
						</sslext:link>
					</div>
				</div>
			</c:if>
			<%
				String emailId1 = request.getParameter("emailId");
			%>


			<c:if test="${ empty userInfo and  empty profileUsers}">
				<div class="signin">
				
				<div id="button">
						<a href="#"> <img src="../images/signin_icon.png" border="0" /> </a>
					</div>
					<a href="http://www.tangotab.com/jsp/login.jsp">Sign in</a> 
					<a
						href="http://www.tangotab.com/jsp/consumer_registration.jsp?emailId=<%out.write(emailId1);%>"
						style="padding: 0 0 0 5px;">Sign up</a>
				</div>
			</c:if>

		</div>

		<div class="nav_head" >
		
				<%
					//if (request.getParameter("currentPage") == "Home")

					String currentPage = request.getParameter("currentPage");
				%>
				<ul>


					<li>

						<c:if
							test="${userInfo.roleId == 5 and  userInfo.billingMethodId ne 0 and  userInfo.billingTypeId ne 0 }">



							<sslext:link forward="unsecureViewDeals" indexId="myaccount"
								title="My Account">
								<span>My Account</span>
							</sslext:link>


						</c:if>
						<c:if
							test="${userInfo.roleId == 5 and  userInfo.billingMethodId eq 0 and  userInfo.billingTypeId eq 0 }">

							<li>
								<a href="client_registration_process.jsp" id="searchdeals"
									title="Search Deals"><span>My Account</span> </a>
							</li>

						</c:if>
						<c:if test="${userInfo.roleId == 6}">

							<a href="http://tangotab.com/jsp/viewDeals.do" id="myaccount" title="My Account"><span>My
									Account</span>
							</a>
						</c:if>
					</li>


					<c:if test="${userInfo.roleId == 1}">


						<li>
							<a href="http://tangotab.com/jsp/viewNames.do?operation=display" id="myaccount"
								title="My Account"><span>My Account</span> </a>
						</li>
					</c:if>
					<c:if test="${userInfo.roleId == 4}">
						<li>
							<a href="http://tangotab.com/jsp/profileEdit.do" id="myaccount"
								title="My Account"><span>My Account</span> </a>
						</li>
					</c:if>

<!--
					<li>
						<c:if test="${not empty userInfo or not empty profileUsers}">
							<a href="index.jsp" id="home" title="Home"><span>Home</span>
							</a>
						</c:if>
						<c:if test="${ empty userInfo and  empty profileUsers}">
							<a href="index.jsp" id="home" title="Home"><span>Home</span>
							</a>
						</c:if>
					</li>-->

						<!--<c:if test="${ empty userInfo and  empty profileUsers}">
					<li>
						<a href="">Restaurants</a>

						<ul>


							<li>
								<a href="innerlogin.jsp">Sign in</a>
							</li>
							<li>
								<a href="client_registration.jsp">Sign up</a>
							</li>

							<li>
								<a href="learnmore.jsp" id="Learn More" title="Learn More"><span>Learn
										More</span>
								</a>
							</li>
							<li>
								<a href="publishyourdeal.jsp">Publish your deals</a>
							</li>
							<li>
								<a href="contact_us1.jsp">Contact us</a>
							</li>

						</ul>


					</li>
</c:if>-->
					<li>
						<a href="../jsp/suggest_restaurant.jsp">Suggestion Box</a>
					</li>
					<li>
					   <a href="http://www.tangotabloid.com" target="_blank">Blog</a>
					
					</li>

					<li>
						<a href="referfriends.jsp">Share</a>
					</li>
					
					<li>
						<a href="../jsp/charity.jsp">Our Movement</a>
					</li>
					
					

					<li>
						<a href="http://www.tangotab.com/jsp/searchForward.do" id="searchdeals" title="Search Deals"><span>Search
								Offers</span> </a>

					</li>
					

				</ul>
			
		</div>
	</div>
	<script type="text/javascript">
				var currentPage = "<%=currentPage%>";

	/*console.warn("Current Page is :"+ currentPage);*/
	if (currentPage == "Home")
		document.getElementById("home").className = 'current';
	else if (currentPage == "MyAccount")
		document.getElementById("myaccount").className = 'current';
	else if (currentPage == "Learn More")
		document.getElementById("Learn More").className = 'current';
	else if (currentPage == "SearchDeals")
		document.getElementById("searchdeals").className = 'current';
	else if (currentPage == "Login")
		document.getElementById("login").className = 'current';
</script>

</div>

<div id="headerbottom"></div>
<!--Added the Email Dialog Here - Social Integration-->

<c:set var="currentPage" value="<%=currentPage%>"></c:set>
      <c:if test="${currentPage eq 'charity'}" >
<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
          
	 <table width="999" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="left" valign="top" background="../images/top_bg1.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="10" colspan="4"></td>
        </tr>
      <tr>
        <td width="2%" align="left" valign="top">&nbsp;</td>
        <td align="left" valign="top" class="white_text">Each time you dine with TangoTab, we provide a meal<br />to a hungry person through local and national food banks</td>
           <c:if test="${currentPage eq 'charity'}" >
          <td width="20%" align="left" valign="top"><a href="http://www.tangotab.com/jsp/press.jsp" ><img src="../images/press_img.png" alt="#" width="177" height="177" border="0"/></a></td>
        <td width="20%" align="left" valign="top"><a href="http://www.facebook.com/TangoTab?sk=photos" target="_blank" ><img src="../images/gallery_img.png" alt="#" width="149" height="177" border="0"/></a></td>
       </c:if>
      
          </tr>
    </table></td>
  </tr>
</table>

</div></div></div></div> 
  </c:if>



<link rel="stylesheet" href="../css/general.css" type="text/css"
	media="screen" />
<script src="http://code.jquery.com/jquery-1.7.1.min.js"
	type="text/javascript"></script>
<script src="../js/popup.js" type="text/javascript"></script>
	<div id="popupContact">
				<a id="popupContactClose">x</a>


				<iframe
					src="https://www.facebook.com/plugins/registration.php?
             client_id=422265907817292&
             redirect_uri=http://www.tangotab.com/jsp/Face.do&
             fields=[
 {'name':'name'},
 {'name':'email'},
  
 {'name':'zipcode',       'description':'Zip Code', 'type':'text'}]"
					scrolling="auto" frameborder="no" style="border: none"
					allowTransparency="true" width="500" height="330">
				</iframe>

			</div>
			<div id="backgroundPopup"></div>
<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-29227383-1']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>