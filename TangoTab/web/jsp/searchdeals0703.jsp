<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.tangotab.TO.BookDealTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<script  language="javascript">
function signupa()
{
 window.location='consumer_registration.jsp';
}
</script>
</head>
<body>
<div id="wrap">
     <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="SearchDeals" />
		</jsp:include>
<div class="content">
  <div class="insight-content">
  <div class="left_content">
   <html:form action="/jsp/search">
  <div class="g_box"><div class="g_mid">
          <h1>Find A Hot Deal!</h1>
          
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
          
  <tr>
    <td width="180" align="left" valign="middle">Search Deals By City:         </td>
    <td width="40" align="left" valign="middle">&nbsp;</td>
    <td width="220" align="left" valign="middle">Search by Zip:</td>
    <td width="3%" align="left" valign="middle">&nbsp;</td>
    <td width="145" align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="middle"><html:select property="cityName" styleClass="restaurant_select" styleId="cities" >
    		<html:option value="">Select your City </html:option>
    		<bean:define id="relationships4" name="dropDownList" property="cities" type="java.util.ArrayList"/>
    		<html:options collection="relationships4" property="cityName" labelProperty="cityName"/>
    	 </html:select>	</td>
    <td align="center" valign="middle"><h2>OR</h2></td>
    <td align="left" valign="middle"><html:text property="zipCode" /></td>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="left" valign="middle"><label></label></td>
  </tr>
  <tr>
    <td colspan="5">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5" align="left" valign="middle"><table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td width="30%" align="left" valign="middle">category: </td>
        <td width="6" align="left" valign="middle"></td>
        <td width="30%" align="left" valign="middle">Cuisine:</td>
        <td width="6" align="left" valign="middle"></td>
        <td width="34%" align="left" valign="middle">Menu Price:</td>
        <td width="34%" align="left" valign="middle">Rating: </td>
      </tr>
      <tr>
        <td align="left" valign="middle"><html:select property="diningStyle"  styleClass="restaurant_select"  >
                <html:option value="">Select Dining Style</html:option>
                <bean:define id="relationships4" name="dropDownList" property="diningStyles" type="java.util.ArrayList"/>
  				<html:options collection="relationships4" property="diningStyleId" labelProperty="diningStyleName"/>
         </html:select></td>
        <td align="left" valign="middle">&nbsp;</td>
        <td align="left" valign="middle"><html:select property="cuisineType"  styleClass="restaurant_select"  >
                <html:option value="">Select Cuisine</html:option>
                <bean:define id="relationships1" name="dropDownList" property="cusineTypes" type="java.util.ArrayList"/>
  				<html:options collection="relationships1" property="cuisineTypeId" labelProperty="type"/>
         </html:select></td>
        <td align="left" valign="middle">&nbsp;</td>
        <td align="left" valign="middle" style="font:normal 11px Arial, Helvetica, sans-serif; padding-right:15px;">
        <html:select property="priceStartRate"  styleClass="restaurant_select"  >
                <html:option value="">Select Menu Price</html:option>
               <c:forEach var="price" items="${dropDownList.prices}" varStatus="count">
               		<html:option value="${price.startPrice},${price.endPrice}"> $ ${price.startPrice} - $ ${price.endPrice}</html:option>
               </c:forEach>
         </html:select></td>
        <td align="left" valign="middle" style="font:normal 11px Arial, Helvetica, sans-serif; padding-right:15px;">
        <html:select property="rating"  styleClass="restaurant_select"  >
                <html:option value="">Select Rating</html:option>
                <bean:define id="relationships3" name="dropDownList" property="ratings" type="java.util.ArrayList"/>
  				<html:options collection="relationships3" property="restRatingsId" labelProperty="restRatingsId"/>
         </html:select></td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td colspan="5" align="left" valign="middle">&nbsp;</td>
  </tr>
  </table>
<div class="fl_1"><div><table width="606" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right" valign="middle"><html:submit  styleClass="gsubmit_btn"  value="Search"/></td>
  </tr>
</table>
</div></div></div>
</div>
</html:form>
<div class="g_bottom"></div>
  </div>
   <div class="right_content"><jsp:include page="search_right.jsp"></jsp:include>
  </div>
  </div>
  <div style="clear:both;"></div>
</div><!--content  end here--><div style="clear:both;"></div>
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
<div>
  <table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
      <td colspan="3" align="center" valign="top"><table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
           
          <td width="15" height="41"><img src="../images/feature.png" width="15" height="41" /></td>
          <td align="left" valign="middle" bgcolor="#61B9CA" class="white_max1" width="938">Deals</td>
          <td width="15" align="left" valign="top"><img src="../images/feature_right.png" width="15" height="41" /></td>
        </tr>
      </table></td>
      </tr>
    <tr>
<td height="300" colspan="0" align="center" valign="top" class="deal_border">

<table width="955" align="center" cellpadding="0" cellspacing="0">
  <c:if test="${not empty dealsInfo}">
        <c:forEach var="deal" items="${dealsInfo}" varStatus="count">
        <c:if test="${count.index % 2 eq 0}">
   <tr>
      <td width="195" align="left" valign="top" class="deal_light"><img src="../images/cr_1.jpg" width="188" height="96" /></td>
      <td width="46%" align="left" valign="middle" class="deal_light"><table width="590" border="0" align="right" cellpadding="0" cellspacing="0">
        <tr>
          <td width="350" align="left" valign="top"><table width="350" border="0" cellspacing="3" cellpadding="0">
<logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="2">
															<FONT color="red"><bean:write name="message"
																	filter="false" /> </FONT>
														</td>
													</tr>
												</logic:present>
											</html:messages>
			 </logic:messagesPresent>
              <tr>
                <td colspan="2" align="left" valign="top" class="gre_low"><a href="dealSummary.do?dealId=${ deal.dealTemplateId}" class="gre_low">${deal.locationRestName}</a></td>
              </tr>
              <tr>
                <td  width="100" align="left" valign="top" class="bla_low">Cuisine: </td>
                <td  width="250" align="left" valign="top" class="bla_low">${deal.cuisineTypeString }</td>
              </tr>
              <tr>
                <td align="left" valign="top" class="bla_low">Address :</td>
                 <td align="left" valign="top" class="bla_low">${deal.address}</td>
              </tr>
              
              <tr>
                <td align="left" valign="top" class="bla_low">Rating:</td>
                <td align="left" valign="top" class="bla_low"><img src="../images/star_rate.png" alt="star" width="65" height="12" /></td>
              </tr>
          </table></td>
          <td width="240" align="left" valign="top"><a href="dealSummary.do?dealId=${ deal.dealTemplateId}" class="blue_low_u">
            <div class="blue_low_u">${deal.dealTemplateDescription}</div></a><a href="dealSummary.do?dealId=${ deal.dealTemplateId}">
                <span>${deal.dealTemplateRestrictions}</span></a>
                 <br/>
			<span>
				${fn:substring(deal.startDateForSearch, 5, 7)}/${fn:substring(deal.startDateForSearch, 8, 10)}/${fn:substring(deal.startDateForSearch, 0, 4)}
				-
				${fn:substring(deal.dealEndDateForSearch, 5, 7)}/${fn:substring(deal.dealEndDateForSearch, 8, 10)}/${fn:substring(deal.dealEndDateForSearch, 0, 4)}
				<br/>
				${deal.availableStartTime} - ${deal.availableEndTime}<br/>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"1\") >= 0}">
					SUN
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"2\") >= 0}">
					MON
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"3\") >= 0}">
					TUE
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"4\") >= 0}">
					WED
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"5\") >= 0}">
					THU
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"6\") >= 0}">
					FRI
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"7\") >= 0}">
					SAT
				</c:if>
	</span></td>
        </tr>
      </table></td>
     <td width="170" align="left" valign="middle" class="deal_light"> 
     
     <table width="161" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="161" height="95" align="center" valign="top" class="get_your_deal"><a href="dealSummary.do?dealId=${ deal.dealTemplateId}">${deal.remainingDeals} Deals Left</a>
    <br /><br/><a href="dealSummary.do?dealId=${ deal.dealTemplateId}"><img src="../images/getdeal_but.png" border="0"  /></a></td>
  </tr>
  
</table>
  </td>
      </tr>
     </c:if> 

    
    <c:if test="${count.index % 2 ne 0}">
    	   <tr>
      <td width="195" align="left" valign="top" class="deal_dark"><img src="../images/cr_1.jpg" width="188" height="96" /></td>
      <td width="46%" align="left" valign="middle" class="deal_dark"><table width="590" border="0" align="right" cellpadding="0" cellspacing="0">
        <tr>
          <td width="350" align="left" valign="top"><table width="350" border="0" cellspacing="3" cellpadding="0">
<logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="2">
															<FONT color="red"><bean:write name="message"
																	filter="false" /> </FONT>
														</td>
													</tr>
												</logic:present>
											</html:messages>
			 </logic:messagesPresent>
              <tr>
                <td colspan="2" align="left" valign="top" class="gre_low"><a href="dealSummary.do?dealId=${ deal.dealTemplateId}" class="gre_low">${deal.locationRestName}</a></td>
              </tr>
              <tr>
                <td  width="100" align="left" valign="top" class="bla_low">Cuisine:</td>
                <td  width="195" align="left" valign="top" class="bla_low">${deal.cuisineTypeString }</td>
              </tr>
              <tr>
                <td align="left" valign="top" class="bla_low">Address :</td>
                 <td align="left" valign="top" class="bla_low">${deal.address}</td>
              </tr>
              <tr>
                <td align="left" valign="top" class="bla_low">Rating: </td>
                <td align="left" valign="top" class="bla_low"><img src="../images/star_rate.png" alt="star" width="65" height="12" /></td>
              </tr>
          </table></td>
          <td width="240" align="left" valign="top"><a href="dealSummary.do?dealId=${ deal.dealTemplateId}" class="text_h9">
            <div class="blue_low_u">${deal.dealTemplateDescription}</div></a><a href="dealSummary.do?dealId=${ deal.dealTemplateId}">
                <span>${deal.dealTemplateRestrictions}</span></a>
                 <br/>
			<span>
				${fn:substring(deal.startDateForSearch, 5, 7)}/${fn:substring(deal.startDateForSearch, 8, 10)}/${fn:substring(deal.startDateForSearch, 0, 4)}
				-
				${fn:substring(deal.dealEndDateForSearch, 5, 7)}/${fn:substring(deal.dealEndDateForSearch, 8, 10)}/${fn:substring(deal.dealEndDateForSearch, 0, 4)}
				<br/>
				${deal.availableStartTime} - ${deal.availableEndTime}<br/>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"1\") >= 0}">
				SUN
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"2\") >= 0}">
				MON
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"3\") >= 0}">
				TUE
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"4\") >= 0}">
				WED
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"5\") >= 0}">
				THU
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"6\") >= 0}">
				FRI
				</c:if>
				<c:if test="${fn:indexOf(deal.availableWeekDays, \"7\") >= 0}">
				SAT
				</c:if>
	</span></td>
        </tr>
      </table></td>
     <td width="170" align="left" valign="middle" class="deal_dark">
          <table width="161" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="161" height="95" align="center" valign="top" class="get_your_deal"><a href="dealSummary.do?dealId=${ deal.dealTemplateId}">${deal.remainingDeals} Deals Left</a>
    <br /><br/><a href="dealSummary.do?dealId=${ deal.dealTemplateId}"><img src="../images/getdeal_but.png" border="0" /></a></td>
  </tr>
  
</table>
     </td>
      </tr>
    </c:if>
             </c:forEach></c:if>
    
</table>
<br/></td>
</tr>
  </table>
</div>
<%@ include file="footer.jsp"%>
<div style="clear:both;"></div>
</div>
</body>
</html>
