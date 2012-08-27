
<%@page import="com.tangotab.util.DateConverterUtility"%> 
<%@page import="com.tangotab.TO.DealTO"%><%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.tangotab.TO.BookDealTO" %>
<%@ page import="com.tangotab.TO.DealTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ page import="com.tangotab.util.DateConverterUtility"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.tangotab.web.DealSummaryAction" %>

<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> ${dealInfo.locationName} | TangoTab ${userInfo.consumerPreferCity.city.cityName}</title>

<meta content='noindex, nofollow' name='robots' /> <meta content='text/html;charset=utf-8' http-equiv='Content-Type' /> 

<meta content='<TangoTab ${dealInfo.locationName}  Deal: TangoTab feeds a person in need every time you dine out with one of our offers. Subscribe for great restaurant deals in Dallas; other cities.' name='description' />
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<!--
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
-->
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link href="../css/bookdealpopover.css" rel="stylesheet" type="text/css" />
 
<style>
#OVER{width:100%; height:100%; left:0px;/*IE*/ top:0px; text-align:center; z-index:5; position:fixed; filter:alpha(opacity=20); opacity:0.2; background-color:#fff;}
#overlay {width:40%; height:50%; z-index:6; display:inline; left:38%;/*IE*/ top:30%; font-color:#cdcdcd; font-size:0.8em;
filter:alpha(opacity=100); opacity:1;text-align:center; position:fixed; background-color:#777;}
#popupContactdeal {-webkit-border-radius: 58px;
-moz-border-radius: 58px;
border-radius: 58px; width:330px; height:auto; padding:10px;
border:solid 1px #000;  left:38%; top:30%;valign:middle;

}
#popupContactdeal h2{text-align: center; color: #000; margin-bottom:15px;}
#popupContactdeal p{color: #000; margin-bottom:15px;}
</style>
<script src="../js/jquery-1.4.3.min.js"> </script>
<script>
		!window.jQuery && document.write('<script src="../js/jquery-1.4.3.min.js"><\/script>');
	</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-33208416-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<script type="text/javascript">
var login = "tangotab";
var api_key = "R_ff805c1c630f643b1db6e8a83a139ffe";
var shortURL="";
function get_short_url(long_url, login, api_key, func)
{
 	
    $.getJSON("http://api.bitly.com/v3/shorten?callback=?", 
        { 
            "format": "json",
            "apiKey": api_key,
            "login": login,
            "longUrl": long_url
        },
        function(response)
        {
            func(response.data.url)
             
        }
	);
	
	
}
function shortUrls(long_url){        
                                                                                                                                                 
	get_short_url(long_url, login, api_key, 
		function(short_url) {
			shortURL=short_url;
			
			
	});
	
}
	$(document).ready(function() {
	var exdate=new Date();
	exdays = null;
	exdate.setDate(exdate.getDate() + exdays);
	var c_name = 'landing';
	var value='${refferCode}';	
	if( value != null && value != "" && value.trim != "" ){
	var c_value = value + ((exdays==null) ? "" : "; expires="+exdate.toUTCString())+"; path=/" ;
	//alert(c_value);
	document.cookie=c_name + "=" + c_value;  
	 
	//getCookie('landing'); 
	}
	shortUrls("<fmt:message key='website.home'></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}&date=${dealInfo.startDate}");
	//shortUrls("<fmt:message key='website.home'></fmt:message>jsp/searchForward.do");
	
	});

function setCookie(c_name,value,exdays)
	{
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
	}

function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
{
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    return unescape(y);
    }
  }
}






function signupa()
{
 window.location='consumer_registration.jsp';
}
</script>
<style>
.main_deal h1{margin:0px; padding:0px; color: #000000;    color: #000000;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 14px;
    font-style: normal;
    font-weight: bold;
    line-height: 16.5px;
    text-decoration: none; } 

.main_deal h2{margin:0px; padding:0px; color: #FF7701;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 35px;
    font-style: normal;
    font-weight: bold;
    text-decoration: none;} 

</style>

<script type="text/javascript">

       function filtersearch()
       {
            var showhidt;
           setCookie("showhidt",showhidt,365);
           document.getElementById('sfilters').style.display='block';
       }



function seediv()
{

	var showhidt = getCookie("showhidt")
     if(showhidt!=null && showhidt!="")
     {
        document.getElementById('sfilters').style.display='block';
     }
}


function close(){
//alert("hi");
document.getElementById('popupContactdeal').style.display='none';
document.getElementById('backgroundPopupdeal').style.display='none';
}
function show(){
//alert("hi");
document.getElementById('popupContactdeal').style.display='block';
document.getElementById('backgroundPopupdeal').style.display='block';
_gaq.push(['_trackEvent', 'Offer Claim', 'Click', 'Claim Offer']);
}


								
</script>

<link rel="stylesheet"  type="text/css" href="tangotab.css"/>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false">
</script>
<script type="text/javascript">


		 function codeAddress(){
            
                geocoder = new google.maps.Geocoder();
                var options = {
                    zoom: 15,
                    center: new google.maps.LatLng(37.09, -95.71),
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    mapTypeControl: true,
                    mapTypeControlOptions: {
                        style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR
                    }
                };
                var geocoder;
                var map = new google.maps.Map(document.getElementById("map_canvas"), options);
                var address = document.getElementById("address").value;
                geocoder.geocode({
                    'address': address
                }, function(results, status){
                    if (status == google.maps.GeocoderStatus.OK) {
                        map.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                    }
                    else {
                       // alert("Geocode was not successful for the following reason: " +   status);
                    }
                });
            }

								
               

	</script>
</head>
<%! String month ;
int day;
String postfix = "";
String fromtime = "";
String totime = "";
Calendar today  = Calendar.getInstance();
Calendar cal;
  %>
<% try{
DealTO dealto = new DealTO();
String sdate = new String();
Date date = new Date();
dealto = (DealTO)request.getAttribute("dealInfo");
sdate = dealto.getStartDate(); 
date = DateConverterUtility.convertUiToServiceDate(sdate);
 cal  = Calendar.getInstance();
cal.setTime(date);
month = new SimpleDateFormat("MMMM").format(date);
 day = cal.get(Calendar.DAY_OF_MONTH);
	 if(day==12)
		postfix="th";
     else if(day==13)
		postfix="th";
	  else if(day % 10 == 1)
            postfix = "st";
      else if(day % 10 == 2)
            postfix = "nd";
      else  if(day % 10 == 3)
            postfix = "rd";
      else 
            postfix = "th";
 fromtime = dealto.getAvailableStartTime();
 if(fromtime != null)
   fromtime = fromtime.toLowerCase().trim().replace(" ","");
 totime = dealto.getAvailableEndTime();
 if(totime != null)
   totime = totime.toLowerCase().trim().replace(" ","");;
   }catch(Exception e){
   }
 %>
<body onload="codeAddress();">
<div id="fb-root">
</div>
<script>
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

 <div id="popupContactdeal" style="display:none;">
<span style="position: absolute;    right: -20px;    top: -11px;padding-right:5px;vertical-align:top;">
		<a  id="popupContactClose" href="javascript:close();"><img src="../images/close_popup.png" border="0" /></a>
		</span>
		
		<h2>Thank You</h2>
			<div style="padding-left:13px;padding-right:13px;text-align: left;">
			<p><b>Please remember this is only valid <span style="color:#e46c0a;" >
			<%if(today.get(Calendar.DAY_OF_YEAR)==cal.get(Calendar.DAY_OF_YEAR)&&today.get(Calendar.YEAR)==cal.get(Calendar.YEAR)){ %>Today<%}else{ %> ${dealInfo.day}, <%=month%> <%=day%><sup><%=postfix%></sup><%}%>
			 from <%=fromtime%> to <%=totime%></span>.</b></p>
		     <p>When you redeem at the restaurant, TangoTab feeds a person in need.</p> 		
	  </div>	
	  <p style="text-align: center;"><a   href="javascript:sendDeal('${dealInfo.dealTemplateId}','${dealInfo.startDate}');"><img src="../images/confirm.png" border="0" /></a></p>
                                      	 
   <p><a href="javascript:close();"  ><img src="../images/oops_cancel_offer.png" border="0" /></a></p>
       

	</div>
<div id="backgroundPopupdeal"  style="display:none;">
	  </div> 


<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="" />
		</jsp:include> 
		
		<!--Header End here-->
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   	
   	<div class="get_yourdetail">
  	<div style="width:695px; float:left;">
    		<!--  <div class="get_deals">
    		<img src="../images/youare_searching.jpg" alt="getyour" /></div> -->
            	<div class="wasingation">&nbsp;</div>
                	<div class="cheng_city">
                	<!--  <div class="city_txt"><%
               String citiname =request.getParameter("cityName");
               	out.write(citiname); 
                	%></div>
                	<div class="refer_deal"><a id="various1" href="#inline1"><b>Change <br/> City</b></a>
                	                	
                	</div>
                	<div class="refer_city"><a href="#" onClick="filtersearch()"><b>Search <br/>filters</b></a>
                    	
                	</div> -->
                    </div>
                  <!-- filters -->
    </div> 
  
   <div class="list_box_effect" id="sfilters" style="display:none;">
                   <html:form action="/jsp/search">
                       	
                       	
                       	<div>
                       	 <input type="hidden" name="cityName" value="<% out.write(citiname); %>" />
                       
                      </div>
                       	
                    <div class="list_top_item">
                    <html:select property="diningStyle"  styleClass="restaurant_select" onchange="submit()">
                <html:option value="">Select Dining Style</html:option>
                <bean:define id="relationships4" name="dropDownList" property="diningStyles" type="java.util.ArrayList"/>
  				<html:options collection="relationships4" property="diningStyleId" labelProperty="diningStyleName"/>
         </html:select>
         </div>
         
                    <div class="list_top_item">
                    <html:select property="cuisineType"  styleClass="restaurant_select" onchange="submit()">
                <html:option value="">Select Cuisine</html:option>
                <bean:define id="relationships1" name="dropDownList" property="cusineTypes" type="java.util.ArrayList"/>
  				<html:options collection="relationships1" property="cuisineTypeId" labelProperty="type"/>
         </html:select>
         </div>
         
                    <div class="list_top_item"> 
                     <html:select property="priceStartRate"  styleClass="restaurant_select" onchange="submit()">
                <html:option value="">Select Menu Price</html:option>
               <c:forEach var="price" items="${dropDownList.prices}" varStatus="count">
               		<html:option value="${price.startPrice},${price.endPrice}"> $ ${price.startPrice} - $ ${price.endPrice}</html:option>
               </c:forEach>
         </html:select>
         </div>
         
          <div class="list_top_item">
        <html:select property="rating"  styleClass="restaurant_select" onchange="submit()">
                <html:option value="">Select Rating</html:option>
                <html:option value="1">1 Star</html:option>
                <html:option value="2">2 Star</html:option>
                <html:option value="3">3 Star</html:option>
                <html:option value="4">4 Star</html:option>
                <html:option value="5">5 Star</html:option>
         </html:select></div>
                    
           </html:form> 
          </div> 
  
  
  <div class="inner_cantainer">
            <div class="main_deal">
            <div style="float:left;">
            <logic:messagesPresent message="true">
																	<html:messages id="message" message="true">
																		<logic:present name="message">
																			<tr>
																				<td align="center" valign="middle" colspan="2">
																					<FONT color="red"> <bean:write
																							name="message" filter="false" /> </FONT>
																					<br>
																				</td>
																			</tr>
																		</logic:present>
																	</html:messages>
																</logic:messagesPresent>
<FONT color="red"><p id="redirectmsg" style="width:300px;float:right;align:center" ></p> </FONT><br/>
            </div>
   <!-- new changes start-->
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <th align="center" valign="top" scope="row"><table width="1003" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="center" valign="top" scope="row">
                    
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="29%" align="left" valign="middle" scope="row">
                        <img src="${dealInfo.locationRestImgPath}"  border="0" width="286" height="223"></td>
                        <td width="71%" scope="row"  >
                            <div  >
      					
                      <div id="map_canvas" style="width: 690px; height: 223px">
                                                                                                    </div>
                              <input type="hidden" value='${dealInfo.address} ${dealInfo.address1} ${dealInfo.city} ${dealInfo.state} ${dealInfo.zipcode}' id="address" />
                    
                      </div>
                        </td>
                      </tr>
                      <tr>
                        <td height="10" colspan="2" scope="row"></td>
                      </tr>
                      <tr>
                        <td colspan="2" align="center" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="68%" align="center" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td colspan="2" align="left" valign="top" scope="row"></td>
                              </tr>
                              <tr>
                                <td colspan="2" align="left" valign="middle" class="offersleft_bg" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td align="center" valign="middle" class="padding1" scope="row"><table width="83%" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td align="left" scope="row" class="text_bold4">${dealInfo.remainingDeals} OFFERS LEFT </td>
                                      </tr>
                                    </table></td>
                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td height="35" colspan="2" scope="row"></td>
                              </tr>
                              <tr>
                                <td height="8" colspan="2" scope="row"></td>
                              </tr>
                              <tr>
                                <td width="75%" align="left" valign="top"  scope="row"><h2>${dealInfo.dealTemplateName}</h2> </td>
                                <td  width="25%" rowspan="3" align="center" valign="top" scope="row" >
                                <c:if test="${not dealInfo.expired }">
                                            <a href="javascript:void();" onclick="show();"   ><img src="../images/claimnow_btn.png" border="0" /></a>
                                            	
                                 </c:if> 
                                 <c:if test="${dealInfo.expired }">
                                            <img src="../images/expired.png" border="0" />
                                            	
                                 </c:if> 
                                 <input type='hidden'  name='dealId'  value="${dealInfo.dealTemplateId}" />
                                </td>

                              </tr>
                              <tr>
                                <td height="15" colspan="2" scope="row"></td>
                              </tr>
                              <tr>
                                <td colspan="2" align="left" valign="top" class="text_bold4" scope="row" style="padding-right:150px;">${dealInfo.dealTemplateDescription} </td>
                              </tr>
                              <tr>
                                <td colspan="2" scope="row">&nbsp;</td>
                              </tr>
                              <tr>
                                <td colspan="2" scope="row">&nbsp;</td>
                              </tr>
                              <tr>
                              <% DealTO d=(DealTO)request.getAttribute("dealInfo");
                               String uiDate="";
                               if(d!=null)
                               uiDate=DateConverterUtility.convertUiToOffers(d.getStartDate());
                               %> 
                                <td colspan="2" align="left" valign="top" class="text_bold5" scope="row">${dealInfo.day} <%=uiDate%>, ${dealInfo.availableStartTime} TO ${dealInfo.availableEndTime}</td>
                              </tr>
                              <tr>
                                <td colspan="2" class="text_bold5" scope="row">&nbsp;</td>
                              </tr>
                              <tr>
                                <tr>
                                <td align="left" valign="top" class="text_bold1" ><span>Offer Restrictions:</span><span style="font-weight:normal; margin-left:5px;">${dealInfo.dealTemplateRestrictions}</span>                              
                                
                                 </td>
                                
                              </tr>

                              </tr>
                              <tr>
                                <td colspan="2" align="left" valign="top" class="text_bold1" scope="row">&nbsp;</td>
                              </tr>
                              <tr>
                                <td colspan="2" align="left" valign="top" class="text_bold1" scope="row">&nbsp;</td>
                                </tr>
                              <tr>
                                <td colspan="2" align="left" valign="top" class="text_bold1" scope="row">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td align="right" valign="top" class="claim_bg" scope="row">
                                    </td>
                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td colspan="2" align="left" valign="top" scope="row"> <p class="text_p">
                            ${dealInfo.description}</p></td>
                              </tr>
                              <tr>
                                <td colspan="2" align="left" valign="top" class="text_bold1" scope="row">&nbsp;</td>
                              </tr>
                            </table></td>
                            <td width="32%" align="center" valign="top" scope="row">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="right" valign="top" scope="row"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td align="center" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td align="left" valign="top" scope="row"><span class="text_bold1">Share this Offer  </span></td>
                                      </tr>
                                      <tr>
                                        <td scope="row">&nbsp;</td>
                                      </tr>
                                      <tr>
                                        <td align="left" valign="top" scope="row"><table width="63%" border="0" cellspacing="0" cellpadding="0">
                                          <tr>
                                            <td align="center" valign="top" scope="row">
                                                 <div id="fpublish_like" style="float:left; ">
					<a   onclick="publishToFacebook(); return false;" title="Facebook Publish" id="fPublishLinkID">
					<img src="../images/facebook_img.png" width="55" height="56" border="0"/></a>
					</div>
                                            
                                            </td>
                                            <td align="center" valign="top" scope="row">
              
                                              <div id="tweet_like_search">
											  <script type="text/javascript">
											  function opentwitter()
											  {
var dealname=escapeSpecial("${dealInfo.dealTemplateName}");
var rname=escapeSpecial("${dealInfo.locationName}");
var location='<fmt:message key='website.home'></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}%26date=${dealInfo.startDate}';
//var link="https://twitter.com/intent/tweet?original_referer="+window.location+"&source=tweetbutton&text=Wow! Check out "+dealname+" at "+rname+" , get yours quickly @TangoTab.  "+location+" %23charity+%23Dallas+%23Dining";
 var link="https://twitter.com/intent/tweet?original_referer="+window.location+"&source=tweetbutton&text= I'm fighting hunger with @TangoTab. I fed someone in need just by dining out. "+shortURL+", "+dealname+"";
window.open(link,'twi',"height=300,width=400,top=200,left=300,status=no,toolbar=no,menubar=no,location=0,resizable=no,scrollbars=yes",0);
}</script>
	 <a href="javascript:opentwitter()"  	 >
	  <img src="../images/twitter_img.png"   width="55" height="56" border="0" /></a>
	  <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div></td>
                                            <td align="center" valign="top" scope="row">
                                            	<div style="float:left">
                      <a id="friend" href="#" onclick="javascript:shareForward(this.id);"><img src="../images/email_btn.png" width="55" height="56"border="0" /></a>
                      </div>
                                       </td>
                                          </tr>
                                        </table></td>
                                      </tr>
                                    </table></td>
                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td align="right" valign="top" scope="row">&nbsp;</td>
                              </tr>                              
                              <tr>
                                <td align="right" valign="top" scope="row"><table width="95%" border="0" cellspacing="4" cellpadding="4">
                                  <tr>
                                    <td colspan="2" align="left" valign="top" scope="row"><h1>${dealInfo.locationName} </h1></td>
                                  </tr>
                                  <tr>
                                    <td height="8" colspan="2" scope="row"></td>
                                  </tr>
                                  <tr>
                                    <td width="42%" align="left" valign="top" scope="row"><span class="text_bold2"><strong>Dining Style:</strong></span></td>
                                    <td width="58%" align="left" valign="top" scope="row"><span class="text_p">${dealInfo.diningStyleString} </span></td>
                                  </tr>
                                  <tr>
                                    <td align="left" valign="top" scope="row"><strong class="text_bold2">Cuisine:</strong></td>
                                    <td align="left" valign="top" scope="row"><span class="text_p">${dealInfo.cuisineTypeString}</span> </td>
                                  </tr>
                                  <tr>
                                    <td align="left" valign="top" class="text_bold2" scope="row">Price:</td>
                                    <td align="left" valign="top" class="text_p" scope="row">${dealInfo.price} </td>
                                  </tr>
                                  <tr>
                                    <td align="left" valign="top" class="text_bold2" scope="row">Website:</td>
                                    <td align="left" valign="top" class="text_p" scope="row">${dealInfo.website}</td>
                                  </tr>
                                  <tr>
                                    <td align="left" valign="top" class="text_bold2" scope="row">Address:</td>
                                    <td align="left" valign="top" class="text_p" scope="row"> 
                                     <c:if test="${ empty dealInfo.address1}">${dealInfo.address}</c:if>
                                     <!-- checking whether the second address is available or not -->
                                     <c:if test="${not empty dealInfo.address1}">${dealInfo.address}, ${dealInfo.address1}
                                     </c:if>
                                       
					<br/>  ${dealInfo.city}, ${dealInfo.state} ${dealInfo.zipcode} 
		 				</td>
                                  </tr>
                                  <tr>
                                    <td align="left" valign="top" class="text_bold2" scope="row">Phone:</td>
                                    <td align="left" valign="top" class="text_p" scope="row">
                                    <c:if test="${fn:length(dealInfo.cellPhone) eq 10}"> 
							${fn:substring(dealInfo.cellPhone, 0, 3)}-${fn:substring(dealInfo.cellPhone, 3, 6)}-${fn:substring(dealInfo.cellPhone, 6, 10)}
			</c:if></td>
                                  </tr>
                                </table></td>
                              </tr>
                            </table></td>
                          </tr>
                        </table></td>
                        </tr>
                      <tr>
                        <td colspan="2" scope="row">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></th>
              </tr>
            </table>
   <!-- new changes end -->


<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>
</div>

<!-- Start fancy box -->
 


<!-- End Fancy Box -->

<fmt:setBundle basename="tangotab"></fmt:setBundle>
<span id="msg" style="display:none;"></span>
<script type="text/javascript">
	//var currentURL=document.location.href;
	//document.getElementById('fb').setAttribute('href', currentURL);	
     var currentURL='<fmt:message key="website.home"></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}%26date=${dealInfo.startDate}';
	 var imgurl = '${dealInfo.locationRestImgPath}';
	 imgurl = imgurl.replace('../','/');
	
	function publishToFacebook(){
	 
 // calling the API ...${dealInfo.locationRestImgPath}
        var obj = {
          method: 'feed',
		  link: '<fmt:message key="website.home"></fmt:message>jsp/index.jsp',
          picture: '<fmt:message key="website.home"></fmt:message>'+imgurl,
          caption: ' ',
          //description: "I just claimed ${dealInfo.dealTemplateName} at ${dealInfo.locationName}, get yours too @TangoTab. I fed myself and someone in need. "+currentURL 
           description: "I'm fighting hunger with @TangoTab.&nbsp;I claimed an offer at ${dealInfo.locationName}and fed someone in need just by dining out. "+currentURL  
		 
        };

        function callback(response) {
          document.getElementById('msg').innerHTML = "Post ID: " ;
        }

        FB.ui(obj, callback);
}


	//Has Added this new method to replace the Special Charcters - Which will not be allowed by Facebook API.
	function escapeSpecial(text) {
		return text.replace(/[^a-zA-Z $ ()0-9]+/g,'');   
	}

</script>
<form name="loginForm" method="post">
 <input type="hidden" name="emailId"/>
 <input type="hidden" name="password"/>
 <input type="hidden" name="dealId" value="${dealInfo.dealTemplateId}" />
 <input type="hidden" name="date" value="${dealInfo.startDate}"/> 
</form>

 <form name="sendDeal" method="post">
 <input type="hidden" name="dealId"/>
 <input type="hidden" name="date"/>
 <input type="hidden" name="compressedURL"/>
  <input type="hidden" name="cityName" value="${searchForm.cityName}"/>
 
 </form>
 
<script language="javascript">
function sendDeal(dealId,date)
{
 
document.sendDeal.dealId.value=dealId;
document.sendDeal.date.value=date;
document.sendDeal.compressedURL.value=shortURL;
 var loggedIn = '${userInfo.roleId}';
 var cookieFounded = isLoginCookieFound();
 //alert(loggedIn.length);
 //alert(cookieFounded);
 /* if not logged in then if cookie found , send user for login process */
 if( loggedIn.length < 1  && cookieFounded == true )
 {document.getElementById("redirectmsg").innerHTML = "You are autologging! Please wait!";
     document.loginForm.action = "login.do?bypass=true";
     document.loginForm.submit();
 }
 else{
    document.sendDeal.action="forwardLogin.do";
	document.sendDeal.submit();
 } 

}
</script>
</body>
</html>
  