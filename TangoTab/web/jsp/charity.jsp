<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TangoTab</title>
 
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link href="css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/scrollend.js"></script>

<link href="css/scrollcolor.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />

<style>		
.white_text	{ font-family:Arial, Helvetica, sans-serif; color:#ffffff; font-size:16px; line-height:22px; font-weight:bold; }		
</style>
<style type="text/css">
.text1 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: bold;
	color: #FFFFFF;
	text-decoration: none;
}

#movement_img {
    float:right;
	
}
.content {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	line-height: 18px;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
	text-align: justify;
}

.text2 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-style: normal;
	font-weight: normal;
}
.text2a{
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-style: normal;
	font-weight: bold;
}
.text3 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 20px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-style: normal;
	font-weight: bold;
}
.text4 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-weight: bold;
}
.text5 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-style: normal;
	font-weight: bold;
}
.text6 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 25px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-style: normal;
	font-weight: bold;
}
.text7 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 45px;
	color: #000000;
	text-decoration: none;
	line-height:20px;
	font-style: normal;
	font-weight: bold;
}
#Layer1 {	
float: left;
	left:277px;
	top:375px;
	width:975px;
	height:71px;
	z-index:1;	
}
#Layer2 {
	position:relative;
	left:-0px;
	top:5px;
	width:751px;
	height:89px;
	z-index:2;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>

<script  language="javascript">

function delete_cookie ( cookie_name )
{
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
}




</script>

<%! StringBuffer count = new StringBuffer(); %>
<% count = new StringBuffer( application.getAttribute("charityCount").toString());
//String cnt = request.getSession().getServletContext().getAttribute("charityCount").toString();
 //count = new StringBuffer(cnt);
/* put the count in comma separated */
if(count.length() > 3){
for(int i = 1; count.length()-(3*i+i-1) > 0; i++){
   count = count.insert(count.length()-((3*i)+i-1),",");
  //System.out.println(count.length()-(3*i+i-1));
  //System.out.println(count);
   }
   }
%> 
</head>

<body onLoad="delete_cookie('showhidt');">
<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="charity" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
     <table width="980" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
         <td>
            <table width="980" border="0" cellspacing="0" cellpadding="0">
     	      <tbody><tr>
                <td colspan="2" align="left" valign="top" bgcolor="#FFFFFF" scope="row"><img src="../images/movementbanner.png" width="1000" height="279"></td>
              </tr>
            </tbody></table></td>
          </tr></tbody></table>
  	 
  	 
  	 <div class="content_deal_inner">	
     
     <div style="padding:14.5px; background-color:#ffffff; width:100%;" >     
          <table width="980" border="0" cellspacing="0" cellpadding="0">
          
          <tr>
            <td align="center" valign="top" bgcolor="#FFFFFF" scope="row">
	      <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72%" align="left" valign="top" scope="row">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                 <tr>
                    <td colspan="3" align="left" valign="top" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" scope="row"><span class="text2">Most envision hunger as a problem that occurs only in the third world, yet a significant hunger battle is happening here at home.</span></td>
                  </tr>
                  <tr>
                    <td colspan="3" height="10"  align="left" valign="top" scope="row">&nbsp;</td>
                  </tr>
                   <tr>
                    <td height="120" colspan="3" align="left" valign="top" scope="row"><div id="Layer2"><img src="../images/movementgraphic.png" width="780" height="125"></div></td>
                  </tr>
                  <tr>
                    <td height="8" colspan="3" align="center" valign="middle" class="text3" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="3" align="center" valign="middle" class="text3" scope="row"><i>1 in 6 North Americans will go to bed hungry  tonight<i></td>
                  </tr>
                  <tr>
                    <td height="8" colspan="3" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" scope="row"><span class="text2">There is no simple cure for hunger. There are no  prescriptions or magic pills, procedures or doctors that can cure this  issue.&nbsp; This is where TangoTab steps in. </span></td>
                  </tr>
                  <tr>
                    <td height="8" colspan="3" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" class="text3" scope="row">Our Mission</td>
                  </tr>
                  <tr>
                    <td height="8" colspan="3" align="left" valign="top" scope="row"></td>
                    </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" class="text2" scope="row">
                    TangoTab feeds a person in need every time our diners redeem an offer at participating restaurants. When You eat They Eat! </td>
                  </tr>
                  <tr>
                    <td height="8" colspan="3" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" scope="row"><span class="text3"><i>Free and Easy </i></span></td>
                  </tr>
                  <tr>
                    <td height="8" colspan="3" scope="row"></td>
                  </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" class="text2" scope="row">You don&rsquo;t have to change your daily routine. You don&rsquo;t have  to spend any additional money. TangoTab makes it free and easy to get great  offers and feed those in need. &nbsp;<strong class="text2"></strong></td>
                  </tr>
                  <tr>
                    <td height="15" colspan="3" scope="row">&nbsp;</td>
                  </tr>
                  <tr>
                    
                    
                    <td width="100%" colspan="3" align="left" valign="top" scope="row"><span class="text2"><b>Join.</b> The  Movement and become a soldier in the fight against hunger</span></td>
                  </tr>
                  <tr>
                    <td height="15" colspan="3" scope="row"></td>
                  </tr>
                  <tr>
                   
                      <td align="left" colspan="3" valign="top" class="text2" scope="row"><b> Feed.</b> Every time you dine at one of our  participating restaurants, we feed a person in need (<%= count %> people fed this year)  </td>
                  </tr>
                  <tr>
                    <td height="15" colspan="3" scope="row"></td>
                  </tr>
                  <tr>
                    
                    <td colspan="3" align="left" valign="top" class="text2" scope="row"><b>Inspire. </b>Be  a philanthropist for hunger.&nbsp;<b><a href="http://www.tangotab.com/jsp"  class="text2a"> <span class="text2a">Sign up </span></a></b>today and share TangoTab with your <b><a href="http://www.facebook.com/sharer.php?u=http://www.tangotab.com" target="_blank" style="text2a"><span class="text2a">Facebook</span> </a></b> &nbsp;friends and <b><a href="http://twitter.com/share?text=I use @TangoTab. When I dine out, I feed a person in need. You can too! http://www.tangotab.com #charity# Dining" target="_blank" class="text2a"><span class="text2a">Twitter</span> </a></b> &nbsp;followers.<strong> </strong>You are the voice for the cause<strong>.</strong></td>
                  </tr>
                  <tr>
                    <td colspan="3" scope="row" height="15">&nbsp;</td>
                  </tr>
                  <tr>
                   
                    <td colspan="3" align="left" valign="top" class="text3" scope="row"><i>If you can feed a child, your network can feed a village</i></td>
                  </tr>
                  
                </table></td>
                <td width="28%" align="center" valign="top" scope="row">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <th align="center" valign="top" scope="row">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr><td height="20px;" >&nbsp;</td></tr>
            
  <tr>
   <td height="67" align="center"><a href="http://www.minniesfoodpantry.org/mfp/index.html" target="_blank"><img src="../images/minnie.jpg" border="0"/></a></td>
   </tr>
   <tr><td height="75" align="center"><a href="http://solvehungertoday.org/" target="_blank"><img src="../images/NIFB_Logo_2.png" alt="img" width="160" height="62" border="0"/></a></td>
   </tr>
   <tr><td height="100" align="center"><a href="http://www.cityharvest.org/" style="" target="_blank"><img src="../images/social-nonprofit.jpg" alt="img" width="109" height="83" border="0"/></a></td>
   </tr>
   <tr><td height="118" align="center" valign="middle"><a href="http://www.regionalfoodbank.org/" target="_blank"><img src="../images/rfbok.png" alt="img" width="160" height="109" border="0"/></a></td>
   </tr>
   <tr><td height="85" align="center"><a href="http://www.soupmobile.org/" target="_blank"><img src="../images/soup_mobile_logo.png" alt="img" width="105" height="56" border="0"/></a></td>
   </tr>
   <tr><td height="110" align="center"><a href="http://www.acocares.org/aco/" target="_blank"><img src="../images/aco_logo.jpg" alt="img" width="74" height="99" border="0"/></a></td>
   </tr>
                    </table></th>
                  </tr>
                </table></td>
              </tr>
            </table>
            </td>
            </tr>
            </table></div>
	 
	 </div>
	 
	 </div>
	
            
           <%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>

<map name="Map" id="Map">
<area shape="rect" coords="267,20,332,89" href="http://www.tangotab.com" />
</map>    

<map name="Map2" id="Map2">
<area shape="rect" coords="46,2,137,96" href="http://www.facebook.com/TangoTab?sk=photos" target="_blank" />
<area shape="rect" coords="14,107,172,128" href="http://www.facebook.com/TangoTab?sk=photos" target="_blank" />
<area shape="rect" coords="38,136,148,163" href="#" />
</map>
    
</body>
</html>
