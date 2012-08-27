<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tangotab.dao.pojo.BillingType"%>
<%@page import="com.tangotab.dao.pojo.CuisineType"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TangoTab </title>
<%@ include file="consumer_imports.jsp"%>
<script type="text/javascript">
	function searchMgrInfo(){
		searchType = document.getElementById("search").value;
		alert(searchType);
		document.forms[0].action = "salesMgrDisplay.do?search="+searchType;
		document.forms[0].submit();
		
	}
	
	function updateDetails(){
		document.forms[0].action = "salesMgrDisplay.do?update=manager";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div id="wrap">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="MyAccount" />
		</jsp:include> 
		<div class="content">
			<div class="insight-content">
			<table width="760" border="0" cellspacing="0" cellpadding="0">			  
				<%@ include file="admin_banner.jsp" %>
			    <tr>
			       <td height="17" colspan="3" align="center" valign="top">
			           <html:form action="/jsp/salesMgrDisplay">
			        <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top">
           
                <table width="945" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" valign="middle" class="red_max">Sales Manager Management</td>
                  </tr>
                  <tr>
                    <td height="1" align="center" valign="top" bgcolor="#B7D286"></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="5">
                        <tr>
                          <td align="right" valign="middle" class="text_formsub">&nbsp;</td>
                          <td width="300" align="right" valign="middle" class="gre_low">Search by Name:</td>
                          <td width="200" align="left" valign="middle"><input type="text" class="restaurant_input" id="search" name="search"/></td>
                          <td align="left" valign="middle"><table width="220" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><input type="button" onclick="searchMgrInfo()" value="Search"></input></div></td>
                              <td><div id="select_hot"><a href="salesMgr.do">New</a></div></td>
                            </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="100" height="26" align="right" valign="middle" class="text_h8">&nbsp;</td>
                        <td width="476" align="right" valign="middle" class="red_madium">&nbsp;</td>
                        <td width="350" align="right" valign="middle" class="blue_medium"></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><br/>
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
                          <tr>
                            <td height="24" align="left" valign="middle" class="text_h3">Sales Manager</td>
                            <td align="left" valign="middle" class="text_h3">Cities</td>
                            <td align="left" valign="middle" class="text_h3">Status</td>
                          </tr>
                          
                          <c:if test="${not empty mgrInfo}">
                          <c:forEach var="mgrSale" items="${mgrInfo}" varStatus="count">
	                          <tr>
	                            <td align="left" valign="middle" class="table_light">
	                            <input type="hidden" name="salesId" value="${mgrSale.userId}">
	                            <a href="salesRep.do?userId=${mgrSale.salasMgrUserId}&type=mgrEdit" class="bla_low"><u>${mgrSale.firstname}&nbsp;${mgrSale.lastname}</u></a></td>
	                            <td align="left" valign="middle" class="table_light">${mgrSale.citiesString }</td>
	                            <td align="left" valign="middle" class="table_light">
	                            <html:select property="activeId" styleClass="restaurant_selectmedium" styleId="select" name="mgrSale" value="${mgrSale.isActive}">
	                              <html:option value="1">Active</html:option>
	                              <html:option value="0">Inactive</html:option></html:select></td>
	                          </tr>
	                          </c:forEach>
                         </c:if>
                      </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="480" height="40" align="right" valign="middle"><table width="110" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                              <td><div id="select_hot"><input type="button" onclick="updateDetails()" value="Update"></input></div></td>
                            </tr>
                          </table></td>
                          <td align="right" valign="middle" class="blue_medium"></td>
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
               <!-- form End-->  
			         </td>
			      </tr>
			    </table>  
		    </div>
		<div style="clear:both;"></div>
		</div><!--content  end here--><div style="clear:both;"></div>
		<%@ include file="footer.jsp"%>
		<div style="clear:both;"></div>
	</div> 
</body>
</html>