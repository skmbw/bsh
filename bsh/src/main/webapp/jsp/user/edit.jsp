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
<title>编辑用户</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<div class="row" style="margin-top:20px;">
<form class="form-horizontal" role="form" id="editForm" action="/user/update" method="post">
	<input type="hidden" name="id" value="${model.id}">
<%-- <input type="hidden" name="updateDate" value='<fmt:formatDate value="${model.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' > --%>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" value="${model.name}" placeholder="用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount3" class="col-sm-2 control-label">用户账号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="age" name="age" value="${model.age}" placeholder="年龄">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">修改用户</button> <a href="${ctx}/user/list" class="btn btn-info">返回列表页</a>
    </div>
  </div>
</form>

</div>

</div>

</body>
</html>