<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp"%>
<script type="text/javascript">
	
	function submitForm(){
		var nameId = document.getElementById("nameId").value;
		document.dealDescriptionForm.action = "viewDescription.do?operation=display&nameId="+nameId;
		document.dealDescriptionForm.submit();
	}
		function addForm(){
		//var nameId = document.getElementById("nameId").value;
		document.dealDescriptionForm.action = "viewDescription.do?operation=insert";
		document.dealDescriptionForm.submit();
	}
	
	 
</script>
</head>
<body>
	<div id="wrapper">
	<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		</jsp:include> 
		<div class="cantainer_inner">
      <div class="main_cantainer">
        <div class="cantainer_content">
   
         <div class="inner_cantainer">
            <div class="main_deal">
  
                   <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	
  	                   <div class="content_deal_inner">	
   <!--	start login --><table width="760" border="0" cellspacing="0" cellpadding="0">			  
				<%@ include file="admin_banner.jsp" %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			        <html:form action="/jsp/viewDescription" method="post">
						<!-- form Start-->
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top"><table width="935" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Manage Deal Description</td>
                  </tr>
                   <logic:messagesPresent message="true">
											<html:messages id="message" message="true">
												<logic:present name="message">
													<tr>
														<td align="center" valign="middle" colspan="2">
															<FONT color="red"><bean:write name="message"
																	filter="false" /> </FONT>
														</td>
													</tr>
												</logic:present>
											</html:messages>
										</logic:messagesPresent>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                    
                 
                  <tr>
                    <td align="center" valign="top"><br/>
                     <table width="300" border="0" align="center" cellpadding="4" cellspacing="1" >
                  
                      <tr height="20">
              					<td align="right" width="100" valign="middle" >
														<span class="bla_low">Deal Name<span
															class="red_text"></span>:</span>
													<br /></td>
													<td  align="left" valign="middle" >
														<html:select property="nameId" styleClass="restaurant_select" styleId="nameId"  onchange="submitForm()">
														    <c:forEach var="dname" items="${dealnames}">
																<html:option value="${dname.nameId}">${dname.name}</html:option>
															</c:forEach>
														</html:select>
													<br /></td>
												</tr>  
									
					  <tr>
                       <td align="center" valign="top" colspan="2"><br/>
                         <table width="300" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="center" valign="middle" class="text_h3">Description</td>
                            <td align="center" valign="middle" class="text_h3">Status</td>
                          </tr>	
                          <c:forEach var="desc" items="${dealdesc}">
							 <tr>
                            <td align="left" valign="middle" class="table_dark">
                            <html:hidden property="descriptionId" styleId="descriptionId" value="${desc.descriptionId}" />
                            <a href="viewDescription.do?operation=insert&did=${desc.descriptionId}"> ${desc.description}</a></td>
                            
                           <td align="left" valign="middle" class="table_dark"> 
                           <html:select property="isActive" styleId="isActive" value="${desc.isActive}">
                            <html:option value="1"  >Active</html:option>
                            <html:option value="0"   >InActive</html:option>
                           </html:select>
                           </td>
                          </tr>
                          </c:forEach>
                 
                          <tr>
                            <td height="30" align="right" valign="middle" class="table_light"><table width="75" border="0" align="right" cellpadding="0" cellspacing="0">
                              <tr>
                                <td align="center" valign="middle"><div class="login_butgre"><a href="javascript:addForm();">New</a></div></td>
                              </tr>
                            </table></td>
                            <td align="left" valign="middle" class="table_light" colspan="2"><table width="75" border="0" align="left" cellpadding="0" cellspacing="0">
                              <tr>
                                <td align="center" valign="middle"><div class="login_butgre"><html:submit property="operation" value="update" styleClass="login_butgre">Update</html:submit></div></td>
                              </tr>
                            </table></td>
                          </tr>
                        </table></td>
                      </tr>
                   </table>
                        </td></tr> 
                      
                           
                </table>
                </td>
                <td width="8" background="../images/8.png"></td>
              </tr>
              <tr>
                <td height="8" background="../images/3.png"></td>
                <td height="8" background="../images/6.png"></td>
                <td height="8" background="../images/4.png"></td>
              </tr>
            </table>
           
            </html:form>
		<!-- form End-->
							</td>
			      		</tr>
			    	</table>
				</div>
           <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>
</div>
</div>
</body>
</html>