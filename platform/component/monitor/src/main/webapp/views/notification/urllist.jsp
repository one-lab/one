<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/tags/pipe" prefix="mvcpipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="appName" value="appName" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx}/static/portal.css" rel="stylesheet" type="text/css"
	media="all" />
<title>时效性及资源扫描配置</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script src="${ctx}/static/mvc-pipe/mvc-pipe.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#url-tab").addClass("active");
	});
</script>

<script type="text/javascript">
	var editFlag = '0';
	var addFlag = '0';
	var strEdit = "";
	var strAdd = "";
	var str = "";
	function queryByChange() {
		var appId = $("#appSelected option:selected").attr("id");
		if (appId == undefined) {
			appId = "";
		}
		var redirectUrl = "${ctx}/notification/urlConfigure/list?appId="+ appId;
		location.href = redirectUrl;

		//var urlPaht="${ctx}/notification/urlConfigure/test";
		/* alert($("#appSelected option:selected").attr("id"));
		$.ajax({
			type : "post",
			url : "${ctx}/notification/appConfigure/reflashList?appName="+$("#appSelected option:selected").attr("id"),
			dataType : "json",
			success : function(data) {
				var redirectUrl='${ctx}'+data.message;
				location.href = redirectUrl;
			},
			error : function(data) {
				alert(data+"暂时无法获取应用列别信息.");
			}
		});  */
	}
	function isEdit() {
		if ('1' == editFlag)
			strEdit = "正在进行时效性Url配置编辑.";
		else if ('2' == editFlag)
			strEdit = "正在进行时效性Method配置编辑.";
		else if ('3' == editFlag)
			strEdit = "正在进行资源扫描配置编辑.";
	}
	function isAdd() {
		function isEdit() {
			if ('1' == addFlag)
				strAdd = "正在添加进行时效性Url配置.";
			else if ('2' == addFlag)
				strAdd = "正在添加进行时效性Method配置.";
			else if ('3' == addFlag)
				strAdd = "正在添加进行资源扫配置.";
		}
	}
	function editUrl(id) {
		isEdit(editFlag);
		editFlag = '1';
		if (strEdit != str) {
			alert(strEdit);
			return;
		}
		var type = 'url';
		attrDisplay(id, type);
	}

	function editMethod(id) {
		isEdit(editFlag);
		editFlag = '2';
		if (strEdit != str) {
			alert(strEdit);
			return;
		}
		var type = 'method';
		attrDisplay(id, type);
	}
	function editResponse(id) {
		isEdit(editFlag);
		editFlag = '3';
		if (strEdit != str) {
			alert(strWarn);
			return;
		}
		var type = 'response';
		attrDisplay(id, type);
	}

	function attrDisplay(id, type) {
		var str = "." + id + "_" + type;
		$(str + "span").attr({
			style : "display:none;"
		});
		$(str + "input").attr({
			style : "display:'';width:55px"
		});
		$(str + "href").text("保存");
		$(str + "href").attr({
			href : "javascript:update" + type + "(" + id + ")"
		});
	}
	function updateurl(id) {
		$("#" + id + "_urlform").submit();
		editFlag = '0';
	}

	function updatemethod(id) {
		$("#" + id + "_methodform").submit();
		editFlag = '0';
	}
	function updateresponse(id) {
		$("#" + id + "_responseform").submit();
		editFlag = '0';
	}
	function addUrl() {
		if (isNoSelectApp()) {
			return;
		}
		$("#urltr").attr({
			style : "display:''"
		});
		$("#name").val("");
		$("#url").val("");
		$("#threshold").val("");
		$("#interval").val("");
		$("#environment").val("");
	}

	function addMethod() {
		if (isNoSelectApp()) {
			return;
		}
		$("#methodtr").attr({
			style : "display:''"
		});
		$("#className").val("");
		$("#methodName").val("");
		$("#threshold").val("");
		$("#interval").val("");
		$("#environment").val("");
	}
	function addResponse() {
		if (isNoSelectApp()) {
			return;
		}
		$("#responsetr").attr({
			style : "display:''"
		});
		$("#title").val("");
		$("#url").val("");
		$("#threshold").val("");
	}
	function saveResponse() {
		$("#responsetr").attr({
			style : "display:''"
		});
		$("#className").val("");
		$("#methodname").val("");
		$("#threshold").val("");
		$("#interval").val("");
		$("#environment").val("");
	}
	//保存url对象
	function saveUrl() {
		$("#urlform").submit();
	}
	//保存response对象
	function saveResponse() {
		$("#responseform").submit();
	}
	//保存method对象
	function saveMethod() {
		$("#methodform").submit();
	}

	//根据id删除对象，然后删除对应的页面tr
	function deleteById(index, type) {
		var id = $("." + index + "_" + type + "id").attr("value");
		var indexStr = index + 1;
		var urlPath = "${ctx}/notification/" + type + "Configure/delete/" + id;
		$.ajax({
					type : "post",
					url : urlPath,
					dataType : "json",
					success : function(data) {
						if (type == 'url')
							$("#contentTableUrl tr:eq(" + indexStr + ")")
									.remove();
						else if (type == 'method')
							$("#contentTableMethod tr:eq(" + indexStr + ")")
									.remove();
						else
							$("#contentTableResponse tr:eq(" + indexStr + ")")
									.remove();
						alert("删除成功");
					},
					error : function() {
						alert("暂时无法获取应用列别信息.");
					}
				});
	}

	function isNoSelectApp() {
		var obj = $("#selectApp").text();
		if ('' == obj || null == obj) {
			alert("请先选择应用!");
			$("#appSelected").focus();
			return true;
		}
	}
</script>
</head>
<body>
	<div class="container"></div>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12">
			<h2>时效性及资源扫描配置：</h2>
			<span>
				<div id="content" class="span12">
					<div id="urlconfigure">

						<select id="appSelected" onchange="queryByChange()">
							<option id="">请选择应用</option>
							<c:forEach items="${app}" var="appList">
								<option id="${appList.id}"
									${appList.id eq appOne.id ? "selected='selected'" : ''}>${appList.name
									}</option>
							</c:forEach>
						</select> 当前所选应用:<span id="selectApp">${appOne.name}</span>
					</div>
				</div>
			</span>


			<div class="window">
				<div class="title">时效性url配置</div>
				<div class="content">
					<table id="contentTableUrl"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>url名称</th>
								<th>url路径</th>
								<th>阀值(毫秒)</th>
								<th>频率(分)</th>
								<th>环境</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${url}" var="url" varStatus="var">
								<tr class="${var.index+1}_urltr">
									<form:form modelAttribute="url"
										action="${ctx}/notification/urlConfigure/save" method="post"
										enctype="multipart/form-data" class="form-horizontal"
										id="${var.index}_urlform">
										<fieldset>
											<input name="id" class="${var.index}_urlid" value="${url.id}"
												type="hidden"> <input name="appId"
												value="${url.appId}" type="hidden">
											<td><span class="${var.index}_urlspan">${url.name}</span>
												<input class="${var.index}_urlinput" id="name" name="name"
												value="${url.name}" type="text" style="display: none"
												 ></td>
											<td><span class="${var.index}_urlspan">${url.url}</span>
												<input class="${var.index}_urlinput" id="url" name="url"
												value="${url.url}" type="text" style="display: none"
												 ></td>
											<td><span class="${var.index}_urlspan">${url.threshold}</span>
												<input class="${var.index}_urlinput" id="threshold"
												name="threshold" value="${url.threshold}" type="text"
												style="display: none"  ></td>
											<td><span class="${var.index}_urlspan">${url.interval}</span>
												<input class="${var.index}_urlinput" id="interval"
												name="interval" value="${url.interval}" type="text"
												style="display: none"  ></td>
											<td><span class="${var.index}_urlspan">${url.environment}</span><input
												class="${var.index}_urlinput" id="environment"
												name="environment" value="${url.environment}" type="text"
												style="display: none" ></td>
											<td><a class="${var.index}_urlhref"
												href="javascript:editUrl(${var.index});">编辑</a> &nbsp; <a
												href="javascript:deleteById(${var.index },'url')">删除</a></td>
										</fieldset>
									</form:form>
								</tr>
							</c:forEach>
							<form:form modelAttribute="url"
								action="${ctx}/notification/urlConfigure/save" method="post"
								enctype="multipart/form-data" class="form-horizontal"
								id="urlform">
								<fieldset>
									<tr style="display: none" id="urltr">
										<input type="hidden" value="${appOne.id}" name="appId">
										<td><input name="name" type="text" style="width: 45px;"
											 ></td>
										<td><input name="url" type="text" style="width: 50px;"
											 ></td>
										<td><input name="threshold" type="text"
											style="width: 30px;"  ></td>
										<td><input name="interval" type="text"
											style="width: 30px;"  ></td>
										<td><input name="environment" type="text"
											style="width: 50px;"  ></td>
										<td><a href="javascript:saveUrl();">保存</a> &nbsp; <a
											href="javascript:cancel();">取消</a> &nbsp;</td>
									</tr>
								</fieldset>
							</form:form>
							<tr>
								<input type="button" value="新增url配置"
									onclick="javascript:addUrl();">
							</tr>
						</tbody>
					</table>
				</div>
				<div class="title">时效性method配置</div>
				<div class="content" id="methodconfigure">
					<table id="contentTableMethod"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>名称</th>
								<th>路径</th>
								<th>阀值(毫秒)</th>
								<th>频率(分)</th>
								<th>环境</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${method}" var="method" varStatus="var">
								<tr class="${var.index+1}_methodtr">
									<form:form modelAttribute="method"
										action="${ctx}/notification/methodConfigure/save"
										method="post" enctype="multipart/form-data"
										class="form-horizontal" id="${var.index}_methodform">
										<fieldset>
											<input name="appId" value="${appOne.id}" type="hidden">
											<input name="id" class="${var.index}_methodid"
												value="${method.id}" type="hidden">
											<td><span class="${var.index}_methodspan">${method.className}</span>
												<input class="${var.index}_methodinput" name="className"
												value="${method.className}" type="text"
												style="display: none " ></td>
											<td><span class="${var.index}_methodspan">${method.methodName}</span><input
												class="${var.index}_methodinput" name="methodName"
												value="${method.methodName}" type="text"
												style="display: none" ></td>
											<td><span class="${var.index}_methodspan">${method.threshold}</span><input
												class="${var.index}_methodinput" name="threshold"
												value="${method.threshold}" type="text"
												style="display: none"  ></td>
											<td><span class="${var.index}_methodspan">${method.interval}</span><input
												class="${var.index}_methodinput" name="interval"
												value="${method.interval}" type="text" style="display: none"
												 ></td>
											<td><span class="${var.index}_methodspan">${method.environment}</span><input
												class="${var.index}_methodinput" name="environment"
												value="${method.environment}" type="text"
												style="display: none"  ></td>
											<td><a class="${var.index}_methodhref"
												href="javascript:editMethod(${var.index});">编辑</a> &nbsp; <a
												href="javascript:deleteById(${var.index },'method')">删除</a></td>
										</fieldset>
									</form:form>
								</tr>
							</c:forEach>
							<form:form modelAttribute="method"
								action="${ctx}/notification/methodConfigure/save" method="post"
								enctype="multipart/form-data" class="form-horizontal"
								id="methodform">
								<fieldset>
									<tr style="display: none" id="methodtr">
										<input type="hidden" value="${appOne.id}" name="appId">
										<td><input name="className" type="text"
											style="width: 45px;"  ></td>
										<td><input name="methodName" type="text"
											style="width: 50px;" ></td>
										<td><input name="threshold" type="text"
											style="width: 30px;" ></td>
										<td><input name="interval" type="text"
											style="width: 30px;" ></td>
										<td><input name="environment" type="text"
											style="width: 50px;"></td>
										<td><a href="javascript:saveMethod();">保存</a> &nbsp; <a
											href="javascript:cancel();">取消</a> &nbsp;</td>
									</tr>
								</fieldset>
							</form:form>
							<tr>
								<input type="button" value="新增method配置" onclick="addMethod();">
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="window">
				<div class="title">资源扫描配置</div>
				<div class="content" id="responseConfigure">
					<table id="contentTableResponse"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>名称</th>
								<th>路径</th>
								<th>阀值</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${response}" var="response" varStatus="var">
								<tr class="${var.index+1}_responsetr">
									<form:form modelAttribute="response"
										action="${ctx}/notification/responseConfigure/save"
										method="post" enctype="multipart/form-data"
										class="form-horizontal" id="${var.index}_responseform">
										<fieldset>
											<input name="serialno" value="${response.serialno}"
												type="hidden"> <input type="hidden"
												value="${appOne.id}" name="appId">
											<td><input style="width: 40px" 
												readonly="readonly" class="${var.index}_responsespan"
												value="${response.title}"><input
												class="${var.index}_responseinput" name="title"
												value="${response.title}" type="text" style="display: none"
												></td>
											<td><input style="width: 200px" 
												readonly="readonly" class="${var.index}_responsespan"
												value="${response.url}"> <input
												class="${var.index}_responseinput" name="url"
												value="${response.url}" type="text" style="display: none"
												></td>
											<td><input style="width: 40px" 
												readonly="readonly" class="${var.index}_responsespan"
												value="${response.threshold}"> <input
												class="${var.index}_responseinput" name="threshold"
												value="${response.threshold}" type="text"
												style="display: none"></td>
											<td><a class="${var.index}_responsehref"
												href="javascript:editResponse(${var.index});">编辑</a> &nbsp;
												<a href="javascript:deleteById(${var.index },'response')">删除</a></td>
										</fieldset>
									</form:form>
								</tr>
							</c:forEach>
							<form:form modelAttribute="response"
								action="${ctx}/notification/responseConfigure/save"
								method="post" enctype="multipart/form-data"
								class="form-horizontal" id="responseform">
								<fieldset>
									<tr style="display: none" id="responsetr">
										<input type="hidden" value="${appOne.id}" name="appId">
										<td><input name="title" type="text" style="width: 40px;"
											></td>
										<td><input name="url" type="text" style="width: 200px;"
											></td>
										<td><input name="threshold" type="text"
											style="width: 40px;"></td>
										<td><a href="javascript:saveResponse();">保存</a> &nbsp; <a
											href="javascript:cancel();">取消</a> &nbsp;</td>
									</tr>
								</fieldset>
							</form:form>
							<tr>
								<input type="button" value="新增资源扫描配置" onclick="addResponse();">
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>
