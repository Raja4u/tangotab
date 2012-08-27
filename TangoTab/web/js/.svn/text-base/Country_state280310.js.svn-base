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
	 
	function getDealInfo(){
		dealId = dwr.util.getValue('dealNameId');
		dealDesc=document.getElementById("dealDesc");
		dealRestriction = document.getElementById("dealRestriction")
		if(dealId!=null && dealId!="" && dealId=="custom"){
			document.getElementById("customDealId").style.display = 'block';
			document.getElementById("imageid").style.display = 'none';
			
			document.getElementById("imageupload").style.display = 'block';
			document.getElementById("imageupload1").style.display = 'block';
			dealDesc.removeAttribute("readOnly");
			dealDesc.value="";
			dealRestriction.removeAttribute("readOnly");
			dealRestriction.value=""
		}else{
			document.getElementById("customDealId").style.display = 'none';
			document.getElementById("imageid").style.display = 'block';
			document.getElementById("imageupload").style.display = 'none';
			document.getElementById("imageupload1").style.display = 'none';
			dealDesc.setAttribute("readOnly",true);
			dealRestriction.setAttribute("readOnly",true);
			DealDescr.getDealDescriptionsByNameId( dealId,function(data) {
				if(data!=null){
				
					
					nameId=dwr.util.getValue('dealNameId');
					dwr.util.removeAllOptions("descriptions");
					dwr.util.addOptions("descriptions",["Select Description"]);
				 
				 
					dwr.util.addOptions("descriptions", data, "description", "description");
						}
			});
		    	 
		  		 
		}
	} 
	
	 
	function checkEmail(){
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
}
function getDealDesc(){
	
	nameId=dwr.util.getValue('dealNameId');
	dwr.util.removeAllOptions("descriptions");
	dwr.util.addOptions("descriptions",["Select Description"]);
	DealDescr.getDealDescriptionsByNameId( nameId,function(data) {
 
	dwr.util.addOptions("descriptions", data, "description", "description");
		});
}