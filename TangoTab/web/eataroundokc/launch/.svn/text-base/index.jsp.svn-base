<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<fmt:setBundle basename="tangotab"></fmt:setBundle>

<script type="text/javascript" language="javascript">
	function setCookie(c_name,value,exdays)
	{
	var exdate=new Date();
	exdays = null;
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString())+"; path=/" ;
	document.cookie=c_name + "=" + c_value;
	
	window.location = '<fmt:message key="website.home"></fmt:message>'+'jsp/dealSummary.do?dealId=568&date=06/14/2012';
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
 
</script>
</head>
 
<body onload="setCookie('landing','1058',0);" >

</body>

</html>

	
	
