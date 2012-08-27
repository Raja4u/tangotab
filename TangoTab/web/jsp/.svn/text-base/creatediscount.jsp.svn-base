<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
 
 

<script language="javascript" type="text/javascript">
	function change_date_format(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		document.getElementById("date2").value = date_out_put;
		
	}
</script> 
 
<%@ include file="consumer_imports.jsp"%>
 
	  <script type="text/javascript" src="../js/scroll.js"></script>
	  <script type="text/javascript" src="../js/scrollend.js"></script> 
      <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
	  <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
      <link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
      <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
      <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css" />
</head>

<body>
<div id="wrapper">
	<div id="main">
<!--Header Start-->	<jsp:include page="header.jsp">
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
        <td height="6" colspan="3" align="left" valign="top"></td>
      </tr>
      <tr>
        <td height="17" colspan="3" align="center" valign="top">
        <!-- form Start-->
         <html:form action="/jsp/creditdiscount" method="POST">
                   
                  <input type="hidden" name="id" value="" />
                  <html:hidden property="restDiscountId" />
            <table width="968" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/1.png"></td>
                <td width="729" height="8" background="../images/5.png"></td>
                <td background="../images/2.png"></td>
              </tr>
              <tr>
                <td width="8" background="../images/7.png"></td>
                <td height="100" align="center" valign="top"><table width="930" border="0" align="center" cellpadding="0" cellspacing="5">
                  <tr>
                    <td height="30" colspan="2" align="center" valign="middle" class="red_max">Discount</td>
                    </tr>
                   <html:hidden property="restLocationId" value="1"/>        
		       
                  <tr>
                    <td align="right"  width="15%"  valign="middle" class="bla_low">Discount <span class="red_text">*</span>:</td>
                    <td align="left"width="38%"  valign="middle">
                        <html:text property="discountAmount"/>        
		         <html:errors  property="discountAmount" />
                    </td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">Refered by<span class="red_text">*</span>:</td>
                    <td align="left" valign="middle">
                        <html:text property="referredBy"/>        
		         <html:errors  property="referredBy" /></td>
                  </tr>
                  <tr>
                    <td align="right" valign="middle" class="bla_low">From Date<span class="red_text">*</span>:</td>
                    <td align="left" valign="middle">    <html:text styleId="startDate" property="startDate"/>        
		 <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" />
                          <html:errors  property="startDate" /></td></tr>
                  <tr>
                    <td align="right" valign="middle" class="text_formsub"><span class="bla_low">To Date</span><span class="red_text">*</span>:</td>
                    <td align="left" valign="middle"><html:text property="endDate" styleId="endDate" />        
		 
                   <img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif"   width="16" height="16" />
                          <html:errors  property="endDate" /></td>
                  </tr>

                  <tr>
                    <td align="right" valign="top" class="bla_low">Remarks:</td>
                    <td align="left" valign="middle">
                      <html:textarea property="reasonForDiscount"/>        
		         <html:errors  property="reasonForDiscount" />
                    
                    </td>
                  </tr>

                  <tr>
                    <td height="40" colspan="2" align="center" valign="middle">
                
                    
                     
                       <table width="320" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="30%" align="right" valign="middle">
                           <div id="select_hot"><html:submit  property="operation" value="save" /></div></td>
                          <td  width="10%" valign="middle">
                           <div id="select_hot"><a href="creditdiscountdisplay.do?operation=insert" >Reset</a></div></td>
                         <td  width="30%" abbr="left" valign="middle">
                           <div id="select_hot"><a href="creditdiscountdisplay.do?operation=display" >Cancel</a></div></td>
                        </tr>
                    </table>
               
                    
                    
                    </td>
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
          <!-- form End-->        </td>
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


	<script language="JavaScript1.2">
Calendar.setup({
        inputField     :    "startDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp1",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });
   
   Calendar.setup({
        inputField     :    "endDate",       // id of the input field
        ifFormat       :    "%m/%d/%Y",         //"%Y-%m-%d %H:%M:%S",       // format of the input field
        showsTime      :    false,              // will display a time selector
        button         :    "date_dtp2",   // trigger for the calendar (button ID)
        singleClick    :    true,              // double-click mode
        step           :    1,                  // show all years in drop-down boxes(instead of every other year as default)
        align          :    "right"             // alignment (defaults to "Bl")
    });
</script>


</body>
</html>
