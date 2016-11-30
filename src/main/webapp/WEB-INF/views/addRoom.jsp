<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/1
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加房间</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>在这里添加房间</h1>
    <hr/>
    <form:form method="POST" modelAttribute="room" class="form-horizontal">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-label" for="roomName">房间名：</label>
                <div class="col-md-7">
                    <form:input path="roomname" type="text" id="roomName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="roomname" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-label" for="startPt">起始地点：</label>
                <div class="col-md-7">
                    <form:input path="startPoint" type="text" id="startPt" class="form-control input-md"/>
                    <div class="has-error">
                        <form:errors path="startPoint" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="添加" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
</div>

</body>
</html>
