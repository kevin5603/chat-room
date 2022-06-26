var stompClient = null;

function connect() {
    var socket = new SockJS('/my-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
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

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function sendName() {
    stompClient.send("/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

var i = 0;

function showGreeting(message) {
    const left = "<h1>" + message + "</h1>";
    const right = "<h1 style=\"text-align:right\">" + message + "</h1>";
    $("#content").append(i % 2 == 0 ? left : right);
    i = i + 1;
}

// connect();