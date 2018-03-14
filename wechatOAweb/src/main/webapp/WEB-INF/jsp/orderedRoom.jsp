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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <style>
        .left {
            float: left;
        }

        .clear {
            clear: both;
        }

        body {
            margin: 0;
            padding: 0;
            border: 0;
            background: #F1F1F1;
        }

        div {
            margin: 0;
            padding: 0;
        }

        .top10 {
            margin-top: 10px;
        }

        .bgWhite {
            background: white;
        }

        .timeSection {
            color: white;
            width: 30%;
            text-align: center;
            border-radius: 5px;
            padding: 8px 8px;
            margin: 0 5px;
        }

        .section1 {
            background: #5cb85c;
        }

        .section2 {
            background: #6FCBFF;
        }

        .section3 {
            background: #FBD77A;
        }

        .section4 {
            background: #FFB1A5;
        }
    </style>
</head>
<body>
<input type="hidden" id="hideArr" name="hideArr" value="${arrOrder}"/>
<div class="top" style="position:absolute;z-index:99999;top:0;">
    <div class="col-xs-3">
        <a href="javascript:history.go(-1);">
            <div class="leftArrow"></div>
        </a>
    </div>
    <div class="col-xs-6">预约会议室</div>
</div>
<div class="container" style="margin-top:60px;">
    <div class="left col-xs-3" style="padding:0;"><img src="/resources/img/titleDate.gif" class="img-responsive" alt="">
    </div>
    <div class="col-xs-9" style="padding:0;">
        <select name="bussinessType"
                style="font-size: 25px;text-align: center;position: absolute;color:#000;border:0px;background: transparent;width: 100%;margin-top: 3px;"
                onchange="selectDate(this)">
            <c:forEach items="${arrDays }" var="item">
                <option value="${item}">
                        ${item}</option>
            </c:forEach>
        </select><img src="/resources/img/dropDown.gif" class="img-responsive" alt="" style="z-index: 9999;"></div>
</div>
<div class="top10 container ">
    <div class="">
        <img src="/resources/img/title.gif" class="img-responsive" alt="">
    </div>
</div>
<div id="html">
${arrOrderHtml}</div>
<%@include file="include/footer.jsp" %>
</body>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script>

    //加载页面时显示第一天的预约
    $(function () {

        // var arr1 = $("#hideArr").val().replace("[", "").replace("]", "").split(",");
        // console.log(arr1);
        // var count = 0;
        // $("#room1 .timeSection").each(function (i) {
        //     count++;
        //     if (arr1 == "") {
        //         if (count == 1)
        //             $(this).html("暂无");
        //         else
        //             $(this).hide();
        //     }
        //     else if (count <= arr1.length) {
        //         $(this).html(arr1[i]);
        //     }
        //     else {
        //         $(this).hide();
        //     }
        // })

    });

    function selectDate(objSelect) {
        var date=$(objSelect).children(":selected").val();
        $.post("<c:url value='/meetingRoom/selectDate'/> ",{date:date},function (result) {
            $("#html").html(result);
        })
    }

</script>