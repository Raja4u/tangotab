 
<%@page import="com.tangotab.web.form.LocationForm"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tangotab.dao.pojo.RestaurantLocation" %>
<%@page import="com.tangotab.dao.pojo.CuisineType,com.tangotab.dao.pojo.DiningStyle" %>
<%@page import="com.tangotab.TO.LocationTO,java.util.*,com.tangotab.TO.DropDownTO" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TangoTab</title>
<%@ include file="admin_imports.jsp" %>
<script type="text/javascript">
function check(value){
  if(value == "Yes"){
     document.getElementById("emailId").style.display="none";
     document.getElementById("emailIds").style.display="block";
     }
  if(value == "No"){
     document.locationForm.managerId.vlaue = "";
     document.getElementById("managerId").value="";
     document.getElementById("emailId").style.display="block";
     document.getElementById("emailIds").style.display="none";
     document.getElementById("emailIds").value = "";
     document.getElementById("emailId").value = "";
     document.getElementById("firstname").value = "";
     document.getElementById("mobilePhone").value = "";
     document.locationForm.password.value = ""; 
     
    }
}

function decide(value){
if(value == "Yes") {
	document.getElementById("one").style.display="none";
	document.getElementById("emailId").style.display ="block";
	document.getElementById("emailIds").style.display ="none";
	document.locationForm.emailId.value = '${locationData.restaurantTO.emailId}';
	document.locationForm.firstname.value = '${locationData.restaurantTO.firstname}';
	document.locationForm.mobilePhone.value = '${locationData.restaurantTO.mobilePhone}';
	
  }
 else{
    document.getElementById("one").style.display="block";
	
  }
 
}

function show(value){
if(value != "select"){
 var s = value;
 var values = value.split(",");
 document.getElementById("managerId").vlaue = values[0];
 document.locationForm.managerId.value =  values[0];
 
 //document.getElementById("emailIds").value = values[1];
 //document.locationForm.emailIds.value = values[1];
 //document.dealRegForm.restLocationId1.options[document.dealRegForm.restLocationId1.selectedIndex].text
 
 document.locationForm.emailId.value = values[1];
 document.getElementById("emailId").value = values[1]
 
 document.getElementById("firstname").value = values[2];
 document.getElementById("mobilePhone").value = values[3];
 
 //document.locationForm.password.value = values[4];
 document.getElementById("password").value = values[4];
 //alert(document.locationForm.managerId.value);
 
 }else{
 document.locationForm.managerId.vlaue = "";
 document.locationForm.password.value = "";
 //document.getElementById("emailIds").value = "";
 document.getElementById("emailId").value = "";
 document.getElementById("firstname").value = "";
 document.getElementById("mobilePhone").value = "";
 
 }
 
}

function check1(){

 document.locationForm.existedManager.value = "No";
 document.getElementById("existedManager").value="No";
 //document.getElementById("emailId").style.display="block";
 //document.getElementById("emailIds").style.display="none";
  
}

 function controlDisplay(){
 var val = '${locationForm.hostAsManager}';
// alert(val);
  if(val == "Yes")
     document.getElementById("one").style.display="none";
 }
</script>
</head>
<body onload="controlDisplay();">
	<div id="wrapper">
	<div id="main">
<!--Header Start-->
<jsp:include page="header.jsp">
	<jsp:param name="currentPage" value="MyAccount" />
</jsp:include> 
<!--Header End here-->
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
        <td height="17" colspan="3" align="center" valign="top">
			        <html:form action="/jsp/updateadminlocation.do?operation=update" method="post"
			            enctype="multipart/form-data">
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
			                <table width="930" border="0" align="center" cellpadding="0" cellspacing="5">
			                  <tr>
			                    <td height="40" colspan="3" align="center" valign="middle" class="red_max"> Edit Location Information</td>
			                    
			                    </tr>
			                    <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="2">
																		<font color="red"> <bean:write name="message"
																				filter="false" /> </font>
																		
																	</td>
																</tr>
															</logic:present>
														</html:messages>
													</logic:messagesPresent>
		                        <tr>
			                    <td align="right" valign="middle" class="bla_low">Location Name<span class="red_text">*</span>:</td>
                                <td colspan="2" align="left" valign="middle">
			                     <html:text property="locationRestName"  styleClass="restaurant_select" value="${locationData.locationRestName}" />
			                     <span  class="red_text" id="locationRestName"><html:errors property="locationRestName"/></span>
				                <html:hidden property="restLocationId" value="${locationData.restLocationId}"/>
				                  <html:hidden property="userId" value="${locationData.userId}"/>
				                   <input type="hidden" id="oldpassword" name="oldpassword" value="${locationData.password}" />
				                
				                </td>
			                  </tr>
			                  <tr>
			                    <td  align="right" valign="middle" class="bla_low">Business Name${locationData.businessName}<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="businessName"  styleClass="restaurant_input" value="${businessName}" readonly="true"></html:text>
									</td>
			                  </tr>
                             <tr><!--
                                 <td align="right" valign="middle" class="bla_low">&nbsp;</td>
			                    --><td colspan="2" align="right" valign="middle" class="bla_low"><span class="text_h10">[NOTE:*Your image is displaying here.If you want to change please select browse in the following.*] <br/>
			                    [An image size of 220(width) x 225(height) pixels is recommended.]</span></td>
		                      </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Restaurant Image:<html:hidden property="locationRestImgPath" value="${locationData.locationRestImgPath}"/></td>
			                    <td align="left" valign="middle" height="70px;"><html:file property="locationImage"  styleClass="restaurant_fileupload" styleId="fileField2" />
			                    </td>
			                 <td rowspan="10" align="right" width="220" valign="top"><html:img  src="${locationData.locationRestImgPath}" width="220" height="211" border="0" /></td>
			                 </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Street Address1</span><span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="address"   styleClass="restaurant_input" name="locationData" value="${locationData.address}">
			                     </html:text>
			                     <span  class="red_text" id="address"><html:errors property="address"/></span></td>
			                  </tr>
			                  	<tr>
			                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Street Address2</span>:</td>
			                    <td align="left" valign="middle"><html:text property="address1"   styleClass="restaurant_input" name="locationData" value="${locationData.address1}">
			                     </html:text> 
			                     <span  class="red_text" id="address1"><html:errors property="address1"/></span> </td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">City<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="cityId" styleClass="restaurant_select" styleId="cities" value="${locationData.cityId}"></html:text>
                              <html:errors property="cityId"/></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">State/Prov<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:select property="stateId"  styleClass="restaurant_select" styleId="states" onchange="getCities()" value="${locationData.stateId}" >
			                			<html:option value="0">Select State</html:option>
			               <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach> 
			                </html:select><html:errors property="stateId"/>
				                </td>
			                  </tr>
			                  <html:hidden property="isActive"  styleClass="restaurant_input" value="${locationData.isActive}"></html:hidden>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Zip/Post Code<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="zipCode"  styleClass="restaurant_input" value="${locationData.zipCode}"></html:text>
			                    <span  class="red_text" id="zipCode"><html:errors property="zipCode"/></span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Country<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
													<html:select property="countryId"  styleClass="restaurant_select" styleId="countries" onchange="getStates()"  value="${locationData.countryId}"  >
			                			<html:option value="0">Select Country</html:option>
			                <bean:define id="relationships3" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships3" property="countryId" labelProperty="countryName"/>
			                </html:select><html:errors property="countryId"/>
			                	 									</td>
			                  </tr>
			                      <tr>
			                    <td align="right" valign="middle" class="bla_low">Deal City Preference<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:select property="preferCityId" styleClass="restaurant_select" styleId="cities1" value="${locationData.preferCityId}">
                             <html:option value="0">Select your option </html:option>
			   						<bean:define id="relationships4" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    					<html:options collection="relationships4" property="cityId" labelProperty="cityName"/>
                              </html:select> <html:errors property="preferCityId"/></td>
			                  </tr>
			                  
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Restaurant Description<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle"><html:textarea property="description"   cols="40" rows="10" value="${locationData.description}"></html:textarea>
			                    <span  class="red_text" id="description"><html:errors property="description"/></span></td>
			                  </tr>
			                  <tr>
			                  <td align="right" valign="middle" class="bla_low">Do you want to assign Host as DealManager:</td>
			                 <td align="left" valign="middle">
			                 <table align="left" cellpadding="0" cellspacing="0" width="200">
			                
			                 <tr>
			                  <td align="left" class="bla_low">
			                  <html:radio property="hostAsManager"  styleId="hostAsManager" value="Yes" onclick="decide(this.value)" >Yes</html:radio>
			                  <html:radio property="hostAsManager" styleId="hostAsManager" value="No" onclick="decide(this.value)" >No</html:radio>
		
			                  <span  class="red_text" id="ahphone"> </span></td>
			                 </tr>  
			                 </table>
			                 </td>
			                 </tr> 
			                 <c:if test="${not empty managers }">
			                  <tr id= "one">
			                  <td width="30%" align="right" valign="middle" class="bla_low">Do you want to assign existing DealManager:</td>
			                 <td width= "70%" align="left" valign="middle">
			                 <table align="left" cellpadding="0" cellspacing="0" width="200">
			                <tr>
			                  <td align="left">
			                  <html:radio property="existedManager"  styleId="existedManager" value="Yes" onclick="check(this.value)" >Yes</html:radio>
			                  <html:radio property="existedManager" styleId="existedManager" value="No"   onclick="check(this.value)" >No</html:radio>
		
			                  <span  class="red_text" id="ahphone"> </span></td>
			                 </tr>
			                 </table>
			                 </td>
			                 </tr>  </c:if>
			                 <tr>
			                    <td align="right" valign="middle" class="bla_low">Deal Manager's Email<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle">
			                    <html:text property="emailId"  styleClass="restaurant_input" styleId="emailId" value="${locationData.emailId}"   onblur="checkEmail(6)" ></html:text>
			                    <html:select property="emailIds" styleClass="restaurant_select" styleId="emailIds" style="display:none" onchange="show(this.value)" >
										             	  <html:option value="select">Select Manager</html:option>
										             	  <c:forEach var="mgr" items="${managers}" >
										             	  <html:option  value="${mgr.stateId},${mgr.webSite},${mgr.description},${mgr.zipCode},${mgr.address}"> ${mgr.webSite} </html:option>
										             	   
										             	  </c:forEach>
								</html:select>
								<span  class="red_text" id="checkEmailId"></span>
								 <input type="hidden" name="exemailId"  class="restaurant_input"  value="${locationData.emailId}"   />
			                   
								<span  class="red_text" id="emailId"><html:errors property="emailId"/> </span>
			                    </td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Deal Manager's Name<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="firstname"  styleClass="restaurant_input"   styleId="firstname" value="${locationData.firstname}"></html:text>
			                    <span  class="red_text" id="firstname"><html:errors property="firstname"/></span></td>
			                  </tr>
			                  
			                  <html:hidden property="managerId" styleClass="restaurant_input" styleId="managerId" value="${locationData.userId}"></html:hidden> 
			                  <html:hidden property="password" styleClass="restaurant_input" styleId="password"  value="${locationData.password}"></html:hidden>
			                  <input type="hidden" id="emailIddummy" name="emailIddummy" value="${locationData.emailId}"> </input>
			                  
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Deal Manager's Phone<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="mobilePhone"  styleClass="restaurant_input" styleId="mobilePhone" onkeypress="return isNumberKey(event)" value="${locationData.mobilePhone}" ></html:text>
			                    <span class="blue_text">(e.g., 2125551212)</span>
								<html:errors property="mobilePhone"/>
			                    </td>
			                  </tr>
			                  <!--<tr>
			                    <td align="right" valign="middle" class="bla_low">Direction Image<span class="red_text">*</span>:<html:hidden property="directionImgPath" value="${locationData.directionImgPath}"/></td>
			                    <td align="left" valign="middle"><html:file property="directionImage"  styleClass="restaurant_fileupload" styleId="fileField2" />
			                    </td>
			                   <td rowspan="5" align="right" width="220" valign="top"><html:img src="${locationData.directionImgPath}" width="190" height="100" border="0" /></td>
			                  </tr>
			                  --><tr>
			                    <td align="right" valign="middle" class="bla_low">Restaurant Main Phone<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="locationHomePhone"  styleClass="restaurant_input" onkeypress="return isNumberKey(event)" value="${locationData.locationHomePhone}"></html:text>
			                    <span  class="red_text" id="homePhone">   <html:errors property="locationHomePhone"/> </span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low"> Deal Manager Business Title:</td>
			                    <td align="left" valign="middle"><html:text property="businessTitle"   styleClass="restaurant_input" value="${locationData.businessTitle}"></html:text>
			                    </td>
			                     
			                  </tr>
			                  <tr>
			                  	 <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameOne" styleId="nameOne" styleClass="restaurant_input" value="${locationForm.nameOne}"/>
			                      <span  class="red_text" id="nameOne">  </span></td>
			                  
			                  	 <td align="right" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdOne"   styleClass="restaurant_input" value="${locationForm.emailIdOne}"></html:text>
			                      <span  class="red_text" id="emailIdOne">  <html:errors property="emailIdOne"/> </span></td>
			                  </tr>
			                  <tr>
			                   	 <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameTwo" styleId="nameTwo" styleClass="restaurant_input" value="${locationForm.nameTwo}"/>
			                      <span  class="red_text" id="nameTwo">  </span></td>
			                  
			                  	 <td align="right" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdTwo"   styleClass="restaurant_input" value="${locationForm.emailIdTwo}"></html:text>
			                      <span  class="red_text" id="emailIdTwo">  <html:errors property="emailIdTwo"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameThree" styleId="nameThree" styleClass="restaurant_input" value="${locationForm.nameThree}"/>
			                      <span  class="red_text" id="nameThree">  </span></td>
			                  
			                  	 <td align="right" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdThree"   styleClass="restaurant_input" value="${locationForm.emailIdThree}"></html:text>
			                      <span  class="red_text" id="emailIdThree">  <html:errors property="emailIdThree"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFour" styleId="nameFour" styleClass="restaurant_input" value="${locationForm.nameFour}"/>
			                      <span  class="red_text" id="nameFour">  </span></td>
			                  
			                  	 <td align="right" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFour"   styleClass="restaurant_input" value="${locationForm.emailIdFour}"></html:text>
			                      <span  class="red_text" id="emailIdFour">  <html:errors property="emailIdFour"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFive" styleId="nameFive" styleClass="restaurant_input" value="${locationForm.nameFive}"/>
			                      <span  class="red_text" id="nameFive">  </span></td>
			                  
			                  	 <td align="right" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFive"   styleClass="restaurant_input" value="${locationForm.emailIdFive}"></html:text>
			                      <span  class="red_text" id="emailIdFive"> <html:errors property="emailIdFive"/>  </span></td>
			                  </tr>			                  
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Fax:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="fax"  styleClass="restaurant_input" onkeypress="return isNumberKey(event)" value="${locationData.fax}"></html:text>
			                    <span  class="red_text" id="fax">   <html:errors property="fax"/> </span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Website:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="webSite" onkeyup="hidetext('webSite')"   value="${locationData.webSite}" styleClass="restaurant_input"></html:text>
			                        <span  class="red_text" id="webSite">  &nbsp;  </span>
			                         
			                       </td>
			                 
			                  </tr>
			                  <html:hidden property="restaurantId" value="${locationForm.restaurantId}"/>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Ratings:</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="rating"  styleClass="restaurant_input" value="${locationData.rating}"></html:text></td>
			                  </tr>
			                   <tr>
			                    <td align="right" valign="middle" class="bla_low">Starting Price<span class="red_text">*</span>: $</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="priceStartRate"  styleClass="restaurant_input" value="${locationData.priceStartRate}"></html:text>
			                   <span  class="red_text" id="priceStartRate"><html:errors property="priceStartRate"/></span>
			                   </td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Ending Price<span class="red_text">*</span>: $</td>
			                    <td colspan="2" align="left" valign="middle"><html:text property="priceEndRate"  styleClass="restaurant_input"  value="${locationData.priceEndRate}"></html:text>
			                    <span  class="red_text" id="priceEndRate"><html:errors property="priceEndRate"/></span>
			                   </td>
			                  </tr>
			                  <tr> 
			                    <td align="right" valign="middle" class="bla_low">Change password</td>
			                    <td align="left" valign="middle"><a href="passwordForwardAction.do?userId=${locationData.userId}"  ><u class="red_text">Change password</u></a>
			                        &nbsp;
                                </td>
			                  </tr>
			                    <tr>
			                    <td align="right" valign="top" class="bla_low">Dining Style<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="top" class="text_h9"> <html:errors property="diningStylePreferences"/><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <%
									DiningStyle diningStyle=new DiningStyle();
									List<DiningStyle>  dinList=( List<DiningStyle>)( (DropDownTO)application.getAttribute("dropDownList")).getDiningStyles();
									Iterator<DiningStyle> iter= dinList.iterator();
									int[] diningStylePreferences = ((LocationTO)session.getAttribute("locationData")).getDiningStylePreferences();
 		    
								 %>
						<tr>

								<%
									String i11="5";
									String  ctype1="0";
									String status1="not";
									int ij1=0;
									while(iter.hasNext())
									{
										i11="0";
										diningStyle=(DiningStyle)iter.next();
										ctype1=Integer.toString(diningStyle.getDiningStyleId());
										status1="not";
										if(diningStylePreferences!= null && diningStylePreferences.length>0){
											for(int i=0;i<diningStylePreferences.length;i++)
											{
												i11=diningStylePreferences[i]+"";
												if(i11.equals(ctype1))
												status1="ok";
											}
										}
									 if(ij1%4==0)
										{
										 %></tr><tr><%
									 }
									 	++ij1;
								 
								if(status1.equals("ok"))
								{
								%>     <td align="left" valign="middle"><input type="checkbox" name="diningStylePreferences"  value="<%=ctype1%>" checked />  
								
								<%=diningStyle.getDiningStyleName()%></td>
								
								
								<%
								}else {%>
								<td align="left" valign="middle"><input type="checkbox" name="diningStylePreferences"  value="<%=ctype1%>"   />  
								
								<%=diningStyle.getDiningStyleName()%></td>
								<% } }
								%>
			                    </table></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="top" class="bla_low">Cuisine Type<span class="red_text">*</span>:</td>
			                    <td colspan="2" align="left" valign="top" class="text_h9">  <html:errors property="preferencesList"/><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <%
									CuisineType cuisineType=new CuisineType();
									List<CuisineType>  list=( List<CuisineType>)( (DropDownTO)application.getAttribute("dropDownList")).getCusineTypes();
									
									Iterator<CuisineType> it= list.iterator();
									int[] preferencesList = ((LocationTO)session.getAttribute("locationData")).getPreferencesList();
									
								 %>
						<tr>

								<%
									String i1="5";
									String  ctype="0";
									String status="not";
									int ij=0;
									while(it.hasNext())
									{
										i1="0";
										cuisineType=(CuisineType)it.next();
										ctype=Integer.toString(cuisineType.getCuisineTypeId());
										status="not";
										if(preferencesList!= null && preferencesList.length>0){
											for(int i=0;i<preferencesList.length;i++)
											{
												i1=preferencesList[i]+"";
												if(i1.equals(ctype))
												status="ok";
											}
										}
									 if(ij%4==0)
										{
										 %></tr><tr><%
									 }
									 	++ij;
								 
								if(status.equals("ok"))
								{
								%>     <td align="left" valign="middle"><input type="checkbox" name="preferencesList"  value="<%=ctype%>" checked />  
								
								<%=cuisineType.getType()%></td>
								
								
								<%
								}else {%>
								<td align="left" valign="middle"><input type="checkbox" name="preferencesList"  value="<%=ctype%>"   />  
								
								<%=cuisineType.getType()%></td>
								<% } }
								%>
			                    </table></td>
			                  </tr>
			                    <tr>
			                    <td height="40" colspan="3" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <tr>
			                        <td align="right" width="110"><div id="select_hot"><a href="viewlocationMgmt.do?operation=display">Cancel</a></div></td>
			                        
			                         <td align="right" width="110"><div id="select_hot"><html:submit styleClass="but_img" styleId="submitID" onclick="check1()" >Update</html:submit></div></td>
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
			          <!-- form End-->  
                   </html:form>    
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
