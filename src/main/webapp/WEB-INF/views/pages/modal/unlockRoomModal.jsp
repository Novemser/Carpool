<%--
  Created by IntelliJ IDEA.
  User: Novemser
  Date: 2016/12/21
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="unlockRoomConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <!--Body-->
            <div class="modal-body">
                <i class="fa fa-warning" aria-hidden="true" style="color: orange"></i> 您确定要解锁吗？
            </div>
            <!--Footer-->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="confirmUnlock(${room.id})">
                    是的
                </button>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
<script>
    var sucCount = 0;
    function confirmUnlock(roomId) {
        var xmlHttp = new XMLHttpRequest();

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.status == 202) {
                if (sucCount++ == 0)
                    toastr.success('解锁房间成功！');
                setTimeout(function () {
                    window.location.href = '/room/detail?roomId=' + roomId;
                }, 2000);
            }
        };

        xmlHttp.open("POST", "/room/unlock", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send("roomId=" + roomId);
    }
</script>