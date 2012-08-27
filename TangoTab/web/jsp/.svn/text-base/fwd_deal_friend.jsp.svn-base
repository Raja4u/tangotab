<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="tangotab"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title>
<link href="../css/restyle.css" rel="stylesheet" type="text/css" />
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<link href="../css/bookdealpopover.css" rel="stylesheet" type="text/css" />
<!--
<script type="text/javascript" src="../js/scroll.js"></script>
<script type="text/javascript" src="../js/scrollend.js"></script>-->
<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
<style >
 

		.mediumblack 	{ font-family:Arial, Helvetica, sans-serif; color:#000000; font-size:14px; }
		.normalblack {color: #000000}
		/*------invite------*/
.invite_frd_head{font-size:24px; color:#000;}
.invite_frd_text{font-size:18px; color:#000;}
.invite_frd_orange{color:#f57e20; font-size:18px;}
.invite_frd_green{color:#81943a; font-size:18px;}
.invite_frd_green a{color:#81943a; font-size:18px;text-decoration:none;}
.invite_frd_textarea{border: solid 5px #d6d7d8; height:285px; width:232px; color:#9d9d9d; font-size:18px; padding:5px; font-family:Arial, Helvetica, sans-serif; margin:0px;}
.invite_frd_emailtext{color:#000; font-size:16px; background:#d6d7d8; padding:10px;}
			</style>
			
<script type="text/javascript" language="javascript">
 function submitt(){
 var data = document.getElementById("emails").value;
// alert(data);
     //document.forms[0].action = "../jsp/referralDeal.do?dealId=${dealId}";
     //document.forms[0].submit();
     if(  data == null || data == '' || data.charAt(data.length-1) == ','  ){
      document.getElementById('error').innerHTML = 'please refer atleast one friend';
        return false;
     }else {  
     document.getElementById('error').innerHTML = ''; 
     
     if( validateEmail(document.getElementById("emails").value.split(",")[0]) ){
     document.refferalForm.action='../jsp/referralDeal.do?dealId=${dealId}';
     document.refferalForm.submit();
       return true;
       }else 
       {
       document.getElementById('error').innerHTML = 'Invalid Email Address';
       return false;
       }
       }
 }
 
 function validateEmail(email) {
 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   var address = email;
   if(reg.test(address) == false) {
 	return false;   
   
   }else 
    return true;
} 
 function runScript(evt) {
 var data = document.getElementById("emails").value;
                
        var charCodes = (evt.which) ? evt.which : event.keyCode
        // alert(data.charAt(data.length-1));
        if (charCodes == 13) {
            //code to execute here
            if( !( data == null || data == '' || data.charAt(data.length-1) == ',')  ){              
             document.getElementById("emails").value = document.getElementById("emails").value + ",";
             data = null;
            }
           
        }
        
    }
 
</script>
<script type="text/javascript" language="javascript">
function showEmail(){
document.getElementById('popupContactdeal').style.display = 'block';
document.getElementById('backgroundPopupdeal').style.display = 'block';

}

function close(){

document.getElementById('popupContactdeal').style.display='none';
document.getElementById('backgroundPopupdeal').style.display='none';
}

</script>
<style type="text/css">
#popupContactdeal{

position:fixed;
left:25%;
top:30%;
z-index:6;
height:200px;
width:408px;
background:#FFFFFF;
border:5px solid #888;
z-index:40;
margin-left:300;
padding:0px;
color:#888;
font-size:18px;
text-align:center;
}
.title_bar{margin:0px;
padding: 3px 0px 0px 10px;
width:398px;
background:none;
color:#424242;
height:20px;
text-align:left;
font-size:13px;
font-weight: bold;
}
</style>
</head>
<body>

		<div id="popupContactdeal" style="display:none">
			<span style="position: absolute;    right: -11px;    top: -11px;"> <a
				id="popupContactClose" href="javascript:close();"> <img src="../images/x.png" border="0"/> </a> </span>
			<div class="title_bar" style="padding: 13px 0px 0px 10px;">
				subject: I love TangoTab and think you will too.
			</div>			
			<div class="title_bar">
			Hello<BR/>
				I thought you might like TangoTab.
	 It is a new, free service where you can find great restaurant deals and feed people in need just by dining out.
	 <br/><img src="../images/fb.png" border="0" width="200" height="70" style="margin:10px 0" />
	
			</div>
			<p id="contactArea">
				
			</p>
		</div>
		<div id="backgroundPopupdeal" style="display:none">
		</div>
		
		<div id="wrapper">
		<div id="main">
	 <jsp:include page="header.jsp">
			<jsp:param name="currentPage" value="" />
		</jsp:include> 
		
		<!--Header End here-->
		
		
	<div class="cantainer_inner">
      <div class="main_cantainer">
   <div class="cantainer_content">
   	
  <!-- start here -->
  <html:form action="/jsp/referralDeal.do?dealId=${dealId}" method="post" onsubmit="return submitt();" >
    <html:hidden property="dealId" value="${dealId}"/>
    <html:hidden property="userId" value="${userInfo.userId}" />
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top"><table width="980" border="0" cellspacing="0" cellpadding="0" align="center">    
       
       
        <tr>
        <td  align="center" valign="top"   ><img src="../images/share_banner.png"  /></td>
      </tr>
       
       <tr>
        <td height="35"  align="center" valign="top"   >&nbsp;</td>
      </tr>
       <logic:messagesPresent message="true">
																<html:messages id="message" message="true">
																	<logic:present name="message">
																		<tr>
																			<td align="center" valign="middle" colspan="2">
																				<font color="red">
																					<bean:write name="message" filter="false" />
																				</font>
																			</td>
																		</tr>
																	</logic:present>
																</html:messages>
															</logic:messagesPresent>
       <tr>
         <td  align="center" valign="top"   ><table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td width="725" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
               <tr>
                 <td><img src="../images/network_image.png"   /></td>
               </tr>
               <tr>
                 <td height="40">&nbsp;</td>
               </tr>
               <tr>
                 <td align="left"><p><span class="invite_frd_head">Imagine ending Hunger in America, by only dining out.</span><br />
                   <span class="invite_frd_text">We each have over&nbsp;600 social contacts on average.&nbsp;If you can feed 24 people a year with TangoTab, your network can feed over 16,000 and their network can feed over 10,000,000. &nbsp;Please share with your family and friends, and together we can </span><span class="invite_frd_orange">End Hunger in America!</span></p>
                   </td>
               </tr>
                <tr>
                 <td height="30">&nbsp;
                   </td>
               </tr>
               <tr>
                 <td align="left">
                   <p class="invite_frd_green" onclick="javascript:showEmail();" ><a href="#" >Click to see sample email</a></p></td>
               </tr>
             </table></td>
             <td valign="top">&nbsp;</td>
             <td width="252" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
               <tr>
                 <td class="invite_frd_emailtext" align="left">Enter up to 50 email addresses separated by a comma or on a separate line<br /></td>
               </tr>
               <tr>
                 <td>
                   <label for="textarea"></label>
                    <html:textarea  cols="" rows="5" styleClass="invite_frd_textarea" styleId="emails" property="friendEmailId1" onkeypress="runScript(event)"/>
                 </td>
               </tr>
                <tr>
         <td  align="left" valign="top"   ><span class="red_text" style="font-size:12px" id="error" ></span></td>
           </tr>
               <tr>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td align="center"><a href="#" onclick="javascript:submitt();"  ><img src="../images/send_email_button.png" border="0"   /> </a></td>
               </tr>
             </table></td>
           </tr>
         </table></td>
       </tr>
      
       <tr>
         <td  align="center" valign="top"   >&nbsp;</td>
       </tr>
       
       
       
    </table>
    </td>
  </tr>
</table>  
  
  <div style="padding-left:370px;"></div>
  </html:form>




</div>
<%@ include file="footer.jsp"%>

            </div>
           


        </div>
    

</div>

<div style="clear:both;"></div>
	       
 </div> 


</body>
</html>
   
   