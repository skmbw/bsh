<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="row" style="margin-top:20px;">
<table class="table table-bordered table-hover table-condensed">
<tr>
<td>用户ID</td>
<td>${model.id}</td>
</tr>
<tr>
<td>用户名</td>
<td>${model.name}</td>
</tr>
<tr>
<td>年龄</td>
<td>${model.age}</td>
</tr>
</table>

</div>
<div class="row">
<a class="btn btn-success" href="${ctx}/user/list">返回列表页</a>
</div>
</div>

</body>
</html>