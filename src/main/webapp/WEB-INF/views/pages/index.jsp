<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/1
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>约车</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/bootstrap-theme.min.css" rel="stylesheet">
    <!--external css-->
    <link href="/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="/static/css/mdb.css" rel="stylesheet"/>
    <link href="/static/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <link href="/static/css/index.css" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle btn-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/index" id="brand">CarPooler</a>
        </div>

        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right topNavbar">
                <li ><a href="#home" class="btn2">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#project">Projects</a></li>
            </ul>
        </div>
    </div>
</nav>

<img class="img-responsive" src="/static/images/index.jpg">


<!-- js placed at the end of the document so the pages load faster -->
<script src="/static/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/js/tether.min.js" type="text/javascript"></script>
<script src="/static/js/mdb.min.js" type="text/javascript"></script>

</body>
</html>
