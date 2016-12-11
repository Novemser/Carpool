<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/11
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <link href="/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/static/css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="/static/css/style.css" rel="stylesheet">
    <link href="/static/css/style-responsive.css" rel="stylesheet"/>
    <link href="/static/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="/static/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="/static/js/bootstrap.min.js" type="text/javascript"></script>
    <!--script for this page-->
    <script src="/static/js/jquery.stepy.js" type="text/javascript"></script>
</head>
<body>
<div id="example-basic">
    <h3>Keyboard</h3>
    <section>
        <p>Try the keyboard navigation by clicking arrow left or right!</p>
    </section>
    <h3>Effects</h3>
    <section>
        <p>Wonderful transition effects.</p>
    </section>
    <h3>Pager</h3>
    <section>
        <p>The next and previous buttons help you to navigate through your content.</p>
    </section>
</div>
<!-- js placed at the end of the document so the pages load faster -->
<script src="/static/js/jquery.scrollTo.min.js"></script>
<script src="/static/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="/static/js/jquery.sparkline.js" type="text/javascript"></script>
<script src="/static/js/owl.carousel.js"></script>
<script src="/static/js/jquery.customSelect.min.js"></script>

<!--common script for all pages-->
<script src="/static/js/common-scripts.js"></script>

</body>
</html>

<script>

    $("#example-basic").steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        autoFocus: true
    });

</script>