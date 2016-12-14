<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/8
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="border-head">
    <div class="row">
        <h3 class="col-lg-3">房间信息</h3>
    </div>
</div>
<style type="text/css">
    dt {
        padding-top: 4px;
        padding-bottom: 4px;
    }
</style>
<%@include file="../template/roomState.jsp" %>
<div class="row center-block" style="margin-bottom: 90px;">
    <div class="col-lg-8 col-lg-offset-2 text-center detail_dev">
        <section class="z-depth-1 hoverable panel" style="padding: 15px;">
            <header class="panel-heading">
                房间具体信息
            </header>
            <div class="panel-body">


                <dl class="dl-horizontal">
                    <dt>房主姓名</dt>
                    <dd>${room.host.username}</dd>
                    <dt>房主信用等级</dt>
                    <dd>${room.host.credit}</dd>
                </dl>
                <hr>
                <dl class="dl-horizontal">
                    <dt>房间名称</dt>
                    <dd>${room.roomname}</dd>
                    <dt>创建时间</dt>
                    <dd>${room.createTime}</dd>
                    <dt>房间状态</dt>
                    <dd>
                        <c:set var="state" value="${room.state}"/>
                        <c:choose>
                            <c:when test="${state==ROOM_STATE_UNLOCKED}">
                                <i class="flag-unlocked fa fa-flag" aria-hidden="true">
                                    <span>开放  </span>
                                </i>
                            </c:when>
                            <c:when test="${state==ROOM_STATE_LOCKED}">
                                <i class="flag-locked fa fa-lock" aria-hidden="true">
                                    <span>锁定 </span>
                                </i>
                            </c:when>
                            <c:when test="${state==ROOM_STATE_END}">
                                <i class="flag-finished fa fa-flag" aria-hidden="true">
                                    <span>已完成  </span>
                                </i>
                            </c:when>
                            <c:when test="${state==ROOM_STATE_STARTED}">
                                <i class="flag-started fa fa-flag" aria-hidden="true">
                                    <span>在途中  </span>
                                </i>
                            </c:when>
                        </c:choose>
                    </dd>
                    <dt>出发时间</dt>
                    <dd>${room.startTime}</dd>
                    <dt>起点</dt>
                    <dd>${room.startPoint}</dd>
                    <dt>终点</dt>
                    <dd>${room.endPoint}</dd>
                    <dt>当前人数</dt>
                    <dd>${room.currentNums} / ${room.numberLimit}</dd>
                    <dt>备注</dt>
                    <dd>${room.roomNote}</dd>
                </dl>
                <hr>
                <div style="margin: 10px">
                    <i class="fa fa-commenting"></i><a href="/room/chat?roomId=${room.id}"> 点击进入聊天室</a>
                </div>
                <c:choose>
                    <c:when test="${room.state==ROOM_STATE_UNLOCKED}">
                        <button type="button" class="btn btn-success btn-lg btn-block">确定加入</button>
                    </c:when>
                    <c:when test="${room.state==ROOM_STATE_LOCKED}">
                        <button type="button" class="btn btn-warning btn-lg btn-block">暂时无法加入 请等待房主解锁</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-default btn-lg btn-block">无法加入此房间</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>
    </div>
</div>