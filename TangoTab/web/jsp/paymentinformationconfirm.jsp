<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
	<%@ include file="consumer_imports.jsp"%>
	<script language="javascript">
	
	function submitback()
	{
	document.frm.action="createDeal.do";
	document.frm.submit();
	}
	function submitloca()
	{
	document.frm.action="locationinformation.jsp";
	document.frm.submit();
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
							
			    <table width="968" border="0" cellspacing="0" cellpadding="0">
			      <%@ include file="client_banner.jsp" %>
			      <% // include file=client_menujsp %>
			      
							<tr>
								<td height="17" colspan="3" align="center" valign="top">
    <table width="968" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="3" align="center" valign="top"> </td>
      </tr>
      <tr>
        <td height="6" colspan="3" align="left" valign="top">
        	<input type="hidden"  name="invoiceId" value="${param.x_invoice_num }"/>
        	<input type="hidden"  name="amount" value="${param.x_amount}" />
        	<input type="hidden"  name="acNo" value="${param.x_account_number }"/>
        	<input type="hidden"  name="quantity" value="${param.qty }"/>
        </td>
      </tr>
      <tr>
        <td height="17" colspan="3" align="center" valign="top">
        
     <table width="968" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td background="../images/1.png"></td>
            <td width="729" height="8" background="../images/5.png"></td>
            <td background="../images/2.png"></td>
          </tr>
          <tr>
            <td width="8" background="../images/7.png"></td>
            <td height="100" align="center" valign="top">
            <form name="frm" method="post">	
            <table width="935" border="0" cellpadding="0" cellspacing="8">
                <tr>
                  <td height="30" colspan="4" align="center" valign="middle" class="red_max">${responsetext}
                  </td>
                </tr>
                <tr>
                  <td height="12" colspan="4" align="left" valign="top" class="td_bg"></td>
                </tr>
                <tr>
                  <td height="28" colspan="4" align="left" valign="top" class="text_h9">You may print this receipt page for your records.</td>
                </tr>
               
                <tr>
                  <td height="26" colspan="4" align="left" valign="middle" bgcolor="#a2dae4" class="text_h3">&nbsp;Order Information</td>
                </tr>
                <tr>
                  <td colspan="4" align="left" valign="top" class="td_bg"></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Date/time:</td>
                  <td width="63%" colspan="3" align="left" valign="middle" class="bla_low">${startdate}</td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Transaction number:</td>
                  <td colspan="3" align="left" valign="middle" class="bla_low"> ${transid}</td>
                </tr>
              <!--  <tr>
                  <td align="right" valign="top" class="bla_low">Authorization Code:</td>
                  <td colspan="3" align="left" valign="top" class="bla_low">${autid}</td>
                </tr>-->
                  <tr>
                        <td width="150" height="35" align="right" valign="middle" class="text_h3">Total:</td>
                        <td align="left" valign="middle" class="text_h3">$ ${amount} USD</td>
                      </tr>
                <c:if test="${enteredlocations eq 0}">
                 <tr>
                  <td height="26" colspan="4" align="center" valign="middle" class="red_max">&nbsp;Your account is fully created. <br/>You must now add restaurant locations before you can start to create and publish deals</td>
                 </tr>   
                </c:if> 
                
                <tr>
                  <td height="40" colspan="4" align="center" valign="middle">
                  <table width="280" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="120" align="center" valign="middle"><div id="select_hot" ><input type="button" onclick="window.print()" class="but_max1" value="Print"/></div></td>
                        <c:if test="${enteredlocations eq 0}">
                        <td align="center" valign="middle"><div id="select_hot"> 
                         <!--                <input type="button" value="Add Location" class="but_max1"  onclick="submitloca();"/>-->
                        <sslext:link forward="unsecurecreateLocation" styleClass="but_max1">Add Location</sslext:link> 
                         </div></td>
                        </c:if>
                           <c:if test="${enteredlocations ne 0}">
                        <td align="center" valign="middle"><div id="select_hot"> 
                        <sslext:link forward="unsecureCreateDeal" styleClass="but_max1" >Create Deal</sslext:link> 
                        </div></td>
                        </c:if>
                     
                         
                         
                      </tr>
                  </table></td>
                </tr>
            </table></form>
            
            </td>
            <td width="8" background="../images/8.png"></td>
          </tr>
          <tr>
            <td height="8" background="../images/3.png"></td>
            <td height="8" background="../images/6.png"></td>
            <td height="8" background="../images/4.png"></td>
          </tr>
        </table></td>
      </tr>
    </table>  
    </td></tr></table>
    
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
