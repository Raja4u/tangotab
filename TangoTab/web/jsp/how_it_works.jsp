<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
<script  language="javascript">

function delete_cookie ( cookie_name )
{
  var cookie_date = new Date ( );  // current date & time
  cookie_date.setTime ( cookie_date.getTime() - 1 );
  document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
}




</script>
</head>

<body >
	
	<div id="wrapper">
	<div id="main">
		<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Learn More" />
		</jsp:include> 
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
  <div class="main_deal">
  
  <div class="top_header">
  <img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  
  
  
   <table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top" ><img src="../images/search_feed.png" width="674" height="180" border="0" usemap="#Map" /></td>
      </tr>
      <tr>
        <td><p ><font style="font-family:Dakota Regular;font-size:28px;color:#000;font:bold;font-weight:bold;">How to Tango!</font></p>
        <p><b>Search</b> &nbsp;  [surch]&nbsp;  - &nbsp;<b>verb</b> <br />visit our webpage or mobile app to find local restaurant offers that change throughout the day</p><br />
        <p><b>Tango tab</b> &nbsp;  [<b>tang</b>-goh <b>&nbsp;tab</b>] &nbsp; - <b>verb</b> <br />visit our webpage or mobile app to find local restaurant offers that change throughout the day</p><br />
         <p><b>Feed</b>&nbsp; [Feed] &nbsp;- &nbsp;<b>verb</b> <br />'When you eat... they eat.'&nbsp; Feed someone hungry every time you claim an offer</p><br />
         <p><b>Share</b>&nbsp; [shair] &nbsp;-&nbsp; <b>verb</b> <br />feed more people by inviting your friends to participate - your network can feed a village</p> <br /> <br />

 </td>
      </tr>

    </table></td>
  </tr>
</table>

<map name="Map" id="Map"><area shape="rect" coords="19,31,129,95" href="search.do" />
<area shape="rect" coords="329,39,439,105" href="charity.jsp" />
<area shape="rect" coords="507,30,610,92" href="Friendforward.do" /></map>
 </div>


</div>

            </div>
            
            
            <div class="top_bottom">
            <img src="../images/corner_bottom_left.jpg" align="left" />
            <img src="../images/corner_bottom_right.jpg" align="right" />
            </div>
<!--footer start here-->

				<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>
<!--  </div>		       
</div>   -->   

</body>
</html>