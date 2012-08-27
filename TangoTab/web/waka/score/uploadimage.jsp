<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="com.tangotab.geo.GeoLocationUtility"%>  
<%@page import="com.tangotab.TO.UserTO"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@page import="com.tangotab.business.UserBO"%>
<%@page import="com.tangotab.businessImpl.UserBOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tangotab.TO.DealTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="TangoTab" />
<meta property="og:type" content="restaurant" />
<meta property="og:image" content='<fmt:message key="socialintg.tangotab.image.url"></fmt:message>' />
<meta property="og:site_name" content="TangoTab" />
<meta property="fb:admins" content='<fmt:message key="facebook.appid"></fmt:message>' />
<meta property="og:description"
          content="<fmt:message key='facebook.frontpage.text'></fmt:message>"/>

<title> TangoTab </title> 

<link href="http://184.173.113.66/css/restyle.css" rel="stylesheet" type="text/css" />

<script src="http://184.173.113.66/js/jquery-1.js" type="text/javascript"></script>
<script src="http://184.173.113.66/js/jquery_003.js" type="text/javascript"></script>
<script src="http://184.173.113.66/js/jquery_002.js" type="text/javascript" charset="utf-8"></script>
<script src="http://184.173.113.66/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="http://184.173.113.66/js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script src="http://184.173.113.66/js/geolocator.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		//alert(${after});
		//checkUserAgent();
		<% String image=(String)request.getAttribute("uploaded"); %>
//alert(window.location);
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
 
    //$(".cantainer3").css("background","none");
    //window.location="/mobile${after}";
  // document.getElementById("metatag").innerHTML='<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=1">';
   }


}
function Checkfiles() {
     alert('');
		var fup = document.getElementById('Images');
		var fileName = fup.value;
		alert(fup);
		alert(fileName);
		var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		
		
		if (ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg"
				|| ext == "jpg" || ext == "JPG" || ext == "doc"|| ext == "png" ) {
			
			return true;
		} else {
		document.getElementById("error").innerHTML="Upload .gif/.jpeg/.png images only";
			fup.value="";
			fup.focus();
			return false;
		}
		
	}
<%if (image==null)
    image="";
   else
  image=image;%>

</script>



<style>
		body{
	margin:0px;
	padding:0px;
	font:normal 12px "Century Gothic", Arial, Helvetica, sans-serif;
	color:#ffffff;
	background-repeat: no-repeat;
}
		p,table,td,tr,ul,li,ol,h1,h2,h3,h4,h5,h6,form{ margin:0px; padding:0px;}
		a{ outline:none;}

		.normalwht 	{ font-family:Arial, Helvetica, sans-serif; color:#fff; font-size:12px;  }
		.normalwht2 	{ font-family:Arial, Helvetica, sans-serif; color:#fff; font-size:12px; text-decoration:underline;  }


.text_box{
margin:0px;
padding:4px;
font-size:13px;
width:230px;
height:16px;
border:1px solid #a2abae;
}
.red_max_home {
	font-family: "Century Gothic", Arial, Helvetica, sans-serif;
	font-size: 40px;
	font-style: normal;
	color: #e46c0e;
	text-decoration: none;
	font-weight: 600;
	text-align:center;
	

}

#password-clear {
	    display: none;
	    color:#aaa;
}	
input.placeholder{
color:#aaa;
}
#Layer2 {
      position: relative ; 
      left:0px;
      top:20px;
      width:335px;
      height:102px;
      z-index:5;
}

    </style>

<!-- 

<script src="http://184.173.113.66/js/coda-slider.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="http://184.173.113.66/js/scroll.js"></script>
<script type="text/javascript" src="http://184.173.113.66/js/scrollend.js"></script>
 -->
<!-- <link href="http://184.173.113.66/css/scrollcolor.css" rel="stylesheet" type="text/css" /> -->

<fmt:setBundle basename="tangotab"></fmt:setBundle>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/Countries.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/engine.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/util.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/fingerPrint.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/deal.js'></script>
<script type='text/javascript' src='<fmt:message key="dwr.url"></fmt:message>/dwr/interface/DealDescr.js'></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
 <script type="text/javascript">
 
    function showImages(){
                 if(document.getElementById("Images").value=="" && document.getElementById("Images").value==""){
				document.getElementById("error").innerHTML=" Please Upload Image";
				//alert("please select image");
				 return false;
				}
			else{
	    var fup = document.getElementById('Images');
		var fileName = fup.value;
		//alert(fup);
		//alert(fileName);
		var ext = fileName.substring(fileName.lastIndexOf('.') + 1);		
		
		if (ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg"
				|| ext == "jpg" || ext == "JPG" || ext == "png" ) {
			
			return true;
		} else {
		    document.getElementById("error").innerHTML=" Upload .gif/.jpeg/.png images only";
			fup.value="";
			fup.focus();
			return false;
		   }
		
	      return true;			
         }
         }

</script>

  
</head> 
 
<body height="400px">

 

	<body  >

		<div id="wrapper">
		<div id="main">
	 <jsp:include page="../../jsp/index_header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal" >
  
  <div class="top_header" ><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 
  	 
  	 
  	 
  	 
  	 <!-- start login -->
  	 <div class="content_deal_inner">
  	 <div class="login_page_main">	
  	  
    
       
      <html:form  action="/jsp/upload" enctype="multipart/form-data" onsubmit="return showImages();"> 
      <table width="900" border="0" cellspacing="0" cellpadding="0" align="center"   >
      <tr>
          <td colspan="2" align="center" style="margin-left:50px;height:80px;" class="red_max" ><center><B>WAKA SCORE IMAGE</B></center></td>
      </tr>
      <tr>
          <td colspan="2" align="center">&nbsp; </td>
      </tr>
       <tr ><td colspan="2" align="center"><strong class="red_text"><%=image%></strong></td></tr>
       <tr>
           <td align="right" valign="top" style="color: #000; padding-top: 3px;" width="500"><strong ><br/>Please select the image:&nbsp;&nbsp;</strong></td>
          
          <td align="left" valign="top" class="text_h9" width="500"><br/>
 	        <html:file  styleId="Images" property="wakaImages"/>
 	     <span style="color:red;" id="error" ></span>
 	     
             
          </td>
          
     </tr>
     <tr>
          <td colspan="2" align="center">&nbsp; </td>
     </tr>
     <tr>
     
          <td colspan="2" align="center">
   <html:submit property="submit"   styleClass="but_img">Upload</html:submit>
          <br/></td>
     </tr>
</table>

</html:form>
  </div>

</div>
    
        	<div class="footer_inner_home3">
        	<%@include file="../../jsp/slidefooter.jsp" %>
        	</div>
        </div>
            
    </div>           
 
</div>

 

</body>
</html>
