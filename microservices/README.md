

var ws;
if (window.WebSocket){
    ws = new WebSocket("http://localhost:8080");
    ws.onopen = function(){
        console.log("onopen");
    };
    ws.onmessage = function (e) {
        console.log("echo from server " + e.data);
    };
    ws.onclose = function(){
        console.log("onclose");
    };
    ws.onerror = function(){
        console.log("onerror");
    };
}
else { console.log("WebSocket not supported in your browser");}



var ws;
if (window.WebSocket){
    ws = new WebSocket("ws://localhost:8080/websocket");
    ws.onopen = function(){
        console.log("onopen");
    };
    ws.onmessage = function (e) {
        console.log("echo from server " + e.data);
    };
    ws.onclose = function(){
        console.log("onclose");
    };
    ws.onerror = function(){
        console.log("onerror");
    };
}
else { console.log("WebSocket not supported in your browser");}