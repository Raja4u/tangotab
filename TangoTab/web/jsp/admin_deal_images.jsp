<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="admin_imports.jsp"%>

<script type="text/javascript">
 
	function changeValue(id,val)
	{
	  if(document.getElementById(id).value == "1")
	      document.getElementById(id).value=val;
	  else 
	      document.getElementById(id).value="1";
	   	  
	}
	
	function submitForm(){
		var nameId = document.getElementById("nameId").value;
		document.forms[0].action = "viewImages.do?operation=display&nameId="+nameId;
		document.forms[0].submit();
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
   <!--	start login -->
			<table width="760" border="0" cellspacing="0" cellpadding="0" class="form_txt">			  
				<%@ include file="admin_banner.jsp" %>
			    <tr>
			        <td height="17" colspan="3" align="center" valign="top">
			        <html:form action="/jsp/viewImages" method="post" enctype="multipart/form-data">
						<!-- form Start-->
			<table width="968" border="0" cellspacing="0" cellpadding="0">
				
              <tr>
                <td background="../images/1.png"></td>
                <td width="952" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td width="952" height="100" align="center" valign="top">
                <table width="935" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">  Manage Deal Images<br></td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"><br></td>
                  </tr>
                  <tr>
                  <td  align="center" valign="top">
                  <table width="100%" border="0" cellspacing="0" align="center">
                  <tr >
                  <td align="right" width="10%" valign="middle" >
														<span class="bla_low">Deal Name<span
															class="red_text"></span>:</span>
													<br /></td>
				  <td  width="25%" align="left" valign="middle" >
														<html:select property="nameId" styleClass="restaurant_select" styleId="nameId"  onchange="submitForm()">
														    <c:forEach var="dname" items="${dealnames}">
														   		<html:option value="${dname.nameId}">${dname.name}</html:option>
															</c:forEach>
														</html:select>
													<br /></td>
                     <td width="18%" align="right" valign="middle" >
                     Upload New Image<span class="red_text">*</span>:</td>
                    
                     <td width="27%" align="left" valign="middle" ><span class="red_text">
                      <html:file  property="adminDealImage" styleClass="restaurant_input"/>
                      <html:errors property="adminDealImage" />
                      </span></td>
                    <td width="10%" align="left" valign="middle"><div id="select_hot" ><html:submit property="operation" value="Upload" styleClass="login_butgre">Upload</html:submit></div></td>
                    <td width="10%" align="left" valign="middle"><div id="select_hot" ><html:submit property="operation" value="Delete" styleClass="login_butgre">Delete</html:submit></div></td>
                 </tr>
                  </table>
                  
                  </td>
                  </tr>
                  
                  <tr>
                     
                    <td align="center" valign="top"><br/>
                        <table width="30%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
                          <c:if test="${ not empty images}">
                          <c:forEach var="img" items="${images}" varStatus="status">
                          <c:if test="${status.index %6 eq 0}">
                             <tr>
                           </c:if>
                                    <td align="left" valign="middle" class="table_dark">
                                       <img src="${img.imagePath }" width="120" height="70"/> 
                                    </td>
                                    <td align="left" valign="bottom" class="table_dark">
                                        <input type="checkbox" name="button" id="${img.imageId }" value="1" onClick="changeValue(this.id,'${img.imageId}')" ></input>
                                    </td>
                          <c:if test="${status.index %6 eq 5}">
                             </tr>
                          </c:if>
                          
                          </c:forEach>
                          </c:if>
                       
                        </table>
                      <br/><br></td>
                  </tr>
                </table><br></td>
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