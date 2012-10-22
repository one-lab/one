<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/global/ui/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>电子商务管理系统</title>
<link type="text/css" rel="stylesheet" href="${ctx}/global/css/mis_basic.css">
<script language="javascript" src="${ctx}/global/js/leftPanel.js"></script>
</head>
<body topmargin="0" leftmargin="0">
<div id="leftPanel_main" style="padding-top:5px;">
	<div class="leftPanel" >
		<div class="leftPanel_title_down" onclick="javascript:arrow(this);">套餐</div>
		<div class="leftPanel_list">
			<ul>
				<li onclick="changeLi(this,'${ctx}/combo/operation/create/index.jsp')">创建套餐</li>
				<li onclick="changeLi(this,'${ctx}/combo/operation/verify1/index.jsp')">套餐审核1</li>
				<li onclick="changeLi(this,'${ctx}/combo/operation/verify2/index.jsp')">套餐审核2</li>
				<li onclick="changeLi(this,'${ctx}/combo/operation/deploy/index.jsp')">套餐发布</li>
				<li onclick="changeLi(this,'${ctx}/combo/operation/deploy2/index.jsp')">套餐发布确认</li>
			</ul>
		</div>
	</div>
	
</div>
</body>
</html>















