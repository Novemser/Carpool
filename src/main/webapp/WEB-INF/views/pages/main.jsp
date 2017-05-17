<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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

        <div class=" text text-center" style="padding-bottom: 8px">
            <div class="text text-center" style="padding-bottom: 8px">
                <i class="flag-finished fa fa-flag" aria-hidden="true">
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
            <%--<div class="text text-right">--%>
            <%--<i class="fa fa-space-shuttle" aria-hidden="true"><span>允许中途下车</span></i>--%>
            <%--<i class="fa fa-space-shuttle" style="color: green" aria-hidden="true"><span>不允许中途下车</span></i>--%>
            <%--</div>--%>
        </div>
    </div>

    <%@include file="../template/roomState.jsp" %>
    <div class="row">
        <c:choose>
            <c:when test="${roomPage==null||roomPage.size==0}">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    Ooops, 车池空了...
                </div>
            </c:when>
            <c:otherwise>

                <c:forEach items="${roomPage.content}" var="li">
                    <%--<c:if test="${li.state!=ROOM_STATE_END}">--%>
                    <div class="col-sm-12 col-lg-offset-1 col-lg-10 ">
                        <section class="z-depth-1 col-sm-12 hoverable panel" style="padding: 15px;">
                            <a class="col-sm-6"
                               style="display: flex; flex-direction: column; justify-content: space-around"
                               href="<c:url value="/room/detail?roomId=${li.id}"/>">
                                <div class="row">
                                    <div class="text room-title col-lg-11 col-md-11 col-sm-11 col-xs-11">
                                        <span style="color: #00a5e0;">| </span>
                                        房间信息
                                    </div>
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
                                        <%--<c:choose>--%>
                                        <%--<c:when test="${li.canStopOver}">--%>
                                        <%--<i class="fa fa-space-shuttle" style="color: gray" aria-hidden="true"></i>--%>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>
                                        <%--<i class="fa fa-space-shuttle" style="color: green" aria-hidden="true"></i>--%>
                                        <%--</c:otherwise>--%>
                                        <%--</c:choose>--%>
                                </div>
                                <dl>
                                    <dt>房间名称</dt>
                                    <dd>${li.roomname}</dd>
                                    <dt>出发时间</dt>
                                    <dd><fmt:formatDate value="${li.startTime}" pattern="yyyy-MM-dd HH:mm"/></dd>
                                    <dt>出发地点</dt>
                                    <dd class="start-point">${li.startPoint}</dd>
                                    <dt>目的地</dt>
                                    <dd class="end-point">${li.endPoint}</dd>
                                    <dt>人数</dt>
                                    <dd>
                        <span style="text-align: center;">
                            <c:forEach begin="1" end="${li.currentNums}">
                                <i class="icon-user" style="color: #42b2c4;"></i>
                            </c:forEach>
                            <c:forEach begin="1" end="${li.numberLimit-li.currentNums}">
                                <i class="icon-user" style="color: lightgrey"></i>
                            </c:forEach>
                        </span>
                                    </dd>
                                </dl>
                            </a>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="text room-title">
                                        <span style="color: #00a5e0;">| </span>
                                        起点, 终点信息
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="map col-sm-12">Baidu Map</div>
                                </div>
                            </div>
                        </section>

                    </div>
                    <%--</c:if>--%>
                </c:forEach>
            </c:otherwise>
        </c:choose>


    </div>
    <div class="text-center">
        <nav class="">
            <ul class="pagination pg-blue ">
                <!--Arrow left-->
                <li class="page-item">
                    <a class="page-link" aria-label="Previous">
                        <span aria-hidden="true">«</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>

                <!--Numbers-->
                <c:forEach var="i" begin="0" end="${pageCount > 0 ? pageCount - 1: 0}" step="1">
                    <c:if test="${i==currentPage}">
                        <li class="page-item active"><a href="/home/main?page=${i}" class="page-link">${i+1}</a></li>
                    </c:if>
                    <c:if test="${i!=currentPage}">
                        <li class="page-item"><a href="/home/main?page=${i}" class="page-link">${i+1}</a></li>
                    </c:if>
                </c:forEach>
                <!--Arrow right-->
                <li class="page-item">
                    <a class="page-link" aria-label="Next">
                        <span aria-hidden="true">»</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=LjXz7cMGmKjfh3gGQ78s3NdCKN6KlvDv"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var startPointList = $('#main-content .wrapper section .start-point');
        var endPointList = $('#main-content .wrapper section .end-point');

        $('#main-content .wrapper section .map').each(function (index) {
            var map = new BMap.Map(this);

            var local = new BMap.LocalSearch(map, {
                renderOptions: {map: map}
            });
            var local2 = new BMap.LocalSearch(map, {
                renderOptions: {map: map}
            });

            // 创建地址解析器实例
            var myGeo = new BMap.Geocoder();
            var startPoint = startPointList[index].innerHTML;
            var endPoint = endPointList[index].innerHTML;

            myGeo.getPoint(startPoint, function (startPoint) {
                if (startPoint) {
//                    map.centerAndZoom(startPoint, 12);
//                    map.addOverlay(new BMap.Marker(startPoint));
                    myGeo.getPoint(endPoint, function (endPoint) {
                        var driving = new BMap.DrivingRoute(map, {
                            renderOptions: {
                                map: map,
                                autoViewport: true,
                                enableDragging: true
                            }
                        });
                        driving.search(startPoint, endPoint);
                        map.centerAndZoom('上海', 11);
                    }, '上海市');
                } else {

                }
            }, '上海市');

            var top_right_navigation = new BMap.NavigationControl({
                anchor: BMAP_ANCHOR_TOP_RIGHT,
                type: BMAP_NAVIGATION_CONTROL_SMALL
            }); //右上角，仅包含平移和缩放按钮
            map.addControl(top_right_navigation);
            map.enableContinuousZoom();
            map.enableScrollWheelZoom(true);

            local.search(startPoint);
            local2.search(endPoint);

            $(this).css('height', '300px');
        })
    });

</script>

<style type="text/css">
    .pagination {
        float: right !important;
        display: inline-block;
        padding-left: 0;
        margin: 24px 15px 75px 10px;
        border-radius: 4px;
    }
</style>