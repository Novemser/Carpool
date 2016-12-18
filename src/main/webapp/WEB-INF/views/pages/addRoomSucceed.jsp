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
<section class="card col-center-block col-lg-6 col-md-10 col-sm-12" style="background: white;">
    <div class="panel-body">
        <div class="fade in">
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
                <dt>人数上限</dt>
                <dd>${room.numberLimit}</dd>
                <dt>备注</dt>
                <dd>${room.note}</dd>
            </dl>
            <hr>
            <h4 class="text-center">分享房间</h4>
            <div class="row text-center" style="margin-top: 24px;margin-bottom: 21px;">
                <!--Dribbble-->
                <a class="icons-sm drib-ic"><i class="fa fa-dribbble"> </i></a>
                <!--Linkedin-->
                <a class="icons-sm li-ic"><i class="fa fa-linkedin"> </i></a>
                <!--Google +-->
                <a class="icons-sm gplus-ic"><i class="fa fa-google-plus"> </i></a>
                <!--Instagram-->
                <a class="icons-sm ins-ic"><i class="fa fa-instagram"> </i></a>
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