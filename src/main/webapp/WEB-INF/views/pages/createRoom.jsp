<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/10
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/static/css/mdb.css" rel="stylesheet"/>

<div class="row">
    <div class="col-lg-12">
        <section class="panel" style="margin-bottom: 100px">
            <header class="panel-heading">
                房间创建向导
            </header>

            <div class="panel-body">

                <div class="stepy-tab">
                    <ul id="default-titles" class="stepy-titles clearfix">
                        <li id="default-title-0" class="current-step">
                            <div>Step1</div>
                            <span> </span></li>
                        <li id="default-title-1">
                            <div>Step 2</div>
                            <span> </span></li>
                        <li id="default-title-2">
                            <div>Step 3</div>
                            <span> </span></li>
                    </ul>
                </div>

                <form:form class="form-horizontal" modelAttribute="room" id="default" method="post" action="/home/main">
                    <fieldset title="第一步" class="step" id="default-step-0">
                        <legend>房间信息</legend>
                        <div class="form-group">
                            <div class="col-lg-10">
                                <form:input type="text" class="form-control" placeholder="出发地点" path="startPoint"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10">
                                <form:input type="text" class="form-control" placeholder="结束地点" path="endPoint"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10">
                                <form:input type="text" class="form-control" placeholder="房间名称" path="roomname"/>
                            </div>
                        </div>

                    </fieldset>
                    <fieldset title="第二步" class="step" id="default-step-1" style="display: none;">
                        <legend>时间信息</legend>
                        <div class="form-group">
                            <div class="col-lg-10">
                                <input type="text" class="form-control" placeholder="Phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10">
                                <input type="text" class="form-control" placeholder="Mobile">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10">
                                <textarea class="form-control" cols="60" rows="5"></textarea>
                            </div>
                        </div>
                    </fieldset>

                    <fieldset title="信息确认" class="step" id="default-step-2" style="display: none;">
                        <legend></legend>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Full Name</label>
                            <div class="col-lg-10">
                                <p class="form-control-static">Tawseef Ahmed</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Email Address</label>
                            <div class="col-lg-10">
                                <p class="form-control-static">tawseef@vectorlab.com</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">User Name</label>
                            <div class="col-lg-10">
                                <p class="form-control-static">tawseef</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Phone</label>
                            <div class="col-lg-10">
                                <p class="form-control-static">01234567</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Mobile</label>
                            <div class="col-lg-10">
                                <p class="form-control-static">01234567</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Address</label>
                            <div class="col-lg-10">
                                <p class="form-control-static">
                                    Dreamland Ave, Suite 73
                                    AU, PC 1361
                                    P: (123) 456-7891 </p>
                            </div>
                        </div>
                        <input type="submit" class="finish btn btn-danger" value="确认无误并提交">
                    </fieldset>
                </form:form>
            </div>
        </section>
    </div>
</div>
