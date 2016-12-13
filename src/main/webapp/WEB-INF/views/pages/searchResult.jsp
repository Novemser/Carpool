<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/6
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="/static/css/room-list.css"/>

<div class="border-head">
    <div class="row">
        <h3 class="col-lg-3">当前车池</h3>
        <div class="text text-center" style="padding-bottom: 8px">
            <i class="flag-finished fa fa-flag" aria-hidden="true" >
                <span>已完成  </span>
            </i>
            <i class="flag-started fa fa-flag" aria-hidden="true">
                <span>在途中  </span>
            </i>
            <i class="flag-unlocked fa fa-flag" aria-hidden="true">
                <span>开放  </span>
            </i>
            <i class="flag-locked fa fa-lock" aria-hidden="true">
                <span>锁定 </span>
            </i>
        </div>
    </div>
</div>

<%@include file="../template/roomState.jsp"%>
<div class="row">
    <c:forEach items="${roomPage.content}" var="li">
        <div class="col-lg-4 col-md-6 col-sm-12">
            <section class="z-depth-1 hoverable panel" style="padding: 15px;">
                <a href="<c:url value="/room/detail?roomId=${li.id}"/>">
                    <div class="row">
                        <div class="text room-title text-center col-lg-11 col-md-11 col-sm-11 col-xs-11">${li.roomname}</div>
                        <c:set var="state" value="${li.state}"/>
                        <c:choose>
                            <c:when test="${state==ROOM_STATE_UNLOCKED}">
                                <i class="flag-unlocked fa fa-flag" aria-hidden="true"></i>
                            </c:when>
                            <c:when test="${state==ROOM_STATE_LOCKED}">
                                <i class="flag-locked fa fa-lock" aria-hidden="true"></i>
                            </c:when>
                            <c:when test="${state==ROOM_STATE_END}">
                                <i class="flag-finished fa fa-flag" aria-hidden="true"></i>
                            </c:when>
                            <c:when test="${state==ROOM_STATE_STARTED}">
                                <i class="flag-started fa fa-flag" aria-hidden="true"></i>
                            </c:when>
                        </c:choose>
                    </div>
                    <dl class="dl-horizontal">
                        <dt>时间</dt>
                        <dd>${li.startTime}</dd>
                        <dt>出发地点</dt>
                        <dd>${li.startPoint}</dd>
                        <dt>目的地</dt>
                        <dd>${li.endPoint}</dd>
                        <dt>人数</dt>
                        <dd>
                        <span style="text-align: center;">
                            <c:forEach begin="0" end="${li.currentNums}">
                                <i class="icon-user" style="color: #42b2c4;"></i>
                            </c:forEach>
                            <c:forEach begin="0" end="${li.numberLimit-li.currentNums}">
                                <i class="icon-user" style="color: lightgrey"></i>
                            </c:forEach>
                        </span>
                        </dd>
                    </dl>
                </a>
            </section>
        </div>
    </c:forEach>
</div>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<style type="text/css">
    .pagination {
        float: right !important;
        display: inline-block;
        padding-left: 0;
        margin: 20px 0;
        border-radius: 4px;
    }
</style>