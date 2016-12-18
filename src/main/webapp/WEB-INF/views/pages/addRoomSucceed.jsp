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
                <i class="icon-ok-sign"></i>
                添加房间成功!
            </h4>
            <p>您的房间信息如下:</p>
            <hr>
            <div class="text text-center room-title">${room.roomname}</div>
            <dl class="dl-horizontal">
                <dt>时间</dt>
                <dd>${room.startDate} ${room.startTime}</dd>
                <dt>出发地点</dt>
                <dd>${room.startPoint}</dd>
                <dt>目的地</dt>
                <dd>${room.endPoint}</dd>
                <dt>人数上线</dt>
                <dd>${room.numberLimit}</dd>
            </dl>
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