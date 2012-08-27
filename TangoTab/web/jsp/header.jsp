
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle> 
<!--  <script src="../js/jquery-1.js" type="text/javascript"></script> -->

<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>

<link rel="shortcut icon" href="../images/TangoT_Icon.ico" />
<div id="fb-root">
</div>
<script type="text/javascript">
                    /*  window.fbAsyncInit = function(){
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
                                }());*/

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


function isLoginCookieFound()
{
var emailId='';
var cookieFound = false;
var i,x,y,ARRcookies=document.cookie.split(";");
 
    //alert(ARRcookies[0]);
    /* If cookies found then only search for tangouser id and password */
    if(ARRcookies.length > 1){
	for (i=0;i<ARRcookies.length;i++)
	  {
	  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
	  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
	  x=x.replace(/^\s+|\s+$/g,"");
	 
              // remove double quotes
              
 
			   if(x!='JSESSIONID' && emailId=="" )
			   {
			    var email=x.split("::");
			    
			    if(y.indexOf(",")!= -1){
			      y = y.substring(1,y.length-1);
			      var details = y.split(",");
			    }
			    
			    if(email.length>1)
			    {
			//	document.loginForm.rememberme.checked=true;
			//	 alert(email[1]);
			    document.loginForm.emailId.value=email[1];
			
			//	 alert(y);
			     if(y.indexOf(",")!= -1){
				 document.loginForm.password.value=details[0];
						      document.loginForm.action="login.do";
						   //document.loginForm.submit();  
			 //     document.loginForm.password.value=details[0];
			 //alert(details[0]);
			     }else
				 {
						      document.loginForm.password.value=y;
						      document.loginForm.action="login.do";
						  
				  }
				  cookieFound = true;
			      break;
			    }
			  }
			  
			
	  }
	  }
	 	 return cookieFound;	  
	 
      
}	

function shareForward(eleId){
//alert('first');
 var loggedIn = '${userInfo.roleId}';
 var cookieFounded = false;
 if(document.loginForm != null)
   cookieFounded = isLoginCookieFound();
 //alert(cookieFounded);
 /* if not logged in then if cookie found , send user for login process */
 if( loggedIn.length < 1  && cookieFounded == true )
 {	 
 	 document.getElementById("redirectmsg").innerHTML = "You are autologging! Please wait!";
     document.loginForm.action = "login.do?share=true";
     document.loginForm.submit();
 }
 else{
 //alert('go to share');
 document.getElementById(eleId).href='Friendforward.do?dealId='+'${dealInfo.dealTemplateId}';
   
 } 
 
}	

function shareFriend(eleId){


 var loggedIn = '${userInfo.roleId}';
 
 var cookieFounded = false;
 if(document.loginForm != null)
   cookieFounded = isLoginCookieFound();
 
 //alert(cookieFounded);
 /* if not logged in then if cookie found , send user for login process */
 if( loggedIn.length < 1  && cookieFounded == true )
 {	 
 	 document.getElementById("redirectmsg").innerHTML = "You are autologging! Please wait!";
     document.loginForm.action = "login.do?share=true";
     document.loginForm.submit();
 }
 // if the user is logged in then.. normal process
 else if(loggedIn.length > 0){
 //alert('go to share');
 document.getElementById(eleId).href='Friendforward.do?dealId='+'${dealInfo.dealTemplateId}';
   
 }else
  document.getElementById(eleId).href='login.do?share=true';
 
}					
</script> 



	<!--
<script src="http://code.jquery.com/jquery-1.7.1.min.js"
	type="text/javascript"></script>-->
<script src="../js/popup.js" type="text/javascript"></script>

<div id="header">
	<div class="head_top">
		<div class="logo">
			<c:if test="${not  empty userInfo}">
				<a href="charity.jsp">
				<img src="../images/tango_tablogo.png" border="0" />
				</a>
			</c:if>
			<c:if test="${ empty userInfo}">
				<a href="index.jsp">
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
							title="Sign Out"  onclick="delete_cookie_logindetails('tangotabid');">
							<span>Sign Out</span> 
						</sslext:link>
					</div>
				</div>
			</c:if>
			<%
				String emailId1 = request.getParameter("emailId");
			%>


			<c:if test="${ empty userInfo and  empty profileUsers}">
				<div class="signin" >
				<!-- <div id="button">
						<a href="#"> <img src="../images/signin_icon.png" border="0" /> </a>
					</div>
					<a href="login.jsp">Sign in</a> 
					<a
						href="consumer_registration.jsp?emailId=<%out.write(emailId1);%>"
						style="padding: 0 0 0 5px;">Sign up</a>
			-->&nbsp;	</div> 
			</c:if>

		</div>

		<div class="nav_head1">
		 
				<%
					//if (request.getParameter("currentPage") == "Home")

					String currentPage = request.getParameter("currentPage");
				%>
				<ul>

					
					<c:if test="${ empty userInfo and  empty profileUsers}">
			 	<li>		 
					<a href="login.jsp">Sign in</a> 
					</li>
							<li>  <b> &nbsp;|</li>
					<li><a
						href="consumer_registration.jsp?emailId=<%out.write(emailId1);%>"
						style="padding: 0 0 0 5px;">Sign up</a>  
						</li>
			 	 
			</c:if>
					 
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

							<a href="viewDeals.do" id="myaccount" title="My Account"><span>My
									Account</span>
							</a>
						</c:if>
					</li>


					<c:if test="${userInfo.roleId == 1}">


						<li>
							<a href="viewNames.do?operation=display" id="myaccount"
								title="My Account"><span>My Account</span> </a>
						</li>
					</c:if>
					<c:if test="${userInfo.roleId == 4}">
						<li>
							<a href="profileEdit.do" id="myaccount"
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
						<a href="suggest_restaurant.jsp">Suggestion Box</a>
					</li>
					<li>
					   <a href="http://www.tangotabloid.com" target="_blank" >Blog</a>
					
					</li>

					<li>
						<a id="share" href="#" onclick="javascript:shareFriend(this.id);">Share</a>
					</li>
					
					<li>
						<a href="charity.jsp">Our Movement</a>
					</li>
					
			

					<li>
						<a href="searchForward.do" id="searchdeals" title="Search Deals"><span>Search
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

 
<div id="headerbottom">

</div>

<!--Added the Email Dialog Here - Social Integration


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
  </c:if>-->

  
  	<div id="popupContact" style="display:none;">
				<a id="popupContactClose">x</a>


				<!-- <iframe
					src="https://www.facebook.com/plugins/registration.php?
             client_id=216686028341782&
             redirect_uri=http://www.tangotab.com/jsp/Face.do&
             fields=[
 {'name':'name'},
 {'name':'email'},
  
 {'name':'zipcode',       'description':'Zip Code', 'type':'text'}]"
					scrolling="auto" frameborder="no" style="border: none"
					allowTransparency="true" width="500" height="330">
				</iframe> -->

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

<script type="text/javascript">
function display(){
var ua = navigator.userAgent;

var checker = {
  iphone: ua.match(/(iPhone|iPod|iPad)/),
  blackberry: ua.match(/BlackBerry/),
  android: ua.match(/Android/)  
};

 if(ua.indexOf('NT') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=1024, initial-scale=1, maximum-scale=1">';
   
   }else  if(ua.indexOf('iPhone') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   
   }else  if(ua.indexOf('iPod') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   
   }else  if(ua.indexOf('iPad') != -1){
   
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=768, initial-scale=1, maximum-scale=1">';
   }else  if(ua.indexOf('Android') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   
   }else 
   {
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }
   //alert(document.getElementById('device').value);

}

</script>
<span id="metatag"></span>