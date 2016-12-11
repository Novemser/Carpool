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
            <li class="menu-item-main mymenu-item">
                <a href="/home/main?id=1">
                    <i class="icon-home"></i>
                    <span>主页 </span>
                </a>
            </li>

            <li class="menu-item-select mymenu-item">
                <a href="/room/select?id=2">
                    <i class="icon-search"></i>
                    <span>约车 </span>
                </a>
            </li>

            <li class="menu-item-person mymenu-item">
                <a href="">
                    <i class="icon-user"></i>
                    <span>个人中心 </span>
                    <span class="label label-danger pull-right mail-info">2</span>
                </a>
            </li>


            <li class="dropdown mymenu-item">

                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-flag"></i>  我的行程
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right pull-right">
                    <li><a href="/journey/getMyJourneyAsHost/1452779?id=4">我是房主</a> </li>
                    <li><a href="/journey/getAllJourneys/1452779?id=4">全部出行</a> </li>
                </ul>
            </li>
            <li class="dropdown mymenu-item">

                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-comment"></i> 评论中心
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right ">
                    <li><a href="/comment/getReceivedComment/1452779?id=5">收到评论</a> </li>
                    <li><a href="/comment/getSendedComment/1452779?id=5">发出评论</a> </li>
                </ul>
            </li>

            <li class="menu-item-logout mymenu-item">
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
        $(".mymenu-item").eq(${state-1}).addClass('active');
   /*     switch (${state}) {
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
        }*/
    });
</script>