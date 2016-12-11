<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/5
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<aside>
    <div id="sidebar" class="nav-collapse " tabindex="5000"
         style="overflow-x: auto; overflow-y: visible; outline: none;">
        <c:set var="state" scope="session" value="${pageContext.request.getParameter('id')}"/>
        <c:if test="${state == null||state.equals('')}">
            ${state = 1}
        </c:if>

        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
            <li class="menu-item-main">
                <a href="/home/main?id=1">
                    <i class="icon-home"></i>
                    <span>主页 </span>
                </a>
            </li>

            <li class="menu-item-select sub-menu">
                <a href="javascript:;">
                    <i class="icon-search"></i>
                    <span>约车</span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li><a href="/room/create?id=2">新建房间</a></li>
                    <li><a href="/room/join?id=2">加入房间</a></li>
                </ul>
            </li>

            <li class="menu-item-person">
                <a href="/user?id=3">
                    <i class="icon-user"></i>
                    <span>个人中心 </span>
                    <span class="label label-danger pull-right mail-info">2</span>
                </a>
            </li>

            <li class="menu-item-logout">
                <a href="/login">
                    <i class="icon-key"></i>
                    <span>退出登录</span>
                </a>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<script type="text/javascript" language="JavaScript">

    $(document).ready(function () {
        switch (${state}) {
            case 1:
                $(".menu-item-main").addClass('active');
                break;
            case 2:
                $(".menu-item-select").addClass('active');
                break;
            case 3:
                $(".menu-item-person").addClass('active');
                break;
            case 4:
                $(".menu-item-logout").addClass('active');
                break;
        }
    });
</script>