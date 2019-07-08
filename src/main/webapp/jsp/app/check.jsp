<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta charset="UTF-8">
	<title>App产品详细信息</title>
	<link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
	<style>
		body{
			zoom:0.8
		}
	</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<jsp:include page="/jsp/common/header.jsp"/>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">
			<h2>软件基础信息</h2><br>
			<div class="layui-form-item">
				<label class="layui-form-label">软件名称</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareName" lay-verify="title" autocomplete="off"
					       value="${appInfo.softwareName}" class="layui-input">
				</div>
				<label class="layui-form-label">APK名称</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="apkName" lay-verify="title" autocomplete="off"
					       value="${appInfo.apkName}" class="layui-input">
				</div>
				<label class="layui-form-label">支持ROM</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="supportRom" lay-verify="title" autocomplete="off"
					       value="${appInfo.supportRom}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">界面语言</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="interfaceLanguage" lay-verify="title" autocomplete="off"
					       value="${appInfo.interfaceLanguage}" class="layui-input">
				</div>
				<label class="layui-form-label">软件大小</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfo.softwareSize}" class="layui-input">
				</div>
				<label class="layui-form-label">所属平台</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfo.flatForm.valueName}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">一级分类</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfo.categoryLevel1.categoryName}" class="layui-input">
				</div>

				<label class="layui-form-label">二级分类</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfo.categoryLevel2.categoryName}" class="layui-input">
				</div>
				<label class="layui-form-label">三级分类</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfo.categoryLevel3.categoryName}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" style="padding-bottom: 15px">
				<label class="layui-form-label">应用简介</label>
				<div class="layui-input-block">
					<textarea disabled class="layui-textarea">${appInfo.appInfo}</textarea>
				</div>
			</div>
			<div style="padding-bottom: 15px">
				<div class="layui-input-block" style="float: left">
					<form action="${ctx}/backendApp/check/${appInfo.id}" method="post">
						<input hidden value="${appInfo.id}" name="id">
						<input hidden value="2" name="status">
						<button class="layui-btn layui-btn-normal">审核通过</button>
					</form>
				</div>
				<div class="layui-input-block" style="float: left;">
					<form action="${ctx}/backendApp/check/${appInfo.id}" method="post">
						<input hidden value="${appInfo.id}" name="id">
						<input hidden value="3" name="status">
						<button class="layui-btn layui-btn-danger">审核不通过</button>
					</form>
				</div>
				<div class="layui-input-block" style="float: left">
					<a href="javascript:history.go(-1);">
						<button class="layui-btn layui-btn-primary">返回</button>
					</a>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/jsp/common/footer.jsp"/>
</div>
<script src="${ctx}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['form', 'element', 'laydate', 'jquery'], function () {
        var element = layui.element;
        var laydate = layui.laydate;
        var form = layui.form;
        var $ = layui.jquery;

    });
</script>
</body>
</html>
