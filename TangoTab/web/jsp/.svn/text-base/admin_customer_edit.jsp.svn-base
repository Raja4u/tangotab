<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
    <%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp" %>
<script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
		<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
		
		<script src="../js/Country_state.js" type="text/javascript"></script>
			<script src="../js/util.js" type="text/javascript"></script>
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
   <!--	start login -->
		  <table align="center" width="968" border="0" cellspacing="0" cellpadding="0">
		  <%@ include file="admin_banner.jsp" %>
		  <tr>
		  	<td height="17" colspan="3" align="center" valign="top">
		  	<html:form action="/jsp/adminCustEdit" method="post">
				<!-- form Start-->
				<table align="center" width="968" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td background="../images/1.png"></td>
			            <td width="949" height="8" background="../images/5.png"></td>
			            <td background="../images/2.png"></td>
			          </tr>
			          <tr>
			            <td width="8" background="../images/7.png"></td>
			            <td height="100" width="949" align="center" valign="top">
			            <table width="949" border="0" align="center" cellpadding="0" cellspacing="5">
			              <tr>
			                <td height="12" colspan="2" align="center" valign="middle" class="red_max">Edit Guest Profile</td>
			              </tr>
			              <tr>
			                <td height="10" colspan="4" align="center" valign="top" class="td_bg"></td>
			              </tr>
			              <tr>
			                <td width="22%" align="right" valign="middle" class="bla_low">First Name<span class="red_text">*</span>:</td>
			                <td width="38%" align="left" valign="middle">
							<html:text property="firstname"   styleClass="restaurant_input" ></html:text>
			                  <span  class="red_text" id="fname">   <html:errors  property="firstname" /></span>
                      		</td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Last Name<span class="red_text">*</span>:</td>
			                <td align="left" valign="middle"><html:text property="lastname"    styleClass="restaurant_input"></html:text>
			                   <span  class="red_text" id="lname">  <html:errors  property="lastname" /></span>
			                </td>
			              </tr>
			 				<tr>
			                <td align="right" valign="middle"><span class="bla_low">Email<span class="red_text">*</span></span>:</td>
			                <td align="left" valign="middle"><html:text readonly="true" property="emailId"    styleClass="restaurant_input"></html:text>
			                    <span  class="red_text" id="email">   <html:errors  property="emailId" /></span>
			                <html:hidden property="userId" ></html:hidden>
			                
			                <html:hidden  property="emailId"  value="${emailId}"  styleClass="restaurant_input"></html:hidden>
			                </td>
			                <html:hidden property="password" ></html:hidden>
			          	  <html:hidden property="question1"   styleClass="restaurant_input"/>      
			              </tr>
							<tr>
			                <td align="right" valign="middle" class="bla_low">Zip/Post Code<span class="red_text">*</span>:</td>
			                <td align="left" valign="middle"><html:text property="zipCode"  styleClass="restaurant_input"></html:text>
			                     <span  class="red_text" id="zipCode">  <html:errors  property="zipCode" /></span>
			                </td>
			              </tr>
							
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Mobile Number:</td>
			                <td align="left" valign="middle"><html:text property="mobilePhone"  styleClass="restaurant_input" ></html:text>
			                <span class="blue_text">(e.g., 2125551212)</span>
			                <span  class="red_text" id="amphone">   <html:errors  property="mobilePhone" /> </span></td>
			              </tr>
			              
			                  <tr>
			                <td align="right" valign="middle" class="bla_low">Home Phone:</td>
			                <td align="left" valign="middle"><html:text property="homePhone"    styleClass="restaurant_input" ></html:text>
			                <span  class="red_text" id="ahphone">     </span></td>
			              </tr>
			               <tr>
			                <td align="right" valign="middle" class="bla_low">Gender:</td>
			               <td align="left" valign="middle">
			               <table align="left" cellpadding="0" cellspacing="0" width="200">
			               <tr>
			                <td align="left"><html:radio property="gender"  value="${user.gender}" >Male</html:radio>
			                <html:radio property="gender"   value="${user.gender}">Female</html:radio>
			                <span  class="red_text" id="ahphone"> </span></td>
			               </tr>
			               </table>
			               </td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Age Group:</td>
			                <td align="left" valign="middle"><html:select  property="age"    onkeyup="hidetext('ahphone')"  onkeypress="return isNumberKey(event)" styleClass="restaurant_input" >
			                 <html:option value="0">select</html:option>
			                 <html:option value="1">18-25</html:option>
			                  <html:option value="1">25-35</html:option>
			                   <html:option value="2">35-50</html:option>
			                    <html:option value="3">50+</html:option>
			                </html:select>
			                <span  class="red_text" id="ahphone"></span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Street Address1:</td>
			                <td align="left" valign="middle"><html:text property="address"   styleClass="restaurant_input"></html:text>
			                   <span  class="red_text" id="amsg">  </span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Street Address2:</td>
			                <td align="left" valign="middle"><html:text property="address1"   styleClass="restaurant_input"></html:text>
			                   <span  class="red_text" id="amsg">  </span></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">City:</td>
			                <td align="left" valign="middle"><html:text property="cityId" styleClass="restaurant_select" styleId="cities"   >
                               </html:text></td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle"><span class="bla_low">State/Prov</span><span class="red_text">*</span>:</td>
			                <td align="left" valign="middle">
			                <html:select property="stateId"  styleClass="restaurant_select" styleId="states"   >
			                <html:option value="0">Select State</html:option>
			                <c:forEach var="dList" items="${dropDownList.countries}"  varStatus="status">
			                 		       		<optgroup label="${dList.countryName}">	${dList.countryName}</optgroup>
			                 		       		
			                 		<c:forEach var="dList2" items="${dropDownList.states}"  varStatus="status1">
			                 		<c:if test="${dList.countryId eq dList2.country.countryId}">
			                 			<html:option value="${dList2.stateId}">${dList2.stateName }</html:option>
			                 			</c:if>
			                 		</c:forEach>
			                 		</c:forEach>  </html:select>
			                 		<span  class="red_text" id="stateId"><html:errors property="stateId"/></span>
			                </td>
			              </tr>
			              <tr>
			                <td align="right" valign="middle" class="bla_low">Country:</td>
			                <td align="left" valign="middle"><html:select property="countryId"  styleClass="restaurant_select" styleId="countries"  >
			                <html:option value="0">Select Country</html:option>
			                <bean:define id="relationships2" name="dropDownList" property="countries" type="java.util.ArrayList"/>
			    			<html:options collection="relationships2" property="countryId" labelProperty="countryName"/>
			                </html:select></td>
			              </tr>
			              <tr>
			                  <td align="right" valign="middle" class="bla_low">Preferred City<span class="red_text">*</span>:</td>
			                  <td align="left" valign="middle" class="restaurant_select">
			                    <html:select property="preferCity"  styleClass="restaurant_select" styleId="preferCity" >
			                          <html:option value="0">Select City</html:option>
			                          <bean:define id="relationships2" name="dropDownList" property="cities" type="java.util.ArrayList"/>
			                          <html:options collection="relationships2" property="cityId" labelProperty="cityName"/>
			                   </html:select>
			                   <html:errors property="preferCity" />	 </td>
			             </tr>
			             <tr> 
			                    <td align="right" valign="middle" class="bla_low">Change password</td>
			                    <td align="left" valign="middle"><a href="passwordForwardAction.do?userId=${admincustForm.userId}"  ><u class="red_text">Change password</u></a>
			                        &nbsp;
                                </td>
			                  </tr>
			              <tr>
			                <td align="right" valign="top" class="bla_low">Preferences:</td>
			                <td align="left" valign="top" class="text_h9">
			                <table  align="left"  border="0"  cellspacing="0" cellpadding="0" >
			             
			                <c:forEach var="cuisine" items="${dropDownList.cusineTypes}" varStatus="status">
			                           <c:set var="flag" value="notok" ></c:set>
			                   <c:forEach var="plist" items="${user.preferencesList}" varStatus="status1">
			                      <c:if test="${cuisine.cuisineTypeId eq plist}">
									   <c:set var="flag" value="ok" ></c:set>	
									  
								  </c:if>
			                   </c:forEach>
			                   <c:if test="${status.index %3 eq 0}">
								<tr>
								</c:if>
                                  <td align="left" valign="middle">
                                  
			                <c:forEach var="pList" items="${admincustForm.preferencesList}" varStatus="status1">
			                        		                         	<c:if test="${cuisine.cuisineTypeId eq pList}">
									                        				<c:set var="flag" value="ok" ></c:set>	
									                        			 
									                        		</c:if>
									                        			  	</c:forEach>	
									<c:if test="${flag eq 'ok'}">
										<input type="checkbox" name="preferencesList" value="${cuisine.cuisineTypeId }" checked="true" />${cuisine.type }	  
									</c:if>
									<c:if test="${flag eq 'notok'}">
										<input type="checkbox" name="preferencesList" value="${cuisine.cuisineTypeId }" />${cuisine.type }	  
									</c:if>
								 </td>
								  <c:if test="${status.index %3 eq 2}">
									</tr>
								 </c:if>
			                  </c:forEach>
			                 </table>
			                </td>
			              </tr>
			            
			              <tr>
			                <td height="45" colspan="2" align="center" valign="middle"><table width="330" border="0" align="center" cellpadding="0" cellspacing="0">
			                  <tr>
			                    <td align="right"><div id="select_hot"><html:submit styleClass="but_img" styleId="submitID">Update</html:submit></div></td>
			                     <td> <div id="select_hot"><a href="viewCustomerMgmt.do?operation=display">Cancel</a></div></td>
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