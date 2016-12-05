<%@ page import="com.carpool.website.model.Room" %>
<%@ page import="org.springframework.web.servlet.ModelAndView" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/5
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value="/static/style/cityselect.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/style/frozen.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/style/car.css"/>">
    <script src="<c:url value="/static/js/jquery_car.min.js"/>"></script>
    <title>房间选择</title>
</head>
<body onload="createCode();createCode2();">
<div class="centerMain">
    <form:form class="form1 clearfix" modelAttribute="room" action="/room/add" method="post" name="form1">
        <div id="roomTitle" class="ui-form">
            <div class="ui-form-item ui-border-b">
                <label>房间名称</label>
                <div class="">
                    <form:input path="roomname" type="text" placeholder="请输入房间名称"/>
                </div>
            </div>
            <div style="padding-left: 15px;">
                <form:errors path="roomname" class="has-error help-inline"/>
            </div>
        </div>

        <div class="tab-container ui-form">
            <div class="leftInput">
                <div class="demo fl">
                    <label for="from1" class="text cf">起点</label>
                    <form:input path="startPoint" type="text" class="inputSpot fromSpot" id="from1" name="fromSpot"
                                value="${room.startPoint}"/>
                </div>
                <div class="change">
                    <span class="ico circle"></span>
                </div>
                <div class="demo fr">
                    <label for="to1" class="text dd">终点</label>
                    <form:input path="endPoint" type="text" class="inputSpot toSpot" id="to1" name="toSpot"
                                value="${room.endPoint}"/>
                </div>
            </div>

        </div>

        <div style="background: #f5f5f5;" class="ui-form">
            <div class="ui-form-item ui-border-b">
                <div class="demo fl">
                    <form:errors path="startPoint" class="has-error help-inline"/>
                </div>
                <div class="demo fr">
                    <form:errors path="endPoint" class="fr has-error help-inline"/>
                </div>
            </div>
        </div>

        <div class="ui-form">
            <span class="time-tag">出发时间（过期自动删除本条信息）</span>
            <div class="ui-form-item ui-border-b">
                <label for="from1date">出发日期</label>
                <form:input path="startDate" id="from1date" type="date"/>
            </div>
            <div  style="padding-left: 15px;">
                <form:errors path="startDate" class="has-error help-inline"/>
            </div>
            <div class="ui-form-item ui-border-b">
                <label>出发时间</label>
                <form:input path="startTime" type="time"/>
            </div>
            <div style="padding-left: 15px;">
                <form:errors path="startTime" class="has-error help-inline"/>
            </div>
        </div>
        <!-- end -->
        <div class="mt10 ui-form">
            <div class="ui-form-item ui-form-item-r ui-border-b">
                <label>
                    验证码
                </label>
                <input type="text" placeholder="请输入您收到的验证码" style="margin-left:95px;">
                <!-- 若按钮不可点击则添加 disabled 类 -->
                <button type="button" class="ui-border-l" style="color:#75afca;">重新发送</button>
            </div>
        </div>
        <div class="ui-btn-wrap mt20 ui-form">
            <button class="ui-btn-lg ui-btn-success">
                确认无误，发布拼车信息
            </button>
            <br>
            <button class="ui-btn-lg ui-btn-fail">
                取消
            </button>
            <div class="mt10 item">
                <input type="checkbox" class="check check1" name="checkbox">我已查看并同意用户条款
            </div>
        </div>

    </form:form>
    <form:form class="form2" modelAttribute="room" action="/room/add" method="post" name="form2">
        <div class="tab-container ui-form">
            <div class="leftInput">
                <div class="demo fl">
                    <label for="from1" class="text cf">起点</label>
                    <form:input path="startPoint" type="text" class="inputSpot fromSpot" id="from1" name="fromSpot"
                                value="${room.startPoint}"/>
                </div>
                <div class="change">
                    <span class="ico circle"></span>
                </div>
                <div class="demo fr">
                    <label for="to1" class="text dd">终点</label>
                    <form:input path="endPoint" type="text" class="inputSpot toSpot" id="to1" name="toSpot"
                                value="${room.endPoint}"/>
                </div>
            </div>

        </div>

        <div style="background: #f5f5f5;" class="ui-form">
            <div class="ui-form-item ui-border-b">
                <div class="demo fl">
                    <form:errors path="startPoint" class="has-error help-inline"/>
                </div>
                <div class="demo fr">
                    <form:errors path="endPoint" class="fr has-error help-inline"/>
                </div>
            </div>
        </div>

        <div class="ui-form">
            <span class="time-tag">出发时间</span>
            <div class="ui-form-item ui-border-b">
                <label for="from1date">出发日期</label>
                <form:input path="startDate" id="from1date" type="date"/>
            </div>
            <div  style="padding-left: 15px;">
                <form:errors path="startDate" class="has-error help-inline"/>
            </div>
            <div class="ui-form-item ui-border-b">
                <label>出发时间</label>
                <form:input path="startTime" type="time"/>
            </div>
            <div style="padding-left: 15px;">
                <form:errors path="startTime" class="has-error help-inline"/>
            </div>
        </div>

        <div class="ui-btn-wrap mt20 ui-form">
            <button class="ui-btn-lg ui-btn-success">
                确认无误，搜索座位信息
            </button>
            <br>
            <button class="ui-btn-lg ui-btn-fail">
                取消
            </button>
            <div class="mt10 item">
                <input type="checkbox" class="check check1" name="checkbox">我已查看并同意用户条款
            </div>
        </div>

    </form:form>
</div>
<div class="top">
    <div id="showTitle" class="fl tab tabActive">创建新组</div>
    <div id="hideTitle" class="fl tab">加入旧组</div>
</div>
<div class="clear"></div>

<div>
    <div class="confirm">
        <div class="clear xt xt1">请正确输入出发地点名称</div>
        <div class="clear xt xt4">请正确输入目的地名称</div>
        <div class="clear xt xt6">请选择正确的时间</div>
        <div class="clear xt xt2">请正确输入11位手机号码</div>
        <div class="clear xt xt3">请正确输入费用</div>

        <div class="clear xt xt1_1">请正确输入出发地点名称</div>
        <div class="clear xt xt2_2">请正确输入目的地名称</div>
        <div class="clear xt xt5_5">请正确输入11位手机号码</div>

        <div class="clear xt xt12">请输入正确验证码</div>
    </div>
</div>
</body>
<script language="javascript" type="text/javascript">
//    $("#showTitle").click(function () {
//        $("#roomTitle").show();
//    })
//
//    $("#hideTitle").click(function () {
//        $("#roomTitle").hide();
//    })

    $(function () {
        $('.tab').click(function () {
            $(this).addClass('tabActive').siblings().removeClass('tabActive');
            var index = $(this).index();
            $('.centerMain').children().eq(index).show().siblings().hide();
        })
    });
    /************验证码************/
    var code; //在全局 定义验证码
    function createCode() {
        code = "";
        var codeLength = 4;//验证码的长度
        var checkCode = document.getElementById("checkCode");
        var selectChar = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];//所有候选组成验证码的字符，当然也可以用中文的

        for (var i = 0; i < codeLength; i++) {
            var charIndex = Math.floor(Math.random() * 36);
            code += selectChar[charIndex];
        }
//        alert(code);
        if (checkCode) {
            checkCode.className = "code";
            checkCode.value = code;
        }
    }
    $(function () {
        $('.btn1').click(function validate() {
            var inputCode = document.getElementsByClassName('code1')[0].value;
            if (inputCode.length <= 0) {
                //alert("请输入验证码！");
                $('.confirm').show();
                $('.xt12').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            } else if (inputCode != code) {
                //alert("验证码输入错误！");
                $('.confirm').show();
                $('.xt12').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
                createCode();//刷新验证码
            } else {
                document.getElementsByClassName('right')[0].style.display = 'block';
                document.getElementById('checkCode').style.display = 'none';
            }
        })
    });
    /************************/
    $(function () {
        $('.btn1').click(function abc() {
            var reg1 = /^[\u4E00-\u9FA5]{2,5}$/;
            var reg2 = /^[0-9]+$/;
            var reg3 = /^[0-9.]{1,5}$/;
            var reg4 = /^[0-9]+$/;
            if (Number($('.toTime').val()) <= Number($('.fromTime').val())) {
                $('.confirm').show();
                $('.xt6').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if (!reg1.test($('.fromSpot').val())) {
                $('.confirm').show();
                $('.xt1').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if (!reg1.test($('.toSpot').val())) {
                $('.confirm').show();
                $('.xt4').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if ($('.tel').val().length !== 11 || !reg2.test($('.tel').val())) {
                $('.confirm').show();
                $('.xt2').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if ($('.name').val().length <= 0) {
                $('.confirm').show();
                $('.xt5').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            var cost = Number($('.cost').val());
            if (isNaN(cost) || $('.cost').val().length == 0) {
                $('.confirm').show();
                $('.xt3').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
        })
    });
    /*******************/
    // $(function(){
    // 	$('.demo').click(function(){
    // 		$(this).children('.text').animate({left:'10px',top:'-10px'},500);
    // 		$(this).children('.text1').animate({left:'10px',top:'-10px'},500);
    // 		$(this).children('.text2').animate({left:'10px',top:'-10px'},500);
    // 	});
    // 	var top=(document.documentElement.clientHeight-120)/3;
    // 	$('.confirm').css('top',top+"px");

    // })
    /**********交换城市*********/
    $(function () {
        $('.circle').click(function () {
            var x = document.getElementById('from1').value;
            var y = document.getElementById('to1').value;
            document.getElementById('from1').value = y;
            document.getElementById('to1').value = x;
        });

        // driver

        $('.circle-driver').click(function () {
            var x = document.getElementById('from1-driver').value;
            var y = document.getElementById('to1-driver').value;
            document.getElementById('from1-driver').value = y;
            document.getElementById('to1-driver').value = x;

            var a = document.getElementById('gs-rk').value;
            var b = document.getElementById('gs-ck').value;

            document.getElementById('gs-rk').value = b;
            document.getElementById('gs-ck').value = a;
        });

    });

    /////////////index2的页面//////////////
    /************验证码************/
    var code_2; //在全局 定义验证码
    function createCode2() {
        code_2 = "";
        var codeLength = 4;//验证码的长度
        var checkCode2 = document.getElementById("checkCode2");
        var selectChar = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];//所有候选组成验证码的字符，当然也可以用中文的

        for (var i = 0; i < codeLength; i++) {
            var charIndex = Math.floor(Math.random() * 36);
            code_2 += selectChar[charIndex];
        }
        //alert(code);
        if (checkCode2) {
            checkCode2.className = "code";
            checkCode2.value = code_2;
        }
    }
    $(function () {
        $('.btn2').click(function validate2() {
            var inputCode = document.getElementsByClassName('code1')[1].value;
            if (inputCode.length <= 0) {
                //alert("请输入验证码！");
                $('.confirm').show();
                $('.xt12').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            } else if (inputCode != code_2) {
                //alert("验证码输入错误！");
                $('.confirm').show();
                $('.xt12').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
                createCode2();//刷新验证码
            } else {
                document.getElementsByClassName('right2')[0].style.display = 'block';
                document.getElementById('checkCode2').style.display = 'none';
            }
        })
    });
    /***************************/
    $(function () {
        $('.close').click(function () {
            $('.confirm').hide();
            $('.xt').hide();
        });
        var reg_1 = /^[\u4E00-\u9FA5]{2,5}$/; //汉字城市
        var reg_2 = /^[0-9]+$/;  //数字 电话
        var reg_3 = /^[0-9.]{1,5}$/;
        //var reg4 = /^[0-9]+$/;//数字
        var reg_5 = /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/;
        $('.btn2').click(function abc() {
            if (!reg_1.test($('#from2').val())) {
                $('.confirm').show();
                $('.xt1_1').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if (!reg_1.test($('#to2').val())) {
                $('.confirm').show();
                $('.xt2_2').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if (!reg_1.test($('.cross1').val()) && $('.cross1').val().length > 0) {
                $('.confirm').show();
                $('.xt3_3').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if (!reg_1.test($('.cross2').val()) && $('.cross2').val().length > 0) {
                $('.confirm').show();
                $('.xt4_4').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if ($('.tel1').val().length !== 11 || !reg_2.test($('.tel1').val())) {
                $('.confirm').show();
                $('.xt5_5').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if ($('.name1').val().length <= 0) {
                $('.confirm').show();
                $('.xt8_8').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if (!reg_5.test($('.plate').val())) {
                $('.confirm').show();
                $('.xt6_6').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
            if ($('.person').val().length >= 2 || !reg_2.test($('.person').val())) {
                $('.confirm').show();
                $('.xt7_7').show();
                setTimeout(function () {
                    $('.confirm').hide();
                    $('.xt').hide();
                }, 2000);
            }
        })
    });
    /***************************/
    // $(function(){
    // 	$('.demo').click(function(){
    // 		$(this).children('.text').animate({left:'0px',top:'-10px'},500);
    // 		$(this).children('.text1').animate({left:'0px',top:'-10px'},500);
    // 		$(this).children('.text2').animate({left:'0px',top:'-10px'},500);
    // 		$(this).children('.text3').animate({left:'0px',top:'-10px'},500);
    // 		$(this).children('.plate').addClass('platehover');
    // 	});
    // 	var top=(document.documentElement.clientHeight-120)/3;
    // 	$('.confirm').css('top',top+"px");
    // })

    /**********交换城市*********/
    $(function () {
        $('.check2').click(function () {
            if ($(this).attr("checked") == "checked") {
                $('.btn2').css({"background": "#169bd5"});
            } else {
                $('.btn2').css({"background": "#666"});
            }
        })
    });
</script>
</html>
