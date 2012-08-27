<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tangotab.dao.pojo.DealTemplate"%>
<%@page import="com.tangotab.dao.pojo.DealTemplate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tangotab.businessImpl.DealBOImpl"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib  uri="/WEB-INF/displaytag.tld"  prefix="display" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp"%>
</head>
<body>
 
	<div id="wrapper">
	<div id="main">
		<jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		</jsp:include> 
		  <html:form action="/jsp/adminDealDisplay"  method="post">
		  
		<<div class="cantainer_inner">
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
			        <td height="17" colspan="3" align="center" valign="top">
			        
						<!-- form Start-->
						
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="952" height="8" background="../images/5.png"></td>
                <td background="../images/2.png" height="8"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"><br></td>
                <td height="100" align="center" valign="top">
                <table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Update Deals<br></td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"><br></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td width="42%" align="right" valign="bottom" class="gre_low">Enter Deal Name:<br></td>
                          <td width="20%" align="left" valign="bottom" class="text_formsub"><input type="text" class="restaurant_input"  /><br></td>
                          <td align="left" valign="bottom"><table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><a href="#">Search</a></div><br></td>
                            </tr>
                          </table><br></td>
                        </tr>
                    </table><br></td>
                  </tr>
                    
                  <tr>
                    <td align="center" valign="top">
                    <!-- <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="100" align="right" valign="middle" class="text_h8">&nbsp;<br></td>
                          <td width="380" align="left" valign="middle">&nbsp;<br></td>
                          <td align="right" valign="top" class="blue_medium">page &lt;&lt;&nbsp; &lt; 1 2 3 4 5 6 7 8 9 &gt;&nbsp; &gt;&gt;<br></td>
                        </tr>
                    </table> --><br></td>
                  </tr>
                  
                  <tr>
                    <td align="center" valign="top" width="952"><table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
                        <%
						     request.setAttribute("deal",session.getAttribute("deal"));
						     int i=0;
						     String style="";
						     %>
						   
                              <display:table requestURI='adminDealDisplay.do?operation=display' id="dealList" name="deal" pagesize="6"  cellpadding="3" cellspacing="3"  style="background-color:#B7D287;width:98%">
									 <%
                                i++;
                                style="table_light"; 
                                if(i%2==0)
                                style="table_dark";
                                %> 
                                
							  <display:column  headerClass="text_h3b"  title="Deal Name"   class="<%=style%>" style="width:25%;">
							   <a href='editDeals.do?operation=edit&dealid=<bean:write name="dealList" property="dealTemplateId"  />'>
                                <bean:write name="dealList" property="dealTemplateName"  /></a> </display:column>
                               <display:column   class="<%=style%>" headerClass="text_form"    style="width:25%;"  title="Deal Description"  property="dealTemplateDescription">
                               </display:column>
                               <display:column   class="<%=style%>" headerClass="text_form" style="width:25%;" title="Deal Restrictions" property="dealTemplateRestrictions">
                               </display:column>
                                </display:table>
                               
                               </table>
                          </td>
                          </tr> 
                         
                         </table>
                <td width="8" background="../images/8.png"></td>
              </tr>
          
              <tr>
                <td height="8" background="../images/3.png"></td>
                <td height="8" background="../images/6.png"></td>
                <td height="8" background="../images/4.png"></td>
              </tr>
            </table>
            </td>
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
		
		</html:form>
	</div>
</div>
</body>
</html>