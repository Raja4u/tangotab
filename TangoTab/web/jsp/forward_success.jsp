<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<fmt:setBundle basename="tangotab"></fmt:setBundle>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="Tango Tab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>
          
<script src="../js/jquery-1.js" type="text/javascript"></script>
<script src="../js/jquery_003.js" type="text/javascript"></script>
<script src="../js/jquery_002.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/geolocator.js" type="text/javascript" charset="utf-8"></script>

<script src="../js/coda-slider.js" type="text/javascript" charset="utf-8"></script>
	
		<title> TangoTab </title>
		<%@ include file="consumer_imports.jsp"%>
		<script type="text/javascript">
			function submitAction(){
				document.forms[0].action = "userReg.do?type=consumer";
				document.forms[0].submit();
			}
			function eventTracking(){
  				var _gaq = _gaq || [];
  				_gaq.push(['_setAccount', 'UA-32748288-1']);
  				_gaq.push(['_trackPageview']);
 				_trackEvent("Link", "clicked", "BackToOffer", "", true);
 				_trackEvent("Link", "clicked", "ClaimNow", "", true);
  				(function() {
    				var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    				var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  				})();
			}
		</script>
	</head>
	<body onLoad="getCountryDetails();eventTracking();"> 
		

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
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  	 
  	 
  	 <!-- start here  -->
			
			
			
			
						<table width="760" border="0" cellspacing="0" cellpadding="0">
							<tr>
	<td colspan="3" align="center" valign="top">

	</td>
</tr>   
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
									<!-- form Start-->
									
									<table width="965" border="0" cellspacing="0" cellpadding="0">
          <!-- <tr>
            <td background="../images/1.png"></td>
            <td width="949" height="8" background="../images/5.png"></td>
            <td background="../images/2.png"></td>
          </tr> -->
            <tr>
            <!-- <td width="8" background="../images/7.png"></td>-->
            <td height="300" align="center" valign="top"><table width="740" border="0" align="center" cellpadding="0" cellspacing="5">
              <tr>
                <td height="30" colspan="2" align="center" valign="middle" class="red_max">
                <h1 style="font-size:35px;">
					   <c:if test="${empty dealId or dealId eq 0}"><br/>Thank you for sharing TangoTab with friends.</c:if>
                       <c:if test="${not empty dealId and dealId gt 0}"> 
                     <h1 class="red_max">" If I can feed a child... my network can feed a village "
                        <br/><br/>
                       Thank you for referring your friends to TangoTab. Not only will your friends get Exclusive Offers at their Favorite Restaurants, but every time they reserve an offer with TangoTab, they will
						help to feed the hungry!</h1>
                        </c:if>
                </h1>
				</td>
              </tr>
			  <tr>
                <td height="35" colspan="2" align="center" valign="middle">
                <table width="50%" border="0" align="center" cellpadding="0" cellspacing="5">
                <c:if test="${empty dealId or dealId eq 0 }"> 
                <tr >
                 <td  width ="40%" align="right" valign="middle">
                 <!--    facebook and twitter logos...    -->  
                        
			            <div > 
				             <fb:like href='<fmt:message key="facebook.frontpage.url"></fmt:message>' show_faces="false" layout="button_count" width="0" colorscheme="light"></fb:like>
	                    </div>
  		                </td>
  		             <td width ="20%" align="center" valign="middle">
                     <div >
	                       <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
                     </div>
                     </td>
                     <td width ="40%" align = "left" valign="middle">
                     <div> 
							<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>
							<script type="IN/Share" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>'></script>
					 </div>
                     </td>
                    </tr> </c:if>
					<tr><td colspan="3" height="70">&nbsp;</td></tr>
                    <tr> 
                    <c:if test="${not empty dealId and dealId gt 0}">
                      <!-- <td align="center" valign="middle"  ><div id="select_hot"><a   href="dealSummary.do?dealId=${dealId}">Back To Deal</a></div></td>
                       <td align="center" valign="middle" ><div id="select_hot"><a href="forwardLogin.do?dealId=${dealId}">Reserve the Deal</a></div></td> -->
                       <td align="center" colspan="3" style="text-align:center" ><a href="dealSummary.do?dealId=${dealId}" onclick="_gaq.push(['_trackEvent', 'BackToOffer', 'clicked'])" style="margin-right:20px;" ><img src="../images/back_to_offer.png" border="0" /></a>
                      <a href="forwardLogin.do?dealId=${dealId}" onclick="_gaq.push(['_trackEvent', 'ClaimNow', 'clicked'])"><img src="../images/claim_off_its_free.png" border="0" /></a></td>
                     </c:if>
                     
                      <c:if test="${empty dealId or dealId eq 0}">                 
                     <td align="center" valign="middle" colspan="3">
                     <div id="select_hot_max">
                     <a   href="searchForward.do">Search for Offers Now!</a>
                     </div></td>
                     </c:if>
                     </tr>
                 </table>
                 </td>
                </tr>
										  </table></td>
            <!-- <td width="8" background="../images/8.png"></td> -->
          </tr>
          <!-- <tr>
            <td height="8" background="../images/3.png"></td>
            <td height="8" background="../images/6.png"></td>
            <td height="8" background="../images/4.png"></td>
          </tr> -->
        </table>
		<!-- form End-->
								</td>
							</tr>
						</table>
					
<!-- end here  -->
						
   
   
   </div>


</div>

            </div>
            <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div> 
			</body>
</html>
