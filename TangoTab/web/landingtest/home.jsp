
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

<title>TangoTab</title> 

<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.js" type="text/javascript"></script>
<script src="../js/jquery_003.js" type="text/javascript"></script>
<script src="../js/jquery_002.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/geolocator.js" type="text/javascript" charset="utf-8"></script>


<!-- 

<script src="../js/coda-slider.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
 -->
<!-- <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" /> -->





</head> 

<body  onload="setCookie('landing','1023',0);">
<div id="wrapper">
  <div id="main">
	 <jsp:include page="../jsp/landheader.jsp">
			<jsp:param name="currentPage" value="" />
		</jsp:include> 
		
		<!--Header End here-->
	
	
		
		
<div class="cantainerland"   >
   <div class="main_cantainer">
       <div class="main_positon">
           
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="554" align="center" valign="top" background="images/original_bg.jpg"><table width="1010" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="445" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="right" valign="bottom">&nbsp;</td>
                        <td align="center" valign="top"><table width="90%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="60">&nbsp;</td>
                          </tr>
                          <tr>
                            <td align="right" valign="top"><a href="../jsp/consumer_registration.jsp"><img src="../images/signup_new.png" width="202" height="76" border="0" /></a></td>
                          </tr>
                          <tr>
                            <td align="right" valign="top">&nbsp;</td>
                          </tr>
                          <tr>
                            <td align="right" valign="top"><a href="http://itunes.apple.com/ca/app/tango-tab/id449163047?mt=8"><img src="../images/apps_store.png" width="195" height="66" border="0" /></a></td>
                          </tr>
                          <tr>
                            <td height="80" align="right" valign="bottom">&nbsp;</td>
                          </tr>
                          <tr>
                            <td height="150" align="right" valign="bottom"><img src="../images/bg_join.png" width="428" height="168" border="0" usemap="#Map" /></td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                    </tr>
                  
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>




<map name="Map" id="Map">
<area shape="rect" coords="333,20,395,60" href="../jsp/consumer_registration.jsp" />
<area shape="rect" coords="-2,91,140,129" href="http://www.tangotab.com/jsp/search.do" />
</map>

    
        	<div class="footer_inner_home3">
        	<%@ include file="../jsp/slidefooter.jsp"%>
        	</div>
        </div>
            
    </div>           
 
</div>

</div>      
</div>

</body>
</html>
