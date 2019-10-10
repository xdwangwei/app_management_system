<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta charset="UTF-8">
	<title>新增App产品信息</title>
	<link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
	<style>

	</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<jsp:include page="/jsp/common/header.jsp"/>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">
			<form class="layui-form" action="${ctx}/devApp/add" method="post">
				<%--隐藏域传值--%>
				<input type="hidden" name="devId" value="${sessionScope.devUser.id}">
				<input type="hidden" name="devUser.id" value="${sessionScope.devUser.id}">
				<input type="hidden" name="createdBy" value="${sessionScope.devUser.id}">
				<input type="hidden" name="createdUser.id" value="${sessionScope.devUser.id}">
				<input type="hidden" name="modifyBy" value="${sessionScope.devUser.id}">
				<input type="hidden" name="modifyUser.id" value="${sessionScope.devUser.id}">
				<%--新增App默认都是待审核状态(status = 1)--%>
				<input type="hidden" name="appStatus.valueId" value="1">
				<div class="layui-form-item">
					<label class="layui-form-label">软件名称</label>
					<div class="layui-input-inline">
						<input type="text" name="softwareName" lay-verify="title" autocomplete="off"
						       placeholder="请输入软件名称" class="layui-input">
					</div>
					<label class="layui-form-label">APK名称</label>
					<div class="layui-input-inline">
						<input type="text" name="apkName" lay-verify="title" autocomplete="off"
						       placeholder="请输入APK名称" class="layui-input">
					</div>
					<label class="layui-form-label">支持ROM</label>
					<div class="layui-input-inline">
						<input type="text" name="supportRom" lay-verify="title" autocomplete="off"
						       placeholder="请输入支持ROM" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">界面语言</label>
					<div class="layui-input-inline">
						<input type="text" name="interfaceLanguage" lay-verify="title" autocomplete="off"
						       placeholder="请输入界面语言" class="layui-input">
					</div>
					<label class="layui-form-label">软件大小</label>
					<div class="layui-input-inline">
						<input type="text" name="softwareSize" lay-verify="title" autocomplete="off"
						       placeholder="请输入软件大小" class="layui-input">
					</div>
					<label class="layui-form-label">所属平台</label>
					<div class="layui-input-inline">
						<select name="flatForm.valueId" lay-filter="aihao">
							<option value="" selected>--请选择--</option>
							<c:forEach items="${flatForms}" var="obj">
								<option value="${obj.valueId}">${obj.valueName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">一级分类</label>
					<div class="layui-input-inline">
						<select name="categoryLevel1.id" lay-filter="levelOne" id="levelOne">
							<option value="" selected>--请选择--</option>
							<c:forEach items="${level1Categories}" var="obj">
								<option value="${obj.id}">${obj.categoryName}</option>
							</c:forEach>
						</select>
					</div>

					<label class="layui-form-label">二级分类</label>
					<div class="layui-input-inline">
						<select name="categoryLevel2.id" lay-filter="levelTwo" id="levelTwo">
							<option value="" selected>--请选择--</option>
						</select>
					</div>
					<label class="layui-form-label">三级分类</label>
					<div class="layui-input-inline">
						<select name="categoryLevel3.id" lay-filter="levelThree" id="levelThree">
							<option value="" selected>--请选择--</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
<%--					<label class="layui-form-label">应用简介</label>
					<div class="layui-input-inline">
						<input type="text" name="appInfo" lay-verify="title" autocomplete="off"
						       placeholder="请输入应用简介" class="layui-input">
					</div>--%>
					<label class="layui-form-label">应用简介</label>
					<div class="layui-input-block">
						<textarea name="appInfo" class="layui-textarea" placeholder="请输入应用简介"></textarea>
					</div>
					<%--应用状态(新应用都是待审核)--%>
<%--					 <label class="layui-form-label">APP状态</label>
					 <div class="layui-input-inline">
						 <select name="appStatus.valueId" lay-filter="aihao">
							 <option value="1">待审核</option>
						 </select>
					 </div>--%>
				</div>
				<div class="layui-form-item" style="padding-bottom: 15px">
					<div class="layui-input-block">
						<button class="layui-btn layui-btn-normal" lay-submit
						        lay-filter="formDemo" style="background-color: #007DDB">提交信息
						</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/jsp/common/footer.jsp"/>
</div>
<script src="${ctx}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['form', 'element', 'jquery'], function(){
        var element = layui.element;
        var form = layui.form;
        var $ = layui.jquery;

	    // layui是根据lay-filter进行选择的
	    // layu修改完后需要重新渲染render()
        /**
         * 监听一级分类下拉框，
         * 让二级分类下拉框的可选内容跟随一级下拉框的不同选择而改变,使用ajax
         **/
        form.on('select(levelOne)', function(){
            // alert(1231233);
            // alert($('#levelTwo').html());
            var level1Id = $('#levelOne').val();
			if(level1Id == ''){ // 未选择一级分类
                var html = '<option value="" selected>--请选择--</option>';
                $('#levelTwo').html(html);
                $('#levelThree').html(html);
                // 重新渲染
                form.render();
                return;
			}else{
                $.ajax({
                    url:'${ctx}/category/selectLevel2ByLevel1Id/'+level1Id,
                    method:'get',
                    success:function (data) {
                        // 根据data修改二级分类列表
                        var len = data.length;
                        var html = '<option value="" selected>--请选择--</option>';
                        for (var i = 0; i<len; i++) {
                            html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';
                        }
                        $('#levelTwo').html(html);
                        // 重新渲染
                        form.render();
                    }
                })
			}
        });

        /**
         * 监听二级分类下拉框，
         * 让三级分类下拉框的可选内容跟随二级下拉框的不同选择而改变,使用ajax
         **/
        form.on('select(levelTwo)', function(){
            // alert(1231233);
            // alert($('#levelTwo').html());
            var level2Id = $('#levelTwo').val();
            if(level2Id == ''){ // 未选择一级分类
                var html = '<option value="" selected>--请选择--</option>';
                $('#levelThree').html(html);
                // 重新渲染
                form.render();
                return;
            }else {
                $.ajax({
                    url:'${ctx}/category/selectLevel3ByLevel2Id/'+level2Id,
                    method:'get',
                    success:function (data) {
                        // 根据data修改二级分类列表
                        var len = data.length;
                        var html = '<option value="" selected>--请选择--</option>';
                        for (var i = 0; i<len; i++) {
                            html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';
                        }
                        $('#levelThree').html(html);
                        // 重新渲染
                        form.render();
                    }
                })
            }
        });
    });
</script>
</body>
</html>
