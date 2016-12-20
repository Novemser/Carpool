<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/11
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link href="/static/css/mdb.css" rel="stylesheet"/>--%>
<script type="text/javascript" src="../static/js/password.js"></script>
<div class="row" style="margin-bottom: 90px;">
    <%@include file="profileHeader.jsp" %>
    <aside class="profile-info col-lg-9">
        <section class="panel card">
            <div class="bio-graph-heading">
                Aliquam ac magna metus. Nam sed arcu non tellus fringilla fringilla ut vel ispum. Aliquam ac magna
                metus.
            </div>
            <div class="panel-body bio-graph-info">
                <h1> Profile Info</h1>
                <form class="form-horizontal" role="form" action="/user/edit" method="post">
                    <div class="form-group">
                        <label class="col-lg-2 control-label">支付宝账户</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="aliPay" name="aliPay" placeholder=" ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">QQ</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="QQ" name="QQ" placeholder=" ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">WeChat</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="WeChat" name="WeChat" placeholder=" ">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button type="submit" class="btn btn-success">保存</button>
                            <button type="button" class="btn btn-default" onclick="clear1()">清空</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <section>
            <div class="panel card panel-primary">
                <div class="panel-heading"> Sets New Password & Avatar</div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/user/password" method="post">
                        <div class="form-group">
                            <label class="col-lg-2 control-label">当前密码</label>
                            <div class="col-lg-6">
                                <input type="password" class="form-control" id="cpwd" name="currentPassword"
                                       placeholder=" ">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">新密码</label>
                            <div class="col-lg-6">
                                <input type="password" class="form-control" id="npwd" name="newPassword"
                                       onkeyup="strength()">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">密码强度</label>
                            <div class="col-lg-3">
                                <table width="300px" id="passStrength">
                                    <tr>
                                        <td width="33%" id="strength_L">弱</td>
                                        <td width="33%" id="strength_M">中</td>
                                        <td width="33%" id="strength_H">强</td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">再次输入</label>
                            <div class="col-lg-6">
                                <input type="password" class="form-control" id="rtpwd" name="renewPassword"
                                       onkeyup="isSame()">
                            </div>
                            <div id="unlike" style="display:none; color:#F00">
                                <label class="col-lg-2 control-label">密码输入不一致</label>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-lg-2 control-label">上传头像</label>
                            <div class="col-lg-6">
                                <input type="file" class="file-pos" id="exampleInputFile">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button type="submit" class="btn btn-info" id="save" disabled=true> 保存</button>
                                <button type="button" class="btn btn-default" onclick="clear2()">清空</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </aside>
</div>
