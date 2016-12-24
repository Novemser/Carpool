<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/14
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src='<c:url value="/static/js/stomp.js"/>' type="text/javascript"></script>
<script src='<c:url value="/static/js/sockjs-1.1.1.js"/>' type="text/javascript"></script>
<script>


    var host = window.location.host;
    var websocket;
    var msgCount = 0;


    websocket = new WebSocket("ws://" +host+"/webSocketServer");

    websocket.onopen = function (evnt) {
        getChatHis();
    };
    websocket.onmessage = function (evnt) {

        msgCount++;

        var msg = JSON.parse(evnt.data);

        var year = msg["year"]-100+2000;

        var chatItem = " <div class=\"msg-time-chat\"> <a href=\"#\" class=\"message-img\"><img class=\"avatar\" src=\"#\" alt=\"\"></a> <div class=\"message-body msg-in\"> <span class=\"arrow\"></span> <div class=\"text\" style=\"overflow-x: scroll\"> <p class=\"attribution\"><font color=\'#5f9ea0\'>"+msg["username"]+"</font> at "+msg["hour"]+":"+msg["minute"]+"pm, "+msg["day"]+"th "+msg["month"]+" "+year+"</p> <p>" + msg["chatContent"] +"</p> </div> </div> </div>"

        var newHtml = $("#messagebox").html();
        $("#messagebox").html(newHtml + chatItem);

        if(msgCount > 6){
            var chatContent = document.getElementById ('messagebox');
            chatContent.scrollTop = chatContent.scrollHeight;
        }
    };
    websocket.onerror = function (evnt) {
        alert(error);
    };
    websocket.onclose = function (evnt) {
    }

    function send(){
        var input = $('#inputContent');
        var inputValue = input.val();
        input[0].value = "";
        var date = new Date();

        var content = JSON.stringify({
            'type':1,
            'userid':${userid},
            'username':"${username}",
            'room':${room.id},
            'year':date.getYear().toString(),
            'month': date.getMonth().toString(),
            'day':date.getDay().toString(),
            'hour':date.getHours().toString(),
            'minute':date.getMinutes().toString(),
            'chatContent':inputValue
        });
        websocket.send(content);
    }

    function getChatHis(){
        websocket.send(JSON.stringify({'type':3, 'roomId':${room.id}}));
    }


</script>

<div class="row center-block" style="margin-bottom: 90px;">
    <div class="col-lg-8 col-lg-offset-2 text-center detail_dev">
        <section class="panel card">
            <header class="panel-heading">
                Chats
            </header>
            <div class="panel-body">

                <div class="timeline-messages" id = "messagebox">


                </div>
                <div class="chat-form">
                    <div class="input-cont ">
                        <input id = "inputContent" type="text" class="form-control col-lg-12" placeholder="Type a message here...">
                    </div>
                    <div class="form-group">
                        <div class="pull-right chat-features">
                            <a href="javascript:;">
                                <i class="icon-camera"></i>
                            </a>
                            <a href="javascript:;">
                                <i class="icon-link"></i>
                            </a>
                            <a class="btn btn-danger" onclick="send()" id = "sendButton">Send</a>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </div>
</div>
<script>
    var chatContent = document.getElementById ('messagebox');
    chatContent.scrollTop = chatContent.scrollHeight;

</script>