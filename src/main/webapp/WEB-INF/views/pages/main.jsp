<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/6
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="/static/css/room-list.css"/>
<!--custom chart start-->
<div class="border-head">
    <h3>当前车池</h3>
</div>

<div class="row">
    <c:forEach items="${rooms}" var="li">
        <div class="col-lg-4 col-md-6 col-sm-12">
            <section class="panel" style="padding: 15px;">
                <div class="text text-center room-title">${li.roomname}</div>
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

            </section>
        </div>
    </c:forEach>
</div>

