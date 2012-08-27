
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!--  <script src="../js/jquery-1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/ddsmoothmenuup.css" /> -->
<link rel="stylesheet" type="text/css"
	href="../css/ddsmoothmenuplain.css" />

<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>

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

function delete_cookie_logindetails(cookiename){
                                
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
  {
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  //alert(x);
  //alert(y);
  if(x.indexOf(cookiename) != -1 ){
  //alert('matched'+ i);
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  var c_value=escape(y) + ("; expires="+cookie_date.toUTCString())+"; path=/" ;
  document.cookie = x + "=" + c_value; 
  }
  }
}
						
</script>
<script src="../js/jquery-1.js" type="text/javascript"></script>
<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="../js/ddsmoothmenu.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript">
$.noConflict();
ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

ddsmoothmenu.init({
	mainmenuid: "smoothmenu2", //Menu DIV id
	orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
	//customtheme: ["#804000", "#482400"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
<link rel="stylesheet" href="../css/general.css" type="text/css"
	media="screen" />
<script src="http://code.jquery.com/jquery-1.7.1.min.js"
	type="text/javascript"></script>
<script src="../js/popup.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/util.js"></script>
<div id="header">
	<div class="head_top">
		<div class="logo">
			<c:if test="${not empty userInfo}">
				<a href="http://www.tangotab.com/jsp/charity.jsp"> <img src="../images/tango_tablogo.png"
						border="0" /> </a>
			</c:if>
			<c:if test="${ empty userInfo}">
				<a href="http://www.tangotab.com/jsp/index.jsp"> <img src="../images/tango_tablogo.png"
						border="0" /> </a>
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
							title="Sign Out"
							onclick="delete_cookie_logindetails('tangotabid');">
							<span>Sign Out</span>
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
						<a href="#"> <img src="../images/signin_icon.png" border="0"/> </a>
					</div>
					<a href="http://www.tangotab.com/jsp/login.jsp">Sign in</a><a
						href="http://www.tangotab.com/jsp/consumer_registration.jsp?emailId=<%out.write(emailId1);%>"
						style="padding: 0 0 0 5px;">Sign up</a>
				</div>
			</c:if>

		</div>
		
		
    <div class="nav_head">
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
								<a href="http://www.tangotab.com/jsp/client_registration_process.jsp" id="searchdeals"
									title="Search Deals"><span>My Account</span> </a>
							</li>

						</c:if>
						<c:if test="${userInfo.roleId == 6}">

							<a href="http://www.tangotab.com/jsp/viewDeals.do" id="myaccount" title="My Account"><span>My
									Account</span> </a>
						</c:if>
					</li>


					<c:if test="${userInfo.roleId == 1}">


						<li>
							<a href="http://www.tangotab.com/jsp/viewNames.do?operation=display" id="myaccount"
								title="My Account"><span>My Account</span> </a>
						</li>
					</c:if>
					<c:if test="${userInfo.roleId == 4}">
						<li>
							<a href="http://www.tangotab.com/jsp/profileEdit.do" id="myaccount" title="My Account"><span>My
									Account</span> </a>
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

					<!-- 	<c:if test="${ empty userInfo and  empty profileUsers}">
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
              </c:if> -->
			  	<li>
						<a href="http://www.tangotab.com/jsp/suggest_restaurant.jsp">Suggestion Box</a>
					</li>
					<li>
					   <a href="http://www.tangotabloid.com" target="_blank">Blog</a>
					
					</li>

					<li>
						<a href="http://www.tangotab.com/jsp/Friendforward.do">Share</a>
					</li>
					
					<li>
						<a href="http://www.tangotab.com/jsp/charity.jsp">Our Movement</a>
					</li>
					<!--
					<li>
						<a href="how_it_works.jsp">How to Tango</a>
					</li>-->

					<li>
						<a href="http://www.tangotab.com/jsp/searchForward.do" id="searchdeals" title="Search Deals"><span>Search
								Offers</span> </a>

					</li>


				</ul>
    </div>
  </div>
 <script type="text/javascript">
				var currentPage = "1";

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

