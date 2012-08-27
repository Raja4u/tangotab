<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.tangotab.TO.UserTO"%> 
<%@page import="java.text.NumberFormat,java.text.DecimalFormat"%> 
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.tangotab.TO.BookDealTO" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Dining Offers | TangoTab  ${userInfo.consumerPreferCity.city.cityName}  </title>
<meta content='noindex, nofollow' name='robots' /> <meta content='text/html;charset=utf-8' http-equiv='Content-Type' /> 
<meta content='TangoTab ${userInfo.consumerPreferCity.city.cityName} Deals: TangoTab feeds a person in need every time you dine out with one of our offers. Subscribe for great restaurant deals in Dallas; other cities.' name='description' />

<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<link href="../css/bookdealpopover.css" rel="stylesheet" type="text/css" />

 <script type="text/javascript" src="../js/calendar.js"></script>
<script type="text/javascript" src="../js/calendar-en.js"></script>
<script type="text/javascript" src="../js/calendar-setup.js"></script>
 <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css"/>
<!--
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>-->
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<style>
#OVER{width:100%; height:100%; left:0px;/*IE*/ top:0px; text-align:center; z-index:5; position:fixed; filter:alpha(opacity=20); opacity:0.2; background-color:#fff;}
#overlay {width:40%; height:50%; z-index:6; display:inline; left:38%;/*IE*/ top:30%; font-color:#cdcdcd; font-size:0.8em;
filter:alpha(opacity=100); opacity:1;text-align:center; position:fixed; background-color:#777;}
#popupContactdeal {-webkit-border-radius: 40px;
-moz-border-radius: 40px;
border-radius: 40px; width:330px; height:auto; padding:10px;
border:solid 1px #000;  left:38%; top:30%;valign:middle;

}
#popupContactdeal h2{text-align: center; color: #000; margin-bottom:15px;}
#popupContactdeal p{color: #000; margin-bottom:15px;}
</style>
 <style type="text/css">
.left_blog h2{ color: #F8981D;
    font-size: 15px;
    font-weight: bold;}
	
#date_main{
	margin:0px;
	padding:0px;
	float:left;
	width:180px;
	height:40px;
	}
	
.date_list{
	margin:0px;
	padding:0px;
	float:left;
	list-style-type:none;
	}
	
.date_list ul{
	margin:0px;
	padding:0px;
	float:left;
	list-style-type:none;
	height:37px;
	}
	
.date_list ul li{
	margin:0px 1px 0px 0px ;
	padding:0px;
	float:left;
	list-style-type:none;
	width:21px;
	text-align:center;
	height:37px;
	font-size:12px;
	color:#f8981d;
	font-weight:bold;
	line-height:18px;
	text-decoration:none;
 
	}
	.date_list ul li a{
	margin:0px 1px 0px 0px ;
	padding:0px;
	float:left;
	list-style-type:none;
	width:19px;
	text-align:center;
	height:36px;
	font-size:12px;
color:#f8981d;
	font-weight:bold;
	line-height:18px;
	text-decoration:none;
 
	}
.date_list ul li.org{
	margin:0px 1px 0px 0px ;
	padding:0px;
	float:left;
	list-style-type:none;
	width:21px;
	text-align:center;
	height:37px;
	font-size:12px;
 
	font-weight:bold;
	line-height:18px;
 color:#f8981d;
	text-decoration:none;
	}
	 
	 
.date_list ul li.green{
	margin:0px 1px 0px 0px ;
	padding:0px;
	float:left;
	list-style-type:none;
	width:21px;
	text-align:center;
	height:37px;
	font-size:12px;
	color:#000;
	font-weight:bold;
	line-height:18px;text-decoration:none;
 color:#f8981d;
	}
 </style>
<!--  <script src="../js/jquery-1.js" type="text/javascript"></script> --> 
<script type="text/javascript" > 
function change_date_format(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("from_date_h").value = date_out_put;
	}
</script>


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







function submitfm()
{
   
   
if(document.searchForm.restauntName.value=='Restaurant name')
	document.searchForm.restauntName.value = "";
	
	if(document.searchForm.zipCode.value=='Enter Zip Code')
	   document.searchForm.zipCode.value = "";

       document.searchForm.submit();
  
}

function signupa()
{
 window.location='consumer_registration.jsp';
}

</script>

<script>
		!window.jQuery && document.write('<script src="../js/jquery-1.4.3.min.js"><\/script>');
	</script>


<script type="text/javascript" src="../js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="../js/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript">

/* If the user is signs up it is true for all pages */
var isSignUp=<%=request.getParameter("isSignUp")%>;
	$(document).ready(function() {

			$("#various1").fancybox({
				'titlePosition'		: 'inside',
				'transitionIn'		: 'none',
				'transitionOut'		: 'none'
			});
    if(document.getElementById('dealDate').value.length == 0 || document.searchForm.search.value == 'false')
      setdatevalue();

      /* If the new user signs up */
    if('${isSignUp}'=='true')
    {
    	document.getElementById('popupContactdeal').style.display='block';
		document.getElementById('backgroundPopupdeal').style.display='block';
		/* rounding up the distance */
		var distance = '${dealsInfo[0].distance}';		
		if(document.getElementById('dist1') != null){
			document.getElementById('dist1').innerHTML = Math.round(distance);
		}
		else if(document.getElementById('dist') != null){
			document.getElementById('dist').innerHTML = Math.round(distance);
		}
		isSignUp='true';
	}
	});
	
	function close(){
		document.getElementById('popupContactdeal').style.display='none';
		document.getElementById('backgroundPopupdeal').style.display='none';
	}
	function fancyBox2(id){
		$(id).fancybox().trigger('click');
	}	
		
	</script>




<script type="text/javascript">

       function filtersearch()
       {
         
          var showhidt;
           setCookie("showhidt",showhidt,365);
           document.getElementById('sfilters').style.display='block';
           AutoComplete_Create('restauntName', myCars,10);
          /* if searching without filters then clear filter details */
           if(document.searchForm.search.value == "false"){
            document.searchForm.diningStyle.value = "";
			document.searchForm.cuisineType.value = "";
			document.searchForm.priceStartRate.value = ""
			//document.searchForm.rating.value = "";
			document.searchForm.restaurantLocId.value = "";
			//document.searchForm.restauntName.value = "";
           }
           
           
       }

function seediv()
{
 
	var showhidt = getCookie("showhidt");
     if(showhidt!=null && showhidt!="")
     {
        document.getElementById('sfilters').style.display='block';
     }
      /* if searching without filters then clear filter details */
     if(document.searchForm.search.value == "false"){
            document.searchForm.diningStyle.value = "";
			document.searchForm.cuisineType.value = "";
			document.searchForm.priceStartRate.value = "";
			//document.searchForm.rating.value = "";
			document.searchForm.restaurantLocId.value = "";
			document.searchForm.zipCode.value = "Enter Zip Code";
			document.searchForm.restauntName.value = "Restaurant name";
			setdatevalue();
           }
        
          
}

function setdatevalue(){

	var startingDateone = new Date();
	var onlyDateone = startingDateone.getDate()*1;
	if(onlyDateone < 10 )
	   onlyDateone = '0' + onlyDateone;
	var onlyMonthone = startingDateone.getMonth()*1+1;
	if(onlyMonthone < 10 )
	   onlyMonthone = '0' + onlyMonthone;
		
	var stDateone = onlyMonthone+'/'+onlyDateone+'/'+startingDateone.getFullYear();
	document.getElementById('dealDate').value = stDateone;
		
    
      }
</script>
<script  type="text/javascript">
function submit(id){
//alert(document.searchForm.search.value);
if(document.searchForm.search.value == "true")
{
//document.searchForm.cityName.value = document.frm.cityName.value;
//document.searchForm.zipCode.value = document.frm.zipCode.value;
document.searchForm.diningStyle.value = document.getElementById("diningStyleh").value;
document.searchForm.cuisineType.value = document.getElementById("cuisineTypeh").value;
document.searchForm.priceStartRate.value = document.getElementById("priceStartRateh").value;
document.searchForm.restaurantLocId.value = document.getElementById("restaurantLocIdh").value;

document.searchForm.restauntName.value = document.getElementById("restauntNameh").value;
//document.searchForm.rating.value = document.getElementById("ratingh").value;
document.searchForm.action = "search.do?page="+id;
}
else{
		document.searchForm.action = "searchForward.do?page="+id+"&isSignUp="+isSignUp;
 }
 
 document.searchForm.submit();

}

function clearfilters(bool){

    var submit =  new Boolean(bool);
   
	var startingDate = new Date();
	var onlyDate = startingDate.getDate()*1;
	if(onlyDate < 10 )
	   onlyDate = '0' + onlyDate;
	 
	var onlyMonth = startingDate.getMonth()*1+1;
	if(onlyMonth < 10 )
	   onlyMonth = '0' + onlyMonth;
	   	   
	var stDate = onlyMonth+'/'+onlyDate+'/'+startingDate.getFullYear();
	//document.getElementById('dealDate').value = stDate;	
	
			document.searchForm.diningStyle.value = "";
			document.searchForm.cuisineType.value = "";
			document.searchForm.priceStartRate.value = "";
			//document.searchForm.rating.value = "";
			document.searchForm.restaurantLocId.value = "";
			document.searchForm.restauntName.value = "Restaurant name";
			document.searchForm.dealDate.value = stDate;
			document.searchForm.zipCode.value = "Enter Zip Code";
		   if(submit == true){
		  		  document.searchForm.submit();
		      }
		     
}

function submitCity(citys){
document.searchForm.cityName.value = citys;
document.searchForm.submit();
}
function displayCommingSoon(){
	$(document).ready(function() {
        $("#various1").fancybox().trigger('click');
    });
}
</script>
	<style>
.go_img{
	width:54px;
	height:28px;
	border:none;
	cursor:pointer;
	color:#232222;
	text-align:center;
	background: url(../images/go.png);
	background-repeat: no-repeat;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	vertical-align: middle;
}
</style>
<link rel="stylesheet" href="../css/AutoComplete.css" media="screen" type="text/css" />
    <script language="javascript" type="text/javascript" src="../js/autocomplete.js"></script>
</head>
<body onload="seediv();"> 
<div id="landingImage" >
<c:if test="${imagePath ne null and  imagePath ne ''}"> <img src='${imagePath}'/> </c:if>
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
    		<div class="get_deals">
    		<c:if test="${not empty searchForm.cityName }">
    		<img src="../images/youare_searching.jpg" alt="getyour" />
    		</c:if>
    		<c:if test="${empty searchForm.cityName }">
    		<img src="../images/selectyourcity.jpg" alt="getyour" />
    		</c:if></div>
            	<div class="wasingation"><input type="hidden" name="emailId" value="<% request.getParameter("emailId"); %>" ></div>
            	 
                	<div class="cheng_city">
                	<div class="city_txt"><%
                	//String citiname =request.getParameter("cityName");
                	// out.write(citiname);
                	%>
                	${searchForm.cityName }</div>
                	<div class="refer_deal" onclick="clearfilters(0);"><a id="various1" href="#inline1"><b>Change<br/> City</b></a>
                	
                	
                	</div>
                	
                	<!--  <div class="refer_city"><a href="#" onclick="filtersearch()"><b>Search <br/>filters</b></a>
                    	
                	</div>-->
                    </div>
                        

                            





                    
    </div>
 
    <div class="special_icon">
	<div class="facebook_l">
			<div id="facebook_like">
				<fb:like href='<fmt:message key="facebook.frontpage.url"></fmt:message>' show_faces="false" layout="button_count" width="" colorscheme="light"></fb:like>
	</div>

		</div>
       <div id="tweet_like_search">  
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.searchpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
	
</div>
     <div><script src="http://platform.linkedin.com/in.js"  type="text/javascript"></script>
<script type="IN/Share" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>'></script>
</div>  
    
    	<!--<div class="first_specail"><a href="#"><img src="../images/specal_icon.jpg" alt="1" border="0" /></a><a href="#"><img src="../images/specal_icon1.jpg" border="0" /></a></div>
         	<div class="first_specail" style="padding:0 20px 0 20px;"><a href="#"><img src="../images/like.jpg" alt="1" border="0" /></a><a href="#"><img src="../images/118.jpg" border="0" /></a></div>
             	<div class="first_specail" style="float:right"><a href="#"><img src="../images/twiiter.jpg" alt="1" border="0" /></a><a href="#"><img src="../images/32.jpg" border="0" /></a></div>-->
    </div>
  
  </div>

                   

<div class="list_box_effect" id="sfilters" style="display:block;">



<html:form action="/jsp/search">
                       	
                       	<div>
                       	<!--  <input type="hidden" name="cityName" value="
                       	// " />
                        -->
                        <html:hidden property="cityName" value="${searchForm.cityName}"/>	 
                      </div>
                       	    <div class="list_top_item">
         <html:hidden property="restaurantLocId" />
              <!-- 
            <c:forEach var="rest" items="${dropDownList.restaurants}" varStatus="count">
             
              			 <c:set property="cityNa" var="cityNa" value="rest1"></c:set>
              				<input id="rest1" type="hidden" value="${rest.locationRestName }" name="rest1" />
              			 
              				
               </c:forEach>-->
                 <c:forEach var="rest" items="${dropDownList.restaurants}" varStatus="count">
             <c:if test="${not empty searchForm.cityName}">
              		<input id="${rest.cityId}" type="hidden" value="${rest.locationRestName }" name="${rest.cityId}" />
              		<c:set property="cityNa" var="cityNa" value="${searchForm.cityName}"></c:set>
              			</c:if>
              			 <c:if test="${ empty searchForm.cityName}">
              			 <c:set property="cityNa" var="cityNa" value="rest1"></c:set>
              				<input id="rest1" type="hidden" value="${rest.locationRestName }" name="rest1" />
              				</c:if>
              				
               </c:forEach>
            
        
<html:text property="restauntName"  styleId="restauntName" onfocus="removeText(this)" value="Restaurant name"/>

<c:if test="${not empty searchForm.restauntName }">
<script>document.searchForm.restauntName.value = "${searchForm.restauntName }";</script>
</c:if>
   <script language="javascript" type="text/javascript">
// alert(document.getElementsByName("rest").value);


function removeText(id)
{
if(id.value=='Restaurant name')
document.searchForm.restauntName.value = "";

if(id.value=='Enter Zip Code')
id.value = "";
}
 var myCars=new Array();
 var a=document.getElementsByName("${cityNa}");
 //alert(a.length);
 //alert(a[].value)
                                    
 
 var data1='';
  for(var i=0;i<a.length;i++)
  {
  myCars[i]=a[i].value;
  }
 
    data = ['george@example.com',
            'beatrix@example.com',
            'karen@example.com',
            'fred@example.com',
            'richard@example.com',
            'john@example.com',
            'joe@example.com'].sort();

    AutoComplete_Create('restauntName', myCars,10);
   // AutoComplete_Create('color', ['red', 'orange', 'green', 'black', 'pink', 'grey', 'mauve', 'turquoise', 'blue', 'purple'].sort(), 6);
 // -->
</script>


           
         </div>
         
         <div class="list_top_item">
        
          <html:text   property="dealDate" styleId="dealDate"   readonly="true"  onchange="change_date_format(this.value); "/>
        
        <!--    <c:if test="${ empty searchForm.dealDate }">
          <html:text   property="dealDate" styleId="dealDate" value="Enter Date empty" readonly="true" onchange="change_date_format(this.value); "/>
          </c:if>-->
          <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />
		 </div>
                    <div class="list_top_item">
                    <html:select property="diningStyle"  styleClass="restaurant_select" >
                <html:option value="">Select Dining Style</html:option>
                <bean:define id="relationships4" name="dropDownList" property="diningStyles" type="java.util.ArrayList"/>
  				<html:options collection="relationships4" property="diningStyleId" labelProperty="diningStyleName"/>
         </html:select>
         </div>
         
                    <div class="list_top_item">
                    <html:select property="cuisineType"  styleClass="restaurant_select" >
                <html:option value="">Select Cuisine</html:option>
                <bean:define id="relationships1" name="dropDownList" property="cusineTypes" type="java.util.ArrayList"/>
  				<html:options collection="relationships1" property="cuisineTypeId" labelProperty="type"/>
         </html:select>
         </div>
       
       <div class="list_box_effect" id="sfilters2" style="display:block;float:right;">
                  <div class="list_top_item">
                     <c:if test="${not empty searchForm.zipCode}">
                     <html:text property="zipCode" styleId="zipCode"  value="${searchForm.zipCode}" styleClass="restaurant_select" maxlength="7" onfocus="removeText(this)" />
                    </c:if>
                    <c:if test="${empty searchForm.zipCode}">
                    <html:text property="zipCode" value="Enter Zip Code" styleId="zipCode"  styleClass="restaurant_select" maxlength="7" onfocus="removeText(this)"  />
                   
                    </c:if>
                    </div>
                    <div class="list_top_item">
                     <html:select property="priceStartRate"  styleClass="restaurant_select"  >
                <html:option value="">Select Menu Price</html:option>
               <c:forEach var="price" items="${dropDownList.prices}" varStatus="count">
               		<html:option value="${price.startPrice},${price.endPrice}"> $ ${price.startPrice} - $ ${price.endPrice}</html:option>
               </c:forEach>
         </html:select> 
         
     <input type="submit"  value="" onclick="submitfm()"  class="go_img" />
          <!--    <img align="top"   onclick="submitfm();"  src="../images/go.png" height="28" />  -->
         <img  align="top"   onclick="clearfilters(1);"  src="../images/clear_button.png" />    
         </div>
         </div>
         
                    <!-- <div class="list_top_item">
                    <html:select property="rating"  styleClass="restaurant_select" onchange="submitfm()">
                <html:option value="">Select Rating</html:option>
                <html:option value="1">1 Star</html:option>
                <html:option value="2">2 Star</html:option>
                <html:option value="3">3 Star</html:option>
                <html:option value="4">4 Star</html:option>
                <html:option value="5">5 Star</html:option>
         </html:select></div> -->
         
    <!--  <div style="float: left; color:green;font-family: verdana;font: bold;font-size:12px; font-style: italic" ><b>Enter restaurant name and click on GO</b></div>
         -->   
            <input type="hidden" name="search" Id="hsearch" value="${searchForm.search}" />	
         	<input type="hidden" name="hcity" value="${searchForm.cityName}"/>								
			<input type="hidden" name="num" value="${num}"/>
                    
           </html:form>
     


</div>






 <script language="JavaScript1.2">
Calendar.setup({
        inputField     :    "dealDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    true,              // will display a time selector
        button         :    "date_dtp1",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right",             // alignment (defaults to "Bl")
        weekNumbers    : true,
         dateStatusFunc :   dateStatus
                
    });
    
    function dateStatus(date) {
            
            var startDate = new Date();
            var endDate = new Date();
            startDate.setHours(0);
            startDate.setMinutes(0);
            startDate.setSeconds(0);
            startDate.setMilliseconds(0);
            
               //        startDate.setDate(startDate.getDate()-1); 
            for(var i=0; i< 30; i++){
              endDate.setDate(endDate.getDate()+1);
            }
                  
            if (date >= startDate && date < endDate) {
          
                  return false;
            } else  {
      
                  return true;
            }
      }       
	
    
</script>

 

<div class="inner_cantainer">
  <div class="left_blog">
  
<input type="hidden" id="diningStyleh" name="diningStyle" value="${searchto.diningStyle}"/>
<input type="hidden" id="cuisineTypeh" name="cuisineType" value="${searchto.cuisineType}"/>
<input type="hidden" id="priceStartRateh" name="priceStartRate" value="${searchto.priceStartRate}"/>
<!--  <input type="hidden" id="ratingh" name="rating" value="${searchto.rating}"/>-->
<input type="hidden" id="restaurantLocIdh" name="restaurantLocId" value="${searchto.restaurantLocId}"/>
<input type="hidden" id="restauntNameh" name="restauntNameh" value="${searchto.restauntName}"/>
   <logic:messagesPresent message="true">
		<html:messages id="message" message="true">
			<logic:present name="message">
				<div class="nodeals"> 
																			
				<FONT color="red">
					<!-- <c:if test="${empty searchForm.cityName and empty searchForm.restauntName}" >
                        	<bean:write name="message" filter="false" />
                        </c:if>
                        <c:if test="${not empty searchForm.cityName and empty searchForm.restauntName}" >
                        <b>We're expanding</b>. Deals in your city are coming up soon.
                        </c:if>
                        <c:if test="${not empty searchForm.restauntName}" >
                         Sorry, the restaurant you're looking for doesn't currently have any offers.  Check back soon for new offers as they change by the minute!
                       </c:if>   -->	
                     No offers were found.  Please  <a href="suggest_restaurant.jsp"  class="text_search" >tell</a> us if we are missing something great. 

				</FONT>
				</div>
																		
			</logic:present>
		</html:messages>
	</logic:messagesPresent>

<table border="0" width="720" align="center" cellpadding="0" cellspacing="0">
<tr>
<td   align="right" colspan="4" valign="middle" class="blue_medium">

                        <c:if test="${not empty dealsInfo}">
                        <%@ include file="pagination.jsp" %></c:if>
                        
                       </td>
</tr>
</table>
                     															
<c:if test="${not empty dealsInfo}">

                <c:set var="cdate" value=""></c:set>
 
 				
  
        <c:forEach var="deal" items="${dealsInfo}" varStatus="count">
        
        <c:forEach var="dealweek" items="${deal.weakDate}" varStatus="test">
				      
				  
				      <c:if test="${ not empty dealweek.dayName and  dealweek.dayName  eq 'Ok' }"  >
				   <c:set var="cdate" value="${dealweek.availableDates}"></c:set>
				             
				       </c:if>
				        <c:if test="${not   empty dealweek.dayName  and  dealweek.dayName  eq 'Yes'  }"  >
				 
				     
				      <!--  <c:if test="${ empty dealweek.date}"  >
				         <li class="green"><a href=#">
				        ${dealweek.dayLetter}</a>
				      </li>
				        </c:if> -->
				          <c:if test="${ not empty dealweek.date}"  >
				          <c:set var="cdate" value="${dealweek.availableDates}"></c:set>
				        </c:if>
				        
				       </c:if>
				   
				      </c:forEach>
				      
    <c:if test="${ ( deal.distance lt 25 ) or ( empty isSignUp ) }">    	
        														
 	<div class="first_blog" style="padding:15px 0 0px 0;">
 	 
 	
 	<div class="left_img">
 <c:choose> 
  	<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > 
  	 <a href="#">${deal.remainingDeals} Left&nbsp;&nbsp;&nbsp;</a>
  	</c:when>
 	<c:when test="${deal.remainingDeals eq 0}" > 
 	 <a href="#">${deal.remainingDeals} Left&nbsp;&nbsp;&nbsp;</a>
 	</c:when>
 	<c:when test="${deal.remainingDeals gt 0}" >
 	<a href="dealSummary.do?dealId=${ deal.dealTemplateId}&date=${cdate}">${deal.remainingDeals} Left&nbsp;&nbsp;&nbsp;</a>
 	</c:when>
 </c:choose>
 	<!-- <img src="images/left-top.jpg" alt="Left top" /> -->
 	
 	</div>
 	<div class="right_content_box">
 	<div class="img_boxcontent"><img src="${deal.restDealImagePath}" width="190" height="130" /></div>
 	<div class="blog_content">
 	 <h1> 
 	 <c:choose> 
			 
			<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > <h1>${deal.locationRestName}</h1> </c:when> 
			<c:when test="${deal.remainingDeals eq 0}" ><h1>${deal.locationRestName}</h1> </c:when> 
			<c:when test="${deal.remainingDeals gt 0}" > 
			<a href="dealSummary.do?dealId=${deal.dealTemplateId}&date=${cdate}" class="gre_low"><h1>${deal.locationRestName}</h1></a></c:when> 
			
			</c:choose>  
 	  
 	 </h1>
   <!--  <img src="../images/star_rate.png" alt="star" width="65" height="12" />--> 
 	 
 	 	<c:choose> 
			
			<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" >
			  <h2> ${deal.dealTemplateName}</h2>
                  <p> ${deal.dealTemplateDescription}</p> </c:when> 
			<c:when test="${deal.remainingDeals eq 0}" >
			 
	<h2>${deal.dealTemplateName}</h2>
                  <p>${deal.dealTemplateDescription}</p></c:when> 
<c:when test="${deal.remainingDeals gt 0}" >
<a href="dealSummary.do?dealId=${ deal.dealTemplateId}&date=${cdate}">
<h2>${deal.dealTemplateName}</h2></a>
           		 <a href="dealSummary.do?dealId=${ deal.dealTemplateId}&date=${cdate}" style="text-decoration:none;">
                <p>${deal.dealTemplateDescription}</p></a>
				<--(${searchForm.zipCode})(${deal.distance})-->
                </c:when> 
			
			</c:choose>  
		
    
 	</div>
 	
 	<div class="gets_yours_now">
 	
 	<!--<c:choose> 
			
			<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > ${deal.locationRestName} </c:when> 
			<c:when test="${deal.remainingDeals eq 0}" >${deal.locationRestName} </c:when> 
			<c:when test="${deal.remainingDeals gt 0}" > 
			<a href="dealSummary.do?dealId=${deal.dealTemplateId}" class="gre_low">${deal.locationRestName}</a></c:when> 
			
			</c:choose> -->
			   
			
			<h3>	<div style="float:none; padding-top:25px; padding-bottom:56px;">
 	${deal.availableStartTime} - ${deal.availableEndTime}<br/>
		 
			 
				 <div id="date_main" style="margin-left:10px;">

  <div class="date_list" style="margin-left:10px;"> <ul>

				      <c:forEach var="dealweek" items="${deal.weakDate}" varStatus="test">
				      
				  
				      <c:if test="${ not empty dealweek.dayName and  dealweek.dayName  eq 'Ok' }"  >
				   <c:set var="cdate" value="${dealweek.availableDates}"></c:set>
				             <li class="green">
								<c:choose>
											<c:when	test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}">
												<a href="#">${dealweek.dayLetter}</a>
											</c:when>
											<c:when test="${deal.remainingDeals eq 0}">
												<a href="#">${dealweek.dayLetter}</a>
											</c:when>
											<c:when test="${deal.remainingDeals gt 0}">
												<a href="javascript:sendDeal('${deal.dealTemplateId}','${dealweek.availableDates}');">${dealweek.dayLetter}</a>
											</c:when>
								</c:choose>
								
				             </li>
				       </c:if>
				        <c:if test="${not   empty dealweek.dayName  and  dealweek.dayName  eq 'Yes'  }"  >
				 
				     
				      <!--  <c:if test="${ empty dealweek.date}"  >
				         <li class="green"><a href=#">
				        ${dealweek.dayLetter}</a>
				      </li>
				        </c:if> -->
				          <c:if test="${ not empty dealweek.date}"  >
				          <li class="org"><a href="javascript:sendDeal('${deal.dealTemplateId}','${dealweek.availableDates}');">${dealweek.dayLetter} </a></li>
				        </c:if>
				        
				       </c:if>
				   
				      </c:forEach>
				    </ul>
				       </div></div>
 	</div></h3>
 	
 	
 	<c:choose> 
  <c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > 
    <div><img src="../images/sold.png" />   </div>	
    				
  </c:when> 
  	    <c:when test="${deal.remainingDeals eq 0}" > 
    <img src="../images/sold.png" /> 
  </c:when> 
  <c:when test="${deal.remainingDeals gt 0}" > 
    
   
   <!-- // <%
                	//String citiname =request.getParameter("cityName");
                	//out.write(citiname);
                	%> -->
            	
    <!-- 
    <a href="dealSummary.do?dealId=${ deal.dealTemplateId}&cityName=${searchForm.cityName }"><img src="../images/get_yous_now.jpg" border="0" /></a>
	  -->
	 <a href="javascript:sendDeal('${deal.dealTemplateId}','${cdate}');"> <img src="../images/see_details.png" border="0" width="125" height="34" /></a>
  </c:when>  
</c:choose>
 	
 	
 	
 	
 	</div>
 	
 	</div>
 
</div></c:if>
    </c:forEach>
    </c:if>
    
<table border="0" width="720" align="center" cellpadding="0" cellspacing="0">
 <tr>
  <td  align="right" colspan="4" valign="middle" class="blue_medium">
 	<c:if test="${not empty dealsInfo}">
                        <%@ include file="pagination.jsp" %></c:if>
                        </td></tr></table>
 	</div>
<div class="cant_right-inner">
   <!-- <div class="tango_app"><a href="mobileapps.jsp">
  <img src="../images/arrow.png" alt="arrow" width="35" height="45" border="0" align="left" /><img src="../images/mobile1.jpg" border="0" align="right" />
    <p><font style="font-family: bradley Hand ITC;font: bolder;font-weight:bolder;font-size: 20px;">Get The TangoTab app</font> to receive real time deals and much more</p>
     <img src="../images/gettheapp.png" width="185" height="67" border="0"></a></div>-->
<!--   <div class="face_book">
  
  	<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) {return;}
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div class="fb-activity" data-site="www.tangotab.com" data-width="246" data-height="290" data-header="true" data-recommendations="false"></div>
		

  </div>
  <a href="http://www.adaywithoutfood.com" target="_blank" style="margin-left:9px; "><img src="../images/DWH.jpg" border="0" /></a>-->
  <div class="addvertise">
    <!-- <font style="font-family: bradley Hand ITC;font: bolder;font-weight:bolder;font-size: 20px;color:#e46c0e;">
						Together...<br/> we can make a difference<br></font> -->

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



</div>
  <div class="addvertise">&nbsp;</div>
  </div>

 
    </div>
     <div class="footer_inner" >
  <div class="nav_footer">   <%@ include file="footer.jsp"%>
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
		
		<td  colspan="4" style="color:#000000; font-weight:bold;padding-bottom:10px;padding-top:10px;">
		<table width="100%" align="left"><tr><td align="left"><h1 align="left">Select Your City</h1><br /></td></tr></table>
		
		<br /></td>
	</tr>
	<tr>
		<td width="37%" align="left">&nbsp;<br /></td>
		<td width="63%">&nbsp;<br /></td>
	</tr>
	<tr>
		
		<td align="left" colspan="4" style="padding-left:60px;">
		
	<table width="100%" align="center"  ><tr><td>
	
	
   	<c:forEach var="dList2" items="${dropDownList.cities}"  varStatus="status">
  
    <p><a href="javascript:submitCity('${dList2.cityName}');" > ${dList2.cityName} </a> <p>
    <c:if test="${(status.index+1) %4 eq 0 and status.index gt 0}">
     		</td><td valign="top">
    </c:if>
 
    </c:forEach>
			<!-- 
			<p><a href="search.do?cityName=Dallas Fort Worth">Dallas Fort Worth</a></p>
			<p><a href="search.do?cityName=Houston">Houston</a></p>
			<p><a href="search.do?cityName=Lanett">Lanett</a></p>
			<p><a href="search.do?cityName=Los Angeles">Los Angeles</a></p>
			<p><a href="search.do?cityName=New York">New York</a></p>
			<p><a href="search.do?cityName=Westchester">Westchester</a></p>
	
	 -->
	</td></tr>
	</table>
					
		</td>
	</tr>
	
	
</table>
</div></div>



		
		
	<c:if test="${dealsInfo[0].distance lt 25.5}">
	<div id="popupContactdeal" style="display:none;text-align: left;">
	<span style="position: absolute;    right: -30px;    top: -11px;padding-right:5px;vertical-align:top;">
		<a  id="popupContactClose" href="javascript:close();"><img src="../images/close_popup.png" border="0" /></a>
		</span>
	    <div style="font-size: 22px; color: #f57e20; font-weight: bold; font-family:arial; text-align: center;">Welcome to TangoTab </div>
		<p style="font-size: 17px;text-align: center;padding-top:16px;">You have offers nearby in:</p>
		<center><table style="background: #d9d9d9;  -webkit-border-radius: 8px; -moz-border-radius: 8px; border:solid 1px #000; padding:5px;
border-radius: 8px;width: 80%;text-align: center"><tr><td>${dealsInfo[0].CITY_NAME}<br /></td><td ><span id="dist"></span> mi.<br /></td></tr> </table></center>
		<p style="font-size: 17px;text-align: center;padding-top:16px;">Find your favorite restaurants and come back often as we add more restaurants.</p>
		<div style="align:center;padding-left:42px;" ><img src="../images/whenueat_theyeat.png" border="0"  ></img></div>
	</div>
	</c:if>
	
	
	<c:if test="${dealsInfo[0].distance ge 25.5}">
	<div id="popupContactdeal" style="display:none;text-align: left;width:260px;">
	<span style="position: absolute;    right: -30px;    top: -11px;padding-right:5px;vertical-align:top;">
		<a  id="popupContactClose" href="javascript:close();"><img src="../images/close_popup.png" border="0" /></a>
		</span>
	    <div style="font-size: 22px; color: #f57e20; font-weight: bold; font-family:arial; text-align: center;">We're Coming Soon </div><br/>
		<p style="font-size: 17px;padding-bottom:12px;">We're not in your city yet.&nbsp;&nbsp;The closest TangoTab city is:</p>
		<center><table style="background: #d9d9d9;  -webkit-border-radius: 8px; -moz-border-radius: 8px; border:solid 1px #000; padding:5px;
border-radius: 8px;width: 260px;text-align: center"><tr><td>${dealsInfo[0].CITY_NAME}<br /></td><td ><span id="dist1"></span> mi.<br /></td></tr> </table></center><br/>
		<p style="font-size: 17px;">We will let you know when we come to your city.</p>
		<center><a href="javascript:close();"  onclick="fancyBox2('#various1');"><img src="../images/current_cities.png" border="0"></img></a></center>
		</div>
	</c:if>
	
	<c:if test="${empty dealsInfo}">
	<div id="popupContactdeal" style="display:none;text-align: left;">
	<span style="position: absolute;    right: -30px;    top: -11px;padding-right:5px;vertical-align:top;">
		<a  id="popupContactClose" href="javascript:close();"><img src="../images/close_popup.png" border="0" /></a>
		</span>
		<div style="font-size: 22px; color: #f57e20; font-weight: bold; font-family:arial; text-align: center;">We're Coming Soon </div><br/>
		<p style="font-size: 17px;">Thank you for signing up for TangoTab.  We're not in your city yet, but we'll let you know when we come, and in the meantime you've been entered into our monthly drawings.</p><br/>
		<p style="font-size: 17px;"><b>Demand that TangoTab comes to your city sooner</b>.  Tell your friends.  The more that sign up, the faster we'll get there.</p>
		<center><a href="javascript:close();"  onclick="fancyBox2('#various1');"><img src="../images/current_cities.png"></img></a></center>
		</div>
	</c:if>
	

<div id="backgroundPopupdeal"  style="display:none;">
	  </div>  


<!-- End Fancy Box -->


 <form name="sendDeal" method="post">
 <input type="hidden" name="dealId"/>
 <input type="hidden" name="date"/>
  <input type="hidden" name="cityName" value="${searchForm.cityName}"/>
 
 </form>
 </body>

<script language="javascript">
var OSName="Unknown OS";
if (navigator.appVersion.indexOf("Win")!=-1) OSName="Windows";
if (navigator.appVersion.indexOf("Mac")!=-1) OSName="MacOS";
if (navigator.appVersion.indexOf("X11")!=-1) OSName="UNIX";
if (navigator.appVersion.indexOf("Linux")!=-1) OSName="Linux";
 var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-32748288-1']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
 _setCustomVar('1', 'dealName', dealId, '1');
 _trackEvent('OfferDescription', dealId, 'clicked', dealId, 'true');
function sendDeal(dealId,date)
{
   
 _gaq.push(['_trackEvent', 'Details', 'clicked', dealId]);
 _gaq.push(['_setCustomVar', '1', 'clicked', 'clicked', '3']);
 _gaq.push(['_setCustomVar',1,'OS',OSName,2]);  
_gaq.push(['_trackPageview']);
document.sendDeal.dealId.value=dealId;
document.sendDeal.date.value=date;
document.sendDeal.action="dealSummary.do?dealId="+dealId+"&date="+date;
document.sendDeal.submit();
}
</script> 
</html>
<% if(session.getAttribute("imagePath")!=null)
{
session.removeAttribute("imagePath");
} 
 if(session.getAttribute("isSignUp")!=null)
{
session.removeAttribute("isSignUp");
}%>
