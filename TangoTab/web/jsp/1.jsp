<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
 <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-us"> 
<head> 
<title>TangoTab</title> 

<script type="text/javascript"><!-- 
/*var mycarousel_itemList ;
Admin.getImages( function(data) {
    	 mycarousel_itemList=data;
function mycarousel_itemLoadCallback(carousel, state){
    for (var i = carousel.first; i <= carousel.last; i++) {
        if (carousel.has(i)) {
            continue;
        }
        if (i > mycarousel_itemList.length) {
            break;
        }
        carousel.add(i, mycarousel_getItemHTML(mycarousel_itemList[i-1]));
    }
};
 

function mycarousel_getItemHTML(item)
{
    return '<a onclick=updateParent("' + item + '") href="#"><img src="' + item + '" width="75" height="80" alt="' + item + '" /></a>';
};
 
jQuery(document).ready(function() {
    jQuery('#mycarousel').jcarousel({
        size: mycarousel_itemList.length,
        itemLoadCallback: {onBeforeAnimation: mycarousel_itemLoadCallback}
    });
});
});*/

function updateParent(imageVale){
	opener.document.getElementById('fileField').value=imageVale;
	window.close();
}
 
--></script> 
</head> 
<body > 
<table width="640">
	<c:if test="${not empty images}">
		<c:forEach var="image" items="${images}" varStatus="count">
			<c:if test="${count.index % 4 eq 0}">
				<tr>
			</c:if>	
				<td align="center" valign="middle">
					<a onclick="updateParent('${image}')" href="#"><img src="${image}" width="150" height="150"/></a>
				 </td>
			<c:if test="${count.index % 4 eq 3}">
				</tr>
			</c:if>	
		</c:forEach>
	</c:if>
	<c:if test="${empty images}">
	NO IMAGES FOUND
	</c:if>
</table> 
</body> 
</html> 