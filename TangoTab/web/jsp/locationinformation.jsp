<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
<script type="text/javascript">
function check(value){
  if(value == "Yes"){
     document.getElementById("emailId").style.display="none";
     document.getElementById("emailIds").style.display="block";
      document.getElementById("firstname").setAttribute("readOnly",true);
     }
  if(value == "No"){
     document.locationForm.managerId.vlaue = "";
     document.getElementById("managerId").value="";
     document.getElementById("emailId").style.display="block";
     document.getElementById("emailIds").style.display="none";
     document.getElementById("emailIds").value = "";
     document.getElementById("emailId").value = "";
     document.getElementById("firstname").value = "";
     
      document.getElementById("firstname").removeAttribute("readOnly");
     document.getElementById("mobilePhone").value = "";
     document.locationForm.password.value = ""; 
    
    }
}

function decide(value){
if(value == "Yes") {
	document.getElementById("one").style.display="none";
	document.getElementById("emailId").style.display ="block";
	document.getElementById("emailId").setAttribute('readOnly','readonly');    
	document.getElementById("emailIds").style.display ="none";
	document.locationForm.emailId.value = '${userInfo.emailId}';
	document.locationForm.firstname.value = '${userInfo.firstname}';
	document.locationForm.mobilePhone.value = '${userInfo.mobilePhone}';
	
  }
 else{
    document.getElementById("one").style.display="block";
    	document.getElementById("emailId").removeAttribute('readOnly');
	
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
  
}
</script>
<script type="text/javascript">
		  function fill(){
  if(document.locationForm.adddo.checked==true)
 {
 
		    document.locationForm.address.value='${userInfo.address}';
		    document.locationForm.address1.value='${userInfo.address1}';
		 document.locationForm.cityId.value='${userInfo.cityId}';
		    document.locationForm.stateId.value='${userInfo.stateId}';
		    	 document.locationForm.zipCode.value='${userInfo.zipCode}';
		    document.locationForm.countryId.value='${userInfo.countryId}';
		  
	}else 
	{
		    document.locationForm.address.value='';
		    document.locationForm.address1.value='';
		 document.locationForm.cityId.value='';
		    document.locationForm.stateId.value='0';
		    	 document.locationForm.zipCode.value='';
		    document.locationForm.countryId.value='0';
	
	}
		  
		  
		  
		  }
 
 function controlDisplay(){
  if(document.locationForm.hostAsManager.value == "Yes")
     document.getElementById("one").style.display="none";
 }
		</script>
</head>
	<body >

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
							
			    <table width="968" border="0" cellspacing="0" cellpadding="0">
			      <%@ include file="client_banner.jsp"%>
		      	  <%@ include file="client_menu.jsp"%>			      
			      <tr>
			         <td height="17" colspan="3" align="center" valign="top">
			         		<html:form action="/jsp/locationReg" method="post"
			enctype="multipart/form-data"  ><!-- form Start-->
			            <table width="968" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <td background="../images/1.png"></td>
			                <td width="729" height="8" background="../images/5.png"></td>
			                <td background="../images/2.png"></td>
			              </tr>
			              <tr>
			                <td width="8" background="../images/7.png"></td>
			                <td width="952" height="100" align="center" valign="top"><table width="930" border="0" align="center" cellpadding="0" cellspacing="5">
			                  <tr>
			                    <td height="40" colspan="2" align="center" valign="middle" class="red_max"> Location Information</td>
			                    </tr>
			                    <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<tr>
																	<td align="center" valign="middle" colspan="2">
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		<br>
																	</td>
																</tr>
															</logic:present>
														</html:messages>
													</logic:messagesPresent>
		                 <tr>
			                    <td width="300" align="right" valign="middle" class="bla_low">Location Name<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="locationRestName" onkeyup="hidetext('locationRestName')"  styleClass="restaurant_select">
				                </html:text>
				                <span  class="red_text" id="locationRestName">     <html:errors property="locationRestName"/></span>
				                </td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Business Name<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="businessName" onkeyup="hidetext('businessName')"  styleClass="restaurant_input" value="${userInfo.businessName}" readonly="true"></html:text>
                                <html:errors property="businessName"/></td>
			                  </tr>
			                  <tr>
			                    <td colspan="2" align="center" valign="middle" class="text_h10">[NOTE:*An image size of 220 (width) x 225 (height) pixels is recommended.*]
			                    </td>
		                      </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Restaurant Image<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">	<html:file property="locationImage" />
			                    
										   <span  class="red_text" id="locationRestImgPath"><html:errors property="locationRestImgPath"/></span></td>
			                  </tr>
			                   <tr>
			                    <td align="center" valign="middle" class="bla_low" colspan="2"> <input type="checkbox" name="adddo"  value="yes" onclick="fill()" /> 
                    &nbsp;Location address  is same as Business address</td>
                    </tr>
                  
			                  <tr>
			                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Street Address1</span><span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="address"   styleClass="restaurant_input"></html:text>
									 <span  class="red_text" id="address"><html:errors property="address"/></span>
									 </td>
			                  </tr>    <tr>
			                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">Street Address2</span>:</td>
			                    <td align="left" valign="middle"><html:text property="address1"   styleClass="restaurant_input"></html:text>
									 
									 </td>
			                  </tr> 
			                
			                        <tr> 
			                    <td align="right" valign="middle" class="bla_low">City<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
			                    <html:text property="cityId" styleClass="restaurant_select" styleId="cities"     >
                                </html:text><span  class="red_text" id="cityId"><html:errors property="cityId"/></span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">State<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
										<html:select property="stateId"  onkeyup="hidetext('stateId')"   styleClass="restaurant_select" styleId="states"  >
			                			<html:option value="0">Select State</html:option>
			                	 <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			              
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach> 
			                </html:select><span  class="red_text" id="stateId"><html:errors property="stateId"/></span>
									</td>
			                  </tr>
			            <tr>
			                    <td align="right" valign="middle" class="bla_low">Zip/Post Code<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="zipCode"  onkeyup="hidetext('zipCode')"  styleClass="restaurant_input"></html:text>
								<span  class="red_text" id="zipCode">	<html:errors property="zipCode"/></span></td>
			                  </tr>
			                  
			                   <tr>
			                    <td align="right" valign="middle" class="bla_low">Country<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
													<html:select property="countryId"    styleClass="restaurant_select" styleId="countries"  >
			                			<html:option value="0">Select Country</html:option>
			                <bean:define id="relationships3" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships3" property="countryId" labelProperty="countryName"/>
			                </html:select><span  class="red_text" id="countryId"><html:errors property="countryId"/></span>
			                	 
									</td>
			                  </tr>
			                    <tr> 
			                    <td align="right" valign="middle" class="bla_low">Deal City Preference<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
			                    <html:select property="preferCityId" styleClass="restaurant_select" styleId="cities"     >
                             <html:option value="0">Select your option </html:option>
			   						<bean:define id="relationships4" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    					<html:options collection="relationships4" property="cityId" labelProperty="cityName"/>
                              </html:select><span  class="red_text" id="preferCityId"><html:errors property="preferCityId"/></span></td>
			                  </tr> 
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Restaurant Description<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:textarea property="description"   cols="40" rows="10"  ></html:textarea>
									<span  class="red_text" id="description"><html:errors property="description"/> </span></td>
			                  </tr>
			                  
			                  <tr>
			                  <td align="right" valign="middle" class="bla_low">Do you want to assign Host as DealManager:</td>
			                 <td align="left" valign="middle">
			                 <table align="left" cellpadding="0" cellspacing="0" width="200">
			                 		                
			                 <tr>
			                  <td align="left">
			                  <html:radio property="hostAsManager"  styleId="hostAsManager" value="Yes" onclick="decide(this.value)" >Yes</html:radio>
			                  <html:radio property="hostAsManager" styleId="hostAsManager" value="No" onclick="decide(this.value)" >No</html:radio>
		
			                  <span  class="red_text" id="ahphone"> </span></td>
			                 </tr>  
			                 </table>
			                 </td>
			                 </tr> 
			                 
			                 
			                  <tr id= "one">
			                   <c:if test="${not empty managers }"> 
			                  <td align="right" valign="middle" class="bla_low">Do you want to assign existing DealManager:</td>
			                 <td align="left" valign="middle">
			                 <table align="left" cellpadding="0" cellspacing="0" width="200">
			                 		                
			                 <tr>
			                  <td   class="bla_low" align="left">
			                  <html:radio property="existedManager"  styleId="existedManager" value="Yes" onclick="check(this.value)" >Yes</html:radio>
			                  <html:radio property="existedManager" styleId="existedManager" value="No" onclick="check(this.value)" >No</html:radio>
		
			                  <span  class="red_text" id="ahphone"> </span></td>
			                 </tr>  
			                 </table>
			                 </td>
			                 </tr>  </c:if>
			               
			                 <tr>
			                   <td align="right" valign="middle" class="bla_low">Deal Manager's Email<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle">
			                    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
									     <tr>
									         <td width="163" align="left" valign="top">
										             	<html:text property="emailId"	styleClass="restaurant_input" styleId="emailId" onkeyup="hidetext('checkEmailId')"  onblur="checkEmail(6)" style="display:block"></html:text> 
										             	
										             	<html:select property="emailIds" styleClass="restaurant_select" styleId="emailIds" style="display:none" onchange="show(this.value)" >
										             	  <html:option value="select">Select Manager</html:option>
										             	  <c:forEach var="mgr" items="${managers}" >
										             	  <html:option  value="${mgr.stateId},${mgr.webSite},${mgr.description},${mgr.zipCode},${mgr.address}"> ${mgr.webSite} </html:option>
										             	   
										             	  </c:forEach>
										             	 </html:select>
										     </td>
										     <td width="285" align="left" valign="top" class="red_text" id="checkEmailId"></td>
										</tr>
									</table>
									
				                </td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Deal Manager's Name<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="firstname" styleId="firstname" onkeyup="hidetext('firstname')"   styleClass="restaurant_input"></html:text>
							<span  class="red_text" id="firstname"><html:errors property="firstname"/> </span></td>
			                  </tr>
			                  
			                  <html:hidden property="managerId" styleClass="restaurant_input" styleId="managerId" ></html:hidden> 
			                   <html:hidden property="password" styleClass="restaurant_input" styleId="password" ></html:hidden>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Deal Manager's Phone<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="mobilePhone" styleId="mobilePhone"  onkeyup="hidetext('mobilePhone')"     onkeypress="return isNumberKey(event)"  styleClass="restaurant_input"></html:text>
			                   <span class="blue_text">(e.g., 2125551212)</span>
			                  <span  class="red_text" id="mobilePhone">   <html:errors property="mobilePhone"/> </span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Restaurant Main Phone<span class="red_text">*</span>:</td>
			                    <td align="left" valign="middle"><html:text property="locationHomePhone" onkeyup="hidetext('locationHomePhone')"   onkeypress="return isNumberKey(event)"   styleClass="restaurant_input"></html:text>
			                  <span  class="red_text" id="homePhone">   <html:errors property="locationHomePhone"/> </span></td>
			                     
			                  </tr>
			                   <tr>
			                    <td align="right" valign="middle" class="bla_low"> Deal Manager Business Title:</td>
			                    <td align="left" valign="middle"><html:text property="businessTitle"   styleClass="restaurant_input"></html:text>
			                    </td>
			                     
			                  </tr>
			                 
			                  <tr>
			                  	 <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameOne" styleId="nameOne" styleClass="restaurant_input"/>
			                      <span  class="red_text" id="nameOne">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdOne"   styleClass="restaurant_input"></html:text>
			                      <span  class="red_text" id="emailIdOne">  <html:errors property="emailIdOne"/> </span></td>
			                  </tr>
			                  <tr>
			                   	 <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameTwo" styleId="nameTwo" styleClass="restaurant_input"/>
			                      <span  class="red_text" id="nameTwo">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdTwo"   styleClass="restaurant_input"></html:text>
			                      <span  class="red_text" id="emailIdTwo">  <html:errors property="emailIdTwo"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameThree" styleId="nameThree" styleClass="restaurant_input"/>
			                      <span  class="red_text" id="nameThree">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdThree"   styleClass="restaurant_input"></html:text>
			                      <span  class="red_text" id="emailIdThree">  <html:errors property="emailIdThree"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFour" styleId="nameFour" styleClass="restaurant_input"/>
			                      <span  class="red_text" id="nameFour">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFour"   styleClass="restaurant_input"></html:text>
			                      <span  class="red_text" id="emailIdFour">  <html:errors property="emailIdFour"/> </span></td>
			                  </tr>
			                  <tr>
			                   <td align="right" valign="middle" class="bla_low"> Additional Deal Manager Name:</td>
			                     <td align="left" valign="middle"><html:text  property="nameFive" styleId="nameFive" styleClass="restaurant_input"/>
			                      <span  class="red_text" id="nameFive">  </span></td>
			                  
			                  	 <td align="left" valign="middle" class="bla_low"> Email:</td>
			                     <td align="left" valign="middle"><html:text property="emailIdFive"   styleClass="restaurant_input"></html:text>
			                      <span  class="red_text" id="emailIdFive"> <html:errors property="emailIdFive"/>  </span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Fax:</td>
			                    <td align="left" valign="middle"><html:text property="fax"  onkeyup="hidetext('fax')"  onkeypress="return isNumberKey(event)"  styleClass="restaurant_input"></html:text>
			                      <span  class="red_text" id="fax">   <html:errors property="fax"/> </span></td>
			                
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Website:</td>
			                    <td align="left" valign="middle"><html:text property="webSite" onkeyup="hidetext('webSite')"  styleClass="restaurant_input"></html:text>
			                        <span  class="red_text" id="webSite">  &nbsp;  </span>
			                         
			                       </td>
			                 
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Starting Price<span class="red_text">*</span>: $</td>
			                    <td align="left" valign="middle"><html:text property="priceStartRate" onkeyup="hidetext('priceStartRate')"   styleClass="restaurant_input"></html:text>
			                     <span  class="red_text" id="priceStartRate">    <html:errors property="priceStartRate"/></span></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="middle" class="bla_low">Ending Price<span class="red_text">*</span>: $</td>
			                    <td align="left" valign="middle"><html:text property="priceEndRate" onkeyup="hidetext('priceEndRate')"   styleClass="restaurant_input"></html:text>
			                         <span  class="red_text" id="priceEndRate"><html:errors property="priceEndRate"/></span></td>
			                  </tr>
			                  
			                  <tr>
			                    <td align="right" valign="top" class="bla_low">Dining Style<span class="red_text">*</span>:</td>
			                    <td align="left" valign="top" class="text_h9"> <html:errors property="diningStylePreferences"/><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <c:if test="${not empty dropDownList.diningStyles}">
																	<c:forEach var="cusineType" items="${dropDownList.diningStyles}" varStatus="status">
																	<c:set var="flag" value="notok" ></c:set>	
																		<c:forEach var="dList" items="${locationForm.diningStylePreferences}" varStatus="status1">
			                        		                        		<c:if test="${cusineType.diningStyleId eq dList}">
									                        				<c:set var="flag" value="ok" ></c:set>		
									                        			</c:if>
									                        			  	</c:forEach>	
																		<c:if test="${status.index %3 eq 0}">
																			<tr>
																		</c:if>
																		<td align="left" valign="middle">
																		
																			<c:if test="${flag eq 'ok'}">
							                        			<input type="checkbox" name="diningStylePreferences"  value="${cusineType.diningStyleId }" checked="true" />${cusineType.diningStyleName }	  
																	</c:if>
							                        	  			<c:if test="${flag eq 'notok'}">
							                        			<input type="checkbox" name="diningStylePreferences"  value="${cusineType.diningStyleId }"  />${cusineType.diningStyleName }	  
														 		</c:if>
																		 </td>
																		<c:if test="${status.index %3 eq 2}">
																			</tr>
																		</c:if>
																	</c:forEach>
																</c:if>
			                    </table></td>
			                  </tr>
			                  <tr>
			                    <td align="right" valign="top" class="bla_low">Cuisine Type<span class="red_text">*</span>:</td>
			                    <td align="left" valign="top" class="text_h9">    <span  class="red_text" id="preferencesList"> <html:errors property="preferencesList"/></span><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			                     
			                  
			                        <c:if test="${not empty dropDownList.cusineTypes}">
																	<c:forEach var="cusineType" items="${dropDownList.cusineTypes}" varStatus="status">
																	<c:set var="flag" value="notok" ></c:set>	
																		<c:forEach var="pList" items="${locationForm.preferencesList}" varStatus="status1">
			                        		                        		<c:if test="${cusineType.cuisineTypeId eq pList}">
									                        				<c:set var="flag" value="ok" ></c:set>		
									                        		</c:if>
									                        			  	</c:forEach>	
																		<c:if test="${status.index %3 eq 0}">
																			<tr>
																		</c:if>
																		<td align="left" valign="middle">
																					
															<c:if test="${flag eq 'ok'}">
							                        			<input type="checkbox" name="preferencesList"  value="${cusineType.cuisineTypeId }" checked="true" />${cusineType.type }	  
															</c:if>
							                        	  	<c:if test="${flag eq 'notok'}">
							                        			<input type="checkbox" name="preferencesList"  value="${cusineType.cuisineTypeId }"  />${cusineType.type }	  
														 </c:if>
														 </td>
																		<c:if test="${status.index %3 eq 2}">
																			</tr>
																		</c:if>
																	</c:forEach>
																</c:if>
			                    </table></td>
			                  </tr>
			                  <tr>
			                    <td height="40" colspan="2" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <tr>
			                        <td><div id="select_hot"><a href="manageLocations.do">Cancel</a></div></td>
									<td><div id="select_hot"><a href="createLocation.do">Reset</a></div></td>
									<td><div id="submitId"><html:submit styleId="submitID" styleClass="but_img" onclick="check1()">Save</html:submit></div></td>
									</tr>
			                    </table></td>
			                  </tr>
			                  <tr>
			                    <td height="40" colspan="2" align="center" valign="middle" class="text_h10"> 
			                   
			                  Saving your information. Please be patient as it can take a few moments to upload the image and save them
			                  </td></tr>
			                </table></td>
			                <td width="8" background="../images/8.png"></td>
			              </tr>
			              <tr>
			                <td height="8" background="../images/3.png"></td>
			                <td height="8" background="../images/6.png"></td>
			                <td height="8" background="../images/4.png"></td>
			              </tr>
			            </table></html:form>
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