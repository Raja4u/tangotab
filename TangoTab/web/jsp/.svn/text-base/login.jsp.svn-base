<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tangotab.util.GenerateHashData"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<fmt:setBundle basename="tangotab"></fmt:setBundle>
	<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/hashcode.js'></script>
     <script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
	<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title> TangoTab </title>
		<%@ include file="imports.jsp"%>
		
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-33008810-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
	<script type="text/javascript" language="javascript">
	
	var emailId='${loginForm.emailId}';
	//alert(emailId);
	function getCookie()
{

var i,x,y,ARRcookies=document.cookie.split(";");
 
 //alert(ARRcookies.length);
	for (i=0;i<ARRcookies.length;i++)
	  {
	//alert(ARRcookies);
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
			    document.loginForm.emailId.value=email[1];
			     if(y.indexOf(",")!= -1){
			      document.loginForm.password.value=details[0];
			     }else
				 {
				 
			      document.loginForm.password.value=y;
				  }
			    break;
			    }
			  }
	  }
 
}
function getCookieByName()
{

var cname=document.loginForm.emailId.value;
 document.loginForm.password.value='';
var i,x,y,ARRcookies=document.cookie.split(";");

for (i=0;i<ARRcookies.length;i++)
  {

  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
			    var email=x.split("::");
  		 if(email.length>1)
			    {
	 
				  if(cname==email[1])
				  {
				  //alert(y);
				  // remove double quotes
		//		  document.loginForm.rememberme.checked=true;
				  if(y.indexOf(",")!= -1){
                  y = y.substring(1,y.length-1);
                  var details = y.split(",");
				  document.loginForm.password.value=details[0];
				  //alert(document.loginForm.password.value);
				  }else{
				   //alert(document.loginForm.password.value);
				   
				   document.loginForm.password.value=y;
				  }
				  }
 			}
  }
}
	
		
function delete_cookie ( cookie_name )
{
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
}

function submitme()
{
	
	var mail = document.getElementById("emailId").value;
	hashcode.getHashValue( mail, function(data) {
       	  _gaq.push(['_setCustomVar',3,'email',data,2]);  
		  _gaq.push(['_trackPageview']);
    	document.loginForm.submit();
    	 
 });
	 
	return false;
}

    
  

</script>		
	</head>
	<body  onload="delete_cookie('showhidt'); getCookie();">

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
            <div class="main_deal" >
  
  <div class="top_header" ><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 
  	 
  	 
  	 
  	 
  	 <!-- start login -->
  	 <div class="content_deal_inner">
  	 <div class="login_page_main">			
				
<html:form action="/jsp/login" onsubmit="return submitme();" >
<div class="login_left">
		<div class="login_key"><div class="key"><img src="../images/logicon.png" width="28" height="31" /></div> <h1 style="color:#E46C0E; font-size:18px; font-weight:bold;">I already have an account.</h1></div>											
		
		<div><logic:messagesPresent message="true"><html:messages id="message" message="true">
			<logic:present name="message">
			<FONT color="red">
				<bean:write name="message" filter="false" />
			</FONT>
			</logic:present>
			</html:messages>
			</logic:messagesPresent>
		</div>												
		<p>Email:</p> 
		<div><html:hidden property="dealId" value="${dealID}" name="loginForm"/>
			<html:text property="emailId" styleClass="substxt" styleId="emailId" onkeyup="hidetext('emailId');getCookieByName();"  onchange="getCookieByName();"  /><span id="emailId">
		<html:errors  property="emailId"/></span>
		<html:hidden property="dealId" value="${dealID}"/>
		<html:hidden property="date" value="${date}" />
		<input type="hidden" name="compressedURL" value="${compressedURL}"/>
		<c:if test="${not empty share }">
    		<input type="hidden" name="share" id="share" value="${share}" />
    		</c:if>
    		<c:if test="${empty share }">
    		<input type="hidden" name="share" id="share" value="<%=request.getParameter("share")%>" />
    		</c:if>
	
		</div>
		<p>Password:</p>
		<div>
			<html:password property="password" styleClass="substxt" styleId="textfield2" value=""  onkeyup="hidetext('password');"  />
			<span id="password">
			<html:errors  property="password"/></span>
		</div>
	<div><a href="./forgot_password.jsp" style="color:#7d9b17;text-decoration: none;"><h2 style="color:#7D9B17; font-size:14px; font-weight:bold;">Forgot Password</h2></a></div>
	<div><p><html:checkbox property="rememberme" styleId="rememberme" ></html:checkbox>&nbsp;Keep Me Signed In</p></div>															
	<div><div id="select_hot">
	<html:submit styleClass="but_img" value="Log In" >Log In</html:submit>	</div>																						    </div>
																			
</div>

<!-- start next dev-->
<div class="right_login"  style="width:550px;">	
<h1 style="color:#E46C0E; font-size:18px; font-weight:bold;">I do not have an account.</h1>
<br/>
<!-- <h2>Sign up for an account for:</h2>-->
<p>
TangoTab is a free service that allows you to search and claim for specials, events, and exclusive offers at your favorite restaurants, for free. The best part is that by redeeming these free offers through TangoTab, you are joining in the fight against hunger. Each time an offer is redeemed, TangoTab donates a meal to local food banks and hunger-related charities. When you eat, they eat. Sign up today!
<!-- Incredible Offers Choice of ample deals available every day																	Ability to share with your friends and earn rewards
Immediate access to your confirmed deal
Ability to carry confirmation on your phone -->
<br/><br/> 
 
</p>
<div id="select_hot">
<a href="consumer_registration.jsp">Sign Up</a> 
</div>
	</div>					
</html:form>
<div>
				
</div>
  	 
  	 <!-- End login -->
   
   
   
   </div>


</div>

</div>
<div class="top_bottom">
    <img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>
   <%@ include file="footer.jsp"%>
  </div>  
        </div>
        </div>
    </div>
	</div>
	 </div>
	 
	 
	</div>

</div>

<div style="clear:both;"></div>
</div>		
	</body>
</html>

