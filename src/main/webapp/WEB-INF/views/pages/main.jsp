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
<!--custom chart start-->
<div class="border-head">
    <div class="row">
        <h3 class="col-lg-3">当前车池</h3>
    </div>
</div>
<spring:url value="" var="next">
    <spring:param name="roomPage.page" value="${roomPage.number + 1}"/>
    <spring:param name="roomPage.size" value="${roomPage.size}"/>
</spring:url>
<div class="row">
    <c:forEach items="${roomPage.content}" var="li">
        <div class="col-lg-4 col-md-6 col-sm-12">
            <section class="z-depth-1 hoverable panel" style="padding: 15px;">
                <a href="<c:url value="/room/detail?roomId=${li.id}"/>">
                    <div class="row"><div class="text room-title text-center col-lg-11 col-md-11 col-sm-11 col-xs-11">土豪你好</div>
                        <i class="fa fa-flag" aria-hidden="true" style="color: lightgreen"></i></div>
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
<script type="javascript" language="javascript">

</script>
