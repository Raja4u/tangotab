<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle> 
 
<script type="text/javascript">
		checkUserAgent();
function checkUserAgent(){
var ua = navigator.userAgent;

var checker = {
  iphone: ua.match(/(iPhone|iPod|iPad)/),
  blackberry: ua.match(/BlackBerry/),
  android: ua.match(/Android/)  
};
 if(ua.indexOf('iPhone') != -1 || ua.indexOf('iPod') != -1 
	|| ua.indexOf('BlackBerry') != -1 || ua.indexOf('Android') != -1 || ua.indexOf('RIM') != -1)
	{
 
   window.location='<fmt:message key="website.home"></fmt:message>mobile'+'${errorPath}';
  // document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }else 
   window.location="<fmt:message key='website.home'></fmt:message>jsp/";
   


}

</script>
