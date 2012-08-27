<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% Date currentDate=new Date();
 %> 
 <% int dealId=0;
if(	request.getAttribute("dealId")!=null)
{
	//session.setAttribute("dealId",request.getAttribute("dealId"));

	  dealId=(Integer)request.getAttribute("dealId");
	}
		 if( 	request.getParameter("dealId")!=null )
	  dealId=Integer.parseInt(request.getParameter("dealId"));
 %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title> TangoTab </title>
		<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/scroll.js"></script>
		<script type="text/javascript" src="../js/scrollend.js"></script> 
	<script src="../js/util.js" type="text/javascript"></script>
		<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
       <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
       <link rel="stylesheet" type="text/css" href="../css/calendar-blue2.css" />
       <script language="javascript" type="text/javascript">
       
   function showET(){
	var s = document.getElementById('selectend').options[document.getElementById('selectend').selectedIndex].value;
	//alert(s);
	document.getElementById('endT').value=s;
	}
	
 function check(){

     var err = false;  
var startTime = document.getElementById('select').options[document.getElementById('select').selectedIndex].value;
var endTime = document.getElementById('selectend').options[document.getElementById('selectend').selectedIndex].value; 
document.getElementById("totimemsg").innerHTML="";
document.getElementById("dealnamemsg").innerHTML = "";
document.getElementById("dealdescmsg").innerHTML = "";
document.getElementById("dealrestmsg").innerHTML = "";
document.getElementById("qtymsg").innerHTML = "";

 if(document.dealRegForm.dealTemplateName.value == null || document.dealRegForm.dealTemplateName.value.trim().length < 1){
   document.getElementById("dealnamemsg").innerHTML = "Offer Name is required.";
   err = true;
   }
 if(document.dealRegForm.dealTemplateDescription.value == null  || document.dealRegForm.dealTemplateDescription.value.trim().length < 1){
   document.getElementById("dealdescmsg").innerHTML = "Offer Description is required.";
   err = true;
   }
  if(document.dealRegForm.dealTemplateRestrictions.value == null || document.dealRegForm.dealTemplateRestrictions.value.trim().length < 1){
   document.getElementById("dealrestmsg").innerHTML = "Offer Restriction is required.";
   err = true;
   }
   if(document.dealRegForm.availableDealsQty.value == null || document.dealRegForm.availableDealsQty.value.trim().length < 1){
   document.getElementById("qtymsg").innerHTML = "Quantity is required.";
   err = true;
   }
   
   
if(err) 
  return false;
  
 var sid = startTime.split(":");
 var eid = endTime.split(":");
 
 if(sid[0]*1 > eid[0]*1)
 {
    document.getElementById("totimemsg").innerHTML="Please select End time greater than Start time.";
	return false;
 }else if((sid[0]*1 == eid[0]*1) && (sid[1]*1 >= eid[1]*1) )
 {
    document.getElementById("totimemsg").innerHTML="Please select End time greater than Start time.";
	return false;
 }
 
 
 var currentDate=new Date();
 
  
   currentDate.setMonth('<%=currentDate.getMonth()%>');
   currentDate.setDate('<%=currentDate.getDate()%>');
   currentDate.setYear('<%=currentDate.getYear()+1900%>');
     
 //currentDate.setDate()
	var startDate=new Date();
	var endDate=new Date();
/*	if(document.dealRegForm.startDate.value!='')
	{
	document.getElementById("todatemsg").innerHTML="";
	 var s=(document.dealRegForm.startDate.value).split("/");
	 startDate.setDate(s[1]);
	 startDate.setMonth((s[0])-1);
	 startDate.setYear(s[2]);
		if(currentDate>startDate)
			{
		 
			document.getElementById("todatemsg").innerHTML="Please select start date as  current date or after.";
		 		return false;
			}
 	} 
 	*/
 if(document.dealRegForm.startDate.value!='')
	{
	document.getElementById("todatemsg").innerHTML="";
	 var s=(document.dealRegForm.startDate.value).split("/");
	 
	 startDate.setMonth((s[0])-1);
	 startDate.setDate(s[1]);
	 startDate.setYear(s[2]);
		if(currentDate>startDate)
			{
		 
			document.getElementById("todatemsg").innerHTML="Please select From date as today's date or later.";
		 		return false;
			}
		
	} 
	
 
 
	var startDate=new Date();
	var endDate=new Date();
 
	if(document.dealRegForm.startDate.value!='' && document.dealRegForm.dealEndDate.value!='')
	{
	 var s=(document.dealRegForm.startDate.value).split("/");
	 
	 startDate.setMonth((s[0])-1);
	 startDate.setDate(s[1]);
	 startDate.setYear(s[2]);
	 var end=(document.dealRegForm.dealEndDate.value).split("/");
	 
	 endDate.setMonth((end[0])-1);
	 endDate.setDate(end[1]);
	 endDate.setYear(end[2]);
		var sind='';
	 		
					var index1=0;
				
						for(var s1=startDate;s1<=endDate;)
						{
						//alert(s1.getDay());
						sind=sind+','+(s1.getDay()+1);
						index1=index1+1;
						s1.setDate(s1.getDate()+1);
						if(index1>=7)
						break;
						//alert(index1);
						}
						
						startDate.setMonth((s[0])-1);
						startDate.setDate(s[1]);
				    	startDate.setYear(s[2]);
				        //alert(startDate);alert(endDate);
						var weekDays=document.dealRegForm.weekDays.value;
					 
						for(var i=0;i<document.dealRegForm.weekDays.length;i++)
						{
								if(document.dealRegForm.weekDays[i].checked )
								{
								
							//	alert(sind.indexOf(document.dealRegForm.weekDays[i].value));
									if((sind.indexOf(document.dealRegForm.weekDays[i].value)==-1))
									{
									document.getElementById("todatemsg").innerHTML="Please Select day in the date range.";
		 	
							 		return false ;
									} 								
								}
								
						}
						
						
		 	if(document.dealRegForm.isRecurring[1].checked==true)
			{
			var weekstartDate=new Date();
			var weekendDate=new Date();
  			var s=(document.dealRegForm.startDate.value).split("/");
	           
	           weekstartDate.setMonth((s[0])-1);
	           weekstartDate.setDate(s[1]);
	           weekstartDate.setYear(s[2]);
	 
	 /* increase to one week and compare with end date */
	 weekstartDate.setDate(weekstartDate.getDate()+6);
	 
	 var end=(document.dealRegForm.dealEndDate.value).split("/");
	 
	 weekendDate.setMonth((end[0])-1);
	 weekendDate.setDate(end[1]);
	 weekendDate.setYear(end[2]);
	 
	 /* if date range exceeds one week then alert */
				if(weekstartDate<weekendDate)
				{ 
				document.getElementById("todatemsg").innerHTML="Please Select TO date with in one week";
			 		return false;
				} 
			}
		if(startDate>endDate)
		{
	 
		document.getElementById("todatemsg").innerHTML="Please Select To date after From date.";
	 		return false;
		}else 
		{
		document.getElementById("todatemsg").innerHTML="";
		
				document.getElementById("submitinfo").style.display="inline";
				document.getElementById("submitone").style.display="none";
				 
			return true;
		}
 	}
	 
 
	}
	function change_date_format(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("from_date_h").value = date_out_put;
	}
    
    function change_date_format2(date_val)
	{
		var date_val_array = date_val.split("/");
		var date_out_put = date_val_array[2]+"-"+date_val_array[0]+"-"+date_val_array[1];
		//document.getElementById("to_date_h").value = date_out_put;


}
		function hide(){
				document.getElementById("customDealId").style.display = 'none';
			}
		function getTotime(fromtime)
	{
	var id=fromtime.split(":");
	
		if(id.length==2)
		{
	var todatevalue=document.getElementById("endtime");
	todatevalue.innerHTML="";
	var textdata='<select  class="restaurant_select" name="availableEndTime" id="selectend">';
	 
	var j=1;
	var timetype="am";
	var min="00";
	var start=0;

	if(id[1]==30)
	start=(id[0]*1)+1;
	else 
	{
	start=(id[0]);
	j=2;
	}
	var disptime=0;

			for(var i=start;i<25;i++)
			{
			 disptime=i;
				if(i>=12)
				{
				timetype="pm";
				if(i!=12)
				disptime=(i-12);
				}
  
			for(var k=j;k<3;k++)
			{
				if(k==2)
				{
				min="30";
				}
				else 
				{
				min="00";
				}
				if(i==24)
				{
				k=k+1;
				timetype="am";
				}
			textdata=textdata+"<option value="+i+":"+min+" >"+disptime+":"+min+" "+timetype+" </option>";
			}
			j=1;
			}
			textdata=textdata+"</select>";
				todatevalue.innerHTML=textdata;
					
		
		 
		}
	}	
	
	function showImages(){
		window.open('getImages.do','imagesWin',"height=400,width=700,top=500,left=300,status=no,toolbar=no,menubar=no,location=0,resizable=no");
	}
</script>
		<link rel="stylesheet" type="text/css"
			href="../css/jqueryslidemenu.css" />


		<script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
		<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
<%@ include file="consumer_imports.jsp"%>
	</head>

	<body>
		
<div id="wrapper">
	<div id="main">
	
		<jsp:include page="header.jsp">
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
						<%@ include file="client_banner.jsp" %>
	        			<%@ include file="client_menu.jsp" %>  
	        			<tr>
							<td colspan="3" align="center" valign="top">
								<!--Client Start-->
							 
    <!--Client End-->    
          	<!-- form Start--><html:form action="/jsp/dealUpdate"  onsubmit="return check();"  enctype="multipart/form-data">
								<table width="968" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td background="../images/1.png"></td>
										<td width="729" height="8" background="../images/5.png"></td>
										<td background="../images/2.png"></td>
										   <html:hidden property="dealId" value="<%=Integer.toString(dealId)%>"/>
				                <html:hidden property="customDeal" value="${dealInfo.customDeal}"/>
				                 <html:hidden property="isActive" value="${dealInfo.isActive}"/>
				                 <html:hidden property="restDealPublishedDate" value="${dealInfo.restDealPublishedDate}" />
				                 <html:hidden  property="restDealCreateDate" value="${dealInfo.restDealCreateDate}" />
									</tr>
									<tr>
										<td width="8" background="../images/7.png"></td>
										<td height="100" align="center" valign="top">
											<table width="945" border="0" align="center" cellpadding="0"
												cellspacing="8">

												<tr>
													<td height="30" colspan="3" align="center" valign="middle"
														class="red_max">
														Update Offer
													</td>
												</tr>
												<tr>
												
													<td align="left" valign="middle" class="text_h9">
														<html:hidden property="restLocationId" name="dealInfo"/>
														<html:hidden property="dealTemplateId" value="${dealInfo.dealTemplateId}" name="dealInfo"/>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="text_h2">
														<span class="bla_low">Offer Name<span
															class="red_text">*</span>:</span>
													</td>
													<td colspan="2" align="left" valign="middle" class="text_h9">
														<html:textarea property="dealTemplateName" value="${dealInfo.dealTemplateName}" styleClass="restaurant_input" name="dealInfo" readonly="true" />
														<!--<html:select property="dealTemplateName" value="${dealInfo.dealTemplateName}"
															styleClass="restaurant_select" name="dealInfo">
															<html:option value="0">Select your option</html:option>
															<bean:define id="relationships3" name="dropDownList"
																property="deals" type="java.util.ArrayList" />
															<html:options collection="relationships3"
																property="dealTemplateName" labelProperty="dealTemplateName" />
														</html:select>-->
														<span id="dealnamemsg" class="text_h9"><html:errors property="dealTemplateName" /></span>
													</td>
												</tr>
												<tr>
													<td width="22%" align="right" valign="middle"
														class="bla_low">
														Offer Description
														<span class="red_text">*</span>:
													</td>
													<td width="38%" align="left" valign="middle">
													<c:if test="${dealInfo.customDeal eq 0}"> 
													<html:textarea property="dealTemplateDescription" name="dealInfo" readonly="true" ></html:textarea>
													</c:if> 
														<c:if test="${dealInfo.customDeal ne 0}"> 
													<html:textarea property="dealTemplateDescription" name="dealInfo"  ></html:textarea>
													</c:if> 
														<span id="dealdescmsg" class="red_text"><html:errors property="dealTemplateDescription" />
														  </span>
													</td>
												</tr>
												<tr>
													<td width="22%" align="right" valign="middle"
														class="bla_low">
														Offer Restriction
														<span class="red_text">*</span>:
													</td>
													<td align="left"colspan="2"  valign="middle">
														
														<c:if test="${dealInfo.customDeal eq 0}"> 
														<html:textarea property="dealTemplateRestrictions" name="dealInfo" readonly="true"  ></html:textarea>
														</c:if>
														<c:if test="${dealInfo.customDeal ne 0}"> 
														<html:textarea property="dealTemplateRestrictions" name="dealInfo"  ></html:textarea>
														
														</c:if>
													<span id="dealrestmsg" class="red_text"><html:errors property="dealTemplateRestrictions" />	 </span>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														Days
														<span class="red_text">*</span>:
													</td>
													<td align="left" colspan="2"  valign="middle" class="text_h9">
														<c:if test="${dealInfo.sunday ne 0}">
															<input type="checkbox" name="weekDays" value="1" checked="checked">SUN</input>
														</c:if>
														<c:if test="${dealInfo.sunday eq 0}">
															<input type="checkbox" name="weekDays" value="1" >SUN</input>
														</c:if>
														<c:if test="${dealInfo.monday ne 0}">
															<input type="checkbox" name="weekDays" value="2" checked="checked">MON</input>
														</c:if>
														<c:if test="${dealInfo.monday eq 0}">
															<input type="checkbox" name="weekDays" value="2" >MON</input>
														</c:if>
														<c:if test="${dealInfo.tuesday ne 0}">
															<input type="checkbox" name="weekDays" value="3" checked="checked">TUE</input>
														</c:if>
														<c:if test="${dealInfo.tuesday eq 0}">
															<input type="checkbox" name="weekDays" value="3" >TUE</input>
														</c:if>
														<c:if test="${dealInfo.wednesday ne 0}">
															<input type="checkbox" name="weekDays" value="4" checked="checked">WED</input>
														</c:if>
														<c:if test="${dealInfo.wednesday eq 0}">
															<input type="checkbox" name="weekDays" value="4" >WED</input>
														</c:if>
														<c:if test="${dealInfo.thursday ne 0}">
															<input type="checkbox" name="weekDays" value="5" checked="checked">THU</input>
														</c:if>
														<c:if test="${dealInfo.thursday eq 0}">
															<input type="checkbox" name="weekDays" value="5" >THU</input>
														</c:if>
														<c:if test="${dealInfo.friday ne 0}">
															<input type="checkbox" name="weekDays" value="6" checked="checked">FRI</input>
														</c:if>
														<c:if test="${dealInfo.friday eq 0}">
															<input type="checkbox" name="weekDays" value="6" >FRI</input>
														</c:if>
														<c:if test="${dealInfo.staturday ne 0}">
															<input type="checkbox" name="weekDays" value="7" checked="checked">SAT</input>
														</c:if>
														<c:if test="${dealInfo.staturday eq 0}">
															<input type="checkbox" name="weekDays" value="7" >SAT</input>
														</c:if>
															<html:errors property="weekDays" />	
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														Dates
														<span class="red_text">*</span>:
													</td>
													<td align="left" valign="middle" class="text_h9" colspan=2>
														From
														<html:text  property="startDate" styleId="startDate" name="dealInfo"
														onchange="change_date_format(this.value);  "   readonly="true"  />
			                                             <img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />
														<html:errors property="startDate" />	&nbsp; To
														<html:text property="dealEndDate"    readonly="true"  styleId="dealEndDate" styleClass="restaurant_input" name="dealInfo"
														onchange="change_date_format2(this.value); "/>
														<img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />

													<span id="todatemsg" class="red_text">	<html:errors property="dealEndDate" /></span>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="text_formsub">
														<span class="bla_low">Time</span>:
													</td>
													<td align="left" valign="middle" class="text_h9"  colspan=2>
														From
														<html:select name="dealInfo" styleClass="restaurant_select" property="availableStartTime" styleId="select"  onchange="getTotime(this.value);">
														 	<html:option value="0:30">12:30 am</html:option>
															<html:option value="1:00">1:00 am</html:option>
															<html:option value="1:30">1:30 am</html:option>
															<html:option value="2:00">2:00 am</html:option>
															<html:option value="2:30">2:30 am</html:option>
															<html:option value="3:00">3:00 am</html:option>
															<html:option value="3:30">3:30 am</html:option>
															<html:option value="4:00">4:00 am</html:option>
															<html:option value="4:30">4:30 am</html:option>
															<html:option value="5:00">5:00 am</html:option>
															<html:option value="5:30">5:30 am</html:option>
															<html:option value="6:00">6:00 am</html:option>
															<html:option value="6:30">6:30 am</html:option>
															<html:option value="7:00">7:00 am</html:option>
															<html:option value="7:30">7:30 am</html:option>
															<html:option value="8:00">8:00 am</html:option>
															<html:option value="8:30">8:30 am</html:option>
															<html:option value="9:00">9:00 am</html:option>
															<html:option value="9:30">9:30 am</html:option>
															<html:option value="10:00">10:00 am</html:option>
															<html:option value="10:30">10:30 am</html:option>
															<html:option value="11:00">11:00 am</html:option>
															<html:option value="11:30">11:30 am</html:option>
															<html:option value="12:00">12:00 pm</html:option>
															<html:option value="12:30">12:30 pm</html:option>
															<html:option value="13:00">1:00 pm</html:option>															<html:option value="4:00">1:30 am</html:option>
															<html:option value="13:30">1:30 pm</html:option>
															<html:option value="14:00">2:00 pm</html:option>
															<html:option value="14:30">2:30 pm</html:option>
															<html:option value="15:00">3:00 pm</html:option>
															<html:option value="15:30">3:30 pm</html:option>
															<html:option value="16:00">4:00 pm</html:option>
															<html:option value="16:30">4:30 pm</html:option>
															<html:option value="17:00">5:00 pm</html:option>
															<html:option value="17:30">5:30 pm</html:option>
															<html:option value="18:00">6:00 pm</html:option>
															<html:option value="18:30">6:30 pm</html:option>
															<html:option value="19:00">7:00 pm</html:option>
															<html:option value="19:30">7:30 pm</html:option>
															<html:option value="20:00">8:00 pm</html:option>
															<html:option value="20:30">8:30 pm</html:option>
															<html:option value="21:00">9:00 pm</html:option>
															<html:option value="21:30">9:30 pm</html:option>
															<html:option value="22:00">10:00 pm</html:option>
															<html:option value="22:30">10:30 pm</html:option>
															<html:option value="23:00">11:00 pm</html:option>
															<html:option value="23:30">11:30 pm</html:option>
															<html:option value="24:00">12:00 am</html:option>
		
														</html:select>
														<input type="hidden" name="endT" id="endT" value=""/>
														&nbsp;&nbsp;&nbsp; To<span id="endtime">
															<html:select name="dealInfo" styleClass="restaurant_select" property="availableEndTime" styleId="selectend" >
														 	<html:option value="0:30">12:30 am</html:option>
															<html:option value="1:00">1:00 am</html:option>
															<html:option value="1:30">1:30 am</html:option>
															<html:option value="2:00">2:00 am</html:option>
															<html:option value="2:30">2:30 am</html:option>
															<html:option value="3:00">3:00 am</html:option>
															<html:option value="3:30">3:30 am</html:option>
															<html:option value="4:00">4:00 am</html:option>
															<html:option value="4:30">4:30 am</html:option>
															<html:option value="5:00">5:00 am</html:option>
															<html:option value="5:30">5:30 am</html:option>
															<html:option value="6:00">6:00 am</html:option>
															<html:option value="6:30">6:30 am</html:option>
															<html:option value="7:00">7:00 am</html:option>
															<html:option value="7:30">7:30 am</html:option>
															<html:option value="8:00">8:00 am</html:option>
															<html:option value="8:30">8:30 am</html:option>
															<html:option value="9:00">9:00 am</html:option>
															<html:option value="9:30">9:30 am</html:option>
															<html:option value="10:00">10:00 am</html:option>
															<html:option value="10:30">10:30 am</html:option>
															<html:option value="11:00">11:00 am</html:option>
															<html:option value="11:30">11:30 am</html:option>
															<html:option value="12:00">12:00 pm</html:option>
															<html:option value="12:30">12:30 pm</html:option>
															<html:option value="13:00">1:00 pm</html:option>															<html:option value="4:00">1:30 am</html:option>
															<html:option value="13:30">1:30 pm</html:option>
															<html:option value="14:00">2:00 pm</html:option>
															<html:option value="14:30">2:30 pm</html:option>
															<html:option value="15:00">3:00 pm</html:option>
															<html:option value="15:30">3:30 pm</html:option>
															<html:option value="16:00">4:00 pm</html:option>
															<html:option value="16:30">4:30 pm</html:option>
															<html:option value="17:00">5:00 pm</html:option>
															<html:option value="17:30">5:30 pm</html:option>
															<html:option value="18:00">6:00 pm</html:option>
															<html:option value="18:30">6:30 pm</html:option>
															<html:option value="19:00">7:00 pm</html:option>
															<html:option value="19:30">7:30 pm</html:option>
															<html:option value="20:00">8:00 pm</html:option>
															<html:option value="20:30">8:30 pm</html:option>
															<html:option value="21:00">9:00 pm</html:option>
															<html:option value="21:30">9:30 pm</html:option>
															<html:option value="22:00">10:00 pm</html:option>
															<html:option value="22:30">10:30 pm</html:option>
															<html:option value="23:00">11:00 pm</html:option>
															<html:option value="23:30">11:30 pm</html:option>
															<html:option value="24:00">12:00 am</html:option>
		
														</html:select></span>
														<span id="totimemsg" class="red_text"></span>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														QTY
														<span class="red_text">*</span>:
													</td>
													<td align="left" valign="middle" class="text_h9">
													<html:hidden property="usedDealsQty"   value="${dealInfo.usedDealsQty}"/>
													<html:hidden property="restDealPublishStatus" value="${dealInfo.restDealPublishStatus}"/>
													<html:hidden property="rewardPoints" value="${dealInfo.rewardPoints}"/>
													<html:text name="dealInfo" styleClass="restaurant_select" property="availableDealsQty" onkeypress="return isNumberKey(event)"  styleId="select" />
														
												<span id="qtymsg" class="red_text"><html:errors property="availableDealsQty" /></span>
 
 <input type="hidden" name="dealId" value="16" /></td>
                                                 <td width="200" height="100" rowspan="4" align="center" valign="top" class="text_h9"><img src="${dealInfo.restDealImagePath}" width="190" height="100"/></td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														Recurring
														<span class="red_text">*</span>:
													</td>
													<td align="left" valign="middle" class="text_h9">
														<html:radio property="isRecurring" styleId="radio" value="1" name="dealInfo"/>
														Yes or
														<html:radio property="isRecurring" styleId="radio2" value="0" name="dealInfo"/>
														No
													</td>
												</tr>
	
											<!-- <tr>		<td rowspan="2" align="right" valign="middle" class="bla_low">
														Image Upload:							</td>
													<td align="left" valign="middle" class="text_h10">
													[NOTE:*Your image is displaying here.If you want to change please select browse in the following.*]</td>
											    </tr>
												<tr>
												  <td align="left" valign="middle" class="text_h9">						   
												  <html:hidden property="existImagePath" style="hiddenPath" value="${dealInfo.restDealImagePath}"/>
														<html:file
															styleClass="restaurant_fileupload" styleId="fileField" property="dealImage" />	</td>
											  </tr> -->
											   <tr>
													<td align="right" valign="middle" class="bla_low">
												  <div id="imageupload" style="display: inline"> 		Image Upload:</div>
													<br /></td>
													<td align="left" valign="middle" class="text_h9">
													  <div id="imageupload1" style="display: inline"> 
													  	<html:text styleClass="restaurant_fileupload" styleId="fileField" readonly="true" property="existImagePath" value="${dealInfo.restDealImagePath}"/>
													  	<input type="button" id="imageId" name="imageId" value="choose" onclick="showImages()"/>
													</div>
													<br /></td>
											    </tr> 
												<tr>
													<td height="55" colspan="3" align="center" valign="middle"  >
													<div  id="submitone">
														<table width="330" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td align="right">
																   <div id="select_hot">
																		<html:submit styleClass="but_img" property="submit"
																				styleId="submitID" onclick="showET();">Update</html:submit>	
																				</div>															</td>
																<td colspan="2" align="left">
																	<div id="select_hot" style="float:left">
																		<a href="viewDeals.do">Cancel</a>																	</div>																</td>
															</tr>
														</table>	</div>
														<div id="submitinfo" class="red_max" style="display: none;">
														<img src="../images/ajax-loader.gif"  /> <br/>  <b>Please wait...</b>
														</div>															</td>
												</tr>
											</table>
									  </td>
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
        inputField     :    "dealEndDate",       // id of the input field
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