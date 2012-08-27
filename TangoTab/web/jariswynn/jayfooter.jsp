
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!--  <script src="../js/jquery-1.js" type="text/javascript"></script> -->


<script src="http://www.tangotab.com/js/sendmail.js" type="text/javascript" charset="utf-8"></script>

<link href="http://www.tangotab.com/css/restyle.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="http://www.tangotab.com/images/TangoT_Icon.ico" />
<div id="fb-root">
</div>
 
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

	<script type="text/javascript" src="http://www.tangotab.com/js/ddsmoothmenu.js"></script>
	
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


<div class="navjay" style="background-color:#000000; width:967px;height: 70px;">
			<div id="smoothmenu1" class="ddsmoothmenu" >
		
		<ul>
			<li style="float:left;"><a href="#">Restaurants</a>

						<ul>
						<li><a href="http://www.tangotab.com/jsp/innerlogin.jsp">Sign in</a></li>
							<li><a href="http://www.tangotab.com/jsp/client_registration.jsp">Sign up</a></li>

							<li><a href="http://www.tangotab.com/jsp/learnmore.jsp" id="Learn More" title="Learn More"><span>Learn
										More</span></a></li>
							<li><a href="http://www.tangotab.com/jsp/publishyourdeal.jsp">Publish your deals</a></li>
							<li><a href="http://www.tangotab.com/jsp/contact_us1.jsp">Contact us</a></li>
						</ul>

			</li> 
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/aboutus.jsp">About Us</a></li>
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/affiliates.jsp">Affiliates</a></li>
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/press.jsp">Press</a></li>
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/jobs.jsp" >Jobs</a></li>  
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/contact_us.jsp">Contact Us</a></li>
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/support_us.jsp">Support</a></li> 
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/privacy_policy.jsp">Privacy</a> </li>	 
			<li style="float:left;"><a href="http://www.tangotab.com/jsp/terms.jsp">Terms</a> </li> 
		
			<br>			
			
		</ul>
		<br/>
		<ul>
		<li style="color:#fff; float:left;">Copyright © 2000-2011 TangoTab.com All rights reserved.</li>
		</ul>
		
		</div>	
		
		</div> 



<!--Added the Email Dialog Here - Social Integration-->

