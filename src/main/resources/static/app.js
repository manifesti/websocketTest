var stompClient = null;

function setConnected(connected) {
    if (connected) {
    	$("#greetings").append("<tr><td><b>Connected!</b></td></tr>");
    }
    else {
    	$("#greetings").append("<tr><td><b>Disconnected!</b></td></tr>");
    }
}

function connect() {
    var socket = new SockJS('/hswebsocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
    	setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/websocket/hello", {}, JSON.stringify({ 'username':$("#username").val() , 'message': $("#message").val()}));
}

function showGreeting(data) {
    var formatdate = moment(new Date(data.date));
    $("#greetings").append("<tr><td><span style=\"float:right\"><b>"+ formatdate.format("DD.MM.YYYY HH:mm:ss") + "</b></span><b>" + data.username + "</b><br> " + data.message + "</td></tr>");
}

$(function () {
	$( "#disconnect" ).hide();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
	$( "#disconnect" ).click(function() { 
		$( "#disconnect" ).hide();
		$( "#connect" ).show();
		disconnect();
	});
	$( "#connect" ).click(function() {
		$( "#connect" ).hide();
		$( "#disconnect" ).show();
		connect();
	});
    $( "#send" ).click(function() { 
    	sendMessage(); 
    	$("#message").val("");
    });
});