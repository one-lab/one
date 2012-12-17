<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/global/ui/taglibs.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setHeader("Cache-Control", "No-Cache");//HTTP 1.1
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${ctx}/global/css/mis_basic.css" rel="stylesheet"
	type="text/css">
</HEAD>
<body>
<div id="toolbar_DIV">
<table id="toolbar_main" cellpadding="0" cellspacing="0">
	<tr>
		<td onclick="javascript:maximizeGrid(this);">&nbsp;</td>
		<td onclick="doEdit();" onmouseover="changeTD_style(this);"
			onmouseout="changeTD_style(this);">审核二</td>
		<td>&nbsp;</td>
		<td onclick="doDelete();" onmouseover="changeTD_style(this);"
			onmouseout="changeTD_style(this);">删除</td>
		<td>&nbsp;</td>
		
	</tr>
</table>
</div>

<input type="hidden" name="idStr" id="idStr">
<input type="hidden" name="count" id="count">
<input type="hidden" name="status" id="status">
</body>
<script language="javascript">
	//初始化toolbar样式
	var toolbarTable = document.getElementById("toolbar_main");
	var toolbarRow = toolbarTable.rows[0];
	toolbarRow.className = "toolbar_bg";
	var tds = toolbarRow.cells;
	for ( var i = 0; i < tds.length; i++) {
		if (i == 0) {
			tds[i].className = "toolbar_up";
			tds[i].title = "扩大数据表";
		} else if (i % 2 == 0) {
			tds[i].className = "toolbar_gap";
		} else {
			tds[i].className = "toolbar_normal";
		}
	}
	//改变toolbar样式
	function changeTD_style(obj) {
		if (obj.className == "toolbar_normal") {
			obj.className = "toolbar_hover";
		} else {
			obj.className = "toolbar_normal";
		}
	}
	//公用区域start
	var defaultRows = top.frames[1].frames[2].document.getElementById("fraTop").rows;
	var idStr = "";
	var count = 0;
	var printID = "";
	var emailID = "";
	var receiver = "";
	var flag = "";
	var status = "";
	function maximizeGrid(obj) {
		var className = obj.className;
		if (className == "toolbar_up") {//上移
			obj.className = "toolbar_down";
			top.frames[1].frames[2].document.getElementById("fraTop").rows = '0,30,*,40,0';
			obj.title = "还原数据表";
		} else {//下移
			obj.className = "toolbar_up";
			top.frames[1].frames[2].document.getElementById("fraTop").rows = defaultRows;
			obj.title = "扩大数据表";
		}
	}
	function doSearch() {
		var fraSearchForm = top.frames[1].frames[2].frames[0];
		//fraSearchForm.document.getElementById("frmInput").submit();
		fraSearchForm.doSearch();
	}
	function getId() {
		try {
			//top.frames[1].frames[2].frames[2].window.checkSingleRow();
			idStr = document.getElementById("idStr").value;
			count = document.getElementById("count").value;
			status = document.getElementById("status").value;
			return true;
		} catch (e) {
			alert("请选择要操作的记录！");
			return false;
		}
	}
	var top_ = (window.screen.availHeight - 750) / 2;
	if (top_ < 0) {
		top_ = 0;
	}
	var left_ = (window.screen.availWidth - 1020) / 2;
	if (left_ < 2) {
		left_ = 0;
	}
	var config = "width=1020,height=750,toolbar=no,statusbar=no";
	config += ",top=" + top_ + ",left=" + left_;
	//公用区域end

	//特殊处理，随功能不同而不同
	//编辑
	function doEdit() {
		var comboCode=top.frames[1].frames[2].frames[2].document.getElementById("comboToProcess").value;
		
		if (!getId()) {
			return;
		}
		if (count == 0) {
			alert("请选择要编辑的url信息！");
			return;
		}
		if (count > 1) {
			alert("只能对单条信息进行操作！");
			return;
		}
		//alert(idStr);
		window.open(
				"${ctx}/combo/prepareProcess2.do?combo.comboCode=" + comboCode, "套餐审核二",
				"top=100, left=100, width=900,height=600,toolbar=yes");
	}
	//删除
	function doDelete() {
		if (!getId()) {
			return;
		}
		if (count == 0) {
			alert("请选择要删除的url信息！");
			return;
		}
		if (confirm("确定删除您选中的" + count + "个信息吗？")) {
			//window.parent.frames[4].location.href = "
<%//=request.getContextPath()%>
	///misUserManager/delete.do?idStr=" + idStr;
			window.parent.frames[4].location.href = "${ctx}/monitor/responsedelete.do?serialNos="
					+ idStr;
		}
	}
	//增加
	function doAdd() {
		window.open(
				"${ctx}/monitor/responseprepareAdd.do", "添加url信息",
				"top=100, left=100, width=900,height=600,toolbar=yes");
	}

	//特殊处理end
</script>
</HTML>
