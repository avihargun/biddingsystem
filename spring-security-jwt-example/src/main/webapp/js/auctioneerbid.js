var stompClient = null;

    var socket = new SockJS('/bidsocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/bid/returnbid', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
        
        stompClient.subscribe('/bid/placebid', function (showbid) {
            showBid(JSON.parse(bid.body));
        });
    });         



function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': $("#name").val()}));
}         

function showGreeting(message) {
	
	var b_id="#"+ message.itemId+"b";
	//console.log("greetings",b_id);
    $(b_id).html(message.rbid);
}
 
function showBid(showbid)
{
	console.log("showbid",showbid.bidderEmail);
}
function trigger(id)
{
	var v = "#"+id+"t"
	var value= $(v).val();
	console.log("id",id,value);
	stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': value, 'itemId':id}));
	
}

function highbid(id,eno,bidvalue)
{
	console.log("itemid",id,"eno",eno,"bidvalue",bidvalue);
	//stompClient.send("/app/hello1", {}, JSON.stringify({'bidValue': value, 'itemId':id,'eventNo':eno}));
	
}

$(function () {
    $("#bid").click(function (e) {
        e.preventDefault();
        stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': $("#bid-value").val()}));
    });

    
});