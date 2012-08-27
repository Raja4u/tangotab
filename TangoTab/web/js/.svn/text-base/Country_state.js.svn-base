function getCountryDetails(){
	Countries.getCountries( function(data) {
    dwr.util.addOptions("countries", data, "countryId", "countryName");
	});
		
	}
	
	
	function getStates(){
		countryCode=dwr.util.getValue('countries');
		dwr.util.removeAllOptions("states");
		dwr.util.addOptions("states",["Select State"]);
		Countries.getStatesByCountry( countryCode,function(data) {
    	dwr.util.addOptions("states", data, "stateId", "stateName");
  		});
	}
	
	function getCities(){
		stateCode=dwr.util.getValue('states');
		dwr.util.removeAllOptions("cities");
		dwr.util.addOptions("cities",["Select City"]);
		Countries.getCitiesByState( stateCode,function(data) {
    	dwr.util.addOptions("cities", data, "cityId", "cityName");
    	
  		});
	} 
	 
	function getDealInfo(id){
		dealId = dwr.util.getValue('dealNameId');
 //alert(dealId);
		dealRestriction = document.getElementById("dealTemplateRestrictions")
		if(dealId!=null && dealId!="" && dealId=="custom"){
		//	alert('sd');
			document.getElementById("customDealId").style.display = 'block';
			
			document.getElementById("dealDesc").style.display = 'none';			
		 	document.getElementById("dealDesccust").style.display = 'block';
		 	document.getElementById("imageupload").style.display = 'block';
			document.getElementById("imageupload1").style.display = 'block';
			document.getElementById("imageuploadN").style.display = 'block';
			dealRestriction.removeAttribute("readOnly");
			if(id==1)
			dealRestriction.value=""
				
		}else{
			document.getElementById("customDealId").style.display = 'none';
		 	document.getElementById("dealrec").style.display = 'block';
			document.getElementById("dealDesc").style.display = 'block';
		 	document.getElementById("dealDesccust").style.display = 'none';
			document.getElementById("imageupload").style.display = 'none';
 			document.getElementById("imageupload1").style.display = 'none';
 			document.getElementById("imageuploadN").style.display = 'none';
			
		 	dealRestriction.setAttribute("readOnly",true);
			DealDescr.getDealDescriptionsByNameId( dealId,function(data) {
	 
				if(data!=null){
					 
		    	
					nameId=dwr.util.getValue('dealNameId');
					dwr.util.removeAllOptions("dealTemplateDescription");
					dwr.util.addOptions("dealTemplateDescription",["Select your option"]);
				 
				 
					dwr.util.addOptions("dealTemplateDescription", data, "description", "description");
				 	}
		  		});
	 
			 
		}
		
	}
	
	/*function checkEmail(){
		var emailId = dwr.util.getValue("emailId");
	 
		if(emailId!=null && emailId.trim()!=""){
			deal.checkUserAvailability( emailId,function(data) {
			    	if(data==true){
			    		document.getElementById("checkEmailId").innerHTML="Email Id already existed";
			    	}else{
			    		document.getElementById("checkEmailId").innerHTML="";
			    	}
			 });	
		}else{
				document.getElementById("checkEmailId").innerHTML="Email Id is required";
		}
}*/
	function checkEmail(roleId){
		var emailId = dwr.util.getValue("emailId");
	 
		if(emailId!=null && emailId.trim()!=""){
			deal.checkUserAvailability( emailId,roleId,function(data) {
			    	if(data==true){
			    		document.getElementById("checkEmailId").innerHTML="";
			    		document.getElementById("checkEmailId").innerHTML="Email already exists";
			    	}else{
			    		document.getElementById("checkEmailId").innerHTML="";
			    	}
			 });	
		}else{
				document.getElementById("checkEmailId").innerHTML="Email Id is required";
		}
}
	function searchDeals(cityName)
	{
		cityName="";
  
		deal.searchByCityDeals( cityName,function(data) {
 
	 });	
	}