<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="social_top">
		<div class="facebook_l">
			<div id="facebook_like"><a href="#" title="Facebook"></a></div>
			<div class="facebook_com">0</div>
			<div class="like_text">0 people like this. Be the first of your friends .</div>
			
		</div>
		<div class="like_text"><c:if test="${not empty userInfo}">
				welcome ${userInfo.firstname} 
			</c:if></div>
			
		<div class="social_l"><div id="tweet_like"><a href="#" title="Tweeter"></a></div>
			<div class="facebook_com">0</div><div id="email_like"><a href="#" title="Email"></a></div>
		</div>
	</div>
	<div class="logo"><h1><a href="index.jsp"></a></h1></div>
	<div class="fr">
		<div class="facebook_bg"><img src="http://50.17.229.179:8080/TangoTab/images/facebook_profile.jpg" alt="facebook_profile" />
			<h1>Register or <a href="http://www.facebook.com" target="_blank">Login with Facebook</a></h1>
		</div>
	</div>
	<div id="navigation">
		<div class="nav_l"></div>
		<div class="nav_m">
			<%
			//if (request.getParameter("currentPage") == "Home")
				
				String currentPage = request.getParameter("currentPage");
			%>
			<div id="menu">
				<ul>
					<li style="margin-left:0px;"><a href="http://50.17.229.179:8080/TangoTab/jsp/index.jsp" id="home" title="Home"><span>Home</span></a></li>
					<div class="nav_divider"></div><li><a href="http://50.17.229.179:8080/TangoTab/jsp/profileEdit.do" id="myaccount" title="My Account"><span>My Account</span></a></li>
					<div class="nav_divider"></div><li><a href="http://50.17.229.179:8080/TangoTab/jsp/how_it_works.jsp" id="howitworks" title="How It Works"><span>How It Works</span></a></li>
					
					<c:if test="${userInfo.roleId == 4}">
						
						 <div class="nav_divider"></div>	
						 <li>					
						<a href="http://50.17.229.179:8080/TangoTab/jsp/searchdeals.jsp" id="searchdeals" title="Search Deals"><span>Search Deals</span>
							</a>
							</li>
						</c:if>
						<c:if  test="${empty userInfo}">
						
						 <div class="nav_divider"></div>	
						 <li>					
						<a href="http://50.17.229.179:8080/TangoTab/jsp/searchdeals.jsp" id="searchdeals" title="Search Deals"><span>Search Deals</span>
							</a>
							</li>
						</c:if>
			 
					<div class="nav_divider"></div><li><c:if test="${empty userInfo}"><a href="http://50.17.229.179:8080/TangoTab/jsp/login.jsp" id="login" title="Log In"><span>Log In</span></a></c:if><c:if test="${not empty userInfo}"><a href="logout.do" id="login" title="Log Out"><span>Log Out</span></a></c:if></li>
				</ul>
			</div>
			<script type="text/javascript">
				var currentPage = "<%=currentPage%>";
				/*console.warn("Current Page is :"+ currentPage);*/
				if(currentPage == "Home")
					document.getElementById("home").className = 'current';
				else if(currentPage == "MyAccount")
					document.getElementById("myaccount").className = 'current';
				else if(currentPage == "HowItWorks")
					document.getElementById("howitworks").className = 'current';
				else if(currentPage == "SearchDeals")
					document.getElementById("searchdeals").className = 'current';
				else if(currentPage == "Login")
					document.getElementById("login").className = 'current';				
			</script>			
		</div>
		<div class="nav_r"></div>
	</div>
</div>

