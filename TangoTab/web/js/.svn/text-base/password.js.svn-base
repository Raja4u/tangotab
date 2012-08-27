function CheckPassword(password)  

{  

var strength = new Array();  

strength[0] = "Blank";  

strength[1] = "Very Weak";  

strength[2] = "Weak";  

strength[3] = "Medium";  

strength[4] = "Strong";  

 strength[5] = "Very Strong";  
 

var score = 1;  



 if (password.length < 1)  

return strength[0];  



if (password.length < 4)  

   return strength[1];  



 if (password.length >= 8)  

 score++;  

 if (password.length >= 12)  

 score++;  

 if (password.match(/\d+/))  

score++;  

if (password.match(/[a-z]/) &&  

password.match(/[A-Z]/))  

score++;  

if (password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,£,(,)]/))  

 score++;  

 

return strength[score];  
