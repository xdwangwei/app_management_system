<%--
  Created by IntelliJ IDEA.
  User: wangwei
  Date: 2019/6/30
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="layui-header">
	<div class="layui-logo">APP BMS</div>

	<ul class="layui-nav layui-layout-right">
		<c:if test="${sessionScope.devUser != null}">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
						${sessionScope.devUser.devName}
				</a>
			</li>
			<li class="layui-nav-item"><a href="${ctx}/dev/logout">退了</a></li>
		</c:if>
		<c:if test="${sessionScope.backendUser != null}">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
					${sessionScope.backendUser.backendName}
				</a>
			</li>
			<li class="layui-nav-item"><a href="${ctx}/backend/logout">退了</a></li>
		</c:if>
	</ul>
</div>

<div class="layui-side layui-bg-black">
	<div class="layui-side-scroll">
		<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		<ul class="layui-nav layui-nav-tree" lay-filter="test">
			<li class="layui-nav-item layui-nav-itemed">
				<a class="" href="javascript:;">后台首页</a>
				<dl class="layui-nav-child">
					<dd><a href="#">列表一</a></dd>
					<dd><a href="#">列表二</a></dd>
					<dd><a href="#">列表三</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a href="javascript:;">App应用管理</a>
				<dl class="layui-nav-child">
					<dd>
						<c:if test="${sessionScope.devUser != null}">
							<a href="${ctx}/devApp/index/devId/${sessionScope.devUser.id}">
								App维护</a>
						</c:if>
						<c:if test="${sessionScope.backendUser != null}">
							<a href="${ctx}/backendApp/index">
								App维护</a>
						</c:if>
					</dd>
				</dl>
			</li>
		</ul>
	</div>
</div>
