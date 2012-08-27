<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<%@ include file="imports.jsp"%> 
<link href="css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/scrollend.js"></script>
<link href="css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>

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
  	 <div class="content_deal">
  <!-- start hrer  -->
  
  
  
  

<h1>Contact Us</h1>
           
              <div class="form_txt"><img src="../images/contactimg.jpg" width="302" height="192" align="right" /></div>
             <!--  form starts -->
             <div>
              <html:form action="/jsp/contact" method="post">
              
               <p>Please submit your  comments or requests below and
                    click the submit button to send the message.</p>
                <div>
                        <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																
																	<div>
																		<font color="green"> <bean:write name="message"
																				filter="false" /> </font>
																		
																	</div>
															</logic:present>
														</html:messages>
						</logic:messagesPresent>
                      </div>
                <div><p>Name<span class="red_text">*</span>:</p></div>
                  <div>
                  <html:text property="firstName" styleClass="restaurant_input substxt" styleId="firstName" ></html:text>
                  <span  class="red_text" id="fname"><html:errors property="firstName" /></span> </div>
                <div><p>Email<span class="red_text">*</span>:</p></div>
                  <div>
                  <html:text property="emailId" styleClass="restaurant_input substxt" styleId="emailId"  ></html:text> 
                  <span  class="red_text" id="fname"><html:errors property="emailId" /></span> </div>
               <div><p>Phone:</p></div>
                  <div>
                  <html:text property="phone" styleClass="restaurant_input substxt" styleId="phone"   onkeypress="return isNumberKey(event)"    maxlength="10" ></html:text> 
                  <span class="blue_text">Eg: 2125551212</span></td>
                </div>
                <div><p>Restaurant Name:</p></div>
                 <div>
                  <html:text property="restaurantName" styleClass="restaurant_input substxt" styleId="restaurantName" ></html:text> </div>
                <div><p>Restaurant City:</p></div>
                  <div>
                  <html:text property="restaurantCity" styleClass="restaurant_input substxt" styleId="restaurantCity" value=""  ></html:text> </div>
                <div><p>Comments/Requests:</p></div>
                  <div>
                  <html:textarea property="comments" styleClass="restaurant_input substxt" styleId="comments" value="" ></html:textarea> </div>
                <div><p>Type Of Inquiry<span class="red_text">*</span>:</p></div>
                  <div>
                  <html:select property="typeOfEnquiry" styleClass="restaurant_input" styleId="typeOfEnquiry">
                    <html:option  value="Sales Inquiry">Sales Inquiry</html:option>
                    <html:option  value="Customer Service">Customer Service</html:option>
                    <html:option  value="Billing Inquiry">Billing Inquiry</html:option>
                    <html:option  value="Technical Issues">Technical Issues</html:option>
                    <html:option  value="Web Master">Web Master</html:option>
                  </html:select>
                  <html:errors property="typeOfEnquiry" /> </div>
                
                 <div id="select_hot">
                      <html:submit styleClass="but_img" styleId="submitID1"  property="operation" value="Send" >Submit</html:submit></div>
                      <div id="select_hot">
                      <a href="contact_us.jsp"> Clear</a></div>
                    
              </html:form>
              </div>
             
      
  <!-- End Hrer  -->   
            
            
     </div>


</div>

            </div>
            <div class="top_bottom"><img src="../images/corner_bottom_left.jpg" align="left" /><img src="../images/corner_bottom_right.jpg" align="right" /></div>

<%@ include file="footer.jsp"%>
        </div>
    </div>
	</div>
	 </div>

</div>

<div style="clear:both;"></div>


</body>
</html>
