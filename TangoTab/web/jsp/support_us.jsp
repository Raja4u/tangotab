<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
	<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp" %>
<link href="css/restyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/scrollend.js"></script>
<link href="css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>

</head>

<body>
<div id="wrap">
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
  
  
  
  
  
  
    
        <html:form action="/jsp/support" method="post">
       <h1>Support</h1>
           
                     <div class="form_txt">
                        <logic:messagesPresent message="true">
														<html:messages id="message" message="true">
															<logic:present name="message">
																<div>
																		<FONT color="red"> <bean:write name="message"
																				filter="false" /> </FONT>
																		
																	
																</div>
															</logic:present>
														</html:messages>
						</logic:messagesPresent>
                      </div>
          <h2>Contact Customer Care</h2><div>
              <img src="../images/support_img.jpg" width="302" height="194" align="right" /></div>
            
            <div><p>Contact Email<span class="red_text">*</span>:</p></div>
                 <div>
                   <html:text property="emailId" readonly="readonly" styleClass="restaurant_input substxt" styleId="emailId" value="" >${userInfo.emailId}</html:text>
                   <span  class="red_text" id="fname"><html:errors property="emailId" /></span></td>
                </div>
             
               <div><p>Subject:</p></div>
                  <div>
                   <html:text property="subject" styleClass="restaurant_input substxt" styleId="subject" value="" ></html:text></div>
                <div><p>Description:</p></div>
                  <div>
                   <html:textarea cols="40" rows="2"  property="description" styleClass="restaurant_input stxtarea" styleId="description" value="" ></html:textarea></div>
               <div>
                <html:hidden property="roleId" styleClass="restaurant_input" styleId="roleId " value="${userInfo.roleId}" ></html:hidden>
                </div>
                  
                    <div id="select_hot"><html:submit styleId="submit" styleClass="but_img">Send</html:submit></div>
                      
                     
            </html:form>
            
            
            
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
</div>		       
</div>      

</body>
</html>