<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta charset="UTF-8">
	<title>App信息管理系统</title>
	<link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
	<style>
		body {
			zoom: 0.8;
		}
	</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<jsp:include page="/jsp/common/header.jsp"/>

	<div class="layui-body" style="background-color: #e6e6e6">
		<!-- 内容主体区域 -->
		<%--上半部分，分类查询--%>
		<div style="margin:0;background-color: white">
			<form class="layui-form" action="${ctx}/devApp/select" method="post" style="padding-top: 20px">
				<%--分页查询条件--%>
				<input type="hidden" name="pageNum" value="1">
				<input type="hidden" name="devId" value="${sessionScope.devUser.id}">
				<div class="layui-form-item">
					<label class="layui-form-label">软件名称</label>
					<div class="layui-input-inline">
						<input type="text" name="softwareName" lay-verify="title" autocomplete="off"
						       placeholder="请输入要查询的软件名称" value="${selectDTO.softwareName}"
						       class="layui-input">
					</div>
					<label class="layui-form-label">APP状态</label>
					<div class="layui-input-inline">
						<select name="appStatusId" lay-filter="aihao">
							<option value="" selected>--请选择--</option>
							<c:forEach items="${appStatus}" var="obj">
								<option value="${obj.valueId}" <c:if test="${obj.valueId eq selectDTO.appStatusId }">
									selected
								</c:if>>${obj.valueName}</option>
							</c:forEach>

						</select>
					</div>

					<label class="layui-form-label">所属平台</label>
					<div class="layui-input-inline">
						<select name="flatFormId" lay-filter="aihao">
							<option value="" selected>--请选择--</option>
							<c:forEach items="${flatForms}" var="obj">
								<option value="${obj.valueId}" <c:if test="${obj.valueId eq selectDTO.flatFormId}">
									selected
								</c:if>>${obj.valueName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">一级分类</label>
					<div class="layui-input-inline">
						<select name="level1Id" lay-filter="levelOne" id="levelOne">
							<option value="" selected>--请选择--</option>
							<c:forEach items="${level1Categories}" var="obj">
								<option value="${obj.id}" <c:if test="${obj.id eq selectDTO.level1Id}">
									selected
								</c:if>>${obj.categoryName}</option>
							</c:forEach>
						</select>
					</div>

					<label class="layui-form-label">二级分类</label>
					<div class="layui-input-inline">
						<select name="level2Id" lay-filter="levelTwo" id="levelTwo">
							<option value="" selected>--请选择--</option>
						</select>
					</div>

					<label class="layui-form-label">三级分类</label>
					<div class="layui-input-inline">
						<select name="level3Id" lay-filter="levelThree" id="levelThree">
							<option value="" selected>--请选择--</option>
						</select>
					</div>

				</div>
				<div class="layui-form-item" style="padding-bottom: 15px">
					<div class="layui-input-block">
						<button class="layui-btn layui-btn-normal" lay-submit
						        lay-filter="formDemo" style="background-color: #007DDB">查 询
						</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<%--下半部分，数据显示--%>
		<div style="background-color: white">
			<div class="layui-input-block" style="padding-top: 25px;margin-left: 15px">
				<a href="${ctx}/devApp/toAdd">
					<button class="layui-btn" lay-submit lay-filter="formDemo">新增APP产品信息</button>
				</a>
			</div>
			<table class="layui-table">
				<thead>
				<tr style="background-color: white">
					<th>软件名称</th>
					<th>APK名称</th>
					<th>软件大小(单位:M)</th>
					<th>所属平台</th>
					<th>所属分类(一级分类->二极管分类->三级分类)</th>
					<th>状态</th>
					<th>下载次数</th>
					<th>最新版本号</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list}" var="obj">
						<tr>
							<td>${obj.softwareName}</td>
							<td>${obj.apkName}</td>
							<td>${obj.softwareSize}</td>
							<td>${obj.flatForm.valueName}</td>
							<td>${obj.categoryLevel1.categoryName}->${obj.categoryLevel2.categoryName}->${obj.categoryLevel3.categoryName}</td>
							<td>${obj.appStatus.valueName}</td>
							<td>${obj.downloads}</td>
							<td>${obj.latestVersion.versionNo}</td>
							<td>
								<a href="${ctx}/devApp/detailInfo/${obj.id}"><i class="layui-icon layui-icon-more layui-bg-green"></i></a>
								<a href="${ctx}/devApp/toEdit/${obj.id}"><i class="layui-icon layui-icon-edit layui-bg-blue"></i></a>
								<a href="${ctx}/devApp/deleteApp/${obj.id}"><i class="layui-icon layui-icon-delete layui-bg-red"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%--页码导航--%>
		<div>
			<div style="position:absolute;left:15px; ">
				<p>
					共 ${pageInfo.total} 条数据，第 ${pageInfo.pageNum}/${pageInfo.pages} 页
				</p>
			</div>
			<div style="position:absolute;right: 15px; ">
				<p>
					<a page="first" href="javascript:void(0)">
						<button class="layui-btn layui-btn-normal layui-btn-radius"
						        style="height: 28px;line-height: 28px">首页
						</button>
					</a>
					<a page="prev" href="javascript:void(0)">
						<button class="layui-btn layui-btn-normal layui-btn-radius"
						        style="height: 28px;line-height: 28px">上一页
						</button>
					</a>
					<a page="next" href="javascript:void(0)">
						<button class="layui-btn layui-btn-normal layui-btn-radius"
						        style="height: 28px;line-height: 28px">下一页
						</button>
					</a>
					<a page="last" href="javascript:void(0)">
						<button class="layui-btn layui-btn-normal layui-btn-radius"
						        style="height: 28px;line-height: 28px">尾页
						</button>
					</a>
				</p>
			</div>
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

        /**
         * 分页标签a标签点击处理
	     **/
        $('a[page]').click(function () {
            var pageNum = 1;
            var v = $(this).attr("page"); // first?last?
            var currPage = '${pageInfo.pageNum}'; // 当前页
            var totalPages = '${pageInfo.pages}'; // 总页数
            switch (v) {
                case  "first":
                    if(currPage == 1) return;
                    pageNum = 1;
                    break;
                case  "prev":
                    pageNum = parseInt(currPage) - 1;
                    if (pageNum < 1) {
                        // pageNum = 1;
	                    return;
                    }
                    break;
                case  "next":
                    pageNum = parseInt(currPage) + 1;
                    if (pageNum > totalPages) {
                        // pageNum = totalPages;
	                    return;
                    }
                    break;
                case  "last":
                    if (currPage == totalPages) return;
                    pageNum = totalPages;
                    break;
            }
            //更新隐藏域的值
            $("input[name=pageNum]").val(pageNum);
            //提交表单
            $("form").submit();
        })

        /**
         * 查询返回后，回显上次的查询条件
         * @type {string}
         */
        // 页面加载时触发
	    $(function () {
            var level1Id = '${selectDTO.level1Id}';
            var level2Id = '${selectDTO.level2Id}';
            var level3Id = '${selectDTO.level3Id}';
            // 上次查询时有选过一级分类
            if(level1Id != null && level1Id != '' && level1Id != undefined){
                // 重新渲染二级分类下拉框内容
                $.ajax({
                    url:'${ctx}/category/selectLevel2ByLevel1Id/'+level1Id,
                    method:'get',
                    success:function (data) {
                        // 根据data修改二级分类列表
                        var len = data.length;
                        var html2 = '<option value="" selected>--请选择--</option>';
                        for (var i = 0; i<len; i++) {
                            html2 += '<option value="'+data[i].id+'" ';
                            // 如果上次查询时有选过二级分类，将选过的条目设置为选中，更新三级下拉框
                            if(data[i].id == level2Id){
                                // 将选过的条目设置为选中
                                html2 += 'selected';
                                // 更新三级下拉框
                                $.ajax({
                                    url:'${ctx}/category/selectLevel3ByLevel2Id/'+level2Id,
                                    method:'get',
                                    success:function (data) {
                                        // 根据data修改二级分类列表
                                        var len = data.length;
                                        var html3 = '<option value="" selected>--请选择--</option>';
                                        for (var i = 0; i<len; i++) {
                                            html3 += '<option value="'+data[i].id+'" ';
                                            // 如果上次查询时有选过二级分类，将选过的条目设置为选中，更新三级下拉框
                                            if(data[i].id == level3Id){
                                                // 将选过的条目设置为选中
                                                html3 += 'selected';
                                                // 更新三级下拉框
                                            }
                                            html3 += '>'+data[i].categoryName+'</option>';
                                        }
                                        $('#levelThree').html(html3);
                                        // 重新渲染
                                        form.render();
                                    }
                                });
                            }
                            html2 += '>'+data[i].categoryName+'</option>';
                        }
                        $('#levelTwo').html(html2);
                        // 重新渲染
                        form.render();
                    }
                });
            }
        })

    });
</script>
</body>
</html>
