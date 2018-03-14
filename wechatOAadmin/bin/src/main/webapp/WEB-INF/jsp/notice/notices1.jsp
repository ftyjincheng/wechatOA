﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>办件指引列表</title>
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<jsp:include page="../include/headTag.jsp" />
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->
	<jsp:include page="../include/header.jsp"/>	
	
	<jsp:include page="../include/menues.jsp">
		<jsp:param value="/notices/1" name="menu"/>
	</jsp:include>
	<div class="content">

	<ul class="breadcrumb">
		<li><a href="<c:url value='/user/welcome.htm'/>">Home</a> <span class="divider">/</span></li>
		<li class="active">须知列表</li>
	</ul>
	
		<div class="container-fluid">
			<div class="row-fluid">
			<div class="btn-toolbar">
					<a href="<c:url value="/createNotice"/>" class="btn btn-primary">
						<i class="icon-plus"></i>添加须知
					</a>
					
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>序号</th>
								<th>须知标题</th>
								<th>描述</th>
								<th>状态</th>
								<th>创建时间</th>
								<th>所属区县</th>
								<th style="width: 30px;">操作</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${notices}" var="item" varStatus="status">
							<tr <c:if test="${status.index % 2 == 0 }">class="info"</c:if>>
								<td>${(status.index + 1) + (pages.currentPage - 1) * pages.pageRecord }</td>
								<td>${item.noticeName }</td>
								<td>${item.noticeDescription }</td>
								<td>${item.noticeTypeName }</td>
								<td>${item.createTime }</td>
								<td>
									<c:if test="${item.area eq 0}">市区</c:if>
									<c:if test="${item.area eq 1}">和平区</c:if>
									<c:if test="${item.area eq 2}">河西区</c:if>
									<c:if test="${item.area eq 3}">河北区</c:if>
									<c:if test="${item.area eq 4}">河东区</c:if>
									<c:if test="${item.area eq 5}">南开区</c:if>
									<c:if test="${item.area eq 6}">红桥区</c:if>
									<c:if test="${item.area eq 7}">东丽区</c:if>
									<c:if test="${item.area eq 8}">西青区</c:if>
									<c:if test="${item.area eq 9}">津南区</c:if>
									<c:if test="${item.area eq 10}">北辰区</c:if>
									<c:if test="${item.area eq 11}">武清区</c:if>
									<c:if test="${item.area eq 12}">宝坻</c:if>
									<c:if test="${item.area eq 13}">蓟县</c:if>
									<c:if test="${item.area eq 14}">静海</c:if>
									<c:if test="${item.area eq 15}">宁河</c:if>
									<c:if test="${item.area eq 16}">滨海新区</c:if>
									<c:if test="${item.area eq 17}">滨海第一中心</c:if>
									<c:if test="${item.area eq 18}">滨海第二中心</c:if>
									<c:if test="${item.area eq 19}">滨海第三中心</c:if>
									<c:if test="${item.area eq 20}">滨海第四中心</c:if>
									<c:if test="${item.area eq 21}">开发区</c:if>
									<c:if test="${item.area eq 22}">高新区</c:if>
									<c:if test="${item.area eq 23}">东疆港</c:if>
								</td>
								<td>
									<a href="<c:url value="/updateNotice/${item.id}"/>"><i class="icon-pencil"></i></a>
	              					<a href="#myModal${item.id}" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
	              					<div class="modal small hide fade" id="myModal${item.id}" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
											<h3 id="myModalLabel">确认删除</h3>
										</div>
										<div class="modal-body">
											<p class="error-text">
												<i class="icon-warning-sign modal-icon"></i>
												确定删除该记录?
											</p>
										</div>
										<div class="modal-footer">
			              					<form id="deleteNews${item.id}" method="post" action="<c:url value="/notice/${item.id}/${pages.currentPage }"/>">
			              						<input type="hidden" name="page" value="1"/>
												<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
												<input type="submit" class="btn btn-danger" value="删除"/>
			              					</form>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">
				<c:if test="${pages.totalPage > 0}">
					<ul>
					<c:if test="${pages.currentPage > 1}">
						<li><a href="<c:url value="/notices/${pages.prePage }"/>">Prev</a></li>
					</c:if>
					<c:forEach begin="${pages.pageNumStart }" end="${pages.pageNumEnd }" varStatus="status">
						<li <c:if test="${status.index == pages.currentPage }">class="active"</c:if>>
							<a href="<c:url value="/notices/${status.index }"/>">
								${status.index }
							</a>
						</li>
					</c:forEach>
					<c:if test="${pages.currentPage< pages.totalPage}">
						<li><a href="<c:url value="/notices/${pages.nextPage }"/>">Next</a></li>
					</c:if>
						<li class="disabled"><a>共${pages.totalPage}页(${pages.totalRecord }条数据)</a></li>
					</ul>
				</c:if>
				</div>
				<jsp:include page="../include/footer.jsp"/>
			</div>
		</div>
	</div>
</body>
</html>


