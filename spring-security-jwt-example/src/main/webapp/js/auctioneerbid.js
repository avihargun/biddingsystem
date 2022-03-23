var stompClient = null;

    var socket = new SockJS('/bidsocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/bid/returnbid', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });         



function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': $("#name").val()}));
}         

function showGreeting(message) {
    $("#bidchange").html(message.rbid);
}

$(function () {
    $("#bid").click(function (e) {
        e.preventDefault();
        stompClient.send("/app/hello", {}, JSON.stringify({'bidValue': $("#bid-value").val()}));
    });

    
});