<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="include/nav.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <%@ include file="include/commoncss.jsp" %>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body id="myOrder">

<div class="top">
    <div class="col-xs-3">
        <a href="javascript:history.go(-1)">
            <div class="leftArrow"></div>
        </a>
    </div>
    <div class="col-xs-6">我的预约</div>
</div>
<div class="content">
    <ul>
        <c:if test="${empty arrOrder }">
            <li>
                <p>
                    您还未预约过<a href="<c:url value='/meetingRoom/loadOrderPage'/>"
                             style="position:relative;margin-top:10px">我要预约</a>
                </p></li>
        </c:if>
        <c:forEach items="${arrOrder }" var="item">
            <li>
                <p>
                    状态：
                </p>
                <p>
                    预约时间：<span>${item.date } ${item.startTime }-${item.endTime }</span>
                </p>
                <p>
                    会议室：<span>会议室${item.roomId }</span>
                </p>
                <p>
                    <span onclick="showCode()"><u style="color: #00B7EE;">点我查看预约时段锁密码</u></span>
                </p>
            </li>
        </c:forEach>
    </ul>
</div>


<%@include file="include/footer.jsp" %>

<%@ include file="include/commonjs.jsp" %>

</body>
<script type="text/javascript">
function showCode() {
    alert("锁密码为：189273");
}
</script>
</html>