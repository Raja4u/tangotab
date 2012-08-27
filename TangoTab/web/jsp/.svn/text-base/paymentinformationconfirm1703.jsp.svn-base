<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>

<link href="http://50.17.229.179:8080/TangoTab/css/paymenttangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://50.17.229.179:8080/TangoTab/js/scroll.js"></script>
<script type="text/javascript" src="http://50.17.229.179:8080/TangoTab/js/scrollend.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="http://50.17.229.179:8080/TangoTab/js/jqueryslidemenu.js""></script>
</head>
<body>
<br></br><br></br>
<form  action="http://50.17.229.179:8080/TangoTab/jsp/viewDeals.do">

<!--Header Start-->
    
<!--Header End here-->
<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
<tr><td align="center" >
<table width="968" align="center" border="0" cellspacing="0" cellpadding="0" >
       <tr>
	       
	        <td height="75" align="center" valign="middle" bgcolor="#7d9b17" class="white_max1">Tango Tab</td>
	        
	      </tr>
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
     <fieldset>   
     <table width="968" border="0" cellspacing="0" cellpadding="0">
          <tr>
            
            <td height="100" align="center" valign="top">
            <table width="935" border="0" align="center" cellpadding="0" cellspacing="8">
                <tr>
                  <td height="30" colspan="4" align="center" valign="middle" class="red_max">${param.x_response_reason_text}
                  </td>
                </tr>
                <tr>
                  <td height="12" colspan="4" align="left" valign="top" class="td_bg"></td>
                </tr>
                <tr>
                  <td height="28" colspan="4" align="left" valign="top" class="text_h9">You may print this receipt page for your records.</td>
                </tr>
                <tr>
                  <td height="26" colspan="4" align="left" valign="middle" bgcolor="#a2dae4" class="text_h3">&nbsp;&nbsp;&nbsp;Order Information</td>
                </tr>
                <tr>
                  <td colspan="4" align="left" valign="top" class="td_bg"></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Invoice number: </td>
                  <td width="63%" colspan="3" align="left" valign="middle" class="bla_low">${param.x_invoice_num}</td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Description:</td>
                  <td colspan="3" align="left" valign="middle" class="bla_low"> ${param.x_description}</td>
                </tr>
                
                <tr>
                  <td colspan="4" align="left" valign="middle" class="td_bg"></td>
                </tr>
                <tr>
                  <td colspan="4" align="left" valign="middle" class="td_bg"></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">&nbsp;</td>
                  <td height="45" colspan="3" align="right" valign="middle" class="bla_low"><table width="300" border="0" align="right" cellpadding="0" cellspacing="5">
                      <tr>
                        <td width="150" height="35" align="right" valign="middle" class="text_h3">Total:</td>
                        <td align="left" valign="middle" class="text_h3">${param.x_amount}</td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="26" colspan="4" align="left" valign="middle" bgcolor="#a2dae4" class="text_h3">&nbsp;Order Information</td>
                </tr>
                <tr>
                  <td colspan="4" align="left" valign="top" class="td_bg"></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Date/time:</td>
                  <td width="63%" colspan="3" align="left" valign="middle" class="bla_low"></td>
                </tr>
                <tr>
                  <td align="right" valign="middle" class="bla_low">Transaction number:</td>
                  <td colspan="3" align="left" valign="middle" class="bla_low"> ${param.x_trans_id}</td>
                </tr>
                <tr>
                  <td align="right" valign="top" class="bla_low">Authorization Code:</td>
                  <td colspan="3" align="left" valign="top" class="bla_low">${param.x_auth_code}</td>
                </tr>
                
                <tr>
                  <td height="40" colspan="4" align="center" valign="middle">
                  <table width="220" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        
                       <td align="center" bgcolor="#e8740e" width="300">
                       <table width="300" border="0" cellspacing="1" cellpadding="0">
                         <tr>
                         <td width="150" align="left" valign="35">                     
                        <input type="button" onclick="window.print()" value="Print" class="but_imgmax"  /></td>
                        <td width="150"><input type="submit" value="Back To TangoTab" class="but_imgmax" /></td>
                         </tr>
                       </table>
                        </td>
                      </tr>
                  </table>
                  </td>
                </tr>
            </table>
            </td>
           </tr>
         
        </table>
        </fieldset></td>
      </tr>
    </table>  
    </td></tr>
    </table>

</form>
</body>
</html>
