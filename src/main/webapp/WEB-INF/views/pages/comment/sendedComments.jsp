<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2016/12/7
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
    <link href="/static/css/commentPage.css" rel="stylesheet">
    <style type="text/css">
        .commentText
        {
            overflow: auto;
        }

        .border-head table
        {
            font-size: x-small;
        }
        .border-head table td
        {
            margin-right: 5px;
        }
        dt, dd {
            line-height: 1.42857143;
        }
        body
        {
            color: #2b577a;
            font-family: Helvetica,"Hiragino Sans GB W3",arial,sans-serif;
            line-height: 1;
            display: block;
            font-size: medium;
            background-color: #f1f2f7;
        }
    </style>
</head>
<body>
<c:set value="${user}" var="user"></c:set>
<c:set value="${userid}" var="userid"></c:set>
<c:set value="${sendedComments}" var="sendedComments"></c:set>
<div class="border-head">
    <h3>
        已发评论
    </h3>
</div>
<div class="row">
    <c:choose>
        <c:when test="${empty userid}">
            亲，你还没有登录呢，去<a href="<c:url value='/comment/getSendedComment/1452779'/>" class="btn btn-default">
            登录
            </a>
        </c:when>
        <c:when test="${sendedComments.totalElements==0}">
            你还没有发出任何评论呢！
        </c:when>
        <c:otherwise>
            <c:forEach var="comment" items="${sendedComments.content}">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <section class="panel" style="padding: 15px;">
                        <dl class="dl-horizontal">
                            <dt>被评价用户：</dt>
                            <dd><a href="<c:url value="/comment/getOthersComment/${comment.targetUser.id}"/> "> ${comment.targetUser.username}</a></dd>
                            <dt>你的评分：</dt>
                            <dd>
                                <c:forEach begin="0" end="${comment.credit-1}">
                                    <i class="icon-star" style="color: yellow"></i>
                                </c:forEach>
                                <c:forEach begin="${comment.credit+1}" end="5">
                                    <i class="icon-star" style="color: lightgrey"></i>
                                </c:forEach>
                                    ${comment.credit}分
                            </dd>
                            <dt>评论内容：</dt>
                            <dd>
                                <div class="commentText">
                                        ${comment.commentText}
                                </div>
                            </dd>
                            <dt>评论时间：</dt>
                            <dd><fmt:formatDate value="${comment.commentTime}" pattern="yyyy/MM/dd  HH:mm:ss"></fmt:formatDate>
                            </dd>
                            <dt>行程详情：</dt>
                            <dd>
                                出发时间为<fmt:formatDate value="${comment.journey.startTime}" pattern="yyyy/MM/dd HH:mm"></fmt:formatDate>
                                &nbsp; 起点为${comment.journey.startPoint} &nbsp;
                                终点为${comment.journey.endPoint}
                            </dd>
                        </dl>
                    </section>
                </div>
            </c:forEach>
            <div class="col-lg-12 col-md-12 col-sm-12" style="padding-left: 15px" >
                <ul class="pagination pagination-centered center-block">
                    <li>
                        <a href="<c:url value="/comment/getSendedComment/${userid}?currentPage=0"></c:url> ">
                            第一页
                        </a>
                    </li>

                    <c:if test="${sendedComments.hasPrevious()}">
                        <li>
                            <a  href="<c:url value='/comment/getSendedComment/${userid}?currentPage=${sendedComments.number-1}'></c:url>">
                                上一页
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <span class="text-info disabled">当前页数${sendedComments.number+1}/${sendedComments.totalPages}</span>
                    </li>
                    <c:if test="${sendedComments.hasNext()}">
                        <li>
                            <a href="<c:url value='/comment/getSendedComment/${userid}?currentPage=${sendedComments.number+1}'></c:url>">
                                下一页
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="<c:url value="/comment/getSendedComment/${userid}?currentPage=${sendedComments.totalPages-1}"></c:url> ">
                            最后一页
                        </a>
                    </li>
                </ul>
            </div>
        </c:otherwise>

    </c:choose>
</div>
</body>
</html>
