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
					       value="${appInfoDetail.softwareName}" class="layui-input">
				</div>
				<label class="layui-form-label">APK名称</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="apkName" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.apkName}" class="layui-input">
				</div>
				<label class="layui-form-label">支持ROM</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="supportRom" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.supportRom}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">界面语言</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="interfaceLanguage" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.interfaceLanguage}" class="layui-input">
				</div>
				<label class="layui-form-label">软件大小</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.softwareSize}" class="layui-input">
				</div>
				<label class="layui-form-label">所属平台</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.flatForm.valueName}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">一级分类</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.categoryLevel1.categoryName}" class="layui-input">
				</div>

				<label class="layui-form-label">二级分类</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.categoryLevel2.categoryName}" class="layui-input">
				</div>
				<label class="layui-form-label">三级分类</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.categoryLevel3.categoryName}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">销售日期</label>
				<div class="layui-input-inline">
					<input disabled type="text" class="layui-input" id="onSaleDate"
					       value="<fmt:formatDate value="${appInfoDetail.onSaledate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>">
				</div>
				<label class="layui-form-label">截止日期</label>
				<div class="layui-input-inline">
					<input disabled type="text" class="layui-input" id="offSaleDate"
					       value="<fmt:formatDate value="${appInfoDetail.offSaledate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>">
				</div>
				<%--应用状态--%>
				<label class="layui-form-label">APP状态</label>
				<div class="layui-input-inline">
					<input disabled type="text" name="softwareSize" lay-verify="title" autocomplete="off"
					       value="${appInfoDetail.appStatus.valueName}" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" style="padding-bottom: 15px">
				<label class="layui-form-label">应用简介</label>
				<div class="layui-input-block">
					<textarea disabled class="layui-textarea">${appInfoDetail.appInfo}</textarea>
				</div>
			</div>
			<h2>历史版本信息</h2><br>
			<div class="layui-form-item">
				<table class="layui-table">
					<thead>
					<tr>
						<th>版本编号</th>
						<th>APK文件名称</th>
						<th>APK位置</th>
						<th>下载链接</th>
						<th>版本大小</th>
						<th>版本信息</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${appInfoDetail.appVersions}" var="obj">
						<tr>
							<td>${obj.versionNo}</td>
							<td>${obj.apkFilename}</td>
							<td>${obj.apkLocpath}</td>
							<td>${obj.downloadLink}</td>
							<td>${obj.versionSize}</td>
							<td>${obj.versionInfo}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
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
