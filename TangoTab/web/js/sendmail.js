$(document).ready(function(){
	
$("#email_like").click(function()
{
	//console.debug('Email Like');
	//console.debug($("#email_like").position());
	var position=$("#email_like").position();
	var top=position.top+21;
	var left=position.left+80-290;
	
	
	var divStayle='position:absolute;left:'+left+'px;top:'+top+'px';
	//console.debug(divStayle);
	$("#dialog").attr('style',divStayle).show();
	return false;
});

	$('#cancel').click(function(ev){
        ev.preventDefault();
        $("#dialog").hide();
    });

   /* $("#dialog").dialog({
        autoOpen: false,
        width: 450,
        position: ['right', 'top'],
        show: 'blind',
    });
    //handling the pop-up event.
    $('#email_like').click(function(ev){
        $("#dialog").dialog("open");
        
    });
    $('#cancel').click(function(ev){
        ev.preventDefault();
        $("#dialog").dialog("close");
        
    });*/
    $('#send').click(function(ev){
        if (($('#to').val() == "") ||
        ($('#from').val() == "")) {
            alert("Please enter all fields");
            $("#from").focus();
            //return false();
        }
        ev.preventDefault();
        var to = $('#to');
        //console.debug(to);
        var from = $('#from');
        //console.debug(from);
        var message = $('#message');
        
        var data = 'to=' + to.val() + '&from=' + from.val() +
        '&message=' +
        message.html();
		//console.debug(data);        
        $.ajax({
            url: "../SendMail",
            type: "post",
            data: data,
            success: function(reponse){
                //console.debug(reponse);
                //$("#dialog").html(reponse).show();
				$("#dialog").hide();
				//setTimeout("refreshmsgs()", 5000);
            }
            
        });
    });
});
// To show the Message sended successly .
function refreshmsgs(){
    //$("#dialog").html("").show();
$("#dialog").hide();
}
