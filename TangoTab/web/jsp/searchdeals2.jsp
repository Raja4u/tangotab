<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title> TangoTab </title>
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
 
 <script type="text/javascript" src="../js/calendar.js"></script>
<script type="text/javascript" src="../js/calendar-en.js"></script>
<script type="text/javascript" src="../js/calendar-setup.js"></script>
 <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css"/>
<!--
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>-->
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
 
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

		$(document).ready(function() {

			$("#various1").fancybox({
				'titlePosition'		: 'inside',
				'transitionIn'		: 'none',
				'transitionOut'		: 'none'
			});


		});
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

	var showhidt = getCookie("showhidt")
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
			document.searchForm.restauntName.value = "";
			
           }
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
 document.searchForm.action = "searchForward.do?page="+id;
 }
 
 document.searchForm.submit();

}

</script>
	<style>
.go_img{
	width:106px;
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
<%

	String emailvar = request.getParameter("emailId");
	String ecitilvar = request.getParameter("cityName");
	
	

%>
<%
if(emailvar != null)
{
%>

	<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="" />
		</jsp:include> 
		
		<!--Header End here-->
		<div class="cantainer">
		
	 <div class="cantainer">
        <div class="main_cantainer">
    <div class="main_positon">
    	<div class="form_bg">
        <div class="form_left">
         <img src="../images/signup.png" />        </div>
        	
		
		 <div class="form_right">		
		 
		 




<%}
else
{
%>


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
                	<div class="refer_deal"><a id="various1" href="#inline1"><b>Change<br/> City</b></a>
                	
                	
                	</div>
                	
                	<div class="refer_city"><a href="#" onclick="filtersearch()"><b>Search <br/>filters</b></a>
                    	
                	</div>
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

                   

<div class="list_box_effect" id="sfilters" style="display:none;">



<html:form action="/jsp/search">
                       	
                       	<div>
                       	<!--  <input type="hidden" name="cityName" value="
                       	// " />
                        -->
                        <html:hidden property="cityName" value="${searchForm.cityName}"/>	 
                      </div>
                       	    <div class="list_top_item">${dropDownList.restaurants}
         <html:hidden property="restaurantLocId" />
              <!-- <html:select property="restaurantLocId"  styleClass="restaurant_select" onchange="submitfm()">
                <html:option value="">Select Restaurant</html:option>
               <c:forEach var="rest" items="${dropDownList.restaurants}" varStatus="count">
               		<html:option value="${rest.restLocationId}"> ${rest.locationRestName }</html:option>
               </c:forEach>
           </html:select>   -->
            <c:forEach var="rest" items="${dropDownList.restaurants}" varStatus="count">
             <c:if test="${not empty searchForm.cityName}">
              		<input id="${rest.city.cityName}" type="hidden" value="${rest.locationRestName }" name="${rest.city.cityName}" />
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
         <c:if test="${not empty searchForm.dealDate }">
          <html:text   property="dealDate" styleId="dealDate"  readonly="true" onchange="change_date_format(this.value); "/>
          </c:if>
           <c:if test="${ empty searchForm.dealDate }">
          <html:text   property="dealDate" styleId="dealDate" value="Enter Date" readonly="true" onchange="change_date_format(this.value); "/>
          </c:if>
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
         
                    <div class="list_top_item">
                     <html:select property="priceStartRate"  styleClass="restaurant_select"  >
                <html:option value="">Select Menu Price</html:option>
               <c:forEach var="price" items="${dropDownList.prices}" varStatus="count">
               		<html:option value="${price.startPrice},${price.endPrice}"> $ ${price.startPrice} - $ ${price.endPrice}</html:option>
               </c:forEach>
         </html:select> 
         
         <!-- <input type="submit"  value="" onclick="submitfm()"  class="go_img" /> -->
         <img align="top"   onclick="submitfm()"  src="../images/go.png" height="28" />   
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







		 	
	
<%} %>
<%


	BookDealTO to = (BookDealTO) session.getAttribute("book_deal_to");
	if(to != null) {
		if(to.getErrorMessage() != null && to.getErrorMessage().length() > 0) {
			out.write(to.getErrorMessage());
		} else {
			out.write("Your deal confirmation code is: " + to.getConsumerReservationId());
		}
		session.removeAttribute("book_deal_to");
	}
%>

<%
if(emailvar != null)
{
%>
<p><input type="hidden" name="emailId" value="<% request.getParameter("emailId"); %>" ></p>
<%}
else
{
%>


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
						<c:if test="${empty searchForm.cityName and empty searchForm.restauntName}" >
                        	<bean:write name="message" filter="false" />
                        </c:if>
                        <c:if test="${not empty searchForm.cityName and empty searchForm.restauntName}" >
                        <b>We're expanding</b>. Deals in your city are coming up soon.
                        </c:if>
                        <c:if test="${not empty searchForm.restauntName}" >
                         Sorry, the restaurant you're looking for doesn't currently have any offers.  Check back soon for new offers as they change by the minute!
                       </c:if>  

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
        <c:forEach var="deal" items="${dealsInfo}" varStatus="count">
        	
        														
 	<div class="first_blog" style="padding:15px 0 0px 0;">
 	<% String leftclassv = "left_img"; %>
 	<c:choose> 
 	<c:when test="${deal.remainingDeals eq 0}" > 
    <%  leftclassv = "left_img_red";%>
  	</c:when>
  	
  
  <c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > 
    <%  leftclassv = "left_img_red";%>
    				
  </c:when> 
  
  
  <c:when test="${deal.remainingDeals gt 0}" > 
    
    <%  leftclassv = "left_img"; %>
	 
  </c:when> 
  	</c:choose> 
 	
 	<div class=" <% out.write(leftclassv); %>">
 	
 	<a href="dealSummary.do?dealId=${ deal.dealTemplateId}">${deal.remainingDeals} Left</a>
 	
 	<!-- <img src="images/left-top.jpg" alt="Left top" /> -->
 	
 	</div>
 	<div class="right_content_box">
 	<div class="img_boxcontent"><img src="${deal.restDealImagePath}" width="190" height="130" /></div>
 	<div class="blog_content">
 	 <h1> 
 	 <c:choose> 
			 
			<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > ${deal.locationRestName} </c:when> 
			<c:when test="${deal.remainingDeals eq 0}" >${deal.locationRestName} </c:when> 
			<c:when test="${deal.remainingDeals gt 0}" > 
			<a href="dealSummary.do?dealId=${deal.dealTemplateId}" class="gre_low">${deal.locationRestName}</a></c:when> 
			
			</c:choose>  
 	  
 	 </h1>
   <!--  <img src="../images/star_rate.png" alt="star" width="65" height="12" />--> 
 	 
 	 	<c:choose> 
			
			<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" >
			  <p> ${deal.dealTemplateName}</p>
                  <p> ${deal.dealTemplateDescription}</p> </c:when> 
			<c:when test="${deal.remainingDeals eq 0}" >
			 
	<p style="font-size:15px; font-weight:bold;">${deal.dealTemplateName}</p>
                  <p>${deal.dealTemplateDescription}</p></c:when> 
<c:when test="${deal.remainingDeals gt 0}" >
<a href="dealSummary.do?dealId=${ deal.dealTemplateId}">
<p style="font-size:15px; font-weight:bold;">${deal.dealTemplateName}</p></a>
           		 <a href="dealSummary.do?dealId=${ deal.dealTemplateId}" style="text-decoration:none;">
                <p>${deal.dealTemplateDescription}</p></a>
                </c:when> 
			
			</c:choose>  
		
    
 	</div>
 	
 	<div class="gets_yours_now"><h1><c:choose> 
			
			<c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > ${deal.locationRestName} </c:when> 
			<c:when test="${deal.remainingDeals eq 0}" >${deal.locationRestName} </c:when> 
			<c:when test="${deal.remainingDeals gt 0}" > 
			<a href="dealSummary.do?dealId=${deal.dealTemplateId}" class="gre_low">${deal.locationRestName}</a></c:when> 
			
			</c:choose> 
			   
			</h1>
			<h3>	<div style="float:left">
 	${deal.availableStartTime} - ${deal.availableEndTime}<br/>
		 
			 
				 <div id="date_main">

  <div class="date_list"> <ul>
  <c:set var="cdate" value=""></c:set>
				      <c:forEach var="dealweek" items="${deal.weakDate}" varStatus="test">
				      
				  
				      <c:if test="${ not empty dealweek.dayName and  dealweek.dayName  eq 'Ok' }"  >
				   <c:set var="cdate" value="${dealweek.availableDates}"></c:set>
				             <li class="green">
				             <a href="javascript:sendDeal('${deal.dealTemplateId}','${dealweek.availableDates}');">
				             ${dealweek.dayLetter} ${dealweek.dateOfDate } </a></li>
				       </c:if>
				        <c:if test="${not   empty dealweek.dayName  and  dealweek.dayName  eq 'Yes'  }"  >
				 
				     
				      <!--  <c:if test="${ empty dealweek.date}"  >
				         <li class="green"><a href=#">
				        ${dealweek.dayLetter}</a>
				      </li>
				        </c:if> -->
				          <c:if test="${ not empty dealweek.date}"  >
				          <li class="org"><a href="javascript:sendDeal('${deal.dealTemplateId}','${dealweek.availableDates}');">${dealweek.dayLetter} ${dealweek.dateOfDate } </a></li>
				        </c:if>
				        
				       </c:if>
				   
				      </c:forEach>
				    </ul>
				       </div></div>
 	</div></h3>
 	
 	
 	<c:choose> 
  <c:when test="${(deal.currentCredits lt maxdebit) and (deal.billingMethodId eq 1)}" > 
    <div><img src="../images/soldout.png"/>   </div>	
    				
  </c:when> 
  	    <c:when test="${deal.remainingDeals eq 0}" > 
    <img src="../images/soldout.png"/> 
  </c:when> 
  <c:when test="${deal.remainingDeals gt 0}" > 
    
    <h2 style="padding: 5px;">
   <!-- // <%
                	//String citiname =request.getParameter("cityName");
                	//out.write(citiname);
                	%> -->
            </h2>    	
    <!-- 
    <a href="dealSummary.do?dealId=${ deal.dealTemplateId}&cityName=${searchForm.cityName }"><img src="../images/get_yous_now.jpg" border="0" /></a>
	  -->
	 <a href="javascript:sendDeal('${deal.dealTemplateId}','${cdate}');"> <img src="../images/get_yous_now.jpg" border="0" /></a>
  </c:when>  
</c:choose>
 	
 	
 	
 	
 	</div>
 	
 	</div>
 
</div>
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
  <div class="tango_app"><a href="mobileapps.jsp">
  <!--  <img src="../images/arrow.png" alt="arrow" width="35" height="45" border="0" align="left" /><img src="../images/mobile1.jpg" border="0" align="right" />
    <p><font style="font-family: bradley Hand ITC;font: bolder;font-weight:bolder;font-size: 20px;">Get The TangoTab app</font> to receive real time deals and much more</p>
    --><img src="../images/gettheapp.png" width="185" height="67" border="0"></a></div>
  <div class="face_book">
  
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


 
 
 
 
 
<%} %>
<%
if(emailvar != null)
{
%>

<form name="frm" method="post" >
 <c:if test="${not empty dealsInfo }" >

   <h1>Wecome to TangoTab Home of Hot Deals</h1>
   <h2>You will start receiving your emails with hot restaurant deals soon</h2>
   <div class="refer"><a href="Friendforward.do"><img src="../images/refer_friend.jpg" border="0"></a> </div>
   <p> Personalize your deals & password</p>
   <div class="refer"><a href="consumer_registration.jsp"><img src="../images/complete_your.jpg" border="0"></a> </div>
   <%
                	String citiname = request.getParameter("cityName");
                	%>
   <div class="refer"><a href="search.do?cityName=${searchForm.cityName }"><img src="../images/search_hot_deals.jpg" border="0"></a> </div>
 </c:if>
  
<c:if test="${ empty dealsInfo}">
   
   <h1>We're expanding. Deals in your city are coming up 
soon</h1>

<p>There are no deals in your city as of yet . We will notify 
you as soon as have hot deals from cool restaurants in your area.</p> 
<p>Have friends who want deals</p>
<div class="refer"><a href="Friendforward.do"><img src="../images/refer_friend.jpg" border="0"></a></div>
<div class="refer"><a href="searchForward.do"><img src="../images/browse_around.jpg" border="0"></a></div>
 </c:if>
</form>

        </div>
        </div>
        
        <div class="copyrigth">
        <div class="twiietr_bg">  
       <div class="facebook_l">
			<div id="facebook_like">
				<fb:like href='<fmt:message key="facebook.frontpage.url"></fmt:message>' show_faces="false" layout="button_count" width="0" colorscheme="light"></fb:like>
	</div>

		</div>
       <div id="tweet_like_search">
	 <a href="http://twitter.com/share" class="twitter-share-button" data-url='<fmt:message key="twitter.frontpage.url"></fmt:message>' data-text="<fmt:message key="twitter.frontpage.text"></fmt:message>" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</div>

<div>
<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>
<script type="IN/Share"></script>
</div>
</div>
        </div>
        </div></div>
        <div class="footer_inner_home">
        <%@ include file="slidefooter.jsp"%></div>
    </div>      
      
 </div>  
</div>
</div> 
<%}
else
{

%>
 <div class="footer_inner">
  <div class="nav_footer">   <%@ include file="footer.jsp"%>
  </div>  
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
		<table width:"50%" align="left"><tr><td><h1>Select Your City</h1><br /></td></tr></table>
		
		<br /></td>
	</tr>
	<tr>
		<td width="37%" align="left">&nbsp;<br /></td>
		<td width="63%">&nbsp;<br /></td>
	</tr>
	<tr>
		
		<td align="left" colspan="2">
		
	<table width:"50%" align="center"  ><tr><td>
	
	
   	<c:forEach var="dList2" items="${dropDownList.cities}"  varStatus="status">
  
    <p><a href="search.do?cityName=${dList2.cityName}" > ${dList2.cityName} </a> &nbsp; &nbsp; &nbsp;<p>
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


<!-- End Fancy Box -->



<%} %>

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

 <form name="sendDeal" method="post">
 <input type="hidden" name="dealId"/>
 <input type="hidden" name="date"/>
  <input type="hidden" name="cityName" value="${searchForm.cityName}"/>
 
 </form>
 </body>
<style type="text/css">

#date_main{
	margin:0px;
	padding:5px;
	float:left;
	width:140px;
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
<script language="javascript">
function sendDeal(dealId,date)
{
 
document.sendDeal.dealId.value=dealId;
document.sendDeal.date.value=date;
document.sendDeal.action="dealSummary.do";
document.sendDeal.submit();
}
</script>
</html>
