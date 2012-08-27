<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.tangotab.dao.UserDAO" %>
<%@ page import="com.tangotab.dao.pojo.RestaurantLocationPreference" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tangotab.business.UserBO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>

<script type="text/javascript" language="javascript">
function signupa()
{
 window.location='consumer_registration.jsp';
}
</script>

<%  Integer locid = Integer.parseInt(request.getParameter("locid"));
   
    UserBO userdao = com.tangotab.businessImpl.BusinessFactory.getUserBO();
    StringBuffer cuisine= new StringBuffer();
    RestaurantLocationPreference locat = null;
   if(locid > 0 ){
    ArrayList<RestaurantLocationPreference> cuisines = null;
   
    cuisines = (ArrayList<RestaurantLocationPreference>)userdao.getCuisinesByLocationId(locid); 
    if(cuisines.size() > 0 )
       locat = cuisines.get(0);
    for(RestaurantLocationPreference loc:cuisines){
        cuisine.append(loc.getCuisineTypeId().getType()+", ");
       }
    if(cuisine.length()>1){
        cuisine.deleteCharAt(cuisine.length()-1 );
        cuisine.deleteCharAt(cuisine.length()-1 );
      }
    }

    %>
</head>
<body>
 <br/><br/><br/><br/> 
 <form name="display"    method="get" >
 <table width="955" align="center" cellpadding="0" cellspacing="2"  class="deal_dark">
   <tr>
    <td width="195" rowspan="4" align="left" valign="top" class="deal_light">
    <img src="<%=request.getParameter("img")%>" width="190" height="100" /></td>
    <td width="46%" align="left" valign="middle" class="deal_light">
    <table width="590" border="0" align="right" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top">
        <table width="98%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2" align="left" valign="top" class="gre_low">
            <a href="#" class="blue_low">Restaurant Name
              </a></td>
          </tr>
          <tr>
            <td colspan="2" align="left" valign="top" class="gre_low"><%=request.getParameter("loc") %></td>
          </tr>
          <% if(locid > 0){ %>
           <tr>
            <td align="left" class="deal_light">Cuisines:</td>
            <td align="left" class="deal_light"><%= cuisine %></td>
           </tr>
           <tr>
            <td align="left" class="deal_light">Address: </td>
            <td align="left" class="deal_light"><%= locat.getRestaurantLocation().getAddress()%></td>
           </tr>
          <% }%>
          <tr>
            <td align="left" class="deal_light">Rating:</td>
            <td align="left" class="deal_light"><img src="../images/star_rate.png" alt="star" width="65" height="12" /></td>
          </tr>
          
          <!-- <tr>
            <td align="left" class="deal_light">Deal Name: </td>
            <td align="left" class="deal_light"><%=request.getParameter("dealTemplateName") %></td>
          </tr>-->
       
          </table></td>
          
        <td align="left" valign="top">
        <table width="98%" border="0" cellspacing="3" cellpadding="0">
        <% String days = request.getParameter("day");
            String dayss[] = days.split(","); 
            days = "";
            for(int i = 0; i < dayss.length; i++)
            {
             if(dayss[i].equals("1"))
               days = days + "Sun";
             else if(dayss[i].equals("2"))
               days = days + "Mon";
             else if(dayss[i].equals("3"))
               days = days + "Tue";
             else if(dayss[i].equals("4"))
               days = days + "Wed";
             else if(dayss[i].equals("5"))
               days = days + "Thu";
             else if(dayss[i].equals("6"))
               days = days + "Fri";
             else if(dayss[i].equals("7"))
               days = days + "Sat";
             if(i == (dayss.length - 1))
                days = days + ".";
             else
                days = days + ", ";
               
            }
            %>
           <tr>
           
            <td width="240" rowspan="4" align="left" valign="top" class="deal_light">
            <span class="blue_low_u"><%=request.getParameter("dealdesc").replace("!qe!","%").replace("!qs!","#") %></span><br/>
             <span class="text_h9"><%=request.getParameter("dealr") %></span>
              <br/>
			<span>
				<%=request.getParameter("stime") %> - <%=request.getParameter("etime") %><br/>
				<%=request.getParameter("sdate") %> - <%=request.getParameter("edate") %>
				<br/>
				<%=days %>
	        </span>
            </td>
          </tr>
        </table>
        </td>
      </tr>
    </table></td>
    <td width="34%" align="center" valign="top" class="deal_light">
    <table width="161" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="161" height="95" align="center" valign="top" class="get_your_deal"><%= request.getParameter("qty") %> Deals Left<br />
              <br/><img src="../images/getdeal_but.png" border="0" />
          </td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<table width="900" align="left" cellpadding="0" cellspacing="2">
<tr><td align="center" valign="middle" width="300" ></td>
<td align="center" valign="middle" width="300">
				<div id="select_hot">
				<a href="#"  onclick="self.close()">Close</a></div>
</td>
<td align="center" valign="middle" width="300"></td>
</tr>
</table>
</body>
</html>
