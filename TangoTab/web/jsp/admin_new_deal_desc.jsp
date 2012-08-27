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
		document.forms[0].action = "viewDescription.do?operation=display&nameId="+nameId;
		document.forms[0].submit();
	}
		function checkValidataion()
		{
			Ltrim(document.dealDescriptionForm.description);
	 		if(document.dealDescriptionForm.description.value==""  || document.dealDescriptionForm.description.value.length<1)
			{
			document.getElementById("descriptionerror").innerHTML='Deal Description is required';
			return false;
			} else if( document.dealDescriptionForm.description.value.length>1000)
			{
				document.getElementById("descriptionerror").innerHTML="Deal Description length can't be greater than 1000";
			return false;
			} else 
			return true;
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

							<div class="top_header">
								<img src="../images/corner_left.jpg" align="left" />
								<img src="../images/corner_right.jpg" align="right" />
							</div>

							<div class="content_deal_inner">
							
							<table width="760" border="0" cellspacing="0" cellpadding="0">			  
				<%@ include file="admin_banner.jsp" %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			        <html:form action="/jsp/newdescription" method="post" onsubmit="return checkValidataion();">
						<!-- form Start-->
						 <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top">
                <table width="935" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">  Manage Deal Description</td>
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
                     <table width="60%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#cccccc">
                     <c:if test="${dealDescriptionForm.descriptionId eq null or dealDescriptionForm.descriptionId eq 0 }">
                      <tr height="20">
              					<td align="right" width="100" valign="middle" >
														<span class="bla_low">Deal Name<span
															class="red_text"></span>:</span>
													<br /></td>
													<td  align="left" valign="middle" >
														<html:select property="nameId" styleClass="restaurant_select" styleId="nameId" >
														    <c:forEach var="dname" items="${dealnames}">
																<html:option value="${dname.nameId}">${dname.name}</html:option>
															</c:forEach>
														</html:select>
													<br /></td>
												</tr>  
												</c:if>
						<c:if test="${dealDescriptionForm.descriptionId gt 0 }">
						<tr height="20">
                        <td align="right" width="100" valign="middle" ><span class="bla_low">Deal Name<span
															class="red_text"></span>:</span>
													<br /></td>
                        <td align="left" valign="middle" >
                          <html:text property="name" styleId="name" styleClass="restaurant_select" readonly="true" />
                          <html:hidden property="nameId" styleId="nameId" styleClass="restaurant_select"/>
                        </td>
                          </tr>					
						</c:if>
				      <tr>
                        <td align="right" valign="middle" class="table_light">Deal Description<span class="red_text">*</span>:</td>
                        <td align="left" valign="middle" class="table_light"><span class="red_text">
                          <html:textarea property="description"/>
                    	  <div id="descriptionerror">
                          <html:errors property="description"  />
                          </div> 
                        </span>
                        </td>
                        <html:hidden property="descriptionId"/>
                        <html:hidden property="isActive"/>
                      </tr>
                      
                      <tr>
                        <td align="right" valign="middle" class="table_light">&nbsp;</td>
                        <td align="left" valign="middle" class="table_light"> 
                        <table width="110" border="0" align="left" cellpadding="0" cellspacing="0">
                          <tr>
                            <td><div id="select_hot">
                                   <html:submit property="operation" styleClass="but_img" value="save"/>
                            </div></td>
                            <td align="center" valign="middle">
                            <div id="select_hot">                               
                            	   <html:button onclick="submitForm()" property="operation" styleClass="but_img" value="Cancel"/>
                            </div></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td></tr>
                         
                      
                           
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
		<!-- form End-->
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
	</div>
</div>
</body>
</html>