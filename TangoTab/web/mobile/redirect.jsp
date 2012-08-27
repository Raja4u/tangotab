<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String dev = (String)request.getAttribute("device");
if( dev != null && dev.length() > 0 )
    response.sendRedirect("http://itunes.apple.com/us/app/tango-tab/id449163047?mt=8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>TangoTab</title> 

	<script type="text/javascript">
function display(){
var ua = navigator.userAgent;

var checker = {
  iphone: ua.match(/(iPhone|iPod|iPad)/),
  blackberry: ua.match(/BlackBerry/),
  android: ua.match(/Android/)  
};

 if(ua.indexOf('NT') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=1024, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='web';
   }else  if(ua.indexOf('iPhone') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='iPhone';
   }else  if(ua.indexOf('iPod') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='iPod';
   }else  if(ua.indexOf('iPad') != -1){
   document.getElementById('device').value='iPad';
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=768, initial-scale=1, maximum-scale=1">';
   }else  if(ua.indexOf('Android') != -1){
 document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   document.getElementById('device').value='Android';
   }else 
   {
   document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }
   //alert(document.getElementById('device').value);

}

</script>
<span id="metatag"></span>
	</head>
	
	<body onLoad="display()">
 

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top" scope="row" class="mainbox"><table width="320" height="480" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center" valign="top" scope="row"> 
          <table width="100%"  align="center" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="center" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="center" valign="top" class="mainbox" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="center" valign="top" scope="row"><img src="images/logo.png" alt="Tangotab" class="padding1" /></td>
                        </tr>
                        <tr>
                          <td height="65" align="center" valign="top" scope="row"></td>
                        </tr>
                        
                        <tr>
                          <td height="10" align="center" valign="top" class="" scope="row"><a href="#"><img src="images/thankyou_img.png" alt="img" width="243" height="158" border="0" /></a></td>
                        </tr>
                        
                        
                        <tr>
                          <td height="30" align="center" valign="top" class="" scope="row"></td>
                        </tr>
                    </table></td>
                  </tr>
                </table>
                 
              </td>
            </tr>
          </table></td>
      </tr>
    </table></td>
  </tr>
</table>
   
  </body>
</html>
