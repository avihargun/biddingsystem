var stompClient = null;

    var socket = new SockJS('/bidsocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/bid/returnbid', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
        
        stompClient.subscribe('/bid/placebid', function (showbid) {
            showBid(JSON.parse(showbid.body));
        });
    });         



function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': $("#name").val()}));
}         

function showGreeting(message) {
	var b_id="#"+ message.itemId+"b";
	setTimeout(()=>{
		$(b_id).html("bid completed")
	},10000)
	
	//console.log("greetings",b_id);
    $(b_id).html(message.rbid);
}
 
function showBid(showbid)
{
	console.log("showbid",showbid.bidderEmail,$("#b_id").val());
	var div_id="#"+showbid.itemId+"c";
	$(div_id).text("highbid:"+showbid.bidValue+" by " + showbid.bidderEmail );
	var bu_id="#"+ showbid.itemId+"b";
	var newbid=showbid.bidValue + 10;
    $(bu_id).html(newbid);
    
	if($("#b_id").val()==showbid.bidderEmail)
	{

    	$(bu_id).prop('disabled',true);
	}
	else
	{
		$(bu_id).prop('disabled',false);
	}
	
}
function trigger(id)
{
	var v = "#"+id+"t"
	var value= $(v).val();
	console.log("id",id,value);
	stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': value, 'itemId':id}));
	
}

function highbid(id,eno,bidvalue,bidderemail)
{
	//console.log("itemid",id,"eno",eno,"bidvalue",bidvalue,"bidderemail",bidderemail);
	stompClient.send("/app/hello1", {}, JSON.stringify({'bidValue': bidvalue, 'itemId':id,'eventNo':eno,'bidderEmail':bidderemail}));
	
}

$(function () {
    $("#bid").click(function (e) {
        e.preventDefault();
        stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': $("#bid-value").val()}));
    });

    
});