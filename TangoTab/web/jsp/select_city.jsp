<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />

<script src="../js/jquery-1.js" type="text/javascript"></script> 
<script  language="javascript">


function submit()
{
   
       document.frm.submit();
  
}

function signupa()
{
 window.location='consumer_registration.jsp';
}
</script>
</head>
<body>
<%

	String emailvar = request.getParameter("emailId");
	String ecitilvar = request.getParameter("cityName");
	

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
 <p>&nbsp;</p>
 
 
 <c:if test="${not empty dealsInfo }" >
 <h1>SELECT Your City</h1>
   <html:form action="/jsp/search">
                	<html:select property="cityName" styleClass="restaurant_select" styleId="cities" onchange="submit()">
    		<html:option value="">Select City</html:option>
    		<bean:define id="relationships4" name="dropDownList" property="cities" type="java.util.ArrayList"/>
    		<html:options collection="relationships4" property="cityName" labelProperty="cityName"/>
    	 </html:select>
    	 </html:form>
 </c:if>
  
<c:if test="${ empty dealsInfo}">
   
   <h1>SELECT Your City</h1>
   <html:form action="/jsp/search">
                	<html:select property="cityName" styleClass="restaurant_select" styleId="cities" onchange="submit()">
    		<html:option value="">Select City</html:option>
    		<bean:define id="relationships4" name="dropDownList" property="cities" type="java.util.ArrayList"/>
    		<html:options collection="relationships4" property="cityName" labelProperty="cityName"/>
    	 </html:select>
    	 </html:form>
 </c:if>


        </div>
        </div>
        
        <div class="copyrigth">
        <div class="twiietr_bg"><a href="#"><img src="../images/like.jpg" border="0" /></a><a href="#"><img src="../images/118.jpg" border="0" /></a><span style="padding:0 0 0 22px"><a href="#"><img src="../images/twiiter.jpg" border="0" /></a><a href="#"><img src="../images/32.jpg" border="0" /></a></span></div>
        </div>
        </div></div>
        <div class="footer_inner_home">
        <%@ include file="footer.jsp"%></div>
    </div>      
      
 </div>  
</div>
</div> 

</body>
</html>        
         
         
         
        	