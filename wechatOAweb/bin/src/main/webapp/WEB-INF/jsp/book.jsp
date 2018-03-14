<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="include/nav.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <script type="text/javascript">
        var arrParam = window.location.href.split('rtnCode=');
        if (arrParam.length > 1) {
            var code = arrParam[1].substr(0, 1);
            if (code != '') {
                var msg = window.location.href.split('rtnMsg=')[1];
                alert(decodeURI(msg));
            }
        }
    </script>
    <style type="text/css">
        i:after {
            content: " ";
            display: inline-block;
            height: 10px;
            width: 10px;
            border-width: 2px 2px 0 0;
            border-color: #C8C8CD;
            border-style: solid;
            -webkit-transform: matrix(0.71, 0.71, -0.71, 0.71, 0, 0);
            transform: matrix(0.71, 0.71, -0.71, 0.71, 0, 0);
            position: relative;
            top: -2px;
            position: absolute;
            top: 50%;
            margin-top: -4px;
            right: 2px;
            font-size: 14px;
            font-weight: 300;
        }

        i {
            text-align: right;
            color: #999999;
            padding-right: 15px;
            position: relative;
            flex: 1;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }
    </style>
</head>
<body id="order">
<div class="top" style="position:absolute;z-index:99999;top:0;">
    <div class="col-xs-3">
        <a href="javascript:history.go(-1);">
            <div class="leftArrow"></div>
        </a>
    </div>
    <div class="col-xs-6">预约会议室</div>
</div>
<div class="content">
    <input type="hidden" name="openid" value="${openid }"/>
    <div class="btn-group">
        <p>
            会议室<span style="color:red;">*</span>
        </p>

        <select name="meetingRoomId" id="meetingRoomId"
                style="margin-top:12px;margin-bottom:12px;color:#000;border:0px;background: transparent;height:25px;">
            <c:forEach items="${listRoom }" var="item">
                <option value="${item.meetingRoomId}">${item.roomName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="btn-group">
        <p>
            日期<span style="color:red;">*</span>
        </p>
        <input type="text" name="date" value="" class="Wdate" id="date"
               onClick="WdatePicker({minDate:'%y-%M-{%d+1}',maxDate:'%y-%M-{%d+8}'})"/>
    </div>


    <div class="btn-group">
        <p>
            起始时间<span style="color:red;">*</span>
        </p>
        <input class="Wdate" type="text" name="startTime" id="startTime" onClick="WdatePicker({dateFmt:'HH:mm'})"
               value=""/>
    </div>


    <div class="btn-group">
        <p>
            结束时间<span style="color:red;">*</span>
        </p>

        <input type="text" name="endTime" value="" id="endTime" class="Wdate" onClick="WdatePicker({dateFmt:'H:mm'})"/>
    </div>

</div>
<div class="content">
    <p>
        <img src="<c:url value='/resources/img/titleIco1.png'/>">个人信息
    </p>

    <p>
        姓名<span style="color:red;">*</span>
    </p>
    <input type="text" name="name" id="name" value="${userInfo.name}">
    <p>
        学号/工号<span style="color:red;">*</span>
    </p>
    <input type="text" name="idcard" id="idcard" value="${userInfo.userid}">
    <p>
        移动电话<span style="color:red;">*</span>
    </p>
    <input type="text" name="mobile" id="mobile" value="${userInfo.mobile}">
</div>
<div class="bottomBtn" style="margin-bottom:60px">
    <a href="javascript:void(0)" onclick="submitData(this)">确定</a>
</div>
<%@include file="./include/footer.jsp" %>
<%@ include file="include/commonjs.jsp" %>
<script type="text/javascript" src="<c:url value='/resources/My97DatePicker/WdatePicker.js'/>"></script>
<script type="text/javascript">

    $(function () {

    });

    function submitData(obj) {
        var meetingRoomId = $("#meetingRoomId").val();
        console.log(meetingRoomId);
        var date = $("#date").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var name = $("#name").val();
        var idcard = $("#idcard").val();
        var mobile = $("#mobile").val();

        if (name == "" || name == null) {
            alert("真实姓名不能为空!");
            return false;
        }

        if (idcard == "" || idcard == null) {
            alert("身份证号不能为空!");
            return false;
        }

        if (mobile == "" || mobile == null) {
            alert("电话不能为空!");
            return false;
        }

        if (date == "" || date == null) {
            alert("日期不能为空!");
            return false;
        }

        if (startTime == "" || startTime == null) {
            alert("起始时间不能为空!");
            return false;
        }

        if (endTime == "" || endTime == null) {
            alert("结束时间不能为空!");
            return false;
        } else {
            var intStartTime = parseInt(startTime.split(":"), 10);
            var intEndTime = parseInt(endTime.split(":"), 10);
            if (intStartTime > intEndTime) {
                $("#endTime").html("结束时间不能小于开始时间");
                return false;
            }
        }

        if (!confirm("您的预约信息是否确认提交？")) {
            return false;
        }
        var url = '<c:url value="/meetingRoom/OrderSubmit"/>';

        $
            .ajax({
                type: 'POST',
                url: url,
                data: {
                    "roomId": meetingRoomId,
                    "date": date,
                    "startTime": startTime,
                    "endTime": endTime,
                    "name": name,
                    "idcard": idcard,
                    "mobile": mobile
                },
                success: function (result) {
                    if (result.rtnCode == "9") {
                        alert(result.rtnMsg);
                        $(obj).attr("onclick", "submitData(this)");
                    } else {
                        alert("预约申请成功！");
                        window.location.href = '<c:url value="/meetingRoom/myOrder"/>';
                    }
                },
                error: function () {
                    alert("异常！");
                }
            });
    }

    function getNum(text) {
        var value = text.replace(/[^0-9]/ig, "");
        return value;
    }
</script>
</body>
</html>