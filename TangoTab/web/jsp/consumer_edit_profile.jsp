<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.tangotab.TO.DropDownTO"%>
<%@page import="com.tangotab.TO.UserTO"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
    <%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
    <%@  page import="com.tangotab.dao.pojo.CuisineType" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@  page import="com.tangotab.web.form.UserForm,java.util.Iterator,java.util.List" %>
<c:if test="${empty userInfo}">
<% response.sendRedirect("login.jsp");%>
  </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>

<script type="text/javascript">
function getName(id){
var name = document.getElementById(id).options[document.getElementById(id).selectedIndex].text;

document.getElementById("hname").value = name;

}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="Login" />
		</jsp:include> 
		
		<!--Header End here-->
	
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   
     <div class="inner_cantainer">
            <div class="main_deal">
  
  <div class="top_header"><img src="../images/corner_left.jpg" align="left" /><img src="../images/corner_right.jpg" align="right" /></div> 
  	 <div class="content_deal_inner">
  	 
  	 
  	 <!-- start here  -->
		
		
	
		  <table width="950" border="0" cellspacing="0" cellpadding="0" class="form_txt">
		  <%@ include file="consumer_banner.jsp" %>
		  <tr>
		  	<td height="17" colspan="3" align="center" valign="top">
				<!-- form Start-->
				<c:if test="${not empty userInfo}">
				<html:form action="/jsp/consumerUpdate">
				<table width="955" border="0" cellspacing="0" cellpadding="0" style="color:#000000;">
			          <tr>
			            <td background="../images/1.png"></td>
			            <td width="949" height="8" background="../images/5.png"></td>
			            <td background="../images/2.png"></td>
			          </tr>
			          <tr>
			            <td width="8" background="../images/7.png"></td>
			            <td height="100" align="center" valign="top"><table width="740" border="0" align="center" cellpadding="0" cellspacing="5">
			         
			                 
			                 <tr>
			                <td height="12" colspan="2" align="center" valign="middle" class="red_max">
			                <c:if test="${empty userInfo.address1 || empty userInfo.address || empty userInfo.mobilePhone 
			                 || empty userInfo.homePhone  || empty userInfo.gender  || empty userInfo.age  
			                 || empty userInfo.cityId  || empty userInfo.stateId  || empty userInfo.countryId  || 
			                 empty userInfo.preferencesList   
			                 ||  empty userInfo.consumerPreferCity ||  userInfo.consumerPreferCity.city.cityId eq 0}" > 
			                Please complete your profile so we can better match the Offers to your preferences!			                </c:if>
			                <c:if test="${not empty userInfo.address1 and not empty userInfo.address  and not empty  userInfo.mobilePhone 
			                  and not empty userInfo.homePhone   and not empty  userInfo.gender   and not empty  userInfo.age  
			                 and not    empty userInfo.cityId   and not    empty userInfo.stateId   and not empty   userInfo.countryId   
			                 and not empty   userInfo.preferencesList and not  empty userInfo.consumerPreferCity and    userInfo.consumerPreferCity.city.cityId ne 0}" > Member Profile</c:if>			                </td>
			              </tr>
			              
			                 <tr>
			                   <td align="right" valign="middle" class="bla_low">&nbsp;</td>
			                   <td align="left" valign="middle">&nbsp;</td>
			                   </tr>
			                 <tr>
			                <td width="300" align="right" valign="middle" class="bla_low">First Name <span class="red_text">*</span>:</td>
			                <td align="left" valign="middle">
							<html:text property="firstname" name="userInfo"   onkeyup="hidetext('fname')" styleClass="restaurant_input substxt"></html:text>
			                  <span  class="red_text" id="fname">   <html:errors  property="firstname" /></span>									</td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Last Name <span class="red_text">*</span>:</td>
			                <td align="left" valign="middle"><html:text property="lastname" name="userInfo"   onkeyup="hidetext('lname')"  styleClass="restaurant_input substxt"></html:text>
			                   <span  class="red_text" id="lname">   <html:errors  property="lastname" /></span>
			                   <html:hidden property="refferedUrl"  name="userInfo"  ></html:hidden>
			  <html:hidden property="password"  value="12345678"  styleClass="restaurant_input"></html:hidden>
			       <html:hidden property="cpassword" value="12345678"  styleClass="restaurant_input"></html:hidden></td>
			              </tr>
			 				<tr>
			                <td align="right" valign="middle"><span class="bla_low">Email<span class="red_text"> *</span></span>:</td>
			                <td align="left" valign="middle"><html:text readonly="true" property="emailId" name="userInfo"   onkeyup="hidetext('email')"  styleClass="restaurant_input substxt"></html:text>
			                <html:hidden property="emailId" name="userInfo"   onkeyup="hidetext('email')"  styleClass="restaurant_input"></html:hidden>
			                  <span  class="red_text" id="email">    <html:errors  property="emailId" /></span>			                </td>
			              </tr>
							<tr>
			                <td align="right" valign="middle" class="bla_low">Zip/Post Code <span class="red_text">*</span>:</td>
			                <td align="left" valign="middle"><html:text property="zipCode"   onkeyup="hidetext('zipCode')"  name="userInfo" styleClass="restaurant_input substxt"></html:text>
			            <span  class="red_text" id="zipCode">           <html:errors  property="zipCode" /></span>			                </td>
			              </tr>
							
							 
			              <tr> 
			                <td align="right" valign="middle" class="bla_low">Mobile Number :</td>
			                <td align="left" valign="middle">
			                    <c:if test="${empty userInfo.mobilePhone}">
			                <html:text property="mobilePhone"   onkeyup="hidetext('amphone')" styleClass="substxt " onkeypress="return isNumberKey(event)"></html:text>
			                </c:if>
			                    <c:if test="${not empty userInfo.mobilePhone}">
			                     <html:text property="mobilePhone" name="userInfo"   maxlength="10" onkeyup="hidetext('amphone')"  styleClass="restaurant_input substxt" onkeypress="return isNumberKey(event)"  ></html:text>
			                    </c:if>
			              <span  class="red_text" id="amphone">   <html:errors  property="mobilePhone" /> </span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Home Phone :</td>
			                
			                <td align="left" valign="middle">
			                     <c:if test="${empty userInfo.homePhone}">
			           		  <html:text property="homePhone"  onkeyup="hidetext('ahphone')"  onkeypress="return isNumberKey(event)" styleClass="restaurant_input substxt" ></html:text>
			                </c:if>
			                    <c:if test="${not empty userInfo.homePhone}">
			                    <html:text property="homePhone"   name="userInfo"  onkeyup="hidetext('ahphone')"  onkeypress="return isNumberKey(event)" styleClass="restaurant_input substxt" ></html:text>
			                    </c:if>
			                <span  class="red_text" id="ahphone">     <html:errors  property="homePhone" /></span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Gender :</td>
			               <td align="left" valign="middle">
			               <table align="left" cellpadding="0" cellspacing="0" width="200">
			               <tr>
			                <td align="left">
			                          <c:if test="${empty userInfo.gender}">
			                        
			                <html:radio property="gender"  value="male" >Male</html:radio>
			                <html:radio property="gender"   value="female" >Female</html:radio>
			                </c:if>
			                    <c:if test="${not empty userInfo.gender}">
			                              
			                <html:radio property="gender" name="userInfo" value="male" >Male</html:radio>
			                <html:radio property="gender" name="userInfo"  value="female" >Female</html:radio>
			                    </c:if>
			          
			                <span  class="red_text" id="ahphone"> </span></td>
			               </tr>
			               </table>			               </td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Age Group :</td>
			                <td align="left" valign="middle">
			               <c:if test="${userInfo.age eq 0}">
			                       <html:select  property="age"    onkeyup="hidetext('ahphone')"  onkeypress="return isNumberKey(event)" styleClass="listboxeffect" >
			                 <html:option value="0">select</html:option>
			                 <html:option value="1">18-25</html:option>
			                  <html:option value="1">25-35</html:option>
			                   <html:option value="2">35-50</html:option>
			                    <html:option value="3">50+</html:option>
			                </html:select>
			                </c:if>
			                        <c:if test="${userInfo.age ne 0}">
			                     <html:select  property="age" name="userInfo"   onkeyup="hidetext('ahphone')"  onkeypress="return isNumberKey(event)" styleClass="listboxeffect" >
			                 <html:option value="0">select</html:option>
			                 <html:option value="1">18-25</html:option>
			                  <html:option value="1">25-35</html:option>
			                   <html:option value="2">35-50</html:option>
			                    <html:option value="3">50+</html:option>
			                </html:select>
			                    </c:if>
			       
			                
			                <span  class="red_text" id="ahphone"></span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Street Address1 :</td>
			                <td align="left" valign="middle">
			                <c:if test="${empty userInfo.address}">
			                <html:text property="address"    styleClass="restaurant_input substxt"></html:text>
			                </c:if>
			                     <c:if test="${not empty userInfo.address}">
			                <html:text property="address"      name="userInfo"       styleClass="restaurant_input substxt"></html:text>
			                </c:if>
			                   <span  class="red_text" id="amsg">  <html:errors  property="address" /></span></td>
			              </tr>
			              
			                  <tr>
			                <td align="right" valign="middle" class="bla_low">Street Address2 :</td>
			                <td align="left" valign="middle">
			                     <c:if test="${empty userInfo.address1}">
			                <html:text property="address1"       styleClass="restaurant_input substxt"></html:text>
			                </c:if>
			                     <c:if test="${not empty userInfo.address1}">
			                <html:text property="address1"     name="userInfo"     styleClass="restaurant_input substxt"></html:text>
			                </c:if>
			                   <span  class="red_text" id="amsg"> </span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">City :</td>
			                <td align="left" valign="middle">
			                          <c:if test="${empty userInfo.cityId}">
 		              <html:text property="cityId" styleClass="restaurant_input substxt" styleId="cities"  />
			                </c:if>
			                    <c:if test="${not empty userInfo.cityId}">
			                          <html:text property="cityId" styleClass="restaurant_input substxt" styleId="cities" name="userInfo" />
			                    </c:if>                            </td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle"><span class="bla_low">State</span> :</td>
			                <td align="left" valign="middle">
			              <c:if test="${userInfo.stateId eq 0}">
			                 <html:select property="stateId"  styleClass="listboxeffect" styleId="states"   >
			                <html:option value="0">Select State</html:option>
			              <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach>   </html:select>
			                </c:if>
 
			                       <c:if test="${userInfo.stateId ne 0}">
			                       <html:select property="stateId"  styleClass="listboxeffect" styleId="states"  name="userInfo" >
			                <html:option value="0">Select State</html:option>
			              <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach>   </html:select>
			                    </c:if>			             </td>
			              </tr>
			       
			                     <tr>
			                <td align="right" valign="middle" class="bla_low">Country :</td>
			                <td align="left" valign="middle">
			                          <c:if test="${userInfo.countryId eq 0}">
			                 <html:select property="countryId"  styleClass="listboxeffect" styleId="countries" >
			                <html:option value="0">Select Country</html:option>
			                <bean:define id="relationships2" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships2" property="countryId" labelProperty="countryName"/>
			                </html:select>
			                </c:if>
			                    <c:if test="${userInfo.countryId ne 0 }">
			                         <html:select property="countryId"  styleClass="listboxeffect" styleId="countries" name="userInfo" >
			                <html:option value="0">Select Country</html:option>
			                <bean:define id="relationships2" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships2" property="countryId" labelProperty="countryName"/>
			                </html:select>
			                    </c:if>			               </td>
			              </tr>
			              
			                        <tr>
			                <td align="right" valign="middle" class="bla_low">Preferred City<span class="red_text">* </span>:</td>
			                <td align="left" valign="middle">
			                   <c:if test="${empty userInfo.consumerPreferCity}">
			              <html:select property="preferCity"  styleClass="listboxeffect" styleId="preferCity1"  value="${userForm.preferCity}" onchange="getName(this.id);">
			                <html:option value="">Select City</html:option>
			                <bean:define id="relationships2" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    			<html:options collection="relationships2" property="cityId" labelProperty="cityName"/>
			                </html:select>
			                </c:if>
			                    <c:if test="${not empty userInfo.consumerPreferCity}">
			                    <html:select property="preferCity"  styleClass="listboxeffect" styleId="preferCity2"  value="${userInfo.consumerPreferCity.city.cityId}" onchange="getName(this.id);">
			                <html:option value="0">Select City</html:option>
			                <bean:define id="relationships2" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			    			<html:options collection="relationships2" property="cityId" labelProperty="cityName"/> 
			                </html:select>
			                    </c:if> 
			                    <html:errors property="preferCity" />			                    </td>
			                    
			                    <input type="hidden" id="hname" name="hname" value=""/>
			              </tr>
			              
			              <tr>
			                <td align="right" valign="top" class="bla_low">Preferred Cuisines :</td>
			                <td align="center" valign="top" class="text_h9"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			            
			                    <%
									CuisineType cuisineType=new CuisineType();
									List<CuisineType>  list=( List<CuisineType>)( (DropDownTO)application.getAttribute("dropDownList")).getCusineTypes();
									Iterator<CuisineType> it= list.iterator();
									int[] preferencesList = ((UserTO)session.getAttribute("userInfo")).getPreferencesList();
									if(request.getAttribute("userForm")!=null  )
									{
									 UserForm  userForm=(UserForm)request.getAttribute("userForm");
									 if(userForm.getPreferencesList()!=null)
			                    	 preferencesList=userForm.getPreferencesList();
									}
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
										if(preferencesList !=null && preferencesList.length >0){
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
								<%  } }
								%>
			                </table></td>
			              </tr>
			              <tr>
			                <td height="45" valign="middle"></td>
			                <td height="45" valign="middle">
							<table width="330" border="0" cellpadding="0" cellspacing="0">
			                  <tr>
			                     <!--<td align="left"><div id="select_hot"><a href="searchForward.do" id="searchdeals" title="Search Deals">Skip</a></div></td>
			                     --> <td align="left"><div id="select_hot"><html:submit styleClass="but_img" styleId="submitID">Update</html:submit></div></td>
									<td align="right"><div id="select_hot"><a href="search.do">Cancel</a></div></td>
			                    			                   
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
					</table></html:form>
						</c:if>
				<!-- form End-->
				</td>
		      </tr>
		    </table>
		 
		
	

	
	
	
	<!-- end here  -->
						
   
   
   </div>
   <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

</div>

            </div>
         


<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div> 
</body>
</html>