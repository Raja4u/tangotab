<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<sslext:pageScheme secure="false"/>   
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<%@ include file="imports.jsp"%> 
<link href="css/tangotab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/scrollend.js"></script>

<link href="css/scrollcolor.css" rel="stylesheet" type="text/css" />




<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />

<!--[if lte IE 7]>
<style type="text/css">
html .jqueryslidemenu{height: 1%;} /*Holly Hack for IE7 and below*/
</style>
<![endif]-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>

</head>

<body>
<div id="wrapper">
	<div id="main">
<!--Header Start-->
<%@ include file="header.jsp" %>
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
      <tr>
        <td width="8" height="25" align="center" valign="top" background="../images/abtgre.jpg"></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td colspan="2" align="left" valign="top" class="red_max">Affiliates<br/><br/></td>
            </tr>
            <tr>
              <td width="653" align="left" valign="top" class="text_h9">
                <p>Want a piece of the pie? TangoTab's affiliate program offers  multiple ways for you to profit from us.  </p><br/><p class="red_madium">Web Affiliate Program:  </p>
                <p align="justify">
                Each time a customer comes to us from our link on your site and purchases a deal you receive a portion of the transaction cost. </p><br/>
                <p class="red_madium">On-the-Street Affiliate Program:  </p>
                <p align="justify">Become an authorized affiliate and each time you send new restaurants our way, you receive a portion of the set up cost. 
                This is perfect if you are already selling into the restaurant industry and don't mind mentioning us in conversation.  </p>
                <p><br/>Contact TangoTab today to learn more about becoming an affiliate.</p></td>
              <td width="425" align="center" valign="top"><img src="../images/affiliates_img.jpg" width="302" height="194" /></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="15" align="center" valign="top"></td>
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
