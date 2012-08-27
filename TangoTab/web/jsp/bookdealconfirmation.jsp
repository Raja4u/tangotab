<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.tangotab.TO.BookDealTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<!--
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
-->
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link href="../css/bookdealpopover.css" rel="stylesheet" type="text/css" />
 
<style>
#OVER{width:100%; height:100%; left:0px;/*IE*/ top:0px; text-align:center; z-index:5; position:fixed; filter:alpha(opacity=20); opacity:0.2; background-color:#fff;}
#overlay {width:40%; height:50%; z-index:6; display:inline; left:30%;/*IE*/ top:30%; font-color:#cdcdcd; font-size:0.8em;
filter:alpha(opacity=100); opacity:1;text-align:center; position:fixed; background-color:#777;}
</style>


<script  language="javascript">


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

</script>

<link rel="stylesheet"  type="text/css" href="tangotab.css"/>
<script>
		!window.jQuery && document.write('<script src="../js/jquery-1.4.3.min.js"><\/script>');
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
	
	shortUrls("<fmt:message key='website.home'></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}&date=${dealInfo.startDate}");
	
	});
		
	</script>
</head>
<body >
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


	

<div id="popupContactdeal">
<span style="float:right;padding-right:10px;">
		<a  id="popupContactClose" href="javascript:close();">x</a>
		</span>
		<div class="title_bar">Enjoy dining out with your TangoTab offer!</div>
        <p>&nbsp;</p>
       
		<p id="contactArea">
			You just fed a person in need, imagine <br/>what your entire network can do!</p>
    <div class="special_icon" style="width:300px; float:none; margin-left:100px;padding-top:30px;">
    <div   style=" float:left; margin-left:10px;">
			  <div >
			  <a onclick="postToFeed(); return false;"  >
			  <img src="../images/facebook_img.png" width="55" height="56" border="0"/></a>
			  </div>

		</div>
       <div    style="float:left; margin-left:10px;">
	     <!--  <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a>-->
	     <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
	      <script>
											  function opentwitter()
{var dealname=escapeSpecial("${dealInfo.dealTemplateName}");
var rname=escapeSpecial("${dealInfo.locationName}");
var location='<fmt:message key='website.home'></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}%26date=${dealInfo.startDate}';
//var link="https://twitter.com/intent/tweet?original_referer="+window.location+"&source=tweetbutton&text=Wow! Check out "+dealname+" at "+rname+" , get yours quickly @TangoTab.  "+location+" %23charity+%23Dallas+%23Dining";
var link="https://twitter.com/intent/tweet?original_referer="+window.location+"&source=tweetbutton&text= I'm fighting hunger with @TangoTab. I fed someone in need just by dining out. "+shortURL+", "+dealname+"";
  
window.open(link,'twi',"height=300,width=400,top=200,left=300,status=no,toolbar=no,menubar=no,location=0,resizable=no,scrollbars=yes",0);
}</script>
       <a href="javascript:opentwitter();" > <img src="../images/twitter_img.png"   width="55" height="56" border="0" /></a>
      </div>
	  <div style="float:left; margin-left:10px;">
                      <a id="friend" href="#" onclick="javascript:shareForward(this.id);"><img src="../images/email_btn.png" width="55" height="56"border="0" /></a>
                      </div>
      <!--  <div>
		<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>
		<script type="IN/Share"  data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>'></script>
	</div> --> 
    	  
  </div>
      
            
	</div>
<div id="backgroundPopupdeal">
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
  	<div class="get_yourdeals">
    		<!--  <div class="get_deals">
    		<img src="../images/get_your_detail.jpg" alt="getyour" /></div>
            	<div class="wasingation">&nbsp;</div>
                	<div class="cheng_city">
                	<div class="city_txt"><%
                	String citiname =request.getParameter("cityName");
                	out.write(citiname);
                	%></div>
                	<div class="refer_deal"><a id="various1" href="#inline1"><b>Change <br/> City</b></a>
                	                	
                	</div>
                	<div class="refer_city"><a href="#" onClick="filtersearch()"><b>Search <br/>filters</b></a>
                    	
                	</div>
                    </div> -->
                    
    </div>
    <div class="special_icon" >
    <div class="facebook_l">
			<div id="facebook_like">
				<fb:like href='http://www.tangotab.com/jsp/index.jsp' show_faces="false" layout="button_count" width="0" colorscheme="light"></fb:like>
	       </div>

		</div>
       <div id="tweet_like_search">
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div>
     <div>
<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>
<script type="IN/Share"  data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>'></script>
</div>  
    	
  
  </div>		
		
 <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  	 
<!-- start  here -->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="font-size:12px; color:#000000;">
            <tr>
              <td width="100%" height="30" colspan="2" align="center"  valign="middle" bgcolor="#FFFFFF" class="gre_medium" ><h1 >Thank You  for Ordering this Offer.</h1></td>
              </tr>
            <tr>
              <td colspan="3" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">
              <table width="50%" align="center" border="0" >
                <tr>
                  <td width="46%"><h2>Your Confirmation Number is:</h2></td>
                  <td width="54%"><%
	BookDealTO to = (BookDealTO) session.getAttribute("book_deal_to");
	if(to != null) {
		if(to.getErrorMessage() != null && to.getErrorMessage().length() > 0) {
			out.write(to.getErrorMessage());
		} else {
			out.write(""+to.getConsumerReservationId());
		}
		session.removeAttribute("book_deal_to");
	}
%></td>
                </tr>
              </table></td>
              </tr>
            <tr>
              <td width="402" align="right" valign="middle" bgcolor="#FFFFFF" class="report_table"></td>
              <td align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">     </td> 
            </tr>
            <tr>
              <td height="25" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF" class="blue_medium">
               <p style="text-align:center; font-style:italic; font-weight:bold;"> This confirmation number and your offer details have been sent to your email account.</td></p>
              </tr>
              <tr>
              <td width="12%" ></td>
                <td width="68%" valign="middle" bgcolor="#FFFFFF"  >
                <table width="100%" align="left" cellpadding="4" >
                  <tr height=23>
                    <td><b>Restaurant Name: </b></td>
                    <td><span class="table_leftmargin">${dealInfo.locationName}</span></td>
                  </tr>
                  <tr height=23>
                    <td><b>Dining Style: </b></td>
                    <td>${dealInfo.diningStyleString}</td>
                  </tr>
                  <tr height=23>
                    <td><b>Cuisine: </b></td>
                    <td>${dealInfo.cuisineTypeString}</td>
                   
                  </tr>
                  <tr height=23>
                    <td><b>Price :</b></td>
                    <td>${dealInfo.price}</td>
                  </tr>
                  <tr height=23>
                    <td><b>Website : </b></td>
                    <td>${dealInfo.website}</td>
                  </tr>
                  <tr height=23>
                    <td><b>Phone Number:</b></td>
                    
                    <td>
                    <!-- ${dealInfo.cellPhone} -->
                    
                    <c:if test="${fn:length(dealInfo.cellPhone) eq 10}"> 
			${fn:substring(dealInfo.cellPhone, 0, 3)}-${fn:substring(dealInfo.cellPhone, 3, 6)}-${fn:substring(dealInfo.cellPhone, 6, 10)}
			</c:if>
			<c:if test="${fn:length(dealInfo.cellPhone) lt 10 or fn:length(dealInfo.cellPhone) gt 10}"> ${dealInfo.cellPhone}
			</c:if></td>
                  </tr>
                  <tr  height=23>
                    <td><b>Address:</b></td>
                    <td>${dealInfo.address}	 
              <c:if test="${not empty dealInfo.address1 }" >
				${dealInfo.address1} <br/>
				</c:if>
				<c:if test="${not empty dealInfo.city }" >
				${dealInfo.city}				</c:if>
				<c:if test="${not empty dealInfo.state }" >
				${dealInfo.state} <br/>
				</c:if>
				<c:if test="${not empty dealInfo.zipcode }" >
				${dealInfo.zipcode} <br/>
				</c:if>				</td>
                  </tr>
                  <tr  height=23>
                    <td><b>Date:</b></td>
                    <td>${dealInfo.startDate}</td>
                  </tr>
                  <tr  height=23>
                    <td><b>Time:</b></td>
                    <td>${dealInfo.availableStartTime} TO ${dealInfo.availableEndTime}</td>
                  </tr>
                  <tr height=23>
                    <td><b>Days:</b></td>
                    <td>${dealInfo.day} </td>
                  </tr>
                 
                  <tr>
                    <td colspan="2"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
				<td width="50%" align="right">
				<div class="special_icon">
																					<div class="facebook_l">
																						 <div id="fpublish_like" style="float:left; ">
					<a onclick='postToFeed(); return false;' title="Facebook Share" id="fPublishLinkID"><img src="../images/fshare.png" width="61" height="20" border="0"/></a>
		</div>
																					</div>
																					<div id="tweet_like_search">
																					
																						<a data-count="none"
																							href="http://twitter.com/share?text=I'm fighting hunger with @TangoTab. I fed someone in need just by dining out. "+shortURL+", "+"${dealInfo.dealTemplateName}"
																							class="twitter-share-button"
																							data-url= shortURL
																							show-url="false">Tweet</a>
																							
																						<script type="text/javascript"
																							src="http://platform.twitter.com/widgets.js"></script>
																					</div>
																					
																				</div>
																			</td>
                  <td width="100" align="center"><div id="select_hot">
				  <a href="#" onClick="javascript:window.print()">Print</a></div></td>
				  
				  
                </tr>
                
              
          </table></td>
                    </tr>
                </table>
                </td>
                <td width="20%" align="center">
                    <script language="JavaScript1.2">

//Presentational Slideshow Script- By Dynamic Drive
//For full source code and more DHTML scripts, visit http://www.dynamicdrive.com
//This credit MUST stay intact for legal use

var slideshow_width='250px' //SET SLIDESHOW WIDTH (set to largest image's width if multiple dimensions exist)
var slideshow_height='190px' //SET SLIDESHOW HEIGHT (set to largest image's height if multiple dimensions exist)
var pause=3000 //SET PAUSE BETWEEN SLIDE (2000=2 seconds)
var slidebgcolor="white"

var dropimages=new Array()
//SET IMAGE PATHS. Extend or contract array as needed
dropimages[0]="../images/imgg1.gif"
dropimages[1]="../images/imgg2.gif"
dropimages[2] = "../images/imgg3.gif"

var droplinks=new Array()
//SET IMAGE URLs. Use "" if you wish particular image to NOT be linked:
droplinks[0]=""
droplinks[1]=""
droplinks[2]=""
droplinks[3]=""
droplinks[4]=""
droplinks[5]=""
droplinks[6]=""


////NO need to edit beyond here/////////////

var preloadedimages=new Array()
for (p=0;p<dropimages.length;p++){
preloadedimages[p]=new Image()
preloadedimages[p].src=dropimages[p]
}

var ie4=document.all
var dom=document.getElementById

if (ie4||dom)
document.write('<div style="position:relative;width:'+slideshow_width+';height:'+slideshow_height+';overflow:hidden"><div id="canvas0" style="position:absolute;width:'+slideshow_width+';height:'+slideshow_height+';background-color:'+slidebgcolor+';left:-'+slideshow_width+'"></div><div id="canvas1" style="position:absolute;width:'+slideshow_width+';height:'+slideshow_height+';background-color:'+slidebgcolor+';left:-'+slideshow_width+'"></div></div>')
else
document.write('<a href="javascript:rotatelink()"><img name="defaultslide" src="'+dropimages[0]+'" border=0></a>')

var curpos=parseInt(slideshow_width)*(-1)
var degree=10
var curcanvas="canvas0"
var curimageindex=linkindex=0
var nextimageindex=1

function movepic(){
if (curpos<0){
curpos=Math.min(curpos+degree,0)
tempobj.style.left=curpos+"px"
}
else{

clearInterval(dropslide)
nextcanvas=(curcanvas=="canvas0")? "canvas0" : "canvas1"
tempobj=ie4? eval("document.all."+nextcanvas) : document.getElementById(nextcanvas)
var slideimage='<img src="'+dropimages[curimageindex]+'" border=0  width=250 height=190>'
tempobj.innerHTML=(droplinks[curimageindex]!="")? '<a href="'+droplinks[curimageindex]+'">'+slideimage+'</a>' : slideimage
nextimageindex=(nextimageindex<dropimages.length-1)? nextimageindex+1 : 0
setTimeout("rotateimage()",pause)
}
}

function rotateimage(){
if (ie4||dom){
resetit(curcanvas)
var crossobj=tempobj=ie4? eval("document.all."+curcanvas) : document.getElementById(curcanvas)
crossobj.style.zIndex++
var temp='setInterval("movepic()",50)'
dropslide=eval(temp)
curcanvas=(curcanvas=="canvas0")? "canvas1" : "canvas0"
}
else
document.images.defaultslide.src=dropimages[curimageindex]
linkindex=curimageindex
curimageindex=(curimageindex<dropimages.length-1)? curimageindex+1 : 0
}

function rotatelink(){
if (droplinks[linkindex]!="")
window.location=droplinks[linkindex]
}

function resetit(what){
curpos=parseInt(slideshow_width)*(-1)
var crossobj=ie4? eval("document.all."+what) : document.getElementById(what)
crossobj.style.left=curpos+"px"
}

function startit(){
var crossobj=ie4? eval("document.all."+curcanvas) : document.getElementById(curcanvas)
crossobj.innerHTML='<a href="'+droplinks[curimageindex]+'"><img src="'+dropimages[curimageindex]+'" border=0></a>'
rotateimage()
}

if (ie4||dom)
window.onload=startit
else
setInterval("rotateimage()",pause)

</script>
                    
                    </td>
                </tr>
              <tr>
              <td align="right" valign="middle" bgcolor="#FFFFFF" class="report_table">&nbsp;</td>
              <td width="566" align="left" valign="middle" bgcolor="#FFFFFF" class="table_leftmargin">&nbsp;</td>
            </tr>
          
            
            
            
            <!--       ${dealInfo.address} ${dealInfo.address1}
                  ${dealInfo.city}
                  ${dealInfo.state}
                  ${dealInfo.zipcode} -->
            
                <tr>
              <td height="46" align="left" valign="middle" bgcolor="#FFFFFF" class="report_table" colspan="3">
               <div class="text_h10">To redeem this offer, present a printed version of this confirmation to the restaurant at the date and time stated above. You will not be able to redeem this offer without this confirmation. You may also show offer confirmation on your SmartPhone TangoTab app.</div>              </td>
            </tr>
      </table>
<!-- End here  -->
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

<div style="clear:both;"></div>
</div>		
<!-- Start fancy box -->

<div style="display:none;">
		<div id="inline1" class="space">
		<table width="98%"  border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td  colspan="2" style="color:#000000; font-weight:bold;">
		<table width:"50%" align="left"><tr><td><h1>Select Your City</h1></td></tr></table>
		
		</td>
	</tr>
	<tr>
		<td width="37%" align="left">&nbsp;</td>
		<td width="63%">&nbsp;</td>
	</tr>
	<tr>
		
		<td align="left" colspan="2">
		
	<table width:"50%" align="center"><tr><td>
			<p><a href="search.do?cityName=Chicago" >Chicago</a><p>
			<p><a href="search.do?cityName=Dallas Fort Worth">Dallas Fort Worth</a></p>
			<p><a href="search.do?cityName=Houston">Houston</a></p>
			<p><a href="search.do?cityName=Lanett">Lanett</a></p>
			<p><a href="search.do?cityName=Los Angeles">Los Angeles</a></p>
			<p><a href="search.do?cityName=New York">New York</a></p>
			<p><a href="search.do?cityName=Westchester">Westchester</a></p>
	
	
	</td></tr>
	</table>
					
		</td>
	</tr>
	
	
</table>
</div></div>
<fmt:setBundle basename="socialintg"></fmt:setBundle>
 <p id='msg' style="display:none;"></p>
<script type="text/javascript">

	var currentURL='<fmt:message key="website.home"></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}';

	 
  function postToFeed() {

        // calling the API ...
        var obj = {
          method: 'feed',
		  link: '<fmt:message key="website.home"></fmt:message>jsp/dealSummary.do?dealId=${dealInfo.dealTemplateId}',
          picture: '<fmt:message key="socialintg.tangotab.image.url"></fmt:message>',
          caption: ' ',
          //description: "I just claimed ${dealInfo.dealTemplateName} at ${dealInfo.locationName}, get yours too @TangoTab. I fed myself and someone in need.  "+currentURL
          description: "I'm fighting hunger with %23TangoTab.I claimed an offer at ${dealInfo.locationName}and fed someone in need just by dining out. ${dealInfo.dealTemplateName}, "+currentURL  
		};

        function callback(response) {
          document.getElementById('msg').innerHTML = "Post ID: " + response['post_id'];
        }

        FB.ui(obj, callback);
      }
	

	 




	//Has Added this new method to replace the Special Charcters - Which will not be allowed by Facebook API.

	function escapeSpecial(text) {

		return text.replace(/[^a-zA-Z 0-9]+/g,'');   

	}

</script>


<!-- End Fancy Box -->
</body>
</html>
  