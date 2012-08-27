<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<fmt:setBundle basename="socialintg"></fmt:setBundle>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> TangoTab </title> 

<link href="../css/bookdealpopover.css" rel="stylesheet" type="text/css" />    
<style>
#OVER{width:100%; height:100%; left:0px;/*IE*/ top:0px; text-align:center; z-index:5; position:fixed; filter:alpha(opacity=20); opacity:0.2; background-color:#fff;}
#overlay {width:40%; height:50%; z-index:6; display:inline; left:38%;/*IE*/ top:30%; font-color:#cdcdcd; font-size:0.8em;
filter:alpha(opacity=100); opacity:1;text-align:center; position:fixed; background-color:#777;}
#popupContactdeal {-webkit-border-radius: 40px;
-moz-border-radius: 40px;
border-radius: 40px; width:330px; height:auto; padding:10px;
border:solid 1px #000;  left:35%; top:40%;valign:middle;

}
#popupContactdeal h2{text-align: center; color: #000; margin-bottom:15px;}
#popupContactdeal p{color: #000; margin-bottom:15px;}
</style>
<script>
		!window.jQuery && document.write('<script src="../js/jquery-1.4.3.min.js"><\/script>');
	</script>
	<script type="text/javascript">

	$(document).ready(function() {
	document.getElementById('popupContactdeal').style.display='block';
		document.getElementById('backgroundPopupdeal').style.display='block';
	});
	function close(){
		document.getElementById('popupContactdeal').style.display='none';
		document.getElementById('backgroundPopupdeal').style.display='none';
	}
	</script>

<body>
<jsp:include page="index.jsp"></jsp:include>
<div id="popupContactdeal" style="display:none;">
		<span style="position: absolute;    right: -30px;    top: -11px;padding-right:5px;vertical-align:top;">
		<a  id="popupContactClose" href="javascript:close();"><img src="../images/close_popup.png" border="0" /></a>
		</span>
		<div>
		Thank you for signing up.<br/>   TangoTab feeds a person in need each time you dine out with one of our offers.
		</div><br/>
		<center><div style="border: solid 1px;border-radius: 10px;width: 250px;height: 35px;background: #80953A">
		<a href="searchForward.do" ><span style="color: white;display: block;padding-top: 5px"><b><i>Find your first offer</i></b></span></a></div></center><br/>
	</div>
	<div id="backgroundPopupdeal"  style="display:none;">
	  </div> 

</body>
</html>
<fmt:message key='website.home'></fmt:message>