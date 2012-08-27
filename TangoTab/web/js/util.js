	function isNumberKey(evt)
  {
     var charCode = (evt.which) ? evt.which : event.keyCode
     if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;

     return true;
  }
 function isSpace(evt)
 {
 
			
   var charCode = (evt.which) ? evt.which : event.keyCode
 
   if (charCode ==32)
   {
	   alert("Please Enter Valid characters");
      return false;
   }

   return true;
}
 
function hidetext(id)
{			if(document.getElementById(id))
			document.getElementById(id).innerHTML = "";
}
	
 function removetext(id,val)
 { 	 
 	 if(id.value==val)
	 {
		 id.value='';
	 } 
 }
 
 
 function validateZipCode(zipCodeID)//getting the value 
	 {
	 
	  var data=zipCodeID.trim();
	  if(zipCodeID.trim().length>6){ //checking whether zipcode length is 7 or not
	  var zipvalidation=/^[0-9a-zA-Z][0-9a-zA-Z][0-9a-zA-Z]\s[0-9a-zA-Z][0-9a-zA-Z][0-9a-zA-Z]$/g;
      if(zipvalidation.test(data)){ //checking condition which should be in xxx xxx
    	  return true;
 	   
	   }
	   else{
	   	    // document.getElementById("zcode").innerHTML = "Invalid ZipCode";
	          return false;
	      }	
	    return false;	//if length is not correct returning false 
	  }
	 
	   return noSpaceZip(zipCodeID); //if the above condition is false call noSpaceZip()
   }  
	     
   function noSpaceZip(zipCodeID)     //checking whether zipcode contains whitespaces or not(5or6digits)
	 {
	   
	  var data=zipCodeID.trim();
	  var zipcodenospace= /^[0-9a-zA-Z]*$/g;
	 
	    if(zipcodenospace.test(data)){ //checking condition	
	    //document.userForm.zipCode.value=data ;
	     return true;    
		 }
		 else{
		    //document.getElementById("zcode").innerHTML = "white spaces are not allowed";
		    return false
		   }
	}
 
 
 
 
 
function trim(str)
{
    if(!str || typeof str != 'string')
        return null;
   
    return str.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
 
}

function Ltrim(item)

{
 
  item.value = item.value.replace(/\r/g, " ");
  item.value = item.value.replace(/[^ A-Za-z0-9`~!@#\$%\^&\*\(\)-_=\+\\\|\]\[\}\{'";:\?\/\.>,<]/g, "");
  item.value = item.value.replace(/'/g, "");
  item.value = item.value.replace(/ +/g, " ");  
  item.value = item.value.replace(/^\s/g, "");
  item.value = item.value.replace(/\s$/g, "");	
  if (item.value == ' '){item.value = ''};
}

function putFirstName1(){
        if(document.getElementById('firstName').value == null || document.getElementById('firstName').value == "")
          document.getElementById('firstName').value = 'First Name';
        }
        function putLastName1(){
        if(document.getElementById('lastName').value == null || document.getElementById('lastName').value == "")
          document.getElementById('lastName').value = 'Last Name';
        }
        function putEmailId1(){
        if(document.getElementById('emailId').value == null || document.getElementById('emailId').value == "")
          document.getElementById('emailId').value = 'Email';
        }
        function putPassword1(){
        if(document.getElementById('password').value == null || document.getElementById('password').value == "")
          document.getElementById('password').value = 'Password';
        }
        function putZipCode1(){
        if(document.getElementById('zipCodeID').value == null || document.getElementById('zipCodeID').value == "")
          document.getElementById('zipCodeID').value = 'Zip Code'; 
        }

        function clickedBodyUtil(){
        //alert('body'+document.getElementById('formClicked').value);

        if(document.getElementById('formClicked').value == "false"){

         putFirstName1();
         putLastName1();
         putEmailId1();
         putPassword1();
         putZipCode1();
         
          }
          document.getElementById('formClicked').value = "false";
        }

        function clickedFormUtil(element,elevalue){
        //alert("form"+id);
        document.getElementById('formClicked').value = "true";
      var id = element.id;
        if(id == 'firstName'){
         //putFirstName1();
              if(element.value==elevalue)
                   {
                    element.value='';
                   } 
         putLastName1();
         putEmailId1();
         putPassword1();
         putZipCode1();
        }

        if(id == 'lastName'){
              if(element.value==elevalue)
                   {
                    element.value='';
                   }
         putFirstName1();
        // putLastName1();
         putEmailId1();
         putPassword1();
         putZipCode1();
        }


        if(id == 'emailId'){
              if(element.value==elevalue)
                   {
                    element.value='';
                   }
        putFirstName1();
         putLastName1();
        // putEmailId1();
         putPassword1();
         putZipCode1();
        }

        if(id == 'password'){
              if(element.value==elevalue)
                   {
                    element.value='';
                   }
        putLastName1()();
         putLastName1();
         putEmailId1();
         //putPassword1();
         putZipCode1();

        }

        if(id == 'zipCodeID'){
              if(element.value==elevalue)
                   {
                    element.value='';
                   }
        putFirstName1();
         putLastName1();
         putEmailId1();
         putPassword1();
         //putZipCode1();

        }


        }
