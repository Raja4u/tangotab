<?PHP

function authSendEmail($from,  $to,  $subject, $message)
{
//SMTP + SERVER DETAILS
/* * * * CONFIGURATION START * * * */
$smtpServer = "localhost";
$port = "25";
$timeout = "30";
$username = "";
$password = "";
$localhost = "localhost";
$newLine = "\r\n";
/* * * * CONFIGURATION END * * * * */

//Connect to the host on the specified port
$smtpConnect = fsockopen($smtpServer, $port, $errno, $errstr, $timeout);
$smtpResponse = fgets($smtpConnect, 515);
if(empty($smtpConnect)) 
{
$output = "Failed to connect: $smtpResponse";
return $output;
}
else
{
$logArray['connection'] = "Connected: $smtpResponse";
}

//Request Auth Login
fputs($smtpConnect,"AUTH LOGIN" . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['authrequest'] = "$smtpResponse";

//Send username
fputs($smtpConnect, base64_encode($username) . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['authusername'] = "$smtpResponse";

//Send password
fputs($smtpConnect, base64_encode($password) . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['authpassword'] = "$smtpResponse";

//Say Hello to SMTP
fputs($smtpConnect, "HELO $localhost" . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['heloresponse'] = "$smtpResponse";

//Email From
fputs($smtpConnect, "MAIL FROM: $from" . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['mailfromresponse'] = "$smtpResponse";

//Email To
fputs($smtpConnect, "RCPT TO: $to" . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['mailtoresponse'] = "$smtpResponse";

//The Email
fputs($smtpConnect, "DATA" . $newLine);
$smtpResponse = fgets($smtpConnect, 515);
$logArray['data1response'] = "$smtpResponse";

//Construct Headers
$headers = "MIME-Version: 1.0" . $newLine;
$headers .= "Content-type: text/html; charset=iso-8859-1" . $newLine;

fputs($smtpConnect, "To: $to\nFrom: $from\nSubject: $subject\n$headers\n\n$message\n.\n");
$smtpResponse = fgets($smtpConnect, 515);
$logArray['data2response'] = "$smtpResponse";

// Say Bye to SMTP
fputs($smtpConnect,"QUIT" . $newLine); 
$smtpResponse = fgets($smtpConnect, 515);
$logArray['quitresponse'] = "$smtpResponse"; 
}


 $body = '<html><head><style type="text/css">

#container { 
	width: 520px;
	font-size:11px; 
	font-family:lucida grande,tahoma,verdana,arial,sans-serif;
	color:#393939;
}
.nospace { display: block; }
.image { margin: 0 auto; }


.maina_title {
	font-size:16px;
	color:#009ebc;
	font-weight:bold;}
	
	
.blue_frame {padding:10px;
border:solid 1px #009ebc;}

.for_left {padding-right:10px;
padding-top:10px;
padding-bottom:10px;
width:150px;
	font-size:11px; 
	font-family:lucida grande,tahoma,verdana,arial,sans-serif;
	color:#393939;}

.for_right {border:#009ebc solid 1px;
width:250px;
	font-size:11px; 
	font-family:lucida grande,tahoma,verdana,arial,sans-serif;
	color:#393939;}
	
.text {font-size:11px; 
	font-family:lucida grande,tahoma,verdana,arial,sans-serif;
	color:#393939;}
	
.for_left_missing {padding-right:10px;
padding-top:10px;
padding-bottom:10px;
width:150px;
	font-size:11px; 
	font-family:lucida grande,tahoma,verdana,arial,sans-serif;
	color:#eb0d0d;}

.for_right_missing {border:#eb0d0d solid 2px;
width:250px;
	font-size:11px; 
	font-family:lucida grande,tahoma,verdana,arial,sans-serif;
	color:#393939;}
</style></head><body> 
<div id="container">
<div class="blue_frame">
<table width="480" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><div class="for_left" align="right">Gender:</div></td>
    <td>
  <font class="text">'.$_POST["toon"].'</font> 
</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lFirstName">* First Name:</div> </td>
    <td>'.$_POST["FirstName"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lLastName">* Last Name:</div></td>
    <td>'.$_POST["LastName"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lEmail">* Email:</div></td>
    <td>'.$_POST["Email"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right">Phone Number:</div></td>
    <td>'.$_POST["PhoneNumber"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lStreet">* Street:</div></td>
    <td>'.$_POST["Street"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lCity">* City:</div></td>
    <td>'.$_POST["City"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right">* State:</div></td>
    <td>'.$_POST["State"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lZip">* Zip:</div></td>
    <td>'.$_POST["Zip"].'</td>
  </tr>
  <tr>
    <td><div class="for_left" align="right" id="lComments">* Comments:</div></td>
    <td>'.$_POST["comments"].'</td>
  </tr>
</table></div></div></body>';

echo authSendEmail("Payitforward@fruit-66.com","Payitforward@fruit-66.com","Pay It Forward Kick Start Entry Submission",$body);
header("Location: http://www.fruit-66.com/about/pay-it-forward.htm");



?>
