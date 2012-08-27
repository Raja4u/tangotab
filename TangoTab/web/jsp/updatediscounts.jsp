
<%@page import="com.tangotab.util.DateConverterUtility"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page import="java.util.List"%>
<%@page import="com.tangotab.web.form.RestaurantDiscountForm"%>
<%@page import="com.tangotab.businessImpl.BusinessFactory"%>
<%@page import="com.tangotab.business.RestaurantDiscountBO"%>
<%@page import="com.tangotab.dao.pojo.RestaurantDiscount"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
</head>

<body>
<div id="wrapper">
	<div id="main">
<!--Header Start-->
 	<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		</jsp:include>
	 
 
 <div class="cantainer_inner">
			<div class="main_cantainer">
				<div class="cantainer_content">

					<div class="inner_cantainer">
						<div class="main_deal">

							<div class="top_header">
								<img src="../images/corner_left.jpg" align="left" />
								<img src="../images/corner_right.jpg" align="right" />
							</div>

							<div class="content_deal_inner">
    <table width="968" border="0" cellspacing="0" cellpadding="0">
         <%@ include file="admin_banner.jsp" %>
       
      <tr>
        <td height="6" colspan="3" align="left" valign="top"></td>
      </tr>
      <tr>
        <td height="17" colspan="3" align="center" valign="top"><!-- form Start-->
        <html:form action="/jsp/creditdiscountdisplay" method="POST">
            <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="center" valign="middle" class="red_max">Update Discount</td>
                  </tr>
                  <tr>
                    <td align="center" valign="top" class="red_max"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                   <!--      <tr>
                          <td width="480" align="right" valign="middle">&nbsp;</td>
                          <td align="right" valign="middle" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;</td>
                        </tr> -->
                    </table></td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top" width="100%"  class="blue_medium"  ><br/>
             <%
             	int i=0;
             	int locationId=1;
             	if(request.getParameter("locid")!=null)
             	locationId=Integer.parseInt(request.getParameter("locid")); 
             	RestaurantDiscountBO discountBO= BusinessFactory.getRestaurantDiscountBO();
             	 List<RestaurantDiscount> list=null;
             	 RestaurantDiscount  discount=new RestaurantDiscount();
            
             	if(request.getAttribute("restDiscList")==null)
             	{
             	list=discountBO.getRestauantDiscountByLocation(locationId);
             	request.setAttribute("restDiscList",list);
             	}else 
             	list=(List)request.getAttribute("restDiscList");     	
             	
             
             int id=0;
             int isactive=0;
             String style="";
             %>         
<display:table style="background-color:#cccccc;width:98%"  id="creditD" requestURI="/jsp/creditdiscountdisplay.do?operation=display" name="restDiscList" pagesize="10" cellpadding="2" cellspacing="2"  >
			 <% i++;
			 style="table_light";
			 if(i%2==0)
			  style="table_dark";
			  if(list.size()>0)
			  {
			  	discount=(RestaurantDiscount)list.get(i-1);
			  	isactive=discount.getIsActive();
			  	}
			 %>
			
			 <display:column headerClass="text_h3" class="<%=style%>" style="width:5%;"  title="Sl.No" ><%=i%>
			
			 </display:column>
		  	<display:column headerClass="text_h3" class="<%=style%>"   title="Reffered By" paramId="1"  property="referredBy">
		  	
		  	 <a href='creditdiscountdisplay.do?operation=insert&id=<bean:write name="creditD" property="restDiscountId" />'>
		  	 <bean:write name="creditD" property="referredBy"/></a>&nbsp;&nbsp;</display:column>
	  	<display:column headerClass="text_h3" class="<%=style%>"  title="Discount" property="discountAmount" >
		  	 </display:column>
	  	<display:column headerClass="text_h3" class="<%=style%>"  title="From Date" >

	<% out.print(DateConverterUtility.convertDBTimeStampToUiDate(discount.getStartDate()));   %>		  	 </display:column>
	
		  	<display:column headerClass="text_h3" class="<%=style%>"  title="To Date"   >
		  <% out.print(DateConverterUtility.convertDBTimeStampToUiDate(discount.getEndDate()));  %>
		  	 </display:column>
	<display:column headerClass="text_h3" class="<%=style%>"   title="Status"  >
	  <html:hidden property="restDiscountId" value="<%=Integer.toString(discount.getRestDiscountId()) %>" />
	<html:select property="isActive" value="<%=Integer.toString(isactive) %>">
	<html:option value="1" >Active</html:option>
	<html:option value="0"  >Pending</html:option>
	<html:option value="2"   >Suspend</html:option>
	</html:select> 
                                 
 </display:column>
 
	
		</display:table> 
		
                    <!--      <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Business Name</td>
                            <td align="center" valign="middle" class="text_h3">Discount</td>
                            <td align="center" valign="middle" class="text_h3">From Date</td>
                            <td align="center" valign="middle" class="text_h3">To Date</td>
                            <td align="left" valign="middle" class="">&nbsp;&nbsp;&nbsp;Status</td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_light">IPL</td>
                            <td align="left" valign="middle" class="table_light">15</td>
                            <td align="left" valign="middle" class="table_light">06/02/2011</td>
                            <td align="left" valign="middle" class="table_light">08/02/2011</td>
                            <td align="left" valign="middle" class="table_light"><select name="select2" class="restaurant_selectmedium" id="select2">
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Suspended</option>
                              </select>
                            </td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_dark">Remington</td>
                            <td align="left" valign="middle" class="table_dark">16</td>
                            <td align="left" valign="middle" class="table_dark">06/02/2011</td>
                            <td align="left" valign="middle" class="table_dark">08/02/2011</td>
                            <td align="left" valign="middle" class="table_dark"><select name="select" class="restaurant_selectmedium" id="select2">
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Suspended</option>
                            </select></td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_light">Mariton</td>
                            <td align="left" valign="middle" class="table_light">17</td>
                            <td align="left" valign="middle" class="table_light">06/02/2011</td>
                            <td align="left" valign="middle" class="table_light">10/02/2011</td>
                            <td align="left" valign="middle" class="table_light"><select name="select" class="restaurant_selectmedium" id="select2">
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Suspended</option>
                            </select></td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_dark">Redwood</td>
                            <td align="left" valign="middle" class="table_dark">18</td>
                            <td align="left" valign="middle" class="table_dark">06/02/2011</td>
                            <td align="left" valign="middle" class="table_dark">15/02/2011</td>
                            <td align="left" valign="middle" class="table_dark"><select name="select" class="restaurant_selectmedium" id="select2">
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Suspended</option>
                            </select></td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_light">Sherwood</td>
                            <td align="left" valign="middle" class="table_light">19</td>
                            <td align="left" valign="middle" class="table_light">06/02/2011</td>
                            <td align="left" valign="middle" class="table_light">17/02/2011</td>
                            <td align="left" valign="middle" class="table_light"><select name="select" class="restaurant_selectmedium" id="select2">
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Suspended</option>
                            </select></td>
                          </tr>
                          <tr>
                            <td align="left" valign="middle" class="table_dark">Brookwilli</td>
                            <td align="left" valign="middle" class="table_dark">20</td>
                            <td align="left" valign="middle" class="table_dark">06/02/2011</td>
                            <td align="left" valign="middle" class="table_dark">20/02/2011</td>
                            <td align="left" valign="middle" class="table_dark"><select name="select" class="restaurant_selectmedium" id="select2">
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Suspended</option>
                            </select></td>
                          </tr>
                      </table> --></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="297" height="40" align="right" valign="middle">&nbsp;</td>
                          <td width="353" align="right" valign="middle"><table width="220" border="0" align="center" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="100" align="center"><div id="select_hot"><html:submit property="operation" styleClass="but_img">Update</html:submit></div></td>
                                <td width="100" align="center"><div id="select_hot"><a href="creditdiscountdisplay.do?operation=insert">New</a></div></td>
                              </tr>
                          </table></td>
                          <td width="295" align="right" valign="middle" class="blue_medium">&nbsp;</td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
                <td width="8" background="../images/8.png"></td>
              </tr>
              <tr>
                <td height="8" background="../images/3.png"></td>
                <td height="8" background="../images/6.png"></td>
                <td height="8" background="../images/4.png"></td>
              </tr>
            </table>
            </html:form>
          <!-- form End-->        </td>
      </tr>
    </table>  
    </div>
							<div class="top_bottom">
								<img src="../images/corner_bottom_left.jpg" align="left" />
								<img src="../images/corner_bottom_right.jpg" align="right" />
							</div>

							<%@ include file="footer.jsp"%>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div style="clear: both;"></div>
	</div>
</div>




</body>
</html>
