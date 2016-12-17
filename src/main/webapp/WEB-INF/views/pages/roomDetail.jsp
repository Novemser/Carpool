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
                                    <span>开放 </span>
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
                <div style="margin: 24px;width: 75%;" class="btn btn-lg btn-primary">
                    <i class="fa fa-commenting"></i><a href="/room/chat?roomId=3" style="color: white"> 进入聊天室</a>
                </div>
                <c:choose>
                    <c:when test="${room.state==ROOM_STATE_UNLOCKED}">
                        <div class="btn-effect btn btn-success btn-lg">
                            <i class="fa fa-check"></i><a href="/"> 确定加入</a>
                        </div>
                    </c:when>
                    <c:when test="${room.state==ROOM_STATE_LOCKED}">
                        <div class="btn-effect btn btn-warning btn-lg">
                            <i class="fa fa-info"></i><a href="/"> 暂时无法加入 请等待房主解锁</a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-effect btn btn-default btn-lg btn-block">
                            <i class="fa fa-exclamation-triangle"></i> 无法加入此房间
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>
    </div>
    <div id="share" class="pull-right">
        <div class="bdsharebuttonbox">
            <a class="bds_more" href="#" data-cmd="more"></a>
            <a title="分享到微信" class="bds_weixin" href="#" data-cmd="weixin"></a>
            <a title="分享到QQ空间" class="bds_qzone" href="#" data-cmd="qzone"></a>
            <a title="分享到新浪微博" class="bds_tsina" href="#" data-cmd="tsina"></a>
            <a title="分享到腾讯微博" class="bds_tqq" href="#" data-cmd="tqq"></a>
            <a title="分享到人人网" class="bds_renren" href="#" data-cmd="renren"></a>
            <a title="分享到QQ好友" class="bds_sqq" href="#" data-cmd="sqq"></a></div>
    </div>
</div>

<style type="text/css">
    .btn-effect {
        width: 75%;
        margin: 10px;
    }

    .btn-effect a {
        color: white;
    }
</style>
<script>
    window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["weixin","qzone","tsina","tqq","renren","sqq"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["weixin","qzone","tsina","tqq","renren","sqq"]}};
    with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>