<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% java.util.Date currentDate=new Date();
 %> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title> TangoTab </title>
		<link href="../css/tangotab.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/scroll.js"></script>
		<script type="text/javascript" src="../js/scrollend.js"></script>
	 
        		<link href="../css/scrollcolor.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css"  href="../css/jqueryslidemenu.css" />
		<link rel="stylesheet" type="text/css"
			href="../css/jqueryslidemenu.css" />

 <script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
		<script type="text/javascript" src="../js/jqueryslidemenu.js"></script>
		<script src="../js/Country_state.js" type="text/javascript"></script>
			<script src="../js/util.js" type="text/javascript"></script>
		<script type="text/javascript" language="javascript">
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
	function showET(){
	var s = document.getElementById('selectend').options[document.getElementById('selectend').selectedIndex].value;
	document.getElementById('endT').value=s;
	}
	
	
	
	
  function checkold(){ 

var startTime = document.getElementById('select').options[document.getElementById('select').selectedIndex].value;
var endTime = document.getElementById('selectend').options[document.getElementById('selectend').selectedIndex].value; 
document.getElementById("totimemsg").innerHTML="";
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
		if(document.getElementById("dealNameId").value=="custom"){
			currentDate.setDate('<%=currentDate.getDate()+1%>');
  
				if(currentDate>startDate)
				{
		 
				    document.getElementById("todatemsg").innerHTML="Please select start date as one day after the current date.";
		 			return false;
				}
			}
	} 
	
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
 
  
			// alert("hello");	
			 
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
				//	alert(startDate);alert(endDate);
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
			 
			 	
		if(startDate>endDate)
		{
	 
		document.getElementById("todatemsg").innerHTML="Please Select To date after From date";
	 		return false;
		} 		
	//	alert(document.dealRegForm.isRecurring[1].checked);
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
	     //alert(weekstartDate +","+ weekendDate+","+(s[0]));
		 document.getElementById("todatemsg").innerHTML="Please Select TO date with in one week";
	 	 return false;
		} 
	}

				
				/*			
					*/
	
		
		
 	}
	// 	 alert('hi');
	var deal = document.getElementById("dealNameId").value;
		if(document.getElementById("dealNameId").value=="custom"){
 
		var val= document.getElementById("customDealId").value;
			if(document.getElementById("customDealId").value==null || document.getElementById("customDealId").value==""){
				document.getElementById("dealNameIDmsg").innerHTML="Offer Name required";
				 if(document.getElementById("custdealdesc").value==null || document.getElementById("custdealdesc").value==""){
				document.getElementById("custdealdescmsg").innerHTML="Offer Description required";
				 
				}
				if(document.getElementById("fileField").value=="" && document.getElementById("dealImage").value==""){
				document.getElementById("dealImagemsg").innerHTML="TangoTab Image or Custom Offer Image required";
				 
				}
				return false;
			}else if(document.getElementById("customDealId").value!=null && document.getElementById("customDealId").value!=""  && (document.getElementById("customDealId").value).length>500){
				document.getElementById("dealNameIDmsg").innerHTML="Offer Name  length  can't be greater than 500";
				 if(document.getElementById("custdealdesc").value!=null && document.getElementById("custdealdesc").value!=""  && (document.getElementById("custdealdesc").value).length>1000){
				document.getElementById("custdealdescmsg").innerHTML="Offer Description length  can't be greater than 1000";
				 
				}
				 
				return false;
			}
				 if(document.getElementById("custdealdesc").value==null || document.getElementById("custdealdesc").value==""){
				document.getElementById("custdealdescmsg").innerHTML="Offer Description required";
				 return false;
				}  
				if(document.getElementById("fileField").value=="" && document.getElementById("dealImage").value==""){
				document.getElementById("dealImagemsg").innerHTML="TangoTab Image or Custom Offer Image required";
				  return false;
				}
			else {		
		//	alert("after"+document.dealRegForm.custdealdesc.value);
		//	document.dealRegForm.dealTemplateDescription.value=document.dealRegForm.custdealdesc.value;
					// document.getElementById("dealTemplateDescription").value=document.getElementById("custdealdesc").value;
				document.getElementById("submitinfo").style.display="inline";
				document.getElementById("submitone").style.display="none";
  //alert('hi');
				 return true;
			}
		}else  if(document.getElementById("dealTemplateDescription").value==null || document.getElementById("dealTemplateDescription").value==""){
				document.getElementById("custdealdescmsg").innerHTML="Deal Description required";
				if(document.getElementById("fileField").value==null || document.getElementById("fileField").value==""){
				document.getElementById("existImagePathmsg").innerHTML="Deal Image required";
				 
				}
				 return false;
				}
		 else  if(document.getElementById("dealTemplateDescription").value==null || document.getElementById("dealTemplateDescription").value==""){
				document.getElementById("custdealdescmsg").innerHTML="Deal Description required";
				 return false;
				}
			else 	if(document.getElementById("fileField").value==null || document.getElementById("fileField").value==""){
				document.getElementById("existImagePathmsg").innerHTML="Deal Image required";
				 return false;
				}else {
				
			//	alert('2');
				document.getElementById("submitinfo").style.display="inline";
				document.getElementById("submitone").style.display="none";
				 
				 return true;
			}
			 
	} 
	
function clearAll(){

document.getElementById('locationmsg').innerHTML = '';
document.getElementById('totimemsg').innerHTML = '';
document.getElementById('todatemsg').innerHTML = '';
document.getElementById('dealRetId1').innerHTML = '';
document.getElementById('dealNameIDmsg').innerHTML = '';
document.getElementById('custdealdescmsg').innerHTML = '';
document.getElementById('dealImagemsg').innerHTML = '';
//document.getElementById('existImagePathmsg').innerHTML = '';
document.getElementById('qtymsg').innerHTML = '';
document.getElementById('daysmsg').innerHTML = '';
document.getElementById('recurmsg').innerHTML = '';

}

function check(){
var err = false;
clearAll();

if(document.dealRegForm.restLocationId.value == "-1")
{
 	document.getElementById('locationmsg').innerHTML = "Please select Location.";
	err = true;
}
var startTime = document.getElementById('select').options[document.getElementById('select').selectedIndex].value;
var endTime = document.getElementById('selectend').options[document.getElementById('selectend').selectedIndex].value; 

 var sid = startTime.split(":");
 var eid = endTime.split(":");
 
  
   var currentDate=new Date();
 
   
   currentDate.setMonth('<%=currentDate.getMonth()%>');
   currentDate.setDate('<%=currentDate.getDate()%>');
   currentDate.setYear('<%=currentDate.getYear() + 1900%>');

	var startDate=new Date();
	var endDate=new Date();
	if(document.dealRegForm.startDate.value == '' && document.dealRegForm.dealEndDate.value == '')
	{
	document.getElementById("todatemsg").innerHTML="Please select both start date and end date.";
	err = true;
	}
	else if(document.dealRegForm.startDate.value!='')
	{
	 document.getElementById("todatemsg").innerHTML="";
	 var s=(document.dealRegForm.startDate.value).split("/");
	 startDate.setMonth((s[0])-1);
	 startDate.setDate(s[1]);
	 startDate.setYear(s[2]);
		if(currentDate>startDate)
			{
		 	document.getElementById("todatemsg").innerHTML="Please select From date as today's date or later.";
		 	err = true;
			}
		/*else if(document.getElementById("dealNameId").value=="custom"){
			currentDate.setDate('<%=currentDate.getDate() + 1%>');
  
				if(currentDate>startDate)
				{
		 
				    document.getElementById("todatemsg").innerHTML="Please select start date as one day after the current date.";
		 			err = true;
				}
		}*/
		else if(document.dealRegForm.dealEndDate.value == ''){
		     document.getElementById("todatemsg").innerHTML = "To date is required.";
		     err = true;
		}
	} 
	
	if(!err && document.dealRegForm.startDate.value!='' && document.dealRegForm.dealEndDate.value!='')
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
						
						sind=sind+','+(s1.getDay()+1);
						index1=index1+1;
						s1.setDate(s1.getDate()+1);
						if(index1>=7)
						break;
						}
						
						startDate.setMonth((s[0])-1);
						startDate.setDate(s[1]);
				    	startDate.setYear(s[2]);
				
 						if(startDate>endDate)
 						  {	 
						   document.getElementById("todatemsg").innerHTML="Please Select To date after From date";
						   err = true;
  		   				  }
						var weekDays=document.dealRegForm.weekDays.value;
					    if(!err ){
						for(var i=0;i<document.dealRegForm.weekDays.length;i++)
						  {
								if(document.dealRegForm.weekDays[i].checked )
								{
								
									if((sind.indexOf(document.dealRegForm.weekDays[i].value)==-1))
									{
									document.getElementById("todatemsg").innerHTML="Please Select day in the date range.";
		 	                        err = true;
							 		
									} 								
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
	 	 err = true;
		} 
	}
		
 } 	
 	
 /* End of date validation and start time validation */
 if(sid[0]*1 > eid[0]*1)
 {
    document.getElementById("totimemsg").innerHTML="Please select End time greater than Start time.";
	err = true;
 }else if((sid[0]*1 == eid[0]*1) && (sid[1]*1 >= eid[1]*1) )
 {
    document.getElementById("totimemsg").innerHTML="Please select End time greater than Start time.";
	err = true;
 }
 
	
	var deal = document.getElementById("dealNameId").value;
	/* For custom deals */
		if(document.getElementById("dealNameId").value=="custom"){
		   /* var cname = document.getElementById("customDealId").value;
		    var cdesc = document.getElementById("custdealdesc").value;
		    alert("c deal name:"+cname.trim().length);
		    alert("c deal desc:"+cname.trim().length);*/
		    
		    if(document.getElementById("dealTemplateRestrictions").value == null || document.getElementById("dealTemplateRestrictions").value.trim() == ''){
            document.getElementById('dealRetId1').innerHTML = 'Offer restriction is required';
            err = true;
            }
		    var val= document.getElementById("customDealId").value;
			if(document.getElementById("customDealId").value==null || document.getElementById("customDealId").value.trim()==""){
				document.getElementById("dealNameIDmsg").innerHTML="Offer Name required";
				if(document.getElementById("custdealdesc").value==null || document.getElementById("custdealdesc").value.trim()==""){
				document.getElementById("custdealdescmsg").innerHTML="Offer Description required";
				 
				}
				if(document.getElementById("dealImage").value==""){
				document.getElementById("dealImagemsg").innerHTML="Custom Offer Image required";
				 
				}
				err = true;
			}else if(document.getElementById("customDealId").value!=null && document.getElementById("customDealId").value.trim()!=""  && (document.getElementById("customDealId").value).length>500){
				 document.getElementById("dealNameIDmsg").innerHTML="Offer Name  length  can't be greater than 500";
				 
				 if(document.getElementById("custdealdesc").value!=null && document.getElementById("custdealdesc").value.trim()!=""  && (document.getElementById("custdealdesc").value).length>1000){
				  document.getElementById("custdealdescmsg").innerHTML="Offer Description length  can't be greater than 1000";
				 }
				 err = true;
			}
			 if(document.getElementById("dealTemplateRestrictions").value != null && document.getElementById("dealTemplateRestrictions").value.trim() != '' && (document.getElementById("dealTemplateRestrictions").value).length>1000 ){
              document.getElementById('dealRetId1').innerHTML = "Offer Restriction length  can't be greater than 1000";
            err = true;
            }
			if(document.getElementById("custdealdesc").value==null || document.getElementById("custdealdesc").value.trim()==""){
			  document.getElementById("custdealdescmsg").innerHTML="Offer Description required";
			  err = true;
			}  
			if( document.getElementById("dealImage").value==""){
			  document.getElementById("dealImagemsg").innerHTML="Custom Offer Image required";
			  err = true;
			}
			
		}
/* For normal deals  */
else{
     
     if(document.getElementById("dealTemplateRestrictions").value == null || document.getElementById("dealTemplateRestrictions").value.trim() == ''){
        document.getElementById('dealRetId1').innerHTML = "Deal Restriction is required";
        err = true;
       }
     if(document.getElementById("dealNameId").value== null || document.getElementById("dealNameId").value.trim()== ""){
       document.getElementById("dealNameIDmsg").innerHTML="Deal Name required";
       err = true;
       }
     if(document.getElementById("dealTemplateDescription").value==null || document.getElementById("dealTemplateDescription").value.trim()=="" ||
       document.getElementById("dealTemplateDescription").value=="Select your option"){
		 document.getElementById("custdealdescmsg").innerHTML="Deal Description required";
		 err = true;
		}
	/*if(document.getElementById("fileField").value==null || document.getElementById("fileField").value==""){
		document.getElementById("existImagePathmsg").innerHTML="Deal Image required";
		err = true;
	   }*/
		
	}
	/* for deal quantity */		
	if(document.dealRegForm.availableDealsQty.value == 0 || document.dealRegForm.availableDealsQty.value.trim() == '')
	{
		document.getElementById("qtymsg").innerHTML = "Offer Quantity is required."
		err = true;
	}
	/* for recurring check */
	if(!document.dealRegForm.isRecurring[0].checked && !document.dealRegForm.isRecurring[1].checked)
	{
	    //alert(document.dealRegForm.isRecurring.length);
		document.getElementById("recurmsg").innerHTML = "Please select yes or no."
		err = true;
	}	
	/* checking if week days is selected or not */
	var weekflag = false;
	for(var l=0;l<document.dealRegForm.weekDays.length;l++){
      if(document.dealRegForm.weekDays[l].checked)
        weekflag = true;
    }
    if(!weekflag){
      document.getElementById("daysmsg").innerHTML = "Days is required."
      err = true;
     }
		
    if(err)
	   return false;
	else {
	
	   document.getElementById("submitinfo").style.display="inline";
	   document.getElementById("submitone").style.display="none";
	   return true;	
	   }
			 
 }/* end of validation */
	
	
	function check1()
		{
		//alert('check2');
		if(check()==true)
		{
		//alert(check());
		return true;
		}
		else 
		return false;
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
	var i = 0;
	var flag = 0;

			for( i=start; i < 25; i++ )
			{
			/* if selected is 12am  then to stop end time to display
			12 am again. display up to 11:45pm  so this condition */
			if(flag == 1 && i == 24)
			   break;
			   
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
			
			/* for last option if night 12am is selected, display all day times
			and check if first option itself is 24 then proceed and
			it should do only for one time(so set the flag)*/
			if(i == id[0]*1  && id[0]*1 == 24 && flag == 0)
			{
			flag = 1;
			i = 0;
			//alert("after" + i*1);
			}
			
			
			
			}
			textdata=textdata+"</select>";
			todatevalue.innerHTML=textdata;
			//alert(textdata);
					
		
		 
		}
	}
	function showImages(){
	//alert(document.getElementById("dealNameId").value);
	var dealName=document.getElementById("dealNameId").value;
		window.open('getImages.do?dealName='+dealName,'imagesWin',"height=400,width=700,top=500,left=300,status=no,toolbar=no,menubar=no,location=0,resizable=no,scrollbars=yes",0);
	}
 
	
		function getChoices(form)
		{
		
		  var values, options, option, length1, k=0;
		  values  = new Array();
		  options = form.dealTemplateRestrictionss.options;
		 
		  while(option=options[k++])
		    if(option.selected)
		      values[values.length] = option.value;
		  length1 = 0*1;
		  for(var len=0; len < values.length; len++){
		     length1 = length1 + values[len].length;
		  }
		  var left1 = 1000 - form.dealTemplateRestrictions.value.length*1;
		  var restvaluestring = form.dealTemplateRestrictions.value;
		   for(var le=0; le < values.length; le++){
		      if((form.dealTemplateRestrictions.value).indexOf(values[le]) == -1){
		        if (left1 == 1000){
		       	  form.dealTemplateRestrictions.value = values[le]+".";
		        }else if(values[le].length <= left1){
		          /* multiple option selected*/
		          if(values.length > 1){
		          if(form.dealTemplateRestrictions.value[form.dealTemplateRestrictions.value.length -1] == "." )
		             {
		            	 form.dealTemplateRestrictions.value = restvaluestring.substring(0, restvaluestring.length-1);
		             }
		         	
		          	 form.dealTemplateRestrictions.value = form.dealTemplateRestrictions.value +", "+ values[le]+".";
		          	}
		          	/* single option */
		          else{ 
		          /* if last letter ends with "." then remove it and add , item .*/
		            if(form.dealTemplateRestrictions.value[form.dealTemplateRestrictions.value.length -1] == "." )
		             {
		            	 form.dealTemplateRestrictions.value = restvaluestring.substring(0, restvaluestring.length-1);
		             }
		             form.dealTemplateRestrictions.value = form.dealTemplateRestrictions.value +", "+ values[le]+".";
		            }
		          }
		       }
		      		       	  
		  }
		  /*  if(values.length > 1)
		 	 form.dealTemplateRestrictions.value = form.dealTemplateRestrictions.value +".";
		 if(length1 <= left1){
		  	form.dealTemplateRestrictions.value = form.dealTemplateRestrictions.value +" "+ values[values.length-1];
		    form.dealTemplateRestrictions.value = form.dealTemplateRestrictions.value +".";
		  }*/
		
		showCount(form.dealTemplateRestrictions.value);
		}
		
		function acceptData(evt,restvalue){
		
		if(restvalue == null || restvalue == "")
		   restvalue = "";
		
		 var left = 999 - restvalue.length*1;
		 
		 if(evt != null){ 
		   
		    var charCodes = (evt.which) ? evt.which : event.keyCode
		 
		 	if(charCodes == 8 || charCodes == 46){
		 		return true;
		 	}
		 }
		 if(left < 0)			
			 return false;		 
		 else		 
		 	return true;
			
		}
		
    function showCount(restval){
     var left = 1000 - restval.length*1;
     
      if(left < 0){
			 document.getElementById('dealRetId1').innerHTML = "Offer Restriction length can't be greater than 1000.";
			
		 }
		 else{
		 	document.getElementById('dealRetId1').innerHTML = left+ " left.";	
		 	
		 }	   
    
    }

	function getRest(form)
		{
		  var values, options, option, k=0, rest;
		  values  = new Array();
		  options = form.dealTemplateRestrictionss.options;
		  while(option=options[k++])
		    if(option.selected)
		      values[values.length] = option.value;
		      rest = values.join(', ');
		     rest =   rest +".";
		    	     
		    return rest;
		}
		function getDays(form)
		{
		  var  k=0;
		  var options="";
		 
		  for( ;k<7;k++){
		   if(form.weekDays[k].checked == true)
		     options=options+form.weekDays[k].value+",";
		    
		     }
		   return options;
		}
	function dealPreview()
	 { 
	  var rest = getRest(document.dealRegForm);
	  var locid = document.dealRegForm.restLocationId1.value;
	  if(locid >= 0){
	  var location = document.dealRegForm.restLocationId1.options[document.dealRegForm.restLocationId1.selectedIndex].text;
	  var dealname = document.dealRegForm.dealTemplateName.value;
	 
	  var dealdesc = document.dealRegForm.dealTemplateDescription.value; 
	  if(dealname == "custom" ){
	   dealname = document.dealRegForm.customDealTemplateName.value;
	   dealdesc = document.dealRegForm.custdealdesc.value;
	  }
	  dealdesc = dealdesc.replace(/%/g,"!qe!");
	  dealdesc = dealdesc.replace(/#/g,"!qs!");
	  var sdate = document.dealRegForm.startDate.value;
	  var edate = document.dealRegForm.dealEndDate.value;
	  var stime = document.dealRegForm.availableStartTime.options[document.dealRegForm.availableStartTime.selectedIndex].text;
	  var etime = document.dealRegForm.availableEndTime.options[document.dealRegForm.availableEndTime.selectedIndex].text;
	  var qty = document.dealRegForm.availableDealsQty.value; 
	  //var img = document.dealRegForm.existImagePath.value;
	  var img = document.dealRegForm.dealImage.value;
	  var day = getDays(document.dealRegForm);
	  window.open("displaydeal.jsp?dealTemplateName="+dealname+"&locid="+locid+"&dealdesc="+dealdesc+"&loc="+location+"&dealr="+rest+"&sdate="+sdate+"&edate="+edate+"&stime="+stime+"&etime="+etime+"&qty="+qty+"&img="+img+"&day="+day,'imagesWin',"height=400,width=1000,top=350,left=100,status=no,toolbar=no,scrollbars=1,menubar=no,location=0,resizable=yes");
 	 }else{
 	   alert("Please select Location");
 	 }
 	 } 
		</script>
		<%@ include file="consumer_imports.jsp"%>
	</head>

	<body  > 
		<div id="wrapper">
			<div id="main">
			<!--Header Start-->
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
							<%@ include file="client_banner.jsp"%>
							<%@ include file="client_menu.jsp"%>

						<tr>
							<td height="6" colspan="3" align="left" valign="top"></td>
						</tr>
						<tr>
							<td height="17" colspan="3" align="center" valign="top">
								<!-- form Start-->
								<html:form action="/jsp/dealReg" method="post" enctype="multipart/form-data" onsubmit="return check();">
	
								<table width="968" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td background="../images/1.png"></td>
										<td width="952" height="8" background="../images/5.png"></td>
										<td background="../images/2.png"></td>
									</tr>
									<tr>
										<td width="8" background="../images/7.png"></td>
										<td height="100" align="center" valign="top">
											<table width="952" border="0" align="center" cellpadding="0"
												cellspacing="8">

												<tr>
													<td height="30" colspan="3" align="center" valign="middle"
														class="red_max">
														Create Offer
													<br />													</td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="text_h2">
														<span class="bla_low">Location<span
															class="red_text">*</span>:</span>
													<br /></td>
													<td colspan="2" align="left" valign="middle" class="text_h9">
												 
													
												 	<html:select property="restLocationId" 
															styleClass="restaurant_select" styleId="restLocationId1"   >
															<c:if test="${locationsInfoSize gt 1}">	
															<html:option value="-1">Select your option</html:option>
															<html:option value="0">----ALL----</html:option>
															 </c:if>
														 
																 <c:forEach items="${locationsInfo}" var="s">
																 <c:if test="${s.isActive eq 1 }" >
															<html:option value="${s.restLocationId}">${s.locationRestName}</html:option>
														 </c:if>
															 </c:forEach>
														</html:select>
												 
				<!-- 								<c:if test="${userInfo.roleId eq 5}">   
														<html:select property="restLocationId" 
															styleClass="restaurant_select" styleId="restLocationId1"   >
															<html:option value="-1">Select your option</html:option>
															<html:option value="0">----ALL----</html:option>
															 
															<bean:define id="relationships3" name="locationsInfo"
																 type="java.util.ArrayList" />
															<html:options collection="relationships3"
																property="restLocationId" labelProperty="locationRestName" />
															 
														</html:select>
														
														</c:if> -->	
                                                        <span class="red_text" id="locationmsg">
														<html:errors property="restLocationId"  /></span>
														 
													<br /></td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="text_h2">
														<span class="bla_low">Offer Name<span
															class="red_text">*</span>:</span>
													<br /></td>
													<td colspan="2" align="left" valign="middle" class="text_h9">
														<table align="left" border="0" cellpadding="0" cellspacing="0">
															<tr>
																<td align="left"  id="textDealId">
													   <html:hidden property="dealTemplateName"  styleId="dealNameId" value="custom" />
															
															<html:textarea property="customDealTemplateName" styleId="customDealId" styleClass="restaurant_input"  style="display:block;float:left;"></html:textarea>															
															
														
													
														 														</td>
																<td align="left" id="dealNameIDmsg"  class="red_text" >
																		
																		<html:errors property="dealTemplateName"/></td>
																<td >
																																	</td>
															</tr>
														</table>													</td>
												</tr>
												<!--<tr>
													<td width="22%" align="right" valign="middle"
														class="bla_low">
														
														<span class="red_text"></span>
													<br /></td>
													<td width="38%" align="left" valign="middle">
													<html:text property="customDealTemplateName" styleId="customDealId"  value=""></html:text>
														<span class="text_h9">
														  </span>
													<br /></td>
												</tr>-->
												<tr>
													<td width="22%" align="right" valign="middle"
														class="bla_low">
														Offer Description<span class="red_text">*</span>:
													<br /></td>
													<td width="38%" colspan="2" align="left" valign="middle">
												<span class="text_h9"  id="dealDesc" style="float:left;">
											 
				  
												   <html:hidden property="dealTemplateDescription" styleId="dealTemplateDescription"  value="" />
																	
													
																 
													
													
																</span>
																<span class="text_h9"  id="dealDesccust" style="display:block;float:left;" >																	
																	<html:textarea property="custdealdesc"  styleId="custdealdesc" styleClass="restaurant_input"/>	
																</span>									 
													
														<span class="red_text" id="custdealdescmsg"><html:errors property="dealTemplateDescription"/>
														  </span>
													<br /></td>
												</tr>
												<tr>
													<td width="22%" align="right" valign="middle"
														class="bla_low">
														Offer Restriction<span class="red_text">*</span>:
													<br /></td>
													<td colspan="2" align="left" valign="middle" >
													<div id="dealRetId">
														<span class="text_h9" id="dealrec"  style="float:left;" >
														<html:select property="dealTemplateRestrictionss"  
																		styleClass="restaurant_select"  styleId="dealTemplateRestrictionss" onchange="getChoices(this.form);" multiple="true" >
																		
														<bean:define id="relationships4" name="dropDownList"
																property="dealRestriction" type="java.util.ArrayList" />
																<c:forEach var="dealr" items="${dropDownList.dealRestriction}">
																<c:if test="${dealr.isActive eq 1}">
																  <html:option value="${dealr.restriction}">${dealr.restriction}</html:option>
																</c:if>
																</c:forEach>
															
														</html:select>		
														</span>
																<span class="text_h9"   style="float:left;" > <!-- showCount(event,this.value);   -->
														<html:textarea cols="20" rows="5" styleId="dealTemplateRestrictions" property="dealTemplateRestrictions"  onkeypress="return acceptData(event,this.value);" onkeyup="showCount(this.value);"></html:textarea>
													</span>
														 
														 </div>
														 <div id="dealRetId1" class="red_text"></div>
													  <html:errors property="dealTemplateRestrictions"/></td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														Days<span class="red_text">*</span>:												 </td>
													<td colspan="2" align="left" valign="middle" class="text_h9">
													
														<c:forEach var="pList" items="${dealRegForm.weekDays}" varStatus="status1">
			                        		                  
									                        				<c:set var="flag" value="ok" ></c:set>		
									                        	 
									                        			  	</c:forEach>	
														<html:checkbox property="weekDays" value="1" styleId="Sun" >Sun</html:checkbox>
														<html:checkbox property="weekDays" value="2" styleId="Mon" >Mon</html:checkbox>
														<html:checkbox property="weekDays" value="3" styleId="Tue" >Tue</html:checkbox>
														<html:checkbox property="weekDays" value="4" styleId="Tue" >Wed</html:checkbox>
														<html:checkbox property="weekDays" value="5" styleId="Thu" >Thu</html:checkbox>
														<html:checkbox property="weekDays" value="6" styleId="Fri" >Fri</html:checkbox>
														<html:checkbox property="weekDays" value="7" styleId="Sat" >Sat</html:checkbox>
													<span id="daysmsg" class="red_text">
													 <html:errors property="weekDays"/> </span>
													 </td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														Dates<span class="red_text">*</span>:													</td>
													<td colspan="2" align="left" valign="middle" class="text_h9">
														From
														<html:text property="startDate"    styleId="startDate"  readonly="true" onchange="change_date_format(this.value); " />
													<img ID="date_dtp1" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />
														<html:errors property="startDate" />
														&nbsp; To
															<html:text property="dealEndDate"  styleId="dealEndDate"  readonly="true" styleClass="restaurant_input" 
														onchange="change_date_format2(this.value);"/>
														<img ID="date_dtp2" style="CURSOR: hand" border="0" src="../images/calendar.gif" align="middle" />
														<span id="todatemsg" class="red_text"><html:errors property="dealEndDate" /></span></td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="text_formsub">
														<span class="bla_low">Time</span>:													</td>
													<td colspan="2" align="left" valign="middle" class="text_h9">
														From
														<html:select  styleClass="restaurant_select" property="availableStartTime" styleId="select"  onchange="getTotime(this.value)">
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
															<html:option value="13:00">1:00 pm</html:option>															
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
															<html:select  styleClass="restaurant_select" property="availableEndTime" styleId="selectend">
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
															<html:option value="13:00">1:00 pm</html:option>															
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
													<br /></td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														QTY<span class="red_text">*</span>:
													<br /></td>
													<td align="left" valign="middle" class="text_h9">
														<html:text  styleClass="restaurant_select"  onkeypress="return isNumberKey(event)"  property="availableDealsQty" styleId="select"> </html:text>
														<span class="red_text" id="qtymsg"><html:errors property="availableDealsQty" /></span><br /></td>
												    <td width="200" height="100" rowspan="3" align="right" valign="top" class="text_h9">
												    <div id="imageid" style="display:none;">
												    <img src="" border="0"/></div>
												    
												    </td>
												</tr>
												<tr>
													<td align="right" valign="middle" class="bla_low">
														Recurring<span class="red_text">*</span>:
													<br /></td>
													<td align="left" valign="middle" class="text_h9">
														<html:radio property="isRecurring" styleId="radio" value="1" />
														Yes or
														<html:radio property="isRecurring" styleId="radio2" value="0" />
														No
													<span class="red_text" id = "recurmsg"><html:errors property="isRecurring" /></span></td>
											    </tr>
											    
											    
											    	<!-- 	<tr>
													<td align="right" valign="middle" class="bla_low">
														Event Type:
													<br /></td>
													<td align="left" valign="middle" class="text_h9">
														 
														 
												<html:select property="eventId" styleClass="restaurant_select" styleId="events" >
												<html:option value="0">Select Event </html:option>
												<bean:define id="relationships7" name="dropDownList" property="events" type="java.util.ArrayList"/>
												<html:options collection="relationships7" property="eventId" labelProperty="eventName"/>
												</html:select>

													<html:errors property="isRecurring" /></td>
											    </tr>	 -->					       <!--<tr>
			                                          <td colspan="2" align="center" valign="middle" class="text_h10">[NOTE:*An image size of approx. 220(width) x 225(height) pixels is recommended.*]
			                                          </td>
		                                           </tr>
													
												<tr>
													<td align="right" valign="middle" class="bla_low">
												  <div  >Select TangoTab Image:</div>
													<br /></td>
													<td align="left" valign="middle" class="text_h9">
													   <div>
													  	<html:text styleClass="restaurant_fileupload" styleId="fileField"  readonly="true" property="existImagePath"/>
													  	<input type="button" id="imageId" name="imageId" value="choose" onclick="showImages()"/>
													  	</div>
													 	<span class="red_text" id="existImagePathmsg"></span> 
													<br /></td>
											    </tr> -->
											    <tr>
			                                      <td colspan="2" align="center" valign="middle" class="text_h10">
			                                       <div id="imageuploadN" style="display: block;">[NOTE:*An image size of 190(width) x 130(height) pixels is recommended.*]
			                                        </div></td>
		                                        </tr>
											    			<tr>
													<td align="right" valign="middle" class="bla_low">
												  <div id="imageupload" style="display:block;">Upload Host Image<span class="red_text">*</span>:</div>
													<br /></td>
													<td align="left" valign="middle" class="text_h9">
													  <div id="imageupload1" style="display: block;float:left;"> 	<html:file
															styleClass="restaurant_fileupload" styleId="dealImage" property="dealImage"/>
															</div>
																<div class="red_text" id="dealImagemsg" style="float:left;"></div> 
													<br /></td>
											    </tr>
												<tr>
													<td height="55" colspan="3" align="center" valign="middle" >
													<div id="submitone">
												  		<table width="440" border="0" align="center"
															cellpadding="0" cellspacing="4">
															<tr>
															    <td align="center" valign="middle" width="110">
																	<div id="select_hot">
																		<a href="viewDeals.do">Cancel</a>	
																	</div>	
 																</td>
 																<!-- <td align="center" valign="middle" width="110">
																	<div id="select_hot">
																		<a href="createDeal.do">Reset</a>																	</div>																</td> -->
																
 																<td align="center" valign="middle" width="110">
 																     <div id="select_hot">
																		  <a href="javascript:dealPreview()">Preview</a>	
																     </div> 
																</td>
																<td align="center" valign="middle" width="110">
																	<div id="select_hot">
																		<html:submit styleClass="but_img" property="submit"
																				styleId="submitID" onclick="showET();" >Save</html:submit>
																	</div>																 </td>
															</tr>
														</table>		
														</div>
														<div id="submitinfo" class="red_max" style="display: none;">
														<img src="../images/ajax-loader.gif"  /> <br/>  <b>Please wait...</b>
														</div>											</td>
												</tr>
												<c:if test="${ not empty dealRegForm.dealTemplateName}">
											
					<script>getDealInfo(2); 
						

				  
						
						</script></c:if> 
											</table>
									  <br /></td>
										<td width="8" background="../images/8.png"></td>
									</tr>
									<tr>
										<td height="8" background="../images/3.png"></td>
										<td height="8" background="../images/6.png"></td>
										<td height="8" background="../images/4.png"></td>
									</tr>
								</table>
								<!-- form End-->
								</html:form>
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