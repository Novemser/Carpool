<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/8
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="<c:url value="/static/css/room-list.css"/>"/>
<section class="panel col-center-block col-lg-6 col-md-10 col-sm-12">
    <div class="panel-body">
        <div class="alert alert-success alert-block fade in">
            <h4>
                <i class="fa fa-check-circle fa-2x" style="color: green;line-height: 60px">
                    <span style="color: green; font-size: 25px; margin-bottom: 2px;vertical-align: middle;">创建成功!</span>
                </i>
            </h4>
            <h4>您的房间信息如下:</h4>
            <hr>
            <div class="text text-center room-title">${room.roomname}</div>
            <dl class="dl-horizontal">
                <dt>出发时间</dt>
                <dd>${room.startDate} ${room.startTime}</dd>
                <dt>起点</dt>
                <dd>${room.startPoint}</dd>
                <dt>终点</dt>
                <dd>${room.endPoint}</dd>
                <dt>人数上线</dt>
                <dd>${room.numberLimit}</dd>
                <dt>备注</dt>
                <dd>${room.note}</dd>
            </dl>
            <hr>
            <div style="margin: 10px">
                <i class="fa fa-commenting"></i><a href="/room/chat?roomId=${room.id}"> 点击进入聊天室</a>
            </div>
        </div>
    </div>
</section>
<style type="text/css">
    .col-center-block {
        float: none;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
</style>